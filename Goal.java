import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class Goal implements FieldElement {
  Point loc;
  char rot;

  public Goal(Point inLoc, char inRot){
    loc = inLoc;
    rot = inRot;
  }

  @Override
  public void provideGamePiece() {
    // do nothing
    
  }

  @Override
  public void recieveGamePiece() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void paint(Graphics g) {
    int inv = 10;
    if(rot == 'u' || rot == 'r')
      inv = -10;
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

    int a = 0, b = 0;
    if(rot == 'u' || rot == 'd'){
      a = -x/3;       b = -5+inv;
    } else {
      a = -5-inv;  b = (int)(-2.5*x);
    } 
    g.setColor(Color.green);
    g.fillRect(loc.x+x/2+a, loc.y+y/2+b, x*2/3, y*2/3);
    g.setColor(Color.BLACK);
    g.drawRect(loc.x+x/2+a, loc.y+y/2+b, x*2/3, y*2/3);
  }
}
