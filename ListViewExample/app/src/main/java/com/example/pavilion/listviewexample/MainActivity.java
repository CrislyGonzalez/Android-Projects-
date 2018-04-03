package com.example.pavilion.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Agua",
            "Vino",
            "Café",
            "Carnes",
            "Hamburguesa",
            "Chocolate",
            "Ensaladas",
            "Frituras",
            "Frutas",
            "Pan"
    };
    String[] itemdescription ={
            "Al menos 8 vasos al día",
            "No exceda una copa al día",
            "Evite tomarlo",
            "Al menos tres veces a la semana",
            "Solo caseras y bajas en grasa",
            "No más de tres a la semana",
            "Todas las que quiera comer",
            "Evítelas, cambie por semillas",
            "Intente al menos una porción de frutas al día",
            "Consuma pan integral"
    };
    Integer[] imgid={
            R.drawable.i01,
            R.drawable.i02,
            R.drawable.i03,
            R.drawable.i04,
            R.drawable.i05,
            R.drawable.i06,
            R.drawable.i07,
            R.drawable.i08,
            R.drawable.i09,
            R.drawable.i10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, itemname, imgid, itemdescription);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem = itemname[position];
                Toast.makeText(getApplicationContext(), Selecteditem,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
