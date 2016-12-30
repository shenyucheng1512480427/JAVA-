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
			super("吃货餐饮注册系统");
			setLayout(null);
			setResizable(false);//禁止调整框架大小
			
//			zhanghao=info.getzhanghao();
//			name=info.getname();
//			mima=info.getmima();
//			isKehu=info.getiskehu();
			
			jl1=new JLabel("请输入账号:");
			jl2=new JLabel("请输入密码：");
			jl3=new JLabel("没有账号？");
			jl3.setHorizontalAlignment(SwingConstants.RIGHT);
			//账号
			account = new JTextField();
			//密码
			code = new JPasswordField();
			
			//登录
			denglu=new JButton("登录");
			denglu.addActionListener(new Bt());
			zhuce=new JButton("立即注册");
			zhuce.addActionListener(new Bt());
			
			jp1=new JPanel();	//面板1
			jp1.add(jl1);		//添加账号标签
			jp1.add(account);	//添加账号框
			jp1.add(jl2);		//添加密码标签
			jp1.add(code);		//添加密码框
			gl1=new GridLayout(4,1);//面板1的布局管理
			jp1.setLayout(gl1);		//将布局管理1添加到面板1
			jp1.setBounds(85,10,150,120);//设置面板1的坐标
			getContentPane().add(jp1);//将面板1添加到窗体
			
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
						//检验账号
						if(ac.equals("")){
							jl1.setForeground(Color.red);
							jl1.setText("账号不能为空！");
						}
						else if(flag==false){
							jl1.setForeground(Color.red);
							jl1.setText("没有该账号！");
						}else{
							FileReader fr3=new FileReader(ac+".txt");
							BufferedReader br3=new BufferedReader(fr3);
							for(int i=0;i<3;i++)
								br3.readLine();
							iskehu=Boolean.parseBoolean(br3.readLine());
							br3.close();
							if(isKehu!=iskehu){
								jl1.setForeground(Color.red);
								jl1.setText("账号类型错误！");
							}
							else{
								jl1.setForeground(Color.black);
								jl1.setText("账号正确！");
								//检验密码
								FileReader fr2=new FileReader(ac+".txt");
								BufferedReader br2=new BufferedReader(fr2);
								br2.readLine();
								name=br2.readLine();
								mi=br2.readLine();
								str=String.valueOf(code.getPassword());	
								br2.close();
								if(!mi.equals(str)){
									jl2.setForeground(Color.red);
									jl2.setText("密码错误！");
								}else{
									jl2.setForeground(Color.black);
									jl2.setText("密码正确！");
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
			super("欢迎使用吃货餐饮系统！请登录");
			setLayout(null);
			setResizable(false);//禁止调整框架大小

			jl1=new JLabel("请输入用户名:");
			jl1.setBackground(Color.red);
			jl2=new JLabel("请输入密码：");
			jl2.setBackground(Color.red);
			jl3=new JLabel("已有账号？");
			jl3.setHorizontalAlignment(SwingConstants.RIGHT);
			jl4=new JLabel("再次输入密码：");
			
			//用户名或账号
			account = new JTextField();
			//密码
			code = new JPasswordField();
			//确认密码
			codeSure = new JPasswordField();
			
			
			//登录
			zhuce=new JButton("注册");
			zhuce.addActionListener(new Bt());
			denglu=new JButton("立即登录");
			denglu.addActionListener(new Bt());
			
			jp1=new JPanel();	//面板1
			jp1.add(jl1);		//添加账号标签
			jp1.add(account);	//添加账号框
			jp1.add(jl2);		//添加密码标签
			jp1.add(code);		//添加密码框
			jp1.add(jl4);
			jp1.add(codeSure);
			gl1=new GridLayout(6,1);//面板1的布局管理
			jp1.setLayout(gl1);		//将布局管理1添加到面板1
			jp1.setBounds(85,10,150,120);//设置面板1的坐标
			getContentPane().add(jp1);//将面板1添加到窗体
			
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
					String ac;//用户名
					String co;//密码
					String cos;//确认密码
					String regex="\\p{Alnum}{6,20}";
					try {
						//产生新账号
						FileReader fr=new FileReader("SignUp.txt");
						BufferedReader br=new BufferedReader(fr);
						String str;
						int num=2016001;
						while(br.readLine()!=null)num++;
						str=String.valueOf(num);
						br.close();
						//读取输入的信息
						ac=account.getText();
						co=String.valueOf(code.getPassword());
						cos=String.valueOf(codeSure.getPassword());
						//检验用户名
						if(ac.equals("")){
							jl1.setForeground(Color.red);
							jl1.setText("用户名不能为空！");
						}else{
							jl1.setForeground(Color.black);
							jl1.setText("用户名正确！");
							//检验密码
							if(co.equals("")){
								jl2.setForeground(Color.red);
								jl2.setText("密码不能为空！");
							}
							else if(!co.matches(regex)){
								jl2.setForeground(Color.red);
								jl2.setText("输入6-20位字母或数字：");
							}
							else{
								jl2.setForeground(Color.black);
								jl2.setText("密码正确!");
								//检验确认密码
								if(!cos.equals(co)){
									jl4.setForeground(Color.red);
									jl4.setText("两次输入的密码不同！");
								}else{
									jl4.setForeground(Color.black);
									jl4.setText("确认密码正确!");
									zhanghao=str;
									name=ac;
									mima=co;
									//将新账号写到SignUp.txt文件中
									FileWriter fw=new FileWriter("SignUp.txt",true);
									BufferedWriter bw=new BufferedWriter(fw);
									bw.write(str);
									bw.newLine();
									bw.close();
									//为新账号建立个人文件夹
									File newDir=new File(".\\"+zhanghao+"\\dingdan");
									newDir.mkdirs();
									new BufferedWriter(new FileWriter(".\\"+zhanghao+"\\SignUp.txt",true)).close();
									//为新账号建立个人信息文件
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
										bw1.write("0");//月单量
										bw1.newLine();
										bw1.write("5");//评分
										bw1.newLine();
										bw1.write("8:00--20:00");//营业时间
										bw1.newLine();
									}
									else{
										bw1.write("未知");//性别
										bw1.newLine();
										bw1.write("保密");//年龄
										bw1.newLine();
										bw1.write("未填写！！");//地址
										bw1.newLine();
										bw1.write("0");//积分
										bw1.newLine();
										bw1.write("该用户很懒，什么都没留下");//个人介绍
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
			super("注册成功！");
			setResizable(false);
			setLayout(null);
			JLabel jl1=new JLabel("注册成功!请记住您的账号：");
			jl1.setBounds(70,20,280,30);
			JLabel jl2=new JLabel(ac);
			jl2.setBounds(120,50,100,30);
			JButton jb=new JButton("确认");
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
		JPanel jp;//面板
		GridLayout gridlayout;
		JButton kehu,shangjia;
		
		public Iam(){
			super("用户类型选择窗口");
			setLayout(null);
			setResizable(false);
			gridlayout=new GridLayout(2,1,0,20);//网格布局管理器
		
			//注册表打开一次，防止没有注册表产生错误
			try {
				new BufferedWriter(new FileWriter("SignUp.txt",true)).close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			kehu=new JButton("我是客户");
			shangjia=new JButton("我是商家");
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