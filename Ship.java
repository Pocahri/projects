package asteroids;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends Polygon implements KeyListener
{
    public boolean foward=false;
    public boolean left=false;
    public boolean right=false;
    //public int acceleration;
    
    public Ship(Point[] s, Point p, double r)
    {
        super(s,p,r);
    }
    public void move()
    {
        if(foward)
        {
            position.y=position.y+2*Math.sin(Math.toRadians(rotation));
            position.x=position.x+2*Math.cos(Math.toRadians(rotation));
             
            //wrapping the ship around
            if(position.y>600)
                position.y=0;         
            else if(position.y<0)
                position.y=600;
            
            if(position.x>800)
                position.x=0;
            else if(position.x<0)
                position.x=800;
            
        }
        if(left)
        {
            rotation=rotation-2.5;
        }
        if(right)
        {
            rotation=rotation+2.5;
        }
        
    }
    public void paint(Graphics brush)
    {
        brush.setColor(Color.white);
        brush.drawPolygon(Polygon.getX(this.getPoints()), Polygon.getY(this.getPoints()), this.getPoints().length);
    }
    public void keyPressed(KeyEvent e)
    {
        int keyCode=e.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_UP:
                foward=true;
                break;
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                break;
        
        }
    }
    public void keyReleased(KeyEvent e)
    {
        int keyCode=e.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_UP:
                foward=false;
                break;
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
        }
    }
    public void keyTyped(KeyEvent e)
    {
        //not being used.
    }
}