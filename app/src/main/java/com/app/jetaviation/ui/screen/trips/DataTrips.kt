package com.app.jetaviation.ui.screen.trips

data class DataTrips(
    var sourceShort: String,
    var destinationShort: String,
    var sorceLocation: String,
    var destinationLocation: String,
    var takeOffTime: String,
    var landingTime: String,
    var sourceTerminal: String,
    var destinationTerminal: String,

    )
