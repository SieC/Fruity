package sc.fruity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.Locale

@Composable
fun RowItem(
    modifier : Modifier = Modifier,
    label: String,
    text: String
) {
    Row(modifier = modifier) {
        Text(text = "$label:  ".uppercase(Locale.getDefault()), color = MaterialTheme.colorScheme.primary)
        Text(text = text)
    }
}