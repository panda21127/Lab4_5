package model;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(int count)
    {
    	if(count==1)
    	{
	    	setTitle("Graphis List");
	    	setSize(500,500);
	    	MyPanel panel=new MyPanel();
	    	Container pane=getContentPane();
	    	pane.add(panel);
    	}
    	if(count==2)
    	{
	    	setTitle("Graphis HashMap");
	    	setSize(500,500);
	    	MyPanel2 panel=new MyPanel2();
	    	Container pane=getContentPane();
	    	pane.add(panel);
    	}
    }
}
