package tool;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class Zhuceqi extends JFrame implements ActionListener{
	JPanel jp;
	JLabel jl1,jl2;
	JButton jb;
	JRadioButton jrb1,jrb2;
	ButtonGroup btg;
	JTextField jt;

	public Zhuceqi(){
		super("注册器");
		jp=new JPanel();
		jp.setLayout(new FlowLayout());
		add(jp);
		
		jl1=new JLabel("注册类型：");
		//jl1.setBounds(0,0);//
		jp.add(jl1);
		btg=new ButtonGroup();
		jrb1=new JRadioButton("商家");
		jrb2=new JRadioButton("客户");
		btg.add(jrb1);
		btg.add(jrb2);
		jp.add(jrb1);
		jp.add(jrb2);
		
		jl2=new JLabel("注册数量：");
		jp.add(jl2);
		
		jt=new JTextField();
		jt.setColumns(9);
		jp.add(jt);
		
		jb=new JButton("执行");
		jp.add(jb);
		jb.addActionListener(this);
		
		setBounds(600,250,200,150);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		String[] kehuName={"张三","李四","王麻","陆人甲","涂匪乙","刘氓丁"};
		String[] dianjiaName={"沈大成","上理炒饭","麦当劳","肯德基","必胜客","第一食堂","上理第五食堂","普通烤肉店","东北家常菜"};
		String[] caiName={"锅包肉","冰红茶","小鸡炖蘑菇","西红柿炒鸡蛋","韭黄炒蛋","蛋炒饭","汉堡包","薯条","烤鸡","米饭","土豆丝"};
		if(e.getSource()==jb){
			try {
				//注册表打开一次，防止没有注册表产生错误
				BufferedWriter b = new BufferedWriter(new FileWriter("SignUp.txt",true));
				b.close();
				new BufferedWriter(new FileWriter("shangjia.txt",true)).close();
				new BufferedWriter(new FileWriter("kehu.txt",true)).close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if(jt.getText().equals("")){
				new Queren("数量不能为空！");
			}
			else if(jrb1.isSelected()==true){
				int num=Integer.parseInt(jt.getText());
				
				try {
					
					FileReader fr;
					fr = new FileReader("SignUp.txt");
					BufferedReader br=new BufferedReader(fr);
					int zhanghao=2016001;
					while(br.readLine()!=null)zhanghao++;
					br.close();

					for(int i=0;i<num;i++,zhanghao++){
						//添加进注册表
						BufferedWriter bw1=new BufferedWriter(new FileWriter("SignUp.txt",true));
						bw1.write(zhanghao+"");
						bw1.newLine();
						bw1.close();
						//添加进店家注册表
						BufferedWriter bw5;
						bw5=new BufferedWriter(new FileWriter("shangjia.txt",true));
						bw5.write(zhanghao+"");
						bw5.newLine();
						bw5.close();
						//创建文件夹
						File newDir=new File(".\\"+zhanghao+"\\dingdan");
						newDir.mkdirs();
						//建立店家文件
						BufferedWriter bw=new BufferedWriter(new FileWriter(zhanghao+".txt"));
						bw.write(zhanghao+"");//账号
						bw.newLine();
						bw.write(dianjiaName[(int)(Math.random()*dianjiaName.length )]);//店名
						bw.newLine();
						bw.write("123123");//密码
						bw.newLine();
						bw.write("false");//账号类型
						bw.newLine();
						bw.write((int)(Math.random()*20+1)*100+"");//余额
						bw.newLine();
						bw.write((int)(Math.random()*200+20)+"");//月单量
						bw.newLine();
						bw.write(String.format("%.1f",(double)((int)(Math.random()*12+39))/10)+"");//评分
						bw.newLine();
						bw.write((int)(Math.random()*4+6)+":00--"+(int)(Math.random()*5+20)+":00");//营业时间
						bw.newLine();
						bw.close();
						
						//将菜品添加进菜品注册表
						int caiNum=(int)(Math.random()*36+5);//菜的数量
						BufferedWriter bw4=new BufferedWriter(
								new FileWriter(".\\"+zhanghao+"\\SignUp.txt"));
						for(int j=1;j<=caiNum;j++){
							bw4.write(j+"");
							bw4.newLine();
						}
						bw4.close();
						for(int j=1;j<=caiNum;j++){
							//建立新菜品文件
							BufferedWriter bw3=new BufferedWriter(
									new FileWriter(".\\"+zhanghao+"\\"+j+".txt"));
							bw3.write(j+"");//ID
							bw3.newLine();
							bw3.write(caiName[(int)(Math.random()*caiName.length )]);//菜名
							bw3.newLine();
							bw3.write((int)(Math.random()*21+10)+"");//售价
							bw3.newLine();
							bw3.write((int)(Math.random()*31+10)+"");//销量
							bw3.newLine();
							bw3.write(String.format("%.1f",(double)((int)(Math.random()*12+39))/10)+"");//评分
							bw3.newLine();
							bw3.close();
						}
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Queren("新增"+num+"个店家！");
			}
			else if(jrb2.isSelected()==true){
				int num=Integer.parseInt(jt.getText());
				
				try {
					FileReader fr;
					fr = new FileReader("SignUp.txt");
					BufferedReader br=new BufferedReader(fr);
					int zhanghao=2016001;
					while(br.readLine()!=null)zhanghao++;
					br.close();

					for(int i=0;i<num;i++){
						//添加进注册表
						BufferedWriter bw1=new BufferedWriter(new FileWriter("SignUp.txt",true));
						bw1.write(zhanghao+"");
						bw1.newLine();
						bw1.close();
						//添加进客户注册表
						BufferedWriter bw4;
						bw4=new BufferedWriter(new FileWriter("kehu.txt",true));
						bw4.write(zhanghao+"");
						bw4.newLine();
						bw4.close();
						//创建文件夹
						File newDir=new File(".\\"+zhanghao+"\\dingdan");
						newDir.mkdirs();
						//建立用户文件
						BufferedWriter bw=new BufferedWriter(new FileWriter(zhanghao+".txt"));
						bw.write(zhanghao+"");
						bw.newLine();
						bw.write(kehuName[(int)(Math.random()*kehuName.length )]);
						bw.newLine();
						bw.write("123123");
						bw.newLine();
						bw.write("true");
						bw.newLine();
						bw.write(0+"");//余额
						bw.newLine();
						if((int)(Math.random()%2)==1) //性别
							bw.write("男");
						else bw.write("女");
						bw.newLine();
						bw.write((int)(Math.random()*50+15)+""); //年龄
						bw.newLine();
						bw.write("军工路"+(int)(Math.random()*1001+100));//地址
						bw.newLine();
						bw.write((int)(Math.random()*3000+500)+"");//积分
						bw.newLine();
						bw.write("该用户很懒，什么都没留下");//个人介绍
						bw.newLine();
						bw.close();
						zhanghao++;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Queren("新增"+num+"个用户！");
			}
		}	
	}
}


//class Shifou extends JFrame implements ActionListener{
//	JPanel jp;
//	JLabel jl;
//	JButton jb1,jb2;
//
//	public Shifou(){
//		super("?");
//		jp=new JPanel();
//		jp.setLayout(null);
//		add(jp);
//		
//		jl=new JLabel("是否开启注册器？");
//		jl.setBounds(40,0,160,50);
//		jp.add(jl);
//		
//		jb1=new JButton("是");
//		jb1.setBounds(30,50,50,30);
//		jp.add(jb1);
//		jb2=new JButton("否");
//		jb2.setBounds(100,50,50,30);
//		jp.add(jb2);
//		setBounds(600,250,200,150);
//		setVisible(true);
//		
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==jb1){
//			
//		}	
//	}
//}