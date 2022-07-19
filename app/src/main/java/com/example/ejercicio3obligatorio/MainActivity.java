package com.example.ejercicio3obligatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO DEBERIAMOS CONTROLAR QUE HAY ACCESO A ITERNET
        DescargaAnimales descargaAnimales = new DescargaAnimales(this);
        descargaAnimales.execute();
    }

    public void mostrarAnimalRecibido(InfoAnimales infoAnimales) {
        Log.d("ETIQUETA_LOG" ,"Perro rx = " + infoAnimales.toString());
        //TODO USAR PICASO PARA LA URL DE LA IMAGEN QUE RECIBO, CARGARLA EN UN IMAGEVIEW
    }
}