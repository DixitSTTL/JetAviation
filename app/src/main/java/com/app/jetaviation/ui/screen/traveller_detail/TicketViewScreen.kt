package com.app.jetaviation.ui.screen.traveller_detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
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
import com.app.jetaviation.ui.screen.trips.DataTrips
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.JetAviationTheme
import com.app.jetaviation.ui.theme.Surface_cl
import com.app.jetaviation.ui.theme.Teal_cl
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketViewScreen(navigateBack: () -> Unit) {

    var isLoaded by remember { mutableStateOf(Constants.enumIsLoaded.LOADED) }
    var item = DataTrips(
        sourceShort = "DEL",
        destinationShort = "JFK",

        sorceLocation = "New Delhi",
        destinationLocation = "John F. Kennedy, NY",

        takeOffTime = "23:45, Thu 15 Oct",
        landingTime = "4:30, Fri 16 Oct",

        sourceTerminal = "Terminal 3",
        destinationTerminal = "Terminal 2",
    )

    val rotateAngle: Float by animateFloatAsState(
        targetValue = if (isLoaded == Constants.enumIsLoaded.NOT_LOADED) 0f else -1440f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 10000, easing = FastOutSlowInEasing
            )
        )
    )

    LaunchedEffect(key1 = "") {
        isLoaded = Constants.enumIsLoaded.LOADING
        delay(12000)
        isLoaded = Constants.enumIsLoaded.LOADED

    }

    JetAviationTheme {

        Box(
            Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {

            Canvas(
                Modifier.size(100.dp)
            ) {
                drawCircle(
                    color = Card_cl, radius = size.minDimension / 2, style = Stroke(
                        width = 12f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
                    )
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_track_plane),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .rotate(rotateAngle)
            )


            Column(
                modifier = Modifier
                    .height(500.dp)
                    .align(alignment = Alignment.BottomCenter)
                    .padding(vertical = 200.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Processing your payment",
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    style = TextStyle(
                        color = White_cl_90, fontSize = 16.sp

                    )
                )

                Text(
                    "Connecting to the bank server",
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    style = TextStyle(
                        color = White_cl_30, fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(vertical = 3.dp),
                )
            }

        }

        AnimatedVisibility(visible = isLoaded == Constants.enumIsLoaded.LOADED) {

            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {},
                        navigationIcon = {
                            Icon(painter = painterResource(id = R.drawable.ic_close),
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
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent
                        )
                    )
                },

                ) {

                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(it)
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        painter = painterResource(id = R.drawable.img_celebrate),
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        "Ta-da!\n" + "Booking confirmed",
                        fontFamily = FontFamily(Font(R.font.rubik_regular)),
                        style = TextStyle(
                            fontSize = 24.sp, color = White_cl_90
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        "We’ve sent you the ticket copy on your\n" + "email and WhatsApp.",
                        fontFamily = FontFamily(Font(R.font.rubik_regular)),
                        style = TextStyle(
                            color = White_cl_90
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                                .background(Teal_cl)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
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
                                        color = Color.Black, fontSize = 16.sp
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
                                        color = Color.Black, fontSize = 16.sp

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
                                        color = Color.Black, fontSize = 12.sp
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
                                        color = Color.Black, fontSize = 12.sp
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
                                        color = Color.Black, fontSize = 12.sp
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
                                        color = Color.Black, fontSize = 12.sp
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
                                        color = Color.Black, fontSize = 12.sp
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
                                        color = Color.Black, fontSize = 12.sp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .padding(start = 10.dp)
                                        .alpha(0.3f),
                                    textAlign = TextAlign.End

                                )
                            }

                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 12.dp)
                                    .alpha(0.3f)
                                    .height(1.dp)
                                    .background(Surface_cl)
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                            ) {


                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        "GATE",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Surface_cl,
                                        ),
                                        modifier = Modifier.alpha(0.3f),
                                    )
                                    Text(
                                        "C2",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Color.Black,
                                        ),
                                        modifier = Modifier,
                                    )
                                }
                                Column(
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "FLIGHT",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Surface_cl,
                                        ),
                                        modifier = Modifier.alpha(0.3f),
                                    )
                                    Text(
                                        "UA 902Y",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Color.Black,
                                        ),
                                        modifier = Modifier,
                                    )
                                }

                                Column(
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.End

                                ) {
                                    Text(
                                        "SEAT",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Surface_cl,
                                        ),
                                        modifier = Modifier.alpha(0.3f),
                                    )
                                    Text(
                                        "14E",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Color.Black,
                                        ),
                                        modifier = Modifier,
                                    )
                                }

                            }

                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 12.dp)
                                    .alpha(0.3f)
                                    .height(1.dp)
                                    .background(Surface_cl)
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                            ) {


                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        "TRAVELLER",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Surface_cl,
                                        ),
                                        modifier = Modifier.alpha(0.3f),
                                    )
                                    Text(
                                        "Samantha Ruth",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Color.Black,
                                        ),
                                        modifier = Modifier,
                                    )
                                }

                                Column(horizontalAlignment = Alignment.End) {
                                    Text(
                                        "CLASS",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Surface_cl,
                                        ),
                                        modifier = Modifier.alpha(0.3f),
                                    )
                                    Text(
                                        "Economy",
                                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                        style = TextStyle(
                                            color = Color.Black,
                                        ),
                                        modifier = Modifier,
                                    )
                                }


                            }

                        }

                        Image(
                            painter = painterResource(id = R.drawable.ic_ticket_bg),
                            contentDescription = "",
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillWidth
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(
                                    shape = RoundedCornerShape(
                                        bottomEnd = 16.dp, bottomStart = 16.dp
                                    )
                                )
                                .background(Teal_cl)
                                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    ("ticket number").uppercase(),
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    style = TextStyle(
                                        color = Surface_cl
                                    ),
                                    modifier = Modifier.alpha(0.3f),
                                )

                                Text(
                                    ("01672721252926").uppercase(),
                                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                                    style = TextStyle(
                                        color = Surface_cl
                                    ),
                                )
                            }

                            Image(
                                painter = painterResource(id = R.drawable.img_qr),
                                contentDescription = "",
                                modifier = Modifier.size(70.dp)
                            )

                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun previewTicketViewScreen() {
    TicketViewScreen({})
}