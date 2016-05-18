import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Tests the asteroid class
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (4.27.2016)
 */
public class AsteroidTest extends TestCase
{
    //~ Fields ................................................................

    private Asteroid asteroid;
    
    private Space space;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AsteroidTest test object.
     */
    public AsteroidTest()
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
        asteroid = new Asteroid(1, 0);
        space = new Space(500, 500);
    }


    // ----------------------------------------------------------

    /**
     * tests the getSpeed method
     */
    public void testGetSpeed()
    {
        assertEquals(1, asteroid.getSpeed());
    }
    
    /**
     * tests the wrapAround method
     */
    public void testWrapAround()
    {
        // add an asteroid at far x boundary
        Asteroid ship = new Asteroid(1, 0);
        space.add(ship, 499, 100);
        // add an asteroid at 0 x boundary
        Asteroid shap = new Asteroid(1, 180);
        space.add(shap, 0, 100);
        // add an asteroid at far y boundary
        Asteroid shep = new Asteroid(1, 90);
        space.add(shep, 100, 499);
        // add an asteroid at 0 y boundary
        Asteroid shop = new Asteroid(1, -90);
        space.add(shop, 100, 0);
        
        // run world 1 time
        run(space, 1);
        assertEquals(0, ship.getGridX());
        assertEquals(499, shap.getGridX());
        assertEquals(0, shep.getGridY());
        assertEquals(499, shop.getGridY());
    }
    

}
