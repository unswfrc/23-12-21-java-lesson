import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Optional;

class Main extends JFrame {
    
  class App extends JPanel implements KeyListener {
    Optional<Character> keyPressed = Optional.empty();
    Stage s = new Stage();

    public App() {
      setPreferredSize(new Dimension(1024, 720));
      setFocusable(true);
      addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
      s.paint(g, keyPressed);
      if(keyPressed.isPresent()){
      }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_LEFT){
        keyPressed = Optional.of('l');
      } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
        keyPressed = Optional.of('r');
      } else if (e.getKeyCode() == KeyEvent.VK_UP){
        keyPressed = Optional.of('u');
      } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
        keyPressed = Optional.of('d');
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      keyPressed = Optional.empty();
    }
  }

  public static void main(String[] args) throws Exception {
    Main window = new Main();
    window.run();
  }

  private Main() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    App canvas = new App();
    this.setContentPane(canvas);
    this.pack();
    this.setVisible(true);
  }

  public void run() {
    while (true) {
      this.repaint();
    }
  }
}