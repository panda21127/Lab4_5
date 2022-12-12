package model;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;


public class MyPanel extends JPanel {
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawLine(100, 410, 100, 390);//10
		g.drawLine(150, 410, 150, 390);//100
		g.drawLine(200, 410, 200, 390);//1000
		g.drawLine(250, 410, 250, 390);//10000
		g.drawLine(300, 410, 300, 390);//100000
		g.drawLine(40, 350, 60, 350);//10
		g.drawLine(40, 300, 60, 300);//100
		g.drawLine(40, 250, 60, 250);//1000
		g.drawLine(40, 200, 60, 200);//10000
		g.drawLine(40, 150, 60, 150);//100000
		g.drawString("0",30, 420);
		//x
		g.drawString("10",90, 420);
		g.drawString("100",140, 420);
		g.drawString("1000",182, 420);
		g.drawString("10000",230, 420);
		g.drawString("100000",280, 420);
		//y
		g.drawString("100000",10, 350);
		g.drawString("200000",10, 300);
		g.drawString("300000",10, 250);
		g.drawString("400000",10, 200);
		g.drawString("500000",10, 150);
		g.drawLine(50, 400, 50, 50);
		g.drawLine(50, 400, 400, 400);
		//our game
		List<Float>  arrays_list = new ArrayList<Float>() ;
		List<Float>  arrays_list_medium = new ArrayList<Float>() ;
		try {
			arrays_list=Model.Take_arrays("list","addTotalTime");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			arrays_list_medium=Model.Take_arrays("list","addMedianTime");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Color oldColor = g.getColor();
		Color newColor = new Color(0, 0, 255);
		int N=200000000;
		g.setColor(newColor);
		g.drawLine(50, 400, 100, (int)(400-arrays_list.get(0)/N));
		g.drawLine(100,(int)  (400-arrays_list.get(0)/N), 150,(int) (400-arrays_list.get(1)/N));
		g.drawLine(150,(int)  (400-arrays_list.get(1)/N), 200,(int) (400-arrays_list.get(2)/N));
		g.drawLine(200,(int)  (400-arrays_list.get(2)/N), 250,(int) (400-arrays_list.get(3)/N));
		g.drawLine(250,(int)  (400-arrays_list.get(3)/N), 300,(int) (400-arrays_list.get(4)/N));
		g.setColor(oldColor);
		newColor = new Color(0, 255, 0);
		int M=N;
		g.setColor(newColor);
		g.drawLine(50, 400, 100, (int)(400-arrays_list_medium.get(0)/M));
		g.drawLine(100,(int)  (400-arrays_list_medium.get(0)/M), 150,(int) (400-arrays_list_medium.get(1)/M));
		g.drawLine(150,(int)  (400-arrays_list_medium.get(1)/M), 200,(int) (400-arrays_list_medium.get(2)/M));
		g.drawLine(200,(int)  (400-arrays_list_medium.get(2)/M), 250,(int) (400-arrays_list_medium.get(3)/M));
		g.drawLine(250,(int)  (400-arrays_list_medium.get(3)/M), 300,(int) (400-arrays_list_medium.get(4)/M));
		g.setColor(oldColor);
	}
}
