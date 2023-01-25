import java.awt.*;
import java.awt.image.BufferedImage;

public class Watcher {
    private final int X = 490, Y = 875, W = 320, H = 1;
    private final int HEART = -60653, NO_HEART = -14145496, DEAD = -10999511;
    private Rectangle bounds;
    private Robot robot;

    public Watcher(){
        bounds = new Rectangle(X,Y,W,H);
        try {
            robot = new Robot();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public BufferedImage screenshot(){
        return robot.createScreenCapture(bounds);
    }

    public int getHealth() throws NoHeartsException{
        BufferedImage img = screenshot();
        int health = 0;
        for(int i = 0; i < 20; i++){
            int color = img.getRGB(16*i+5,0);
            if(color == HEART)
                health++;
            else if (color == DEAD)
                return 0;
            else if(color != NO_HEART)
                throw new NoHeartsException();
        }
        return health;
    }
}
