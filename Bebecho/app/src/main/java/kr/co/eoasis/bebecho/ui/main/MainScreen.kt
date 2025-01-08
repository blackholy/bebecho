package kr.co.eoasis.bebecho.ui.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.login.LoginDestinations
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.login.bluetooth.BluetoothScreen
import kr.co.eoasis.bebecho.ui.login.main.LoginMainScreen
import kr.co.eoasis.bebecho.ui.login.singup.SignUpScreen
import kr.co.eoasis.bebecho.ui.login.survey.SurveyScreen
import kr.co.eoasis.bebecho.ui.main.History.HistoryScreen
import kr.co.eoasis.bebecho.ui.main.home.HomeScreen
import kr.co.eoasis.bebecho.ui.main.measurement.MeasurementScreen
import kr.co.eoasis.bebecho.ui.main.post.PostScreen
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.ui.theme.Gray3
import androidx.compose.material3.Scaffold

import androidx.navigation.compose.currentBackStackEntryAsState
import kr.co.eoasis.bebecho.ui.navigation.MainDestinations

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
    startDestination: String = MainDestinations.HOME_ROUTE
) {
    val mainNavController = rememberNavController()
    val mainNavActions = remember(mainNavController) {
        MainNavigationActions(mainNavController)
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = mainNavController,
                items = listOf(
                    MainDestinations.HOME_ROUTE,
                    MainDestinations.POST_ROUTE,
                    MainDestinations.MEASUREMENT_ROUTE
                )
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = mainNavController,
            startDestination = MainDestinations.HOME_ROUTE,
            modifier = modifier.padding(paddingValues)
        ) {
            composable(MainDestinations.HOME_ROUTE) {
                HomeScreen(
                    mainViewModel = viewModel,
                    navActions = mainNavActions
                )
            }
            composable(MainDestinations.MEASUREMENT_ROUTE) {
                MeasurementScreen()
            }
            composable(MainDestinations.POST_ROUTE) {
                PostScreen()
            }
        }
    }
}

@Composable
private fun BottomNavigation(
    navController: NavHostController,
    items: List<String>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        
        items.forEach { route ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    when (route) {
                        MainDestinations.HOME_ROUTE -> Icon(Icons.Default.Home, contentDescription = null)
                        MainDestinations.POST_ROUTE -> Icon(Icons.Default.List, contentDescription = null)
                        MainDestinations.MEASUREMENT_ROUTE -> Icon(Icons.Default.Add, contentDescription = null)
                    }
                }
            )
        }
    }
}

@Composable
fun BottomNavigationItem(modifier: Modifier, text:String, painter: Painter, tabPosition: Int, value: Int){
    Column(modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally){
        Icon(painter, contentDescription = text,
            tint = selectedColor(tabPosition, value)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, color = selectedColor(tabPosition, value), style =
        MaterialTheme.typography.titleSmall, fontSize = 9.sp)
    }
}

@Composable
fun selectedColor(position:Int, value: Int):Color{
    return if(position == value){
        MaterialTheme.colorScheme.primary
    }else{
        MaterialTheme.colorScheme.surfaceVariant
    }
}
@Preview
@Composable
fun MainScreenPreview(){
    BebechoTheme {
        MainScreen()
    }
}