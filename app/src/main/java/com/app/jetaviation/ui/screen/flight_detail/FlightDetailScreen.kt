package com.app.jetaviation.ui.screen.flight_detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.jetaviation.R
import com.app.jetaviation.ui.Constants
import com.app.jetaviation.ui.screen.filght.DataFlights
import com.app.jetaviation.ui.screen.filght.flightItem
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.Green_cl
import com.app.jetaviation.ui.theme.Red_cl
import com.app.jetaviation.ui.theme.Surface_cl
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightDetailScreen(onBackPress: () -> Unit) {
    var data = DataFlights(
        sd_name = "DEL - JFK",
        airline = "United Airlines UA 802",
        price = "₹ 45,168",
        timePeriod = "23:45 - 4:30",
        tag = "fastest",
        totalTime = "15h 15m • Direct",
        img = R.drawable.img_ua
    )
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {

                    Text(
                        text = "Flight Details", style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.rubik_medium))
                        ),
                        color = White_cl_90,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            .clickable {
                                onBackPress()
                            }.padding(5.dp)

                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        content = {

            Column(
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState())
            ) {

                Column(modifier = Modifier.fillMaxWidth()) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Max)
                            .padding(horizontal = 10.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(vertical = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(16.dp)
                                    .border(3.dp, color = Card_cl, shape = CircleShape)
                            )
                            Canvas(
                                Modifier
                                    .weight(1f)
                                    .width(1.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                val pathEffect =
                                    PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)

                                drawLine(
                                    color = Card_cl,
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, size.height),
                                    pathEffect = pathEffect,
                                    strokeWidth = 5f,
                                    cap = StrokeCap.Round
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.ic_flight),
                                contentDescription = "",
                                modifier = Modifier.rotate(135f),
                                colorFilter = ColorFilter.tint(Card_cl)
                            )


                        }


                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 10.dp),
                        ) {
                            Text(
                                "Indra Gandhi (DEL), New Delhi, India",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                color = White_cl_90,

                                )
                            Text(
                                "Departure: 23:45, Thu 15 Oct",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                color = White_cl_30,
                                fontSize = 12.sp
                            )

                            flightItem(data, {}, Modifier.padding(vertical = 16.dp))

                            Text(
                                "John F. Kenedy (JFK), New York (NY), USA",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                color = White_cl_90,

                                )
                            Text(
                                "Arrival: 4:30, Fri 16 Oct",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                color = White_cl_30,
                                fontSize = 12.sp
                            )
                        }


                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Card_cl
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        shape = RoundedCornerShape(16.dp)

                    ) {

                        Column(modifier = Modifier.padding(12.dp)) {

                            Text(
                                "What flight crew is doing to ensure your safety?",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    color = White_cl_90
                                )
                            )

                            SampleText("Flight crew wearing PPE kit")
                            SampleText("Cleaning wipes provided")
                            SampleText("Emergency KIT")
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomCard(
                        {
                            Column(modifier = Modifier) {
                                Column(
                                    modifier = Modifier.padding(
                                        horizontal = 16.dp,
                                        vertical = 12.dp
                                    )
                                ) {

                                    Text(
                                        "Know about your\n" +
                                                "flight",
                                        fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                        style = TextStyle(
                                            fontSize = 24.sp,
                                            color = White_cl_90
                                        )
                                    )
                                    Text(
                                        "You will fly on Boing 777 plane, but this is not guaranteed.",
                                        fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                        style = TextStyle(
                                            color = White_cl_90,
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )


                                }

                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(White_cl_30)
                                )

                                Column(
                                    modifier = Modifier.padding(
                                        horizontal = 16.dp,
                                        vertical = 12.dp
                                    )
                                ) {

                                    Text(
                                        "From past year, all the flights are",
                                        fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                        style = TextStyle(
                                            color = White_cl_90,
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )

                                    Row {
                                        Row(
                                            modifier = Modifier.weight(1f),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "91%",
                                                style = TextStyle(
                                                    color = Green_cl,
                                                    fontSize = 26.sp,
                                                    fontFamily = FontFamily(Font(R.font.rubik_medium))
                                                )
                                            )
                                            Text(
                                                text = "on time",
                                                style = TextStyle(
                                                    color = White_cl_30,
                                                    fontFamily = FontFamily(Font(R.font.rubik_regular))
                                                ),
                                                modifier = Modifier.padding(start = 10.dp)
                                            )


                                        }
                                        Spacer(modifier = Modifier.height(4.dp))

                                        Row(
                                            modifier = Modifier.weight(1f),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "12.9m",
                                                style = TextStyle(
                                                    color = Red_cl,
                                                    fontSize = 26.sp,
                                                    fontFamily = FontFamily(Font(R.font.rubik_medium))
                                                )
                                            )
                                            Text(
                                                text = "average\n" +
                                                        "delay",
                                                style = TextStyle(
                                                    color = White_cl_30,
                                                    fontFamily = FontFamily(Font(R.font.rubik_regular))
                                                ),
                                                modifier = Modifier.padding(start = 10.dp)
                                            )

                                        }


                                    }


                                }


                            }
                        },
                        R.drawable.img_plane
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomCard(
                        {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    ("baggage policy").uppercase(),
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    style = TextStyle(
                                        color = White_cl_30,
                                    ),
                                )

                                Spacer(modifier = Modifier.size(2.dp))

                                Text(
                                    "What all you can\n" +
                                            "take?",
                                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                    style = TextStyle(
                                        fontSize = 24.sp,
                                        color = White_cl_90
                                    )
                                )

                                SampleText2(R.drawable.ic_cabin_bag, "1 Cabin Bag 7kg")

                                SampleText2(R.drawable.ic_checkin_bag, "2 Checkin Bags 23kg each")

                                Spacer(modifier = Modifier.size(6.dp))

                                Text(
                                    "Have extra bags?",
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    style = TextStyle(
                                        brush = Brush.linearGradient(
                                            colors = Constants.gradientColors
                                        ),
                                        fontSize = 16.sp
                                    ),
                                )

                            }


                        },
                        R.drawable.img_bags
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Card_cl
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        shape = RoundedCornerShape(16.dp)

                    ) {

                        Column(modifier = Modifier.padding(12.dp)) {

                            Text(
                                "In flight experience",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    color = White_cl_90
                                )
                            )

                            SampleText2(R.drawable.ic_meal, "Free meal provided")
                            SampleText2(R.drawable.ic_entertainment, "Entertainment")
                            SampleText2(R.drawable.ic_usb, "Power and USB port")
                            SampleText2(R.drawable.ic_seat, "3-3-3 seat layout")

                        }
                    }

                }

            }

        },
        bottomBar = {
            Column(
                Modifier
                    .background(Surface_cl)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(White_cl_30)
                )

                Row(
                    Modifier
                        .padding(12.dp)
                )
                {

                    Column(
                        Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)
                    ) {
                        Text(
                            ("total fare").uppercase(),
                            fontFamily = FontFamily(Font(R.font.rubik_medium)),
                            style = TextStyle(
                                color = White_cl_30
                            )
                        )
                        Text(
                            "₹ 45,307",
                            fontFamily = FontFamily(Font(R.font.rubik_medium)),
                            style = TextStyle(
                                color = White_cl_90,
                                fontSize = 20.sp
                            ),
                            textAlign = TextAlign.End
                        )
                    }

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = 12.dp)
                            .height(40.dp)
                            .background(
                                brush = Brush.verticalGradient(colors = Constants.gradientColors),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .align(Alignment.CenterVertically),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            "Continue",
                            fontFamily = FontFamily(Font(R.font.rubik_medium)),
                            color = Color.Black,
                            fontSize = 16.sp,
                        )
                    }

                }
            }


        }

    )

}

@Composable
fun CustomCard(compos: @Composable () -> Unit, img: Int) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Card_cl
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(16.dp)

    ) {
        Box {

            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
                    .size(100.dp)
                    .aspectRatio(1f)
                    .padding(vertical = 12.dp),
                alignment = Alignment.TopEnd
            )

            compos()
        }


    }
}

@Composable
fun SampleText(s: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_tick),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Green_cl)
        )

        Text(
            s,
            fontFamily = FontFamily(Font(R.font.rubik_regular)),
            style = TextStyle(
                color = White_cl_90
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)
        )
    }

}

@Composable
fun SampleText2(s1: Int, s: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Image(
            painter = painterResource(id = s1),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Green_cl)
        )

        Text(
            s,
            fontFamily = FontFamily(Font(R.font.rubik_regular)),
            style = TextStyle(
                color = White_cl_90
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)
        )
    }

}

@Preview
@Composable
fun previewFlightDetailScreen() {
    FlightDetailScreen {}

}
