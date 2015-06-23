package io.github.omgimanerd.sumoshapes.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import io.github.omgimanerd.sumoshapes.game.Game;

public class GameView extends View {

  private Game game_;

  public GameView(Context context, AttributeSet attrs) {
    super(context, attrs);

    game_ = new Game();
  }

  @Override
  public void onDraw(Canvas canvas) {
    game_.update();
    game_.render();

    invalidate();
  }

  public boolean onTouchEvent(MotionEvent event) {
    return super.onTouchEvent(event);
  }
}