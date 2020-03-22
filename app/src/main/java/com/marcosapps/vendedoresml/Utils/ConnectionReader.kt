package com.marcosapps.vendedoresml.Utilsimport java.io.BufferedReaderimport java.io.IOExceptionimport java.io.InputStreamimport java.io.InputStreamReaderimport javax.net.ssl.HttpsURLConnectionclass ConnectionReader{    @Throws(IOException::class)    fun readStringFromHttpsURLConnection(sucess: Boolean,                                         httpsURLConnection: HttpsURLConnection): String {        val result = StringBuilder()        val inputStream: InputStream?        if (sucess) {            inputStream = httpsURLConnection.inputStream        } else {            inputStream = httpsURLConnection.errorStream        }        if (inputStream != null) {            val inputStreamReader = InputStreamReader(inputStream)            val bufferedReader = BufferedReader(inputStreamReader)            var character = bufferedReader.read()            while (character != -1) {                result.append(character.toChar())                character = bufferedReader.read()            }            bufferedReader.close()            inputStreamReader.close()            inputStream.close()        }        httpsURLConnection.disconnect()        return result.toString()    }}