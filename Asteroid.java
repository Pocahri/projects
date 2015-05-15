package asteroids;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Asteroid extends Polygon
{
    protected boolean foward=true;
    
    public Asteroid(Point[] s, Point p, double r)
    {
        super(s,p,r);
    }
    public void paint(Graphics brush)
    {
        brush.setColor(Color.white);
        brush.drawPolygon(Polygon.getX(this.getPoints()), Polygon.getY(this.getPoints()), this.getPoints().length);
    }
    public void smallMove()
    {
        if(foward)
        {
            position.y+=.5+Math.sin(Math.toRadians(rotation));
            position.x+=1+Math.cos(Math.toRadians(rotation));
            
            //wrapping the asteroid around
            if(position.y>600)
                position.y=0;         
            else if(position.y<0)
                position.y=600;
            
            if(position.x>800)
                position.x=0;
            else if(position.x<0)
                position.x=800;
        }
    }
    public void bigMove()
    {
        if(foward)
        {
            position.y+=.5;
            position.x+=.5;
            position.y+=Math.sin(Math.toRadians(rotation));
            position.x+=Math.cos(Math.toRadians(rotation));
            
            //wrapping the asteroid around
            if(position.y>600)
                position.y=0;         
            else if(position.y<0)
                position.y=600;
            
            if(position.x>800)
                position.x=0;
            else if(position.x<0)
                position.x=800;
        }
    }
    
}