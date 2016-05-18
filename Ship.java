import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The ship class represents your ship in space
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (2016.04.26)
 */
public class Ship extends Actor
{
    //~ Fields ................................................................

    private int theSpeed;

    private int theRotation;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ship object.
     */
    public Ship()
    {
        this(0, -90);
    }
    
    /**
     * creates a new ship object
     * @param speed   the speed of the ship
     * @param rotation  the rotation of the ship
     */
    public Ship(int speed, int rotation)
    {
        theSpeed = speed;
        
        theRotation = rotation;
        
        turn(theRotation);
    }

    //~ Methods ...............................................................

    /**
     * returns the speed of the ship
     * @return speed   the speed of the ship
     */
    public int getSpeed()
    {
        return theSpeed;
    }

    /**
     * returns the rotation of the ship
     * @return Rotation   the orientation of the ship
     */
    public int getTheRotation()
    {
        return theRotation;
    }
    
    /**
     * wraps the ship to the other side of the world
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
     * increases the speed of the ship w/ a 6 cap
     */
    public void dpadNorthIsDown()
    {
        if (theSpeed <= 5)
        {
            theSpeed = theSpeed + 1;
        }
    }
    
    /**
     * turns the ship
     */
    public void dpadEastIsDown()
    {
        turn(5);
        theRotation = theRotation + 5;
    }
    
    /**
     * slows down the ship
     */
    public void dpadSouthIsDown()
    {
        if (theSpeed > 0)
        {
            theSpeed = theSpeed - 1;
        }
    }
    
    /**
     * turns the ship
     */
    public void dpadWestIsDown()
    {
        turn(-5);
        theRotation = theRotation - 5;
    }
    
    /**
     * adds a bullet
     */
    public void onScreenTouchDown()
    {
        int rad = theRotation;
        int x = this.getGridX();
        int y = this.getGridY();
        getWorld().add(new Bullet(10, rad), x, y);
    }
    
    /**
     * removes the ship from the world
     */
    public void lose()
    {
        int y = getGridY();
        int x = getGridX();
        if (getIntersectingObjects(Asteroid.class).size() != 0)
        {            
            Asteroid asteroid = getWorld().getOneObjectAt(x, y, Asteroid.class);
            getWorld().remove(asteroid);
            remove();
        }
    }
    
    /**
     * makes the ship act
     */
    public void act()
    {
        this.move(theSpeed);
        wrapAround();
        lose();
    }
}
