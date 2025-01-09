import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun SearchBar(
    searchQuery: String,
    onQueryChanged: (String) -> Unit
) {
    TextField(
        value = searchQuery,
        onValueChange = onQueryChanged,
        placeholder = { Text("Ürün Ara..", color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
    )
}