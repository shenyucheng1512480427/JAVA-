package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaiReader {
	String zhanghao;
	int caiNum;
	public int getCaiNum(){return caiNum;}
	public CaiReader(String zhanghao) throws IOException{
		this.zhanghao=zhanghao;
		int num=0;
		
		//注册表打开一次，防止没有注册表而产生错误
		try {
			BufferedWriter b = new BufferedWriter(new FileWriter(".\\"+zhanghao+"\\SignUp.txt",true));
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader br=new BufferedReader(new FileReader(".\\"+zhanghao+"\\SignUp.txt"));
		while(br.readLine()!=null){num++;}
		br.close();
		caiNum=num;
	}

}
