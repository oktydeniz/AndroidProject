package com.oktydeniz.exampleapp.utils;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.oktydeniz.exampleapp.R;

import java.util.Locale;

public class GlideBindingAdapter {

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView image, String imageUrl) {
        Context context = image.getContext();
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
        Glide.with(context).setDefaultRequestOptions(requestOptions).load(imageUrl).into(image);

    }
}
