package io.github.omgimanerd.sumoshapes.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import io.github.omgimanerd.sumoshapes.util.CustomResources;

public class SumoPlatform {

  private RectF platform_;
  private Paint platformPaint_;

  public SumoPlatform(int screenWidth, int screenHeight) {
    float screenPadding = screenWidth / 25f;
    platform_ = new RectF(
        screenPadding, screenPadding,
        screenWidth - screenPadding, screenHeight - screenPadding);
    platformPaint_ = new Paint();
    platformPaint_.setColor(CustomResources.SUMOPLATFORM_COLOR);
  }

  public void update() {
    // Does nothing yet.
  }

  public void render(Canvas canvas) {
    canvas.drawRect(platform_, platformPaint_);
  }

  public boolean isOut(SumoShape shape) {
    return platform_.contains((float) shape.getPosition().x,
                              (float) shape.getPosition().y);
  }
}
