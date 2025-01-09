package com.example.sebzemeyve.views.components

import SebzeMeyveItem
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sebzemeyve.models.HalFiyat

@Composable
fun SebzeMeyveListesi(sebzeMeyveFiyatlar: List<HalFiyat>) {
    val baseImageUrl = "https://www.bizizmir.com/YuklenenDosyalar/Hal/"
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(sebzeMeyveFiyatlar) { halFiyat ->
            Row(modifier = Modifier.fillMaxWidth()) {
                val imageUrl = baseImageUrl + halFiyat.Gorsel
                GorselGoster(imageUrl)
                SebzeMeyveItem(halFiyat = halFiyat)
            }
        }
    }
}
