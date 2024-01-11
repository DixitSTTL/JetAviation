package com.app.jetaviation.ui.screen.flight_detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
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
import com.app.jetaviation.ui.screen.filght.DataFlights
import com.app.jetaviation.ui.screen.filght.flightItem
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.Green_cl
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightDetailScreen() {
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
        content = {
            it
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
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
                            contentDescription = ""
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

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

                    CustomCard {
                        Column(modifier = Modifier.padding(16.dp)) {


                            Text(
                                "What all you can\n" +
                                        "take?",
                                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    color = White_cl_90
                                )
                            )
                            SampleText2(R.drawable.ic_cabin_bag,"1 Cabin Bag 7kg")
                            SampleText2(R.drawable.ic_checkin_bag,"2 Checkin Bags 23kg each")


                        }

                    }


                }

            }


        }
    )


}

@Composable
fun CustomCard(compos: @Composable () -> Unit) {

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
                painter = painterResource(id = R.drawable.img_bags),
                contentDescription = "",
                modifier = Modifier.align(alignment = Alignment.TopEnd)

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
    FlightDetailScreen()

}
