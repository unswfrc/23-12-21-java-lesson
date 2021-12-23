import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Graphics;

public class Stage {
  List<Arrow> arrows;
  Robot robt;
  List<FieldElement> field;
  List<GamePiece> element;

  public Stage(){
    arrows = new ArrayList<Arrow>();
    arrows.add(new Arrow('l', new Point(855,680)));
    arrows.add(new Arrow('r', new Point(985,680)));
    arrows.add(new Arrow('u', new Point(920,610)));
    arrows.add(new Arrow('d', new Point(920,680)));

    field = new ArrayList<FieldElement>();
    field.add(new FeaderStation(new Point(200, 650), 'u'));
    field.add(new FeaderStation(new Point(650, 650), 'u'));
    field.add(new Wall(new Point(350,650), 'u'));
    field.add(new Wall(new Point(500,650), 'u'));

    field.add(new Wall(new Point(800,500), 'l'));
    field.add(new Wall(new Point(800,350), 'l'));
    field.add(new Wall(new Point(800,200), 'l'));
    field.add(new Wall(new Point(800,50), 'l'));

    field.add(new Wall(new Point(180,500), 'r'));
    field.add(new Wall(new Point(180,350), 'r'));
    field.add(new Wall(new Point(180,200), 'r'));
    field.add(new Wall(new Point(180,50), 'r'));

    field.add(new Goal(new Point(200,30), 'd'));
    field.add(new Goal(new Point(650,30), 'd'));
    field.add(new Wall(new Point(350,30), 'd'));
    field.add(new Wall(new Point(500,30), 'd'));

    robt = new Robot(new Point(500, 600), 90);

    element = new ArrayList<GamePiece>();
    element.add(new Ball(new Point(100,400)));
    element.add(new Block(new Point(100,400)));

  }

  public void paint(Graphics g, Optional<Character> keyPressed){
    for(Arrow a : arrows){
      a.paint(g, keyPressed); //task 1 make this line
    }

    for(FieldElement f : field){
      f.paint(g);
    }

    robt.paint(g, keyPressed, field);

    for(GamePiece gp : element){
      gp.paint(g);
    }
  }
}
