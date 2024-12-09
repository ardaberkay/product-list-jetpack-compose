package com.example.sebzemeyve.models

data class HalFiyat(
    val OrtalamaUcret: Double,
    val MalAdi: String,
    val Birim: String,
    val AsgariUcret: Double,
    val AzamiUcret: Double,
    val MalId: Int,
    val tarih: String?,
    val HalTuru: Int,
    val MalTipId: Int,
    val MalTipAdi: String,
    val Gorsel: String
)

data class SebzeMeyveResponse(
    val BultenTarihi: String,
    val HalFiyatListesi: List<HalFiyat>
)