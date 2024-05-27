package com.adden00.tesk_task_neyron.features.startScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.adden00.tesk_task_neyron.R
import com.adden00.tesk_task_neyron.data.local.UserCache
import com.adden00.tesk_task_neyron.ui.design_system.Colors
import com.adden00.tesk_task_neyron.ui.design_system.Styles
import com.adden00.tesk_task_neyron.ui.design_system.TopPanel

const val phone = "+79143014334"

@Composable
fun StartScreen(
    navigator: Navigator = LocalNavigator.currentOrThrow
) {
    val user = UserCache.currentUser.collectAsState()
    Box(modifier = Modifier.background(Colors.bg_gradient)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp)
        ) {

            TopPanel {

            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = user.value.name, style = Styles.text_header_24)
            Row {
                Text(text = user.value.surname, style = Styles.text_header_24)
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    modifier = Modifier.height(24.dp),
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "edit"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = phone,
                style = Styles.text_grey_16
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = stringResource(id = R.string.my_sells), style = Styles.text_grey_16)

        }
    }
}


@Preview
@Composable
fun Preview() {
    StartScreen()
}