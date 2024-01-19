package com.app.jetaviation.ui.screen.traveller_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.jetaviation.R
import com.app.jetaviation.ui.Constants
import com.app.jetaviation.ui.Constants.countryNamesList
import com.app.jetaviation.ui.Constants.mealList
import com.app.jetaviation.ui.common.travelDropDown
import com.app.jetaviation.ui.common.travelEditText
import com.app.jetaviation.ui.screen.dashbord.Formater
import com.app.jetaviation.ui.screen.dashbord.SimpleDatePickerInDatePickerDialog
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.Green_cl
import com.app.jetaviation.ui.theme.Surface_cl
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravellerDetailScreen(navigateBack: () -> Unit, navigateCardDetail: () -> Unit) {
    val gender = listOf("Male", "Female")
    var fName by remember { mutableStateOf("") }
    var lName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNum by remember { mutableStateOf("") }
    var dobText by remember { mutableLongStateOf(System.currentTimeMillis()) }
    var expText by remember { mutableLongStateOf(System.currentTimeMillis()) }
    var passportNumber by remember { mutableStateOf("") }
    val (selected, setSelected) = remember { mutableStateOf("") }
    var isOpenDate by remember {
        mutableStateOf(false)
    }
    var isOpenExpDate by remember {
        mutableStateOf(false)
    }


    Scaffold(
        containerColor = Surface_cl,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Traveller Details",
                        style = TextStyle(
                            fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.rubik_medium))
                        ),
                        color = White_cl_90,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },

                navigationIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_back),
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
        },
        content = {

            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Green_cl)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(Surface_cl)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "These details must match passport and photo ID",
                        fontFamily = FontFamily(Font(R.font.rubik_regular)),
                        style = TextStyle(
                            color = Surface_cl,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    gender.forEach {
                        RadioButton(selected = selected == it, onClick = {
                            setSelected(it)
                        })

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = it,
                            fontFamily = FontFamily(Font(R.font.rubik_regular)),
                            style = TextStyle(
                                color = White_cl_90,
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                travelEditText(
                    mValue = fName,
                    mPlaceHolder = "FIRST NAME",
                    mModifier = Modifier
                        .padding(vertical = 6.dp)
                        .height(60.dp),
                    str = {
                        fName = it

                    },
                    keyboardType = KeyboardType.Text
                )

                travelEditText(
                    mValue = lName,
                    mPlaceHolder = "LAST NAME",
                    mModifier = Modifier.padding(vertical = 6.dp),
                    str = {
                        lName = it

                    },
                    keyboardType = KeyboardType.Text
                )

                travelEditText(
                    mValue = email,
                    mPlaceHolder = "EMAIL",
                    mModifier = Modifier
                        .padding(vertical = 6.dp)
                        .height(60.dp),
                    str = {
                        email = it

                    },
                    keyboardType = KeyboardType.Email
                )

                travelEditText(
                    mValue = phoneNum,
                    mPlaceHolder = "PHONE NUMBER",
                    mModifier = Modifier
                        .padding(vertical = 6.dp)
                        .height(60.dp),
                    str = {
                        phoneNum = it

                    },
                    keyboardType = KeyboardType.Number
                )

                travelDropDown(
                    list = countryNamesList, label = "NATIONALITY"
                )

                TextField(
                    value = Formater(dobText),
                    onValueChange = {},
                    label = {
                        Text(
                            text = "DOB", color = White_cl_30, style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.rubik_medium)), fontSize = 12.sp
                            )
                        )
                    },
                    enabled = false,
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        disabledContainerColor = Card_cl,
                        focusedContainerColor = Card_cl,
                        focusedTextColor = White_cl_90,
                        disabledTextColor = White_cl_90,
                        focusedPlaceholderColor = Card_cl,
                        disabledPlaceholderColor = Card_cl,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Card_cl,
                        unfocusedLabelColor = Card_cl,
                        disabledLabelColor = Card_cl,
                        focusedLabelColor = White_cl_30
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable(onClick = { isOpenDate = true })
                )

                travelDropDown(
                    list = mealList, label = "MEAL"
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "PASSPORT DETAILS",
                    fontFamily = FontFamily(Font(R.font.rubik_regular)),
                    color = White_cl_30,
                    fontSize = 12.sp
                )

                travelEditText(
                    mValue = passportNumber,
                    mPlaceHolder = "PASSPORT NUMBER",
                    mModifier = Modifier
                        .padding(vertical = 6.dp)
                        .height(60.dp),
                    str = {
                        passportNumber = it

                    },
                    keyboardType = KeyboardType.NumberPassword
                )

                travelDropDown(
                    list = countryNamesList, label = "ISSUING COUNTRY"
                )

                TextField(
                    value = Formater(expText),
                    onValueChange = {},
                    label = {
                        Text(
                            text = "EXPIRY", color = White_cl_30, style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.rubik_medium)), fontSize = 12.sp
                            )
                        )
                    },
                    enabled = false,
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        disabledContainerColor = Card_cl,
                        focusedContainerColor = Card_cl,
                        focusedTextColor = White_cl_90,
                        disabledTextColor = White_cl_90,
                        focusedPlaceholderColor = Card_cl,
                        disabledPlaceholderColor = Card_cl,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Card_cl,
                        unfocusedLabelColor = Card_cl,
                        disabledLabelColor = Card_cl,
                        focusedLabelColor = White_cl_30
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable(onClick = { isOpenExpDate = true })
                )


            }

            if (isOpenDate) {

                SimpleDatePickerInDatePickerDialog(
                    titleText = "DATE OF BIRTH",
                    dobText,
                    isValidationReq = Constants.DateValidation.PAST_DATE
                ) { date ->
                    isOpenDate = false
                    dobText = date
                }

            }
            if (isOpenExpDate) {

                SimpleDatePickerInDatePickerDialog(
                    titleText = "EXPIRY DATE",
                    expText,
                    isValidationReq = Constants.DateValidation.NOT_VALIDATION
                ) { date ->
                    isOpenExpDate = false
                    expText = date
                }

            }
        },

        bottomBar = {
            Column(
                Modifier.background(Surface_cl)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(White_cl_30)
                )

                Row(
                    Modifier.padding(12.dp)
                ) {

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
                                color = White_cl_90, fontSize = 20.sp
                            ),
                            textAlign = TextAlign.End
                        )
                    }

                    Button(
                        onClick = {
                            navigateCardDetail()
                        },
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


@Preview(backgroundColor = 0xFF1D2026)
@Composable
fun previewTripDetailScreen() {
    TravellerDetailScreen({}, {})

}
