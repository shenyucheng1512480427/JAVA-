package customer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import tool.Queren;
import tool.Reader;

public class PerDingdan extends JScrollPane{
	public PerDingdan(String kehuID) throws IOException{
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		SD sd=new SD(kehuID);
		this.setViewportView(sd);
	}

}
class SD extends JPanel{
	ADingdan[] dd;
	
	public SD(String kehuID) throws IOException{
		File dir=new File(".\\"+kehuID+"\\dingdan");
		File[] file=dir.listFiles();
		int dingdanNum=file.length;
		int num=dingdanNum;
		if(num<10) num=10;
		setLayout(new GridLayout(num,1));
		dd=new ADingdan[dingdanNum];
		for(int i=0;i<dingdanNum;i++){
			dd[i]=new ADingdan(kehuID,file[i].getName());
			add(dd[i]);
		}
	}
	

}
class ADingdan extends JPanel implements ActionListener{
	String kehuDingdanID;
	String kehuID;
	
	String shangjiaID;
	String shangjiaDingdanID;
	String sumMoney;
	String state;
	
	String shangjiaName;
	
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2;
	
	public ADingdan(String kehuID,String dingdanID) throws IOException{
		this.kehuID=kehuID;
		this.kehuDingdanID=dingdanID;
		BufferedReader br;
		//��ȡ������Ϣ
		br=new BufferedReader(new FileReader(".\\"+kehuID+"\\dingdan\\"+dingdanID));
		shangjiaID=br.readLine();
		shangjiaDingdanID=br.readLine();
		sumMoney=br.readLine();
		state=br.readLine();
		br.close();
		//��ȡ�ͻ��û���
		br=new BufferedReader(new FileReader(kehuID+".txt"));
		br.readLine();
		shangjiaName=br.readLine();
		br.close();
		//�༭�������
		jl1=new JLabel("�ڵ�ң� "+shangjiaName+" �Ķ���");
		jl2=new JLabel("�ܶ"+sumMoney);
		jl3=new JLabel("״̬��"+state);
		jb1=new JButton("�鿴��ϸ");
		jb2=new JButton("ȷ��");
		//System.out.println(state);
		if(state.equals("�ȴ��̼ҽӵ�"))
			jb2.setText("��ȴ�");
		else if(state.equals("��������"))
			jb2.setText("ȷ���ʹ�");
		else if(state.equals("�����"))
			jb2.setText("�����");
		
		//Ϊ�����Ӽ�����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		this.setBorder(new BevelBorder(0));
		
		setLayout(new GridLayout(3,2));
		add(jl1);
		add(new JLabel(""));
		add(jl2);
		add(jl3);
		add(jb1);
		add(jb2);
		
	}

	public void actionPerformed(ActionEvent e) {
		try {
			
		if(e.getSource()==jb1){
			new Queren("���޴˹���");
		}else if(e.getSource()==jb2){
			if(state.equals("�ȴ��̼ҽӵ�")){
				new Queren("�ȴ��̼ҽӵ������Ժ�");
			}
			else if(state.equals("��������")){
				state="�����";
				jb2.setText("�����");
				jl3.setText("״̬��"+state);
				//�޸ĵ���ļ����µĶ����ļ�
				BufferedWriter bw=new BufferedWriter(new FileWriter(".\\"+shangjiaID+"\\dingdan\\"+shangjiaDingdanID));
				bw.write(kehuID);
				bw.newLine();
				bw.write(kehuDingdanID);
				bw.newLine();
				bw.write(sumMoney);
				bw.newLine();
				bw.write(state);
				bw.newLine();
				bw.close();
				//�޸Ŀͻ��ļ����µĶ����ļ�
				BufferedWriter bw2=new BufferedWriter(new FileWriter(".\\"+kehuID+"\\dingdan\\"+kehuDingdanID));
				bw2.write(shangjiaID);
				bw2.newLine();
				bw2.write(kehuDingdanID);
				bw2.newLine();
				bw2.write(sumMoney);
				bw2.newLine();
				bw2.write(state);
				bw2.newLine();
				bw2.close();
				
				new Queren("��������ɣ���ȥ���۰ɣ�");
			}
			else if(state.equals("�����")){
				new Queren("��������ɣ�");
			}
		}
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}

