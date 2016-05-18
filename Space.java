import sofia.micro.*;
import sofia.util.*;

//-------------------------------------------------------------------------
/**
 *  The space class is the world class being used.
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (2016.04.26)
 */
public class Space extends World
{
    //~ Fields ................................................................

    private int theHeight;
    
    private int theWidth;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Space object.
     */
    public Space()
    {
        this(800, 600);
        populate();
    }

    /**
     * Creates a new Space object
     * @param height   the height of the world
     * @param width    the width of the world
     */
    public Space(int width, int height)
    {
        super(width, height, 1);
        theHeight = height;
        theWidth = width;
    }

    //~ Methods ...............................................................
    
    /**
     * populates the space with 5 asteroids and a ship
     */
    public void populate()
    {
        this.add(new Ship(0, -90), theWidth / 2, theHeight / 2);
        // make the ship face North
        
        
        for (int i = 0; i < 5; i++)
        {
            int speed = Random.generator().nextInt(4) + 1;
            int orientation =  Random.generator().nextInt(359);
            Asteroid rock = new Asteroid(speed, orientation);
            // set orientation of rock
            
            
            int y = Random.generator().nextInt(theHeight);
            int x = Random.generator().nextInt(theWidth);
            this.add(rock, x, y);
        }
    }

}
