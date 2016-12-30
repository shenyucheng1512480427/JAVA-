package shop;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import tool.Queren;
import tool.Reader;

public class ShopDingdan extends JScrollPane{
	public ShopDingdan(String shangjiaID) throws IOException{
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		SD sd=new SD(shangjiaID);
		this.setViewportView(sd);
	}

}
class SD extends JPanel{
	ADingdan[] dd;
	
	public SD(String shangjiaID) throws IOException{
		File dir=new File(".\\"+shangjiaID+"\\dingdan");
		File[] file=dir.listFiles();
		int dingdanNum=file.length;
		int num=dingdanNum;
		if(num<10) num=10;
		setLayout(new GridLayout(num,1));
		dd=new ADingdan[dingdanNum];
		for(int i=0;i<dingdanNum;i++){
			dd[i]=new ADingdan(shangjiaID,file[i].getName());
			add(dd[i]);
		}
	}
	

}
class ADingdan extends JPanel implements ActionListener{
	String shangjiaDingdanID;
	String shangjiaID;
	
	String kehuID;
	String kehuDingdanID;
	String sumMoney;
	String state;
	
	String kehuName;
	
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2;
	
	public ADingdan(String shangjiaID,String dingdanID) throws IOException{
		this.shangjiaID=shangjiaID;
		this.shangjiaDingdanID=dingdanID;
		BufferedReader br;
		//读取订单信息
		br=new BufferedReader(new FileReader(".\\"+shangjiaID+"\\dingdan\\"+dingdanID));
		kehuID=br.readLine();
		kehuDingdanID=br.readLine();
		sumMoney=br.readLine();
		state=br.readLine();
		br.close();
		//读取客户用户名
		br=new BufferedReader(new FileReader(kehuID+".txt"));
		br.readLine();
		kehuName=br.readLine();
		br.close();
		//编辑组件功能
		jl1=new JLabel("来自客户：  "+kehuName+" 的订单");
		jl2=new JLabel("总额："+sumMoney);
		jl3=new JLabel("状态："+state);
		jb1=new JButton("查看明细");
		jb2=new JButton("确定");
		//System.out.println(state);
		if(state.equals("等待商家接单"))
			jb2.setText("接单");
		else if(state.equals("正在配送"))
			jb2.setText("请等待");
		else if(state.equals("已完成"))
			jb2.setText("已完成");
		
		//为组件添加监听器
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		this.setBorder(new BevelBorder(0));
		
		setLayout(new GridLayout(3,2));
		add(jl1);
		add(new JLabel(""));
		add(jl2);
		add(jl3);
		add(jb1);
		add(jb2);
		
	}

	public void actionPerformed(ActionEvent e) {
		try {
			
		if(e.getSource()==jb1){
			new Queren("暂无此功能");
		}else if(e.getSource()==jb2){
			if(state.equals("等待商家接单")){
				//读取订单总额
				int sum;
				BufferedReader br=new BufferedReader(new FileReader(".\\"+shangjiaID+"\\dingdan\\"+shangjiaDingdanID));
				br.readLine();
				br.readLine();
				sum=Integer.parseInt(br.readLine());
				br.close();
				new Queren(sum+"元已入账");
				Reader re=new Reader(shangjiaID);
				re.addMoney(sum);
				state="正在配送";
				jb2.setText("请等待");
				jl3.setText("状态："+state);
				//修改店家文件夹下的订单文件
				BufferedWriter bw=new BufferedWriter(new FileWriter(".\\"+shangjiaID+"\\dingdan\\"+shangjiaDingdanID));
				bw.write(kehuID);
				bw.newLine();
				bw.write(kehuDingdanID);
				bw.newLine();
				bw.write(sumMoney);
				bw.newLine();
				bw.write(state);
				bw.newLine();
				bw.close();
				//修改客户文件夹下的订单文件
				BufferedWriter bw2=new BufferedWriter(new FileWriter(".\\"+kehuID+"\\dingdan\\"+kehuDingdanID));
				bw2.write(shangjiaID);
				bw2.newLine();
				bw2.write(kehuDingdanID);
				bw2.newLine();
				bw2.write(sumMoney);
				bw2.newLine();
				bw2.write(state);
				bw2.newLine();
				bw2.close();
				//修改店家月单量
				new Reader(shangjiaID).addYuedanliang();
				
				new Queren("接单成功！外卖配送中...");
			}
			else if(state.equals("正在配送")){
				new Queren("配送中，请等待！");
			}
			else if(state.equals("已完成")){
				new Queren("订单已完成！");
			}
		}
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}

