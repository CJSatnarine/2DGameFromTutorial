package App;
import javax.swing.JFrame;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //This allows the window to properly close when the user clicks the close/x button. 
        window.setResizable(false); //This checks if the size of the window can be resized.
        window.setTitle("2D Game"); //Sets the title of the window.

        
        //Adds the stuff from GamePanel into the window.
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.setLocationRelativeTo(null); //The null here does not specify the location of the window.
        window.setVisible(true); //This makes the window visible.

        window.pack(); //Causes the window to be sized to fit the preferred size and layout of its subcomponents (=GamePanel)

    }
}
