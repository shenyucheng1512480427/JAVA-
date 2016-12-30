package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
	public Write(String shangjiaID,int tot,String gukeID,int n) throws IOException{
		//读取商家订单数量
		File dir=new File(".\\"+shangjiaID+"\\dingdan");
		File[] files=dir.listFiles();
		int num=files.length+1;
		//客户目录下	
		FileWriter fw = new FileWriter(".\\"+gukeID+"\\dingdan\\"+n);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(shangjiaID);
		bw.newLine();
		bw.write(""+num);
		bw.newLine();
		bw.write(""+tot);
		bw.newLine();
		bw.write("等待商家接单");
		bw.close();
		//商家目录下
		FileWriter fw2 = new FileWriter(".\\"+shangjiaID+"\\dingdan\\"+num);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		bw2.write(gukeID);
		bw2.newLine();
		bw2.write(""+n);
		bw2.newLine();
		bw2.write(""+tot);
		bw2.newLine();
		bw2.write("等待商家接单");
		bw2.close();
	}
}

