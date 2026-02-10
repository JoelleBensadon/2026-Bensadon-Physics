package bensadon.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForceTest {
    private final double tolerance = 0.01;

    @Test
    void add(){
        //Given
        Force f1 = new Force(3,4);
        Force f2 = new Force(1, 2);

        //When
        Force result = f1.add(f2);

        //Then
        assertEquals(4.0, result.getX(), tolerance);
        assertEquals(6.0, result.getY(), tolerance);
    }

    @Test
    void normalize(){
        //Given
        Force f1 = new Force(3,4);

        //When
        Force normalized = f1.normalize();

        //Then
        assertEquals(1.0, normalized.getMagnitude(), tolerance);
        assertEquals(0.6, normalized.getX(), tolerance);
        assertEquals(0.8, normalized.getY(), tolerance);
    }

    @Test
    void scale(){

        //Given
        Force f = new Force(3,4);

        //When
        Force scaled = f.scale(2);

        //Then
        assertEquals(6.0, scaled.getX(), tolerance);
        assertEquals(8.0, scaled.getY(), tolerance);
    }

}
