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
		//�������
		super("��ֵ");
		setResizable(false);
		setLayout(null);
		setBounds(500,200,400,220);
		//������ǩ
		JLabel jl = new JLabel("������Ҫ��ֵ�Ľ�");
		jl.setBounds(130,0,200,100);
		getContentPane().add(jl);
		//�����ı���
		jt = new JTextField();
		jt.setBounds(100,70,190,50);
		jt.setEditable(true);
		getContentPane().add(jt);
		//���ȷ�ϰ�ť
		jb = new JButton("ȷ��");
		jb.setBounds(140,130,100,40);
		getContentPane().add(jb);
		//ȷ�ϼ��ļ�����
		ButtonHandler bh = new ButtonHandler();
		jb.addActionListener(bh);
		//��ȡ�ı���������
		setAccount(account);
		this.a = a;
		setVisible(true);

	}
	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e2){
			if(e2.getSource() == jb ){
				Queren cg = new Queren("��ֵ�ɹ���");
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
