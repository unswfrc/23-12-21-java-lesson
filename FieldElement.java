import java.awt.Graphics;
import java.awt.Point;

public interface FieldElement {
  public void provideGamePiece();

  public void recieveGamePiece();

  public void paint(Graphics g);

}
