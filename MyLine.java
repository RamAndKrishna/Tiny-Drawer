

import java.awt.*;
import java.awt.event.*;


public class MyLine extends MyShape
{

MyLine()
{
x2=0;
x1=y1=y2=x2;
c1=Color.black;
}
public void draw(Graphics g)
{
System.out.println("line");
g.setColor(c1);
g.drawLine(x1,y1,x2,y2);
}
}
