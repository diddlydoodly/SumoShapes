package io.github.omgimanerd.sumoshapes.util;

import android.content.Context;
import android.content.res.Resources;

import io.github.omgimanerd.sumoshapes.R;

public class CustomResources {

  private static Resources res_;
  public static int SUMOSHAPE_DIRECTION_INDICATOR_COLOR;
  public static int SUMOSHAPE_RED;
  public static int SUMOSHAPE_BLUE;

  public static void init(Context context) {
    res_ = context.getResources();

    SUMOSHAPE_DIRECTION_INDICATOR_COLOR = res_.getColor(
        R.color.sumoshape_direction_indicator_color);
    SUMOSHAPE_RED = res_.getColor(R.color.sumoshape_red);
    SUMOSHAPE_BLUE = res_.getColor(R.color.sumoshape_blue);
  }
}
