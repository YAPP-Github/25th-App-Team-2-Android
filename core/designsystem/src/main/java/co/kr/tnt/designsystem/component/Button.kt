package co.kr.tnt.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.core.designsystem.R
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.designsystem.util.ButtonSize
import co.kr.tnt.designsystem.util.ButtonType
import co.kr.tnt.designsystem.util.IconPosition
import co.kr.tnt.designsystem.util.getButtonConfig

@Composable
fun TnTTextButton(
    size: ButtonSize = ButtonSize.Medium,
    type: ButtonType = ButtonType.Primary,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val config = getButtonConfig(size, type, enabled)

    Button(
        onClick = onClick,
        enabled = enabled,
        colors = config.colors,
        shape = RoundedCornerShape(config.cornerRadius),
        border = BorderStroke(width = config.stroke, color = config.borderColor),
        contentPadding = config.contentPadding,
        modifier = modifier
            .height(config.height)
            .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
    ) {
        Text(
            text = text,
            style = config.textStyle,
        )
    }
}

@Composable
fun TnTIconButton(
    size: ButtonSize = ButtonSize.Medium,
    type: ButtonType = ButtonType.GrayOutline,
    iconPosition: IconPosition,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val config = getButtonConfig(size, type, enabled)

    Button(
        onClick = onClick,
        enabled = enabled,
        colors = config.colors,
        shape = RoundedCornerShape(config.cornerRadius),
        border = BorderStroke(width = config.stroke, color = config.borderColor),
        contentPadding = config.contentPadding,
        modifier = modifier
            .height(config.height)
            .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
    ) {
        when (iconPosition) {
            is IconPosition.Leading -> {
                iconPosition.icon()
                Text(
                    text = text,
                    style = config.textStyle,
                    modifier = Modifier.padding(start = 4.dp),
                )
            }

            is IconPosition.Trailing -> {
                Text(
                    text = text,
                    style = config.textStyle,
                    modifier = Modifier.padding(end = 4.dp),
                )
                iconPosition.icon()
            }
        }
    }
}

@Composable
fun TnTBottomButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = TnTTheme.colors.neutralColors.Neutral900,
            contentColor = TnTTheme.colors.neutralColors.Neutral50,
            disabledContainerColor = TnTTheme.colors.neutralColors.Neutral300,
            disabledContentColor = TnTTheme.colors.neutralColors.Neutral50,
        ),
        contentPadding = PaddingValues(top = 20.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                style = TnTTheme.typography.h4,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 150, heightDp = 100)
@Composable
fun TnTTnTTextButtonPreview() {
    TnTTheme {
        TnTTextButton(
            size = ButtonSize.Medium,
            type = ButtonType.Primary,
            text = "텍스트",
            enabled = true,
            onClick = { },
            modifier = Modifier.wrapContentSize(),
        )
    }
}

@Preview(showBackground = true, widthDp = 150, heightDp = 100)
@Composable
fun TnTOutLinedButtonPreview() {
    TnTTheme {
        TnTTextButton(
            size = ButtonSize.Medium,
            type = ButtonType.RedOutline,
            text = "텍스트",
            enabled = true,
            onClick = { },
            modifier = Modifier.wrapContentSize(),
        )
    }
}

@Preview(showBackground = true, widthDp = 150, heightDp = 100)
@Composable
fun TnTIconButtonPreview() {
    TnTTheme {
        TnTIconButton(
            size = ButtonSize.Medium,
            type = ButtonType.GrayOutline,
            iconPosition = IconPosition.Trailing {
                Icon(
                    painter = painterResource(R.drawable.ic_delete),
                    contentDescription = null,
                )
            },
            text = "텍스트",
            enabled = true,
            onClick = { },
            modifier = Modifier.wrapContentSize(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TnTBottomButtonPreview() {
    TnTTheme {
        TnTBottomButton(
            text = "text",
            enabled = true,
            onClick = { },
        )
    }
}
