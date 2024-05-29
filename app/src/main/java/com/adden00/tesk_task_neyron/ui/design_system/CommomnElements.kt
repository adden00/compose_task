package com.adden00.tesk_task_neyron.ui.design_system

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adden00.tesk_task_neyron.R

@Composable
fun TopPanel(onBackClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Colors.bg_top
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 0.dp
            ),
            border = BorderStroke(2.dp, Colors.black),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
        ) {

            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "back"
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = stringResource(id = R.string.back), style = Styles.base_text)
            Spacer(modifier = Modifier.width(4.dp))

        }
    }
}


@Composable
fun ButtonBlock(
    onClick: () -> Unit, padding: PaddingValues = PaddingValues(
        start = 8.dp,
        end = 8.dp,
        top = 20.dp,
        bottom = 20.dp
    ), block: @Composable () -> Unit
) {
    Surface(shape = RoundedCornerShape(15.dp),
        color = Colors.elements_bg,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }) {
        Row(
            modifier = Modifier.padding(
                padding
            ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            block()
        }
    }
}

@Composable
fun BigButton(onClick: () -> Unit, enabled: Boolean, content: @Composable () -> Unit) {
    Button(
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.active_red,
            disabledContainerColor = Colors.passive_red,
        ),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
        onClick = onClick
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    isError: Boolean = false,
    value: String,
    placeholder: String,
    supportedText: String,
    onValueChange: (String) -> Unit

) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Colors.elements_bg,
            errorContainerColor = Colors.elements_bg,
            errorSupportingTextColor = Colors.passive_red,
            focusedTextColor = Colors.white,
            errorTextColor = Colors.active_red,
            unfocusedTextColor = Colors.white,
            errorBorderColor = Colors.active_red,
            disabledBorderColor = Colors.transparent,
            focusedBorderColor = Colors.transparent,
            unfocusedBorderColor = Colors.transparent,

            ),

        isError = isError,
        placeholder = {
            Text(
                text = placeholder,
                style = if (isError) Styles.text_red_14 else Styles.text_grey_14
            )
        },
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        supportingText = {
            if (isError) {
                Text(text = stringResource(id = R.string.wrong_data), style = Styles.text_red_14)
            } else {
                Text(
                    supportedText,
                    style = Styles.text_grey_12
                )
            }
        }
    )
}
