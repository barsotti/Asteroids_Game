import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The bullet class is used to shoot the asteroids
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (2016.04.26)
 */
public class Bullet extends Actor
{
    //~ Fields ................................................................

    private int theSpeed;
    
    //private int theRotation;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bullet object.
     */
    public Bullet()
    {
        this(10, 0);
    }


    /**
     * creates a new Bullet object
     * @param speed   the speed of the bullet
     * @param rotation   the rotation of the bullet
     */
    public Bullet(int speed, int rotation)
    {
        theSpeed = speed;
        
        //theRotation = rotation;
        turn(rotation);
    }
    
    //~ Methods ...............................................................


    /**
     * returns the speed of the bullet
     * @return theSpeed  the speed of the bullet
     */
    public int getSpeed()
    {
        return theSpeed;
    }
    
    /**
     * removes the bullet if it goes too far
     */
    public void goAway()
    {
        int y = getGridY();
        int x = getGridX();
        // if it touches edge, remove itself
        if (x <= 0 || x >= getWorld().getWidth() - 1)
        {
            remove();
        }
        else if (y <= 0 || y >= getWorld().getHeight() - 1)
        {
            remove();
        }
        else if (getIntersectingObjects(Asteroid.class).size() != 0)
        {
            Asteroid asteroid = getWorld().getOneObjectAt(x, y, Asteroid.class);
            getWorld().remove(asteroid);
            remove();
        }
    }
     
    /**
     * does what the bullet does
     */
    public void act()
    {
        move(getSpeed());
        goAway();

    }
}
