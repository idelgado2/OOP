/*************************************************************************
 * Assignment_7(MAINWINDOW)
 * Isaac Delgado
 * COSC3324
 * 11/14/2016
 * Purpose: Is to demonstrate concurrency but drawing bouncing balls each
 *          being run by a different thread
 *
 * Attributes: This class consist of two inner classes (DrawPanel & Creation)
 *              Drawpanel class is used for drawing each ball, while creation
 *              is utilized by the mouse event to execute drawpanel's
 *              paintcomponent.
 **************************************************************************/
package Assignment_7;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Isaac
*/

public class MainWindow {
    
    private int posX = 100 , posY = 100, ballWidth = 100, ballHeight = 100;
    private int radius = ballWidth / 2; //used for bouncing off walls
    private int rateX = 5, rateY = 3; //rate at which the ball moves 
    private int numOfBalls = 1; //keep track of how many created balls, start with 1 (intial ball)
    private boolean run = true; //for drawing loop
    private int flip = 0; //to keep track of space bar presses
    
    JFrame frame;
    Ball initBall = new Ball(posX, posY, ballWidth, ballHeight, Color.blue);
    DrawPanel panel = new DrawPanel(initBall);
    
    MainWindow(){
        frame = new JFrame();
        frame.setSize(650, 650);
        frame.setTitle("Please click on the screen!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.add(panel);
        frame.addMouseListener(new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt){
              formMouseClicked(evt);
          }  
        });
        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        
        frame.setVisible(true);
        position(initBall, posX, posY, rateX, rateY, radius); //ball positioning function
        
    }
    
    private void formKeyPressed(java.awt.event.KeyEvent evt){
        int key = evt.getKeyCode();
        if(key == KeyEvent.VK_SPACE){   //space bar
            //pause all threads while loop here
            if(flip == 0){ //if annimation is dynamic
                run = false; //stop animation
                flip = 1; //animation is now still
            }else{          //else animation is still
                run = true; //start animation
                flip = 0; //animation is now dynamic
            }
        }
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        //when i click I want to create a new Ball on a new thread
        if(numOfBalls < 20){    //this program can only creat up to 20 Balls
            Creation newBall = new Creation();
            ExecutorService threadexe = Executors.newCachedThreadPool(); //create thread pool, I might be creating different pools here?
            threadexe.execute(newBall);    //execute an instance of a Ball with a thread from the pool
            threadexe.shutdown();
            numOfBalls++;
        }else{
            System.out.println("You cannot create anymore Balls");
        }
    }
    
    private void position(Ball ball, int x, int y, int rx, int ry, int rad){
        //position(ball obeject, x-coordinate, y-coordinate, rateOfX, rateOfY, radius)
        while(true){
                        
        while(run){ //infinite loop
                    panel.repaint(ball.x, ball.y, ball.width, ball.height); // Clear old area to background
                    x += rx;
                    y += ry;
                    
                    if(x - rad < 0){
                        rx  *= -1; //change balls direction to opposite
                        x = rad;
                    }else if(x + rad > 650){
                        rx  *= -1;   //change balls direction to opposite
                        x = 650 - rad;
                    }
                    
                    if (y - rad < 0) {
                        ry  *= -1;   //change balls direction to opposite
                        y = rad;
                    } else if (y + rad > 650) {
                        ry  *= -1;   //change balls direction to opposite
                        y = 650 - rad;
                    }
                    
                    ball.x = x;
                    ball.y = y;
                        // Refresh the display
                     panel.repaint(ball.x, ball.y, ball.width, ball.height); // Clear old area to background
                        // Delay for timing control and give other threads a chance
                    try {
                        Thread.sleep(1000 / 50);  // milliseconds
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    panel.setBall(ball); //to make each ball keeps getting re-painted
                }
            Thread.yield(); //Yield current thread when space bar is pressed
        }
    }
    
    class DrawPanel extends JPanel{ //inner class to implement all the drawing
        Ball currentBall;
        DrawPanel(Ball b){
            currentBall = b;
        }
        public void setBall(Ball b){
            currentBall = b;
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            currentBall.draw(g);
        }
    }
    
    public class Creation extends JPanel implements Runnable{ //class that creates the new added ball
        Random rand = new Random();
        float r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        
        Ball ball = new Ball(100, 100, 100, 100, randomColor);
        //panel.setBall(ball);
        Creation(){
            //Ball ball = new Ball(100, 100, 100, 100, Color.red);
            panel.setBall(ball);
        }
        public void run() {
            position(ball, ball.x, ball.y, rateX, rateY, radius);
        }
    }
    
    public static void main(String[] args){
        new MainWindow(); //everything is done by the constructor of this class
    }
                      
}
