package bensadon.physics;

import javax.swing.*;

public class GravityController {
    GravityComponent gravityComponent;
    JTextField xField;
    JTextField yField;
    JLabel angleLabel;
    JLabel magnitudeLabel;

    public GravityController(GravityComponent gravityComponent,
                             JTextField xField,
                             JTextField yField,
                             JLabel angleLabel,
                             JLabel magnitudeLabel) {
        this.gravityComponent = gravityComponent;
        this.xField = xField;
        this.yField = yField;
        this.angleLabel = angleLabel;
        this.magnitudeLabel = magnitudeLabel;
    }

    public void updateForce(double x, double y) {
        Force force = new Force(x, y);
        gravityComponent.setForce(force);
        xField.setText(String.valueOf(force.x()));
        yField.setText(String.valueOf(force.y()));
        angleLabel.setText("Angle: (Degrees):" + force.getDegrees());
        magnitudeLabel.setText("Magnitude: " + force.getMagnitude());
    }
}
