package com.example.crisly_pc.lab4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.text.TextUtils.join;

public class MainActivityLab4 extends AppCompatActivity {

    public static final String TAG_IMG = "IMG";
    private TextView mDataText;

    //guardar imagenes bitmap
    private ImageView imageView;
    private Bitmap loadedImage;
    private String imageHttpAddress = "http://jonsegador.com/wp-content/apezz.png";


    //listview
    ArrayList<Pais> model = new ArrayList<>();
    public PaisAdapter adapter=null;




    //esta relacionado con el evento list
    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Bundle bundle;
            bundle = new Bundle();
            bundle.putString("n", model.get(i).getNombre());
            Intent intent = new Intent(getApplicationContext(), mainImageActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };



    //este metodo llenará todas las filas listview
    static class PaisHolder{
        private TextView nombre=null;
        private TextView codigo1=null;
        private TextView codigo2=null;
        private ImageView icon=null;
        PaisHolder(View row){
            nombre=(TextView)row.findViewById(R.id.nombre);
            codigo1=(TextView)row.findViewById(R.id.codigo1);
            codigo2=(TextView)row.findViewById(R.id.codigo2);
            icon=(ImageView)row.findViewById(R.id.icon);
        }
        void populateFrom(Pais r){

            nombre.setText(r.getNombre());
            codigo1.setText(r.getCodigo1());
            codigo2.setText(r.getCodigo2());


        }
    }

    // lleva el control de que fila estoy
    class PaisAdapter extends ArrayAdapter<Pais> {

        PaisAdapter() {
            super(MainActivityLab4.this, R.layout.row, model);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            View row=convertView;
            PaisHolder holder=null;

            if(row==null){
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent,false);
                holder=new PaisHolder(row);
                row.setTag(holder);
            }
            else{
                holder=(PaisHolder)row.getTag();
            }
            holder.populateFrom(model.get(position));
            //Hay que modificar el model
            return (row);
        }
    }


    // Elementos para realizar Servicios REST
    private static final String URL_REST = "http://services.groupkt.com/country/get/all";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab4);
        mDataText = (TextView) findViewById(R.id.mDataText);
        servicioREST();
        ListView list=(ListView)findViewById(R.id.lista_paises);
        adapter=new PaisAdapter();
        for(int i=0;i<100;i++){
            Log.v(TAG_IMG, "-+++--++++->" + adapter);
            Log.v(TAG_IMG, "-+++--++++->" + adapter);
        }
        list.setAdapter(adapter);
        list.setOnItemClickListener(onListClick);



        imageView = (ImageView) findViewById(R.id.image_view);


    }

    // Clase para la tarea asincronica de Gson en Servicio REST
    private class TaskServicioREST extends AsyncTask<String, Void, String> {
        // La tarea se ejecuta en un thread tomando como parametro el eviado en
        //   AsyncTask.execute()
        @Override
        protected String doInBackground(String... urls) {
            // tomanos el parámetro del execute() y bajamos el contenido
            return loadContentFromNetwork(urls[0]);
        }

        // El resultado de la tarea tiene el archivo json el cual mostramos
        protected void onPostExecute(String r) {
             //paises.add(result);
            // Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
            // mDataText.append("\n \n" + result); // funcionaaaa para ver json all


            Log.v(TAG_IMG, "-+++--++++->" + r);


            try {
                JSONObject req = new JSONObject(r);
                JSONObject locs = req.getJSONObject("RestResponse");
                JSONArray recs = locs.getJSONArray("result");

                for (int i = 0; i < recs.length(); ++i) {
                    JSONObject rec = recs.getJSONObject(i);
                    String nombre = rec.getString("name");
                    String codigoUno = rec.getString("alpha2_code");
                    String codigoDos = rec.getString("alpha3_code");
                    Pais pais = new Pais(nombre,codigoUno,codigoDos);
                    model.add(pais);
                }

               // Log.v(TAG_IMG, "-+++--,,,,,,,,,,->" + a);



            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Log.v(TAG_IMG, "------>" + object.getJSONObject("result").getString("result"));

/*

                for (int i = 0; i < json_array.length(); i++) {

                    JSONObject jsonobject = json_array.getJSONObject(i);
                    String nombre = jsonobject.getString("name");
                    String codigoUno = jsonobject.getString("alpha2_code");
                    String codigoDos = jsonobject.getString("alpha3_code");
                    Pais pais = new Pais(nombre,codigoUno,codigoDos);
                    System.out.println("********************"+nombre);
                    System.out.println(codigoDos);

                    Toast.makeText(getApplicationContext(),pais.toString(), Toast.LENGTH_SHORT).show();


                }*/


        }



        // metodo para bajar el contenido
        private String loadContentFromNetwork(String url) {
            try {
                InputStream mInputStream = (InputStream) new URL(url).getContent();
                InputStreamReader mInputStreamReader = new InputStreamReader(mInputStream);
                BufferedReader responseBuffer = new BufferedReader(mInputStreamReader);
                StringBuilder strBuilder = new StringBuilder();
                String line = null;
                while ((line = responseBuffer.readLine()) != null) {
                    strBuilder.append(line);
                }
                //
                //*Gson mJson = new Gson();
                //*mJson.fromJson(strBuilder.toString(),);//,YourClass.class);
                //
                //*return mJson.toString(); //strBuilder.toString();
                return strBuilder.toString();

            } catch (Exception e) {
                Log.v(TAG_IMG, e.getMessage());
            }
            return null;
        }
    }

    private void servicioREST() {
       // mDataText.setText("/*/ Llamada a web service REST /*/ \n");
        //
        //mDataText.setText(URL_REST);
       // Toast.makeText(getApplicationContext(),URL_REST, Toast.LENGTH_SHORT).show();

        // Tarea AsyncTask para ejecutar la solicitud
        new TaskServicioREST().execute(URL_REST);
    }
}
