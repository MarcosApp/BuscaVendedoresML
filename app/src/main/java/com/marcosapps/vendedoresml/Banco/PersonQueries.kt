package com.marcosapps.vendedoresml.Banco

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import com.marcosapps.vendedoresml.Models.Products
import com.marcosapps.vendedoresml.Models.UserPerson

class PersonQueries (ctx:Context) {

    private val auxDB:DatabaseML = DatabaseML(ctx)

    fun InsertDbPerson (personTO: ArrayList<UserPerson>){

        val db = this.auxDB.writableDatabase

        for (person in personTO) {

            val values = ContentValues()

            values.put("IdMLB", person.Id)
            values.put("Apelido", person.Apelido)
            values.put("RegistroDate", person.RegistroDate)
            values.put("Nacionalidae", person.Nacionalidae)
            values.put("Logo", person.Logo)
            values.put("LinkPerfil", person.LinkPerfil)
            values.put("CidadeName", person.CidadeName)
            values.put("EstadoName", person.EstadoName)
            values.put("Points", person.Points)
            values.put("LevelIdReputacao", person.LevelIdReputacao)
            values.put("Periods", person.Periods)
            values.put("VendaCanceladas", person.VendaCanceladas)
            values.put("VendasCompletas", person.VendasCompletas)
            values.put("RatingNegative", person.RatingNegative)
            values.put("RatingNeutro", person.RatingNeutro)
            values.put("RatingPositivo", person.RatingPositivo)
            values.put("Total", person.Total)
            values.put("Status", person.Status)

            db.insert("PersonMl", null, values);
        }

        db.close()
    }

    fun getPersonDados(): UserPerson {

        val db = this.auxDB.readableDatabase

        val selectALLQuery = "SELECT * FROM PersonMl"

        val cursor: Cursor

        val allUser: UserPerson

        allUser = UserPerson()

        cursor = db.rawQuery(selectALLQuery, null)

        if (cursor != null) {


            if (cursor.moveToFirst()) {

                allUser.Id = cursor.getInt(1)
                allUser.Apelido = cursor.getString(2)
                allUser.RegistroDate = cursor.getString(3)
                allUser.Nacionalidae = cursor.getString(4)
                allUser.Logo = cursor.getString(5)
                allUser.LinkPerfil = cursor.getString(6)
                allUser.CidadeName = cursor.getString(7)
                allUser.EstadoName = cursor.getString(8)
                allUser.Points = cursor.getInt(9)
                allUser.LevelIdReputacao = cursor.getString(10)
                allUser.Periods = cursor.getString(11)
                allUser.VendaCanceladas = cursor.getInt(12)
                allUser.VendasCompletas = cursor.getInt(13)
                allUser.RatingNegative = cursor.getDouble(14)
                allUser.RatingNeutro = cursor.getDouble(15)
                allUser.RatingPositivo = cursor.getDouble(16)
                allUser.Total = cursor.getInt(17)
                allUser.Status = cursor.getString(18)
            }
        }
        cursor.close()
        db.close()
        return allUser;
    }


}