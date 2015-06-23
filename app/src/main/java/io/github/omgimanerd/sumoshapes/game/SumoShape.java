package io.github.omgimanerd.sumoshapes.game;

import android.graphics.Canvas;

import io.github.omgimanerd.sumoshapes.util.Vector;

public class SumoShape {

  private static final int X = 0;
  private static final int Y = 1;
  private static final float VELOCITY_MAGNITUDE = 0.5f;
  private static final float ROTATION_RATE = 1;
  private static final float COLLISION_START_VELOCITY = 0.1f;
  private static final float COLLISION_DECELERATION = 0.01f;

  private Vector position_;
  private Vector innateVelocity_;
  private Vector collisionVelocity_;
  private float rotationRate_;

  public SumoShape(float x, float y,
                   float vx, float vy,
                   float rotationRate) {
    this.position_ = new Vector(x, y);
    this.innateVelocity_ = new Vector(vx, vy);
    this.collisionVelocity_ = new Vector(0, 0);
    this.rotationRate_ = rotationRate;
  }

  public void update() {
    // Innate velocity engine is not compatible with collision caused by
    // another player. We will most likely need another method of storing
    // velocity and acceleration in order to account for the fact that player
    // collision runs independent from player movement.
    this.position_.add(this.collisionVelocity_);
    if (this.rotationRate_ == 0) {
      this.position_.add(this.innateVelocity_);
    } else {
      this.innateVelocity_.addAngle(this.rotationRate_);
    }

    if (this.collisionVelocity_.getMag() < COLLISION_DECELERATION) {
      this.collisionVelocity_.setMag(0);
    } else {
      this.collisionVelocity_.setMag(Math.max(0, this.collisionVelocity_
          .getMag() - COLLISION_DECELERATION));
    }
  }

  public void render(Canvas canvas) {
    canvas.save();
    canvas.rotate((float) this.innateVelocity_.getAngle(),
                  (float) this.position_.x,
                  (float) this.position_.y);
    //TODO: bitmap image for player drawing

    canvas.restore();
  }

  public void setMoving() {
    this.rotationRate_ = 0;
    this.innateVelocity_.setMag(VELOCITY_MAGNITUDE);
  }

  public void setRotatingLeft() {
    this.rotationRate_ = -ROTATION_RATE;
    this.innateVelocity_.setMag(0);
  }

  public void setRotationRight() {
    this.rotationRate_ = ROTATION_RATE;
    this.innateVelocity_.setMag(0);
  }

  public void collide(float angle) {
    this.collisionVelocity_.setMag(COLLISION_START_VELOCITY);
    this.collisionVelocity_.setAngle(angle);
  }
}
