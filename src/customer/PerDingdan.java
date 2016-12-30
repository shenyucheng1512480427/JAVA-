package customer;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import tool.Queren;
import tool.Reader;

public class PerDingdan extends JScrollPane{
	public PerDingdan(String kehuID) throws IOException{
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		SD sd=new SD(kehuID);
		this.setViewportView(sd);
	}

}
class SD extends JPanel{
	ADingdan[] dd;
	
	public SD(String kehuID) throws IOException{
		File dir=new File(".\\"+kehuID+"\\dingdan");
		File[] file=dir.listFiles();
		int dingdanNum=file.length;
		int num=dingdanNum;
		if(num<10) num=10;
		setLayout(new GridLayout(num,1));
		dd=new ADingdan[dingdanNum];
		for(int i=0;i<dingdanNum;i++){
			dd[i]=new ADingdan(kehuID,file[i].getName());
			add(dd[i]);
		}
	}
	

}
class ADingdan extends JPanel implements ActionListener{
	String kehuDingdanID;
	String kehuID;
	
	String shangjiaID;
	String shangjiaDingdanID;
	String sumMoney;
	String state;
	
	String shangjiaName;
	
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2;
	
	public ADingdan(String kehuID,String dingdanID) throws IOException{
		this.kehuID=kehuID;
		this.kehuDingdanID=dingdanID;
		BufferedReader br;
		//读取订单信息
		br=new BufferedReader(new FileReader(".\\"+kehuID+"\\dingdan\\"+dingdanID));
		shangjiaID=br.readLine();
		shangjiaDingdanID=br.readLine();
		sumMoney=br.readLine();
		state=br.readLine();
		br.close();
		//读取客户用户名
		br=new BufferedReader(new FileReader(kehuID+".txt"));
		br.readLine();
		shangjiaName=br.readLine();
		br.close();
		//编辑组件功能
		jl1=new JLabel("在店家： "+shangjiaName+" 的订单");
		jl2=new JLabel("总额："+sumMoney);
		jl3=new JLabel("状态："+state);
		jb1=new JButton("查看明细");
		jb2=new JButton("确定");
		//System.out.println(state);
		if(state.equals("等待商家接单"))
			jb2.setText("请等待");
		else if(state.equals("正在配送"))
			jb2.setText("确认送达");
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
				new Queren("等待商家接单，请稍候！");
			}
			else if(state.equals("正在配送")){
				state="已完成";
				jb2.setText("已完成");
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
				
				new Queren("订单已完成，快去评价吧！");
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

