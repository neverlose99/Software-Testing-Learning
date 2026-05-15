import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testInvalidZeroSide() {
        assertEquals("Invalid", Triangle.classify(0, 3, 4));
        assertEquals("Invalid", Triangle.classify(3, 0, 4));
        assertEquals("Invalid", Triangle.classify(3, 4, 0));
    }

    @Test
    public void testInvalidNegativeSide() {
        assertEquals("Invalid", Triangle.classify(-1, 2, 2));
        assertEquals("Invalid", Triangle.classify(2, -1, 2));
        assertEquals("Invalid", Triangle.classify(2, 2, -1));
    }

    @Test
    public void testNotATriangle() {
        assertEquals("Not a triangle", Triangle.classify(1, 2, 3));
        assertEquals("Not a triangle", Triangle.classify(2, 3, 5));
        assertEquals("Not a triangle", Triangle.classify(3, 5, 1));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals("Equilateral", Triangle.classify(5, 5, 5));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("Isosceles", Triangle.classify(5, 5, 3));
        assertEquals("Isosceles", Triangle.classify(5, 3, 5));
        assertEquals("Isosceles", Triangle.classify(3, 5, 5));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("Scalene", Triangle.classify(3, 4, 5));
    }
}
