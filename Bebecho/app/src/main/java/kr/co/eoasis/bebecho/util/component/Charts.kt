package kr.co.eoasis.bebecho.util.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.main.measurement.GridGraph
import kr.co.eoasis.bebecho.ui.main.measurement.drawHeartRateGraph
import kr.co.eoasis.bebecho.ui.theme.Black
import kr.co.eoasis.bebecho.ui.theme.PANTONE1785C

@Composable
fun HeartRateGraphResult(data: List<Float>, color : Color, maxY: Float, minY: Float) {

    val scope = rememberCoroutineScope()
    Row(modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically){
        Box(){
            ChartGrid(maxY, minY)
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp)
                .horizontalScroll(rememberScrollState())){
                Column (modifier = Modifier.padding(top = 10.dp)){
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(((data.size) * 10f / LocalDensity.current.density).dp + 20.dp)
                            .height(160.dp)
                    ) {
                        drawHeartRate(data, maxY, minY,color)
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
fun DrawScope.drawHeartRate(
    data: List<Float>,
    maxY: Float,
    minY: Float,
    color:Color
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
            color = color,
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
fun ChartGrid(maxY:Float, minY: Float){
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
            val count = ((maxY-minY)/30).toInt()
            items(count){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text((30 + (count + 1 -it) * 30).toString(),
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
