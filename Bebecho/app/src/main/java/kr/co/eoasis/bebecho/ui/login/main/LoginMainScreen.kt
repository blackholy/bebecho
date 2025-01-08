package kr.co.eoasis.bebecho.ui.login.main


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.util.component.redCommonButton

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun LoginMainScreen(
    viewModel: LoginMainViewModel = hiltViewModel(),
    navigationAction: LoginNavigationActions,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column() {
            Row(modifier = Modifier.padding(horizontal = 30.dp, vertical = 17.dp)) {
                Image(painter = painterResource(R.drawable.logo), "logo")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 110.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.login_main_title_login),
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 40.dp)
            ) {
                CommonTextField(
                    uiState.id,
                    stringResource(R.string.login_main_placeholder_enter_id), MaterialTheme.colorScheme.primary, false,
                    viewModel::updateId
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 12.dp)
            ) {
                CommonTextField(
                    uiState.password,
                    stringResource(R.string.login_main_placeholder_enter_password), MaterialTheme.colorScheme.primary, true,
                    viewModel::updatePassword
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 84.dp),
                Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                ) {
                    redCommonButton(
                        text = stringResource(R.string.login_main_button_login),
                        ButtonFont.POPPINS,
                        enabled = loginMainIsEnable(viewModel),
                        fontSize = 16.sp
                    ) {
                        viewModel.saveUserData()
                        navigationAction.navigateToMain()
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = {
                            Log.d("test","testpostback2333")
                            navigationAction.navigateToSignUp()
                          //  navigationAction.navigateToSearch()
                        },
                        modifier = Modifier.defaultMinSize(1.dp, 1.dp),
                        contentPadding = PaddingValues(
                            top = 12.dp,
                            bottom = 12.dp,
                            start = 12.dp,
                            end = 10.dp
                        )
                    ) {
                        Text(
                            stringResource(R.string.login_main_text_button_sign_up),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .height(12.dp)
                            .background(color = MaterialTheme.colorScheme.onSurfaceVariant)
                    )
                    TextButton(
                        onClick = {},
                        modifier = Modifier.defaultMinSize(1.dp, 1.dp),
                        contentPadding = PaddingValues(
                            top = 12.dp,
                            bottom = 12.dp,
                            start = 10.dp,
                            end = 12.dp
                        )
                    ) {
                        Text(
                            stringResource(R.string.login_main_text_button_find_password),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                }

            }

        }
    }
}

fun loginMainIsEnable(viewModel: LoginMainViewModel): Boolean {
    return viewModel.uiState.value.id.isNotEmpty() && viewModel.uiState.value.password.isNotEmpty()
}


@Preview
@Composable
fun LoginScreenPreview() {
    BebechoTheme {
        val navController = rememberNavController()
        LoginMainScreen(navigationAction = LoginNavigationActions(navController))
    }
}