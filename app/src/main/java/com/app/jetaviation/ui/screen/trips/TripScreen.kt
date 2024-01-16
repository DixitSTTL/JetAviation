package com.app.jetaviation.ui.screen.trips

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.app.jetaviation.R
import com.app.jetaviation.ui.Constants
import com.app.jetaviation.ui.Constants.tripList
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.Surface_cl
import com.app.jetaviation.ui.theme.Teal_cl
import com.app.jetaviation.ui.theme.Yellow_cl

@Composable
fun TripScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val titles = listOf("Upcoming", "Past")

    Scaffold(
        contentColor = MaterialTheme.colorScheme.background,
        topBar = {
            Box(Modifier.fillMaxWidth()) {

                TabRow(
                    selectedTabIndex = tabIndex,
                    divider = {},
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .width(250.dp)
                        .align(Alignment.Center)
                        .clip(
                            shape = RoundedCornerShape(16.dp)
                        ),
                    containerColor = Card_cl,
                    contentColor = Card_cl,
                    indicator = {
                        Box(
                            Modifier
                                .tabIndicatorOffset(it[tabIndex])
                                .fillMaxSize()
                                .padding(5.dp)
                                .background(color = Surface_cl, shape = RoundedCornerShape(12.dp))
                                .zIndex(-1f)
                        )
                    }) {

                    titles.forEachIndexed { index, title ->
                        Tab(


                            text = {


                                Text(
                                    title,
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    color = if (tabIndex == index) Yellow_cl else Color.White,
                                    style = TextStyle(
                                        brush = Brush.linearGradient(
                                            colors = if (tabIndex == index) Constants.gradientColors else Constants.gradientWhiteColors
                                        )
                                    ),
                                    modifier = Modifier
                                        .background(
                                            color = Color.Transparent,
                                            shape = RoundedCornerShape(16.dp)
                                        )
                                        .zIndex(2f)
                                        .padding(vertical = 6.dp)

                                )

                            },
                            selected = tabIndex == index,
                            onClick = {
                                tabIndex = index

                            },
                        )
                    }
                }
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

                items(tripList) {

                    tripItem(it, { DataTrips -> })
                }
                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }

            }

        }

    }

}


@Preview
@Composable
fun previewTripScreen() {
    TripScreen()
}

@Preview
@Composable
fun previewTripItem() {
    var dataModel = DataTrips(
        sourceShort = "DEL",
        destinationShort = "JFK",

        sorceLocation = "New Delhi",
        destinationLocation = "John F. Kennedy, NY",

        takeOffTime = "23:45, Thu 15 Oct",
        landingTime = "4:30, Fri 16 Oct",

        sourceTerminal = "Terminal 3",
        destinationTerminal = "Terminal 2",
    )
    tripItem(dataModel, {})
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun tripItem(item: DataTrips, click: (source: DataTrips) -> Unit) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Teal_cl
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 20.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = { click(item) }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {

                Text(
                    ("from").uppercase(),
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    style = TextStyle(
                        color = Surface_cl
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(end = 10.dp)
                        .alpha(0.3f),
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_flight),
                    contentDescription = "",
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .rotate(45f)
                        .alpha(0.5f),
                    colorFilter = ColorFilter.tint(Surface_cl)
                )

                Text(
                    ("to").uppercase(),
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    style = TextStyle(
                        color = Surface_cl
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 10.dp)
                        .alpha(0.3f),
                    textAlign = TextAlign.End
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {

                Text(
                    item.sourceShort,
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(end = 10.dp),
                )



                Text(
                    item.destinationShort,
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 10.dp),
                    textAlign = TextAlign.End

                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    item.sorceLocation,
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(end = 10.dp)
                        .alpha(0.3f),
                )



                Text(
                    item.destinationLocation,
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 10.dp)
                        .alpha(0.3f),
                    textAlign = TextAlign.End

                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    item.takeOffTime,
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(end = 10.dp)
                        .alpha(0.3f),
                )



                Text(
                    item.landingTime,
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 10.dp)
                        .alpha(0.3f),
                    textAlign = TextAlign.End

                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    item.sourceTerminal,
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(end = 10.dp)
                        .alpha(0.3f),
                )



                Text(
                    item.destinationTerminal,
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 10.dp)
                        .alpha(0.3f),
                    textAlign = TextAlign.End

                )
            }


        }

    }

}