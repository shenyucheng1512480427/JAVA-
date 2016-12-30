package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import customer.*;
import shop.*;
import signup.*;
import tool.*;
import tool.Reader;

public class Main {
	public static void main(String args[]) throws IOException{
		new SignUp();
		new Zhuceqi();
		//new Shop_main("2016001");
		//new AddCai("2016002");
//		JOptionPane.showMessageDialog(null, "友情提示");
//		JOptionPane.showMessageDialog(
//				null,"用户名与密码无法登录", "登录失败",JOptionPane.ERROR_MESSAGE);
//		JOptionPane.showMessageDialog(
//				null, "提示消息.", "标题",JOptionPane.PLAIN_MESSAGE);  
//		JOptionPane.showMessageDialog(jPanel, "提示消息", "标题",JOptionPane.WARNING_MESSAGE);
		
//		int n = JOptionPane.showConfirmDialog(
//				null, "你高兴吗?", "标题",JOptionPane.YES_NO_OPTION);//i=0/1 
//		System.out.println(n);
		
//		Object[] options ={ "好啊！", "去一边！" };  
//		int m = JOptionPane.showOptionDialog(
//				null, "我可以约你吗？", "标题",JOptionPane.YES_NO_OPTION,
//				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//		System.out.println(m);
//		
//		Object[] obj2 ={ "足球", "篮球", "乒乓球" };  
//		String s = (String) JOptionPane.showInputDialog(
//				null,"请选择你的爱好:\n", "爱好", JOptionPane.PLAIN_MESSAGE, 
//				new ImageIcon("icon.png"), obj2, "足球");
		
//		JOptionPane.showInputDialog(
//				null,"请输入你的爱好：\n","title",
//				JOptionPane.PLAIN_MESSAGE,icon,null,"在这输入");
	}
}
