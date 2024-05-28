package com.adden00.tesk_task_neyron.features.bank_registration_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.adden00.tesk_task_neyron.R
import com.adden00.tesk_task_neyron.app.navigation.StartScreenRoute
import com.adden00.tesk_task_neyron.features.bank_registration_screen.models.RegisterInfo
import com.adden00.tesk_task_neyron.features.bank_registration_screen.mvi.RegisterBankEffect
import com.adden00.tesk_task_neyron.features.bank_registration_screen.mvi.RegisterBankEvent
import com.adden00.tesk_task_neyron.ui.design_system.BigButton
import com.adden00.tesk_task_neyron.ui.design_system.Colors
import com.adden00.tesk_task_neyron.ui.design_system.EditText
import com.adden00.tesk_task_neyron.ui.design_system.Styles
import com.adden00.tesk_task_neyron.ui.design_system.TopPanel


data class TextFieldsChecker(
    val isNumberError: Boolean = false,
    val isCodeError: Boolean = false,
    val isNameError: Boolean = false,
    val isSurnameError: Boolean = false,
)

private fun checkValues(input: RegisterInfo): Boolean =
    input.number.length == 16 &&
            input.number.isDigitsOnly() &&
            input.name.isNotEmpty() &&
            input.surname.isNotEmpty() &&
            input.code.isNotEmpty()

@Composable
fun BankRegistrationScreen(
    navigator: Navigator = LocalNavigator.currentOrThrow,
    viewModel: BankRegistrationViewModel = hiltViewModel()

) {

    LaunchedEffect(key1 = Unit) {
        viewModel.screenEffect.collect { effect ->
            when (effect) {
                RegisterBankEffect.NavigateToMain -> {
                    navigator.popUntilRoot()
                    navigator.replace(StartScreenRoute)
                }
            }
        }
    }

    val state = viewModel.screenState.collectAsState()
    val textFieldsState = remember { mutableStateOf(RegisterInfo("", "", "", "")) }
    val textFieldsChecker = remember { mutableStateOf(TextFieldsChecker()) }

    if (state.value.isLoading) {
        Dialog(onDismissRequest = {}) {
            Surface(shadowElevation = 10.dp) {
                CircularProgressIndicator(modifier = Modifier.padding(24.dp))
            }
        }
    }

    Box(modifier = Modifier.background(Colors.bg_gradient)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),

                ) {
                TopPanel {
                    navigator.pop()
                }
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = stringResource(id = R.string.bankRegister),
                        style = Styles.text_header_26
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    EditText(
                        value = textFieldsState.value.number,
                        isError = textFieldsChecker.value.isNumberError,
                        label = stringResource(id = R.string.number),
                        supportedText = stringResource(id = R.string.number_hint),
                        onValueChange = {
                            textFieldsState.value = textFieldsState.value.copy(number = it)
                            textFieldsChecker.value =
                                textFieldsChecker.value.copy(
                                    isNumberError = !(textFieldsState.value.number.length == 16 &&
                                            textFieldsState.value.number.isDigitsOnly())
                                )
                        })
                    Spacer(modifier = Modifier.height(16.dp))

                    EditText(
                        value = textFieldsState.value.code,
                        isError = textFieldsChecker.value.isCodeError,
                        label = stringResource(id = R.string.code),
                        supportedText = stringResource(id = R.string.code_hint),
                        onValueChange = {
                            textFieldsState.value = textFieldsState.value.copy(code = it)
                            textFieldsChecker.value =
                                textFieldsChecker.value.copy(
                                    isCodeError = textFieldsState.value.code.isEmpty()
                                )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    EditText(
                        value = textFieldsState.value.name,
                        isError = textFieldsChecker.value.isNameError,
                        label = stringResource(id = R.string.name),
                        supportedText = stringResource(id = R.string.name_hint),
                        onValueChange = {
                            textFieldsState.value = textFieldsState.value.copy(name = it)
                            textFieldsChecker.value =
                                textFieldsChecker.value.copy(
                                    isNameError = textFieldsState.value.name.isEmpty()

                                )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    EditText(
                        value = textFieldsState.value.surname,
                        isError = textFieldsChecker.value.isSurnameError,
                        label = stringResource(id = R.string.surname),
                        supportedText = stringResource(id = R.string.surname_hint),
                        onValueChange = {
                            textFieldsState.value = textFieldsState.value.copy(surname = it)
                            textFieldsChecker.value =
                                textFieldsChecker.value.copy(
                                    isSurnameError = textFieldsState.value.surname.isEmpty()
                                )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.confirmation_text),
                    style = Styles.text_grey_16,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                BigButton(
                    enabled = checkValues(textFieldsState.value),
                    onClick = {
                        viewModel.newEvent(
                            RegisterBankEvent.ConfirmRegister(
                                textFieldsState.value
                            )
                        )
                    }) {
                    Text(
                        text = stringResource(id = R.string.continue_reg),
                        style = Styles.base_text
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}




