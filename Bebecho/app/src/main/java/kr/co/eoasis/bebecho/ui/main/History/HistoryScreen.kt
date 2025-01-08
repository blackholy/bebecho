package kr.co.eoasis.bebecho.ui.main.History

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.ui.theme.Gray0
import kr.co.eoasis.bebecho.ui.theme.Gray2
import kr.co.eoasis.bebecho.ui.theme.Gray5
import kr.co.eoasis.bebecho.ui.theme.Green
import kr.co.eoasis.bebecho.ui.theme.PANTONE184C
import kr.co.eoasis.bebecho.util.component.CommonMainTopBar
import java.util.Calendar

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .clickable(interactionSource = remember { MutableInteractionSource() },
                indication = null,
                enabled = uiState.isShowCalendar) {
                viewModel.updateShowCalendar(false)
            }
    ) {
        Column() {
            CommonMainTopBar("이력")
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(
                    "2024-01-26 측정 결과",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                ) {
                    Row() {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 4.dp)
                                .background(
                                    color = Gray0,
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    end = 12.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.heart), "heart",
                                    tint = Green
                                )
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        text = "FHR",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        color = Gray5
                                    )
                                }
                            }
                            Text(
                                text = "정상",
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = 30.sp,
                                color = Green,
                                modifier = Modifier
                                    .padding(
                                        top = 18.dp,
                                        bottom = 26.dp
                                    )
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                                .background(
                                    color = Gray0,
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    end = 12.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.toco), "heart",
                                    tint = PANTONE184C
                                )
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        text = "TOCO",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        color = Gray5
                                    )
                                }
                            }
                            Text(
                                text = "24",
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 30.sp,
                                color = PANTONE184C,
                                modifier = Modifier
                                    .padding(
                                        top = 18.dp,
                                        bottom = 26.dp
                                    )
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp)
                                .background(
                                    color = Gray0,
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    end = 12.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.kicks), "kicks",
                                    tint = PANTONE184C
                                )
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        text = "Kicks",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        color = Gray5
                                    )
                                }
                            }
                            Text(
                                text = "24",
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 30.sp,
                                color = PANTONE184C,
                                modifier = Modifier
                                    .padding(
                                        top = 18.dp,
                                        bottom = 26.dp
                                    )
                            )
                        }


                    }
                    Row() {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .background(color = Gray0),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    end = 12.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.minimum), "kicks",
                                    tint = Green
                                )
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        text = "Min",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        color = Gray5
                                    )
                                }
                            }
                            Text(
                                text = "109",
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 34.sp,
                                color = Green,
                                modifier = Modifier
                                    .padding(
                                        top = 18.dp,
                                        bottom = 26.dp
                                    )
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .background(color = MaterialTheme.colorScheme.background),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    end = 12.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.average), "kicks",
                                    tint = Green
                                )
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        text = "Avg",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        color = Gray5
                                    )
                                }
                            }
                            Text(
                                text = "126",
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 34.sp,
                                color = Green,
                                modifier = Modifier
                                    .padding(
                                        top = 18.dp,
                                        bottom = 26.dp
                                    )
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .background(color = MaterialTheme.colorScheme.background),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    end = 12.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.average), "kicks",
                                    tint = Green
                                )
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        text = "Max",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 16.sp,
                                        color = Gray5
                                    )
                                }
                            }
                            Text(
                                text = "126",
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 34.sp,
                                color = Green,
                                modifier = Modifier
                                    .padding(
                                        top = 18.dp,
                                        bottom = 26.dp
                                    )
                            )
                        }
                    }
                }
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        "2024-01-12 ~ 2024-02-09", modifier = Modifier.padding(
                            top = 20.dp,
                            start = 10.dp
                        ),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant

                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            "날짜 선택", modifier = Modifier
                                .padding(
                                    top = 20.dp,
                                    start = 10.dp
                                )
                                .clickable {
                                    viewModel.updateShowCalendar(true)
                                },
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }

                Box() {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .background(color = Gray2, shape = RoundedCornerShape(10.dp)),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier.weight(0.28f),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    "측정일자", modifier = Modifier.padding(vertical = 10.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Row(
                                modifier = Modifier.weight(0.2f),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    "측정시간", modifier = Modifier.padding(vertical = 10.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Row(
                                modifier = Modifier.weight(0.2f),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    "평균 FHR", modifier = Modifier.padding(vertical = 10.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Row(
                                modifier = Modifier.weight(0.17f),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    "예상평가", modifier = Modifier.padding(vertical = 10.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Row(
                                modifier = Modifier.weight(0.12f),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    "소견", modifier = Modifier.padding(vertical = 10.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        LazyColumn {
                            items(4) {
                                Column(modifier = Modifier) {
                                    Row(modifier = Modifier.padding(vertical = 20.dp)) {
                                        Row(
                                            modifier = Modifier.weight(0.28f),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "2024-01-19",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }

                                        Row(
                                            modifier = Modifier.weight(0.2f),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "11:33",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Row(
                                            modifier = Modifier.weight(0.2f),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "149",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Row(
                                            modifier = Modifier.weight(0.17f),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "위험",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Row(
                                            modifier = Modifier.weight(0.12f),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "보기",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                textDecoration = TextDecoration.Underline
                                            )
                                        }
                                    }
                                    Spacer(
                                        modifier = Modifier
                                            .height(1.dp)
                                            .fillMaxWidth()
                                            .background(color = MaterialTheme.colorScheme.surface)
                                    )
                                }
                            }
                        }

                    }
                    androidx.compose.animation.AnimatedVisibility(
                        visible = uiState.isShowCalendar,
                        enter = fadeIn(animationSpec = tween(100)),
                        exit = fadeOut(animationSpec = tween(100))
                    ){
                        val year = remember {
                            mutableIntStateOf(Calendar.getInstance().get(Calendar.YEAR))
                        }
                        val month = remember {
                            mutableIntStateOf(Calendar.getInstance().get(Calendar.MONTH))
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .shadow(10.dp, shape = RoundedCornerShape(10.dp))
                                .background(
                                    MaterialTheme.colorScheme.background,
                                    shape = RoundedCornerShape(10.dp),
                                ).clickable(interactionSource = remember {
                                    MutableInteractionSource()
                                },indication = null
                                    ) {
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(start = 32.dp, top = 18.dp, end = 18.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${year.value} ${todayMonth(month.value)}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                )
                                Row(Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,){
                                    IconButton(onClick = {
                                        if(month.intValue == 0){
                                            month.value = 11
                                            year.value = year.value-1
                                        }else{
                                            month.value = month.value - 1
                                        }
                                    }) {
                                        Icon(painter = painterResource(R.drawable.left_arrow),"left_arrow")
                                    }
                                    IconButton({
                                        if(month.intValue == 11){
                                            month.value = 0
                                            year.value = year.value+1
                                        }else{
                                            month.value = month.value + 1
                                        }
                                    }) {
                                        Icon(painter = painterResource(R.drawable.right_arrow),"right_arrow")

                                    }

                                }
                            }


                            val day31 = intArrayOf(0,2,4,6,7,9,11)
                            val day30 = intArrayOf(3, 5, 8, 10)
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(7),
                                modifier = Modifier.padding(horizontal = 28.dp).padding(bottom = 18.dp)
                            ) {
                                items(7) {
                                    Box(modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                                        contentAlignment = Alignment.Center){
                                        Text(text = when(it){
                                            0 -> "S"
                                            1 -> "M"
                                            2 -> "T"
                                            3 -> "W"
                                            4 -> "T"
                                            5 -> "F"
                                            6 -> "S"
                                            else -> "${it+1}"
                                        },
                                            style = MaterialTheme.typography.titleSmall, fontSize = 14.sp)

                                    }

                                }
                                items(37){

                                    val calendar = Calendar.getInstance()
                                    calendar.set(year.value, month.value, 1)
                                    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
                                    if((it - dayOfWeek + 2 < 31 && day30.contains(month.value) || it - dayOfWeek + 2 < 32 && day31.contains(month.value))) {
                                        Box(modifier = Modifier.fillMaxWidth().aspectRatio(1f).padding(6.dp),
                                            contentAlignment = Alignment.Center){
                                            if(it >= dayOfWeek -1 )
                                                Text(text = "${it - dayOfWeek + 2}",
                                                    style = MaterialTheme.typography.titleSmall, fontSize = 14.sp)
                                        }
                                    }
                                }
                            }

                        }
                    }

                }
            }
        }

    }
}

fun todayYear():Int{
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.YEAR)
}

fun todayMonth(month: Int): String{
    return when(month){
        0 -> {
           "January"
        }
        1 ->{
            "February"
        }
        2 -> {
            "March"
        }
        3 -> {
            "April"
        }
        4 -> {
            "May"
        }
        5 -> {
            "June"
        }
        6 -> {
            "July"
        }
        7 -> {
            "August"
        }
        8 -> {
            "September"
        }
        9 ->{
            "October"
        }
        10 -> {
            "November"
        }
        11 -> {
            "December"
        }
        else -> {
            "January"
        }
    }
}

@Preview
@Composable
fun HistoryScreenPreview() {
    BebechoTheme {
        HistoryScreen()
    }
}