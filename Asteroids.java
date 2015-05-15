package asteroids;
import java.lang.Math;
import java.util.Random;
import javax.swing.JOptionPane;
import java.lang.Thread;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
*/
import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

class Asteroids extends Game 
{
    //static int counter = 0;
    public boolean ifCollision=false;
    
    public Asteroids() 
    {
        super("Asteroids!",800,600);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(s1);
    }
    
    Random r1=new Random();
    int life=3;
    //Ship
    Point p1=new Point(0,0);
    Point p2=new Point(-15,15);
    Point p3=new Point(-15, -15);
    Point[] p4={p1,p2,p3};
            
    Ship s1=new Ship(p4, new Point(400,300), 0);
    
    //Asteroid
    Point[] p5={new Point(0,0), new Point(-10, -5), new Point(-10, -15), new 
            Point(-16, -20), new Point(-4, -25), new Point(6, -25), new 
            Point(16,-20), new Point(15, -10)}; //small asteroid 1
    
    //small asteroid 2. 3 point is different
    Point[] p6={new Point(0,0), new Point(-10, -5), new Point(-5, -15), new 
            Point(-16, -20), new Point(-4, -25), new Point(6, -25), new 
            Point(16,-20), new Point(15, -10)}; 
   
    Point[] p7={new Point(0,0), new Point(-20, -10), new Point(-20, -30), new 
            Point(-32, -40), new Point(-8, -50), new Point(12, -50), new 
            Point(32,-40), new Point(30, -20)};//big asteroid 1
    
    Point[] p8={new Point(0,0), new Point(-20, -10), new Point(-10, -30), new 
            Point(-32, -40), new Point(-8, -50), new Point(12, -50), new 
            Point(32,-40), new Point(30, -20)};
    
    //Point pos=new Point(r1.nextInt(800)+1, r1.nextInt(600)+1);
    
    Asteroid a1=new Asteroid(p5, new Point(r1.nextInt(800)+1, r1.nextInt(600)+1)
            , r1.nextInt(360));
    Asteroid a2=new Asteroid(p6, new Point(r1.nextInt(800)+1, r1.nextInt(600)+1)
            , r1.nextInt(360));
    Asteroid a3=new Asteroid(p7, new Point(r1.nextInt(800)+1, r1.nextInt(600)+1)
            , r1.nextInt(360));
    Asteroid a4=new Asteroid(p8, new Point(r1.nextInt(800)+1, r1.nextInt(600)+1)
            , r1.nextInt(360));
    Asteroid a5=new Asteroid(p6, new Point(r1.nextInt(800)+1, r1.nextInt(600)+1)
            , r1.nextInt(360));
    Asteroid a6=new Asteroid(p7, new Point(r1.nextInt(800)+1, r1.nextInt(600)+1)
            , r1.nextInt(360));
   
            
    public void paint(Graphics brush) 
    {
        brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	
        //counter++;
    	brush.setColor(Color.white);
    	//brush.drawString("Counter is " + counter,10,10);
        
        //Displays the number of lives
        brush.drawString("Lives: " + life,10,10);
        
        if(life==0)
        {
            Object[] options={"OK"};
            JOptionPane.showOptionDialog(null,"You died!","Inevitable Death",
                   JOptionPane.PLAIN_MESSAGE,JOptionPane.WARNING_MESSAGE,
                   null,options,options[0]);
            System.exit(0);
        }
        
        if(ifCollision)
        {
            try
            {
                Thread.sleep(1000);
                
            }
            catch(Exception exc)
            {
                //empty   
            }
            
            ifCollision=false;
        }
        
        //Draw and move SHIP
        s1.paint(brush);
        s1.move();
        
        //Draw and move ASTEROID
        a1.paint(brush);
        a1.smallMove();
        a2.paint(brush);
        a2.smallMove();
        a3.paint(brush);
        a3.bigMove();
        a4.paint(brush);
        a4.bigMove();
        a5.paint(brush);
        a5.smallMove();
        a6.paint(brush);
        a6.bigMove();
      
        
        //Check Collison
        if(s1.checkCollision(a1.position))
        {
            life--;
            s1.position=(new Point(400,300));
            s1.rotation=0;
            ifCollision=true;
            
            if(life!=0)
                brush.drawString("You lost a life!", 350, 250);   
        }
        else if(s1.checkCollision(a2.position))
        {
            life--;
            s1.position=(new Point(400,300));
            s1.rotation=0;
            ifCollision=true;
            
            if(life!=0)
                brush.drawString("You lost a life!", 350, 250);
        }
        else if(s1.checkCollision(a3.position))
        {
            life--;
            s1.position=(new Point(400,300));
            s1.rotation=0;
            ifCollision=true;
            
            if(life!=0)
                brush.drawString("You lost a life!", 350, 250);
        }
        else if(s1.checkCollision(a4.position))
        {
            life--;
            s1.position=(new Point(400,300));
            s1.rotation=0;
            ifCollision=true;
            
            if(life!=0)
                brush.drawString("You lost a life!", 350, 250);        
        }
        else if(s1.checkCollision(a5.position))
        {
            life--;
            s1.position=(new Point(400,300));
            s1.rotation=0;
            ifCollision=true;
            
            if(life!=0)
                brush.drawString("You lost a life!", 350, 250);           
        }
        
        else if(s1.checkCollision(a6.position))
        {
            life--;
            s1.position=(new Point(400,300));
            s1.rotation=0;
            ifCollision=true;
            
            if(life!=0)
                brush.drawString("You lost a life!", 350, 250);
      
        }          
  }
    public static void main (String[] args) 
    {
        Asteroids a = new Asteroids();
	a.repaint();
    }
}