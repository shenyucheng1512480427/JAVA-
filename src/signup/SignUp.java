package signup;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import customer.*;
import shop.*;

public class SignUp {

	boolean isKehu = true;
	String name;
	String mima;
	String zhanghao;
	boolean isdenglu = false;
	
	public SignUp() {
		Iam i=new Iam();
	}
	
	public boolean getiskehu(){return isKehu;}
	public String getname(){return name;}
	public String getmima(){return mima;}
	public String getzhanghao(){return zhanghao;}
	public boolean getisdenglu(){return isdenglu;}

	void dengluContinue() throws IOException{
		if(isKehu==true){
			Per_main pemain=new Per_main(zhanghao);
		}else{
			Shop_main shopmain=new Shop_main(zhanghao);
		}
	}
	
	class Denglu extends JFrame{

		GridLayout gl1,gl2;
		JPanel jp1,jp2;
		JLabel jl1,jl2,jl3;
		JTextField account;
		JPasswordField code;
		JButton denglu;
		JButton zhuce;
		
//		String zhanghao;
//		String name;
//		String mima;
//		boolean isKehu;
		
		public Denglu(){
			super("�Ի�����ע��ϵͳ");
			setLayout(null);
			setResizable(false);//��ֹ������ܴ�С
			
//			zhanghao=info.getzhanghao();
//			name=info.getname();
//			mima=info.getmima();
//			isKehu=info.getiskehu();
			
			jl1=new JLabel("�������˺�:");
			jl2=new JLabel("���������룺");
			jl3=new JLabel("û���˺ţ�");
			jl3.setHorizontalAlignment(SwingConstants.RIGHT);
			//�˺�
			account = new JTextField();
			//����
			code = new JPasswordField();
			
			//��¼
			denglu=new JButton("��¼");
			denglu.addActionListener(new Bt());
			zhuce=new JButton("����ע��");
			zhuce.addActionListener(new Bt());
			
			jp1=new JPanel();	//���1
			jp1.add(jl1);		//����˺ű�ǩ
			jp1.add(account);	//����˺ſ�
			jp1.add(jl2);		//��������ǩ
			jp1.add(code);		//��������
			gl1=new GridLayout(4,1);//���1�Ĳ��ֹ���
			jp1.setLayout(gl1);		//�����ֹ���1��ӵ����1
			jp1.setBounds(85,10,150,120);//�������1������
			getContentPane().add(jp1);//�����1��ӵ�����
			
			jp2=new JPanel();
			jp2.setBounds(0, 150, 200, 80);
			getContentPane().add(jp2);
			gl2=new GridLayout(2,2,10,10);
			jp2.setLayout(gl2);
			jp2.add(new JLabel(" "));
			jp2.add(denglu);
			jp2.add(jl3);
			jp2.add(zhuce);

			setBackground(Color.red);
			setBounds(400, 200, 320, 280);
			setVisible(true);
			
		}

		class Bt implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==zhuce){
					Zhuce zhuce=new Zhuce();
					dispose();
				}
				else if(e.getSource()==denglu){
					String ac,mi;
					String str;
					boolean iskehu;
					boolean flag=false;
					ac=account.getText();
					try {
						FileReader fr=new FileReader("SignUp.txt");
						BufferedReader br=new BufferedReader(fr);
						while((str=br.readLine())!=null){
							if(ac.equals(str))
								flag=true;
						}
						//�����˺�
						if(ac.equals("")){
							jl1.setForeground(Color.red);
							jl1.setText("�˺Ų���Ϊ�գ�");
						}
						else if(flag==false){
							jl1.setForeground(Color.red);
							jl1.setText("û�и��˺ţ�");
						}else{
							FileReader fr3=new FileReader(ac+".txt");
							BufferedReader br3=new BufferedReader(fr3);
							for(int i=0;i<3;i++)
								br3.readLine();
							iskehu=Boolean.parseBoolean(br3.readLine());
							br3.close();
							if(isKehu!=iskehu){
								jl1.setForeground(Color.red);
								jl1.setText("�˺����ʹ���");
							}
							else{
								jl1.setForeground(Color.black);
								jl1.setText("�˺���ȷ��");
								//��������
								FileReader fr2=new FileReader(ac+".txt");
								BufferedReader br2=new BufferedReader(fr2);
								br2.readLine();
								name=br2.readLine();
								mi=br2.readLine();
								str=String.valueOf(code.getPassword());	
								br2.close();
								if(!mi.equals(str)){
									jl2.setForeground(Color.red);
									jl2.setText("�������");
								}else{
									jl2.setForeground(Color.black);
									jl2.setText("������ȷ��");
									zhanghao=ac;
									mima=mi;
									dengluContinue();
									dispose();
								}
								
								
							}
						}
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		}
	}
	
	class Zhuce extends JFrame{
		GridLayout gl1,gl2;
		JPanel jp1,jp2;
		JLabel jl1,jl2,jl3,jl4;
		JTextField account;
		JPasswordField code;
		JPasswordField codeSure;
		JButton denglu;
		JButton zhuce;
		public Zhuce(){
			super("��ӭʹ�óԻ�����ϵͳ�����¼");
			setLayout(null);
			setResizable(false);//��ֹ������ܴ�С

			jl1=new JLabel("�������û���:");
			jl1.setBackground(Color.red);
			jl2=new JLabel("���������룺");
			jl2.setBackground(Color.red);
			jl3=new JLabel("�����˺ţ�");
			jl3.setHorizontalAlignment(SwingConstants.RIGHT);
			jl4=new JLabel("�ٴ��������룺");
			
			//�û������˺�
			account = new JTextField();
			//����
			code = new JPasswordField();
			//ȷ������
			codeSure = new JPasswordField();
			
			
			//��¼
			zhuce=new JButton("ע��");
			zhuce.addActionListener(new Bt());
			denglu=new JButton("������¼");
			denglu.addActionListener(new Bt());
			
			jp1=new JPanel();	//���1
			jp1.add(jl1);		//����˺ű�ǩ
			jp1.add(account);	//����˺ſ�
			jp1.add(jl2);		//��������ǩ
			jp1.add(code);		//��������
			jp1.add(jl4);
			jp1.add(codeSure);
			gl1=new GridLayout(6,1);//���1�Ĳ��ֹ���
			jp1.setLayout(gl1);		//�����ֹ���1��ӵ����1
			jp1.setBounds(85,10,150,120);//�������1������
			getContentPane().add(jp1);//�����1��ӵ�����
			
			jp2=new JPanel();
			jp2.setBounds(0, 150, 200, 80);
			getContentPane().add(jp2);
			gl2=new GridLayout(2,2,10,10);
			jp2.setLayout(gl2);
			jp2.add(new JLabel(" "));
			jp2.add(zhuce);
			jp2.add(jl3);
			jp2.add(denglu);

			setBackground(Color.red);
			setBounds(400, 200, 320, 280);
			setVisible(true);
		}
		class Bt implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==denglu){
					Denglu denglu=new Denglu();
					dispose();
				}
				else if(e.getSource()==zhuce){
					String ac;//�û���
					String co;//����
					String cos;//ȷ������
					String regex="\\p{Alnum}{6,20}";
					try {
						//�������˺�
						FileReader fr=new FileReader("SignUp.txt");
						BufferedReader br=new BufferedReader(fr);
						String str;
						int num=2016001;
						while(br.readLine()!=null)num++;
						str=String.valueOf(num);
						br.close();
						//��ȡ�������Ϣ
						ac=account.getText();
						co=String.valueOf(code.getPassword());
						cos=String.valueOf(codeSure.getPassword());
						//�����û���
						if(ac.equals("")){
							jl1.setForeground(Color.red);
							jl1.setText("�û�������Ϊ�գ�");
						}else{
							jl1.setForeground(Color.black);
							jl1.setText("�û�����ȷ��");
							//��������
							if(co.equals("")){
								jl2.setForeground(Color.red);
								jl2.setText("���벻��Ϊ�գ�");
							}
							else if(!co.matches(regex)){
								jl2.setForeground(Color.red);
								jl2.setText("����6-20λ��ĸ�����֣�");
							}
							else{
								jl2.setForeground(Color.black);
								jl2.setText("������ȷ!");
								//����ȷ������
								if(!cos.equals(co)){
									jl4.setForeground(Color.red);
									jl4.setText("������������벻ͬ��");
								}else{
									jl4.setForeground(Color.black);
									jl4.setText("ȷ��������ȷ!");
									zhanghao=str;
									name=ac;
									mima=co;
									//�����˺�д��SignUp.txt�ļ���
									FileWriter fw=new FileWriter("SignUp.txt",true);
									BufferedWriter bw=new BufferedWriter(fw);
									bw.write(str);
									bw.newLine();
									bw.close();
									//Ϊ���˺Ž��������ļ���
									File newDir=new File(".\\"+zhanghao+"\\dingdan");
									newDir.mkdirs();
									new BufferedWriter(new FileWriter(".\\"+zhanghao+"\\SignUp.txt",true)).close();
									//Ϊ���˺Ž���������Ϣ�ļ�
									FileWriter fw1=new FileWriter(str+".txt");
									BufferedWriter bw1=new BufferedWriter(fw1);
									bw1.write(zhanghao);
									bw1.newLine();
									bw1.write(name);
									bw1.newLine();
									bw1.write(mima);
									bw1.newLine();
									bw1.write(isKehu+"");
									bw1.newLine();
									bw1.write("0");
									bw1.newLine();
									if(isKehu==false){
										bw1.write("0");//�µ���
										bw1.newLine();
										bw1.write("5");//����
										bw1.newLine();
										bw1.write("8:00--20:00");//Ӫҵʱ��
										bw1.newLine();
									}
									else{
										bw1.write("δ֪");//�Ա�
										bw1.newLine();
										bw1.write("����");//����
										bw1.newLine();
										bw1.write("δ��д����");//��ַ
										bw1.newLine();
										bw1.write("0");//����
										bw1.newLine();
										bw1.write("���û�������ʲô��û����");//���˽���
										bw1.newLine();
									}
									bw1.close();
									dispose();
									Sure sure=new Sure(zhanghao);
									
								}
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
	
	class Sure extends JFrame{
		public Sure(String ac) throws IOException{
			super("ע��ɹ���");
			setResizable(false);
			setLayout(null);
			JLabel jl1=new JLabel("ע��ɹ�!���ס�����˺ţ�");
			jl1.setBounds(70,20,280,30);
			JLabel jl2=new JLabel(ac);
			jl2.setBounds(120,50,100,30);
			JButton jb=new JButton("ȷ��");
			jb.setBounds(100,80,100,30);
			jb.addActionListener(new Bt());
			
			getContentPane().add(jl1);
			getContentPane().add(jl2);
			getContentPane().add(jb);
			setBounds(400,200,300,180);
			setVisible(true);
			
			BufferedWriter bw;
			bw=new BufferedWriter(new FileWriter("shangjia.txt",true));
			bw.close();
			bw=new BufferedWriter(new FileWriter("kehu.txt",true));
			bw.close();
			bw=new BufferedWriter(new FileWriter(".\\"+zhanghao+"\\SignUp.txt",true));
			bw.close();
			if(isKehu==true){
				bw=new BufferedWriter(new FileWriter("kehu.txt",true));
			}else{
				bw=new BufferedWriter(new FileWriter("shangjia.txt",true));
			}
			bw.write(zhanghao);
			bw.newLine();
			bw.close();
		}
		class Bt implements ActionListener{
			public void actionPerformed(ActionEvent e){
				try {
					dengluContinue();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		}
		
	}

	class Iam extends JFrame{
		JPanel jp;//���
		GridLayout gridlayout;
		JButton kehu,shangjia;
		
		public Iam(){
			super("�û�����ѡ�񴰿�");
			setLayout(null);
			setResizable(false);
			gridlayout=new GridLayout(2,1,0,20);//���񲼾ֹ�����
		
			//ע����һ�Σ���ֹû��ע����������
			try {
				new BufferedWriter(new FileWriter("SignUp.txt",true)).close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			kehu=new JButton("���ǿͻ�");
			shangjia=new JButton("�����̼�");
			kehu.addActionListener(new Bt());
			shangjia.addActionListener(new Bt());
			
			jp=new JPanel();
			jp.add(kehu);
			jp.add(shangjia);
			jp.setBounds(20, 20, 280, 220);
			getContentPane().add(jp);
			jp.setLayout(gridlayout);
			setBackground(Color.red);
			setBounds(400, 200, 320, 280);
			setVisible(true);
			
			
		}
		class Bt implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==kehu){
					isKehu=true;
					Denglu denglu = new Denglu();
					dispose();
				}
				else if(e.getSource()==shangjia){
					isKehu=false;
					Denglu denglu = new Denglu();
					dispose();
				}
			}
		}
	}

}