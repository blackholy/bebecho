package kr.co.eoasis.bebecho.ui.login.bluetooth

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.login.survey.SurveyViewModel
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.util.component.ConnectButton

@Composable
fun BluetoothScreen(
    actions: LoginNavigationActions,
    viewModel: BluetoothViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(Modifier.fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)
    ){
        Column(modifier = Modifier){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    actions.popBackStack()
                }) {
                    Icon(painter = painterResource(R.drawable.left_arrow), "logo")
                }
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "블루투스 연결",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Text("연결 가능 기기", modifier = Modifier.padding(start = 39.dp),
                style = MaterialTheme.typography.titleSmall,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 17.dp)
                .padding(horizontal = 24.dp)
                .height(1.dp)
                .background(color = MaterialTheme.colorScheme.surface)
                ,

            )
            if (ActivityCompat.checkSelfPermission(
                    LocalContext.current,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }

            LazyColumn {

                items(uiState.bluetoothDeviceList){
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Text(text =  it.name.toString(),
                            style = MaterialTheme.typography.titleSmall,
                            fontSize = 16.sp,)
                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End){
                            ConnectButton(){
                            }
                        }
                    }

                }
                items(listOf("Dummy1","Dummy2")){
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 40.dp, vertical = 17.dp)){
                        Text(text =  it.toString(),
                            style = MaterialTheme.typography.titleSmall,
                            fontSize = 16.sp,)
                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End){
                            ConnectButton(){
                                actions.navigateToSearch()
                            }
                        }
                    }

                }
            }


        }
    }


}

@Preview
@Composable
fun BluetoothScreenPreview(){

    BebechoTheme {
        BluetoothScreen(LoginNavigationActions(rememberNavController()))
    }
}