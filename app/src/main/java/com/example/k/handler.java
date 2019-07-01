package com.example.k;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class handler {

    public static handler mInstance;
    private RequestQueue requestQueue;
    private static Context context1;

    private handler(Context context){
        context1 =context;
        requestQueue = getRequestQueue();

    }
    public RequestQueue getRequestQueue(){

        if (requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context1.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized handler getInstance(Context context){
        if (mInstance == null){
            mInstance = new handler(context);
        }
        return mInstance;
    }
    public <T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);
    }
}
