/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.app.jetaviation

import android.content.Context
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.jetaviation.MainDestinations.CLASS_KEY
import com.app.jetaviation.MainDestinations.DATE_KEY
import com.app.jetaviation.MainDestinations.DESTINATION_KEY
import com.app.jetaviation.MainDestinations.SOURCE_KEY
import com.app.jetaviation.ui.JsonNavType
import com.app.jetaviation.ui.screen.dashbord.DashBoardScreen
import com.app.jetaviation.ui.screen.filght.DataFlights
import com.app.jetaviation.ui.screen.filght.FlightListScreen
import com.app.jetaviation.ui.screen.flight_detail.FlightDetailScreen
import com.app.jetaviation.ui.screen.trips.TripScreen
import com.google.gson.Gson

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    finishActivity: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppTabs.FLIGHTS.route,
    showOnboardingInitially: Boolean = true,
    applicationContext: Context
) {
    // Onboarding could be read from shared preferences.
    val onboardingComplete = remember(showOnboardingInitially) {
        mutableStateOf(!showOnboardingInitially)
    }

    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppTabs.FLIGHTS.route) {
            // Intercept back in Onboarding: make it finish the activity
            BackHandler {
                finishActivity()
            }

            DashBoardScreen { source, dest, date,tripClass ->
                actions.navigateFlightList(source, dest, date,tripClass)
            }
        }

        composable(AppTabs.TRIPS.route) {
            BackHandler {
                finishActivity()
            }
            TripScreen()
        }

        composable("${MainDestinations.FLIGHT_LIST}/{$SOURCE_KEY}/{$DESTINATION_KEY}/{$DATE_KEY}/{$CLASS_KEY}",
            arguments = listOf(
                navArgument(SOURCE_KEY) { type = NavType.StringType },
                navArgument(DESTINATION_KEY) { type = NavType.StringType },
                navArgument(DATE_KEY) { type = NavType.LongType },
                navArgument(CLASS_KEY) { type = NavType.StringType }
            )
        ) { backStackEntry: NavBackStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)

            val SOURCE_KEY = arguments.getString(SOURCE_KEY)
            val DESTINATION_KEY = arguments.getString(DESTINATION_KEY)
            val DATE_KEY = arguments.getLong(DATE_KEY)
            val CLASS_KEY = arguments.getString(CLASS_KEY)

            FlightListScreen(SOURCE_KEY, DESTINATION_KEY, DATE_KEY,CLASS_KEY) {
                actions.navigateFlightDetail()
            }

        }

        composable(MainDestinations.FLIGHT_DETAIL) { backStackEntry: NavBackStackEntry ->

            FlightDetailScreen {
                actions.navigateBack()
            }
        }

    }
}

object MainDestinations {
    const val ONBOARDING_ROUTE = "onboarding"
    const val COURSE_DETAIL_ROUTE = "course"
    const val FLIGHT_DETAIL = "flight_detail"
    const val FLIGHT_LIST = "flight_list"


    const val SOURCE_KEY = "source_key"
    const val DESTINATION_KEY = "destination_key"
    const val DATE_KEY = "date_key"
    const val CLASS_KEY = "class_key"
    const val DATA_FLIGHTS_KEY = "data_flights_key"
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }

    // Used from FLIGHT_LIST
    val navigateFlightList = { source: String, destination: String, date: Long, tripClass: String->
        // In order to discard duplicated navigation events, we check the Lifecycle
        navController.navigate("${MainDestinations.FLIGHT_LIST}/$source/$destination/$date/$tripClass")

    }

    // Used from FLIGHT_DETAIL
    val navigateFlightDetail = {
        // In order to discard duplicated navigation events, we check the Lifecycle
        navController.navigate(MainDestinations.FLIGHT_DETAIL)

    }
}

object TabDestinations {
    const val FLIGHT_ROUTE = "tab/flight"
    const val TRIPS_ROUTE = "tab/trips"
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

class ProfileArgType : JsonNavType<DataFlights>() {
    override fun fromJsonParse(value: String): DataFlights {
        return Gson().fromJson(value, DataFlights::class.java)
    }

    override fun DataFlights.getJsonParse(): String {

        return Gson().toJson(this)
    }

}