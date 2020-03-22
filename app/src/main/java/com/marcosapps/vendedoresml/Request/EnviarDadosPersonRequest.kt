package com.marcosapps.vendedoresml.Request

import android.content.Context
import com.marcosapps.vendedoresml.Banco.PersonQueries
import com.marcosapps.vendedoresml.Utils.*
import org.json.JSONObject
import java.io.BufferedOutputStream
import android.os.StrictMode
import android.util.Log


class EnviarDadosPersonRequest {

    fun executeDadosRequest(context:Context): JSONObject? {


        val SDK_INT = android.os.Build.VERSION.SDK_INT
        if (SDK_INT > 8) {
            val policy = StrictMode.ThreadPolicy.Builder()
                    .permitAll().build()
            StrictMode.setThreadPolicy(policy)
            //your codes here
            val person = PersonQueries(context).getPersonDados();



            Log.e("Dados", "Dados1"+person.Id)

            val httpsURLConnection = ConnectionFactoryHttp().createHttpsUrlConnection("POST", UrlServidor().VERIFICAUSER)

            val jsonPerson = JSONObject()
                    .put("IdMLB", person.Id)
                    .put("Apelido", person.Apelido)
                    .put("RegistroDate", person.RegistroDate)
                    .put("Nacionalidade", person.Nacionalidae)
                    .put("Logo", person.Logo)
                    .put("LinkPerfil", person.LinkPerfil)
                    .put("CidadeName", person.CidadeName)
                    .put("EstadoName", person.EstadoName)
                    .put("Points", person.Points)
                    .put("LevelIdReputacao", person.LevelIdReputacao)
                    .put("Periods", person.Periods)
                    .put("VendaCanceladas", person.VendaCanceladas)
                    .put("VendasCompletas", person.VendasCompletas)
                    .put("RatingNegative", person.RatingNegative)
                    .put("RatingNeutro", person.RatingNeutro)
                    .put("RatingPositivo", person.RatingPositivo)
                    .put("Total", person.Total)
                    .put("Status", person.Status)


            //Transforma o objeto JSON em um objeto byte[] com padrão UTF-8

            val jsonPersnBytes = jsonPerson.toString()
                    .toByteArray(charset("UTF-8"))

            httpsURLConnection.setFixedLengthStreamingMode(jsonPersnBytes.size)

            val outputStream = httpsURLConnection.outputStream

            val bufferedOutputStream = BufferedOutputStream(outputStream)

            bufferedOutputStream.write(jsonPersnBytes)

            bufferedOutputStream.flush()

            outputStream.flush()

            bufferedOutputStream.close()

            outputStream.close()

            httpsURLConnection.connect()

            val statusCode = httpsURLConnection.responseCode

            if (statusCode == 201
                    || statusCode == 200) {

                val apiResponse = ConnectionReaderHttp().readStringFromHttpsURLConnection(true, httpsURLConnection)

                httpsURLConnection.disconnect()

                val JsonResponse = JSONObject(apiResponse)

                if (JsonResponse.has("id")) {

                    return JsonResponse
                } else {
                    return null
                }
            } else {

                //var JsonReposta = ConnectionReader().readStringFromHttpsURLConnection(false, httpsURLConnection)

                return null
            }
        }
        return null
    }
}