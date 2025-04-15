package edu.quinnipiac.ser210.travelmateapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import edu.quinnipiac.ser210.travelmateapp.screens.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelMateNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBackButton = currentRoute != Screens.HomeScreen.name

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Travel Mate") },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.HomeScreen.name) {
                HomeScreen(navController)
            }
            composable(Screens.BrowseCountriesScreen.name) {
                BrowseCountriesScreen(navController)
            }
            composable(
                Screens.CountryDetailsScreen.name + "/{country}",
                arguments = listOf(navArgument("country") { type = NavType.StringType })
            ) { backStackEntry ->
                CountryDetailsScreen(
                    navController,
                    countryId = backStackEntry.arguments?.getString("country")
                )
            }
            composable(Screens.PlanningScreen.name) {
                PlanningScreen(navController)
            }
        }
    }
}
