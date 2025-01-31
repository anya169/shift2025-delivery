package com.example.delivery

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delivery.frontpage.FrontPageRoute
import com.example.delivery.frontpage.FrontPageScreen
import com.example.delivery.posttypes.PostTypesViewModel
import com.example.delivery.posttypes.PostTypesViewModelFactory


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = PostTypesRoute) {
            composable<PostTypesRoute> {
                val viewModel: PostTypesViewModel = viewModel(factory = PostTypesViewModelFactory(repository))
                PostTypesScreen(
                    viewModel,
                    onItemSelected = { navController.navigate(CitiesRoute) },
                )
            }

            composable<FrontPageRoute> {
                FrontPageScreen(onClick = { navController.navigate(PostTypesRoute) })
                }
            }

            composable<CitiesRoute> {
                FrontPageScreen(onClick = { navController.popBackStack()})
            }
        }
    }
}
