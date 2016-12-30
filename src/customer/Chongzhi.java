package customer;
import java.io.*;

import tool.Reader;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import tool.*;
import customer.Personal_detail;
import shop.Shop_detail;
public class Chongzhi extends JFrame{
	JButton jb;
	String account;
	String yue;
	JTextField jt;
	int money;
	int a;
	void setAccount(String account){this.account = account;}
//	boolean Bool = true;
//	public boolean getBool(){return Bool;}
	public Chongzhi(String account){
		//创建框架
		super("充值");
		setResizable(false);
		setLayout(null);
		setBounds(500,200,400,220);
		//创建标签
		JLabel jl = new JLabel("请输入要充值的金额：");
		jl.setBounds(130,0,200,100);
		getContentPane().add(jl);
		//创建文本框
		jt = new JTextField();
		jt.setBounds(100,70,190,50);
		jt.setEditable(true);
		getContentPane().add(jt);
		//添加确认按钮
		jb = new JButton("确认");
		jb.setBounds(140,130,100,40);
		getContentPane().add(jb);
		//确认键的监听器
		ButtonHandler bh = new ButtonHandler();
		jb.addActionListener(bh);
		//读取文本框中数字
		setAccount(account);
		this.a = a;
		setVisible(true);

	}
	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e2){
			if(e2.getSource() == jb ){
				Queren cg = new Queren("充值成功！");
				try {
					Reader read = new Reader(account);
					yue = jt.getText();
				    money = Integer.parseInt(yue);
					read.addMoney(money);
				//	if(a == 0){
				//		Personal_detail pd = new Personal_detail();
//	    			    pd.readTxt(account);
//					}
//					else{
//						Shop_detail sd = new Shop_detail();
//	    			    sd.readTxt(account);
//					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	Bool = false;
				dispose();
			}
		}
	}
    
}
