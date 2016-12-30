package customer;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Diancan1 extends JPanel{
	Image img;
	public void paint(Graphics g){
		try{
			//×°ÔØÍ¼Ïñ
			img = ImageIO.read(new File("./picture.png"));
			
		}catch (IOException e){
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, 900, 150, null);
	}
}
