import java.awt.*;

public class Platform extends Hitbox
{
    private Color myColor;
    
    public Platform(int x, int y, int xLength, int yLength)
    {
        super(x, y, xLength, yLength);
        myColor = Color.blue;
    }
    
    public void draw(Graphics myBuffer) 
    {
        myBuffer.setColor(myColor);
        myBuffer.fillRect(myX, myY, myXLength, myYLength);
    }
}