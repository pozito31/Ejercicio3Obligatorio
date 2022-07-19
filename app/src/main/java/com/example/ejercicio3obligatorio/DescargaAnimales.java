package com.example.ejercicio3obligatorio;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DescargaAnimales extends AsyncTask<Void, Void, InfoAnimales> {

    private static final String API_WEB_ANIMALES = "https://dog.ceo/api/breeds/image/random";

    private Context actividad_llamante;

    public DescargaAnimales (Context context)
    {
        this.actividad_llamante = context;
    }

    @Override //aquí se produce la comunicación HTTP
    protected InfoAnimales doInBackground(Void... voids) {
        InfoAnimales infoAnimales = null;

        URL url = null; //aquí vamos a poner la ruta
        HttpURLConnection httpURLConnection = null;//esta clase representa el mensajes / la comunicación http
        Gson gson = null;//este objeto me ayuda a (des)serializar JSON a JAVA
        InputStreamReader inputStreamReader = null; //leo el cuerpo del mensaje
        try {
            //todo el proceso de comunicación es susceptible de lanzar una execepción
            //por eso, vamos a agruparlo en un try-catch

            Log.d("ETIQUETA_LOG", "URL búsqueda = " + API_WEB_ANIMALES);
            url = new URL(API_WEB_ANIMALES);
            Log.d("ETIQUETA_LOG", "URL búsqueda url = " + url);
            httpURLConnection = (HttpURLConnection) url.openConnection(); //porque sé que el tipo de conexión es HTTP
            httpURLConnection.setRequestMethod("GET");//consultar, obtener info del servidor, no envío nada (el cuerpo de la petición ,va vacío)
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) //200
            {
                Log.d("ETIQUETA_LOG", "La conexión ha ido bien! - Respuesta OK");
                //accedo al cuerpo de la respuesta httpURLConnection.getInputStream()
                //uso la clase InputStream para leer ese cuerpo
                Log.d("ETIQUETA_LOG", "Obtenidos " +httpURLConnection.getContentLength() + " bytes" );
                Log.d("ETIQUETA_LOG", "TIPO MIME " +httpURLConnection.getContentType() );
                inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                gson = new Gson(); //para pasar el cuerpo de JSON a Resultado canciones
                infoAnimales = gson.fromJson(inputStreamReader, InfoAnimales.class);
            }

        } catch (Exception e) {
            Log.e("ETIQUETA_LOG", "Algo ha salido mal", e);
        } finally {
            //liberar recursos
            try {
                inputStreamReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();


        }


        return infoAnimales;
    }


    protected void onPostExecute(InfoAnimales infoAnimales) {
        //aquí me llame al mainactivity
        super.onPostExecute(infoAnimales);
        MainActivity mainActivity = (MainActivity) this.actividad_llamante;
        mainActivity.mostrarAnimalRecibido(infoAnimales);
    }

}
