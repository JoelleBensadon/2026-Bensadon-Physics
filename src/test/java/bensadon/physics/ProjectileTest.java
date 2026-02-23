package bensadon.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectileTest {
    private final double tolerance = 0.01;

    @Test
    void apply() {
        // Given
        Projectile p = new Projectile(0, 0, new Force(10, 0));

        // When
        p.apply(1);

        // Then
        assertEquals(10.0, p.getX(), tolerance);
        assertEquals(-9.8, p.getY(), tolerance);

        assertEquals(10.0, p.getForce().x(), tolerance);
        assertEquals(-9.8, p.getForce().y(), tolerance);
    }
}