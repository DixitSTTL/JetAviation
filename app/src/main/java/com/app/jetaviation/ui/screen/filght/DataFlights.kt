package com.app.jetaviation.ui.screen.filght

import android.os.Parcel
import android.os.Parcelable

data class DataFlights(
    var sd_name: String,
    var airline: String,
    var timePeriod: String,
    var totalTime: String,
    var price: String,
    var tag: String,
    var img: Int
)
