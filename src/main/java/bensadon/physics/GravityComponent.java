package bensadon.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    private Force force = new Force(37.0365, 28.9360);
    private Projectile p = new Projectile(0, 0, force);
    private double time = 5;

    public void setForce(Force force) {
        this.force = force;
        p = new Projectile(0, 0, force);
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

        g.setColor(Color.BLUE);

        g.translate(0, getHeight());
        //for (double i = 0; i < time; i += 0.001) {
        p.apply(0.01);
        g.fillOval((int) p.getX(), (int) -p.getY(), 10, 10);
        // }
        double apexX = force.x() * (force.y() / 9.8);
        double apexY = force.getApex();

        g.setColor(Color.RED);
        g.drawOval((int) apexX - 5, (int) -apexY - 5, 10, 10);
        
        g.setColor(Color.green);
        g.drawLine(0, 0, (int) force.x(), (int) -force.y());
    }
}