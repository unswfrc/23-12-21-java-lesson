import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GamePiece{
  public Ball(Point inLoc){
      super(inLoc, 25, 0.5);
  }
  
  @Override
  public void paint(Graphics g){
    g.setColor(Color.cyan);
    g.fillOval((int)xLoc, (int)yLoc, 20, 20);
    g.setColor(Color.black);
    g.drawOval((int)xLoc, (int)yLoc, 20, 20);
  }
}
