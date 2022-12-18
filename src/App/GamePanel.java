package App;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel
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

        public GamePanel()
        {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //Sets the size of the JPanel class
            this.setBackground(Color.BLACK); //Sets background
            this.setDoubleBuffered(true); //If set to true, all the drawings from this component will be done in an offscreen painting buffer. Enabling this can improve the game's rendering performance.

        }
}
