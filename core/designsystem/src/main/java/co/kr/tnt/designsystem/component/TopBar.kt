package co.kr.tnt.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
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
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    trailingComponent: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .fillMaxWidth()
            // 디자인상으로는 16dp가 맞으나, 라이브러리에서 기본적으로
            // horizontal padding 으로 4dp 를 부여하고 있음.
            // 이에 따라 16dp - 4dp 계산값으로 적용
            // see : TopAppBarLayout
            .padding(start = 12.dp, top = 20.dp, end = 12.dp),
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
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = TnTTheme.colors.commonColors.Common0,
        ),
        windowInsets = windowInsets,
        expandedHeight = 60.dp,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TnTTopBarNoBackButton(
    title: String = "",
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    trailingComponent: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .fillMaxWidth()
            // 디자인상으로는 16dp가 맞으나, 라이브러리에서 기본적으로
            // horizontal padding 으로 4dp 를 부여하고 있음.
            // 이에 따라 16dp - 4dp 계산값으로 적용
            // see : TopAppBarLayout
            .padding(start = 12.dp, top = 20.dp, end = 12.dp),
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
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = TnTTheme.colors.commonColors.Common0,
        ),
        windowInsets = windowInsets,
        expandedHeight = 60.dp,
    )
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
