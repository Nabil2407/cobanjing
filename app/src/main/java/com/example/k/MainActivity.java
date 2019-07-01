package com.example.k;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.k.Adapter.Adapterwilayah;
import com.example.k.Model.Modelwilayah;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Modelwilayah>modelwilayahList;


    private String urldata = "http://duganapp.com/cobakonekserver.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.rc_server);
        modelwilayahList = new ArrayList<>();
        showList();


    }

    private void showList(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://duganapp.com/cobakonekserver.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("semuawilayah");
                            for (int i=0;i <array.length(); i++){
                                JSONObject wilayahObj = array.getJSONObject(i);
                                Modelwilayah p = new Modelwilayah(wilayahObj.getString("id_wilayah"),wilayahObj.getString("nama_kabupaten_terpilih"),wilayahObj.getString("nama_kecamatan_terpilih"),wilayahObj.getString("nama_wilayah"),wilayahObj.getString("detail_wilayah"),wilayahObj.getDouble("luas_wilayah"),wilayahObj.getDouble("nilai_erosivitas"));
                                modelwilayahList.add(p);

                            }
                            Adapterwilayah adapterwilayah = new Adapterwilayah(modelwilayahList,getApplicationContext());
                            listView.setAdapter(adapterwilayah);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

        };
        handler.getInstance(getApplicationContext()).addToRequestQue(stringRequest);
    }
}
