package shop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tool.Queren;

public class ChangeCai extends JFrame implements ActionListener{
	JLabel jl1,jl2;
	JTextField tf1,tf2;
	JButton jb;
	String zhanghao;
	String caiNum;
	String caiName;
	String sellMoney;
	String xiaoliang;
	String pingfen;
	
	public ChangeCai(String zhanghao,String caiNum) throws IOException{
		super("修改菜");
		setLayout(new FlowLayout());
		this.zhanghao=zhanghao;
		this.caiNum=caiNum;
		
		jl1=new JLabel("菜名:");
		jl2=new JLabel("售价:");
		
		tf1=new JTextField(15);
		tf2=new JTextField(15);
		
		jb=new JButton("确认");
		jb.addActionListener(this);
		
		add(jl1);
		add(tf1);
		add(jl2);
		add(tf2);
		add(jb);
		setBounds(400,200,250,150);
		setVisible(true);
		
		BufferedReader br=new BufferedReader(new FileReader(".\\"+zhanghao+"\\"+caiNum+".txt"));
		br.readLine();
		caiName=br.readLine();
		sellMoney=br.readLine();
		xiaoliang=br.readLine();
		pingfen=br.readLine();
		br.close();
		
		tf1.setText(caiName);
		tf2.setText(sellMoney);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb){
			caiName=tf1.getText();
			sellMoney=tf2.getText();
			
			try {

				//建立新菜品文件
				BufferedWriter bw3=new BufferedWriter(new FileWriter(".\\"+zhanghao+"\\"+caiNum+".txt"));
				bw3.write(caiNum);//ID
				bw3.newLine();
				bw3.write(caiName);//菜名
				bw3.newLine();
				bw3.write(sellMoney);//售价
				bw3.newLine();
				bw3.write(xiaoliang);//销量
				bw3.newLine();
				bw3.write(pingfen);//评分
				bw3.newLine();
				bw3.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			dispose();
			new Queren("菜品修改成功！");
			
		}
		
	}

}
