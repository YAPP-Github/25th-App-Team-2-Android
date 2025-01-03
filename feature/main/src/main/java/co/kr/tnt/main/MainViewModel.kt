package co.kr.tnt.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.tnt.domain.usecase.TnTUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tntUseCase: TnTUseCase,
) : ViewModel() {
    init {
        viewModelScope.launch {
            tntUseCase()
        }
    }
}
