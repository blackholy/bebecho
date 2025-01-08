package kr.co.eoasis.bebecho.ui.main.History

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.co.eoasis.bebecho.ui.login.search.SearchUiState
import javax.inject.Inject


data class HistoryUiState(
    val calendarMonth: Int = 12,
    val calendarFirstDay: Int = 31,
    val calendarLastDay: Int = 31,
    val isLoading: Boolean = false,
    val isShowCalendar: Boolean = false,
)

@HiltViewModel
class HistoryViewModel @Inject constructor() : ViewModel(){
    private val _uiState = MutableStateFlow(HistoryUiState())
    val uiState: StateFlow<HistoryUiState> = _uiState.asStateFlow()

    fun updateShowCalendar(boolean: Boolean){
        _uiState.update {
            it.copy(isShowCalendar = boolean)
        }
    }
}