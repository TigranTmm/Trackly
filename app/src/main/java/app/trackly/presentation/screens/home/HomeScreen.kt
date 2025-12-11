package app.trackly.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trackly.presentation.ui.theme.BackGr

@Composable
fun HomeScreen(
    //navController: NavController,
    //viewModel: HomeScreenViewModel
) {
    Scaffold(
        containerColor = Color.White
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                text = "HOME",
                modifier = Modifier
                    .padding(32.dp)
            )
        }
    }
}
