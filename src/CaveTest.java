/**
* This class executes testing according to the Test Strategy Document.
* @version 1
* @author Michelle Cheng & Adapted from Module 4.5.5 lesson content from ITO4131
*/
public class CaveTest
{
    /**
    * Default constructor of CaveTest class
    */
    public CaveTest()
    {
    }

    /**
    * Method to test all parameterised Cave class methods
    */
    public void testCave()
    {
        testConstructor();
        testSetHasMonster();
        testSetIdentity();
        testSetMonster();
        testSetOtherCaves();
    }

    /**
    * Method to test non-default Cave constructor
    */
    private void testConstructor()
    {
        System.out.println("TEST 1.1.1:");
        int[] a = {2,3,4,5};
        Cave cave = new Cave(1, a, true);
        cave.display();
        System.out.println("TEST 1.1.2:");
        int[] b = {3,4,5,6};
        cave = new Cave(100, b, false);
        cave.display();
        System.out.println("TEST 1.2.1:");
        int[] c = {3,4,5};
        cave = new Cave(0, c, false);
        cave.display();
        System.out.println("TEST 1.2.2:");
        int[] d = {3,4,5,6,7};
        cave = new Cave(101, d, false);
        cave.display();
    }

    /**
    * Method to test setHasMonster method in Cave class
    */
    private void testSetHasMonster()
    {
        System.out.println("TEST 2.1.1:");
        Cave cave = new Cave();
        cave.setHasMonster(true);
        cave.display(); //monster should appear?
        System.out.println("TEST 2.1.2:");
        cave = new Cave();
        cave.setHasMonster(false);
        cave.display();
        // System.out.println("TEST 2.2.1:");
        // cave = new Cave();
        // cave.setHasMonster("true");
        // cave.display();
        // System.out.println("TEST 2.2.1:");
        // cave = new Cave();
        // cave.setHasMonster(0);
        // cave.display();
    }

    /**
    * Method to test setIdentity method in Cave class
    */
    private void testSetIdentity()
    {
        System.out.println("TEST 3.1.1:");
        Cave cave = new Cave();
        cave.setIdentity(1);
        cave.display();
        System.out.println("TEST 3.1.2:");
        cave = new Cave();
        cave.setIdentity(100);
        cave.display();
        System.out.println("TEST 3.2.1:");
        cave = new Cave();
        cave.setIdentity(0);
        cave.display();
        System.out.println("TEST 3.2.2:");
        cave = new Cave();
        cave.setIdentity(101);
        cave.display();
        // System.out.println("TEST 3.2.3:");
        // cave = new Cave();
        // cave.setIdentity("1");
        // cave.display();
        // System.out.println("TEST 3.2.4:");
        // cave = new Cave();
        // cave.setIdentity(10.1);
        // cave.display();
    }

    /**
    * Method to test setMonster method in Cave class
    */
    private void testSetMonster()
    {
        System.out.println("TEST 4.1:");
        Cave cave = new Cave();
        cave.setMonster(new Monster());
        cave.display();
        System.out.println("TEST 4.2.1:");
        cave = new Cave();
        cave.setMonster(null);
        cave.display();
        // System.out.println("TEST 4.2.2:");
        // cave = new Cave();
        // cave.setMonster("monster");
        // cave.display();
    }

    /**
    * Method to test setOtherCaves method in Cave class
    */
    private void testSetOtherCaves()
    {
        System.out.println("TEST 5.1:");
        Cave cave = new Cave();
        int[] a = {1,2,3,4};
        cave.setOtherCaves(a);
        cave.display();
        System.out.println("TEST 5.2.1:");
        cave = new Cave();
        int[] b = {1,2,3,4,5};
        cave.setOtherCaves(b);
        cave.display();
        System.out.println("TEST 5.2.2:");
        cave = new Cave();
        int[] c = {1,2,3};
        cave.setOtherCaves(c);
        cave.display();
        // System.out.println("TEST 5.2.3:");
        // cave = new Cave();
        // String[] d = {"1","2","3","4"};
        // cave.setOtherCaves(d);
        // cave.display();
    }
}
