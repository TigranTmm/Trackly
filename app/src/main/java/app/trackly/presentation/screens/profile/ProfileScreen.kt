package app.trackly.presentation.screens.profile

import android.graphics.Paint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.trackly.R
import app.trackly.presentation.ui.theme.BackGr
import app.trackly.presentation.ui.theme.Montserrat
import app.trackly.presentation.ui.theme.Text

@Composable
fun ProfileScreen(
    //navController: NavController,
    //viewModel: HomeScreenViewModel
) {
    Scaffold(
        containerColor = BackGr
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.profile_title),
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Text,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 32.dp)
                    .fillMaxWidth()
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun prev() {
    ProfileScreen()
}
