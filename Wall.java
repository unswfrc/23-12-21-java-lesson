import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class Wall implements FieldElement{
  Point loc;
  char rot;

  public Wall(Point inLoc, char inRot){
    loc = inLoc;
    rot = inRot;
  }

  @Override
  public void provideGamePiece() {
    //do nothing
    
  }

  @Override
  public void recieveGamePiece() {
    //do nothing    
  }

  @Override
  public void paint(Graphics g) {
    int x, y;
    if(rot == 'u' || rot == 'd'){
      x = 150; y = 20;
    } else {
      x = 20; y = 150;
    }
    g.setColor(Color.green);
    g.fillRect(loc.x, loc.y, x, y);
    g.setColor(Color.BLACK);
    g.drawRect(loc.x, loc.y, x, y);
  }
}
