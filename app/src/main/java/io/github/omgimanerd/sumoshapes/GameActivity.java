package io.github.omgimanerd.sumoshapes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import io.github.omgimanerd.sumoshapes.customviews.GameView;

public class GameActivity extends Activity {

  private GameView gameView_;
  private ImageButton p1left_;
  private ImageButton p1forward_;
  private ImageButton p1right_;
  private ImageButton p2left_;
  private ImageButton p2forward_;
  private ImageButton p2right_;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                         WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.activity_game);

    init();
  }

  private void init() {
    gameView_ = (GameView) findViewById(R.id.gameView);
    p1left_ = (ImageButton) findViewById(R.id.p1left);
    p1left_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer1().setRotatingLeft();
      }
    });
    p1forward_ = (ImageButton) findViewById(R.id.p1forward);
    p1forward_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer1().setForward();
      }
    });
    p1right_ = (ImageButton) findViewById(R.id.p1right);
    p1right_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer1().setRotationRight();
      }
    });
    p2left_ = (ImageButton) findViewById(R.id.p2left);
    p2left_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer2().setRotatingLeft();
      }
    });
    p2forward_ = (ImageButton) findViewById(R.id.p2forward);
    p2forward_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer2().setForward();
      }
    });
    p2right_ = (ImageButton) findViewById(R.id.p2right);
    p2right_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer2().setRotationRight();
      }
    });
  }
}
