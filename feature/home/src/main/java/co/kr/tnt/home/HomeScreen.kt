package co.kr.tnt.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.feature.home.R

@Composable
@Suppress("UnusedParameter")
internal fun HomeRoute(
    isTrainer: Boolean,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(isTrainer = isTrainer)
}

@Composable
fun HomeScreen(isTrainer: Boolean) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (isTrainer) {
                TrainerHomeContent()
            } else {
                TraineeHomeContent()
            }
        }
    }
}

@Composable
fun TrainerHomeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.img_trainer_home_3x),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
    }
}

@Composable
fun TraineeHomeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.img_trainer_home_3x),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    TnTTheme {
        HomeScreen(
            isTrainer = true
        )
    }
}

