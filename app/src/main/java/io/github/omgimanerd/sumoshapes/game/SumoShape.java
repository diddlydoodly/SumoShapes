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
    position_ = new Vector(x, y);
    innateVelocity_ = new Vector(vx, vy);
    collisionVelocity_ = new Vector(0, 0);
    rotationRate_ = rotationRate;
  }

  public void update() {
    // Innate velocity engine is not compatible with collision caused by
    // another player. We will most likely need another method of storing
    // velocity and acceleration in order to account for the fact that player
    // collision runs independent from player movement.
    position_.add(collisionVelocity_);
    if (rotationRate_ == 0) {
      position_.add(innateVelocity_);
    } else {
      innateVelocity_.addAngle(rotationRate_);
    }

    if (this.collisionVelocity_.getMag() < COLLISION_DECELERATION) {
      collisionVelocity_.setMag(0);
    } else {
      collisionVelocity_.setMag(Math.max(0, collisionVelocity_
          .getMag() - COLLISION_DECELERATION));
    }
  }

  public void render(Canvas canvas) {
    canvas.save();
    canvas.rotate((float) innateVelocity_.getAngle(),
                  (float) position_.x,
                  (float) position_.y);
    //TODO: bitmap image for player drawing

    canvas.restore();
  }

  public void setMoving() {
    rotationRate_ = 0;
    innateVelocity_.setMag(VELOCITY_MAGNITUDE);
  }

  public void setRotatingLeft() {
    rotationRate_ = -ROTATION_RATE;
    innateVelocity_.setMag(0);
  }

  public void setRotationRight() {
    rotationRate_ = ROTATION_RATE;
    innateVelocity_.setMag(0);
  }

  public void collide(float angle) {
    collisionVelocity_.setMag(COLLISION_START_VELOCITY);
    collisionVelocity_.setAngle(angle);
  }
}
