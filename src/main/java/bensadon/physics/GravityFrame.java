package bensadon.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GravityFrame extends JFrame {
    public GravityFrame() {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextField xField = new JTextField("37.0365");
        JTextField yField = new JTextField("28.9360");
        JTextField timeField = new JTextField("5");

        GravityComponent gravityComponent = new GravityComponent();
        JButton button = new JButton("Draw");

        JLabel infoLabel = new JLabel("Angle:  , Magnitude:  ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Force f = new Force(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText())
                );
                gravityComponent.setForce(f);
                gravityComponent.setTime(Double.parseDouble(timeField.getText()));
                infoLabel.setText("Angle: " + f.getDegrees() + "  Magnitude: " + f.getMagnitude());
            }
        });
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("ForceX"));
        northPanel.add(xField);

        northPanel.add(new JLabel("ForceY"));
        northPanel.add(yField);

        northPanel.add(new JLabel("Time"));
        northPanel.add(timeField);

        northPanel.add(button);
        northPanel.add(infoLabel);

        add(northPanel, BorderLayout.NORTH);
        add(gravityComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}