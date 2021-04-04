package com.oktydeniz.exampleapp.views.homeScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

import com.oktydeniz.exampleapp.R;
import com.oktydeniz.exampleapp.adapters.viewAdapters.ViewPagerAdapter;
import com.oktydeniz.exampleapp.databinding.ActivityMainBinding;
import com.oktydeniz.exampleapp.utils.AppAlertDialog;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ExampleApp);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();
        fullScreen();
        init();
    }

    private void init() {
        SharedPreferences status = MainActivity.this.getSharedPreferences("com.oktydeniz.exampleapp", MODE_PRIVATE);
        boolean isFirstStart = status.getBoolean("firstStart", true);
        if (isFirstStart) {
            showOnlyOnce();
        }
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        binding.userViewPager.setAdapter(viewPagerAdapter);
        binding.appBarUserPage.setupWithViewPager(binding.userViewPager);
    }

    private void showOnlyOnce() {
        AppAlertDialog.showOnlyOnce(MainActivity.this);
        SharedPreferences status = MainActivity.this.getSharedPreferences("com.oktydeniz.exampleapp", MODE_PRIVATE);
        status.edit().putBoolean("firstStart", false).apply();
    }

    private void fullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());

            }
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }
    }
}