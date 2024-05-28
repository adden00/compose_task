package com.adden00.tesk_task_neyron.features.history_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.adden00.tesk_task_neyron.R
import com.adden00.tesk_task_neyron.features.history_screen.mvi.HistoryEvent
import com.adden00.tesk_task_neyron.ui.design_system.Colors
import com.adden00.tesk_task_neyron.ui.design_system.Styles
import com.adden00.tesk_task_neyron.ui.design_system.TopPanel

@Composable
fun HistoryScreen(
    navigator: Navigator = LocalNavigator.currentOrThrow,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val state = viewModel.screenState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.newEvent(HistoryEvent.LoadHistory)
    }

    if (state.value.isLoading) {
        Dialog(onDismissRequest = {}) {
            Surface(shadowElevation = 10.dp, color = Colors.bg_bottom) {
                CircularProgressIndicator(modifier = Modifier.padding(24.dp))
            }
        }
    }

    Box(modifier = Modifier.background(Colors.bg_gradient)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp)
        ) {

            TopPanel(
                onBackClick = {
                    navigator.pop()
                }
            )

            Spacer(modifier = Modifier.height(32.dp))
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, text = stringResource(id = R.string.history), style = Styles.text_header_26)
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                LazyColumn {
                    state.value.historyList.forEach {
                        item {
                            Text(text = it.date, style = Styles.text_header_26.copy(fontSize = 20.sp))
                        }
                        items(it.names) { name ->
                            Text(modifier = Modifier.padding(start = 16.dp, top = 4.dp), text = name, style = Styles.base_text)
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}
