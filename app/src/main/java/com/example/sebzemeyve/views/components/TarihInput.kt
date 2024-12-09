package com.example.sebzemeyve.views.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun TarihInput(onTarihChange: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onTarihChange(it)
        },
        label = { Text("Tarih (Yıl-Ay-Gün)") },
        placeholder = { Text("Örneğin: 2020-12-26") },
        modifier = Modifier.fillMaxWidth()
    )
}
