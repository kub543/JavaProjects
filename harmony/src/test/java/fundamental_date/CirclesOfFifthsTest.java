package fundamental_date;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CirclesOfFifthsTest {
private CirclesOfFifths circlesOfFifths;
private CirclesOfFifths expectedCircleOfFifths;

    @Before
    public void CircleOfFifths() {
        circlesOfFifths = new CirclesOfFifths();

    }

    @Test(expected = NullPointerException.class)
    public void choseMoodeOfCircle_unExistKey() {
        circlesOfFifths.choseModeOfCircle("Fisis");
    }

    @Test
    public void choseModeOfCircle_Major() {
        expectedCircleOfFifths = new CirclesOfFifths(Arrays.asList(CirclesOfFifths.majorKeys));
        circlesOfFifths.setModeOfCircle(circlesOfFifths.choseModeOfCircle("C"));
        assertEquals(expectedCircleOfFifths.getModeOfCircle(), circlesOfFifths.getModeOfCircle());
    }

    @Test
    public void choseModeOfCircle_Minor() {
        expectedCircleOfFifths = new CirclesOfFifths(Arrays.asList(CirclesOfFifths.minorKeys));
        circlesOfFifths.setModeOfCircle(circlesOfFifths.choseModeOfCircle("c"));
        assertEquals(expectedCircleOfFifths.getModeOfCircle(), circlesOfFifths.getModeOfCircle());
    }

    @Test
    public void findSubdominant_In_MajorKeys() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals("F", circlesOfFifths.findSubdominant("C"));
    }

    @Test
    public void findDominant_in_Major_Key() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals("G", circlesOfFifths.findDominant("C"));
    }

    @Test
    public void findDominant_in_Minor_Key() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMinor());
        assertEquals("G", circlesOfFifths.findDominant("c"));
    }

    @Test
    public void changeModeOfKey() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMinor());
        assertEquals("C", circlesOfFifths.changeModeOfKey("c"));
    }

    @Test
    public void findTonic_ExistIndex() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals("As", circlesOfFifths.findTonic(4));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void findTonic_UnExistIndex() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        circlesOfFifths.findTonic(17);
    }

    @Test
    public void findIndexOfKeyExistMajorKey() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals(8, circlesOfFifths.findIndexOfKey("C"));
    }

    @Test
    public void findIndexOfKeyUnExistMajorKey() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals(-1, circlesOfFifths.findIndexOfKey("Fisis"));
    }
}