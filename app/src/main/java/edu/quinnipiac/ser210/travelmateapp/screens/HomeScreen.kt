package edu.quinnipiac.ser210.travelmateapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.travelmateapp.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate(Screens.BrowseCountriesScreen.name) },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = MaterialTheme.shapes.large
        ) {
            Text(
                text = "Browse Countries",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate(Screens.PlanningScreen.name) },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Plan Your Trip",
                fontSize = 30.sp
            )
        }
    }
}
