import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Tests the bullet class
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (2016.04.27)
 */
public class BulletTest extends TestCase
{
    //~ Fields ................................................................

    private Bullet bullet;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BulletTest test object.
     */
    public BulletTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        bullet = new Bullet(10, 0);
    }


    // ----------------------------------------------------------

    /**
     * tests the getSpeed method
     */
    public void testGetSpeed()
    {
        assertEquals(10, bullet.getSpeed());
        
    }
    
    /**
     * tests the bullet constructor
     */
    public void testConstructor()
    {
        Bullet bill = new Bullet();
        
        assertEquals(10, bill.getSpeed());
    }
    /**
     * tests the goAway method
     */
    public void testGoAway()
    {
        World world = new World(100, 100);
        Bullet bolt = new Bullet(10, 180);
        world.add(bullet, 100, 20);
        world.add(bolt, 0, 20);
        bullet.goAway();
        bolt.goAway();
        
        assertEquals(0, world.getObjects(Bullet.class).size());
    }
    
    /**
     * tests the goAway method
     */
    public void testGoAway2()
    {
        World world = new World(100, 100);
        Bullet bolt = new Bullet(10, 180);
        world.add(bullet, 100, 20);
        world.add(bolt, 10, 20);
        bullet.goAway();
        bolt.goAway();
        
        assertEquals(1, world.getObjects(Bullet.class).size());
    }
    
    /**
     * tests the goAway method
     */
    public void testGoAway3()
    {
        World world = new World(100, 100);
        Bullet bolt = new Bullet(10, 180);
        world.add(bullet, 10, 0);
        world.add(bolt, 10, 100);
        bullet.goAway();
        bolt.goAway();
        
        assertEquals(0, world.getObjects(Bullet.class).size());
    }
    
    /**
     * tests the goAway method
     */
    public void testGoAway4()
    {
        World world = new World(100, 100);
        Bullet bolt = new Bullet(10, 180);
        world.add(bullet, 10, 0);
        world.add(bolt, 10, 50);
        bullet.goAway();
        bolt.goAway();
        
        assertEquals(1, world.getObjects(Bullet.class).size());
    }
    
    /**
     * tests the goAway method
     */
    public void testGoAway5()
    {
        World world = new World(100, 100);
        world.add(new Asteroid(), 10, 10);
        world.add(bullet, 10, 10);
        bullet.goAway();
        
        assertEquals(0, world.getObjects(Bullet.class).size());
        assertEquals(0, world.getObjects(Asteroid.class).size());
    }
    
    /**
     * tests the goAway method
     */
    public void testGoAway6()
    {
        World world = new World(100, 100);
        world.add(bullet, 10, 10);
        bullet.goAway();
        
        assertEquals(1, world.getObjects(Bullet.class).size());
    }
    
    /**
     * tests act
     */
    public void testAct()
    {
        Space space = new Space(100, 100);
        space.add(bullet, 10, 10);
        
        bullet.act();
        
        assertEquals(20, bullet.getGridX());
    }
    
    /**
     * tests act with an asteroid
     */
    public void testAct2()
    {
        Space space = new Space(100, 100);
        space.add(bullet, 10, 10);
        space.add(new Asteroid(), 20, 10);
        
        bullet.act();
        
        assertEquals(0, space.getObjects(Bullet.class).size());
        assertEquals(0, space.getObjects(Asteroid.class).size());
    }
    
    
}
