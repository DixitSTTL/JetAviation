package com.app.jetaviation.ui.screen.covid

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.app.jetaviation.ui.screen.flight_detail.SampleText
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.Orange_cl
import com.app.jetaviation.ui.theme.Surface_cl
import com.app.jetaviation.ui.theme.White_cl_90

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CovidScreen(navigateBack: () -> Unit) {


    Scaffold(
        containerColor = Surface_cl,
        topBar = {
            CenterAlignedTopAppBar(title = {

                Text(
                    text = "COVID-19 measures",
                    style = TextStyle(
                        fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.rubik_medium))
                    ),
                    color = White_cl_90,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

            }, navigationIcon = {
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
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )

            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Your well being is our top most priority. We’re working hard to ensure your safety",
                fontFamily = FontFamily(Font(R.font.rubik_light)),
                fontSize = 24.sp,
                color = White_cl_90
            )

            Spacer(modifier = Modifier.height(16.dp))
            var tabIndex by remember { mutableIntStateOf(0) }

            val pagerState = rememberPagerState(pageCount = {
                5
            })

            HorizontalPager(
                state = pagerState,
                pageSpacing = 12.dp,
//                pageSize = object : PageSize {
//                    override fun Density.calculateMainAxisPageSize(
//                        availableSpace: Int,
//                        pageSpacing: Int
//                    ): Int {
//                        return ((availableSpace - 2 * pageSpacing) * 0.5f).toInt()
//                    }
//                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img_pagger),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                )
            }


            DotsIndicator(
                totalDots = pagerState.pageCount,
                selectedIndex = pagerState.currentPage,
                selectedColor = Orange_cl,
                unSelectedColor = Card_cl,
                mModifier = Modifier
                    .padding(vertical = 10.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Airlines around the world have adjusted their policies in COVID-19. Here’s what we are doing.",
                fontFamily = FontFamily(Font(R.font.rubik_regular)),
                color = White_cl_90
            )
            Spacer(modifier = Modifier.height(16.dp))

            SampleText(s = "Complete sanitization on arrival")
            SampleText(s = "Travellers requested to wear mask")
            SampleText(s = "Social distancing seating")
            SampleText(s = "COVID-19 rapid test on travellers")
            SampleText(s = "Flexible cancellation")

        }

    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
    mModifier: Modifier,
) {

    LazyRow(modifier = mModifier, verticalAlignment = Alignment.CenterVertically) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Image(
                    painterResource(id = R.drawable.ic_flight),
                    contentDescription = "",
                    modifier = Modifier
                        .size(16.dp)
                        .rotate(45f),
                    colorFilter = ColorFilter.tint(Orange_cl)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
            }
        }
    }
}

@Preview
@Composable
fun previewCovidScreen() {
    CovidScreen({})

}

