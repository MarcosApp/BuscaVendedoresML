package com.marcosapps.vendedoresml.Bancoimport android.content.ContentValuesimport android.content.Contextimport android.database.Cursorimport android.database.sqlite.SQLiteDatabaseimport android.database.sqlite.SQLiteExceptionimport android.util.Logimport com.marcosapps.vendedoresml.Models.Productsimport java.util.ArrayListclass ProductsQueries(ctx:Context) {    private val auxDB:DatabaseML = DatabaseML(ctx)    fun InserteDbProduct(productsTO: ArrayList<Products>) {        val db = this.auxDB.writableDatabase        for (products in productsTO) {            val values = ContentValues()            values.put("IdMLB", products.IdMLB)            values.put("SiteUser", products.SiteUser)            values.put("Titulo", products.Titulo)            values.put("IdProduct", products.IdProduct)            values.put("Preco", products.Preco)            values.put("Moeda", products.Moeda)            values.put("QuantidadeProduct", products.QuantidadeProduct)            values.put("QuantidadeSold", products.QuantidadeSold)            values.put("Disponibilidade", products.Disponibilidade)            values.put("Categoria", products.Categoria)            values.put("VencimentoDoProductML", products.VencimentoDoProductML)            values.put("Condicao", products.Condicao)            values.put("LinkProduct", products.LinkProduct)            values.put("FotoProduct", products.FotoProduct)            values.put("AcceptMercadoPago", products.AcceptMercadoPago)            values.put("QuantidadeParcel", products.QuantidadeParcel)            values.put("ValorParcela", products.ValorParcela)            values.put("Taxa", products.Taxa)            db.insert("ProductsMl", null, values)        }        db.close()    }    fun getAllProducts(): ArrayList<Products>? {        val db = this.auxDB.readableDatabase        var productsArray: ArrayList<Products>? = null        val selectALLQuery = "SELECT ID, TITULO, PRECO, DISPONIBILIDADE,CONDICAO, CATEGORIA,LINKPRODUCT, FOTOPRODUCT, ACCEPTMERCADOPAGO FROM ProductsMl"        val cursor:Cursor        cursor = db.rawQuery(selectALLQuery, null)        if (cursor != null) {            if (cursor.moveToFirst()) {                productsArray = ArrayList(cursor.count)                var allProducts:Products                do {                    allProducts = Products()                    allProducts.IdProduct = cursor.getInt(cursor.getColumnIndex("ID"))                    allProducts.Titulo = cursor.getString(cursor.getColumnIndex("Titulo"))                    allProducts.Preco = cursor.getDouble(cursor.getColumnIndex("Preco"))                    allProducts.Disponibilidade = cursor.getString(cursor.getColumnIndex("Disponibilidade"))                    allProducts.Condicao = cursor.getString(cursor.getColumnIndex("Condicao"))                    allProducts.Categoria = cursor.getString(cursor.getColumnIndex("Categoria"))                    allProducts.LinkProduct = cursor.getString(cursor.getColumnIndex("LinkProduct"))                    allProducts.FotoProduct = cursor.getString(cursor.getColumnIndex("FotoProduct"))                    allProducts.AcceptMercadoPago = cursor.getString(cursor.getColumnIndex("AcceptMercadoPago"))                    productsArray.add(allProducts)               }                while (cursor.moveToNext())            }        }        cursor.close()        db.close()        return productsArray    }    fun temDadosGravados(): Boolean {        var temUsuarioLogado = false        val db = this.auxDB.readableDatabase        val cursor = db.rawQuery("SELECT * FROM ProductsMl;", null)        if (cursor != null) {            if (cursor.moveToFirst()) {                temUsuarioLogado = true            }        }        cursor.close()        db.close()        return temUsuarioLogado    }    fun deleteTable(nameTable:String) {        val db = this.auxDB.writableDatabase        db.beginTransaction()        try {            db.delete(nameTable,                    null, null)            db.setTransactionSuccessful()        } catch (e: Exception) {            e.printStackTrace()        } finally {            db.endTransaction()        }    }}