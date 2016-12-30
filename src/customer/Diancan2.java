package customer;
import java.awt.*;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import java.io.*;

public class Diancan2 extends JScrollPane{
	String kehuID;
	public Diancan2(String kehuID) throws IOException{
		this.kehuID = kehuID;
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		Panel panel = new Panel();
		this.setViewportView(panel);	
	}

	class Panel extends JPanel {
    int n;
	public Panel() throws IOException{
		n = getTextLines("shangjia");
		int num=n;
		if(num<10)
			num=10;
		FileReader fr = new FileReader("shangjia.txt");
		BufferedReader buf = new BufferedReader(fr);
		Shoppanel [] sp = new Shoppanel[n];
		this.setLayout(new GridLayout(num+1,1));
		for(int i = 0;i < n;i++){		
		    sp[i] = new Shoppanel(buf.readLine(),i,n);
			this.add(sp[i]);
		}
		fr.close();
	}
	int getTextLines(String str) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(str+".txt"));
		int x = 0; 
		while(br.readLine() != null) {
		    x++; 
	    }
		br.close();
	    return x;
	}
}

class Shoppanel extends JPanel implements ActionListener{
	JLabel dianming = new JLabel();
	JLabel xiaoliang = new JLabel();
	JLabel tupian;
	JLabel pingfen = new JLabel();
	JLabel qisong = new JLabel();
	String str;
	JButton [] jb = new JButton[100];
	int a;
	JPanel jp = new JPanel();
	public Shoppanel(String str,int n,int n2) throws IOException{
		this.str=str;
		a=n2;
		for(int i = 0;i < n2;i++){
			jb[i] = new JButton("进入");	
			jb[i].addActionListener(this);
		}
		
		FileReader fr = new FileReader(str+".txt");
		BufferedReader buf = new BufferedReader(fr);
		
		this.setLayout(new BorderLayout());
		buf.readLine();
		dianming.setText(buf.readLine());
		dianming.setFont(new Font(" ",Font.BOLD,50));
	    dianming.setHorizontalAlignment(SwingConstants.CENTER);
	    buf.readLine();
	    buf.readLine();
	    buf.readLine();
		xiaoliang.setText("月销量："+buf.readLine());	
		xiaoliang.setFont(new Font(" ",Font.BOLD,20));
		pingfen.setText("         评分："+buf.readLine());
		pingfen.setFont(new Font(" ",Font.BOLD,20));
		qisong.setText("         0元起送");
		qisong.setFont(new Font(" ",Font.BOLD,20));
		jp.add(xiaoliang);
		jp.add(pingfen);
		jp.add(qisong);
		

		this.setBorder(new BevelBorder(0));
		ImageIcon picture=new ImageIcon("001.png");
		tupian = new JLabel(picture);
		this.add(tupian,BorderLayout.WEST);
		this.add(jb[n],BorderLayout.EAST);
		this.add(dianming,BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		fr.close();
	}
	public void actionPerformed(ActionEvent e){
		for(int i = 0;i < a ;i++){
			if(e.getSource() == jb[i]){
				try {
					Xiadan xiadan = new Xiadan(str,kehuID);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
		}
		
	}
}

}
