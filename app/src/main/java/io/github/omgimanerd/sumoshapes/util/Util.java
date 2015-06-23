package io.github.omgimanerd.sumoshapes.util;

import android.content.Context;

public class Util {

  public static int SCREEN_WIDTH;
  public static int SCREEN_HEIGHT;

  public static void init(Context context) {
    Util.SCREEN_WIDTH = context.getResources().getDisplayMetrics().
        widthPixels;
    Util.SCREEN_HEIGHT = context.getResources().getDisplayMetrics().
        heightPixels;
  }
}
