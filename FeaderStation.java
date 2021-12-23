import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class FeaderStation implements FieldElement{
  Point loc;
  char rot;


  public FeaderStation(Point inLoc, char inRot){
    loc = inLoc;
    rot = inRot;
  }

  @Override
  public void provideGamePiece() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void recieveGamePiece() {
    //do nothing    
  }

  @Override
  public void paint(Graphics g) {
    int inv = 5;
    if(rot == 'u' || rot == 'r')
      inv = -5;
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

    if(rot == 'u' || rot == 'd'){
      x = 50; y = 15+inv;
    } else {
      x = -15-inv; y = -50;
    } 
    g.setColor(Color.green);
    g.fillRect(loc.x+x, loc.y-y, 50, 50);
    g.setColor(Color.BLACK);
    g.drawRect(loc.x+x, loc.y-y, 50, 50);
  }
}
