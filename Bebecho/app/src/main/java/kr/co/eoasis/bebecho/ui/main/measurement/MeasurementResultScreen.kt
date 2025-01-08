package kr.co.eoasis.bebecho.ui.main.measurement

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.ui.theme.Blue
import kr.co.eoasis.bebecho.ui.theme.Gray1
import kr.co.eoasis.bebecho.ui.theme.Gray3
import kr.co.eoasis.bebecho.ui.theme.Green
import kr.co.eoasis.bebecho.ui.theme.PANTONE1785C
import kr.co.eoasis.bebecho.util.component.ButtonFont
import kr.co.eoasis.bebecho.util.component.CommonButton
import kr.co.eoasis.bebecho.util.component.CommonMainTopBar
import kr.co.eoasis.bebecho.util.component.DashBoard
import kr.co.eoasis.bebecho.util.component.HeartRateGraphResult


@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeasurementResultScreen() {


    val scrollState = rememberScrollState()
    val modelProducer = remember { CartesianChartModelProducer() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
    ) {
        CommonMainTopBar("측정")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp)
                .padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.heart_measurement), "heart_measurement",
                tint = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "측정 결과",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "00:00",
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.time), "time",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 34.dp)
        ) {
            Row(modifier = Modifier) {
                Text(
                    "정상",
                    color = Green,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.height(26.dp)
                )
                Text(
                    "적인 FHR 수치입니다.",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.height(26.dp)
                )

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Text(
                        "이전 기록 보기", color = MaterialTheme.colorScheme.surfaceVariant,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 13.sp,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable { },
                        lineHeight = 26.sp,
                    )
                }
            }
            Row() {
                Text(
                    "정상",
                    color = Green,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    modifier = Modifier.height(26.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    "적인 TOCO 수치입니다.",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    modifier = Modifier.height(26.dp),
                    textAlign = TextAlign.Center
                )
            }
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    "15번",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    modifier = Modifier.height(26.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    "의 태동이 느껴졌습니다!",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    modifier = Modifier.height(26.dp),
                    textAlign = TextAlign.Center
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Icon(
                        painterResource(R.drawable.check), "check",
                        tint = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }

        }

        val data1 = mutableListOf<Float>()
        repeat(20) {
            data1.add(155f)
            data1.add(100f)
            data1.add(110f)
            data1.add(122f)
            data1.add(110f)
            data1.add(100f)
        }
        data1.add(160f)
        repeat(20) {
            data1.add(155f)
            data1.add(100f)
            data1.add(110f)
            data1.add(122f)
            data1.add(110f)
            data1.add(100f)
        }

        val data2 = mutableListOf<Float>()
        repeat(20) {
            data2.add(95f)
            data2.add(70f)
            data2.add(75f)
            data2.add(75f)
            data2.add(80f)
            data2.add(75f)
        }
        Box(modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp)) {
            Column {
                Spacer(modifier = Modifier.height(MaterialTheme.typography.bodyMedium.fontSize.value.dp + 10.dp))
                GridGraphSmall(data1)
            }
            val maxWidth = remember {
                mutableStateOf(0f)
            }
            Row(modifier = Modifier.fillMaxWidth().onGloballyPositioned {
                maxWidth.value = it.size.width.toFloat()
            }) {
                Column {
                    val maxIndex = data1.indexOf(data1.maxOrNull())
                    val minIndex = data1.indexOf(data1.minOrNull())
                    val maxTextPadding = maxIndex * ((maxWidth.value/data1.size)/ LocalDensity.current.density).dp
                    val minTextPadding = minIndex * ((maxWidth.value/data1.size)/ LocalDensity.current.density).dp
                    Box() {
                        Text(
                            "Max",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.padding(
                                start =
                                if (maxTextPadding > 10.dp) {
                                    maxTextPadding - 10.dp
                                } else {
                                    0.dp
                                }
                            )
                        )

                        Text(
                            "Min",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.padding(
                                start =
                                if (minTextPadding > 10.dp) {
                                    minTextPadding - 10.dp
                                } else {
                                    0.dp
                                }
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    MeasurementResultGraph(data1,data2)
                }
            }
        }
        Box(modifier = Modifier.padding(horizontal = 24.dp)) {
            DashBoard("정상", "24", "24", "109", "126", "126")
        }
        Spacer(
            Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .height(6.dp)
                .background(color = Gray1))

        Text("FHR", modifier = Modifier.padding(top = 30.dp, start = 24.dp),
            style = MaterialTheme.typography.labelMedium, fontSize = 18.sp,)
        Box(modifier = Modifier.padding(start = 24.dp, top = 12.dp)){
            HeartRateGraphResult(data1, PANTONE1785C,210f, 60f, )
        }
        Text("TOCO", modifier = Modifier.padding(top = 30.dp, start = 24.dp),
            style = MaterialTheme.typography.labelMedium, fontSize = 18.sp,)
        Box(modifier = Modifier.padding(start = 24.dp, top = 12.dp)){
            HeartRateGraphResult(data2, Blue,180f, 60f, )
        }

        CommonButton("결과 보내기", font=ButtonFont.WANTED, fontSize = 18.sp, enabled = true,) {

        }


    }
}


@Composable
fun GridGraphSmall(data: List<Float>) {

    val max = data.maxOrNull()
    val isMaxRecord = remember { mutableStateOf(false) }
    val min = data.minOrNull()
    val isMinRecord = remember { mutableStateOf(false) }

    Box() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
            )
            Spacer(modifier = Modifier.width(9.dp))
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                Spacer(
                    modifier = Modifier
                        .height(1.5.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }


        }
    }

}

@Composable
fun MeasurementResultGraph(data1: List<Float>, data2: List<Float>) {
    val widthState = remember { mutableStateOf(0f) }

    Column {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .onGloballyPositioned {
                    widthState.value = it.size.width.toFloat()
                }
        ) {
            drawFHRGraph2(data1, 210f, 60f, widthState.value)
            drawTOCOGraph2(data2, 210f, 60f,widthState.value)
        }
    }
}

fun DrawScope.drawTOCOGraph2(
    data: List<Float>,
    maxY: Float,
    minY: Float,
    maxWidth: Float
) {
    if (data.isEmpty()) return
    val sizeCorrectionValue = 15f
    val stepX = maxWidth/data.size
    val rangeY = (maxY - minY).takeIf { it > 0 } ?: return
    var lastX = 0f;
    for (i in 0 until data.size - 1) {
        val startX = i * stepX  // 스크롤 반영
        val stopX = (i + 1) * stepX

        // 화면 밖의 요소는 건너뜀
        if (stopX < 0 || startX > size.width) continue

        val startY = size.height - (data[i] - minY + sizeCorrectionValue) / rangeY * size.height
        val stopY = size.height - (data[i + 1] - minY + sizeCorrectionValue) / rangeY * size.height

        drawLine(
            color = Blue,
            start = Offset(startX, startY),
            end = Offset(stopX, stopY),
            strokeWidth = 1.dp.toPx(),
            cap = StrokeCap.Round
        )
        lastX = stopX
    }
}

fun DrawScope.drawFHRGraph2(
    data: List<Float>,
    maxY: Float,
    minY: Float,
    maxWidth: Float
) {
    var max = data.maxOrNull();
    var min = data.minOrNull();
    var isMaxLine = false;
    var isMinLine = false;
    val sizeCorrectionValue = 30f
    if (data.isEmpty()) return

    val stepX = maxWidth/data.size
    val rangeY = (maxY - minY).takeIf { it > 0 } ?: return
    var lastX = 0f;
    for (i in 0 until data.size - 1) {
        val startX = i * stepX  // 스크롤 반영
        val stopX = (i + 1) * stepX

        // 화면 밖의 요소는 건너뜀
        if (stopX < 0 || startX > size.width) continue

        val startY = size.height - (data[i] - minY + sizeCorrectionValue) / rangeY * size.height
        val stopY = size.height - (data[i + 1] - minY + sizeCorrectionValue) / rangeY * size.height

        drawLine(
            color = PANTONE1785C,
            start = Offset(startX, startY),
            end = Offset(stopX, stopY),
            strokeWidth = 1.dp.toPx(),
            cap = StrokeCap.Round
        )

        if (data[i] == data.maxOrNull()&& !isMaxLine) {
            isMaxLine = true

            repeat(14) {
                if (it % 2 == 0) {
                    drawLine(
                        color = Gray3,
                        start = Offset(startX, 0f + (it) * 5.dp.toPx()),
                        end = Offset(startX, (it + 1) * 5.dp.toPx()),
                        strokeWidth = 1.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }
        }

        if (data[i] == data.minOrNull() && !isMinLine) {
            isMinLine = true
            repeat(14) {
                if (it % 2 == 0) {
                    drawLine(
                        color = Gray3,
                        start = Offset(startX, 0f + (it) * 5.dp.toPx()),
                        end = Offset(startX, (it + 1) * 5.dp.toPx()),
                        strokeWidth = 1.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }

        }

        lastX = stopX
    }
}


@Preview
@Composable
fun MesurementResultScreenPreview() {
    BebechoTheme {
        MeasurementResultScreen()
    }

}