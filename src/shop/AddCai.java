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

public class AddCai extends JFrame implements ActionListener{
	JLabel jl1,jl2;
	JTextField tf1,tf2;
	JButton jb;
	String zhanghao;
	String caiName;
	String sellMoney;
	public AddCai(String zhanghao){
		super("添加新菜");
		setLayout(new FlowLayout());
		this.zhanghao=zhanghao;
		
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
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb){
			caiName=tf1.getText();
			sellMoney=tf2.getText();
			
			
			try {
				//得到菜的数量
				int caiNum=0;
				BufferedReader br=new BufferedReader(new FileReader(".\\"+zhanghao+"\\SignUp.txt"));
				while(br.readLine()!=null)caiNum++;
				br.close();
				
				//新增一个菜
				caiNum++;
				
				//将菜品添加进菜品注册表
				BufferedWriter bw=new BufferedWriter(new FileWriter(".\\"+zhanghao+"\\SignUp.txt",true));
				bw.write(caiNum+"");
				bw.newLine();
				bw.close();

				//建立新菜品文件
				BufferedWriter bw3=new BufferedWriter(
						new FileWriter(".\\"+zhanghao+"\\"+caiNum+".txt"));
				bw3.write(caiNum+"");//ID
				bw3.newLine();
				bw3.write(caiName);//菜名
				bw3.newLine();
				bw3.write(sellMoney);//售价
				bw3.newLine();
				bw3.write(0+"");//销量
				bw3.newLine();
				bw3.write(0+"");//评分
				bw3.newLine();
				bw3.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dispose();
			new Queren("新加了一个菜！");
			
		}
		
	}

}
