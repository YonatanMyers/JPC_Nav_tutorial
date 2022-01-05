/**
 * Created by: Yonatan Myers
 * For tutorial on JPC Navigation
 * 05/Jan/2022
 */

package com.freedome.yam.jpcnav

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Inputs") {
        composable("Inputs") { Inputs(navController) }
        composable("Output") { Output("J. R.") }
    }
}

@Composable
fun Inputs(navController: NavController) {
    Box(Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.navigate("Output") },
            modifier = Modifier.fillMaxWidth().align(Alignment.Center).padding(10.dp)
        ) { Text(text = "Go to next page") }
    }
}

@Composable
fun Output(name: String) {
    Box(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Hello $name"
        )
    }
}