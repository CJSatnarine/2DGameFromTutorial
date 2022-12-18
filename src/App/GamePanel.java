package App;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable
{
    //Screen settings
    final int originalTileSize = 16; //16x16 tiles
    final int scale = 3; //Used to set the scale.

    final int tileSize = originalTileSize * scale; //scaling the 16x16 pixel sprites bigger.

    //How many tiles can be displayed on a single screen horizontally and vertically? 
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Set player's default position and speed.
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //Sets the size of the JPanel class
        this.setBackground(Color.BLACK); //Sets background
        this.setDoubleBuffered(true); //If set to true, all the drawings from this component will be done in an offscreen painting buffer. Enabling this can improve the game's rendering performance.
        this.addKeyListener(keyH); //The game panel can recognise the key input
        this.setFocusable(true); //With this, the GamePanel can be "focused" to receive key input
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        double drawInterval = 1000000000/FPS;

        //nanoTime returns the current value of the running JVM high-resolution time source in nanoseconds 
        double nextDrawTime = System.nanoTime() + drawInterval;

        //Creating the game loop
        while (gameThread != null)
        {
            // 1. UPDATE: update information such as character positions
            update();

            //DRAW: draw the screen with the updated information
            repaint();

            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000; //Converting from nanoseconds into miliseconds
                
                if (remainingTime < 0)
                {
                    remainingTime = 0; 
                }
                
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            
            }  
            catch (InterruptedException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void update()
    {
        //In Java, the upper left corner is X:0, Y:0.
        //X Values increases to the right.
        //Y values increases as they go down. 
        if (keyH.upPressed)
        {
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed)
        {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed)
        {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed)
        {
            playerX += playerSpeed;
        }
    }

     //Standard method to draw things on JPanel
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        /* Graphics2D class extends the Graphics class to privide more 
        * sophisticated control over geometry, coordinate transformations, 
        * colour management, and text layout. 
        */
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose(); //Dispose of this graphics context and release any system resources that it is using.
            
    }
}
