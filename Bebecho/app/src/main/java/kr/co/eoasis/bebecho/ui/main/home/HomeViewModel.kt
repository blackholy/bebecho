package kr.co.eoasis.bebecho.ui.main.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.co.eoasis.bebecho.ui.login.main.LoginMainUiState
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = false,
     val lastDay:String="",
     val strFhr:String="",
     val strToco:String="",
     val strKick:String="",
     val strMin:String="",
     val strMax:String="",
     val strAvg:String="",



)


@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

fun updateLastDay(lastDay: String) {
    _uiState.update {
        it.copy(lastDay = lastDay)
    }
}

fun updateStrFhr(strFhr: String) {
    _uiState.update {
        it.copy(strFhr = strFhr) 
    }
}

fun updateStrToco(strToco: String) {
    _uiState.update {
        it.copy(strToco = strToco)
    }
}

fun updateStrKick(strKick: String) {
    _uiState.update {
        it.copy(strKick = strKick)
    }
}

fun updateStrMin(strMin: String) {
    _uiState.update {
        it.copy(strMin = strMin)
    }
}

fun updateStrMax(strMax: String) {
    _uiState.update {
        it.copy(strMax = strMax)
    }
}

fun updateStrAvg(strAvg: String) {
    _uiState.update {
        it.copy(strAvg = strAvg)
    }
}



fun updateAllMeasurementData(data: HomeUiState) {
    _uiState.update { current ->
        current.copy(
            lastDay = data.lastDay,
            strFhr = data.strFhr,
            strToco = data.strToco,
            strKick = data.strKick,
            strMin = data.strMin,
            strMax = data.strMax,
            strAvg = data.strAvg
        )
    }
}


}