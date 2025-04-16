package edu.quinnipiac.ser210.travelmateapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import edu.quinnipiac.ser210.travelmateapp.navigation.Screens

@Composable
fun BrowseCountriesScreen(navController: NavController, viewModel: TravelViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.loadVacationData()
    }

    when {
        viewModel.isLoading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        viewModel.error != null -> Text("Error: ${viewModel.error}")
        else -> {
            val countries = viewModel.vacationMap.keys.sorted()
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(countries) { country ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                navController.navigate(Screens.CountryDetailsScreen.name + "/$country")
                            }
                    ) {
                        Text(
                            text = country,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}
