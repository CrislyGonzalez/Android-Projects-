package com.example.crisly_pc.lab4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mainImageActivity extends AppCompatActivity {

    TextView nombrePais;
    Button btnCapturarImagen;
    Bundle bundle;
    String nombre;

    ImageView img;
    //Fotos
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File file = new File(ruta_fotos);
    private static final int codigoCamara = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_image);
        nombrePais = (TextView) findViewById(R.id.nombrePais);
        btnCapturarImagen = (Button) findViewById(R.id.btnCapturar);
        img= (ImageView)findViewById(R.id.image_view) ;


        bundle = getIntent().getExtras();
        nombre = bundle.getString("n");
        nombrePais.setText(nombre);
    }


    public void levantarCamara(View v){
        String file = ruta_fotos + getCode() + ".jpg";
        File mi_foto = new File(file);
        try {
            mi_foto.createNewFile();
        } catch (IOException ex) {
            Log.e("ERROR ", "Error:" + ex);
        }
        //
        Uri uri = Uri.fromFile(mi_foto);
        //Abre la camara para tomar la foto
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Retorna a la actividad
        startActivityForResult(cameraIntent, codigoCamara);
    }



    /*Elementos para capturar imagen*/
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {

        Bitmap bitmap;
        Uri camaUri = data.getData();

        if (requestCode == codigoCamara) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "La imagen se guardo en:\n" + camaUri, Toast.LENGTH_LONG).show();
                bitmap = (Bitmap) data.getExtras().get("data");
                img.setImageBitmap(bitmap);

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "La captura de imagen ha sido cancelada.",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Error al capturar la imagen",
                        Toast.LENGTH_LONG).show();
            }
        }

    }



    @SuppressLint("SimpleDateFormat")
    private String getCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = dateFormat.format(new Date());
        String photoCode = "pic_" + date;
        return photoCode;
    }


}
