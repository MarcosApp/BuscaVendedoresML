package com.marcosapps.vendedoresml.Bancoimport android.content.Contextimport android.database.sqlite.SQLiteDatabaseimport android.database.sqlite.SQLiteOpenHelperclass DatabaseML(context: Context) :        SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {    override fun onCreate(db: SQLiteDatabase?) {        db?.execSQL("CREATE TABLE ProductsMl(" +                "ID INTEGER," +                "IdMLB TEXT," +                "SiteUser TEXT," +                "Titulo TEXT," +                "IdProduct INTEGER," +                "Preco REAL," +                "Moeda TEXT," +                "QuantidadeProduct INTEGER," +                "QuantidadeSold INTEGER," +                "Disponibilidade TEXT," +                "Categoria TEXT," +                "VencimentoDoProductML TEXT," +                "Condicao TEXT," +                "LinkProduct TEXT," +                "FotoProduct TEXT," +                "AcceptMercadoPago REAL," +                "QuantidadeParcel INTEGER," +                "ValorParcela REAL," +                "Taxa REAL," +                "PRIMARY KEY (ID));")        db?.execSQL("CREATE TABLE PersonMl(" +                "ID INTEGER," +                "IdMLB TEXT," +                "Apelido TEXT," +                "RegistroDate TEXT," +                "Nacionalidae TEXT," +                "Logo TEXT," +                "LinkPerfil TEXT," +                "CidadeName TEXT," +                "EstadoName TEXT," +                "Points INTEGER," +                "LevelIdReputacao TEXT," +                "Periods TEXT," +                "VendaCanceladas INTEGER," +                "VendasCompletas INTEGER," +                "RatingNegative REAL," +                "RatingNeutro REAL," +                "RatingPositivo REAL," +                "Total INTEGER," +                "Status TEXT," +                "PRIMARY KEY (ID));")    }    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {    }    companion object {        private val DB_NAME = "MLEstatiticasDB"        private val DB_VERSIOM = 1    }}