import java.awt.Polygon;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.util.Optional;
import java.util.List;

public class Robot {
  double xLoc;
  double yLoc;
  double rot;

  Trio<Polygon,Color,Color> arrowPoly;

  public Robot(Point inLoc, int inRot){
    xLoc = inLoc.x;
    yLoc = inLoc.y;
    rot = inRot;
    setupSprite();
  }

  private void setupSprite(){

    Polygon tPoly = new Polygon();
    tPoly.addPoint((int)(xLoc + 50*Math.cos(Math.toRadians(rot+35))), (int)(yLoc + 50*Math.sin(Math.toRadians(rot+35))));
    tPoly.addPoint((int)(xLoc + 50*Math.cos(Math.toRadians(rot+180-35))), (int)(yLoc + 50*Math.sin(Math.toRadians(rot+180-35))));
    tPoly.addPoint((int)(xLoc + 50*Math.cos(Math.toRadians(rot+180+35))), (int)(yLoc + 50*Math.sin(Math.toRadians(rot+180+35))));
    tPoly.addPoint((int)(xLoc + 50*Math.cos(Math.toRadians(rot-35))), (int)(yLoc + 50*Math.sin(Math.toRadians(rot-35))));
    arrowPoly = new Trio<Polygon,Color,Color>(tPoly, Color.red, Color.black);
  }

  private void moveRob(Optional<Character> keyPressed, List<FieldElement> field){
    double xLocTemp, yLocTemp;
    if(keyPressed.isPresent()){
      if(keyPressed.get() == 'u'){
        xLocTemp = xLoc; yLocTemp = yLoc;
        xLoc -= 0.2*Math.cos(Math.toRadians(rot));
        yLoc -= 0.2*Math.sin(Math.toRadians(rot));
      } else if(keyPressed.get() == 'd'){
        xLocTemp = xLoc; yLocTemp = yLoc;
        xLoc += 0.2*Math.cos(Math.toRadians(rot));
        yLoc += 0.2*Math.sin(Math.toRadians(rot));
      } else if(keyPressed.get() == 'r'){
        rot += 0.1;
      } else if(keyPressed.get() == 'l'){
        rot -= 0.1;
      }
      if(rot > 360){
        rot -= 360;
      } else if ( rot < 0){
        rot += 360;
      }
    }
    setupSprite();
  }

  public void paint(Graphics g, Optional<Character> keyPressed, List<FieldElement> field){
    g.setColor(arrowPoly.getMiddle());
    g.fillPolygon(arrowPoly.getLeft());
    g.setColor(arrowPoly.getRight());
    g.drawPolygon(arrowPoly.getLeft());

    moveRob(keyPressed, field);
  }
}
