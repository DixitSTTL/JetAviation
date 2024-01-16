package com.app.jetaviation.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.jetaviation.R
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90

@Composable
fun travelEditText(
    str: (String) -> Unit,
    mValue: String,
    mPlaceHolder: String,
    keyboardType: KeyboardType,
    mModifier: Modifier
) {

    TextField(
        value = mValue,
        onValueChange = str,
        modifier = mModifier
            .fillMaxWidth(),
        singleLine = true,

        label = {
            Text(
                text = mPlaceHolder,
                color = White_cl_30,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.rubik_medium)),
                    fontSize = 12.sp
                )
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
        ),
        colors = TextFieldDefaults.colors(
            disabledContainerColor = Card_cl,
            focusedContainerColor = Card_cl,
            focusedTextColor = White_cl_90,
            disabledTextColor = White_cl_90,
            focusedPlaceholderColor = Card_cl,
            disabledPlaceholderColor = Card_cl,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Card_cl
        ),
        shape = RoundedCornerShape(16.dp)
    )


}