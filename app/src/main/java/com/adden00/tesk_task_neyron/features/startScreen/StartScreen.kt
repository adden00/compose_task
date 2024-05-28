package com.adden00.tesk_task_neyron.features.startScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.adden00.tesk_task_neyron.R
import com.adden00.tesk_task_neyron.app.navigation.BankScreenRoute
import com.adden00.tesk_task_neyron.app.navigation.HistoryScreenRoute
import com.adden00.tesk_task_neyron.ui.design_system.ButtonBlock
import com.adden00.tesk_task_neyron.ui.design_system.Colors
import com.adden00.tesk_task_neyron.ui.design_system.Styles
import com.adden00.tesk_task_neyron.ui.design_system.TopPanel


@Composable
fun StartScreen(
    viewModel: StartViewModel = hiltViewModel(),
    navigator: Navigator = LocalNavigator.currentOrThrow
) {
    val userInfo = viewModel.currentUser.collectAsState()

    Box(modifier = Modifier.background(Colors.bg_gradient)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp)
        ) {

            TopPanel {}
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = userInfo.value.name, style = Styles.text_header_26)

                Row {
                    Text(text = userInfo.value.surname, style = Styles.text_header_26)
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(
                        modifier = Modifier.height(24.dp),
                        tint = Colors.grey,
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "edit"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = userInfo.value.phone,
                    style = Styles.text_grey_16
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = stringResource(id = R.string.my_sells), style = Styles.text_grey_16)

                Spacer(modifier = Modifier.height(8.dp))

                ButtonBlock(
                    onClick = { navigator.push(HistoryScreenRoute) },
                    padding = PaddingValues(8.dp)
                ) {
                    Image(
                        modifier = Modifier.size(48.dp),
                        painter = painterResource(id = R.drawable.ic_buy),
                        contentDescription = "on"
                    )
                    ForwardIcon()
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.settings), style = Styles.text_grey_16)
                Spacer(modifier = Modifier.height(8.dp))

                ButtonBlock(onClick = {}) {
                    Text(text = stringResource(id = R.string.email), style = Styles.text_grey_16)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = userInfo.value.email, style = Styles.base_text)
                            Text(
                                text = stringResource(id = R.string.need_confirm),
                                style = Styles.text_red_hint
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        ForwardIcon()
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                ButtonBlock(onClick = {}) {
                    Text(
                        text = stringResource(id = R.string.enter_bio),
                        style = Styles.text_grey_16
                    )
                    Switch(
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Colors.white,
                            uncheckedThumbColor = Colors.white,
                            checkedTrackColor = Colors.active_red,
                            uncheckedTrackColor = Colors.grey
                        ),
                        checked = true, onCheckedChange = {},
                        modifier = Modifier
                            .scale(0.7f)
                            .height(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                ButtonBlock(onClick = {}) {
                    Text(
                        text = stringResource(id = R.string.change_pin),
                        style = Styles.text_grey_16
                    )
                    ForwardIcon()

                }

                Spacer(modifier = Modifier.height(8.dp))

                ButtonBlock(onClick = { navigator.push(BankScreenRoute) }) {
                    Text(
                        text = stringResource(id = R.string.bankRegister),
                        style = Styles.text_grey_16
                    )
                    ForwardIcon()
                }

                Spacer(modifier = Modifier.height(8.dp))

                ButtonBlock(onClick = {}) {
                    Text(
                        text = stringResource(id = R.string.language),
                        style = Styles.text_grey_16
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = userInfo.value.language, style = Styles.base_text)
                        ForwardIcon()
                    }
                }
            }
        }
    }
}


@Composable
fun ForwardIcon() {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_front),
        tint = Colors.white,
        modifier = Modifier
            .padding(end = 8.dp)
            .size(16.dp),
        contentDescription = "forward"
    )
}

