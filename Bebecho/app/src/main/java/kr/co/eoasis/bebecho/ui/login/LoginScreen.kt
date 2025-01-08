package kr.co.eoasis.bebecho.ui.login

import android.os.Build
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kr.co.eoasis.bebecho.ui.login.bluetooth.BluetoothScreen
import kr.co.eoasis.bebecho.ui.login.main.LoginMainScreen
import kr.co.eoasis.bebecho.ui.login.search.SearchScreen
import kr.co.eoasis.bebecho.ui.login.singup.SignUpScreen
import kr.co.eoasis.bebecho.ui.login.survey.SurveyScreen
import kr.co.eoasis.bebecho.ui.navigation.BebechoDestinations
import kr.co.eoasis.bebecho.ui.navigation.BebechoNavigationActions


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    startDestination: String = LoginDestinations.MAIN_ROUTE,
    navActions: LoginNavigationActions = remember(navController) {
        LoginNavigationActions(navController)
    },
    mainNavActions: BebechoNavigationActions = remember(navController){
        BebechoNavigationActions(navController)
    }
) {

    val EaseInOut = CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f)
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = EaseInOut)
            )
        },
        exitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = EaseInOut)
            )
        }
    ) {
        composable(
            LoginDestinations.MAIN_ROUTE,
        ) {
            LoginMainScreen(navigationAction = navActions)
        }
        composable(LoginDestinations.SIGN_UP_ROUTE) {
            SignUpScreen(navActions)
        }
        composable(LoginDestinations.SURVEY_ROUTE) {
            SurveyScreen(navActions)
        }
        composable(LoginDestinations.BLUETOOTH_ROUTE) {
            BluetoothScreen(navActions)
        }
        composable(LoginDestinations.SEARCH_ROUTE) {
            SearchScreen(navActions,mainNavActions)
        }
    }
}

