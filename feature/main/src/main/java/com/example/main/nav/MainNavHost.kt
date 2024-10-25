package com.example.main.nav

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.mvrx.compose.mavericksViewModel
import com.airbnb.mvrx.hellohilt.ProductMavericksViewModel
import com.example.main.home.HomeRoute
import com.example.main.home.HomeViewModel
import com.example.main.home.LinkRoute

@Composable
fun MainNavHost(
    homeViewModel: HomeViewModel=  hiltViewModel(),
    productMavericksViewModel: ProductMavericksViewModel = mavericksViewModel()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoute.MainScreen.name
    ) {
        composable(
            route = MainRoute.MainScreen.name,
            enterTransition = {
                null
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }
        ) {
            HomeRoute(
                viewModel = homeViewModel,
                productMavericksViewModel = productMavericksViewModel,
                onNavigateToDetailScreen = { reservation ->
                    productMavericksViewModel.setLink(reservation)
                    navController.navigate(MainRoute.WebViewScreen.name)
                }
            )
        }
        composable(
            route = MainRoute.WebViewScreen.name,
            arguments = listOf(
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) { backStackEntry ->
//            val url = backStackEntry.arguments?.getString("reservation")
//            val reservation = Json.decodeFromString<String>(reservationJson!!)
            LinkRoute(
                viewModel2 = productMavericksViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}