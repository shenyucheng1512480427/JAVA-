package shop;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;
import javax.swing.*;

import customer.Chongzhi;

import signup.*;

import java.io.*;
public class Shop_detail extends JFrame {
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
	 public Shop_detail(){}
	 public Shop_detail(String account) throws IOException{
    	//框架设置
		super("店家信息");
		setResizable(false);
		setLayout(null);
		//创建面板
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		//面板使用网格布局器
		GridLayout gridlayout = new GridLayout(11,1,0,30);
		jp.setLayout(gridlayout);
		GridLayout gridlayout2 = new GridLayout(7,1,0,30);
		jp2.setLayout(gridlayout2);
		GridLayout gridlayout3 = new GridLayout(11,1,0,30);
		jp3.setLayout(gridlayout3);
		//创建滚动条面板
//        JScrollPane outputScrollPane = new JScrollPane();
//        outputScrollPane.setBounds(115,557,450,100);
//        getContentPane().add(outputScrollPane);
        //第一个面板的标签
		myLb[0] = new JLabel("账号： ");
		jp.add(myLb[0]);
        myLb[1] = new JLabel("店名： ");
		jp.add(myLb[1]);
		myLb[2] = new JLabel("密码： ");
		jp.add(myLb[2]);
		myLb[3]= new JLabel("余额: ");
		jp.add(myLb[3]);
	    myLb[4]= new JLabel("单量");
		jp.add(myLb[4]);
		myLb[5]= new JLabel("评分 ");
		jp.add(myLb[5]);
		myLb[6]= new JLabel("营业时间： ");
		jp.add(myLb[6]);
		//添加面板
		getContentPane().add(jp);
		jp.setBounds(10,15,100,700);
	    //添加文本框
		for(int i = 0 ;i < 7;i++){
			jt[i] = new JTextField();
			jt[i].setEditable(false);
		}
	    for(int i = 0;i < 7;i++){
	    	jp2.add(jt[i]);
	    }        
//	    //读取TXT写入文本框
//	    jt[0].setText(account);
//	    jt[1].setText(username);
//	    jt[2].setText(password);
//	    jt[7].setText("0");

	    
	    setAccount(account);
	    //读取文本框数据到文本
	 /*   FileWriter fw;
	    fw = new FileWriter(account+".txt");
	    for(int i = 0;i < 9;i++){
	    	fw.write(jt[i].getText());
	    	fw.write("\n");
	    }
        fw.close();
	   */ 
	    

		//添加文本域
//        outputScrollPane.setViewportView(ja);
        //设置第二个面板
		jp2.setBounds(115,20,450,430);
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
		for(int i = 0;i < 7;i++){
			jb[i].addActionListener(Bt);
		}
		jp3.add(new JLabel(""));
		for(int i = 1;i <4;i++){
			jp3.add(jb[i]);
		}
		jp3.add(new JLabel(""));
		jp3.add(new JLabel(""));
		jp3.add(jb[6]);
		//保存按钮
		save.setBounds(200,500,100,50);
		add(save);
		save.addActionListener(Bt);
		//返回按钮
		quit.setBounds(370,500,100,50);
		add(quit);
		quit.addActionListener(Bt);
		
		//设置第三个面板
		jp3.setBounds(580,20,80,700);
		getContentPane().add(jp3);
		
	    //设置框架
		setBounds(400,50,700,700);
		
		readTxt(account);
		setVisible(true);



	}
     //从Txt读取数据显示
    public void readTxt(String account) throws IOException {
    	try {
			FileReader fr = new FileReader(account+".txt");
			BufferedReader buf = new BufferedReader(fr);
			for(int i = 0 ;i < 7;i++){
				if(i==3)
					buf.readLine();
				jt[i].setText(buf.readLine());
			}
			ja.setText(buf.readLine());
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		}
    }

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
	    			 for(int i = 1;i < 7;i++){
	    				 jt[i].setEditable(false);
	    			 }
	    			 FileWriter fw;
	    			 fw = new FileWriter(account+".txt");
	    			 for(int i = 0;i < 7;i++){
	    				 if(i==3)
	    					 fw.write("false\r\n");
	    			    fw.write(jt[i].getText()+"\r\n");
	    			 }
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