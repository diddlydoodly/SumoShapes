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

  public Vector(double[] xy) {
    this(xy[0], xy[1]);
  }

  public double getAngle() {
    return Math.atan2(this.y, this.x);
  }

  public void setAngle(double angle) {
    double mag = this.getMag();
    this.x = mag * Math.cos(angle);
    this.y = mag * Math.sin(angle);
  }

  public void addAngle(double amount) {
    this.setAngle(this.getAngle() + amount);
  }

  public double getMagSquared() {
    return this.x * this.x + this.y * this.y;
  }

  public double getMag() {
    return Math.sqrt(this.getMagSquared());
  }

  public void setMag(double mag) {
    double angle = this.getAngle();
    this.x = mag * Math.cos(angle);
    this.y = mag * Math.sin(angle);
  }

  public void add(double x, double y) {
    this.x += x;
    this.y += y;
  }

  public void add(Vector v) {
    this.x += v.x;
    this.x += v.y;
  }

  public void sub(double x, double y) {
    this.x -= x;
    this.y -= y;
  }

  public void sub(Vector v) {
    this.x -= v.x;
    this.y -= v.y;
  }
}
