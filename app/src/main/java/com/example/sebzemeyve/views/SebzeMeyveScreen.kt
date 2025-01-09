package com.example.sebzemeyve.views

import SearchBar
import SebzeMeyveItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.sebzemeyve.models.HalFiyat
import com.example.sebzemeyve.ui.theme.BackgroundColor
import com.example.sebzemeyve.ui.theme.InteractionColor
import com.example.sebzemeyve.viewmodels.SebzeMeyveViewModel
import com.example.sebzemeyve.views.components.SebzeMeyveListesi
import com.example.sebzemeyve.views.components.TarihInput

@Composable
fun SebzeMeyveScreen(viewModel: SebzeMeyveViewModel = viewModel()) {

    val sebzeMeyveFiyatlar by viewModel.sebzeMeyveFiyatlar
    var inputTarih by remember { mutableStateOf("") }
    var searchQuery by remember { mutableStateOf("") }
    val errorMessage by viewModel.errorMessage

    val filteredSebzeMeyveFiyatlar = remember(sebzeMeyveFiyatlar, searchQuery) {
        sebzeMeyveFiyatlar.filter { it.MalAdi.contains(searchQuery, ignoreCase = true) }
    }

    Column(modifier = Modifier.padding(top = 65.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            TarihInput(onTarihChange = { inputTarih = it })
            ElevatedButton(
                onClick = {
                    if (inputTarih.isEmpty()) {
                        viewModel.setErrorMessage("Hangi Tarihin Pazar Fiyatlarını Görmek İstiyorsunuz?")
                    } else {
                        viewModel.getSebzeMeyveFiyatlar(inputTarih) { success ->
                            if (!success) {
                                viewModel.setErrorMessage("Lütfen Geçerli Bir Tarih Giriniz.")
                            }
                        }
                    }
                },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = InteractionColor,
                    contentColor = BackgroundColor
                ),
            ) {
                Text("Verileri Getir")
            }
        }

        Column(modifier = Modifier.padding(top = 25.dp, bottom = 25.dp)) {
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            if (sebzeMeyveFiyatlar.isNotEmpty()) {
                SearchBar(
                    searchQuery = searchQuery,
                    onQueryChanged = { searchQuery = it },
                )
                SebzeMeyveListesi(filteredSebzeMeyveFiyatlar)
            }
        }

    }
}


