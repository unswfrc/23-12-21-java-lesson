import java.awt.Polygon;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.util.Optional;

public class Arrow {
  char dir;
  Point loc;
  Trio<Polygon,Color,Color> arrowPoly;
  public Arrow(char inDir, Point inLoc){
    dir = inDir;
    loc = inLoc;
    setupSprite(Optional.empty());
  }

  private void setupSprite (Optional<Character> keyPressed){
    int[] xPoints = {30,60,45,45,15,15,0};
    int[] yPoints = {0,30,30,60,60,30,30};

    int inver = 1;
    if(dir == 'r' || dir == 'd'){
      inver = -1;
    }

    if(dir == 'r' || dir == 'l'){
      int[] t = yPoints;
      yPoints = xPoints;
      xPoints = t;
    }

    Polygon tPoly = new Polygon();
    for(int i = 0; i < xPoints.length; i++){
      tPoly.addPoint(loc.x+xPoints[i]*inver-30*inver, loc.y+yPoints[i]*inver-30*inver);
    }
    arrowPoly = new Trio<Polygon,Color,Color>(tPoly, Color.LIGHT_GRAY, Color.black);
    if(keyPressed.isPresent() && keyPressed.get() == dir){
      arrowPoly.setMiddle(Color.yellow);
    }
  }
  public void paint(Graphics g, Optional<Character> keyPressed){
    g.setColor(arrowPoly.getMiddle());
    g.fillPolygon(arrowPoly.getLeft());
    g.setColor(arrowPoly.getRight());
    g.drawPolygon(arrowPoly.getLeft());

    setupSprite(keyPressed);
  }
}
