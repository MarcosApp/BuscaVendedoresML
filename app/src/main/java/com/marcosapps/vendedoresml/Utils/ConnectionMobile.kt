package com.marcosapps.vendedoresml.Utils

import android.content.Context
import android.net.ConnectivityManager

class ConnectionMobile {

    fun isConected(cont: Context): Boolean {

        val conmag = cont.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (conmag != null) {
            conmag.activeNetworkInfo

            //Verifica internet pela WIFI
            if (conmag.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected) {
                return true
            }

            //Verifica se tem internet móvel
            if (conmag.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected) {
                return true
            }
        }

        return false
    }
}