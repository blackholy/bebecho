
package kr.co.eoasis.bebecho.ui.navigation

import androidx.navigation.NavHostController
import kr.co.eoasis.bebecho.ui.navigation.BebechoNavigation.LOGIN_SCREEN
import kr.co.eoasis.bebecho.ui.navigation.BebechoNavigation.MAIN_SCREEN

/**
 * Screens used in [BebechoDestinations]
 */
private object BebechoNavigation {
    const val LOGIN_SCREEN = "login"
    const val MAIN_SCREEN = "main"
}

/**
 * Arguments used in [BebechoDestinations] routes
 */
object TodoDestinationsArgs {
}

/**
 * Destinations used in the [TodoActivity]
 */
object BebechoDestinations {
    const val LOGIN_ROUTE = LOGIN_SCREEN
    const val MAIN_ROUTE = MAIN_SCREEN
}

/**
 * Models the navigation actions in the app.
 */
class BebechoNavigationActions(private val navController: NavHostController) {
    fun navigateToLogin() {
        navController.navigate(BebechoDestinations.LOGIN_ROUTE)
    }

    fun navigateToMain() {
        navController.navigate(BebechoDestinations.MAIN_ROUTE)
    }


}
