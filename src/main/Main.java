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
//		JOptionPane.showMessageDialog(null, "������ʾ");
//		JOptionPane.showMessageDialog(
//				null,"�û����������޷���¼", "��¼ʧ��",JOptionPane.ERROR_MESSAGE);
//		JOptionPane.showMessageDialog(
//				null, "��ʾ��Ϣ.", "����",JOptionPane.PLAIN_MESSAGE);  
//		JOptionPane.showMessageDialog(jPanel, "��ʾ��Ϣ", "����",JOptionPane.WARNING_MESSAGE);
		
//		int n = JOptionPane.showConfirmDialog(
//				null, "�������?", "����",JOptionPane.YES_NO_OPTION);//i=0/1 
//		System.out.println(n);
		
//		Object[] options ={ "�ð���", "ȥһ�ߣ�" };  
//		int m = JOptionPane.showOptionDialog(
//				null, "�ҿ���Լ����", "����",JOptionPane.YES_NO_OPTION,
//				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//		System.out.println(m);
//		
//		Object[] obj2 ={ "����", "����", "ƹ����" };  
//		String s = (String) JOptionPane.showInputDialog(
//				null,"��ѡ����İ���:\n", "����", JOptionPane.PLAIN_MESSAGE, 
//				new ImageIcon("icon.png"), obj2, "����");
		
//		JOptionPane.showInputDialog(
//				null,"��������İ��ã�\n","title",
//				JOptionPane.PLAIN_MESSAGE,icon,null,"��������");
	}
}
