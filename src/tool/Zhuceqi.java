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
		super("ע����");
		jp=new JPanel();
		jp.setLayout(new FlowLayout());
		add(jp);
		
		jl1=new JLabel("ע�����ͣ�");
		//jl1.setBounds(0,0);//
		jp.add(jl1);
		btg=new ButtonGroup();
		jrb1=new JRadioButton("�̼�");
		jrb2=new JRadioButton("�ͻ�");
		btg.add(jrb1);
		btg.add(jrb2);
		jp.add(jrb1);
		jp.add(jrb2);
		
		jl2=new JLabel("ע��������");
		jp.add(jl2);
		
		jt=new JTextField();
		jt.setColumns(9);
		jp.add(jt);
		
		jb=new JButton("ִ��");
		jp.add(jb);
		jb.addActionListener(this);
		
		setBounds(600,250,200,150);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		String[] kehuName={"����","����","����","½�˼�","Ϳ����","��å��"};
		String[] dianjiaName={"����","������","����","�ϵ»�","��ʤ��","��һʳ��","�������ʳ��","��ͨ�����","�����ҳ���"};
		String[] caiName={"������","�����","С����Ģ��","������������","�»Ƴ���","������","������","����","����","�׷�","����˿"};
		if(e.getSource()==jb){
			try {
				//ע����һ�Σ���ֹû��ע����������
				BufferedWriter b = new BufferedWriter(new FileWriter("SignUp.txt",true));
				b.close();
				new BufferedWriter(new FileWriter("shangjia.txt",true)).close();
				new BufferedWriter(new FileWriter("kehu.txt",true)).close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if(jt.getText().equals("")){
				new Queren("��������Ϊ�գ�");
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
						//��ӽ�ע���
						BufferedWriter bw1=new BufferedWriter(new FileWriter("SignUp.txt",true));
						bw1.write(zhanghao+"");
						bw1.newLine();
						bw1.close();
						//��ӽ����ע���
						BufferedWriter bw5;
						bw5=new BufferedWriter(new FileWriter("shangjia.txt",true));
						bw5.write(zhanghao+"");
						bw5.newLine();
						bw5.close();
						//�����ļ���
						File newDir=new File(".\\"+zhanghao+"\\dingdan");
						newDir.mkdirs();
						//��������ļ�
						BufferedWriter bw=new BufferedWriter(new FileWriter(zhanghao+".txt"));
						bw.write(zhanghao+"");//�˺�
						bw.newLine();
						bw.write(dianjiaName[(int)(Math.random()*dianjiaName.length )]);//����
						bw.newLine();
						bw.write("123123");//����
						bw.newLine();
						bw.write("false");//�˺�����
						bw.newLine();
						bw.write((int)(Math.random()*20+1)*100+"");//���
						bw.newLine();
						bw.write((int)(Math.random()*200+20)+"");//�µ���
						bw.newLine();
						bw.write(String.format("%.1f",(double)((int)(Math.random()*12+39))/10)+"");//����
						bw.newLine();
						bw.write((int)(Math.random()*4+6)+":00--"+(int)(Math.random()*5+20)+":00");//Ӫҵʱ��
						bw.newLine();
						bw.close();
						
						//����Ʒ��ӽ���Ʒע���
						int caiNum=(int)(Math.random()*36+5);//�˵�����
						BufferedWriter bw4=new BufferedWriter(
								new FileWriter(".\\"+zhanghao+"\\SignUp.txt"));
						for(int j=1;j<=caiNum;j++){
							bw4.write(j+"");
							bw4.newLine();
						}
						bw4.close();
						for(int j=1;j<=caiNum;j++){
							//�����²�Ʒ�ļ�
							BufferedWriter bw3=new BufferedWriter(
									new FileWriter(".\\"+zhanghao+"\\"+j+".txt"));
							bw3.write(j+"");//ID
							bw3.newLine();
							bw3.write(caiName[(int)(Math.random()*caiName.length )]);//����
							bw3.newLine();
							bw3.write((int)(Math.random()*21+10)+"");//�ۼ�
							bw3.newLine();
							bw3.write((int)(Math.random()*31+10)+"");//����
							bw3.newLine();
							bw3.write(String.format("%.1f",(double)((int)(Math.random()*12+39))/10)+"");//����
							bw3.newLine();
							bw3.close();
						}
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Queren("����"+num+"����ң�");
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
						//��ӽ�ע���
						BufferedWriter bw1=new BufferedWriter(new FileWriter("SignUp.txt",true));
						bw1.write(zhanghao+"");
						bw1.newLine();
						bw1.close();
						//��ӽ��ͻ�ע���
						BufferedWriter bw4;
						bw4=new BufferedWriter(new FileWriter("kehu.txt",true));
						bw4.write(zhanghao+"");
						bw4.newLine();
						bw4.close();
						//�����ļ���
						File newDir=new File(".\\"+zhanghao+"\\dingdan");
						newDir.mkdirs();
						//�����û��ļ�
						BufferedWriter bw=new BufferedWriter(new FileWriter(zhanghao+".txt"));
						bw.write(zhanghao+"");
						bw.newLine();
						bw.write(kehuName[(int)(Math.random()*kehuName.length )]);
						bw.newLine();
						bw.write("123123");
						bw.newLine();
						bw.write("true");
						bw.newLine();
						bw.write(0+"");//���
						bw.newLine();
						if((int)(Math.random()%2)==1) //�Ա�
							bw.write("��");
						else bw.write("Ů");
						bw.newLine();
						bw.write((int)(Math.random()*50+15)+""); //����
						bw.newLine();
						bw.write("����·"+(int)(Math.random()*1001+100));//��ַ
						bw.newLine();
						bw.write((int)(Math.random()*3000+500)+"");//����
						bw.newLine();
						bw.write("���û�������ʲô��û����");//���˽���
						bw.newLine();
						bw.close();
						zhanghao++;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Queren("����"+num+"���û���");
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
//		jl=new JLabel("�Ƿ���ע������");
//		jl.setBounds(40,0,160,50);
//		jp.add(jl);
//		
//		jb1=new JButton("��");
//		jb1.setBounds(30,50,50,30);
//		jp.add(jb1);
//		jb2=new JButton("��");
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