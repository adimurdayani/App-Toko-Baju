package com.nurmiati.tok_ko.core.data.model

class ResponsModel {
    var success = 0
    lateinit var message: String
    var data = User()
    var produk: ArrayList<Produk> = ArrayList()
    var transaksis: ArrayList<Transaksi> = ArrayList()
    var user: ArrayList<User> = ArrayList()
    var produklimit: ArrayList<ProdukLimit> = ArrayList()

    var rajaongkir = ModelAlamat()
    var transaksi = Transaksi()

    var provinsi: ArrayList<ModelAlamat> = ArrayList()
    var kota_kabupaten: ArrayList<ModelAlamat> = ArrayList()
    var kecamatan: ArrayList<ModelAlamat> = ArrayList()
}
