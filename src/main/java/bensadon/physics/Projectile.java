package bensadon.physics;

public class Projectile {

    private static final Force GRAVITY = new Force(0, -9.8);

    private double x;
    private double y;
    private Force force;

    public Projectile(double x, double y, Force force) {
        this.x = x;
        this.y = y;
        this.force = force;
    }

    public void apply(double time) {
        Force scaledGravity = GRAVITY.scale(time);
        force = force.add(scaledGravity);
        Force scaledForce = force.scale(time);
        x += scaledForce.x();
        y += scaledForce.y();
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Force getForce() {
        return force;
    }
}
