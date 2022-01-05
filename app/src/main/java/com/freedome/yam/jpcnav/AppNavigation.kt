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
        composable(
            "Output/{arg1}/{arg2}",
            arguments = listOf(
                navArgument("arg1") {
                    type = NavType.IntType
                    nullable = false
                },

                navArgument("arg2") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) { args ->
            val a1 = args.arguments?.getInt("arg1")
            val a2 = args.arguments?.getInt("arg2")
            Output(arg1 = a1!!, arg2 = a2!!)
        }
    }
}

@Composable
fun Inputs(navController: NavController) {

    var arg1 by remember {
        mutableStateOf(0)
    }

    var arg2 by remember {
        mutableStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = arg1.toString(),
                onValueChange = {
                    arg1 = it.toInt()
                },
                modifier = Modifier.weight(1.0F)
            )
            Text(text = "x")
            TextField(
                value = arg2.toString(),
                onValueChange = {
                    arg2 = it.toInt()
                },
                modifier = Modifier.weight(1.0F)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("Output/${arg1}/${arg2}")
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ans")
        }
    }
}

@Composable
fun Output(arg1: Int, arg2: Int) {
    val ans = arg1 * arg2
    Box(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "$arg1 x $arg2 = $ans"
        )
    }
}