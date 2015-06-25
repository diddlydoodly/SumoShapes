package io.github.omgimanerd.sumoshapes.game;

import android.graphics.Canvas;

import io.github.omgimanerd.sumoshapes.util.CustomResources;
import io.github.omgimanerd.sumoshapes.util.Util;
import io.github.omgimanerd.sumoshapes.util.Vector;

public class Game {

  private static int MAX_SCORE = 10;

  private SumoPlatform platform_;
  private SumoShape player1_;
  private SumoShape player2_;

  private int player1Score_;
  private int player2Score_;

  public Game() {
    platform_ = new SumoPlatform(Util.SCREEN_WIDTH, Util.SCREEN_HEIGHT);
    player1_ = new SumoShape(
        Util.SCREEN_WIDTH / 2.0f, Util.SCREEN_HEIGHT / 4.0f,
        (float) (Math.PI / 2.0), CustomResources.SUMOSHAPE_BLUE);
    player2_ = new SumoShape(
        Util.SCREEN_WIDTH / 2.0f, Util.SCREEN_HEIGHT * 3.0f / 4.0f,
        (float) (Math.PI * 3.0 / 2.0), CustomResources.SUMOSHAPE_RED);
    player1Score_ = 0;
    player2Score_ = 0;
  }

  public void update() {
    player1_.update();
    player2_.update();
    if (player1_.isCollided(player2_)) {
      player1_.collide(player2_);
    }

    if (platform_.isOut(player1_)) {
      player1_.respawn(getPlayerRespawnPoint(player2_),
                       getPlayerRespawnAngle(player2_));
      player2Score_++;
    } else if (platform_.isOut(player2_)) {
      player2_.respawn(getPlayerRespawnPoint(player1_),
                       getPlayerRespawnAngle(player1_));
      player1Score_++;
    }
  }

  public void render(Canvas canvas) {
    platform_.render(canvas);
    player1_.render(canvas);
    player2_.render(canvas);
  }

  public Vector getPlayerRespawnPoint(SumoShape otherPlayer) {
    if (otherPlayer.getPosition().y < Util.SCREEN_HEIGHT / 2) {
      return new Vector(Util.SCREEN_WIDTH / 2.0,
                        Util.SCREEN_HEIGHT * 3.0 / 4.0);
    } else {
      return new Vector(Util.SCREEN_WIDTH / 2.0,
                        Util.SCREEN_HEIGHT / 4.0);
    }
  }

  public double getPlayerRespawnAngle(SumoShape otherPlayer) {
    if (otherPlayer.getPosition().y < Util.SCREEN_HEIGHT / 2) {
      return 3.0 * Math.PI / 2.0;
    } else {
      return Math.PI / 2.0;
    }
  }

  public SumoShape getPlayer1() {
    return player1_;
  }

  public int getPlayer1Score() {
    return player1Score_;
  }

  public SumoShape getPlayer2() {
    return player2_;
  }

  public int getPlayer2Score() {
    return player2Score_;
  }
}
