package com.example.ejercicio3obligatorio;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;

public class UtilRed {
    public static boolean hayWifiViejo(Context context) {
        boolean br = false;
        ConnectivityManager cm = null;
        NetworkInfo ni = null;

        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        ni = cm.getActiveNetworkInfo();
        br = ((null != ni) && (ni.isConnected()) && (ni.getType() == ConnectivityManager.TYPE_WIFI));

        return br;
    }

    public static boolean hayDatos345gViejo(Context context) {
        boolean br = false;
        ConnectivityManager cm = null;
        NetworkInfo ni = null;

        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        ni = cm.getActiveNetworkInfo();
        br = ((null != ni) && (ni.isConnected()) && (ni.getType() == ConnectivityManager.TYPE_MOBILE));

        return br;
    }

    public static boolean hayInternetViejo(Context context) {
        boolean hayInternet = false;
        ConnectivityManager cm = null;
        NetworkInfo ni = null;

        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        ni = cm.getActiveNetworkInfo();
        hayInternet = (null != ni)&&(ni.isAvailable())&&(ni.isConnected());

        return hayInternet;
    }

    public static boolean hayWifiNuevo (Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean hay_wifi = false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R)
        {
            Log.d("MIAPP", "Comprobando internet desde version >= 30");
            Network network = connectivityManager.getActiveNetwork();
            if (network!=null)
            {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                hay_wifi = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
            }


        } else {

            Log.d("MIAPP", "Comprobando internet desde version < 30");
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null)
            {
                hay_wifi = (networkInfo.isAvailable() && networkInfo.isConnected()&&(networkInfo.getType()==ConnectivityManager.TYPE_WIFI));
            }

        }


        return  hay_wifi;
    }

}
