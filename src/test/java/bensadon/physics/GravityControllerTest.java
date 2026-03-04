package bensadon.physics;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

class GravityControllerTest {

    @Test
    void updateForce() {

        // Given
        GravityComponent gravityComponent = mock();
        JTextField xField = mock();
        JTextField yField = mock();
        JTextField timeField = mock();
        doReturn("5").when(timeField).getText();
        JLabel angleLabel = mock();
        JLabel magnitudeLabel = mock();

        GravityController controller = new GravityController(
                gravityComponent, xField, yField, timeField, angleLabel, magnitudeLabel
        );

        // When
        controller.updateForce(7, 5);

        // Then
        verify(gravityComponent).setForce(new Force(7, 5));
        verify(gravityComponent).setTime(5);
        verify(xField).setText("7.0");
        verify(yField).setText("5.0");
        verify(angleLabel).setText("Angle: (Degrees):35.53767779197438 ");
        verify(magnitudeLabel).setText("Magnitude: 8.602325267042627");
    }
}