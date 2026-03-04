package bensadon.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    private Force force = new Force(37.0365, 28.9360);
    private double time = 5;

    public void setForce(Force force) {
        this.force = force;
        repaint();
    }

    public void setTime(double time) {
        this.time = time;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(170, 210, 230)); //light blue
        for (int x = 0; x < getWidth(); x += 20) {
            g.drawLine(x, 0, x, getHeight());
        }
        for (int y = 0; y < getHeight(); y += 20) {
            g.drawLine(0, y, getWidth(), y);
        }
        Projectile p = new Projectile(0, 0, force);

        g.translate(0, getHeight());
        for (double i = 0; i < time; i += 0.001) {
            p.apply(0.001);
            g.drawOval((int) p.getX(), (int) -p.getY(), 1, 1);
        }
        g.setColor(Color.green);
        g.drawLine(0, 0, (int) force.x(), (int) -force.y());
    }
}