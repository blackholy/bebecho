package kr.co.eoasis.bebecho.util.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme

@Composable
fun CommonMainTopBar(text: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
        }) {
            Icon(painter = painterResource(R.drawable.left_arrow), "help",
                tint = MaterialTheme.colorScheme.surfaceVariant)
        }
        Text(text = text, style = MaterialTheme.typography.titleLarge, fontSize = 24.sp)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
            IconButton(onClick = {
            }) {
                Icon(painter = painterResource(R.drawable.help), "help")
            }
            IconButton(onClick = {
            }) {
                Icon(painter = painterResource(R.drawable.bluetooth), "bluetooth")
            }
            IconButton(onClick = {
            }) {
                Icon(painter = painterResource(R.drawable.setting), "setting")
            }
        }
    }

}


@Composable
fun MainTopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(R.drawable.logo), "logo",
            modifier = Modifier.padding(12.dp),
            tint = MaterialTheme.colorScheme.primary)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
            IconButton(onClick = {
            }) {
                Icon(painter = painterResource(R.drawable.help), "help")
            }
            IconButton(onClick = {
            }) {
                Icon(painter = painterResource(R.drawable.bluetooth), "bluetooth")
            }
            IconButton(onClick = {
            }) {
                Icon(painter = painterResource(R.drawable.setting), "setting")
            }
        }
    }
}

@Composable
fun LoginTopBar(actions: LoginNavigationActions, title: String){
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
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
fun MainTopBarPreview(){
    BebechoTheme {
        Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
            CommonMainTopBar("이력")
        }
    }
}
