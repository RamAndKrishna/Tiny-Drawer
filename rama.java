


import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class rama extends JPanel
{
JLabel sl;
MyShape[] sha;
int co,temp;
int type;

Point p1,p2,p3;
MyShape shape;
Color clr;
boolean fill;
rama(JLabel l)
{
shape=new MyLine();
sl=l;
sha = new MyShape[100];
co=-1;
temp=-1;
type=0;
shape=null;
clr=Color.BLACK;
addMouseListener(new krishna());
addMouseMotionListener(new krishna());
}



public void paintComponent(Graphics gf)
{

super.paintComponent(gf);
for(int t=0;t<=co;t++)
{
sha[t].draw(gf);


}
}
void set_current_shape(int w)
{
type=w;
}
int  get_current_shape()
{
return type;
}
int get_total_shapes()
{
return co;

}
void set_filled(boolean df)
{
fill=df;
}
boolean get_filled()
{
return fill;
}
void setcolor(Color ds)
{
clr=ds;
}
Color getcolor()
{
return clr;	
}
void clear_last_shape()
{

if(co==-1)
{

}
else
{

co=co-1;
System.out.println("after removing");
repaint();
}
}
void redo()
{
if(co<=temp)
{
	co++;
	repaint();
}
}

void clear_drawing()
{
co=-1;
temp=-1;
repaint();
}

class krishna extends MouseAdapter implements MouseMotionListener
{
			public void mousePressed(MouseEvent e)
			{

			if(type==0)
			shape=new MyLine();
			else if(type==1)
			shape=new MyOval();
			else
			shape=new MyRectangle();
			System.out.println("output is coming");

			p1=e.getPoint();

			System.out.println("hai  from pressing");

			}
			public void mouseReleased(MouseEvent e1)
			{
			p2=e1.getPoint();
			
			shape.setval(p1.x,p1.y,p2.x,p2.y,clr,fill);
			co+=1;
			temp=temp+1;
			sha[co]=shape;

			shape=null;
			System.out.println("hai  from released");
			repaint();


			}
			public void mouseMoved(MouseEvent e2)
			{
			p3=e2.getPoint();
			String ds=p3.toString();
			sl.setText(ds);
			System.out.println("hai  from moving");
			}
			public void mouseDragged(MouseEvent e3)
			{
			p2=e3.getPoint();
			String ds=p2.toString();
			sl.setText(ds);

			System.out.println("hai from dragging");
			}

			}



}

