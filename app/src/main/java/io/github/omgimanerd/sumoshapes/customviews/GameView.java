package io.github.omgimanerd.sumoshapes.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import io.github.omgimanerd.sumoshapes.game.Game;

import static java.lang.System.currentTimeMillis;

public class GameView extends View {

  private static final int FPS = 60;

  private Game game_;
  private long lastUpdateTime_;
  private TextView p1score_;
  private TextView p2score_;

  public GameView(Context context, AttributeSet attrs) {
    super(context, attrs);

    game_ = new Game();
    lastUpdateTime_ = 0;
  }

  @Override
  public void onDraw(Canvas canvas) {
    if (currentTimeMillis() > lastUpdateTime_ + (1000.0 / FPS)) {
      game_.update();
      lastUpdateTime_ = currentTimeMillis();
    }
    game_.render(canvas);

    if (p1score_ != null) {
      p1score_.setText("" + game_.getPlayer1Score());
    }
    if (p2score_ != null) {
      p2score_.setText("" + game_.getPlayer2Score());
    }

    invalidate();
  }

  public void initializeScoreViews(TextView p1score, TextView p2score) {
    p1score_ = p1score;
    p2score_ = p2score;
  }

  public Game getGame() {
    return this.game_;
  }
}
