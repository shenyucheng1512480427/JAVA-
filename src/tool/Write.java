package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
	public Write(String shangjiaID,int tot,String gukeID,int n) throws IOException{
		//��ȡ�̼Ҷ�������
		File dir=new File(".\\"+shangjiaID+"\\dingdan");
		File[] files=dir.listFiles();
		int num=files.length+1;
		//�ͻ�Ŀ¼��	
		FileWriter fw = new FileWriter(".\\"+gukeID+"\\dingdan\\"+n);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(shangjiaID);
		bw.newLine();
		bw.write(""+num);
		bw.newLine();
		bw.write(""+tot);
		bw.newLine();
		bw.write("�ȴ��̼ҽӵ�");
		bw.close();
		//�̼�Ŀ¼��
		FileWriter fw2 = new FileWriter(".\\"+shangjiaID+"\\dingdan\\"+num);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		bw2.write(gukeID);
		bw2.newLine();
		bw2.write(""+n);
		bw2.newLine();
		bw2.write(""+tot);
		bw2.newLine();
		bw2.write("�ȴ��̼ҽӵ�");
		bw2.close();
	}
}

