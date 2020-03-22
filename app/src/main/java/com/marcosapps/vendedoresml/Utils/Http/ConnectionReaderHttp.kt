package com.marcosapps.vendedoresml.Utilsimport java.io.BufferedReaderimport java.io.IOExceptionimport java.io.InputStreamimport java.io.InputStreamReaderimport java.net.HttpURLConnectionimport javax.net.ssl.HttpsURLConnectionclass ConnectionReaderHttp{    @Throws(IOException::class)    fun readStringFromHttpsURLConnection(sucess: Boolean,                                         httpURLConnection: HttpURLConnection): String {        val result = StringBuilder()        val inputStream: InputStream?        if (sucess) {            inputStream = httpURLConnection.inputStream        } else {            inputStream = httpURLConnection.errorStream        }        if (inputStream != null) {            val inputStreamReader = InputStreamReader(inputStream)            val bufferedReader = BufferedReader(inputStreamReader)            var character = bufferedReader.read()            while (character != -1) {                result.append(character.toChar())                character = bufferedReader.read()            }            bufferedReader.close()            inputStreamReader.close()            inputStream.close()        }        httpURLConnection.disconnect()        return result.toString()    }}