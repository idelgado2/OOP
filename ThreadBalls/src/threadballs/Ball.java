
package threadballs;
import java.awt.*;
/**
 *
 * @author Isaac
 */
public class Ball{
    int x, y, width, height; // Use an rectangle for illustration
    Color color; // Color of the object
    
    public Ball(int x, int y, int width, int height, Color color) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = color;
   }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height); // Fill a oval
    }
    
}