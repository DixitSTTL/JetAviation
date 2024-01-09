package com.app.jetaviation.ui.screen

import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentManager
import com.app.jetaviation.R
import com.app.jetaviation.ui.Constants.cityList
import com.app.jetaviation.ui.Constants.gradientColors
import com.app.jetaviation.ui.Constants.gradientWhiteColors
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.Green_cl
import com.app.jetaviation.ui.theme.Orange_cl
import com.app.jetaviation.ui.theme.Purple_cl
import com.app.jetaviation.ui.theme.Red_cl
import com.app.jetaviation.ui.theme.Surface_cl
import com.app.jetaviation.ui.theme.Teal_cl
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90
import com.app.jetaviation.ui.theme.Yellow_cl
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen() {
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    var isOpenCity by remember {
        mutableStateOf(false)
    }

    var isOpenDate by remember {
        mutableStateOf(false)
    }

    var sourceText by remember {
        mutableStateOf("")
    }
    var isSource by remember {
        mutableStateOf(true)
    }

    var destinationText by remember {
        mutableStateOf("")
    }

    var searchText by remember {
        mutableStateOf("")
    }

    
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {

            Image(
                painter = painterResource(id = R.drawable.img_user),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Hi Samantha,\nWhere are you flying to?",
                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                fontSize = 24.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            mainSelection(
                navigateSourceCity = {
                    isOpenCity = true
                    isSource = true
                },
                navigateDestCity = {
                    isOpenCity = true
                    isSource = false
                },

                navigateDate = {
                    isOpenDate = true
                },

                sourceText,
                destinationText
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        brush =if (TextUtils.isEmpty(sourceText)&&TextUtils.isEmpty(destinationText)) Brush.verticalGradient(colors = listOf(Card_cl,Card_cl)) else Brush.verticalGradient(colors = gradientColors),
                        shape = RoundedCornerShape(16.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    "Search Flights",
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    color = if (TextUtils.isEmpty(sourceText)&&TextUtils.isEmpty(sourceText)) White_cl_30 else Color.Black,
                    fontSize = 16.sp,
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            normalCard(str = "Check COVID-19 airline measures before you go", color = Yellow_cl)

            Spacer(modifier = Modifier.height(16.dp))

            normalCard(
                str = "India to US flight bookings open! Check all the countries open for travel",
                color = Teal_cl
            )

        }

        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "DISCOVER MORE",
            fontFamily = FontFamily(Font(R.font.rubik_medium)),
            color = White_cl_30,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(modifier = Modifier.fillMaxWidth()) {

            item {
                Spacer(modifier = Modifier.width(20.dp))

                Card(
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Green_cl
                    ),
                    modifier = Modifier
                        .wrapContentSize()
                ) {
                    Column(Modifier.padding(20.dp)) {

                        Text(
                            text = "Get 30% off on all the\n" +
                                    "flights now!",
                            fontFamily = FontFamily(Font(R.font.rubik_regular)),
                            color = Color.Black,
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Row() {
                            Text(
                                text = "Discount code:",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                color = Color.Black,
                            )
                            Text(
                                text = "ALB30",
                                fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                color = Color.Black
                            )
                        }

                        Text(
                            text = "*T&C applied",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.rubik_regular)),
                            color = Surface_cl,
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                        )
                    }


                }

                Spacer(modifier = Modifier.width(12.dp))

                Card(
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Purple_cl
                    ),
                    modifier = Modifier
                        .wrapContentSize()
                ) {
                    Column(Modifier.padding(20.dp)) {

                        Text(
                            text = "Get 30% off on all the\n" +
                                    "flights now!",
                            fontFamily = FontFamily(Font(R.font.rubik_regular)),
                            color = Color.Black,
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Row() {
                            Text(
                                text = "Discount code:",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                color = Color.Black,
                            )
                            Text(
                                text = "ALB30",
                                fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                color = Color.Black
                            )
                        }

                        Text(
                            text = "*T&C applied",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.rubik_regular)),
                            color = Surface_cl,
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                        )
                    }


                }

                Spacer(modifier = Modifier.width(20.dp))

            }

        }

        Spacer(modifier = Modifier.height(36.dp))

        Card(
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
            colors = CardDefaults.cardColors(
                containerColor = Red_cl
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Web check-in is government mendate now",
                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                fontSize = 24.sp,
                color = Color.Black,

                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

        }
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_small_logo),
            contentDescription = "",
            modifier = Modifier
                .size(45.dp)
                .align(Alignment.CenterHorizontally),
            colorFilter = ColorFilter.tint(color = White_cl_30)
        )

        Text(
            text = "Trusted by over\n" +
                    "6.4 million passengers post lockdown",
            fontFamily = FontFamily(Font(R.font.rubik_regular)),
            fontSize = 20.sp,
            color = White_cl_30,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(100.dp))

    }


    if (isOpenCity) {

        ModalBottomSheet(

            content = {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(end = 12.dp)
                                .align(alignment = Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "FLYING FROM",
                                fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                fontSize = 12.sp,
                                color = White_cl_90,
                                textAlign = TextAlign.Center

                            )
                            AnimatedVisibility(
                                visible = sourceText.length > 0,
                            ) {
                                Text(
                                    sourceText,
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    style = TextStyle(
                                        brush = Brush.linearGradient(
                                            colors = gradientColors
                                        )
                                    )


                                )
                            }

                        }
                        Image(
                            painter = painterResource(id = R.drawable.ic_flight),
                            contentDescription = "",
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .rotate(45f)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(start = 12.dp)
                                .align(alignment = Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                "FLYING TO",
                                fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                fontSize = 12.sp,
                                color = White_cl_90,

                                )
                            AnimatedVisibility(
                                visible = destinationText.length > 0,
                            ) {
                                Text(
                                    destinationText,
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    style = TextStyle(
                                        brush = Brush.linearGradient(
                                            colors = gradientColors
                                        )
                                    )


                                )
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(White_cl_90)
                            .padding(vertical = 12.dp)
                    )

                    TextField(
                        value = searchText,
                        onValueChange = {
                            searchText = it
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = ""
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp, horizontal = 20.dp),
                        placeholder = {
                            Text(
                                "Search Departure Airport/City",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                color = White_cl_30,

                                )
                        },
                        textStyle = TextStyle(
                            fontFamily = FontFamily(
                                Font(R.font.rubik_medium)
                            )
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = Orange_cl,
                            containerColor = Card_cl,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        ),
                        shape = RoundedCornerShape(16.dp)


                    )

                    LazyColumn {
                        items(cityList) { item ->

                            cityItem(item) { city ->
                                if (isSource) {
                                    sourceText = city

                                } else {
                                    destinationText = city
                                }

                            }

                        }

                    }


                }
            },
            onDismissRequest = {
                isOpenCity = false
            },
            sheetState = modalBottomSheetState,
            dragHandle = { BottomSheetDefaults.DragHandle() },
            containerColor = Card_cl
        )
    }
    if (isOpenDate) {



      /*  DatePicker(
            modifier = Modifier.padding(16.dp).background(color = Card_cl),
            state = datePickerState,
            dateValidator = { timestamp ->
                // Disable all the days before today
                timestamp > Instant.now().toEpochMilli()
            },
            title = {
                Text(
                    text = "Pick a date")
            },
            headline = {
                // You need to look the datePickerState value
                Text(
                    text = datePickerState.displayMode.toString()
                )
            },

            showModeToggle = true, // allow input mode or picker
            colors = DatePickerDefaults.colors(
                containerColor = Card_cl,
                titleContentColor = White_cl_90,
//                headlineContentColor =,
//                weekdayContentColor =,
                subheadContentColor =Card_cl,
//                yearContentColor =,
//                currentYearContentColor =,
//                selectedYearContentColor =,
//                selectedYearContainerColor =,
//                dayContentColor =,
//                disabledDayContentColor =,
//                selectedDayContentColor =,
//                disabledSelectedDayContentColor =,
//                selectedDayContainerColor =,
//                disabledSelectedDayContainerColor =,
//                todayContentColor =,
//                todayDateBorderColor =,
//                dayInSelectionRangeContentColor =,
//                dayInSelectionRangeContainerColor =
            ), // Many colors, you can decide!
        )*/

        val supportFragmentManager =
            LocalContext.current.findActivity().supportFragmentManager
        showTakeawayDatePicker(supportFragmentManager)
    }
}


@Composable
fun cityItem(item: citys, click: (source: String) -> Unit) {


    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable {
                click(item.shortName)
            }

            .padding(horizontal = 10.dp, vertical = 6.dp)


    ) {

        Column(Modifier.weight(1f)) {
            Text(
                item.location,
                fontFamily = FontFamily(Font(R.font.rubik_medium)),
                color = White_cl_90,

                )
            Text(
                item.name,
                fontFamily = FontFamily(Font(R.font.rubik_light)),
                color = White_cl_30,
                fontSize = 12.sp
            )
        }

        Text(
            item.shortName,
            fontFamily = FontFamily(Font(R.font.rubik_medium)),
            modifier = Modifier.align(alignment = Alignment.CenterVertically),
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
        )


    }

}

data class citys(var name: String, var location: String, var shortName: String)

@Composable
fun mainSelection(
    navigateSourceCity: () -> Unit = {},
    navigateDestCity: () -> Unit = {},
    navigateDate: () -> Unit = {},
    sourceText: String,
    destinationText: String
) {

    val titles = listOf("Oneway", "Round Trip", "Multi-City")
    var tabIndex by remember { mutableIntStateOf(0) }
    var radioSelect by remember { mutableStateOf(false) }


    Box {

        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .clip(
                    shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
                ),
            containerColor = Card_cl,
            indicator = {

            }
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            title,
                            fontFamily = FontFamily(Font(R.font.rubik_medium)),
                            color = if (tabIndex == index) Yellow_cl else Color.White,
                            style = TextStyle(
                                brush = Brush.linearGradient(
                                    colors = if (tabIndex == index) gradientColors else gradientWhiteColors
                                )
                            )
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },


                    )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Card_cl,
                contentColor = Card_cl,
            ),
            border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.background),
            modifier = Modifier.padding(top = 40.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            )

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { navigateSourceCity() }
                ) {
                    Text(
                        "FROM",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        fontSize = 12.sp,
                        color = White_cl_30
                    )
                    Text(
                        if (sourceText.length > 0) sourceText else "Select City",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        color = White_cl_90
                    )

                }

                Image(
                    painter = painterResource(id = R.drawable.ic_flight),
                    contentDescription = "",
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = navigateDestCity)
                ) {
                    Text(
                        "TO",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        fontSize = 12.sp,
                        color = White_cl_30,
                        modifier = Modifier.align(alignment = Alignment.End)
                    )
                    Text(
                        if (destinationText.length > 0) destinationText else "Select City",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        color = White_cl_90,
                        modifier = Modifier.align(alignment = Alignment.End)
                    )

                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = White_cl_30)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {

                Column(modifier = Modifier.weight(1f).clickable { navigateDate() }) {
                    Text(
                        "TRAVEL DATE",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        fontSize = 12.sp,
                        color = White_cl_30
                    )
                    Text(
                        "Sun, 4 Oct",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        color = White_cl_90
                    )

                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "RETURN",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        fontSize = 12.sp,
                        color = White_cl_30,
                        modifier = Modifier.align(alignment = Alignment.End)
                    )
                    Text(
                        "Select Date",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        color = White_cl_90,
                        modifier = Modifier.align(alignment = Alignment.End)
                    )

                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = White_cl_30)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "TRAVELLER",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        fontSize = 12.sp,
                        color = White_cl_30
                    )
                    Text(
                        "1 Adult",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        color = White_cl_90
                    )

                }

                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                        .width(1.dp)
                        .background(color = White_cl_30)
                        .align(alignment = Alignment.CenterVertically)
                )

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "CLASS",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        fontSize = 12.sp,
                        color = White_cl_30,
                        modifier = Modifier.align(alignment = Alignment.End)
                    )
                    Text(
                        "Economy",
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        color = White_cl_90,
                        modifier = Modifier.align(alignment = Alignment.End)
                    )

                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = White_cl_30)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ) {


                RadioButton(selected = radioSelect, onClick = { radioSelect = !radioSelect })

                Text(
                    "Show direct flights only",
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    color = White_cl_90,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }
        }

    }
}

@Composable
fun normalCard(str: String = "hello", color: Color = Orange_cl) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = str,
            fontFamily = FontFamily(Font(R.font.rubik_regular)),
            fontSize = 24.sp,
            color = Color.Black,

            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Preview
@Composable
fun PreviewScreen() {
    DashBoardScreen()
}


private fun showTakeawayDatePicker(

    supportFragmentManager: FragmentManager,

    ) {
    val picker = MaterialDatePicker.Builder.datePicker()
        .setSelection(System.currentTimeMillis())
        .build()
    picker.show(supportFragmentManager, picker.toString())
    picker.addOnPositiveButtonClickListener {
        picker.selection?.let {

        }
    }
}

private tailrec fun Context.findActivity(): AppCompatActivity =
    when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> this.baseContext.findActivity()
        else -> throw IllegalArgumentException("Could not find activity!")
    }
