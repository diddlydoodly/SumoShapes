package io.github.omgimanerd.sumoshapes.game;

import android.graphics.Canvas;
import android.util.Log;

import io.github.omgimanerd.sumoshapes.util.CustomResources;
import io.github.omgimanerd.sumoshapes.util.Util;

public class Game {

  private SumoPlatform platform_;
  private SumoShape player1_;
  private SumoShape player2_;

  public Game() {
    player1_ = new SumoShape(Util.SCREEN_WIDTH / 2, Util.SCREEN_HEIGHT / 4,
                             0, CustomResources.SUMOSHAPE_BLUE);
    player2_ = new SumoShape(Util.SCREEN_WIDTH / 2, Util.SCREEN_HEIGHT * 3 / 4,
                             180, CustomResources.SUMOSHAPE_RED);
  }

  public void update() {
    player1_.update();
    player2_.update();
  }

  public void render(Canvas canvas) {
    player1_.render(canvas);
    player2_.render(canvas);
  }

  public SumoShape getPlayer1() {
    return player1_;
  }

  public SumoShape getPlayer2() {
    return player2_;
  }
}
