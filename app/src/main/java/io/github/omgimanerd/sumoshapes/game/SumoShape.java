package io.github.omgimanerd.sumoshapes.game;

import android.graphics.Canvas;

public class SumoShape {

  private static final float DEFAULT_VELOCITY_MAGNITUDE = 0.5f;
  private static final float DEFAULT_ROTATION_RATE = 1;

  private float[] position_;
  private float[] velocity_;
  private float rotationAngle_;
  private float rotationRate_;

  public SumoShape(float[] position, float[] velocity, float rotationAngle,
                   float rotationRate) {
    position_ = position;
    velocity_ = velocity;
    rotationAngle_ = rotationAngle;
    rotationRate_ = rotationRate;
  }

  public void update() {
    //TODO: look for built in java vector class
    // Innate velocity engine is not compatible with collision caused by
    // another player. We will most likely need another method of storing
    // velocity and acceleration in order to account for the fact that player
    // collision runs independent from player movement.
    for (int i = 0; i < position_.length; ++i) {
      this.position_[i] += this.velocity_[i];
    }
    this.rotationAngle_ += this.rotationRate_;
  }

  public void render(Canvas canvas) {
    canvas.save();
    canvas.rotate(rotationAngle_, this.position_[0], this.position_[1]);
    //TODO: bitmap image for player drawing

    canvas.restore();
  }

  public void setMoving() {
    this.rotationRate_ = 0;
    this.velocity_[0] = (float) Math.cos(rotationAngle_) *
        DEFAULT_VELOCITY_MAGNITUDE;
    this.velocity_[1] = (float) Math.sin(rotationAngle_) *
        DEFAULT_VELOCITY_MAGNITUDE;
  }

  public void setRotatingLeft() {
    this.velocity_[0] = 0;
    this.velocity_[1] = 0;
    this.rotationRate_ = -DEFAULT_ROTATION_RATE;
  }

  public void setRotationRight() {
    this.velocity_[0] = 0;
    this.velocity_[1] = 0;
    this.rotationRate_ = DEFAULT_ROTATION_RATE;
  }
}
