package com.example.k.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.k.Model.Modelwilayah;
import com.example.k.R;

import java.util.List;

public class Adapterwilayah extends ArrayAdapter<Modelwilayah> {

    private List<Modelwilayah> modelwilayahList;
    private Context context;

    public Adapterwilayah(List<Modelwilayah> P,Context context1){

        super(context1, R.layout.isi_layout);
        this.modelwilayahList = P;
        this.context=context1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.isi_layout,null,true);

        TextView id = (TextView) view.findViewById(R.id.tv_id);
        TextView kabupaten = (TextView) view.findViewById(R.id.tv_kabupaten);
        TextView kecamatan = (TextView) view.findViewById(R.id.tv_kecamatan);
        TextView namawilayah = (TextView) view.findViewById(R.id.tv_namawilayah);
        TextView detailwilayah = (TextView) view.findViewById(R.id.tv_detail_wilayah);
        TextView luaslahan = (TextView) view.findViewById(R.id.tv_luas_lahan);
        TextView nilaier = (TextView) view.findViewById(R.id.tv_nilair);

        Modelwilayah modelwilayah = modelwilayahList.get(position);
        id.setText(modelwilayah.getId());
        kabupaten.setText(modelwilayah.getNamakabupatenterpilih());
        kecamatan.setText(modelwilayah.getNamakecamatan());
        namawilayah.setText(modelwilayah.getNamawilayah());
        detailwilayah.setText(modelwilayah.getDetailwilayah());
        luaslahan.setText(String.valueOf(modelwilayah.getLuaslahan()));
        nilaier.setText(String.valueOf(modelwilayah.getNilair()));


        return view;
    }
}
