package kr.co.eoasis.bebecho.ui.main

import androidx.navigation.NavHostController
import kr.co.eoasis.bebecho.ui.navigation.MainDestinations

// MainScreen 내부의 네비게이션을 위한 액션들
class MainNavigationActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(MainDestinations.HOME_ROUTE)
    }

    fun navigateToPost() {
        navController.navigate(MainDestinations.POST_ROUTE)
    }

    fun navigateToMeasurement() {
        navController.navigate(MainDestinations.MEASUREMENT_ROUTE)
    }
}

