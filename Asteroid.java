import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The asteroid class is the hazard in the game
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (2016.04.26)
 */
public class Asteroid extends Actor
{
    //~ Fields ................................................................

    private int theSpeed;
    
    //private int Rotation;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Asteroid object.
     */
    public Asteroid()
    {
        //this(0, 0);
        //turn(Rotation);
        /*# this is empty */
    }

    /**
     * creates a new Asteroid object
     * @param speed   the speed of the asteroid
     * @param rotation   the rotation of the asteroid
     */
    public Asteroid(int speed, int rotation)
    {
        theSpeed = speed;
        
        //Rotation = rotation;
        turn(rotation);
    }
    //~ Methods ...............................................................

    /**
     * returns the speed of the asteroid
     * @return Speed    the speed of the asteroid
     */
    public int getSpeed()
    {
        return theSpeed;
    }
    
    /**
     * wraps the asteroid to the other side of the world
     */
    public void wrapAround()
    {
        // if goes off map
        int y = getGridY();
        int x = getGridX();
        // if it touches edge, wrap to other side
        if (x <= 0)
        {
            setGridX(getWorld().getWidth() - 1);
        }
        else if (x >= getWorld().getWidth() - 1)
        {
            setGridX(0);
        }
        if (y <= 0)
        {
            setGridY(getWorld().getHeight() - 1);
        }
        else if (y >= getWorld().getHeight() - 1)
        {
            setGridY(0);
        }
                
    }
   
    
    /**
     * the act method that asteroid will do
     */
    public void act()
    {
        this.move(getSpeed());
        this.wrapAround();
        //this.goAway();
    }
    
}
