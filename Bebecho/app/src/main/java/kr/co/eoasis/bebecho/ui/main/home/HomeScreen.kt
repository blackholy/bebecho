package kr.co.eoasis.bebecho.ui.main.home

import android.graphics.Typeface
import android.graphics.drawable.AnimatedImageDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastCbrt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisLabelComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottom
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberColumnCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.compose.common.component.rememberLineComponent
import com.patrykandpatrick.vico.compose.common.component.shadow
import com.patrykandpatrick.vico.compose.common.fill
import com.patrykandpatrick.vico.compose.common.rememberHorizontalLegend
import com.patrykandpatrick.vico.compose.common.shape.rounded
import com.patrykandpatrick.vico.core.cartesian.Scroll
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.columnSeries
import com.patrykandpatrick.vico.core.cartesian.layer.ColumnCartesianLayer
import com.patrykandpatrick.vico.core.common.Dimensions
import com.patrykandpatrick.vico.core.common.component.TextComponent
import com.patrykandpatrick.vico.core.common.shape.CorneredShape
import kotlinx.coroutines.launch
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.main.MainNavigationActions
import kr.co.eoasis.bebecho.ui.main.MainUiState
import kr.co.eoasis.bebecho.ui.main.MainViewModel
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.ui.theme.Blue
import kr.co.eoasis.bebecho.ui.theme.Gray2
import kr.co.eoasis.bebecho.ui.theme.Gray5
import kr.co.eoasis.bebecho.ui.theme.Green
import kr.co.eoasis.bebecho.ui.theme.Orange
import kr.co.eoasis.bebecho.ui.theme.PANTONE1785C
import kr.co.eoasis.bebecho.ui.theme.PANTONE184C
import kr.co.eoasis.bebecho.util.component.ButtonFont
import kr.co.eoasis.bebecho.util.component.CommonButton
import kr.co.eoasis.bebecho.util.component.MainTopBar
import kr.co.eoasis.bebecho.util.component.ColorOutLineButton
import kr.co.eoasis.bebecho.util.component.CommonOutLineButton
import kr.co.eoasis.bebecho.data.repository.UserRepositoryImpl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    navActions: MainNavigationActions
) {
    val sheetState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val mainUiState by mainViewModel.uiState.collectAsStateWithLifecycle()

    BottomSheetScaffold(
        contentColor = MaterialTheme.colorScheme.onBackground,
        sheetContentColor = MaterialTheme.colorScheme.onBackground,
        scaffoldState = sheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Row(
                    modifier = Modifier.padding(start = 24.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "공지사항", style = MaterialTheme.typography.titleLarge,
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.right_arrow), "right_arrow",
                                tint = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Gray2)
                )

                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    LazyColumn {

                        items(4) {
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(horizontal = 10.dp)
                                        .padding(top = 8.dp)
                                ) {
                                    Text(
                                        text = "공지사항",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Text(
                                            text = "2024.08.13",
                                            style = MaterialTheme.typography.titleSmall,
                                            fontSize = 10.sp,
                                            color = MaterialTheme.colorScheme.surfaceVariant,

                                            )
                                    }
                                }
                                Spacer(
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(color = Gray2)
                                )
                            }

                        }
                    }
                }

                Row(
                    modifier = Modifier.padding(start = 24.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "문의사항", style = MaterialTheme.typography.titleLarge,
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(top = 40.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.right_arrow), "right_arrow",
                                tint = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Gray2)
                )

                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    LazyColumn {
                        items(4) {
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(horizontal = 10.dp)
                                        .padding(top = 8.dp)
                                ) {
                                    Text(
                                        text = "공지사항",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Text(
                                            text = "2024.08.13",
                                            style = MaterialTheme.typography.titleSmall,
                                            fontSize = 10.sp,
                                            color = MaterialTheme.colorScheme.surfaceVariant,

                                            )
                                    }
                                }
                                Spacer(
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(color = Gray2)
                                )
                            }

                        }
                    }
                }
                Box(modifier = Modifier.padding(vertical = 40.dp, horizontal = 24.dp)) {
                    ColorOutLineButton(
                        text = "문의글 작성하기",
                        font = ButtonFont.WANTED,
                        enabled = true,
                        fontSize = 18.sp,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ) {
                    }
                }
            }
        },

        sheetDragHandle = {
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)

                    .height(6.dp)
                    .width(70.dp)
                    .background(
                        MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(20.dp)
                    )
            )
        },
        sheetShadowElevation = 10.dp,
        modifier = Modifier.background(
            MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ),

        sheetPeekHeight = 56.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        ) {

            val scrollState = rememberVicoScrollState(initialScroll = Scroll.Absolute.End)
            val modelProducer = remember { CartesianChartModelProducer() }
            LaunchedEffect(Unit) {
                modelProducer.runTransaction {
                    columnSeries {
                        series(
                            x = listOf(23, 24, 25, 26, 27, 28, 29),
                            y = listOf(104, 110, 104, 110, 112, 122)
                        )
                        series(
                            x = listOf(23, 24, 25, 26, 27, 28, 29),
                            y = listOf(26, 26, 26, 26, 26, 26)
                        )
                        series(
                            x = listOf(23, 24, 25, 26, 27, 28, 29),
                            y = listOf(75, 75, 75, 75, 75, 75)
                        )
                    }

                }
            }
            Column(
                modifier = Modifier
                    .padding()
                    .verticalScroll(rememberScrollState())
            ) {
                MainTopBar()
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    Text(
                        "${mainUiState.userId}님,",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 32.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Text(
                        "좋은 아침입니다.,", style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 32.sp,
                    )
                    Row(
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(
                            "32주차 (총 225일)", style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                        Text(
                            "|",
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.padding(horizontal = 5.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                        )
                        Text(
                            "2024년 12월 16일 예정",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    }
                    Row(modifier = Modifier.padding(top = 50.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 4.dp)
                        ) {
                            CommonButton(text = "측정하러 가기", ButtonFont.WANTED, true, 18.sp) {
                                navActions.navigateToMeasurement()
                                mainViewModel.setTabPosition(2)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp)
                        ) {
                            ColorOutLineButton(
                                text = "사용법 보기",
                                ButtonFont.WANTED,
                                true,
                                contentColor = Blue,
                                18.sp
                            ) {
                            }
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .height(6.dp)
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.background),
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 30.dp)
                ) {
                    Text(
                        "Overview",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 24.sp,
                    )
                    Row(modifier = Modifier.padding(top = 12.dp)) {
                        Text(
                            "일주일 측정결과",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall,
                            fontSize = 18.sp
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Box(modifier = Modifier.padding(end = 10.dp)) {
                                MeasurementLabel(color = Orange, text = "Min")
                            }
                            Box(modifier = Modifier.padding(end = 10.dp)) {
                                MeasurementLabel(color = Green, text = "Avg")
                            }
                            Box() {
                                MeasurementLabel(color = PANTONE1785C, text = "Max")
                            }
                        }
                    }
                    CartesianChartHost(
                        rememberCartesianChart(
                            rememberColumnCartesianLayer(
                                ColumnCartesianLayer.ColumnProvider.series(
                                    columnColors.map { color ->
                                        rememberLineComponent(
                                            fill = fill(color),
                                            thickness = 16.dp,
                                            margins = Dimensions(topDp = (2.dp).value),
                                            shape = CorneredShape.rounded(4.dp),
                                        )
                                    }
                                ),
                                mergeMode = {
                                    ColumnCartesianLayer.MergeMode.Stacked
                                },
                            ),
                            startAxis = VerticalAxis.rememberStart(
                                label = rememberAxisLabelComponent(
                                    textSize = 14.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            ),
                            bottomAxis = HorizontalAxis.rememberBottom(
                                label = rememberAxisLabelComponent(
                                    textSize = 14.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                ),
                                guideline = null
                            ),
                            legend = rememberHorizontalLegend({ })
                        ),
                        modelProducer,
                        scrollState = scrollState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 240.dp)
                            .padding(top = 8.dp),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "29일 측정결과",
                            style = MaterialTheme.typography.titleSmall,
                            fontSize = 18.sp
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                "측정시간  |  00 : 00",
                                style = MaterialTheme.typography.titleSmall,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    }
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
                                    .background(color = MaterialTheme.colorScheme.background)
                                    ,
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
                        Row(modifier = Modifier.padding(top = 8.dp)) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 4.dp)
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
                                    .padding(horizontal = 4.dp)
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
                                    .padding(start = 4.dp)
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "정상",
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 22.sp,
                            color = Green
                        )
                        Text(
                            text = "적인 FH5수치입니다",
                            style = MaterialTheme.typography.titleSmall,
                            fontSize = 22.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                Spacer(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                        .height(6.dp)
                        .background(MaterialTheme.colorScheme.background)
                )
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "정상적인 태아 심박수가 궁금하신가요?",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 18.sp
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "주별 심박수 보러가기",
                            textDecoration = TextDecoration.Underline,
                            style = MaterialTheme.typography.labelMedium,
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.surfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.height(96.dp))
                }

            }
        }
    }


}

@Composable
fun MeasurementLabel(text: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Spacer(
            modifier = Modifier
                .size(10.dp)
                .background(color = color, shape = RoundedCornerShape(2.dp))
        )
        Text(
            text, modifier = Modifier.padding(start = 4.dp),
            style = MaterialTheme.typography.bodyMedium, color = color,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    BebechoTheme {
        val previewViewModel = hiltViewModel<MainViewModel>()
        HomeScreen(
            mainViewModel = previewViewModel,
            navActions = MainNavigationActions(rememberNavController())
        )
    }
}

private val columnColors = listOf(Orange, Green, PANTONE1785C)