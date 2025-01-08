package kr.co.eoasis.bebecho.ui.login

import androidx.navigation.NavHostController
import kr.co.eoasis.bebecho.ui.login.LoginDestinations.BLUETOOTH_ROUTE
import kr.co.eoasis.bebecho.ui.login.LoginDestinations.SEARCH_ROUTE
import kr.co.eoasis.bebecho.ui.login.LoginDestinations.SIGN_UP_ROUTE
import kr.co.eoasis.bebecho.ui.login.LoginDestinations.SURVEY_ROUTE
import kr.co.eoasis.bebecho.ui.login.LoginNavigation.BLUETOOTH_SCREEN
import kr.co.eoasis.bebecho.ui.login.LoginNavigation.MAIN_SCREEN
import kr.co.eoasis.bebecho.ui.login.LoginNavigation.SEARCH_SCREEN
import kr.co.eoasis.bebecho.ui.login.LoginNavigation.SIGN_UP_SCREEN
import kr.co.eoasis.bebecho.ui.login.LoginNavigation.SURVEY_SCREEN
import kr.co.eoasis.bebecho.ui.navigation.BebechoDestinations

private object LoginNavigation {
    const val MAIN_SCREEN = "main"
    const val SIGN_UP_SCREEN = "signUp"
    const val SURVEY_SCREEN = "survey"
    const val BLUETOOTH_SCREEN = "bluetooth"
    const val SEARCH_SCREEN = "search"
}

object LoginDestinations {
    const val MAIN_ROUTE = MAIN_SCREEN
    const val SIGN_UP_ROUTE = SIGN_UP_SCREEN
    const val SURVEY_ROUTE = SURVEY_SCREEN
    const val BLUETOOTH_ROUTE = BLUETOOTH_SCREEN
    const val SEARCH_ROUTE = SEARCH_SCREEN
}

class LoginNavigationActions(private val navController: NavHostController) {
    fun popBackStack(){
        navController.popBackStack()
    }
    fun navigateToSignUp() {
        navController.navigate(SIGN_UP_ROUTE)
    }
    fun navigateToSurvey() {
        navController.navigate(SURVEY_ROUTE)
    }
    fun navigateToBluetooth() {
        navController.navigate(BLUETOOTH_ROUTE)
    }
    fun navigateToSearch() {
        navController.navigate(SEARCH_ROUTE)
    }
    /*
    fun navigateToMain() {
        navController.navigate(BebechoDestinations.MAIN_ROUTE) {
            // 로그인 스택을 완전히 제거

            popUpTo(BebechoDestinations.MAIN_ROUTE) {
                inclusive = true  // LOGIN_ROUTE도 스택에서 제거
            }
        }
    }

     */

    fun navigateToMain() {
        navController.navigate(BebechoDestinations.MAIN_ROUTE) {
            popUpTo(navController.graph.startDestinationId) { inclusive = true }
            launchSingleTop = true
        }
    }


}

