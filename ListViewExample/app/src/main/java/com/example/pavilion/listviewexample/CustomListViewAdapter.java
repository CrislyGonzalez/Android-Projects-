package com.example.pavilion.listviewexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] itemdescription;


    public CustomListViewAdapter(Activity context, String[] itemname, Integer[] imgid, String[] itemdescription) {
        super(context, R.layout.activity_custom_list_view_adapter, itemname);
        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.itemdescription = itemdescription;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_custom_list_view_adapter, null, true);
        TextView nombre = (TextView) rowView.findViewById(R.id.name);
        ImageView imagen = (ImageView) rowView.findViewById(R.id.icon);
        TextView descripcion = (TextView) rowView.findViewById(R.id.description);
        nombre.setText(itemname[position]);
        imagen.setImageResource(imgid[position]);
        descripcion.setText(itemdescription[position]);
        return rowView;
    }
}
