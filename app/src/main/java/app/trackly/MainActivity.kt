package app.trackly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import app.trackly.presentation.screens.home.HomeScreen
import app.trackly.presentation.ui.theme.TracklyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TracklyTheme {
                Text("HELLOOOOOOOOO", fontSize = 72.sp)
            }
        }
    }
}

@Preview
@Composable
fun prev() {
    Text("HELLOOOOOOOOO", fontSize = 72.sp)
}
