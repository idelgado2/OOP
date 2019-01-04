/*************************************************************************
 * Assignment_7(BALL)
 * Isaac Delgado
 * COSC3324
 * 11/14/2016
 * Purpose: Of this class is to create and draw an oval what will be used
 *          to represent the balls.This class will be executed by the class
 *          MainWindow
 *
 * Attributes: This class consist of the main attributes that are needed for
 *              an oval (spatial coordinates and weight & height of the oval).
 *              additionally this class will include a color attribute
 **************************************************************************/
package Assignment_7;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Isaac
 */
public class Ball {
     public int x, y, width, height; // x&y -> spatial coordinates
     public Color color; // Color of the object
    
    public Ball(int x, int y, int width, int height, Color color) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = color;
   }
    
    public void draw(Graphics g){
        g.setColor(color);  //setcolor to draw wil
        g.fillOval(x, y, width, height); // draw oval with the color
    }
}
