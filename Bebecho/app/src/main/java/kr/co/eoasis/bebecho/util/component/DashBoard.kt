package kr.co.eoasis.bebecho.util.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.theme.Gray0
import kr.co.eoasis.bebecho.ui.theme.Gray5
import kr.co.eoasis.bebecho.ui.theme.Green
import kr.co.eoasis.bebecho.ui.theme.PANTONE184C

@Composable
fun DashBoard(FHR: String, TOCO: String, Kicks: String, Min: String, Avg: String, Max: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 28.dp),
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
                    text = FHR,
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
                    text = TOCO,
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
                    text = Kicks,
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
                    text = Min,
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
                    text = Avg,
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
                        painter = painterResource(R.drawable.maximum), "kicks",
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
                    text = Max,
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

}
