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
		super("�Ի�������̨����ϵͳ");
		//setLayout(null);
		bar=new JMenuBar();
		this.zhanghao=zhanghao;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		String[] mename={"�˵�","����","�鿴����","��ֵ/����","�ҵ�","�˳�","",""};
		String[] itname={
				"����²�","�鿴/�޸Ĳ�Ʒ��Ϣ",	//0
				"�鿴��������","�鿴��Ʒ����",		//1
				"�鿴����",			//2
				"��ֵ","����",						//3
				"�鿴/�޸ĸ�����Ϣ","�޸�����",//4
				"�˳�ϵͳ","���µ�¼",			//5
				"","","",""};
		//�˵�
		//menu=new JMenu[8];
		for(int i=0;i<8;i++){
			menu[i]=new JMenu(mename[i]);
			bar.add(menu[i]);
		}
		
		//�˵���
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
		if(e.getSource()==item[++count]){new Queren("���޸ù��ܣ�");}
		if(e.getSource()==item[++count]){new Queren("���޸ù��ܣ�");}
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
		if(e.getSource()==item[++count]){new Queren("���޸ù��ܣ�");}
		//4
		if(e.getSource()==item[++count]){
			try {
				Shop_detail per=new Shop_detail(zhanghao);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==item[++count]){new Queren("���޸ù��ܣ�");}
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
