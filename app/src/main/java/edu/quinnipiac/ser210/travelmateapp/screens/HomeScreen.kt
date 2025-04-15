package edu.quinnipiac.ser210.travelmateapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.travelmateapp.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                navController.navigate(Screens.BrowseCountriesScreen.name)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Browse Countries")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(Screens.PlanningScreen.name)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Plan Your Trip")
        }
    }
}
