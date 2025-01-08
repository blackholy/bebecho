package kr.co.eoasis.bebecho.ui.main.measurement

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.graphics.RectF
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisLabelComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottom
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.axis.text
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberColumnCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.compose.common.component.rememberLineComponent
import com.patrykandpatrick.vico.compose.common.fill
import com.patrykandpatrick.vico.compose.common.rememberHorizontalLegend
import com.patrykandpatrick.vico.compose.common.shape.rounded
import com.patrykandpatrick.vico.core.cartesian.CartesianChart
import com.patrykandpatrick.vico.core.cartesian.CartesianDrawingContext
import com.patrykandpatrick.vico.core.cartesian.CartesianMeasuringContext
import com.patrykandpatrick.vico.core.cartesian.MutableHorizontalDimensions
import com.patrykandpatrick.vico.core.cartesian.Scroll
import com.patrykandpatrick.vico.core.cartesian.axis.Axis
import com.patrykandpatrick.vico.core.cartesian.axis.BaseAxis
import com.patrykandpatrick.vico.core.cartesian.axis.BaseAxis.Size
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis.HorizontalLabelPosition.Outside
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis.ItemPlacer
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis.VerticalLabelPosition.Center
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.CartesianValueFormatter
import com.patrykandpatrick.vico.core.cartesian.data.columnSeries
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.core.cartesian.layer.ColumnCartesianLayer
import com.patrykandpatrick.vico.core.common.Dimensions
import com.patrykandpatrick.vico.core.common.shape.CorneredShape
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.ui.theme.Black
import kr.co.eoasis.bebecho.ui.theme.Blue
import kr.co.eoasis.bebecho.ui.theme.Gray0
import kr.co.eoasis.bebecho.ui.theme.Gray5
import kr.co.eoasis.bebecho.ui.theme.Green
import kr.co.eoasis.bebecho.ui.theme.PANTONE1785C
import kr.co.eoasis.bebecho.ui.theme.PANTONE184C
import kr.co.eoasis.bebecho.util.component.ButtonFont
import kr.co.eoasis.bebecho.util.component.CommonIconButton
import kr.co.eoasis.bebecho.util.component.CommonMainTopBar
import kr.co.eoasis.bebecho.util.component.PlayButton


@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeasurementScreen(

){


    val scrollState = rememberScrollState()
    val modelProducer = remember { CartesianChartModelProducer() }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
//        .verticalScroll(scrollState)
    ){
        CommonMainTopBar("측정")
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 28.dp)
            .padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(R.drawable.heart_measurement),"heart_measurement",
                tint = MaterialTheme.colorScheme.surfaceVariant)
            Spacer(modifier = Modifier.width(8.dp))
            Text("시작 눌러주세요", style = MaterialTheme.typography.titleSmall, fontSize = 18.sp, color = MaterialTheme.colorScheme.surfaceVariant)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically){
                Text("00:00", style = MaterialTheme.typography.titleSmall, fontSize = 14.sp, color = MaterialTheme.colorScheme.surfaceVariant)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(painter = painterResource(R.drawable.time),"time",
                    tint = MaterialTheme.colorScheme.surfaceVariant)
            }
        }
        var heartRateData by remember { mutableStateOf(listOf<Float>()) }
        val maxY = 210f     // 심박수 최대값
        val minY = 60f      // 심박수 최소값

        // 데이터 추가 함수
        fun addHeartRateData(value: Float) {
            heartRateData = heartRateData + value

        }

        // 실시간 데이터 시뮬레이션
        LaunchedEffect(Unit) {
            var a = 0
            while (true) {
                Log.d(TAG, "MeasurementScreen: ${heartRateData.size}")
                a++
                val simulatedHeartRate = 100f + (Math.random() * 60f).toFloat() // 60~150 bpm
                addHeartRateData(simulatedHeartRate)
                delay(50) // 0.5초 간격으로 데이터 추가
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(top = 7.dp), horizontalArrangement = Arrangement.End){
            Row(verticalAlignment = Alignment.CenterVertically){
                Spacer(modifier = Modifier.size(10.dp).background(PANTONE1785C, shape = RoundedCornerShape(2.dp)))
                Spacer(modifier = Modifier.width(6.dp))
                Text("FHR", style = MaterialTheme.typography.bodyMedium, fontSize = 12.sp,
                    color = PANTONE1785C)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                Spacer(modifier = Modifier.size(10.dp).background(Blue, shape = RoundedCornerShape(2.dp)))
                Spacer(modifier = Modifier.width(6.dp))
                Text("TOCO", style = MaterialTheme.typography.bodyMedium, fontSize = 12.sp,
                    color = Blue)
            }

        }
        ScrollableHeartRateGraph(heartRateData, maxY, minY)

        Box(modifier = Modifier.padding(horizontal = 24.dp).padding(top = 24.dp)){
            MeasurementDashBoard()
        }

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)){
            Box(modifier = Modifier.fillMaxWidth(0.35f)){
                PlayButton(false) {

                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(){
                CommonIconButton("kicks", painterResource(R.drawable.foot), ButtonFont.POPPINS,true,18.sp) { }
            }

        }
    }
}

@Composable
fun ScrollableHeartRateGraph(data: List<Float>, maxY: Float, minY: Float) {
    // 스크롤 상태 기억
//    var offsetX by remember { mutableStateOf(0f) } // X축 이동
    /*val scrollState = rememberScrollableState { delta ->
        offsetX = (offsetX + delta).coerceIn(0f, (data.size - 1) * 200f) // 스크롤 제한
        delta
    }*/
    val scrollState = rememberScrollState(
    )
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        while (true){
            scope.launch {
                scrollState.animateScrollTo(scrollState.maxValue) // 스크롤 끝으로 이동
            }
            delay(50)
        }
    }
    Row(modifier = Modifier.padding(horizontal = 24.dp).padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically){

        Box(){
            GridGraph()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp)
                .horizontalScroll(scrollState)){
                Column (modifier = Modifier.padding(top = 10.dp)){
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(((data.size) * 10f / LocalDensity.current.density).dp + 20.dp)
                            .height(160.dp)
                    ) {
                        drawHeartRateGraph(data, maxY, minY)
                    }

                    val time = intArrayOf(10, 20, 30)
                    LazyRow(modifier = Modifier.width(((data.size) * 10f / LocalDensity.current.density).dp).padding(top = 10.dp).height(24.dp), verticalAlignment = Alignment.Bottom){
                        items(data){
                            it ->
                            if(it > 150){
                                Icon(painter = painterResource(R.drawable.foot), "foot", tint = MaterialTheme.colorScheme.surfaceVariant)
                            }else{
                                Row(modifier = Modifier.width((10f / LocalDensity.current.density).dp)){

                                }
                            }
                        }
                    }
                }

            }

        }
    }
}

@Composable
fun MeasurementDashBoard(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row() {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
                    .background(Gray0)
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
                        tint = Gray5
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
                    text = "120",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 30.sp,
                    color = MaterialTheme.colorScheme.primary,
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
                    .background(Gray0),
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
                        tint = Gray5

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
                    color = MaterialTheme.colorScheme.primary,
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
                        painter = painterResource(R.drawable.kicks), "kicks",
                        tint = Gray5

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
                    color = MaterialTheme.colorScheme.primary,
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
                        tint = Gray5

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
                    color = MaterialTheme.colorScheme.primary,
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
                        painter = painterResource(R.drawable.average), "kicks",
                        tint = Gray5

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
                    color = MaterialTheme.colorScheme.primary,
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
                        painter = painterResource(R.drawable.average), "kicks",
                        tint = Gray5
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
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(
                            top = 18.dp,
                            bottom = 26.dp
                        )
                )
            }

        }
    }

}
fun DrawScope.drawHeartRateGraph(
    data: List<Float>,
    maxY: Float,
    minY: Float,
//    offsetX: Float // 스크롤에 따른 X축 오프셋
) {
    if (data.isEmpty()) return

    val stepX = 10f // X축 간격을 고정 값으로 설정 (픽셀 단위)
    val rangeY = (maxY - minY).takeIf { it > 0 } ?: return
    var lastX = 0f;
    for (i in 0 until data.size - 1) {
        val startX = i * stepX  // 스크롤 반영
        val stopX = (i + 1) * stepX

        // 화면 밖의 요소는 건너뜀
        if (stopX < 0 || startX > size.width) continue

        val startY = size.height - (data[i] - minY) / rangeY * size.height
        val stopY = size.height - (data[i + 1] - minY) / rangeY * size.height

        drawLine(
            color = PANTONE1785C,
            start = Offset(startX, startY),
            end = Offset(stopX, stopY),
            strokeWidth = 1.dp.toPx(),
            cap = StrokeCap.Round
        )
        lastX = stopX
    }
    drawLine(color = Black,
        start = Offset(lastX-5f, 0f),
        end = Offset(lastX-5f, 160.dp.toPx()),
        strokeWidth = 1.5.dp.toPx(),
    )
}
@Composable
fun GridGraph(){

    Box(){
        LazyRow (modifier = Modifier.fillMaxWidth()){
            item {
                Spacer(modifier = Modifier
                    .width(50.dp)
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                )
            }
            items(7){

                Spacer(modifier = Modifier
                    .width(1.dp)
                    .padding(top = 11.dp)
                    .height(160.dp)
                    .background(MaterialTheme.colorScheme.surface)
                )

                Spacer(modifier = Modifier
                    .width(50.dp)
                    .fillMaxWidth()
                )
            }

        }
        LazyColumn (modifier = Modifier.fillMaxWidth()
            .height(182.dp)
            , verticalArrangement = Arrangement.Bottom){
            items(5){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text((30 + (6-it) * 30).toString(),
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 14.sp,
                        lineHeight = 22.sp)
                    Spacer(modifier = Modifier.width(9.dp))
                    Spacer(modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                    )
                }
                Spacer(modifier = Modifier
                    .height(13.dp)
                    .fillMaxWidth()
                )
            }
            item{
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text("60", style = MaterialTheme.typography.bodySmall, lineHeight = 22.sp)
                    Spacer(modifier = Modifier.width(9.dp))

                    Spacer(modifier = Modifier
                        .height(1.5.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.onSurfaceVariant))
                }
            }
        }
    }

}

 @Preview
@Composable
fun MesurementScreenPreview(){
    BebechoTheme {
        MeasurementScreen()
    }

}