package com.sumsol.android.common.common.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class FileUtil {

    public static int getDrawableId(String name, Context ctx) {
        return ctx.getResources().getIdentifier(name, "drawable", ctx.getPackageName());
    }

}
