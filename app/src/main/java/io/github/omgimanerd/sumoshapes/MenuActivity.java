package io.github.omgimanerd.sumoshapes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.omgimanerd.sumoshapes.util.Util;

public class MenuActivity extends Activity {

  private Button startButton_;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    init();
  }

  protected void init() {
    Util.init(this);

    startButton_ = (Button) findViewById(R.id.startButton);
    startButton_.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),
                                   GameActivity.class);
        startActivity(intent);
      }
    });
  }
}
