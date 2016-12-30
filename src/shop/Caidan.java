package shop;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import tool.CaiReader;
import tool.Queren;

public class Caidan extends JScrollPane{
	public Caidan(String zhanghao) throws IOException{
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		Cdan cdan=new Cdan(zhanghao);
		this.setViewportView(cdan);
	}
}
class Cdan extends JPanel implements ActionListener{
	Cai[] cai;
	int caiNum;
	String zhanghao;
	public Cdan(String zhanghao) throws IOException{
		this.zhanghao=zhanghao;
		int num=(new CaiReader(zhanghao)).getCaiNum();
		caiNum=num;
		if(num<10) num=10;
		setLayout(new GridLayout(num,1));
		cai=new Cai[caiNum];
		for(int i=1;i<=caiNum;i++){
			cai[i-1]=new Cai(i+"");
			add(cai[i-1]);
		}
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	class Cai extends JPanel implements ActionListener{
		JLabel caiming = new JLabel();
		JLabel xiaoliang = new JLabel();
		JLabel tupian;
		JButton jb = new JButton("修改");
		String caiNum;
		
		public Cai(String caiId) throws IOException{
			caiNum=caiId;
			FileReader fr = new FileReader(".\\"+zhanghao+"\\"+caiId+".txt");
			BufferedReader buf = new BufferedReader(fr);
			this.setLayout(new BorderLayout());
			
			buf.readLine();
			
			caiming.setText(buf.readLine());
			caiming.setFont(new Font(" ",Font.BOLD,50));
		    caiming.setHorizontalAlignment(SwingConstants.CENTER);
		    
			xiaoliang.setText("售价："+buf.readLine()+
					"                                               月销量："+buf.readLine()+
					"                                               评分："+buf.readLine());
			xiaoliang.setFont(new Font(" ",Font.BOLD,20));
			this.setBorder(new BevelBorder(0));
			
			ImageIcon picture=new ImageIcon("0.jpg");
			tupian = new JLabel(picture);
			
			this.add(tupian,BorderLayout.WEST);
			this.add(jb,BorderLayout.EAST);
			jb.addActionListener(this);
			this.add(caiming,BorderLayout.CENTER);
			this.add(xiaoliang,BorderLayout.SOUTH);
		}
		public void actionPerformed(ActionEvent e) {
			try {
				new ChangeCai(zhanghao,caiNum);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}	
	}
}
