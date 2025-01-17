package co.kr.tnt.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : UiState, E : UiEvent, A : UiSideEffect>(
    initialState: S,
) : ViewModel() {
    private val _uiState = MutableStateFlow<S>(initialState)
    val uiState = _uiState.asStateFlow()

    private val _effect: Channel<A> = Channel()
    val effect = _effect.receiveAsFlow()

    protected val currentState: S
        get() = _uiState.value

    fun setEvent(event: E) {
        dispatchEvent(event)
    }

    private fun dispatchEvent(event: E) = viewModelScope.launch {
        handleEvent(event)
    }

    protected abstract suspend fun handleEvent(event: E)

    protected fun updateState(reduce: S.() -> S) {
        val state = currentState.reduce()
        _uiState.value = state
    }

    protected fun sendEffect(vararg builder: A) {
        for (effectValue in builder) {
            viewModelScope.launch { _effect.send(effectValue) }
        }
    }
}
