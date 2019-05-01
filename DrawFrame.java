
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.*;

public class DrawFrame extends JFrame
{
	
	Color c[]={Color.black,Color.green,Color.yellow,Color.orange,Color.red,Color.BLUE,Color.pink,Color.gray,Color.cyan,
			Color.darkGray,Color.lightGray,Color.magenta,Color.white};
			String[] all={"black","green","yellow","orange","red","blue","pink","grey","cyan","darkGrey","lightGrey","magenta","white"};
			String[] all_shapes={"Line","Circle","Rectangle"};
			int kr[]={0,1,2};
int nu=0;

int count =0;
rama rkr;
JLabel l;
JButton b,b1,b2,b3;
JComboBox c1,c2;
JCheckBox jc;
JPanel p,p1;
void setrama(rama r)
{
rkr=r;
}
rama getrama()
{
return rkr;
}
void setbuttons(JButton ba,JButton bu,JButton bau,JButton bua)
{
	b=ba;
	
		
	b1=bu;
	b2=bau;
	b3=bua;
}
JButton getb()
{
return b;	
}
JButton getb1()
{
return b1;	
}
JButton getb2()
{
return b2;	
}
JButton getb3()
{
return b3;	
}

void setp(JPanel pt)
{
p=pt;
}
void setp1(JPanel pt)
{
p1=pt;
}
JPanel getp()
{
	return p;
}
JPanel getp1()
{
	return p1;
}

void setc1(JComboBox s)
{
	c1=s;
}

void setc2(JComboBox s)
{
	c2=s;
}
JComboBox getc1()
{
return c1;
}
JComboBox getc2()
{
return c2;
}
void setjc(JCheckBox s)
{
	jc=s;
}
JCheckBox getjc()
{
	return jc;
}
DrawFrame()
{
l=new JLabel("Let's Draw");
rkr=new rama(l);
setrama(rkr);
b3=new JButton("Save Drawing");
p1=new JPanel();
b=new JButton("Undo");
b1=new JButton("Clear");
b2=new JButton("Redo");
jc=new JCheckBox("fill");
c1=new JComboBox(all);
c2=new JComboBox(all_shapes);
p=new JPanel();
setp(p);
setbuttons(b,b1,b2,b3);
setjc(jc);



b.addActionListener(new rk());
b1.addActionListener(new rk());
b2.addActionListener(new rk());
b3.addActionListener(new rk());

p.add(b);
p.add(b2);
p.add(b1);
c1.addItemListener(new rk());
c2.addItemListener(new rk());
jc.addItemListener(new rk());
p.add(c1);
p.add(c2);
p.add(jc);
p1.setLayout(new GridLayout(1,2,30,0));
p1.add(l);
p1.add(b3);
add(p,BorderLayout.NORTH);
add(rkr,BorderLayout.CENTER);
add(p1,BorderLayout.SOUTH);
setVisible(true);
setSize(700,700);
setDefaultCloseOperation(3);
}
class rk implements ActionListener,ItemListener
{
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b)
{
rkr.clear_last_shape();


}
else if(e.getSource()==b3)
{
try
{

 BufferedImage im=new BufferedImage(rkr.getWidth(),rkr.getHeight(),BufferedImage.TYPE_INT_RGB);
rkr.paint(im.getGraphics());
File f=new File("rama_krishna.jpg");
Date d=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_hh_mm_aa");
String tt=sdf.format(d).concat(".png");
ImageIO.write(im,"png",new File(tt));
System.out.println(tt);
}
catch(Exception ee)
{
	ee.printStackTrace();
}
}
else if(e.getSource()==b2)
{
rkr.redo();
}
else 
{

rkr.clear_drawing();
}
}
public void itemStateChanged(ItemEvent e)
{
						if(e.getSource()==jc)
						{
							if(nu==0)
							{
							nu=1;
							rkr.set_filled(true);
							}
							else
							{
							nu=0;
							rkr.set_filled(false);

							}
						}
						else if(e.getSource()==c1)
						{


							if(e.getStateChange()==ItemEvent.SELECTED)
							{
							Color gg=c[c1.getSelectedIndex()];
							rkr.setcolor(gg);
							}
							}





							else
							{
							if(e.getStateChange()==ItemEvent.SELECTED)
							{

							rkr.set_current_shape(kr[c2.getSelectedIndex()]);
							}
						}
}
}

public static void main(String[] ar)

{
new DrawFrame();
}
}





