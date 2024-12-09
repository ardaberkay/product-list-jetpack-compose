package com.example.sebzemeyve.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sebzemeyve.models.HalFiyat
import com.example.sebzemeyve.viewmodels.SebzeMeyveViewModel
import com.example.sebzemeyve.views.components.TarihInput

@Composable
fun SebzeMeyveScreen(viewModel: SebzeMeyveViewModel = viewModel()) {

    val sebzeMeyveFiyatlar by viewModel.sebzeMeyveFiyatlar
    var inputTarih by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(top = 50.dp, start = 16.dp, end = 16.dp)) {
        TarihInput(onTarihChange = { inputTarih = it })

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    if (inputTarih.isNotEmpty()) {
                        viewModel.getSebzeMeyveFiyatlar(inputTarih)
                    }
                }
            ) {
                Text("Verileri Getir")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        SebzeMeyveListesi(sebzeMeyveFiyatlar)
    }
}

@Composable
fun SebzeMeyveListesi(sebzeMeyveFiyatlar: List<HalFiyat>) {
    val baseImageUrl = "https://www.bizizmir.com/YuklenenDosyalar/Hal/"
    val viewModel: SebzeMeyveViewModel = viewModel()
    LazyColumn {
        items(sebzeMeyveFiyatlar) { halFiyat ->
            Row {
                viewModel.GorselGoster(imageUrl = baseImageUrl + halFiyat.Gorsel)
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Ürün: ${halFiyat.MalAdi}", fontWeight = FontWeight.Bold)
                    Text(text = "Birim ${halFiyat.Birim}")
                    Text(text = "Asgari Ücret: ${halFiyat.AsgariUcret} ₺")
                    Text(text = "Azami Ücret: ${halFiyat.AzamiUcret} ₺")
                    Text(text = "Ortalama Ücret: ${halFiyat.OrtalamaUcret} ₺")
                }
            }
        }
    }
}

