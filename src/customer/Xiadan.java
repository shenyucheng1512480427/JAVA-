package customer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.management.StringValueExp;
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
import tool.Reader;
import tool.Shifou;
import tool.Write;
public class Xiadan extends JFrame{
	int tot;
	String zhanghao;
	String kehuID;
	Cai [] cai = new Cai [50];
	
	class Mianban extends JScrollPane{
		public Mianban(String zhanghao) throws IOException{
			this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			Cdan cdan=new Cdan(zhanghao);
			this.setViewportView(cdan);
		}
	}

	class Cdan extends JPanel{
		int caiNum;
		int num;
		int [] a = new int[100];
		String str2;
		public Cdan(String zhanghao) throws IOException{
			int num=(new CaiReader(zhanghao)).getCaiNum();
			caiNum=num;
			if(num<10) num=10;
			setLayout(new GridLayout(num+1,1));
			cai=new Cai[caiNum];
			for(int i=1;i<=caiNum;i++){
				FileReader fr2 = new FileReader(".\\"+zhanghao+"\\"+i+".txt");
				BufferedReader buf2 = new BufferedReader(fr2);
				buf2.readLine();
				buf2.readLine();
				str2 = buf2.readLine();
				a[i-1] = Integer.parseInt(str2);
				buf2.close();
				cai[i-1]=new Cai(i+"",zhanghao,i-1,a[i-1]);
				add(cai[i-1]);		
			}
		}
	}

	class Cai extends JPanel implements ActionListener{
		int a;
		int b;
		void seta(int a){this.a = a;}
		JLabel caiming = new JLabel();
		JLabel shoujia = new JLabel();
		JLabel xiaoliang = new JLabel();
		JLabel pingfen = new JLabel();
		JLabel tupian;
		//	JLabel shulianglabel =new JLabel("数量：") ;
		JButton [] add = new JButton[100];
		JButton [] delete = new JButton[100];
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		String str;
		int shu=0;
		int [] jiage = new int [100];
		JLabel shuliang;
		String caimingstr;
		public Cai(String caiId,String zhanghao,int n,int a) throws IOException{
//			for(int i = 0;i < n;i++){
//				jiage[i] = a[i];
//			}
			this.b = a;
			str = zhanghao;
			File dir=new File(".\\"+zhanghao);
			File[] files=dir.listFiles();
			seta(files.length);
			for(int i = 0;i < files.length;i++){
				add[i] = new JButton("+");
				delete[i] = new JButton("-");
				add[i].addActionListener(this);
				delete[i].addActionListener(this);
			}
			
			FileReader fr = new FileReader(".\\"+zhanghao+"\\"+caiId+".txt");
			BufferedReader buf = new BufferedReader(fr);
			this.setLayout(new BorderLayout());
//			
			
		//	System.out.println(buf.readLine());
			buf.readLine();
			
			caiming.setText(caimingstr=buf.readLine());
			caiming.setFont(new Font(" ",Font.BOLD,30));
		    caiming.setHorizontalAlignment(SwingConstants.CENTER);
		    
		    
			shoujia.setText("售价："+buf.readLine());
			xiaoliang.setText("月销量："+buf.readLine());
			pingfen.setText("评分："+buf.readLine());
			fr.close();

			
			
			xiaoliang.setFont(new Font(" ",Font.BOLD,20));
			shoujia.setFont(new Font(" ",Font.BOLD,20));
			pingfen.setFont(new Font(" ",Font.BOLD,20));
			this.setBorder(new BevelBorder(0));
			
			ImageIcon picture=new ImageIcon("0.jpg");
			tupian = new JLabel(picture);
			
			str = String.valueOf(shu);
			shuliang = new JLabel("数量："+str);
			shuliang.setFont(new Font(" ",Font.BOLD,20));
			
			jp.setLayout(new BorderLayout());
//			
			jp.add(add[n],BorderLayout.NORTH);
			jp.add(delete[n],BorderLayout.CENTER);
		//	jp.add(shulianglabel,BorderLayout.SOUTH);
			jp.add(shuliang,BorderLayout.SOUTH);
			jp2.add(shoujia);
			jp2.add(xiaoliang);
			jp2.add(pingfen);
				
				
			this.add(tupian,BorderLayout.WEST);
			this.add(jp,BorderLayout.EAST);
		//	jb.addActionListener(this);
			this.add(caiming,BorderLayout.CENTER);
			this.add(jp2,BorderLayout.SOUTH);
		}
		public void actionPerformed(ActionEvent e) {
			for(int i = 0;i < a;i++){
				if(e.getSource() == add[i]){
					shu++;
					shuliang.setText("数量："+shu);
					tot = tot + b;	
				}
				if(e.getSource() == delete[i]){
					shu--;
					if(shu < 0)
						shu = 0;
					else
						tot = tot - b;
					shuliang.setText("数量："+shu);
				}
			}	
		}
	}
	
	class Dingdan extends JPanel implements ActionListener{
		JButton jb = new JButton("提交订单");
		JLabel jb2;
		String str;
		public Dingdan(int tot){
			str=String.valueOf(tot);
			System.out.println(str);
		//	jb2= new JLabel("总价："+str);
			jb.addActionListener(this);
			this.add(jb,BorderLayout.CENTER);
		//	this.add(jb2,BorderLayout.WEST);
		}
		public void actionPerformed(ActionEvent e){
			Shifou shifou = new Shifou("总金额为："+tot+"  是否提交订单？");
			if(tot <= 0){
				new Queren("低于起送价,提交失败！");
			}
			else if(shifou.m1 == 0){
				try {
					Reader reader = new Reader(kehuID);
					int money=Integer.parseInt(reader.getMoney());
					if(money<tot){
						new Queren("余额不足，请及时充值");
					}
					else{
						money-=tot;
						reader.changeMoney(""+money);
						new Queren("提交成功！");
						File dir=new File(".\\"+kehuID+"\\dingdan");
						File[] files=dir.listFiles();
						try {
							new Write(zhanghao,tot,kehuID,files.length+1);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			else if(shifou.m1 == 1){
			}
		}
	}

	public Xiadan(String zhanghao,String str) throws IOException{

		this.zhanghao = zhanghao;
		this.kehuID = str;
		setResizable(false);
		setBounds(400,100,500,600);
	//	setLayout(new GridLayout(2,1));
		setLayout(null);
		Mianban mianban = new Mianban(zhanghao);
		mianban.setBounds(0,0,500,500);
		getContentPane().add(mianban);
		
		Dingdan dingdan = new Dingdan(tot);
		dingdan.setBounds(0,500,500,100);
		getContentPane().add(dingdan);
		System.out.println(cai[0].shu);
		setVisible(true);

	}
}
