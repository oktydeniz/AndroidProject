package com.oktydeniz.exampleapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.oktydeniz.exampleapp.R;

/**
 * @author oktay
 * @since 1.0
 */

public class AppAlertDialog {
    public static void showOnlyOnce(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.opening_text);
        builder.setCancelable(false);
        builder.setTitle(R.string.information);
        builder.setPositiveButton(R.string.continue_text, (dialog, which) -> {
        });
        builder.create().show();
    }

    // Alert with Message and ok
    public static void showAlertDialog(Context context, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(R.string.okey, (dialog, which) -> {
        });
        builder.create().show();
    }

    // Alert with Message and ok Click Event
    public static void showAlertDialog(Context context, String title, String msg, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(R.string.okey, listener);
        builder.setNegativeButton(R.string.cancel, listener);
        builder.create().show();
    }
}