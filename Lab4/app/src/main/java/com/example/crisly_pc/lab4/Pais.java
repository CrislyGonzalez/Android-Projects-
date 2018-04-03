package com.example.crisly_pc.lab4;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Crisly-PC on 02/06/2017.
 */

public class Pais {
    private String nombre;
    private String codigo1;
    private String codigo2;

    public static ArrayList<Bitmap> gallery;

    public Pais(String nombre, String codigo1, String codigo2) {
        this.nombre = nombre;
        this.codigo1 = codigo1;
        this.codigo2 = codigo2;
    }


    public static void setGallery(Bitmap image) {
        gallery.add(image);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(String codigo1) {
        this.codigo1 = codigo1;
    }

    public String getCodigo2() {
        return codigo2;
    }

    public void setCodigo2(String codigo2) {
        this.codigo2 = codigo2;
    }
}
