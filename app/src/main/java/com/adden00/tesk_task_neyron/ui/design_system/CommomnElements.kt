package com.adden00.tesk_task_neyron.ui.design_system

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 0.dp
            ),
            border = BorderStroke(1.dp, Colors.black),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
        ) {

            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "back"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.back), style = Styles.base_text)
            Spacer(modifier = Modifier.width(4.dp))

        }
    }
}