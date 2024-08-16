package com.example.sweetrealm

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface SweetRealmDestination{
    val route: String
    val icon: ImageVector
}

object Home: SweetRealmDestination {
    override val route: String
        get() = "home"
    override val icon: ImageVector
        get() = Icons.Filled.Home
}

object Category: SweetRealmDestination {
    override val route: String
        get() = "category"
    override val icon: ImageVector
        get() = Icons.Filled.Category
}

object Cart: SweetRealmDestination {
    override val route: String
        get() = "cart"
    override val icon: ImageVector
        get() = Icons.Filled.ShoppingCart
}

object CategoryDetail: SweetRealmDestination {
    override val route: String
        get() = "category_detail"
    override val icon: ImageVector
        get() = Icons.Filled.Details
    const val categoryDetailArg = "detailArg"
    val routeWithArgs = "${route}/{${categoryDetailArg}}"
    val arguments = listOf(
        navArgument(categoryDetailArg){ type = NavType.StringType }
    )
}

object Detail: SweetRealmDestination {
    override val route: String
        get() = "detail"
    override val icon: ImageVector
        get() = Icons.Filled.Details
    const val detailArg = "detailArg"
    val routeWithArgs = "${route}/{${detailArg}}"
    val arguments = listOf(
        navArgument(detailArg){ type = NavType.IntType }
    )
}

val SweetRealmTabRowScreens = listOf(Home, Category, Cart)