package bensadon.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame {
    public GravityFrame() {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        final JLabel xLabel = new JLabel("Force x");
        JTextField xField = new JTextField("37.0365");
        final JLabel yLabel = new JLabel("Force y");
        JTextField yField = new JTextField("28.9360");
        final JLabel timeLabel = new JLabel("Force time");
        JTextField timeField = new JTextField("5");

        GravityComponent gravityComponent = new GravityComponent();
        JLabel angleLabel = new JLabel("Angle: ");
        JLabel magnitudeLabel = new JLabel("Magnitude: ");

        GravityController gravityController = new GravityController(
                gravityComponent, xField, yField, angleLabel, magnitudeLabel
        );

        gravityComponent.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                gravityController.updateForce(e.getX(), gravityComponent.getHeight() - e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        gravityComponent.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                gravityController.updateForce(e.getX(), gravityComponent.getHeight() - e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        JButton button = new JButton("Draw");


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Force f = new Force(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText())
                );
                gravityComponent.setForce(f);
                gravityComponent.setTime(Double.parseDouble(timeField.getText()));
                angleLabel.setText("Angle: " + f.getDegrees());
                magnitudeLabel.setText("Magnitude: " + f.getMagnitude());
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
        northPanel.add(angleLabel);
        northPanel.add(magnitudeLabel);

        add(northPanel, BorderLayout.NORTH);
        add(gravityComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}