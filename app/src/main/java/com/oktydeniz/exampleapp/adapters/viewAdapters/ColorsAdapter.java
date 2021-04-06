package com.oktydeniz.exampleapp.adapters.viewAdapters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oktydeniz.exampleapp.databinding.ColorEduBinding;
import com.oktydeniz.exampleapp.models.ColorsPojo;

import java.util.List;
import java.util.Locale;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ViewHolder> {
    private static final String TAG = "ColorsAdapter";
    List<ColorsPojo> list;
    private TextToSpeech speech;
    private Context context;

    public ColorsAdapter(List<ColorsPojo> colorsPojoList) {
        this.list = colorsPojoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ColorEduBinding binding = ColorEduBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ColorsPojo color = list.get(position);
        holder.binding.setColor(color);
        holder.binding.executePendingBindings();
        holder.binding.imageView.setOnClickListener(v -> textToSpeech(list.get(position).getColor_text()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ColorEduBinding binding;

        public ViewHolder(@NonNull ColorEduBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void textToSpeech(String str) {
        speech = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                speech.setLanguage(Locale.getDefault());
                Locale locale = new Locale("tr", "TR");
                int result = speech.setLanguage(locale);
                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.i(TAG, "This Language is not supported");
                } else {
                    speech.speak(str, TextToSpeech.QUEUE_FLUSH, null, "");
                }
            } else {
                speech = null;
                Log.i(TAG, "Failed to initialize the TextToSpeech engine");
            }

        });
    }

    public void onDestroy() {
        if (speech != null) {
            speech.shutdown();
            speech.stop();
        }
    }
}
