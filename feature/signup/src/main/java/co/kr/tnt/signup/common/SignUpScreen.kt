package co.kr.tnt.signup.common

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
    @Suppress("UnusedParameter")
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    var page by rememberSaveable {
        mutableStateOf(
            if (isTrainer) SignUpPage.TrainerProfileSetup
            else SignUpPage.TraineeProfileSetup
        )
    }

    SignUpScreen(
        modifier = Modifier.padding(20.dp),
        page = page,
        onNextClick = nextClick@{
            if (page == SignUpPage.TraineeProfileComplete || page == SignUpPage.TrainerProfileComplete) {
                // TODO 다음 화면
                return@nextClick
            }

            page = SignUpPage.getNextPage(page)
        },
        onBackClick = backClick@{
            if (page == SignUpPage.TraineeProfileSetup || page == SignUpPage.TrainerProfileSetup) {
                navigateToPrevious()
                return@backClick
            }

            page = SignUpPage.getPreviousPage(page)
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
