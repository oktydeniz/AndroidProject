package com.oktydeniz.exampleapp.views.homeScreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oktydeniz.exampleapp.databinding.FragmentEducationBinding;
import com.oktydeniz.exampleapp.models.ColorsPojo;
import com.oktydeniz.exampleapp.network.ManagerAll;
import com.oktydeniz.exampleapp.views.educationScreen.ColorActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationFragment extends Fragment {
    private FragmentEducationBinding binding;

    public EducationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEducationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.exampleCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), ColorActivity.class));
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}