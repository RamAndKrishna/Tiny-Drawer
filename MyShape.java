
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public abstract class MyShape extends JPanel
{
 boolean fil=false;
 int x1,y1,x2,y2;
 Color c1;

MyShape()
{
x2=0;
x1=y1=y2=x2;
c1=Color.black;

}

public void setval(int a,int b,int c,int d,Color c2,boolean df)
{
x1=a;
y1=b;
x2=c;
y2=d;
c1=c2;
fil=df;
}
public int getx1()
{
return x1;
}
public int gety1()
{
return y1;
}
public int getx2()
{
return x2;
}
public int gety2()
{
return y2;
}
public Color getc1()
{
return c1;
}
public void setfil(boolean ds)
{
fil=ds;
}
public boolean getfill()
{
return fil;
}
public void draw(Graphics g)
{
}
}




