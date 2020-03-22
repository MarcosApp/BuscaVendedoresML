package com.marcosapps.vendedoresml.ModelsTOimport com.marcosapps.vendedoresml.Models.Productsimport org.json.JSONObjectclass ProductsTO(jsonResponse: JSONObject) {    private var personJson: JSONObject = jsonResponse    fun getPersonFromJson():ArrayList<Products> {        val resultPersonJson = ArrayList<Products>()        //var tamanho:Int = personJson?.length()!!        val jsonUser = personJson?.getJSONArray("results")        var objProducts:Products        for (n in 0 until jsonUser.length())        {            objProducts = Products()            objProducts.IdMLB = jsonUser.getJSONObject(n).getString("id")            objProducts.SiteUser = jsonUser.getJSONObject(n).getString("site_id")            objProducts.Titulo = jsonUser.getJSONObject(n).getString("title")            objProducts.IdProduct = jsonUser.getJSONObject(n).getJSONObject("seller").getInt("id")            objProducts.Preco = jsonUser.getJSONObject(n).getDouble("price")            objProducts.Moeda = jsonUser.getJSONObject(n).getString("currency_id")            objProducts.QuantidadeProduct = jsonUser.getJSONObject(n).getInt("available_quantity")            objProducts.QuantidadeSold = jsonUser.getJSONObject(n).getInt("sold_quantity")            objProducts.Disponibilidade = jsonUser.getJSONObject(n).getString("buying_mode")            objProducts.Categoria = jsonUser.getJSONObject(n).getString("listing_type_id")            objProducts.VencimentoDoProductML = jsonUser.getJSONObject(n).getString("stop_time")            objProducts.Condicao = jsonUser.getJSONObject(n).getString("condition")            objProducts.LinkProduct = jsonUser.getJSONObject(n).getString("permalink")            objProducts.FotoProduct = jsonUser.getJSONObject(n).getString("thumbnail")            objProducts.AcceptMercadoPago = jsonUser.getJSONObject(n).getString("accepts_mercadopago")            if (!jsonUser.getJSONObject(n).isNull("installments")) {                objProducts.QuantidadeParcel = jsonUser.getJSONObject(n).getJSONObject("installments").getInt("quantity")                objProducts.ValorParcela = jsonUser.getJSONObject(n).getJSONObject("installments").getDouble("amount")                objProducts.Taxa = jsonUser.getJSONObject(n).getJSONObject("installments").getDouble("rate")            }            resultPersonJson.add(objProducts)        }        return resultPersonJson    }}