package tool;

import javax.swing.JOptionPane;

public class Shifou {
	public int m1;
	public Shifou(String str){
		Object[] options ={"ÊÇ","·ñ"};
		int m = JOptionPane.showOptionDialog(
			null,str,null,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		m1=m;
	}
}
