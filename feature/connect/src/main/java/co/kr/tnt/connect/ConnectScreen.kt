package co.kr.tnt.connect

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun ConnectRoute(
    isTrainer: Boolean,
    navigateToPrevious: () -> Unit,
    navigateToHome: (Boolean) -> Unit,
    @Suppress("UnusedParameter")
    viewModel: ConnectViewModel = hiltViewModel(),
) {
    var page by rememberSaveable {
        mutableStateOf(
            if (isTrainer) ConnectPage.TrainerCodeGeneration
            else ConnectPage.TraineeConnectCode
        )
    }

    SignUpScreen(
        modifier = Modifier.padding(20.dp),
        page = page,
        onNextClick = nextClick@{
            if (page == ConnectPage.TraineeConnectComplete || page == ConnectPage.TrainerCheckTrainee) {
                navigateToHome(isTrainer)
                return@nextClick
            }

            page = ConnectPage.getNextPage(page)
        },
        onBackClick = backClick@{
            if (page == ConnectPage.TrainerCodeGeneration || page == ConnectPage.TraineeConnectCode) {
                navigateToPrevious()
                return@backClick
            }

            page = ConnectPage.getPreviousPage(page)
        },
        onSkipClick = skipClick@{
            navigateToHome(isTrainer)
        }
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    page: ConnectPage,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    onSkipClick: () -> Unit,
) {
    when (page) {
        ConnectPage.TrainerCodeGeneration -> CodeGenerationScreen(
            onNextClick = onNextClick,
        )

        ConnectPage.TrainerConnectComplete -> TrainerConnectCompleteScreen(
            onNextClick = onNextClick,
            onBackClick = onBackClick,
        )

        ConnectPage.TrainerCheckTrainee -> TraineeProfileCheckScreen(
            onNextClick = onNextClick,
        )

        ConnectPage.TraineeConnectCode -> TraineeConnectCodeScreen(
            onNextClick = onNextClick,
            onSkipClick = onSkipClick,
        )

        ConnectPage.TraineeConnectComplete -> TraineeConnectCompleteScreen(
            onNextClick = onNextClick,
            onBackClick = onBackClick,
        )

        ConnectPage.PTSessionForm -> PTSessionFormScreen(
            onNextClick = onNextClick,
        )
    }
}

enum class ConnectPage {
    TrainerCodeGeneration,
    TrainerConnectComplete,
    TrainerCheckTrainee,

    TraineeConnectCode,
    TraineeConnectComplete,
    PTSessionForm;

    companion object {
        fun getPreviousPage(currentPage: ConnectPage): ConnectPage {
            return when (currentPage) {
                TrainerConnectComplete -> TrainerCodeGeneration
                TrainerCheckTrainee -> TrainerConnectComplete

                TraineeConnectComplete -> TraineeConnectCode
                PTSessionForm -> TraineeConnectComplete
                else -> throw IllegalStateException("No previous page defined for $currentPage")
            }
        }

        fun getNextPage(currentPage: ConnectPage): ConnectPage {
            return when (currentPage) {
                TrainerCodeGeneration -> TrainerConnectComplete
                TrainerConnectComplete -> TrainerCheckTrainee

                TraineeConnectCode -> TraineeConnectComplete
                TraineeConnectComplete -> PTSessionForm
                else -> throw IllegalStateException("No previous page defined for $currentPage")
            }
        }
    }
}
