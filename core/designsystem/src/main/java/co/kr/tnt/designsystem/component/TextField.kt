package co.kr.tnt.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.designsystem.component.button.TnTTextButton
import co.kr.tnt.designsystem.component.button.model.ButtonSize
import co.kr.tnt.designsystem.theme.TnTTheme

@Composable
fun TnTTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
    isSingleLine: Boolean = false,
    showWarning: Boolean = false,
    warningMessage: String? = null,
    rightComponent: @Composable () -> Unit = {},
) {
    var isFocused by remember { mutableStateOf(false) }

    val lineColor = when {
        showWarning -> TnTTheme.colors.mainColors.Red500
        isFocused -> TnTTheme.colors.neutralColors.Neutral600
        else -> TnTTheme.colors.neutralColors.Neutral300
    }

    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = TnTTheme.typography.body1Medium,
                        color = TnTTheme.colors.neutralColors.Neutral400,
                    )
                }

                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = isSingleLine,
                    cursorBrush = SolidColor(TnTTheme.colors.neutralColors.Neutral900),
                    textStyle = TextStyle(color = TnTTheme.colors.neutralColors.Neutral600),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { focusState ->
                            isFocused = focusState.isFocused
                        }
                        .padding(vertical = 8.dp),
                    decorationBox = { innerTextField ->
                        innerTextField()
                    },
                )
            }

            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .align(Alignment.CenterVertically),
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 4.dp),
                ) {
                    rightComponent()
                }
            }
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = lineColor,
        )

        if (showWarning && !warningMessage.isNullOrEmpty()) {
            Text(
                text = warningMessage,
                style = TnTTheme.typography.body2Medium,
                color = TnTTheme.colors.mainColors.Red500,
                modifier = Modifier.padding(top = 6.dp),
            )
        }
    }
}

@Composable
fun TnTLabeledTextField(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
    maxLength: Int = 15,
    isSingleLine: Boolean = false,
    showWarning: Boolean = false,
    optional: Boolean = false,
    warningMessage: String? = null,
    rightComponent: @Composable () -> Unit = {},
) {
    val counterColor = when (showWarning) {
        true -> TnTTheme.colors.mainColors.Red500
        false -> TnTTheme.colors.neutralColors.Neutral400
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 7.dp, end = 4.dp)
                .fillMaxWidth(),
        ) {
            Row {
                Text(
                    text = title,
                    style = TnTTheme.typography.body1Bold,
                    color = TnTTheme.colors.neutralColors.Neutral900,
                )
                if (!optional) {
                    Text(
                        text = "*",
                        style = TnTTheme.typography.body1Bold,
                        color = TnTTheme.colors.mainColors.Red500,
                    )
                }
            }

            Text(
                text = "${value.length}/$maxLength",
                style = TnTTheme.typography.label1Medium,
                color = counterColor,
            )
        }

        TnTTextField(
            value = value,
            placeholder = placeholder,
            onValueChange = onValueChange,
            isSingleLine = isSingleLine,
            showWarning = showWarning,
            warningMessage = warningMessage,
            rightComponent = rightComponent,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true, heightDp = 100)
@Composable
fun TnTTextFieldPreview() {
    TnTTheme {
        val maxLength = 15
        var text by remember { mutableStateOf("") }
        var warningState by remember { mutableStateOf(false) }

        warningState = text.length > maxLength

        TnTTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = "내용을 입력해주세요",
            showWarning = warningState,
            isSingleLine = true,
            warningMessage = "${maxLength}자 이내로 입력해주세요",
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            rightComponent = {
                TnTTextButton(
                    text = "텍스트",
                    size = ButtonSize.Small,
                    onClick = { },
                )
            },
        )
    }
}

@Preview(showBackground = true, heightDp = 120)
@Composable
fun TnTLabeledTextFieldPreview() {
    TnTTheme {
        val maxLength = 15
        var text by remember { mutableStateOf("") }
        var warningState by remember { mutableStateOf(false) }

        warningState = text.length > maxLength

        TnTLabeledTextField(
            title = "제목",
            value = text,
            onValueChange = { text = it },
            placeholder = "내용을 입력해주세요",
            maxLength = maxLength,
            showWarning = warningState,
            isSingleLine = true,
            optional = false,
            warningMessage = "${maxLength}자 이내로 입력해주세요",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            rightComponent = {
                TnTTextButton(
                    text = "텍스트",
                    size = ButtonSize.Small,
                    onClick = { },
                )
            },
        )
    }
}
