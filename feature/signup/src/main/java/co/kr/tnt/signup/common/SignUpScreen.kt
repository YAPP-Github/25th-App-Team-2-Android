package co.kr.tnt.signup.common

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.kr.tnt.signup.common.SignUpContract.SignUpSideEffect
import co.kr.tnt.signup.common.SignUpContract.SignUpUiEvent
import co.kr.tnt.signup.trainee.TraineeBasicInfoScreen
import co.kr.tnt.signup.trainee.TraineeNoteForTrainerScreen
import co.kr.tnt.signup.trainee.TraineePTPurposeScreen
import co.kr.tnt.signup.trainee.TraineeProfileCompleteScreen
import co.kr.tnt.signup.trainee.TraineeProfileSetupScreen
import co.kr.tnt.signup.trainer.TrainerProfileCompleteScreen
import co.kr.tnt.signup.trainer.TrainerProfileSetupScreen


@Composable
internal fun SignUpRoute(
    isTrainer: Boolean,
    navigateToPrevious: () -> Unit,
    navigateToConnect: () -> Unit,
    @Suppress("UnusedParameter")
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.setEvent(
            SignUpUiEvent.PageChange(
                if (isTrainer) SignUpPage.TrainerProfileSetup else SignUpPage.TraineeProfileSetup
            )
        )
    }

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                SignUpSideEffect.NavigateToConnect -> navigateToConnect()
            }
        }
    }

    SignUpScreen(
        modifier = Modifier.padding(20.dp),
        page = uiState.currentPage,
        onNextClick = nextClick@{
            if (uiState.currentPage == SignUpPage.TraineeProfileComplete || uiState.currentPage == SignUpPage.TrainerProfileComplete) {
                viewModel.setEvent(SignUpUiEvent.NavigateToConnect)
                return@nextClick
            }

            viewModel.setEvent(SignUpUiEvent.PageChange(SignUpPage.getNextPage(uiState.currentPage)))
        },
        onBackClick = backClick@{
            if (uiState.currentPage == SignUpPage.TraineeProfileSetup || uiState.currentPage == SignUpPage.TrainerProfileSetup) {
                navigateToPrevious()
                return@backClick
            }

            viewModel.setEvent(SignUpUiEvent.PageChange(SignUpPage.getPreviousPage(uiState.currentPage)))
        }
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    page: SignUpPage,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    when (page) {
        SignUpPage.TraineeProfileSetup -> TraineeProfileSetupScreen(
            onBackClick = onBackClick,
            onNextClick = onNextClick,
        )

        SignUpPage.TraineeBasicInfo -> TraineeBasicInfoScreen(
            onBackClick = onBackClick,
            onNextClick = onNextClick,
        )

        SignUpPage.TraineePTPurpose -> TraineePTPurposeScreen(
            onBackClick = onBackClick,
            onNextClick = onNextClick,
        )

        SignUpPage.TraineeNoteForTrainer -> TraineeNoteForTrainerScreen(
            onBackClick = onBackClick,
            onNextClick = onNextClick,
        )

        SignUpPage.TraineeProfileComplete -> TraineeProfileCompleteScreen(
            onBackClick = onBackClick,
            onNextClick = onNextClick,
        )

        SignUpPage.TrainerProfileSetup -> TrainerProfileSetupScreen(
            onBackClick = onBackClick,
            onNextClick = onNextClick,
        )

        SignUpPage.TrainerProfileComplete -> TrainerProfileCompleteScreen(
            onBackClick = onBackClick,
            onNextClick = onNextClick,
        )
    }
}

enum class SignUpPage {
    TraineeProfileSetup,
    TraineeBasicInfo,
    TraineePTPurpose,
    TraineeNoteForTrainer,
    TraineeProfileComplete,

    TrainerProfileSetup,
    TrainerProfileComplete;

    companion object {
        fun getPreviousPage(currentPage: SignUpPage): SignUpPage {
            return when (currentPage) {
                TraineeBasicInfo -> TraineeProfileSetup
                TraineePTPurpose -> TraineeBasicInfo
                TraineeNoteForTrainer -> TraineePTPurpose
                TraineeProfileComplete -> TraineeNoteForTrainer

                TrainerProfileComplete -> TrainerProfileSetup
                else -> throw IllegalStateException("No previous page defined for $currentPage")
            }
        }

        fun getNextPage(currentPage: SignUpPage): SignUpPage {
            return when (currentPage) {
                TraineeProfileSetup -> TraineeBasicInfo
                TraineeBasicInfo -> TraineePTPurpose
                TraineePTPurpose -> TraineeNoteForTrainer
                TraineeNoteForTrainer -> TraineeProfileComplete

                TrainerProfileSetup -> TrainerProfileComplete
                else -> throw IllegalStateException("No previous page defined for $currentPage")
            }
        }
    }
}
