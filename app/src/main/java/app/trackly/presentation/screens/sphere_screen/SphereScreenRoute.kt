package app.trackly.presentation.screens.sphere_screen

import android.net.Uri

sealed class SphereScreenRoute(val route: String) {
    object Sphere : SphereScreenRoute("sphere/{id}/{title}/{color}") {
        fun createRoute(id: Int, title: String, color: String) =
            "sphere/$id/${Uri.encode(title)}/${Uri.encode(color)}"
    }
}