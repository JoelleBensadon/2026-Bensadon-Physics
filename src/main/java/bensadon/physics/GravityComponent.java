package bensadon.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    public Force force = new Force(37.0365, 28.9360);

    public void setForce(Force force) {
        this.force = force;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Projectile p = new Projectile(0, 0, force);

        g.translate(0, getHeight());
        for (double i = 0; i < 5; i += 0.001) {
            p.apply(0.001);
            g.drawOval((int) p.getX(), (int) -p.getY(), 1, 1);
        }
    }
}