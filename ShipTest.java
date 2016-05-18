import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Tests the ship class
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (2016.04.27)
 */
public class ShipTest extends TestCase
{
    //~ Fields ................................................................
    private Space space;
    
    private Ship ship;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ShipTest test object.
     */
    public ShipTest()
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
        space = new Space(500, 500);
        ship = new Ship(6, -90);
    }


    // ---------------------------------------------------------
    
    /**
     * tests the ship constructor
     */
    public void testConstructor()
    {
        Ship shuttle = new Ship();
        
        assertEquals(0, shuttle.getSpeed());
        assertEquals(-90, shuttle.getRotation(), 0.00001);
    }
    
    /**
     * tests the getSpeed method
     */
    public void testGetSpeed()
    {
        // the speed of the ship should be 5
        assertEquals(6, ship.getSpeed());
    }
    
    /**
     * tests the wrapAround method
     */
    public void testWrapAround()
    {
        // add a ship at far x boundary
        Ship shup = new Ship(1, 0);
        space.add(shup, 499, 100);
        // add a ship at 0 x boundary
        Ship shap = new Ship(1, 180);
        space.add(shap, 0, 100);
        // add a ship at far y boundary
        Ship shep = new Ship(1, 90);
        space.add(shep, 100, 499);
        // add a ship at 0 y boundary
        Ship shop = new Ship(1, -90);
        space.add(shop, 100, 0);
        
        // run world 1 time
        run(space, 1);
        assertEquals(0, shup.getGridX());
        assertEquals(499, shap.getGridX());
        assertEquals(0, shep.getGridY());
        assertEquals(499, shop.getGridY());
    }
    
    /**
     * tests the dpadNorthIsDown method
     */
    public void testdpadNorthIsDown()
    {
        // 6 is the cap of speed
        ship.dpadNorthIsDown();
        assertEquals(6, ship.getSpeed());
        // 
        Ship shop = new Ship(1, 0);
        shop.dpadNorthIsDown();
        assertEquals(2, shop.getSpeed());
    }
    
    /**
     * tests the dpadEastIsDown()
     * 
     */
    public void testDpadEastIsDown()
    {
        ship.dpadEastIsDown();
        assertEquals(-85, ship.getTheRotation()); 
    }
    
    /**
     * tests the dpadSouthIsDown method
     */
    public void testDpadSouthIsDown()
    {
        ship.dpadSouthIsDown();
        assertEquals(5, ship.getSpeed());
        
        Ship shop = new Ship(0, 0);
        shop.dpadSouthIsDown();
        assertEquals(0, shop.getSpeed());
    }
    
    /**
     * tests the dpadWestIsDown
     */
    public void testDpadWestIsDown()
    {
        ship.dpadWestIsDown();
        assertEquals(-95, ship.getTheRotation());
    }
    
    /**
     * tests the onscreentouchdown method
     */
    public void testOnScreenTouchDown()
    {
        space.add(ship, 25, 25);
        
        ship.onScreenTouchDown();
        
        assertEquals(1, space.getObjects(Bullet.class).size());
    }
    
    /**
     * tests the lose method
     */
    public void testLose()
    {
        space.add(ship, 50, 50);
        space.add(new Asteroid(), 50, 50);
        
        ship.lose();
        
        assertEquals(0, space.getObjects(Ship.class).size());
    }
}
