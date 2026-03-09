package bensadon.physics;

import javax.swing.*;

public class GravityController {
    private final GravityComponent gravityComponent;
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField timeField;
    private final JLabel angleLabel;
    private final JLabel magnitudeLabel;
    private final JLabel apexLabel;


    public GravityController(GravityComponent gravityComponent,
                             JTextField xField,
                             JTextField yField,
                             JTextField timeField,
                             JLabel angleLabel,
                             JLabel magnitudeLabel,
                             JLabel apexLabel) {
        this.gravityComponent = gravityComponent;
        this.xField = xField;
        this.yField = yField;
        this.timeField = timeField;
        this.angleLabel = angleLabel;
        this.magnitudeLabel = magnitudeLabel;
        this.apexLabel = apexLabel;
    }

    public void updateForce(double x, double y) {
        Force force = new Force(x, y);
        gravityComponent.setForce(force);
        gravityComponent.setTime(Double.parseDouble(timeField.getText()));
        xField.setText(String.valueOf(force.x()));
        yField.setText(String.valueOf(force.y()));
        angleLabel.setText("Angle: (Degrees):" + force.getDegrees());
        magnitudeLabel.setText("Magnitude: " + force.getMagnitude());
        apexLabel.setText("Apex: " + force.getApex());
    }
}