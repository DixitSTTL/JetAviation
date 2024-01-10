package com.app.jetaviation.ui.screen.trips

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.app.jetaviation.R
import com.app.jetaviation.ui.Constants
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.Orange_cl
import com.app.jetaviation.ui.theme.Yellow_cl

@Composable
fun TripScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val titles = listOf("Upcoming", "Past")

    Scaffold {

        it
        Column(modifier = Modifier.fillMaxSize()) {

            TabRow(
                selectedTabIndex = tabIndex,
                modifier = Modifier
                    .width(250.dp)
                    .padding(horizontal = 3.dp)
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
                    .align(alignment = Alignment.CenterHorizontally),
                containerColor = Card_cl,
                indicator = {

                    TabRowDefaults.Indicator(
                        Modifier
                            .tabIndicatorOffset(it[tabIndex])

                            .background(Orange_cl)
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

                            )
                        },
                        selected = tabIndex == index,
                        onClick = {
                            tabIndex = index

                        },
                    )
                }
            }

            LazyColumn {

            }


        }

    }


}