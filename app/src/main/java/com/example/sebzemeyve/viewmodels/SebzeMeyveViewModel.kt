package com.example.sebzemeyve.viewmodels

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImage
import com.example.sebzemeyve.models.HalFiyat
import com.example.sebzemeyve.models.services.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SebzeMeyveViewModel : ViewModel() {
    private val _sebzeMeyveFiyatlar = mutableStateOf<List<HalFiyat>>(emptyList())
    val sebzeMeyveFiyatlar: State<List<HalFiyat>> = _sebzeMeyveFiyatlar
    val errorMessage = mutableStateOf("")

    private val apiService = Retrofit.Builder()
        .baseUrl("https://openapi.izmir.bel.tr/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getSebzeMeyveFiyatlar(date: String, onResult: (Boolean) -> Unit = {}) {
        viewModelScope.launch {
            try {
                val response = apiService.getSebzeMeyveFiyatlar(date)
                if (response.HalFiyatListesi.isEmpty()) {
                    setErrorMessage("Bu tarihe ait veriler bulunamadı.")
                    onResult(false)
                } else {
                    _sebzeMeyveFiyatlar.value = response.HalFiyatListesi
                    setErrorMessage("")
                    onResult(true)
                }
            } catch (e: Exception) {
                setErrorMessage("Veriler getirilirken bir hata oluştu: ${e.localizedMessage}")
                onResult(false)
            }
        }
    }

    fun setErrorMessage(message: String) {
        errorMessage.value = message
    }
}
