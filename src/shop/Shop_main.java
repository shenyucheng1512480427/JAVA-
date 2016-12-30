package shop;

import customer.*;
import signup.SignUp;
import tool.Queren;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Shop_main extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu[] menu=new JMenu[8];
	JMenuItem[] item=new JMenuItem[16];
	String zhanghao;
	Caidan caidan;
	public Shop_main(String zhanghao){
		super("吃货餐饮后台管理系统");
		//setLayout(null);
		bar=new JMenuBar();
		this.zhanghao=zhanghao;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		String[] mename={"菜单","评价","查看订单","充值/提现","我的","退出","",""};
		String[] itname={
				"添加新菜","查看/修改菜品信息",	//0
				"查看本店评价","查看菜品评价",		//1
				"查看订单",			//2
				"充值","提现",						//3
				"查看/修改个人信息","修改密码",//4
				"退出系统","重新登录",			//5
				"","","",""};
		//菜单
		//menu=new JMenu[8];
		for(int i=0;i<8;i++){
			menu[i]=new JMenu(mename[i]);
			bar.add(menu[i]);
		}
		
		//菜单项
		//item=new JMenuItem[16];
		for(int i=0;i<14;i++){
			item[i]=new JMenuItem(itname[i]);
			item[i].addActionListener(this);
		}
		int count=0;
		menu[0].add(item[count]);
		menu[0].add(item[++count]);

		menu[1].add(item[++count]);
		menu[1].add(item[++count]);
		
		menu[2].add(item[++count]);

		menu[3].add(item[++count]);
		menu[3].add(item[++count]);

		menu[4].add(item[++count]);
		menu[4].add(item[++count]);

		menu[5].add(item[++count]);
		menu[5].add(item[++count]);
		
		
		setJMenuBar(bar);
		setVisible(true);
		setBounds(300,50,900,700);
	}
	
	public void actionPerformed(ActionEvent e) {
		int count=0;
		//0
		if(e.getSource()==item[count]){
			new AddCai(zhanghao);
		}
		if(e.getSource()==item[++count]){
			getContentPane().removeAll();
			try {
				caidan=new Caidan(zhanghao);
				//caidan.setBounds(0,10,890,650);
				this.add(caidan);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.repaint();
			this.validate();
			
		}
		//1
		if(e.getSource()==item[++count]){new Queren("暂无该功能！");}
		if(e.getSource()==item[++count]){new Queren("暂无该功能！");}
		//2
		if(e.getSource()==item[++count]){
			getContentPane().removeAll();
			try {
				add(new ShopDingdan(zhanghao));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.repaint();
			this.validate();
		}
		//3
		if(e.getSource()==item[++count]){
			Chongzhi cz=new Chongzhi(zhanghao);
		}
		if(e.getSource()==item[++count]){new Queren("暂无该功能！");}
		//4
		if(e.getSource()==item[++count]){
			try {
				Shop_detail per=new Shop_detail(zhanghao);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==item[++count]){new Queren("暂无该功能！");}
		//5
		if(e.getSource()==item[++count]){
			System.exit(0);
		}
		if(e.getSource()==item[++count]){
			SignUp signup=new SignUp();
			dispose();
		}
		
	}

}
