package co.kr.tnt.signup.trainee

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.core.designsystem.R
import co.kr.tnt.designsystem.component.TnTLabeledTextField
import co.kr.tnt.designsystem.component.TnTTopBar
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.signup.trainee.component.ProgressSteps
import java.util.Calendar

@Composable
fun TraineeBasicInfoScreen() {
    // TODO 상태 관리 따로 빼기
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }

    val isHeightValid by remember { derivedStateOf { height.isNotEmpty() && validateInput(height) } }
    val isWeightValid by remember { derivedStateOf { weight.isNotEmpty() && validateInput(weight) } }

    val isFormValid by remember { derivedStateOf { isHeightValid && isWeightValid } }

    Scaffold(
        // TODO 버튼 클릭 시 트레이니 이름 입력 화면으로 이동
        topBar = { TnTTopBar(onBackClick = {}) },
        containerColor = TnTTheme.colors.commonColors.Common0,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .imePadding()
                    .verticalScroll(rememberScrollState()),
            ) {
                ProgressSteps(
                    currentStep = 2,
                    totalSteps = 4,
                    title = stringResource(R.string.signup_set_basic_info_title),
                    subTitle = stringResource(R.string.signup_set_basic_info_subtitle),
                )
                Spacer(Modifier.padding(top = 48.dp))
                Text(
                    text = stringResource(R.string.user_birthday),
                    color = TnTTheme.colors.neutralColors.Neutral900,
                    style = TnTTheme.typography.body1Bold,
                    modifier = Modifier.padding(start = 20.dp, bottom = 8.dp),
                )
                BirthdayPicker(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    onDateSelected = { birthday = it },
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = TnTTheme.colors.neutralColors.Neutral200,
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
                Spacer(Modifier.padding(top = 48.dp))
                BodyInfoInput(
                    height = height,
                    weight = weight,
                    onHeightChange = { newHeight ->
                        if (validateInput(newHeight)) {
                            height = newHeight
                        }
                    },
                    onWeightChange = { newWeight ->
                        if (validateInput(newWeight)) {
                            weight = newWeight
                        }
                    },
                )
            }
            // TODO 트레이니 PT 목적 화면으로 이동
            TnTBottomButton(
                text = stringResource(R.string.next),
                modifier = Modifier.align(Alignment.BottomCenter),
                enabled = isFormValid,
                onClick = { },
            )
        }
    }
}

@Composable
private fun BirthdayPicker(
    modifier: Modifier = Modifier,
    initialDate: String = "2000/01/01",
    onDateSelected: (String) -> Unit = {},
) {
    var selectedDate by remember { mutableStateOf(initialDate) }
    val context = LocalContext.current

    val textColor = if (selectedDate == initialDate) {
        TnTTheme.colors.neutralColors.Neutral400
    } else {
        TnTTheme.colors.neutralColors.Neutral600
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val calendar = Calendar.getInstance()
                val today = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(
                    context,
                    { _, selectedYear, selectedMonth, selectedDay ->
                        val formattedDate =
                            "$selectedYear/${"%02d".format(selectedMonth + 1)}/${
                                "%02d".format(selectedDay)
                            }"
                        selectedDate = formattedDate
                        onDateSelected(formattedDate)
                    },
                    year,
                    month,
                    day,
                )
                    .apply {
                        // 오늘 이후는 선택 불가능
                        datePicker.maxDate = today.timeInMillis
                    }
                    .show()
            },
    ) {
        Text(
            text = selectedDate,
            color = textColor,
            style = TnTTheme.typography.body1Medium,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
private fun Unit(stringResId: Int) {
    Text(
        text = stringResource(stringResId),
        style = TnTTheme.typography.body1Medium,
        color = TnTTheme.colors.neutralColors.Neutral400,
    )
}

/**
 * 유효한 입력값인지 검사 (정수 또는 실수 형식 확인)
 * 형식: 정수 또는 실수
 */
private fun validateInput(input: String): Boolean {
    return input.isEmpty() || (input.toDoubleOrNull() != null && !input.startsWith("0"))
}

@Composable
private fun BodyInfoInput(
    height: String,
    weight: String,
    onHeightChange: (String) -> Unit,
    onWeightChange: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        TnTLabeledTextField(
            title = stringResource(R.string.user_height),
            value = height,
            placeholder = "0",
            isSingleLine = true,
            isRequired = true,
            showCounter = false,
            keyboardType = KeyboardType.Number,
            trailingComponent = {
                Unit(R.string.height_unit)
            },
            onValueChange = onHeightChange,
            modifier = Modifier.weight(1f),
        )
        TnTLabeledTextField(
            title = stringResource(R.string.user_weight),
            value = weight,
            placeholder = "00.0",
            isSingleLine = true,
            isRequired = true,
            showCounter = false,
            keyboardType = KeyboardType.Number,
            trailingComponent = {
                Unit(R.string.weight_unit)
            },
            onValueChange = onWeightChange,
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TraineeBasicInfoScreenPreview() {
    TnTTheme {
        TraineeBasicInfoScreen()
    }
}
