package io.github.omgimanerd.sumoshapes.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import io.github.omgimanerd.sumoshapes.util.CustomResources;
import io.github.omgimanerd.sumoshapes.util.Util;
import io.github.omgimanerd.sumoshapes.util.Vector;

public class SumoShape {

  private static final float VELOCITY_MAGNITUDE = Util.SCREEN_WIDTH / 60f;
  private static final float ROTATION_RATE = 0.15f;
  private static final float COLLISION_START_VELOCITY = Util.SCREEN_WIDTH / 80f;
  private static final float COLLISION_DECELERATION = Util.SCREEN_WIDTH / 4000f;

  private static final int SIZE = Util.SCREEN_WIDTH / 20;
  private static final int INDICATOR_OFFSET = SIZE * 2 / 3;
  private static final int INDICATOR_SIZE = SIZE / 4;

  private Vector position_;
  private Vector innateVelocity_;
  private Vector collisionVelocity_;
  private float rotationRate_;

  private Paint directionIndicatorPaint_;
  private Paint bodyPaint_;

  public SumoShape(float x, float y, float startAngle, int bodyColor) {
    this(x, y, 0, 0, 0, bodyColor);
    this.innateVelocity_.setAngle(startAngle);
  }

  public SumoShape(float x, float y,
                   float vx, float vy,
                   float rotationRate,
                   int bodyColor) {
    position_ = new Vector(x, y);
    innateVelocity_ = new Vector(vx, vy);
    collisionVelocity_ = new Vector(0, 0);
    rotationRate_ = rotationRate;

    directionIndicatorPaint_ = new Paint();
    directionIndicatorPaint_.setColor(
        CustomResources.SUMOSHAPE_DIRECTION_INDICATOR_COLOR);
    bodyPaint_ = new Paint();
    bodyPaint_.setColor(bodyColor);
  }

  public void update() {
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
    canvas.drawCircle((float) position_.x, (float) position_.y, SIZE,
                      bodyPaint_);
    double angle = innateVelocity_.getAngle();
    canvas.drawCircle(
        (float) (position_.x + INDICATOR_OFFSET * Math.cos(angle)),
        (float) (position_.y + INDICATOR_OFFSET * Math.sin(angle)),
        INDICATOR_SIZE,
        directionIndicatorPaint_
    );
  }

  public void setForward() {
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

  public boolean isCollided(SumoShape other) {
    return this.position_.getDistancedSquared(other.getPosition()) <= (4 *
        SIZE * SIZE);
  }

  public void collide(SumoShape other) {
    collisionVelocity_.setMag(COLLISION_START_VELOCITY);
    collisionVelocity_.setAngle(other.getVelocity().getAngle());
    other.collisionVelocity_.setMag(COLLISION_START_VELOCITY);
    other.collisionVelocity_.setAngle(innateVelocity_.getAngle());
  }

  public Vector getPosition() {
    return position_;
  }

  public Vector getVelocity() {
    return innateVelocity_;
  }
}
