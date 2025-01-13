package co.kr.tnt.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.core.designsystem.R
import co.kr.tnt.designsystem.theme.TnTTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TnTTopBar(
    title: String = "",
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    trailingComponent: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = TnTTheme.typography.h4,
                color = TnTTheme.colors.neutralColors.Neutral900,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        actions = trailingComponent,
        navigationIcon = {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.size(32.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = "Go back",
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun TnTTopBarOnlyBackButtonPreview() {
    TnTTheme {
        TnTTopBar(
            modifier = Modifier.fillMaxWidth(),
            onBackClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TnTTopBarBackButtonWithTitlePreview() {
    TnTTheme {
        TnTTopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "제목",
            onBackClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TnTTopBarWithAllComponentsPreview() {
    TnTTheme {
        TnTTopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "제목",
            onBackClick = { },
            trailingComponent = {
                Row(
                    horizontalArrangement = Arrangement.End,
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = TnTTheme.colors.neutralColors.Neutral400,
                        ),
                        elevation = ButtonDefaults.buttonElevation(0.dp),
                        contentPadding = PaddingValues(0.dp),
                    ) {
                        Text(
                            text = "건너뛰기",
                            style = TnTTheme.typography.body2Medium,
                        )
                    }
                }
            },
        )
    }
}
