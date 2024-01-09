package com.app.jetaviation.ui

import androidx.compose.ui.graphics.Color
import com.app.jetaviation.ui.screen.citys

object Constants {


    val gradientColors = listOf(Color(0xffF88264), Color(0xffFFE3C5))
    val gradientWhiteColors = listOf(Color.White, Color.White)

    val cityList = listOf(
        citys(location = "Delhi, India", name = "Indira Gandhi Intl Airport", shortName = "DEL"),
        citys(location = "New York City, NY", name = "John F Kennedy Intl Airport", shortName = "JFK"),
        citys(location = "Mumbai, India", name = "Chhatrapati Shivaji Intl Airport", shortName = "BOM")
    )


}