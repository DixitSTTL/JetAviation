package com.app.jetaviation.ui

import androidx.compose.ui.graphics.Color
import com.app.jetaviation.R
import com.app.jetaviation.ui.screen.dashbord.DataCities
import com.app.jetaviation.ui.screen.filght.DataFlights

object Constants {


    val gradientColors = listOf(Color(0xffF88264), Color(0xffFFE3C5))
    val gradientWhiteColors = listOf(Color.White, Color.White)

    val cityList = listOf(
        DataCities(
            location = "Delhi, India",
            name = "Indira Gandhi Intl Airport",
            shortName = "DEL"
        ),
        DataCities(
            location = "New York City, NY",
            name = "John F Kennedy Intl Airport",
            shortName = "JFK"
        ),
        DataCities(
            location = "Mumbai, India",
            name = "Chhatrapati Shivaji Intl Airport",
            shortName = "BOM"
        )
    )


    val flightList = listOf(
        DataFlights(
            sd_name = "DEL - JFK",
            airline = "United Airlines UA 802",
            price = "45,168",
            timePeriod = "23:45 - 4:30",
            tag = "fastest",
            totalTime = "15h 15m • Direct",
            img = R.drawable.img_ua
        ),
        DataFlights(
            sd_name = "DEL - ewr",
            airline = "Air India AI 101",
            price = "50,760",
            timePeriod = "1:55 - 7:00",
            tag = "CHEAPEST",
            totalTime = "15h 35m • Direct",
            img = R.drawable.img_air_india
        ),
        DataFlights(
            sd_name = "DEL - JFK",
            airline = "Turkish Airlines",
            price = "49,550",
            timePeriod = "2:15 - 7:25",
            tag = "",
            totalTime = "15h 25m • Direct",
            img = R.drawable.img_turk
        ),
    )

    enum class enumIsLoaded{
        NOT_LOADED,
        LOADING,
        LOADED

    }


}