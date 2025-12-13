package app.trackly.presentation.screens.all_tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import app.trackly.presentation.ui.theme.ShapeBg
import app.trackly.presentation.ui.theme.ShapeBorder
import app.trackly.presentation.ui.theme.Text

@Composable
fun AllTasksScreen(
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
            // TITLE
            Text(
                text = stringResource(id = R.string.all_tasks_title),
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
fun Prev() {
    AllTasksScreen()
}
