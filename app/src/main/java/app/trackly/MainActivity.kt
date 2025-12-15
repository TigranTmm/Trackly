package app.trackly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.trackly.presentation.navigation.bottom_bar.BottomNavigationBar
import app.trackly.presentation.navigation.bottom_bar.ButtonItem
import app.trackly.presentation.screens.all_tasks.AllTasksScreen
import app.trackly.presentation.screens.home.HomeScreen
import app.trackly.presentation.screens.profile.ProfileScreen
import app.trackly.presentation.screens.sphere_screen.SphereScreen
import app.trackly.presentation.screens.sphere_screen.SphereScreenRoute
import app.trackly.presentation.ui.theme.BackGr
import app.trackly.presentation.ui.theme.TracklyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(BackGr.toArgb()),
            navigationBarStyle = SystemBarStyle.dark(BackGr.toArgb())
        )
        setContent {
            TracklyTheme(darkTheme = true) {
                val navController = rememberNavController()

                val currentRoute = navController
                    .currentBackStackEntryAsState()
                    .value
                    ?.destination
                    ?.route

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            currentRoute = currentRoute,
                            onNavigate = { route ->
                                navController.navigate(route) {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    restoreState = true
                                }
                            }
                        )
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = ButtonItem.Home.route,
                        modifier = Modifier
                            .padding(padding)
                    ) {
                        composable(ButtonItem.Home.route) { HomeScreen(navController) }
                        composable(ButtonItem.Profile.route) { ProfileScreen() }
                        composable(ButtonItem.AllTask.route) { AllTasksScreen() }


                        composable(
                            route = SphereScreenRoute.Sphere.route,
                            arguments = listOf(
                                navArgument("id") { type = NavType.IntType },
                                navArgument("title") { type = NavType.StringType },
                                navArgument("color") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            SphereScreen(
                                id = backStackEntry.arguments!!.getInt("id"),
                                title = backStackEntry.arguments!!.getString("title")!!,
                                color = backStackEntry.arguments!!.getString("color")!!
                            )
                        }
                    }
                }



            }
        }
    }
}
