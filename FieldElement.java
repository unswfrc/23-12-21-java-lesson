import java.awt.Graphics;

public interface FieldElement {
  public void provideGamePiece();

  public void recieveGamePiece();

  public void paint(Graphics g);

}
