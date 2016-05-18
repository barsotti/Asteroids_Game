import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Tests the space class
 *
 *  @author Brandon Barsotti (barsotti)
 *  @version (2016.04.27)
 */
public class SpaceTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SpaceTest test object.
     */
    public SpaceTest()
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
        // setUp is not necessary
    }


    // ----------------------------------------------------------

    /**
     * tests the paramaterless space constructor
     */
    public void testSpace()
    {
        Space space = new Space();
        
        assertEquals(1, space.getObjects(Ship.class).size());
        assertEquals(5, space.getObjects(Asteroid.class).size());
    }

    /**
     * tests the populate method
     */
    public void testPopulate()
    {
        Space space = new Space(100, 100);
        space.populate();
        
        assertEquals(5, space.getObjects(Asteroid.class).size());
    }
    
    
    
    
}
