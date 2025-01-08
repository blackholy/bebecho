package kr.co.eoasis.bebecho.ui.login.bluetooth

import android.bluetooth.BluetoothDevice
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kr.co.eoasis.bebecho.ui.login.survey.SurveyUiState
import javax.inject.Inject

data class BluetoothUiState(
    val isLoading: Boolean = false,
    val bluetoothDeviceList: List<BluetoothDevice> = listOf()
)

@HiltViewModel
class BluetoothViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(BluetoothUiState())
    val uiState: StateFlow<BluetoothUiState> = _uiState.asStateFlow()
}