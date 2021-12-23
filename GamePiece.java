import java.awt.Point;
import java.awt.Graphics;

public class GamePiece {
  double xLoc, yLoc;
  int rot;
  int score;
  double speed;
  double friction;

  public GamePiece(Point inLoc, int inScore, double inFriction){
    xLoc = inLoc.x;
    yLoc = inLoc.y;
    score = inScore;
    speed = 0.0;
    friction = inFriction;
  }

  public void decelerate(){
    if(speed > 0){
      speed -= friction;
    }
    if(speed < 0){
      speed = 0;
    }
  }

  public void move(){
    xLoc += 0.2*Math.cos(Math.toRadians(rot));
    yLoc += 0.2*Math.sin(Math.toRadians(rot));
  }

  public void release(double inSpeed, int inRot){
    speed = inSpeed;
    rot = inRot;
  }

  public void paint(Graphics g){
    System.out.println("something went wrong");
  }
}
