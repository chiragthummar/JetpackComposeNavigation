package com.cb.jetpackcomposenavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cb.jetpackcomposenavigation.ui.theme.JetpackComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            Log.e("TAG", "Home Screen .....")
                            Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Button(onClick = { navController.navigate("second") }) {
                                    Text(text = "Navigate To Second Screen")
                                }
                            }
                        }
                        composable("second") {
                            Log.e("TAG", "Second Screen")
                            Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text(
                                    text = "Seconds Screen"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
