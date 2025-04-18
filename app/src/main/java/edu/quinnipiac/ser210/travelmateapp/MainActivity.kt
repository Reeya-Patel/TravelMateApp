package edu.quinnipiac.ser210.travelmateapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import edu.quinnipiac.ser210.travelmateapp.navigation.TravelMateNavigation
import edu.quinnipiac.ser210.travelmateapp.ui.theme.TravelMateAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelMateAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TravelMateNavigation()
                }
            }
        }
    }
}
