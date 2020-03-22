package com.marcosapps.vendedoresml.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.marcosapps.vendedoresml.Models.Products
import com.marcosapps.vendedoresml.R
import com.squareup.picasso.Picasso
import java.net.URI
import java.net.URL
import kotlin.collections.ArrayList
import android.graphics.Typeface



class ItemAdapterProduct(val list: ArrayList<Products>, val context: Context): RecyclerView.Adapter<ItemAdapterProduct.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val titulo = view.findViewById(R.id.titulo) as TextView
        val preco = view.findViewById(R.id.price) as TextView
        val condicao = view.findViewById(R.id.condicao) as TextView
        val accptmp = view.findViewById(R.id.accptmp) as TextView
        val taxa = view.findViewById(R.id.taxaml) as TextView
        val category = view.findViewById(R.id.category) as View
        val imagem = view.findViewById(R.id.imgemProduct) as ImageView
        val btnBuy = view.findViewById(R.id.btnBuy) as Button
    }

    override fun onCreateViewHolder(holder: ViewGroup, position: Int): ItemAdapterProduct.ItemViewHolder {
        val v = LayoutInflater.from(holder.context).inflate(R.layout.item_list_product, holder, false)
        val ivh = ItemViewHolder(v)

        return ivh
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemAdapterProduct.ItemViewHolder, position: Int) {
        val titulo = list[position].Titulo
        if (titulo.length > 30){
            holder.titulo.setText(list[position].Titulo.substring(0,30) + "...")
        }else{
            holder.titulo.setText(list[position].Titulo)
        }
        holder.preco.text = "Preço: R$"+list[position].Preco.toString()

        val condicao = list[position].Condicao
            if (condicao.contains("new")){ holder.condicao.text = "Condição: Novo" }
                else{ holder.condicao.text = "Condição: Usado" }

        val acceptml = list[position].AcceptMercadoPago
        if (acceptml.contains("true")){
            holder.accptmp.text = "MercadoPago: Sim"
        }else{
            holder.accptmp.text = "MercadoPago: Não"
        }

        val category = list[position].Categoria
        if (category.contains("gold_special"))
        {
            holder.taxa.setTextColor(Color.parseColor("#DAA520"))
            holder.category.setBackgroundResource(R.color.colorGold)
        }else
            if(category.contains("gold_pro"))
        {
            holder.taxa.setTextColor(Color.parseColor("#808080"))
            holder.category.setBackgroundResource(R.color.colorPremium)
        }
        else{
            holder.taxa.setTextColor(Color.parseColor("#BC6B1A"))
            holder.category.setBackgroundResource(R.color.colorBronze)
        }

        holder.imagem.setImageBitmap(null)
        Picasso.get().load(list[position].FotoProduct)
                .error(R.drawable.ic_menu_gallery)
                .into(holder.imagem)
        Picasso.get().setIndicatorsEnabled(true)

        holder.btnBuy.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(list[position].LinkProduct))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent)
        }
        //DownloadImageTask(holder?.imagem).execute(list[position].FotoProduct)
    }

    /*class DownloadImageTask(val imageView : ImageView): AsyncTask<String, Void, Bitmap>() {

        override fun doInBackground(vararg params: String?): Bitmap {

            //Recebo o link da imagem e renderizo e codifcio em bitmap
            val url = params[0]

            val stream = URL(url).openStream()
            val bitmap = BitmapFactory.decodeStream(stream)

            //Retornando o bitmap
            return bitmap
        }

        // set a imagem com meu Bitmap
        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }

    }*/

}