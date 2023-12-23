import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun App() {
    MaterialTheme {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = "Welcome to the app",
            textAlign = TextAlign.Center
        )
    }
}