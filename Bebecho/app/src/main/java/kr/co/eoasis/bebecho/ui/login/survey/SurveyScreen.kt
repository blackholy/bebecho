package kr.co.eoasis.bebecho.ui.login.survey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.util.component.ButtonFont
import kr.co.eoasis.bebecho.util.component.CommonButton
import kr.co.eoasis.bebecho.util.component.CommonDropdown
import kr.co.eoasis.bebecho.util.component.CommonOutLineButton
import kr.co.eoasis.bebecho.util.component.CommonTextField
import kr.co.eoasis.bebecho.util.component.CommonTextFieldMemo
import kr.co.eoasis.bebecho.util.component.CommonTextFieldOnlyBirth
import kr.co.eoasis.bebecho.util.component.CommonToggleButton
import kr.co.eoasis.bebecho.util.component.LoginTopBar

@Composable
fun SurveyScreen(
    actions: LoginNavigationActions,
    viewModel: SurveyViewModel = hiltViewModel()
   ){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val countListState = remember {
        mutableStateListOf("첫 번째","두 번째","세 번째")
    }
    val cycleListState = remember {
        mutableStateListOf("1주일 마다","2주일 마다","3주일 마다")
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)
    ){
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            LoginTopBar(actions, "설문")
            Spacer(modifier = Modifier.height(28.dp))
            Text(stringResource(R.string.login_survey_label_single_baby),
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 4.dp)){
                    CommonToggleButton("예", uiState.isSingleBaby ?: false, ButtonFont.WANTED, true, MaterialTheme.colorScheme.secondary) {
                        viewModel.updateSingleBaby(true)
                    }
                }
                Box(modifier = Modifier.padding(start = 4.dp)){
                    CommonToggleButton("아니요", !(uiState.isSingleBaby ?: true), ButtonFont.WANTED, true, MaterialTheme.colorScheme.secondary) {
                        viewModel.updateSingleBaby(false)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                stringResource(R.string.login_survey_label_due_date),
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                Box(){
                    CommonTextFieldOnlyBirth(uiState.dueDate, "년-월-일 순으로 입력해주세요.",MaterialTheme.colorScheme.surfaceVariant){
                        viewModel.updateDueDate(it)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "3. 몇 번째 임신인가요?",
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                Box(modifier = Modifier
                    .fillMaxWidth()){

                    CommonDropdown(if(uiState.numberOfPregnancies == 0){"선택해주세요."} else {countListState[uiState.numberOfPregnancies-1]},
                        uiState.isPregnanciesDropdownExpand,
                        {
                            viewModel.updateIsPregnanciesDropdownExpand(false)
                        },
                        countListState
                        ,
                         {
                             viewModel.updateNumberOfPregnancies(it+1) },
                        ){
                        viewModel.updateIsPregnanciesDropdownExpand(true)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("4. 몇 번째 출산인가요?",
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                Box(modifier = Modifier
                    .fillMaxWidth()){
                    CommonDropdown(if(uiState.numberOfBirth == 0){"선택해주세요."} else {countListState[uiState.numberOfBirth-1]},
                        uiState.isBirthDropdownExpand,
                        {
                            viewModel.updateIsBirthDropdownExpand(false)
                        },
                        countListState,
                        {
                            viewModel.updateNumberOfBirth(it+1) },
                    ){
                        viewModel.updateIsBirthDropdownExpand(true)
                    }
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Text("5. 고혈압이 있습니까?",
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 4.dp)){
                    CommonToggleButton("예", uiState.isHighBloodPressure ?: false, ButtonFont.WANTED, true, MaterialTheme.colorScheme.secondary) {
                        viewModel.updateHighBloodPressure(true)

                    }
                }
                Box(modifier = Modifier.padding(start = 4.dp)){
                    CommonToggleButton("아니요", !(uiState.isHighBloodPressure ?: true), ButtonFont.WANTED, true, MaterialTheme.colorScheme.secondary) {
                        viewModel.updateHighBloodPressure(false)

                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text("6. 당뇨가 있습니까?",
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 4.dp)){
                    CommonToggleButton("예", uiState.isDiabetes ?: false, ButtonFont.WANTED, true, MaterialTheme.colorScheme.secondary) {
                        viewModel.updateDiabetes(true)

                    }
                }
                Box(modifier = Modifier.padding(start = 4.dp)){
                    CommonToggleButton("아니요", !(uiState.isDiabetes ?: true), ButtonFont.WANTED, true, MaterialTheme.colorScheme.secondary) {
                        viewModel.updateDiabetes(false)

                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text("7. 측정주기 설정해주세요",
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                CommonDropdown(if(uiState.measurementCycle == 0){"주 단위로 선택해주세요."} else {countListState[uiState.measurementCycle-1]},
                    uiState.isCycleDropdownExpand,
                    {
                        viewModel.updateIsCycleDropdownExpand(false)
                    },
                    cycleListState,
                    {
                        viewModel.updateMeasurementCycle(it+1) },
                ){
                    viewModel.updateIsCycleDropdownExpand(true)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text("8. 기기 일련번호 입력해주세요",
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                CommonTextField(uiState.deviceId, "일련번호를 입력해주세요.", MaterialTheme.colorScheme.surfaceVariant, false) {
                    viewModel.updateDeviceId(it)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("9. 추가로 기재하고 싶은 사항이 정보가 있다면 입력해주세요.",
                modifier = Modifier
                    .padding(horizontal = 26.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.height(180.dp).padding(horizontal = 24.dp)){
                CommonTextFieldMemo (uiState.memo, "내용을 입력해주세요.", MaterialTheme.colorScheme.surfaceVariant, false) {
                    viewModel.updateMemo(it)
                }
            }
            Spacer(modifier = Modifier.height(60.dp))

            Row(modifier = Modifier.padding(horizontal = 24.dp)){
                Box(modifier = Modifier.fillMaxWidth(0.5f).padding(end = 4.dp)){
                    CommonOutLineButton ("취소", ButtonFont.WANTED,true) {
                        actions.popBackStack()
                    }
                }
                Box(modifier = Modifier.fillMaxWidth().padding(start = 4.dp)){
                    CommonButton("저장", ButtonFont.WANTED, surveyIsEnabled(viewModel),
                        fontSize = 18.sp) {
                        actions.navigateToBluetooth()
                    }
                }
            }
            Spacer(modifier = Modifier.height(60.dp))

        }

    }
}

fun surveyIsEnabled(viewModel: SurveyViewModel) :Boolean{
    val uiState = viewModel.uiState.value
    return uiState.isSingleBaby != null &&
            uiState.isDiabetes != null &&
            uiState.isHighBloodPressure != null &&
            uiState.dueDate.text.isNotEmpty() &&
            uiState.deviceId.isNotEmpty() &&
            uiState.measurementCycle != 0 &&
            uiState.numberOfBirth != 0 &&
            uiState.numberOfPregnancies != 0
}

@Preview
@Composable
fun PreviewScreenSizes(){
    BebechoTheme {
        Box(modifier = Modifier.height(1200.dp)){
            SurveyScreen(LoginNavigationActions(rememberNavController()))
        }
    }
}