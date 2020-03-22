package com.marcosapps.vendedoresml.Request

import com.marcosapps.vendedoresml.Utils.ConnectionFactoryHttp
import com.marcosapps.vendedoresml.Utils.UrlServidor
import org.json.JSONObject

class VerificarInformRequest {


    fun executerVerificacao(username:Int?): Boolean {


        val httpsURLConnection = ConnectionFactoryHttp().createHttpsUrlConnection("GET", UrlServidor().VERIFICAUSER + username)

        httpsURLConnection.connect()

        val statusCode = httpsURLConnection.responseCode

        @Suppress("RedundantIf")
        if (statusCode == 201
                || statusCode == 200){

            return false
        }
        else{

            return true
        }
    }
}