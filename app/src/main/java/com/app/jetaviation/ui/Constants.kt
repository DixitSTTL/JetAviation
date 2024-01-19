package com.app.jetaviation.ui

import androidx.compose.ui.graphics.Color
import com.app.jetaviation.R
import com.app.jetaviation.ui.screen.dashbord.DataCities
import com.app.jetaviation.ui.screen.filght.DataFlights
import com.app.jetaviation.ui.screen.trips.DataTrips

object Constants {


    val gradientColors = listOf(Color(0xffF88264), Color(0xffFFE3C5))
    val gradientWhiteColors = listOf(Color.White, Color.White)

    enum class DateValidation {
        FUTURE_DATE,
        PAST_DATE,
        NOT_VALIDATION
    }

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
        ),
        DataCities(
            location = "Los Angeles, USA",
            name = "Los Angeles International Airport",
            shortName = "LAX"
        ),
        DataCities(
            location = "Tokyo, Japan",
            name = "Tokyo Haneda Airport",
            shortName = "HND"
        ),
        DataCities(
            location = "Singapore",
            name = "Singapore Changi Airport",
            shortName = "SIN"
        ),
        DataCities(
            location = "Dubai, United Arab Emirates",
            name = "Dubai International Airport",
            shortName = "DXB"
        ),
        DataCities(
            location = "Sydney, Australia",
            name = "Sydney Kingsford Smith Airport ",
            shortName = "SYD"
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


    val tripList = listOf(
        DataTrips(
            sourceShort = "DEL",
            destinationShort = "JFK",

            sorceLocation = "New Delhi",
            destinationLocation = "John F. Kennedy, NY",

            takeOffTime = "23:45, Thu 15 Oct",
            landingTime = "4:30, Fri 16 Oct",

            sourceTerminal = "Terminal 3",
            destinationTerminal = "Terminal 2",
        ),
        DataTrips(
            sourceShort = "DEL",
            destinationShort = "JFK",

            sorceLocation = "New Delhi",
            destinationLocation = "John F. Kennedy, NY",

            takeOffTime = "23:45, Thu 15 Oct",
            landingTime = "4:30, Fri 16 Oct",

            sourceTerminal = "Terminal 3",
            destinationTerminal = "Terminal 2",
        ),
        DataTrips(
            sourceShort = "DEL",
            destinationShort = "JFK",

            sorceLocation = "New Delhi",
            destinationLocation = "John F. Kennedy, NY",

            takeOffTime = "23:45, Thu 15 Oct",
            landingTime = "4:30, Fri 16 Oct",

            sourceTerminal = "Terminal 3",
            destinationTerminal = "Terminal 2",
        ),
        DataTrips(
            sourceShort = "DEL",
            destinationShort = "JFK",

            sorceLocation = "New Delhi",
            destinationLocation = "John F. Kennedy, NY",

            takeOffTime = "23:45, Thu 15 Oct",
            landingTime = "4:30, Fri 16 Oct",

            sourceTerminal = "Terminal 3",
            destinationTerminal = "Terminal 2",
        ),
        DataTrips(
            sourceShort = "DEL",
            destinationShort = "JFK",

            sorceLocation = "New Delhi",
            destinationLocation = "John F. Kennedy, NY",

            takeOffTime = "23:45, Thu 15 Oct",
            landingTime = "4:30, Fri 16 Oct",

            sourceTerminal = "Terminal 3",
            destinationTerminal = "Terminal 2",
        ),
        DataTrips(
            sourceShort = "DEL",
            destinationShort = "JFK",

            sorceLocation = "New Delhi",
            destinationLocation = "John F. Kennedy, NY",

            takeOffTime = "23:45, Thu 15 Oct",
            landingTime = "4:30, Fri 16 Oct",

            sourceTerminal = "Terminal 3",
            destinationTerminal = "Terminal 2",
        ),
    )

    enum class enumIsLoaded {
        NOT_LOADED,
        LOADING,
        LOADED

    }

    val mealList = listOf(
        "Diabetic meal",
        "Gluten-free meal",
        "Fruit platter meal",
        "Non-vegetarian meal",
        "Vegan meal",
        "Asian vegetarian meal",
        "Hindu Vegetarian Meal",
        "Jain meal",
        "Moslem meal",
        "Child meal",
        "Baby meal "
    )

    val countryNamesList = listOf(
        "Afghanistan",
        "Albania",
        "Algeria",
        "Andorra",
        "Angola",
        "Antigua and Barbuda",
        "Argentina",
        "Armenia",
        "Australia",
        "Austria",
        "Azerbaijan",
        "Bahamas",
        "Bahrain",
        "Bangladesh",
        "Barbados",
        "Belarus",
        "Belgium",
        "Belize",
        "Benin",
        "Bhutan",
        "Bolivia",
        "Bosnia and Herzegovina",
        "Botswana",
        "Brazil",
        "Brunei",
        "Bulgaria",
        "Burkina Faso",
        "Burundi",
        "Cabo Verde",
        "Cambodia",
        "Cameroon",
        "Canada",
        "Central African Republic",
        "Chad",
        "Chile",
        "China",
        "Colombia",
        "Comoros",
        "Congo (Congo-Brazzaville)",
        "Costa Rica",
        "Cote d'Ivoire",
        "Croatia",
        "Cuba",
        "Cyprus",
        "Czechia",
        "Denmark",
        "Djibouti",
        "Dominica",
        "Dominican Republic",
        "Ecuador",
        "Egypt",
        "El Salvador",
        "Equatorial Guinea",
        "Eritrea",
        "Estonia",
        "Eswatini",
        "Ethiopia",
        "Fiji",
        "Finland",
        "France",
        "Gabon",
        "Gambia",
        "Georgia",
        "Germany",
        "Ghana",
        "Greece",
        "Grenada",
        "Guatemala",
        "Guinea",
        "Guinea-Bissau",
        "Guyana",
        "Haiti",
        "Honduras",
        "Hungary",
        "Iceland",
        "India",
        "Indonesia",
        "Iran",
        "Iraq",
        "Ireland",
        "Israel",
        "Italy",
        "Jamaica",
        "Japan",
        "Jordan",
        "Kazakhstan",
        "Kenya",
        "Kiribati",
        "Korea, North",
        "Korea, South",
        "Kosovo",
        "Kuwait",
        "Kyrgyzstan",
        "Laos",
        "Latvia",
        "Lebanon",
        "Lesotho",
        "Liberia",
        "Libya",
        "Liechtenstein",
        "Lithuania",
        "Luxembourg",
        "Madagascar",
        "Malawi",
        "Malaysia",
        "Maldives",
        "Mali",
        "Malta",
        "Marshall Islands",
        "Mauritania",
        "Mauritius",
        "Mexico",
        "Micronesia",
        "Moldova",
        "Monaco",
        "Mongolia",
        "Montenegro",
        "Morocco",
        "Mozambique",
        "Myanmar (formerly Burma)",
        "Namibia",
        "Nauru",
        "Nepal",
        "Netherlands",
        "New Zealand",
        "Nicaragua",
        "Niger",
        "Nigeria",
        "North Macedonia (formerly Macedonia)",
        "Norway",
        "Oman",
        "Pakistan",
        "Palau",
        "Palestine State",
        "Panama",
        "Papua New Guinea",
        "Paraguay",
        "Peru",
        "Philippines",
        "Poland",
        "Portugal",
        "Qatar",
        "Romania",
        "Russia",
        "Rwanda",
        "Saint Kitts and Nevis",
        "Saint Lucia",
        "Saint Vincent and the Grenadines",
        "Samoa",
        "San Marino",
        "Sao Tome and Principe",
        "Saudi Arabia",
        "Senegal",
        "Serbia",
        "Seychelles",
        "Sierra Leone",
        "Singapore",
        "Slovakia",
        "Slovenia",
        "Solomon Islands",
        "Somalia",
        "South Africa",
        "South Sudan",
        "Spain",
        "Sri Lanka",
        "Sudan",
        "Suriname",
        "Sweden",
        "Switzerland",
        "Syria",
        "Taiwan",
        "Tajikistan",
        "Tanzania",
        "Thailand",
        "Timor-Leste",
        "Togo",
        "Tonga",
        "Trinidad and Tobago",
        "Tunisia",
        "Turkey",
        "Turkmenistan",
        "Tuvalu",
        "Uganda",
        "Ukraine",
        "United Arab Emirates",
        "United Kingdom",
        "United States of America",
        "Uruguay",
        "Uzbekistan",
        "Vanuatu",
        "Vatican City",
        "Venezuela",
        "Vietnam",
        "Yemen",
        "Zambia",
        "Zimbabwe"
    )


}