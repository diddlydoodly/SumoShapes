package io.github.omgimanerd.sumoshapes.util;

/**
 * Custom Vector class for 2D
 */
public class Vector {

  public double x;
  public double y;
  public double angle;

  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
    this.angle = Math.atan2(y, x);
  }

  public double getAngle() {
    return this.angle;
  }

  /**
   * Internal helper method to normalize angles to the range of 0 to 2 * PI,
   * exclusive of upper bound.
   * @param angle
   * @return
   */
  private static double normalizeAngle(double angle) {
    while (angle < 0) {
      angle += 2 * Math.PI;
    }
    return angle % (2 * Math.PI);
  }

  public void setAngle(double angle) {
    double mag = this.getMag();
    this.angle = normalizeAngle(angle);
    x = mag * Math.cos(this.angle);
    y = mag * Math.sin(this.angle);
  }

  public void addAngle(double amount) {
    setAngle(getAngle() + amount);
  }

  public double getMagSquared() {
    return x * x + y * y;
  }

  public double getMag() {
    return Math.sqrt(getMagSquared());
  }

  public void setMag(double mag) {
    x = mag * Math.cos(angle);
    y = mag * Math.sin(angle);
  }

  public void add(Vector v) {
    x += v.x;
    y += v.y;
  }

  public void sub(Vector v) {
    x -= v.x;
    y -= v.y;
  }

  public double getDistancedSquared(Vector v) {
    return (v.x - x) * (v.x - x) + (v.y - y) * (v.y - y);
  }

  public double getDistance(Vector v) {
    return Math.sqrt(getDistancedSquared(v));
  }

  public String toString() {
    return x + " " + y + " " + angle;
  }
}
