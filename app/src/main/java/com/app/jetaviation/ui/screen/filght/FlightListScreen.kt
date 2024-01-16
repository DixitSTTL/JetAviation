package com.app.jetaviation.ui.screen.filght

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.jetaviation.R
import com.app.jetaviation.ui.Constants
import com.app.jetaviation.ui.screen.dashbord.Formater
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.JetAviationTheme
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightListScreen(
    SOURCE: String?,
    DESTINATION: String?,
    DATE: Long?,
    CLASS: String?,
    navigateFlightDetails: () -> Unit,
    navigateBack: () -> Unit,
) {

    var isLoaded by remember { mutableStateOf(Constants.enumIsLoaded.NOT_LOADED) }

    val offsetAnimation: Dp by animateDpAsState(

        if (isLoaded == Constants.enumIsLoaded.NOT_LOADED) 0.dp else 200.dp,
        animationSpec = tween(
            delayMillis = 1000,
            durationMillis = 1500
        )
    )

    LaunchedEffect(key1 = "") {
        isLoaded = Constants.enumIsLoaded.LOADING
        delay(3000)
        isLoaded = Constants.enumIsLoaded.LOADED

    }

    JetAviationTheme {

        Scaffold(
            contentColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "",
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .clickable {
                                    navigateBack()
                                }
                                .padding(5.dp)

                        )
                    },
                    title = {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 4.dp)
                            ) {

                                Text(
                                    SOURCE!!,
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    style = TextStyle(
                                        color = White_cl_90
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .padding(end = 10.dp),
                                    textAlign = TextAlign.End
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.ic_flight),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterVertically)
                                        .rotate(45f)
                                )

                                Text(
                                    DESTINATION!!,
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    style = TextStyle(
                                        color = White_cl_90
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .padding(start = 10.dp),
                                    textAlign = TextAlign.Start
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 4.dp)
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Text(
                                    Formater(DATE!!),
                                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                    style = TextStyle(
                                        color = White_cl_30,
                                        fontSize = 12.sp
                                    ),
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically),
                                    textAlign = TextAlign.End
                                )

                                Spacer(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .padding(3.dp)
                                        .clip(CircleShape)
                                        .background(White_cl_30)
                                )

                                Text(
                                    CLASS!!,
                                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                    style = TextStyle(
                                        color = White_cl_30,
                                        fontSize = 12.sp
                                    ),
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically),
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )


            },
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {


                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(White_cl_30)
                        .padding(vertical = 4.dp)
                )
                AnimatedVisibility(visible = isLoaded == Constants.enumIsLoaded.LOADED) {
                    LazyColumn {

                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                        items(Constants.flightList) { item ->

                            flightItem(
                                item,
                                navigateFlightDetails,
                                Modifier.padding(vertical = 6.dp, horizontal = 20.dp)
                            )

                        }

                    }
                }

                AnimatedVisibility(visible = isLoaded == Constants.enumIsLoaded.LOADING) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Box(modifier = Modifier.fillMaxWidth()) {

                            Image(
                                painter = painterResource(id = R.drawable.ic_logo),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(offsetAnimation)
                                    .align(alignment = Alignment.Center)
                            )

                        }

                        Text(
                            "Keep your seatbelt fastened!",
                            fontFamily = FontFamily(Font(R.font.rubik_medium)),
                            style = TextStyle(
                                color = White_cl_90
                            ),
                            modifier = Modifier
                                .padding(top = 60.dp)
                                .align(alignment = Alignment.CenterHorizontally),

                            )

                        Text(
                            "Looking for best flights",
                            fontFamily = FontFamily(Font(R.font.rubik_light)),
                            style = TextStyle(
                                color = White_cl_30,
                            ),
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .align(alignment = Alignment.CenterHorizontally),
                        )

                    }
                }

            }

        }

    }

}

@Preview
@Composable
fun previewFlightListScreen() {
    FlightListScreen("DEL", "AHM", 1676000000000, "Economy", {}, {})
}

@Preview
@Composable
fun previewflightItem() {
    var data = DataFlights(
        sd_name = "DEL - JFK",
        airline = "United Airlines UA 802",
        price = "₹ 45,168",
        timePeriod = "23:45 - 4:30",
        tag = "fastest",
        totalTime = "15h 15m • Direct",
        img = R.drawable.img_ua
    )

    flightItem(data, {}, Modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun flightItem(item: DataFlights, click: () -> Unit, modifier: Modifier) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Card_cl
        ),
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        onClick = { click() }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                Text(
                    item.sd_name,
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .align(alignment = Alignment.CenterVertically),
                    style = TextStyle(
                        color = White_cl_30
                    )
                )
                Text(
                    (item.tag).uppercase(),
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .align(alignment = Alignment.CenterVertically),
                    style = TextStyle(

                        brush = Brush.linearGradient(
                            colors = Constants.gradientColors
                        ),
                        fontSize = 18.sp
                    ),
                    textAlign = TextAlign.End
                )

            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                Column(Modifier.weight(1f)) {
                    Text(
                        item.timePeriod,
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        color = White_cl_90,

                        )
                    Text(
                        item.totalTime,
                        fontFamily = FontFamily(Font(R.font.rubik_light)),
                        color = White_cl_30,
                        fontSize = 12.sp
                    )
                }

                Text(
                    "₹",
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    style = TextStyle(
                        color = White_cl_90
                    )
                )
                Text(
                    item.price,
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 34.sp,
                        color = White_cl_90
                    )
                )

            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = item.img),
                    contentDescription = "",
                    modifier = Modifier.size(45.dp)
                )

                Text(
                    item.airline,
                    fontFamily = FontFamily(Font(R.font.rubik_light)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterVertically)
                        .padding(start = 16.dp),
                    style = TextStyle(
                        color = White_cl_90
                    )
                )

            }

        }

    }

}