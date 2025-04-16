package edu.quinnipiac.ser210.travelmateapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import edu.quinnipiac.ser210.travelmateapp.Model.VacationAPI
import edu.quinnipiac.ser210.travelmateapp.Network.VacationApi
import kotlinx.coroutines.launch

@Composable
fun CountryDetailsScreen(
    navController: NavController,
    countryId: String?,
    viewModel: TravelViewModel = viewModel()
) {
    val vacation = viewModel.vacationMap[countryId]

    if (vacation == null) {
        Text("No data found for $countryId")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Country: ${vacation.country}", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Capital: ${vacation.capital}")
        Text("Currency: ${vacation.currency}")
        Text("Popular Vacation Spot: ${vacation.vacation}")
    }
}

// 🧠 Embedded ViewModel
class TravelViewModel : ViewModel() {
    var vacationMap by mutableStateOf<Map<String, VacationAPI>>(emptyMap())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun loadVacationData() {
        viewModelScope.launch {
            try {
                println("📡 Sending request to /details...")
                vacationMap = VacationApi.retrofitService.getAllVacationData()
                println("✅ Data received. Keys = ${vacationMap.keys}")
                error = null
            } catch (e: Exception) {
                error = e.message
                println("❌ API ERROR MESSAGE: ${e.message}")
                println("❌ API ERROR CLASS: ${e::class}")
                e.printStackTrace()
        } finally {
                isLoading = false
            }
        }
    }

}
