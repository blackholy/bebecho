package kr.co.eoasis.bebecho.ui.main

import androidx.navigation.NavHostController
import kr.co.eoasis.bebecho.ui.navigation.BebechoDestinations

private object MainNavigation {
    const val HOME_SCREEN = "home"
    const val MEASUREMENT_SCREEN = "measurement_screen"
    const val HISTORY_SCREEN = "history"
    const val POST_SCREEN = "post"
}

object MainDestinations {
    const val HOME_ROUTE = MainNavigation.HOME_SCREEN
    const val MEASUREMENT_ROUTE = MainNavigation.MEASUREMENT_SCREEN
    const val HISTORY_ROUTE = MainNavigation.HISTORY_SCREEN
    const val POST_ROUTE = MainNavigation.POST_SCREEN
}

class MainNavigationActions(private val navController: NavHostController) {
    fun popBackStack(){
        navController.popBackStack()
    }
    fun navigateToHome() {
        popBackStack()
        navController.navigate(MainDestinations.HOME_ROUTE)
    }
    fun navigateToMeasurement() {
        popBackStack()
        navController.navigate(MainDestinations.MEASUREMENT_ROUTE)
    }
    fun navigateToHistory() {
        popBackStack()
        navController.navigate(MainDestinations.HISTORY_ROUTE)
    }
    fun navigateToPost() {
        popBackStack()
        navController.navigate(MainDestinations.POST_ROUTE)
    }

}

