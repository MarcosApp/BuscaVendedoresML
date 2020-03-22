package com.marcosapps.vendedoresml.Taskimport android.animation.Animatorimport android.content.Intentimport android.os.AsyncTaskimport android.support.v4.content.ContextCompat.startActivityimport android.util.Logimport android.view.Viewimport com.marcosapps.vendedoresml.Banco.ProductsQueriesimport com.marcosapps.vendedoresml.ModelsTO.ProductsTOimport com.marcosapps.vendedoresml.Rimport com.marcosapps.vendedoresml.Request.BuscarInformRequestimport com.marcosapps.vendedoresml.Request.VerificarInformRequestimport com.marcosapps.vendedoresml.Utils.DialogCustomimport com.marcosapps.vendedoresml.Utils.MyPreferencesimport com.marcosapps.vendedoresml.Views.DashboardPersonActivityimport com.marcosapps.vendedoresml.Views.SearchPersonActivityimport kotlinx.android.synthetic.main.activity_main.*import org.json.JSONObjectimport java.lang.ref.WeakReferenceclass BuscarInforUsuario(context: SearchPersonActivity) : AsyncTask<String, Void, JSONObject>() {    private val activityReference: WeakReference<SearchPersonActivity> = WeakReference(context)    private var result: JSONObject? = null    val myPreferences = MyPreferences(context)    val activity = activityReference.get()    override fun onPreExecute() {        super.onPreExecute()        if (activity == null || activity.isFinishing) return        activity.animation_search.visibility = View.VISIBLE        activity.animation_search.playAnimation()        activity.animation_search.addAnimatorListener(object : Animator.AnimatorListener {            override fun onAnimationStart(animation: Animator) {            }            override fun onAnimationEnd(animation: Animator) {                if (activity.isPlay == false) {                    activity.animation_search.playAnimation()                } else if (activity.isPlay == true && result != null) {                    val intent = Intent(activity, DashboardPersonActivity::class.java)                    activity.finish()                    startActivity(activity, intent, null)                }            }            override fun onAnimationCancel(animation: Animator) {            }            override fun onAnimationRepeat(animation: Animator) {            }        })    }    override fun doInBackground(vararg strings: String): JSONObject? {        val user = strings[0]        val buscarPersonRequest = BuscarInformRequest(this.activityReference.get()?.applicationContext!!)        val personJson: JSONObject? = buscarPersonRequest.executeLoginRequest(user)        return personJson    }    override fun onPostExecute(result: JSONObject?) {        super.onPostExecute(result)        this.result = result        val activity = activityReference.get()        activity?.isPlay = true        if (activity != null) {            if (result == null) {                DialogCustom().DialogMessage(activity, activity.getString(R.string.vendedor_naoencontrado),                        activity.getString(R.string.verifique_dados))                activity.animation_search.visibility = View.GONE                activity.cardMain.visibility = View.VISIBLE            }            else if (true) {                val userKey = myPreferences.getChaveUser()                BuscarPersonUsuario(activity).execute(userKey)                val productsTO = ProductsTO(result)                val product = productsTO.getPersonFromJson()                BuscaInfoBase(activity).execute(userKey)                ProductsQueries(activity).InserteDbProduct(product)            }        }    }}