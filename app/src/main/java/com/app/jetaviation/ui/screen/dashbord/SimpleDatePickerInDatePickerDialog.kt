package com.app.jetaviation.ui.screen.dashbord

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.jetaviation.ui.Constants
import com.app.jetaviation.ui.theme.Green_cl
import com.app.jetaviation.ui.theme.Surface_cl

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SimpleDatePickerInDatePickerDialog(
    titleText: String,
    travelDate: Long,
    isValidationReq: Constants.DateValidation,
    onDismiss: (date: Long) -> Unit
) {


    // Need to use this PaddingValues at the moment
// otherwise you will have some padding issues…
// Could be public or fixed by Google
    val datePickerTitlePadding = PaddingValues(
        start = 24.dp,
        end = 12.dp,
        top = 16.dp
    )

// Need to use this PaddingValues at the moment
// otherwise you will have some padding issues…
// Could be public or fixed by Google
    val datePickerHeadlinePadding = PaddingValues(
        start = 24.dp,
        end = 12.dp,
        bottom = 12.dp
    )
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = travelDate
    )


    ModalBottomSheet(

        content = {

            DatePicker(
                modifier = Modifier.padding(16.dp),
                state = datePickerState,

                dateValidator = { timestamp ->

                    when (isValidationReq) {

                        Constants.DateValidation.FUTURE_DATE -> {
                            timestamp > System.currentTimeMillis()
                        }

                        Constants.DateValidation.PAST_DATE -> {
                            timestamp < System.currentTimeMillis()
                        }

                        Constants.DateValidation.NOT_VALIDATION -> {
                            true
                        }

                    }

                },
                title = {
                    Text(
                        modifier = Modifier.padding(datePickerTitlePadding),
                        text = titleText
                    )
                },
                headline = {
                    // You need to look the datePickerState value
                    Text(
                        modifier = Modifier.padding(datePickerHeadlinePadding),
                        text = datePickerState.displayMode.toString()
                    )
                },
                showModeToggle = true, // allow input mode or picker
                colors = DatePickerDefaults.colors(
//            containerColor =,
//            titleContentColor =,
//            headlineContentColor =,
//            weekdayContentColor =,
//            subheadContentColor =,
//            yearContentColor =,
//            currentYearContentColor =,
//            selectedYearContentColor =,
//            selectedYearContainerColor =,
//            dayContentColor = ,
//            disabledDayContentColor =,
                    selectedDayContentColor = Surface_cl,
//            disabledSelectedDayContentColor =,
//            selectedDayContainerColor =,
//            disabledSelectedDayContainerColor =,
                    todayContentColor = Green_cl,
                    todayDateBorderColor = Green_cl,
//            dayInSelectionRangeContentColor =,
//            dayInSelectionRangeContainerColor =
                ), // Many colors, you can decide!
            )

        },
        onDismissRequest = {
            onDismiss(datePickerState.selectedDateMillis!!)
        },

        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Surface_cl
    )


}