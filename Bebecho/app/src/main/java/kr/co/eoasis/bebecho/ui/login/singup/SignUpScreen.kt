package kr.co.eoasis.bebecho.ui.login.singup

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.util.component.ButtonFont
import kr.co.eoasis.bebecho.util.component.CommonButton
import kr.co.eoasis.bebecho.util.component.CommonTextField
import kr.co.eoasis.bebecho.util.component.CommonTextFieldOnlyBirth
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SignUpScreen(
    actions: LoginNavigationActions,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton( onClick = {
                   // actions.popBackStack()
                    Log.d("test","testpostback")
                    actions.navigateToSearch()

                }) {
                    Icon(painter = painterResource(R.drawable.left_arrow), "logo")
                }
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = stringResource(R.string.login_sign_up_title_sign_up),
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Spacer(modifier = Modifier.height(28.dp))
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(R.string.login_sign_up_label_name),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
                Box() {
                    CommonTextField(
                        value = uiState.name,
                        stringResource(R.string.login_sign_up_placeholder_name),
                        MaterialTheme.colorScheme.surfaceVariant,
                        false
                    ) {
                        viewModel.updateName(name = it)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(R.string.login_sing_up_label_id),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
                Box() {
                    CommonTextField(
                        value = uiState.id,
                        stringResource(R.string.login_sign_up_placeholder_id),
                        MaterialTheme.colorScheme.surfaceVariant,
                        false
                    ) {
                        viewModel.updateId(id = it)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(R.string.login_sign_up_label_password),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
                Box() {
                    CommonTextField(
                        value = uiState.password,
                        stringResource(R.string.login_sign_up_placeholder_password),
                        MaterialTheme.colorScheme.surfaceVariant,
                        true
                    ) {
                        viewModel.updatePassword(password = it)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(R.string.login_sign_up_label_birth),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
                Box() {
                    CommonTextFieldOnlyBirth (
                        value = uiState.birth,
                        stringResource(R.string.login_sign_up_placeholder_birth),
                        MaterialTheme.colorScheme.surfaceVariant,
                    ) {
                        viewModel.updateBirth(birth = it)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(R.string.login_sign_up_label_email),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
                Box() {
                    CommonTextField(
                        value = uiState.email,
                        stringResource(R.string.login_sign_up_placeholder_email),
                        MaterialTheme.colorScheme.surfaceVariant,
                        false
                    ) {
                        viewModel.updateEmail(email = it)
                    }
                }
            }

            Column(modifier = Modifier.fillMaxHeight(), Arrangement.Bottom) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 65.dp),
                ) {
                    CommonButton(
                        text = stringResource(R.string.login_sign_up_button_register),
                        font = ButtonFont.WANTED,
                        enabled = signUpIsEnabled(uiState=uiState),
                        fontSize = 16.sp
                    ) {
                        actions.navigateToSurvey()
                    }
                }
            }
        }
    }
}

private fun signUpIsEnabled(uiState: SignUpUiState): Boolean {
    return uiState.name.isNotEmpty() && uiState.id.isNotEmpty() && uiState.password.isNotEmpty() && uiState.birth.text.isNotEmpty()
}

@Preview
@Composable
fun SignUpScreenPreview() {
    val controller = rememberNavController()
    BebechoTheme {
        SignUpScreen(LoginNavigationActions(controller))
    }
}