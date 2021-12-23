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
    rot = 0;
    speed = 0.0;
    friction = inFriction;
  }

  public void bounce(Robot robt){
    double dist = Math.sqrt(Math.pow(xLoc-robt.xLoc, 2) + Math.pow(yLoc-robt.yLoc, 2));
    if(dist < 50){
      rot = (int)Math.toDegrees(Math.atan((robt.yLoc-yLoc)/(robt.xLoc-xLoc)))-180;
      System.out.println(rot);
      speed = 10.0;

    }
    
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
    xLoc += 0.01*speed*Math.cos(Math.toRadians(rot));
    yLoc += 0.01*speed*Math.sin(Math.toRadians(rot));
  }

  public void release(double inSpeed, int inRot){
    speed = inSpeed;
    rot = inRot;
  }

  public void paint(Graphics g){
    move();
    decelerate();
  }
}
