package com.marcosapps.vendedoresml.Task

import android.os.AsyncTask
import com.marcosapps.vendedoresml.Models.UserPerson
import com.marcosapps.vendedoresml.Request.BuscarPersonRequest
import com.marcosapps.vendedoresml.Request.EnviarDadosPersonRequest
import com.marcosapps.vendedoresml.Request.VerificarInformRequest
import com.marcosapps.vendedoresml.Utils.DialogCustom
import com.marcosapps.vendedoresml.Views.SearchPersonActivity
import org.json.JSONObject
import java.lang.ref.WeakReference

class BuscaInfoBase(context: SearchPersonActivity) : AsyncTask<Int, Void, Boolean>() {

    private val activityReference: WeakReference<SearchPersonActivity> = WeakReference(context)

    //private var result: JSONObject? = null

    override fun onPreExecute() {

        super.onPreExecute()

    }

    override fun doInBackground(vararg params: Int?): Boolean? {

        val user = params[0]

        val buscarInfoBase = VerificarInformRequest()

        val personJson: Boolean? = buscarInfoBase.executerVerificacao(user)

        return personJson
    }

    override fun onPostExecute(result: Boolean?) {

        super.onPostExecute(result)

        val activity = activityReference.get()

        activity?.isPlay = true

        if (activity != null) {

            if (result == true) {

                //EnviarDadosPersonRequest().executeDadosRequest(activity)
            }
            else
                if (true) {


            }
        }
    }
}