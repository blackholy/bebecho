package kr.co.eoasis.bebecho.ui.login.survey

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.co.eoasis.bebecho.ui.login.singup.SignUpUiState
import javax.inject.Inject


data class SurveyUiState(
    val isLoading: Boolean = false,
    val isSingleBaby: Boolean? = null,
    val dueDate: TextFieldValue = TextFieldValue(""),
    val numberOfPregnancies:Int = 0,
    val isPregnanciesDropdownExpand : Boolean = false,
    val numberOfBirth : Int = 0,
    val isBirthDropdownExpand : Boolean = false,
    val isHighBloodPressure : Boolean? = null,
    val isDiabetes : Boolean? = null,
    val measurementCycle: Int =0,
    val isCycleDropdownExpand : Boolean = false,
    val deviceId: String = "",
    val memo:String = ""
)

@HiltViewModel
class SurveyViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SurveyUiState())
    val uiState: StateFlow<SurveyUiState> = _uiState.asStateFlow()

    fun updateSingleBaby(isSingleBaby: Boolean) {
        _uiState.update {
            it.copy(isSingleBaby = isSingleBaby)
        }
    }
    fun updateDueDate(dueDate: TextFieldValue) {
        _uiState.update {
            it.copy(dueDate = dueDate)
        }
    }
    fun updateNumberOfPregnancies(numberOfPregnancies: Int) {
        _uiState.update {
            it.copy(numberOfPregnancies = numberOfPregnancies)
        }
    }
    fun updateNumberOfBirth(numberOfBirth: Int) {
        _uiState.update {
            it.copy(numberOfBirth = numberOfBirth)
        }
    }
    fun updateIsPregnanciesDropdownExpand(isPregnanciesDropdownExpand: Boolean) {
        _uiState.update {
            it.copy(isPregnanciesDropdownExpand = isPregnanciesDropdownExpand)
        }
    }
    fun updateIsBirthDropdownExpand(isBirthDropdownExpand: Boolean) {
        _uiState.update {
            it.copy(isBirthDropdownExpand = isBirthDropdownExpand)
        }
    }
    fun updateHighBloodPressure(isHighBloodPressure: Boolean) {
        _uiState.update {
            it.copy(isHighBloodPressure = isHighBloodPressure)
        }
    }
    fun updateDiabetes(isDiabetes: Boolean) {
        _uiState.update {
            it.copy(isDiabetes = isDiabetes)
        }
    }
    fun updateMeasurementCycle(measurementCycle: Int) {
        _uiState.update {
            it.copy(measurementCycle = measurementCycle)
        }
    }
    fun updateIsCycleDropdownExpand(isCycleDropdownExpand: Boolean) {
        _uiState.update {
            it.copy(isCycleDropdownExpand = isCycleDropdownExpand)
        }
    }
    fun updateDeviceId(deviceId: String) {
        _uiState.update {
            it.copy(deviceId = deviceId)
        }
    }
    fun updateMemo(memo: String) {
        _uiState.update {
            it.copy(memo = memo)
        }
    }

}