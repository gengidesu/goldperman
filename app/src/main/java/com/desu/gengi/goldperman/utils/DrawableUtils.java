package com.desu.gengi.goldperman.utils;

import android.graphics.drawable.Drawable;

/**
 * Created by thanaphong.khaownual on 1/15/2018.
 */

public class DrawableUtils {
    private static final int[] EMPTY_STATE = new int[] {};

    public static void clearState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(EMPTY_STATE);
        }
    }
}
