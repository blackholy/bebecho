package kr.co.eoasis.bebecho.ui.login.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kr.co.eoasis.bebecho.ui.login.bluetooth.BluetoothUiState
import javax.inject.Inject

data class SearchUiState(
    val isLoading: Boolean = false,
    val time : Long = 0,
    val beats: List<Int> = listOf(),
)

@HiltViewModel
class SearchViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()
}