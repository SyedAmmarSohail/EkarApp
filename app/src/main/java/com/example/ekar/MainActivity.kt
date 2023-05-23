package com.example.ekar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ekar.presentation.EkarViewModel
import com.example.ekar.presentation.onboard.ViewOnBoardScreen
import com.example.ekar.presentation.vehicle_detail.VehicleDetailScreen
import com.example.ekar.presentation.map.MapScreen
import com.example.ekar.presentation.navigation.Route
import com.example.ekar.presentation.theme.EkarAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: EkarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EkarAppTheme {
                val navController = rememberNavController()
                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = Route.MAP_SCREEN
                    ) {
                        composable(Route.MAP_SCREEN) {
                            MapScreen(
                                viewModel = viewModel,
                                onNavigateToDetail = {
                                    navController.navigate(
                                        Route.VEHICLE_DETAIL
                                    )
                                }
                            )
                        }
                        composable(Route.VEHICLE_DETAIL) {
                            VehicleDetailScreen(
                                viewModel = viewModel,
                                onNavigateToViewOnBoard = {
                                    navController.navigate(
                                        Route.VIEW_ON_BOARD
                                    )
                                },
                                onNavigateUp = {
                                    navController.navigateUp()
                                }
                            )
                        }
                        composable(Route.VIEW_ON_BOARD) {
                            ViewOnBoardScreen(
                                viewModel = viewModel,
                                onNavigateUp = {
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

