package com.oktydeniz.exampleapp.network;

public class BaseManager {
    public RestApi getRestApi(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();
    }
}
