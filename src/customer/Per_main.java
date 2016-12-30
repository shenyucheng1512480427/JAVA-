package customer;

import customer.*;
import shop.ShopDingdan;
import signup.SignUp;
import tool.Queren;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Per_main extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu[] menu=new JMenu[8];
	JMenuItem[] item=new JMenuItem[16];
	String zhanghao;
	Diancan1 diancan1;
	Diancan2 diancan2;
	public Per_main(String zhanghao) throws IOException{
		super("吃货餐饮系统");
		bar=new JMenuBar();
		this.setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.zhanghao=zhanghao;
		String[] mename={"点餐","收藏","查看订单","充值","我的","退出","",""};
		String[] itname={
				"点餐",	//0
				"收藏的店铺","收藏的好菜",		//1
				"查看订单",			//2
				"充值",							//3
				"查看/修改个人信息","修改密码","收货地址",//4
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

		menu[1].add(item[++count]);
		menu[1].add(item[++count]);
		
		menu[2].add(item[++count]);
		
		menu[3].add(item[++count]);

		menu[4].add(item[++count]);
		menu[4].add(item[++count]);
		menu[4].add(item[++count]);

		menu[5].add(item[++count]);
		menu[5].add(item[++count]);
		
		diancan1 = new Diancan1();
		diancan1.setBounds(0,0,900,150);
		this.add(diancan1);
		diancan2 = new Diancan2(zhanghao);
		diancan2.setBounds(0,150,900,550);
		this.add(diancan2);
		
		setJMenuBar(bar);
		setBounds(300,50,900,700);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		int count=0;
		//0
		if(e.getSource()==item[count]){
			getContentPane().removeAll();
			diancan1 = new Diancan1();
			diancan1.setBounds(0,0,900,150);
			this.add(diancan1);
			try {
				diancan2 = new Diancan2(zhanghao);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			diancan2.setBounds(0,150,900,550);
			this.add(diancan2);
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
				PerDingdan pd = new PerDingdan(zhanghao);
				pd.setBounds(0,0,900,700);
				add(pd);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			this.repaint();
			this.validate();
		}
		//3
		if(e.getSource()==item[++count]){
			Chongzhi cz=new Chongzhi(zhanghao);
		}
		//4
		if(e.getSource()==item[++count]){
			try {
				Personal_detail per=new Personal_detail(zhanghao);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==item[++count]){new Queren("暂无该功能！");}
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
