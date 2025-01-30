package com.example.delivery

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delivery.data.PostTypesRepository
import com.example.delivery.posttypes.PostTypesRoute
import com.example.delivery.posttypes.PostTypesScreen

@Composable
fun PostScreen(repository: PostTypesRepository) {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = PostTypesRoute) {
            composable<PostTypesRoute> {
                PostTypesScreen(
                    repository = repository,
                    onItemSelected = { /*TODO Добавит навигацию на экран деталей*/ },
                )
            }
        }
    }
}