package com.nurmiati.tok_ko.core.data.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nurmiati.tok_ko.DetailActivity
import com.nurmiati.tok_ko.R
import com.nurmiati.tok_ko.core.data.model.Produk
import com.nurmiati.tok_ko.util.Helper
import com.nurmiati.tok_ko.util.Util
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterProduk(var activity: Activity, var data: ArrayList<Produk>) :
    RecyclerView.Adapter<AdapterProduk.HolderData>() {
    class HolderData(view: View) : RecyclerView.ViewHolder(view) {
        val tv_nama = view.findViewById<TextView>(R.id.nama_produk)
        val tv_harga = view.findViewById<TextView>(R.id.harga)
        val tv_gambar = view.findViewById<ImageView>(R.id.image)
        val layout = view.findViewById<CardView>(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderData {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return HolderData(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HolderData, position: Int) {

        holder.tv_nama.text = data[position].name
        holder.tv_harga.text = Helper().formatRupiah(data[position].harga)
            .format(Integer.valueOf(data[position].harga))
        val imageUrl =
            Util.produkUrl + data[position].image
        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_image)
            .into(holder.tv_gambar)

        holder.layout.setOnClickListener {
            val intent = Intent(activity, DetailActivity::class.java)
            val str = Gson().toJson(data[position], Produk::class.java)
            intent.putExtra("extra", str)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}