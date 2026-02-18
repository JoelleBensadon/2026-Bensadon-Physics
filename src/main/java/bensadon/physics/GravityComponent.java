package bensadon.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // g.drawLine(0, 0, getWidth(), getHeight());
        // g.drawOval(30, 45, 20, 20);
        // g.fillOval(0, 0, 20, 20);

        // gravity force
        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(0.001);

        // force value counted in class
        Force f1 = new Force(37.0365, 28.9360);

        double x = 0;
        double y = 0;

        for (double t = 0; t <= 5; t += 0.001) {
            // add gravity to f1
            f1 = f1.add(scaledGravity);

            // scale f1 by 0.001
            Force scaledF1 = f1.scale(0.001);

            // update x and y using the scaled force
            x = x + scaledF1.x();
            y = y + scaledF1.y();

            g.fillOval((int) x, (int) y, 3, 3);
        }
    }
}
