package com.marcosapps.vendedoresml.Viewsimport android.content.Intentimport android.graphics.drawable.ColorDrawableimport android.os.Bundleimport android.support.design.widget.Snackbarimport android.support.design.widget.NavigationViewimport android.support.v4.app.Fragmentimport android.support.v4.view.GravityCompatimport android.support.v4.widget.DrawerLayoutimport android.support.v7.app.ActionBarDrawerToggleimport android.support.v7.app.AppCompatActivityimport android.view.Menuimport android.view.MenuItemimport android.widget.EditTextimport android.widget.ImageViewimport android.widget.TextViewimport com.marcosapps.vendedoresml.Banco.PersonQueriesimport com.marcosapps.vendedoresml.Banco.ProductsQueriesimport com.marcosapps.vendedoresml.Models.UserPersonimport com.marcosapps.vendedoresml.Rimport com.squareup.picasso.Picassoimport kotlinx.android.synthetic.main.activity_dashboard_person.*import kotlinx.android.synthetic.main.app_bar_dashboard_person.*import kotlinx.android.synthetic.main.nav_header_dashboard_person.*class DashboardPersonActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_dashboard_person)        setSupportActionBar(toolbar)        supportActionBar!!.setTitle("Lista de Produtos")        nav_view.setNavigationItemSelectedListener(this)        startDefaultFragment()    }    override fun onBackPressed() {        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {            val apelido = findViewById(R.id.title) as TextView            val linkPerfil = findViewById(R.id.subtitle) as TextView            val photoPerson = findViewById(R.id.photoPerson) as ImageView            val person = PersonQueries(this).getPersonDados()            apelido.setText(person.Apelido)            linkPerfil.setText(person.LinkPerfil)            if(person.Logo != "") {                Picasso.get().load(person.Logo)                        .error(R.drawable.ic_menu_gallery)                        .into(photoPerson)            }            drawer_layout.closeDrawer(GravityCompat.START)        } else {            super.onBackPressed()        }    }    private fun startDefaultFragment() {        var fragment: Fragment? = null        val fragmentClass = ProductsList::class.java        try {            fragment = fragmentClass.newInstance()        } catch (e: InstantiationException) {            e.printStackTrace()        } catch (e: IllegalAccessException) {            e.printStackTrace()        }        supportFragmentManager.beginTransaction().replace(R.id.frame_content, fragment!!).commit()    }    override fun onCreateOptionsMenu(menu: Menu): Boolean {        // Inflate the menu; this adds items to the action bar if it is present.        menuInflater.inflate(R.menu.dashboard_person, menu)        return true    }    override fun onOptionsItemSelected(item: MenuItem): Boolean {        // Handle action bar item clicks here. The action bar will        // automatically handle clicks on the Home/Up button, so long        // as you specify a parent activity in AndroidManifest.xml.        when (item.itemId) {            R.id.action_settings -> Sair()        }        return true    }    fun Sair(){        ProductsQueries(this).deleteTable("ProductsML")        ProductsQueries(this).deleteTable("PersonMl")        intent = Intent(this, SearchPersonActivity::class.java)        startActivity(intent)    }    override fun onNavigationItemSelected(item: MenuItem): Boolean {        // Handle navigation view item clicks here.        var fragments: Fragment? = null        val fragmentClass: Class<*>? = null        val id = item.itemId        if (id == R.id.nav_camera) {        } else if (id == R.id.nav_gallery) {        } else if (id == R.id.nav_manage) {        }        try {            fragments = fragmentClass!!.newInstance() as Fragment        } catch (e: InstantiationException) {            e.printStackTrace()        } catch (e: IllegalAccessException) {            e.printStackTrace()        }        val fragmentManager = supportFragmentManager        fragmentManager.beginTransaction().replace(R.id.frame_content, fragments!!).commit()        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)        drawer.closeDrawer(GravityCompat.START)        return true    }}