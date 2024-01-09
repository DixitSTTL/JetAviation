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

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.jetaviation.ui.screen.DashBoardScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    finishActivity: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppTabs.FLIGHTS.route,
    showOnboardingInitially: Boolean = true
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

            DashBoardScreen()
        }

        composable(AppTabs.TRIPS.route) {
            BackHandler {
                finishActivity()
            }
        }

    }
}

object MainDestinations {
    const val ONBOARDING_ROUTE = "onboarding"
    const val COURSE_DETAIL_ROUTE = "course"
    const val COURSE_DETAIL_ID_KEY = "courseId"
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val onboardingComplete: () -> Unit = {
        navController.popBackStack()
    }

    // Used from COURSES_ROUTE
    val openCourse = { newCourseId: Long, from: NavBackStackEntry ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${MainDestinations.COURSE_DETAIL_ROUTE}/$newCourseId")
        }
    }

    // Used from COURSE_DETAIL_ROUTE
    val relatedCourse = { newCourseId: Long, from: NavBackStackEntry ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${MainDestinations.COURSE_DETAIL_ROUTE}/$newCourseId")
        }
    }

    // Used from COURSE_DETAIL_ROUTE
    val upPress: (from: NavBackStackEntry) -> Unit = { from ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigateUp()
        }
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
