package io.github.omgimanerd.sumoshapes.util;

/**
 * Custom Vector class for storing 2D positions
 */
public class Vector {

  public double x;
  public double y;

  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getAngle() {
    return Math.atan2(this.y, this.x);
  }

  public void setAngle(double angle) {
    double mag = this.getMag();
    x = mag * Math.cos(angle);
    y = mag * Math.sin(angle);
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
    double angle = this.getAngle();
    x = mag * Math.cos(angle);
    y = mag * Math.sin(angle);
  }

  public void add(Vector v) {
    x += v.x;
    x += v.y;
  }

  public void sub(Vector v) {
    x -= v.x;
    y -= v.y;
  }
}
