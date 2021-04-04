package com.oktydeniz.exampleapp.network;

import com.oktydeniz.exampleapp.models.ColorsPojo;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private final static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<List<ColorsPojo>> getColors() {
        return getRestApi().getAllColors();
    }

}
