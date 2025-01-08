package kr.co.eoasis.bebecho

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.co.eoasis.bebecho.ui.login.LoginScreen
import kr.co.eoasis.bebecho.ui.main.MainScreen
import kr.co.eoasis.bebecho.ui.navigation.BebechoDestinations
import kr.co.eoasis.bebecho.ui.navigation.BebechoNavigationActions
import kr.co.eoasis.bebecho.ui.navigation.MainDestinations

@Composable
fun BebechoNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = BebechoDestinations.LOGIN_ROUTE
) {
    val navActions = remember(navController) {
        BebechoNavigationActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(BebechoDestinations.LOGIN_ROUTE) {
            LoginScreen(
                mainNavActions = navActions
            )
        }
        composable(BebechoDestinations.MAIN_ROUTE) {
            MainScreen(
                startDestination = MainDestinations.HOME_ROUTE
            )
        }
    }
}
