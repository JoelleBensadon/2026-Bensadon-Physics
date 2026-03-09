package bensadon.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForceTest {
    private final double tolerance = 0.01;

    @Test
    void add() {
        //Given
        Force f1 = new Force(3, 4);
        Force f2 = new Force(1, 2);

        //When
        Force result = f1.add(f2);

        //Then
        assertEquals(4.0, result.x(), tolerance);
        assertEquals(6.0, result.y(), tolerance);
    }

    @Test
    void normalize() {
        //Given
        Force f1 = new Force(3, 4);

        //When
        Force normalized = f1.normalize();

        //Then
        assertEquals(1.0, normalized.getMagnitude(), tolerance);
        assertEquals(0.6, normalized.x(), tolerance);
        assertEquals(0.8, normalized.y(), tolerance);
    }

    @Test
    void scale() {

        //Given
        Force f = new Force(3, 4);

        //When
        Force scaled = f.scale(2);

        //Then
        assertEquals(6.0, scaled.x(), tolerance);
        assertEquals(8.0, scaled.y(), tolerance);
    }

    @Test
    void apex() {

        // Given
        Force f = new Force(7, 5);

        // When
        double apex = f.getApex();

        // Then
        assertEquals(1.2755102040816326, apex, tolerance);
    }

}
