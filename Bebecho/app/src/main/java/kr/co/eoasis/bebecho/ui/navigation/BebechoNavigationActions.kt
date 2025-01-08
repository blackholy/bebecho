package kr.co.eoasis.bebecho.ui.navigation

import androidx.navigation.NavHostController

class BebechoNavigationActions(private val navController: NavHostController) {
    fun navigateToMain() {
        navController.navigate(BebechoDestinations.MAIN_ROUTE) {
            popUpTo(BebechoDestinations.LOGIN_ROUTE) {
                inclusive = true
            }
        }
    }

    fun navigateToLogin() {
        navController.navigate(BebechoDestinations.LOGIN_ROUTE)
    }
} 