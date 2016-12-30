package tool;

import java.io.*;

public class Reader {
	String[] info=new String[10];
	String zhanghao;
	String name;
	String mima;
	boolean isKehu;
	String money;
	
	String xingbie;
	String nianling;
	String dizhi;
	String jifen;
	String jieshao;
	
	String yuedanliang;
	String pingfen;
	String yingyeshijian;
	//获取用户信息
	public String getZhanghao(){return zhanghao;}
	public String getName(){return name;}
	public String getMima(){return mima;}
	public boolean getIsKehu(){return isKehu;}
	public String getMoney(){return money;}
	
	public String getDizhi(){return dizhi;}
	public String getXingbie(){return xingbie;}
	public String getNianling(){return nianling;}
	public String getJifen(){return jifen;}
	public String getJieshao(){return jieshao;}
	
	public String getYuedanliang(){return yuedanliang;}
	public String getPingfen(){return pingfen;}
	public String getYingyeshijian(){return yingyeshijian;}

	public Reader(String zhanghao) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(zhanghao+".txt"));
		for(int i=0;i<10;i++){
			info[i]=br.readLine();
		}
		this.zhanghao=info[0];
		name=info[1];
		mima=info[2];
		isKehu=Boolean.parseBoolean(info[3]);
		money=info[4];
		yuedanliang=xingbie=info[5];
		pingfen=nianling=info[6];
		yingyeshijian=dizhi=info[7];
		jifen=info[8];
		br.close();
	}
	//更改用户某一项信息
	public void changeMima(String newmima) throws IOException {
		mima=newmima;
		info[2]=mima;
		change(newmima,3);
	}
	public void changeMoney(String newmoney) throws IOException{
		money=newmoney;
		info[4]=money;
		change(newmoney,5);
	}
	//如果money不是数字就会产生错误，注意！！！！！！！！！！！！！！！！！！！！！！！！！
	public void addMoney(int addmoney) throws IOException{
		int mon=Integer.parseInt(money);
		int sum=mon+addmoney;
		money=String.valueOf(sum);
		info[4]=money;
		change(money,5);
	}
	public void changeDizhi(String newdizhi) throws IOException{
		dizhi=newdizhi;
		info[5]=dizhi;
		change(newdizhi,8);
	}
	public void addYuedanliang() throws IOException{
		int num=Integer.parseInt(yuedanliang);
		num++;
		info[5]=yuedanliang=String.valueOf(num);
		change(yuedanliang,6);
	}
	//更改用户信息文件第line行为str
	void change(String str,int line) throws IOException{
		int n = getTextLines();
		BufferedWriter bw=new BufferedWriter(new FileWriter(zhanghao+".txt"));
		for(int i=0;i<line-1;i++){
			bw.write(info[i]);
			bw.newLine();
		}
		bw.write(str);
		bw.newLine();
		for(int i = line;i < n;i++){
			bw.write(info[i]);
			bw.newLine();
		}
		bw.close();
	}
	//账户初始化，仅留下登录信息
	public void chushihua() throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter(zhanghao+".txt"));
		bw.write(zhanghao);
		bw.write(name);
		bw.write(mima);
		bw.write(String.valueOf(isKehu));
		bw.write("0");
		for(int i=0;i<10;i++){
			bw.write(" ");
		}
		bw.close();
	}
	//得到TXT文本行数
	public int getTextLines() throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(zhanghao+".txt"));
		int x = 0; 
		while(br.readLine() != null) {
		    x++; 
        }
		br.close();
	return x;
	}

}
