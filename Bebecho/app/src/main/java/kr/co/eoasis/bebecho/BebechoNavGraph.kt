package kr.co.eoasis.bebecho

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import kr.co.eoasis.bebecho.ui.login.main.LoginMainScreen
import kr.co.eoasis.bebecho.ui.main.MainScreen
import kr.co.eoasis.bebecho.ui.navigation.BebechoDestinations
import kr.co.eoasis.bebecho.ui.navigation.BebechoNavigationActions
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kr.co.eoasis.bebecho.ui.login.LoginScreen
import kr.co.eoasis.bebecho.ui.main.home.HomeScreen
import kr.co.eoasis.bebecho.ui.main.measurement.MeasurementScreen
import kr.co.eoasis.bebecho.ui.main.post.PostScreen

@Composable
fun BebechoNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    startDestination: String = BebechoDestinations.LOGIN_ROUTE,
    navActions: BebechoNavigationActions = remember(navController) {
        BebechoNavigationActions(navController)
    }
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.padding(top = 44.dp)
    ) {
        composable(
            BebechoDestinations.LOGIN_ROUTE,
        ) {
            LoginScreen(mainNavActions = navActions)
//            MeasurementScreen()
//            HomeScreen()
//            LoginScreen()
        }
        composable(BebechoDestinations.MAIN_ROUTE) {
            MainScreen()
        }
    }
}
