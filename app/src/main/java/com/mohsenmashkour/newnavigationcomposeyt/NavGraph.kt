package com.mohsenmashkour.newnavigationcomposeyt

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Composable
fun MyNav(){
    val navController =  rememberNavController()
    NavHost(navController = navController, startDestination = Home ) {
        composable<Home>{
           HomeScreen(navController)
        }

        composable<Detail> {
            val args = it.toRoute<Detail>()
            DetailScreen(name = args.name, age = args.age)
        }
    }
}


@Serializable
object Home

@Serializable
data class Detail(
    val name : String?,
    val age : Int
)