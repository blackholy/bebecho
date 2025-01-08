package kr.co.eoasis.bebecho.ui.login.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.navigation.BebechoNavigationActions
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.util.component.ButtonFont
import kr.co.eoasis.bebecho.util.component.CommonButton
import kr.co.eoasis.bebecho.util.component.ColorOutLineButton
import kr.co.eoasis.bebecho.util.component.LoginTopBar


@SuppressLint("DefaultLocale")
@Composable
fun SearchScreen(
    actions: LoginNavigationActions,
    mainActions: BebechoNavigationActions,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            LoginTopBar(actions, "탐색")
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(top = 30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${String.format("%02d", uiState.time / 60)}:${
                            String.format(
                                "%02d",
                                uiState.time % 60
                            )
                        }",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(R.drawable.time), "time",
                        tint = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp), // 열 간 간격
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(15) { index -> // 데이터 항목 개수
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.surfaceContainerLow,
                                shape = RoundedCornerShape(10.dp)
                            ).border(1.dp, color = MaterialTheme.colorScheme.primary, shape =
                            RoundedCornerShape(10.dp)
                            )
                            , contentAlignment = Alignment.Center,){
                            Text(
                                text = "Item $index",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .padding(vertical = 9.dp)

                            )
                        }
                    }
                }
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(top = 30.dp)){
                    Box(modifier = Modifier.fillMaxWidth(0.6f)){
                        CommonButton("심박 찾기", ButtonFont.WANTED, true,
                            16.sp){
                        }
                    }
                    Spacer(modifier= Modifier.width(8.dp))
                    Box(modifier = Modifier.fillMaxWidth()){
                        ColorOutLineButton ("TOCO 찾기", ButtonFont.WANTED, true,
                            MaterialTheme.colorScheme.primary, 16.sp){
                        }
                    }
                }

                Text(text = "· 연속된 심박정보가 5개 이상이 될때까지 이동하면서 찾아주세요 \n· 찾은 경우 벨트를 장착하세요 (허용범위 : 40 ~ 200)",
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier.padding(horizontal = 20.dp).padding(top = 20.dp)
                    )

                Box(modifier = Modifier.padding(horizontal = 24.dp).padding(top = 40.dp)){
                    CommonButton("Ready", ButtonFont.POPPINS, true, 16.sp) {
                        mainActions.navigateToMain()
                    }
                }

            }
        }

    }

}

@Preview
@Composable
fun SearchScreenPreview() {
    BebechoTheme {
        SearchScreen(LoginNavigationActions(rememberNavController()),BebechoNavigationActions(
            rememberNavController()
        ))
    }
}