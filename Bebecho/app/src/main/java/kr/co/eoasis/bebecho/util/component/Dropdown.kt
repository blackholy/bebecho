package kr.co.eoasis.bebecho.util.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme


@Composable
fun CommonDropdown(
    text:String,
    isExpand: Boolean,
    onDismissRequest: () -> Unit,
    list: List<String>,
    onItemSelect: (Int) -> Unit,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(10.dp)
            ).clickable {
                onClick()
            }
            .padding(horizontal = 20.dp, vertical = 17.dp)

        ,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = text, style = MaterialTheme.typography.titleSmall,)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically){
                Icon(painter = painterResource(R.drawable.bottom_arrow), "bottomArrow",
                    tint = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier.rotate(if(isExpand){180.0f} else {0f})
                )
            }
        }
        DropdownMenu(
            expanded = isExpand, onDismissRequest = {
                onDismissRequest()
            },
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(10.dp))
        ) {
            list.forEachIndexed { index, username ->
                DropdownMenuItem(text = {
                    Text(text = username, color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleSmall)
                },
                    onClick = {
                        onDismissRequest()
                        onItemSelect(index)
                    })
            }
        }
    }
}

@Preview
@Composable
fun PreviewDropdown() {
    BebechoTheme {
        var isExpand = remember{
            mutableStateOf(false)
        }
        var listState = remember{
            mutableStateListOf("1", "2", "3")
        }
        var text = remember{
            mutableStateOf("선택해주셈")
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Box(modifier = Modifier.fillMaxWidth(0.5f)){
                CommonDropdown(text.value,isExpand.value, {isExpand.value = false},listState, {
                    text.value = listState[it].toString() },
                    {isExpand.value = true })
            }
        }
    }

}