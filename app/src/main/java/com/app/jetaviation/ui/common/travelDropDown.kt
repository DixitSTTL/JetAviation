package com.app.jetaviation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.jetaviation.R
import com.app.jetaviation.ui.theme.Card_cl
import com.app.jetaviation.ui.theme.White_cl_30
import com.app.jetaviation.ui.theme.White_cl_90
import com.app.jetaviation.ui.theme.Yellow_cl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun travelDropDown(list: List<String>, label: String) {


    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
    ) {
        TextField(
            value = selectedOptionText,
            onValueChange = {
                selectedOptionText = it
            },
            label = {
                Text(
                    text = label,
                    color = White_cl_30,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.rubik_medium)),
                        fontSize = 12.sp
                    )
                )
            },
            readOnly = true,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_drop_down),
                    contentDescription = "",
                    modifier = Modifier.rotate(if (expanded) 180f else 0f)
                )
            },
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
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
                .height(60.dp)
                .menuAnchor(),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier
                .background(Yellow_cl)
                .clip(RoundedCornerShape(16.dp))
        ) {
            list.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                    text = {
                        Text(
                            text = (selectionOption).uppercase(),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.rubik_medium)),
                            )
                        )
                    },
                    colors = MenuDefaults.itemColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Black
                    ),


                    )
            }
        }
    }


}

