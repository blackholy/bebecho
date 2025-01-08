package kr.co.eoasis.bebecho.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kr.co.eoasis.bebecho.BebechoNavGraph
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme

@Preview
@Composable
fun BebechoApp(){
    BebechoTheme {
        BebechoNavGraph()
    }
}