package shop;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import tool.Queren;
import tool.Reader;

public class ShopDingdan extends JScrollPane{
	public ShopDingdan(String shangjiaID) throws IOException{
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		SD sd=new SD(shangjiaID);
		this.setViewportView(sd);
	}

}
class SD extends JPanel{
	ADingdan[] dd;
	
	public SD(String shangjiaID) throws IOException{
		File dir=new File(".\\"+shangjiaID+"\\dingdan");
		File[] file=dir.listFiles();
		int dingdanNum=file.length;
		int num=dingdanNum;
		if(num<10) num=10;
		setLayout(new GridLayout(num,1));
		dd=new ADingdan[dingdanNum];
		for(int i=0;i<dingdanNum;i++){
			dd[i]=new ADingdan(shangjiaID,file[i].getName());
			add(dd[i]);
		}
	}
	

}
class ADingdan extends JPanel implements ActionListener{
	String shangjiaDingdanID;
	String shangjiaID;
	
	String kehuID;
	String kehuDingdanID;
	String sumMoney;
	String state;
	
	String kehuName;
	
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2;
	
	public ADingdan(String shangjiaID,String dingdanID) throws IOException{
		this.shangjiaID=shangjiaID;
		this.shangjiaDingdanID=dingdanID;
		BufferedReader br;
		//��ȡ������Ϣ
		br=new BufferedReader(new FileReader(".\\"+shangjiaID+"\\dingdan\\"+dingdanID));
		kehuID=br.readLine();
		kehuDingdanID=br.readLine();
		sumMoney=br.readLine();
		state=br.readLine();
		br.close();
		//��ȡ�ͻ��û���
		br=new BufferedReader(new FileReader(kehuID+".txt"));
		br.readLine();
		kehuName=br.readLine();
		br.close();
		//�༭�������
		jl1=new JLabel("���Կͻ���  "+kehuName+" �Ķ���");
		jl2=new JLabel("�ܶ"+sumMoney);
		jl3=new JLabel("״̬��"+state);
		jb1=new JButton("�鿴��ϸ");
		jb2=new JButton("ȷ��");
		//System.out.println(state);
		if(state.equals("�ȴ��̼ҽӵ�"))
			jb2.setText("�ӵ�");
		else if(state.equals("��������"))
			jb2.setText("��ȴ�");
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
				//��ȡ�����ܶ�
				int sum;
				BufferedReader br=new BufferedReader(new FileReader(".\\"+shangjiaID+"\\dingdan\\"+shangjiaDingdanID));
				br.readLine();
				br.readLine();
				sum=Integer.parseInt(br.readLine());
				br.close();
				new Queren(sum+"Ԫ������");
				Reader re=new Reader(shangjiaID);
				re.addMoney(sum);
				state="��������";
				jb2.setText("��ȴ�");
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
				//�޸ĵ���µ���
				new Reader(shangjiaID).addYuedanliang();
				
				new Queren("�ӵ��ɹ�������������...");
			}
			else if(state.equals("��������")){
				new Queren("�����У���ȴ���");
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

