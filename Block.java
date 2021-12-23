import java.awt.Polygon;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.util.Optional;
import java.util.List;

public class Block extends GamePiece {
  public Block(Point inLoc){
    super(inLoc, 25, 5.0);
  }
  
  @Override
  public void paint(Graphics g){

    Polygon tPoly = new Polygon();
    tPoly.addPoint((int)(xLoc + 20*Math.cos(Math.toRadians(rot+45))),     (int)(yLoc + 20*Math.sin(Math.toRadians(rot+45))));
    tPoly.addPoint((int)(xLoc + 20*Math.cos(Math.toRadians(rot+180-45))), (int)(yLoc + 20*Math.sin(Math.toRadians(rot+180-45))));
    tPoly.addPoint((int)(xLoc + 20*Math.cos(Math.toRadians(rot+180+45))), (int)(yLoc + 20*Math.sin(Math.toRadians(rot+180+45))));
    tPoly.addPoint((int)(xLoc + 20*Math.cos(Math.toRadians(rot-45))),     (int)(yLoc + 20*Math.sin(Math.toRadians(rot-45))));

    g.setColor(Color.cyan);
    g.fillPolygon(tPoly);
    g.setColor(Color.black);
    g.drawPolygon(tPoly);    
  }
}
