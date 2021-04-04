package com.oktydeniz.exampleapp.views.educationScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.oktydeniz.exampleapp.R;
import com.oktydeniz.exampleapp.adapters.viewAdapters.ColorsAdapter;
import com.oktydeniz.exampleapp.databinding.ActivityColorBinding;
import com.oktydeniz.exampleapp.models.ColorsPojo;
import com.oktydeniz.exampleapp.network.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ColorActivity extends AppCompatActivity {
    private ActivityColorBinding binding;
    private ColorsAdapter adapter ;
    private static final String TAG = "ColorActivity";
    List<ColorsPojo> colorsPojo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityColorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        Call<List<ColorsPojo>> call = ManagerAll.getInstance().getColors();
        call.enqueue(new Callback<List<ColorsPojo>>() {
            @Override
            public void onResponse(@NonNull Call<List<ColorsPojo>> call, @NonNull Response<List<ColorsPojo>> response) {
                Log.i(TAG, "onResponse : completed  ");
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse :" + response.body());
                    colorsPojo = response.body();
                    adapter = new ColorsAdapter(colorsPojo);
                    binding.colorRecyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ColorsPojo>> call, @NonNull Throwable t) {
                System.out.println("failed  : " + t.getLocalizedMessage());
            }
        });
    }
}