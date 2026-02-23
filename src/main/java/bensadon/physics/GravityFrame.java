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

        GravityComponent gravityComponent = new GravityComponent();
        JButton button = new JButton("Draw");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityComponent.setForce(
                        new Force(
                                Double.parseDouble(xField.getText()),
                                Double.parseDouble(yField.getText())
                        )
                );

            }
        });

        JPanel northPanel = new JPanel();
        northPanel.add(xField);
        northPanel.add(yField);
        northPanel.add(button);
        add(northPanel, BorderLayout.NORTH);


        add(gravityComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
