import javax.swing.*;

public class PlatformerDriver 
{
    public static final int FRAME = 600;
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Platformer");
        frame.setSize(FRAME, FRAME);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	
        PlatformerPanel p = new PlatformerPanel();
        frame.setContentPane(p);
        p.requestFocus();
      
        frame.setVisible(true);
    }
}