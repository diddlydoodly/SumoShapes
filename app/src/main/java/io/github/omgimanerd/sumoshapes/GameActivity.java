package io.github.omgimanerd.sumoshapes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import io.github.omgimanerd.sumoshapes.customviews.GameView;

public class GameActivity extends Activity {

  private GameView gameView_;
  private ImageButton p1left_;
  private ImageButton p1forward_;
  private ImageButton p1right_;
  private ImageButton p2left_;
  private ImageButton p2forward_;
  private ImageButton p2right_;

  private TextView p1score_;
  private TextView p2score_;

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
    p1left_.setSoundEffectsEnabled(false);

    p1forward_ = (ImageButton) findViewById(R.id.p1forward);
    p1forward_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer1().setForward();
      }
    });
    p1forward_.setSoundEffectsEnabled(false);

    p1right_ = (ImageButton) findViewById(R.id.p1right);
    p1right_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer1().setRotationRight();
      }
    });
    p1right_.setSoundEffectsEnabled(false);

    p2left_ = (ImageButton) findViewById(R.id.p2left);
    p2left_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer2().setRotatingLeft();
      }
    });
    p2left_.setSoundEffectsEnabled(false);

    p2forward_ = (ImageButton) findViewById(R.id.p2forward);
    p2forward_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer2().setForward();
      }
    });
    p2forward_.setSoundEffectsEnabled(false);

    p2right_ = (ImageButton) findViewById(R.id.p2right);
    p2right_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gameView_.getGame().getPlayer2().setRotationRight();
      }
    });
    p2right_.setSoundEffectsEnabled(false);

    p1score_ = (TextView) findViewById(R.id.p1score);
    p2score_ = (TextView) findViewById(R.id.p2score);
    gameView_.initializeScoreViews(p1score_, p2score_);
  }
}
