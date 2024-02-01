import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PlatformerPanel extends JPanel
{
    private static final int FRAME = PlatformerDriver.FRAME;
    private static final Color BACKGROUND = new Color(204, 204, 204);
    
    private Player playerCharacter;
    private Platform platformOne;
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Timer t;
    private Timer movement;
    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;
    
    public PlatformerPanel()
    {
        myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        
        playerCharacter = new Player();
        platformOne = new Platform(FRAME / 2 - 50, FRAME / 2 + 100, 100, 20);
        
        movement = new Timer(100, new MovementListener());
        movement.start();
        t = new Timer(10, new EventListener());
        t.start();
        
        addKeyListener(new Keyboard());
        setFocusable(true);
    }
    
    private class Keyboard extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                playerCharacter.jump();
                wPressed = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                playerCharacter.duck();
                sPressed = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                playerCharacter.moveLeft();
                aPressed = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                playerCharacter.moveRight();
                dPressed = true;
            }
        }
        
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                wPressed = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                sPressed = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                aPressed = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                dPressed = false;
            }
        }
    }
    
    private class MovementListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(wPressed)
            {
                playerCharacter.jump();
            }
            if(sPressed)
            {
                playerCharacter.duck();
            }
            if(aPressed)
            {
                playerCharacter.moveLeft();

            }
            else if(dPressed)
            {
                playerCharacter.moveRight();
            }
            else
            {
                playerCharacter.slowDown();
            }
        }
    }
    
    public void paintComponent(Graphics g)
    {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }
    
    private class EventListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0, 0, FRAME, FRAME);
            playerCharacter.move();
            if(playerCharacter.collide(platformOne))
                System.out.println("collide");
            playerCharacter.draw(myBuffer);
            platformOne.draw(myBuffer);
            repaint();
        }
    }
}