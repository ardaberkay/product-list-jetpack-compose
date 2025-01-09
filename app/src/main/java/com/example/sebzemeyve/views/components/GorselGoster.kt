package com.example.sebzemeyve.views.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun GorselGoster(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Ürün Görseli",
        modifier = Modifier
            .size(120.dp)
            .padding(8.dp),
        contentScale = ContentScale.Crop
    )
}