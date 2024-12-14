import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sebzemeyve.models.HalFiyat
import com.example.sebzemeyve.ui.theme.HeaderTextColor
import com.example.sebzemeyve.ui.theme.TextColor

@Composable
fun SebzeMeyveItem(halFiyat: HalFiyat) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = halFiyat.MalAdi, fontWeight = FontWeight.Bold, color = HeaderTextColor)
        Text(text = "Birim: ${halFiyat.Birim}", color = TextColor)
        Text(text = "Asgari Ücret: ${halFiyat.AsgariUcret} ₺", color = TextColor)
        Text(text = "Azami Ücret: ${halFiyat.AzamiUcret} ₺", color = TextColor)
        Text(text = "Ortalama Ücret: ${halFiyat.OrtalamaUcret} ₺", color = TextColor)
    }
}