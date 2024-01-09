package com.app.jetaviation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.jetaviation.ui.Constants.gradientColors
import com.app.jetaviation.ui.Constants.gradientWhiteColors
import com.app.jetaviation.ui.theme.JetAviationTheme
import com.app.jetaviation.ui.theme.Surface_cl

@Composable

fun AviationApp(finishActivity: () -> Unit) {
    JetAviationTheme {
        val tabs = remember { AppTabs.values() }
        val navController = rememberNavController()
        Scaffold(
            contentColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                BottomBar(navController = navController, tabs)
            }
        ) { innerPaddingModifier ->
            NavGraph(
                finishActivity = finishActivity,
                navController = navController,
                modifier = Modifier.padding(innerPaddingModifier)
            )
        }
    }
}

enum class AppTabs(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    FLIGHTS(R.string.flight, R.drawable.ic_flight, TabDestinations.FLIGHT_ROUTE),
    TRIPS(R.string.trip, R.drawable.ic_trips, TabDestinations.TRIPS_ROUTE),
}


@Composable
fun BottomBar(navController: NavController, tabs: Array<AppTabs>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
        ?: AppTabs.FLIGHTS.route

    val routes = remember { AppTabs.values().map { it.route } }
    if (currentRoute in routes) {

        NavigationBar(containerColor = Surface_cl) {

            tabs.forEach { tab ->

                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(tab.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .graphicsLayer(alpha = 0.99f)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(
                                            brush = Brush.linearGradient(
                                                colors = if (currentRoute == tab.route) gradientColors else gradientWhiteColors,
                                                tileMode = TileMode.Mirror
                                            ),
                                            blendMode = BlendMode.SrcAtop
                                        )
                                    }
                                },
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(tab.title),
                            fontFamily = FontFamily(Font(R.font.rubik_medium)),
                            modifier = Modifier
                                .graphicsLayer(alpha = 0.99f)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(
                                            brush = Brush.linearGradient(
                                                colors = if (currentRoute == tab.route) gradientColors else gradientWhiteColors,
                                                tileMode = TileMode.Mirror
                                            ),
                                            blendMode = BlendMode.SrcAtop
                                        )
                                    }
                                },
                        )
                    },
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    alwaysShowLabel = false,
                    modifier = Modifier.navigationBarsPadding()
                )
            }
        }
    }
}
