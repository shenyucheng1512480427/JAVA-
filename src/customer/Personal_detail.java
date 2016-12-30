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
	JButton save = new JButton("保存");
	JButton quit = new JButton("返回");
	String account;
	void setAccount(String account){this.account = account;}
	public Personal_detail(){}
	public Personal_detail(String account) throws IOException{ 
    	//框架设置
		super("个人信息");
		setResizable(false);
		setLayout(null);
		//创建面板
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		//面板使用网格布局器
		GridLayout gridlayout = new GridLayout(11,1,0,30);
		jp.setLayout(gridlayout);
		GridLayout gridlayout2 = new GridLayout(11,1,0,30);
		jp2.setLayout(gridlayout2);
		GridLayout gridlayout3 = new GridLayout(11,1,0,30);
		jp3.setLayout(gridlayout3);
		//创建滚动条面板
        JScrollPane outputScrollPane = new JScrollPane();
        outputScrollPane.setBounds(115,557,450,100);
        getContentPane().add(outputScrollPane);
        //第一个面板的标签
		myLb[0] = new JLabel("账号： ");
		jp.add(myLb[0]);
        myLb[1] = new JLabel("用户名： ");
		jp.add(myLb[1]);
		myLb[2] = new JLabel("密码： ");
		jp.add(myLb[2]);
		myLb[3]= new JLabel("余额： ");
		jp.add(myLb[3]);
	    myLb[4]= new JLabel("性别： ");
		jp.add(myLb[4]);
		myLb[5]= new JLabel("年龄： ");
		jp.add(myLb[5]);
		myLb[6]= new JLabel("地址： ");
		jp.add(myLb[6]);
		myLb[7] = new JLabel("积分： ");
		jp.add(myLb[7]);
		myLb[8] = new JLabel("个人介绍： ");
		jp.add(myLb[8]);	
		//添加面板
		getContentPane().add(jp);
		jp.setBounds(10,15,100,700);
		
	    //添加文本框
		for(int i = 0 ;i < 9;i++){
			jt[i] = new JTextField();
			jt[i].setEditable(false);
		}
	    for(int i = 0;i < 8;i++){
	    	jp2.add(jt[i]);
	    }        
	    setAccount(account);
		//添加文本域
        outputScrollPane.setViewportView(ja);
        ja.setLineWrap(true);
        //设置第二个面板
		jp2.setBounds(115,20,450,700);
		getContentPane().add(jp2);
		//创建按钮
		jb[0] = new JButton("切换");
		jb[1] = new JButton("更改");
		jb[2] = new JButton("更改");
		jb[3] = new JButton("充值");
		jb[4] = new JButton("更改");
		jb[5] = new JButton("更改");
		jb[6] = new JButton("更改");
		jb[7] = new JButton("更改");
		jb[8] = new JButton("更改");
		ButtonHandler Bt = new ButtonHandler();
		for(int i = 1;i < 9;i++){
			jb[i].addActionListener(Bt);
		}
		jp3.add(new Label(""));
		for(int i = 1;i <7;i++){
			jp3.add(jb[i]);
		}
		

		
		//保存按钮
		save.setBounds(150,720,100,50);
		add(save);
		save.addActionListener(Bt);
		//返回按钮
		quit.setBounds(350,720,100,50);
		add(quit);
		quit.addActionListener(Bt);
		
		//设置第三个面板
		jp3.setBounds(580,20,80,700);
		getContentPane().add(jp3);
		
	    //设置框架
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
     //构造监听器
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
	    		//文本域的写入
	    		//	 fw.write(ja.getText());
	    		//   fw.close();
	    			 for (int i = 0; i < ja.getLineCount(); i++) {
	    				 try {
	    				 String s = ja.getText(ja.getLineStartOffset(i), ja.getLineEndOffset(i)- ja.getLineStartOffset(i));
	    				 fw.write(s);
	    				 fw.write("\r\n");
	    				 //s为每一行数据，如果想保存在windows中加\r\n就好了
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
	    		 System.out.println("错误");
	    	 } catch (IOException e1) {
				e1.printStackTrace();
			}
	    	
	    }
   }
}
