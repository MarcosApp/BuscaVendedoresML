package com.marcosapps.vendedoresml.Utilsimport java.io.IOExceptionimport java.net.URLimport javax.net.ssl.HttpsURLConnectionclass ConnectionFactory {    @Throws(IOException::class)    fun createHttpsUrlConnection(httpMethod: String, urlServidor: String) : HttpsURLConnection{        val httpsURLConnection = URL(urlServidor).openConnection() as HttpsURLConnection        httpsURLConnection.connectTimeout = 0        httpsURLConnection.readTimeout = 0        //Setar o tipo de método recebido (GET, POST, etc)        httpsURLConnection.requestMethod = httpMethod        //Setar a propriedade do Request        httpsURLConnection.setRequestProperty("Content-Type", "application/json")        if (httpMethod == "POST") {            httpsURLConnection.doOutput = true        }        /*if (token != null) {            //Setar o token como value da key Authorization            httpsURLConnection.setRequestProperty("Authorization", token)        }*/        return httpsURLConnection    }}