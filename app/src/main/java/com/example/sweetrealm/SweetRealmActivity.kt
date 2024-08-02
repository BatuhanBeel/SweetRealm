package com.example.sweetrealm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sweetrealm.presentation.cart.CartScreen
import com.example.sweetrealm.presentation.category.CategoryScreen
import com.example.sweetrealm.presentation.components.SweetRealmTabRow
import com.example.sweetrealm.presentation.detail.DetailScreen
import com.example.sweetrealm.presentation.home.HomeScreen
import com.example.sweetrealm.ui.theme.SweetRealmTheme

class SweetRealmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SweetRealmApp()
        }
    }
}


@Composable
fun SweetRealmApp() {
    SweetRealmTheme {
        val navController = rememberNavController()
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry?.destination
        val currentScreen = SweetRealmTabRowScreens.find { it.route == currentDestination?.route } ?: Home

        Scaffold(
            bottomBar = {
                if (currentDestination?.route == Home.route ||
                    currentDestination?.route == Category.route ||
                    currentDestination?.route == Cart.route
                ) {
                    SweetRealmTabRow(allScreens = SweetRealmTabRowScreens, onTabSelected = { navController.navigate(it.route) }, currentScreen = currentScreen, modifier = Modifier.systemBarsPadding())
                }
            }
        ) { innerPadding ->
            SweetRealmNavHost(navController, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun SweetRealmNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route){
            HomeScreen()
        }

        composable(route = Category.route){
            CategoryScreen()
        }

        composable(route = Cart.route){
            CartScreen()
        }

        composable(route = Detail.routeWithArgs, arguments = Detail.arguments){ navBackStackEntry ->
            val navArg = navBackStackEntry.arguments?.getInt(Detail.detailArg)
            if(navArg != null){
                DetailScreen(
                    argumentId = navArg,
                    onPopUpClick = { navController.navigateUp() }
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun SweetRealmAppPreview() {
    SweetRealmTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {

            }
        }
    }
}
