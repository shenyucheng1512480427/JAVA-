package customer;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;
import tool.*;
import tool.Reader;
import signup.*;

import java.io.*;
public class Personal_detail extends JFrame {
	boolean qiehuan=true;
	public boolean getqiehuan(){return qiehuan;}
	JPanel jp,jp2,jp3;
	GridLayout gridlayout,gridlayout2,gridlayout3;
	JScrollPane outputScrollPane;
	JTextField [] jt = new JTextField[10];
	JButton [] jb = new JButton[10];
    JLabel [] myLb = new JLabel[10];
	JTextArea ja = new JTextArea();   	
	JButton save = new JButton("����");
	JButton quit = new JButton("����");
	String account;
	void setAccount(String account){this.account = account;}
	public Personal_detail(){}
	public Personal_detail(String account) throws IOException{ 
    	//�������
		super("������Ϣ");
		setResizable(false);
		setLayout(null);
		//�������
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		//���ʹ�����񲼾���
		GridLayout gridlayout = new GridLayout(11,1,0,30);
		jp.setLayout(gridlayout);
		GridLayout gridlayout2 = new GridLayout(11,1,0,30);
		jp2.setLayout(gridlayout2);
		GridLayout gridlayout3 = new GridLayout(11,1,0,30);
		jp3.setLayout(gridlayout3);
		//�������������
        JScrollPane outputScrollPane = new JScrollPane();
        outputScrollPane.setBounds(115,557,450,100);
        getContentPane().add(outputScrollPane);
        //��һ�����ı�ǩ
		myLb[0] = new JLabel("�˺ţ� ");
		jp.add(myLb[0]);
        myLb[1] = new JLabel("�û����� ");
		jp.add(myLb[1]);
		myLb[2] = new JLabel("���룺 ");
		jp.add(myLb[2]);
		myLb[3]= new JLabel("�� ");
		jp.add(myLb[3]);
	    myLb[4]= new JLabel("�Ա� ");
		jp.add(myLb[4]);
		myLb[5]= new JLabel("���䣺 ");
		jp.add(myLb[5]);
		myLb[6]= new JLabel("��ַ�� ");
		jp.add(myLb[6]);
		myLb[7] = new JLabel("���֣� ");
		jp.add(myLb[7]);
		myLb[8] = new JLabel("���˽��ܣ� ");
		jp.add(myLb[8]);	
		//������
		getContentPane().add(jp);
		jp.setBounds(10,15,100,700);
		
	    //����ı���
		for(int i = 0 ;i < 9;i++){
			jt[i] = new JTextField();
			jt[i].setEditable(false);
		}
	    for(int i = 0;i < 8;i++){
	    	jp2.add(jt[i]);
	    }        
	    setAccount(account);
		//����ı���
        outputScrollPane.setViewportView(ja);
        ja.setLineWrap(true);
        //���õڶ������
		jp2.setBounds(115,20,450,700);
		getContentPane().add(jp2);
		//������ť
		jb[0] = new JButton("�л�");
		jb[1] = new JButton("����");
		jb[2] = new JButton("����");
		jb[3] = new JButton("��ֵ");
		jb[4] = new JButton("����");
		jb[5] = new JButton("����");
		jb[6] = new JButton("����");
		jb[7] = new JButton("����");
		jb[8] = new JButton("����");
		ButtonHandler Bt = new ButtonHandler();
		for(int i = 1;i < 9;i++){
			jb[i].addActionListener(Bt);
		}
		jp3.add(new Label(""));
		for(int i = 1;i <7;i++){
			jp3.add(jb[i]);
		}
		

		
		//���水ť
		save.setBounds(150,720,100,50);
		add(save);
		save.addActionListener(Bt);
		//���ذ�ť
		quit.setBounds(350,720,100,50);
		add(quit);
		quit.addActionListener(Bt);
		
		//���õ��������
		jp3.setBounds(580,20,80,700);
		getContentPane().add(jp3);
		
	    //���ÿ��
		setBounds(400,50,700,900);
		setVisible(true);
	
		readTxt(account);
	}
    public void readTxt(String account) throws IOException {
    	try {
			FileReader fr = new FileReader(account+".txt");
			BufferedReader buf = new BufferedReader(fr);
		
			for(int i = 0 ;i < 8;i++){
				if(i==3)
					buf.readLine();
				jt[i].setText(buf.readLine());
			}
			String str;
			ja.setText(buf.readLine());	
		//	for(int i = 0 ;i < ja.getLineCount()-1;i++){
			//	ja.append("\n\r");
		//    ja.append(buf.readLine());
		//	}
			while((str=buf.readLine())!= null){
		//		ja.newLine();
				ja.append(str);
			}
			
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		}
    }
     //���������
    class ButtonHandler implements ActionListener{
	     public void actionPerformed(ActionEvent e) {
	    	 try{
	    		 if(e.getSource() == jb[0]){
	    			  dispose();
	    			  qiehuan=false;
	    		 }
	    		 else if(e.getSource() == jb[1]){
	    			 jt[1].setEditable(true);
	    		 }
	    		 else if(e.getSource() == jb[2]){
	    			 jt[2].setEditable(true);
	    		 }
	    	     else if(e.getSource() == jb[3]){
	    			 Chongzhi cz = new Chongzhi(account);
	    			 cz.addWindowListener(new WindowAdapter(){
	    				 public void windowClosed(WindowEvent e1){
	    					 try {
								readTxt(account);
							} catch (IOException e) {
								e.printStackTrace();
							}
	    				 }
	    			 });
//	    			 while(cz.getBool()==true)
//	    			 jt[3].setText(cz.showyue());
//	    			 FileWriter fw;
//	    			 fw = new FileWriter(account+".txt");
//	    			 for(int i = 0;i < 8;i++){
//	    				 if(i==3)
//	    					 fw.write("true\r\n");
//	    			     fw.write(jt[i].getText()+"\r\n");
//	    			 }
//	    			 fw.write(ja.getText());
//	    		     fw.close();
	    		 }
	    		 else if(e.getSource() == jb[4]){
	    			 jt[4].setEditable(true);
	    		 }
	    		 else if(e.getSource() == jb[5]){
	    			 jt[5].setEditable(true);
	    		 }
	    		 else if(e.getSource() == jb[6]){
	    			 jt[6].setEditable(true);
	    		 }
	    		 else if(e.getSource() == jb[7]){
	    			 jt[7].setEditable(true);
	    		 }
	    		 else if(e.getSource() == jb[8]){
	    			 jt[8].setEditable(true);
	    		 }
	    		 else if(e.getSource() == save){
	    			 for(int i = 1;i < 9;i++){
	    				 jt[i].setEditable(false);
	    			 }
	    			 FileWriter fw;
	    			 fw = new FileWriter(account+".txt");
	    			 for(int i = 0;i < 8;i++){
	    				 if(i==3)
	    					 fw.write("true\r\n");
	    			    fw.write(jt[i].getText()+"\r\n");
	    			 }
	    		//�ı����д��
	    		//	 fw.write(ja.getText());
	    		//   fw.close();
	    			 for (int i = 0; i < ja.getLineCount(); i++) {
	    				 try {
	    				 String s = ja.getText(ja.getLineStartOffset(i), ja.getLineEndOffset(i)- ja.getLineStartOffset(i));
	    				 fw.write(s);
	    				 fw.write("\r\n");
	    				 //sΪÿһ�����ݣ�����뱣����windows�м�\r\n�ͺ���
	    				 } catch (Exception ex) {
	    				 ex.printStackTrace();
	    				 }
	    			 }
	    			 fw.close();
	    		 }
	    		 else if(e.getSource() == quit){
	    			 dispose();
	    		 }
	    		 
	    	 }catch(StringIndexOutOfBoundsException e2){
	    		 System.out.println("����");
	    	 } catch (IOException e1) {
				e1.printStackTrace();
			}
	    	
	    }
   }
}
