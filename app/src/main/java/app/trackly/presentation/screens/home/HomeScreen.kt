package app.trackly.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.trackly.R
import app.trackly.presentation.ui.theme.BackGr
import app.trackly.presentation.ui.theme.Border
import app.trackly.presentation.ui.theme.Montserrat
import app.trackly.presentation.ui.theme.ShapeBg
import app.trackly.presentation.ui.theme.ShapeBorder
import app.trackly.presentation.ui.theme.Text

@Composable
fun HomeScreen(
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
                text = stringResource(id = R.string.home_title),
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Text,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 32.dp)
                    .fillMaxWidth()
            )

            // STRICK
            Box(
                modifier = Modifier
                    .background(
                        color = ShapeBg,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = ShapeBorder,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(170.dp)
            ) {
                Text(
                    text = stringResource(R.string.days_completed),
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    color = Text,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // SPHERES_TITLE
            Text(
                text = stringResource(R.string.spheres),
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Text
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ADD_SPHERE_BUTTON
            Box(
                modifier = Modifier
                    .drawBehind {
                        val strokeWidth = 2.dp.toPx()
                        val dashWidth = 8.dp.toPx()
                        val gapWidth = 8.dp.toPx()

                        drawRoundRect(
                            color = ShapeBorder,
                            style = Stroke(
                                width = strokeWidth,
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(dashWidth, gapWidth)
                                )
                            ),
                            cornerRadius = CornerRadius(16.dp.toPx())
                        )
                    }
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(32.dp)
            ) {
                Row(modifier = Modifier
                    .align(Alignment.Center),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.add_icon),
                        contentDescription = "add_icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(32.dp)
                    )
                    Text(
                        text = stringResource(R.string.add_sphere),
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Medium,
                        color = Border,
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // SPHERES
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun prev() {
    HomeScreen()
}
