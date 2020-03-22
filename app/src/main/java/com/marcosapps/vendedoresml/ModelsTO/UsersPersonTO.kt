package com.marcosapps.vendedoresml.ModelsTO

import com.marcosapps.vendedoresml.Models.Address
import com.marcosapps.vendedoresml.Models.UserPerson
import org.json.JSONObject

class UsersPersonTO(jsonResponse: JSONObject) {

    private var personJson: JSONObject = jsonResponse

    fun getPersonFromJson(): ArrayList<UserPerson> {

        val resultPersonJson = ArrayList<UserPerson>()

        val objPerson:UserPerson

        objPerson = UserPerson()

        objPerson.Id = personJson.getInt("id")
        objPerson.Apelido = personJson.getString("nickname")
        objPerson.RegistroDate = personJson.getString("registration_date")
        objPerson.Nacionalidae = personJson.getString("country_id")
        objPerson.Logo = personJson.getString("logo");
        objPerson.Points = personJson.getInt("points");
        objPerson.LinkPerfil = personJson.getString("permalink");
        objPerson.LevelIdReputacao = personJson.getJSONObject("seller_reputation").getString("level_id")
        objPerson.Periods = personJson.getJSONObject("seller_reputation").getJSONObject("transactions").getString("period")

        //Reputação - Venda
        objPerson.VendaCanceladas = personJson.getJSONObject("seller_reputation").getJSONObject("transactions").getInt("canceled")
        objPerson.VendasCompletas = personJson.getJSONObject("seller_reputation").getJSONObject("transactions").getInt("completed")

        //Reputação - Perfil
        objPerson.RatingNegative = personJson.getJSONObject("seller_reputation").getJSONObject("transactions").getJSONObject("ratings").getDouble("negative")
        objPerson.RatingNeutro = personJson.getJSONObject("seller_reputation").getJSONObject("transactions").getJSONObject("ratings").getDouble("neutral")
        objPerson.RatingPositivo = personJson.getJSONObject("seller_reputation").getJSONObject("transactions").getJSONObject("ratings").getDouble("positive")

        objPerson.Total = personJson.getJSONObject("seller_reputation").getJSONObject("transactions").getInt("total")

        objPerson.CidadeName = personJson.getJSONObject("address").getString("city")
        objPerson.EstadoName = personJson.getJSONObject("address").getString("state")

        objPerson.Status = personJson.getJSONObject("status").getString("site_status")


        resultPersonJson.add(objPerson)

        return resultPersonJson
    }
}