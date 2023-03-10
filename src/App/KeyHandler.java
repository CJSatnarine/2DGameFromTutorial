package App;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; //The listener interface for receiving keyboard events (keystrokes).

public class KeyHandler implements KeyListener
{
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    @Override
    public void keyTyped(KeyEvent e) 
    {   
        //Not being used
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int code = e.getKeyCode(); //Returns the integer key keyCode associated with the key in this event
        
        //W key pressed
        if (code == KeyEvent.VK_W)
        {
            upPressed = true;
        }

        //S key pressed
        if (code == KeyEvent.VK_S)
        {
            downPressed = true;
        }

        //A key pressed
        if (code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }

        //D key pressed
        if (code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        int code = e.getKeyCode();
        
        //W key released
        if (code == KeyEvent.VK_W)
        {
            upPressed = false;
        }

        //S key released
        if (code == KeyEvent.VK_S)
        {
            downPressed = false;
        }

        //A key released
        if (code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }

        //D key released
        if (code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
    }   
}
