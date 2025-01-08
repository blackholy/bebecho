package kr.co.eoasis.bebecho.ui.main.post

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.flow.observeOn
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.login.LoginNavigationActions
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.ui.theme.Gray1
import kr.co.eoasis.bebecho.ui.theme.Gray2
import kr.co.eoasis.bebecho.util.component.CommonMainTopBar
import kr.co.eoasis.bebecho.util.component.SearchTextField



@Composable
fun PostScreen(
    viewModel: PostViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController(),
    navActions: PostNavigationActions = remember(navController) {
        PostNavigationActions(navController)
    }
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        CommonMainTopBar("게시글")
        Spacer(modifier = Modifier.height(24.dp))
        TabBar(uiState, viewModel,navActions)
        NavHost(
            navController = navController,
            startDestination = PostDestination.INQUIRY_ROUTE
        ) {
            composable(PostDestination.NOTIFY_ROUTE) {
                NotifyScreen(uiState, viewModel,navActions)
            }
            composable(PostDestination.INQUIRY_ROUTE) {
                InquiryScreen(uiState,viewModel)
            }
            composable(PostDestination.QUESTION_ROUTE) {
                QuestionScreen(uiState,viewModel,navActions)
            }
            composable(route = PostDestination.NOTIFY_SEE_MORE_ROUTE,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })) {
                NotifySeeMore(viewModel)
            }
        }
    }
}


@Composable
fun NotifySeeMore(viewModel :PostViewModel){
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        Spacer(modifier = Modifier.padding(top = 20.dp).fillMaxWidth().height(6.dp).background(color = Gray1))
    }

}

@Composable
fun NotifyScreen(uiState: PostUiState, viewModel: PostViewModel, actions: PostNavigationActions) {

    LazyColumn(
    ) {
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 27.dp)
            ) {
                SearchTextField(uiState.searchText, "검색어를 입력해주세요.") {
                    viewModel.updateSearchText(it)
                }
            }
        }
        item {
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Row(
                    modifier = Modifier.padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${uiState.startDate} ~ ${uiState.endDate}",
                        style = MaterialTheme.typography.titleSmall,
                        textDecoration = TextDecoration.Underline,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Row(
                        horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "최신순",
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Icon(
                            painter = painterResource(R.drawable.bottom_arrow), "arrow",
                            tint = MaterialTheme.colorScheme.surfaceVariant
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(color = Gray2, shape = RoundedCornerShape(10.dp)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp),
                    ) {
                        Text(
                            "게시일", modifier = Modifier.padding(vertical = 10.dp),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(
                        modifier = Modifier.weight(0.8f),
                    ) {
                        Text(
                            "제목", modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                }
            }
        }
        items(uiState.notifyPostList) {
            data ->
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
                .clickable {
                actions.navigateToNotifySeeMore(data.id.toString())
            }) {
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Row(modifier = Modifier.width(90.dp).padding(start = 20.dp)){
                        Text(
                            data.date,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 10.sp
                        )
                    }
                    Text(
                        data.title,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
                Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(color=MaterialTheme.colorScheme.surface,
                    ))
            }
        }
    }
}


@Composable
fun InquiryScreen(uiState: PostUiState, viewModel: PostViewModel) {
    LazyColumn(
    ) {
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 27.dp)
            ) {
                SearchTextField(uiState.searchText, "검색어를 입력해주세요.") {
                    viewModel.updateSearchText(it)
                }
            }
        }
        item {
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Row(
                    modifier = Modifier.padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${uiState.startDate} ~ ${uiState.endDate}",
                        style = MaterialTheme.typography.titleSmall,
                        textDecoration = TextDecoration.Underline,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Row(
                        horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "최신순",
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Icon(
                            painter = painterResource(R.drawable.bottom_arrow), "arrow",
                            tint = MaterialTheme.colorScheme.surfaceVariant
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(color = Gray2, shape = RoundedCornerShape(10.dp)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp),
                    ) {
                        Text(
                            "게시일", modifier = Modifier.padding(vertical = 10.dp),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(
                        modifier = Modifier.weight(0.8f),
                    ) {
                        Text(
                            "제목", modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Row(
                        modifier = Modifier,
                    ) {
                        Text(
                            "답변", modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                }
            }
        }
        items(uiState.notifyPostList) {
                data ->
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Row(modifier = Modifier.width(90.dp).padding(start = 20.dp)){
                        Text(
                            data.date,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 10.sp
                        )
                    }
                    Text(
                        data.title,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
                Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(color=MaterialTheme.colorScheme.surface,
                ))
            }
        }
    }

}

@Composable
fun QuestionScreen(uiState: PostUiState,viewModel: PostViewModel,navActions: PostNavigationActions) {
    LazyColumn(
    ) {
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 27.dp)
            ) {
                SearchTextField(uiState.searchText, "검색어를 입력해주세요.") {
                    viewModel.updateSearchText(it)
                }
            }
        }
        item{
            Spacer(modifier = Modifier.height(8.dp))
            QuestionItem("가입 / 탈퇴") {

            }
        }

        item{
            QuestionItem("기기") { }
        }

        item{
            QuestionItem("사용 방법") { }
        }

        item{
            QuestionItem("기타 서비스") { }
        }
        item {
            QuestionItem("이벤트 / 기타") { }
        }
    }

}
@Composable
fun QuestionItem(text: String, onClick : () -> Unit){
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).clickable {
        onClick()
    }) {
        Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)){
            Text(text, style = MaterialTheme.typography.bodySmall, fontSize = 16.sp)
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End){
                Icon(painter = painterResource(R.drawable.right_arrow), contentDescription = "arrow")
            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = MaterialTheme.colorScheme.surface))
    }
}


@Composable
fun TabBar(uiState: PostUiState, viewModel: PostViewModel,navActions: PostNavigationActions) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    viewModel.updateTabPosition(0)
                    navActions.navigateToNotify()
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "공지사항",
                style = MaterialTheme.typography.titleSmall,
                color = colorByTabPosition(tabPosition = uiState.tabPosition, 0)
            )
            if (uiState.tabPosition == 0) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(2.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(2.dp)
                        )
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    viewModel.updateTabPosition(1)
                    navActions.navigateToInquiry()
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "문의사항",
                style = MaterialTheme.typography.titleSmall,
                color = colorByTabPosition(tabPosition = uiState.tabPosition, 1)
            )
            if (uiState.tabPosition == 1) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(2.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(2.dp)
                        )
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    viewModel.updateTabPosition(2)
                    navActions.navigateToQuestion()
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "자주 묻는 질문",
                style = MaterialTheme.typography.titleSmall,
                color = colorByTabPosition(tabPosition = uiState.tabPosition, 2)
            )
            if (uiState.tabPosition == 2) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(2.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(2.dp)
                        )
                )
            }
        }
    }

}

@Composable
private fun colorByTabPosition(tabPosition: Int, value: Int) =
    if (tabPosition == value) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }

@Preview
@Composable
fun PostScreenPreview() {
    BebechoTheme {
        PostScreen()
    }
}