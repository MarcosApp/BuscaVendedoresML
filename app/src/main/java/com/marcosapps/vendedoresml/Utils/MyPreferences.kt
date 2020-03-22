package com.marcosapps.vendedoresml.Utils

import android.content.Context

class MyPreferences (context: Context) {

    val PREFERENCE_NAME = "SharedPrefML"
    val PREFERENCE_KEY = "ChaveKey"

    val preference= context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getChaveUser(): Int{
        return preference.getInt(PREFERENCE_KEY, 0)
    }

    fun setChaveUser(user:Int){
        val editor = preference.edit()
        editor.putInt(PREFERENCE_KEY, user)
        editor.apply()
    }

}