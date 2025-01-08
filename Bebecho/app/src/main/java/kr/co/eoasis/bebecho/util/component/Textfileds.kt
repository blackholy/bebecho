package kr.co.eoasis.bebecho.util.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.eoasis.bebecho.R
import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
import kr.co.eoasis.bebecho.ui.theme.Gray1
import kr.co.eoasis.bebecho.ui.theme.Gray4
import kotlin.math.max

@Composable
fun CommonTextField(value: String, placeHolder: String,color: Color, isPassword:Boolean, onValueChange: (String) -> Unit ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp, color = if (value.isEmpty()) {
                    Gray4
                } else {
                    color
                }, shape = RoundedCornerShape(10.dp)
            )
    ) {
        BasicTextField(
            modifier = Modifier.padding(
                start = 20.dp,
                top = 19.dp,
                bottom = 19.dp,
                end = 20.dp
            ), value = value, onValueChange = { onValueChange(it) },
            textStyle = TextStyle(fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                color = MaterialTheme.colorScheme.onBackground
                ),
            visualTransformation = if(isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            maxLines = 1,
            singleLine = true
        ) {
            innerTextField ->
            if (value.isEmpty()) {
                Text(placeHolder, style = MaterialTheme.typography.bodyMedium, color = Gray4)
            }
            innerTextField()
        }
    }
}

@Composable
fun SearchTextField(value: String, placeHolder: String, onValueChange: (String) -> Unit ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Gray1,
                shape = RoundedCornerShape(10.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(painterResource(R.drawable.search),"search",
            modifier = Modifier.padding(start = 15.dp),
            tint = MaterialTheme.colorScheme.surfaceVariant)
        BasicTextField(
            modifier = Modifier.fillMaxWidth().padding(
                start = 15.dp,
                top = 14.dp,
                bottom = 14.dp,
                end = 20.dp
            ), value = value, onValueChange = { onValueChange(it) },
            textStyle = TextStyle(fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                color = MaterialTheme.colorScheme.onBackground
            ),
            maxLines = 1,
            singleLine = true
        ) {
                innerTextField ->

            if (value.isEmpty()) {
                Text(placeHolder, style = MaterialTheme.typography.bodyMedium, color = Gray4)
            }
            innerTextField()
        }
    }
}

@Composable
fun CommonTextFieldMemo(value: String, placeHolder: String,color: Color, isPassword:Boolean, onValueChange: (String) -> Unit ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp, color = if (value.isEmpty()) {
                    Gray4
                } else {
                    color
                }, shape = RoundedCornerShape(10.dp)
            )
    ) {
        BasicTextField(
            modifier = Modifier.fillMaxHeight().padding(
                start = 20.dp,
                top = 19.dp,
                bottom = 19.dp,
                end = 20.dp
            ), value = value, onValueChange = { onValueChange(it) },
            textStyle = TextStyle(fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                color = MaterialTheme.colorScheme.onBackground
            ),
            visualTransformation = if(isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        ) {
                innerTextField ->
            if (value.isEmpty()) {
                Text(placeHolder, style = MaterialTheme.typography.bodyMedium, color = Gray4)
            }
            innerTextField()
        }
    }
}


@Composable
fun CommonTextFieldOnlyBirth(value: TextFieldValue, placeHolder: String, color: Color, onValueChange: (TextFieldValue) -> Unit ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp, color = if (value.text.isEmpty()) {
                    Gray4
                } else {
                    color
                }, shape = RoundedCornerShape(10.dp)
            )
    ) {
        BasicTextField(
            modifier = Modifier.padding(
                start = 20.dp,
                top = 19.dp,
                bottom = 19.dp,
                end = 20.dp
            ), value = value, onValueChange = {
                val text = formatTextFieldValue(it.text)
                onValueChange(it.copy(text = text,
                    selection = TextRange(text.length)))

                                              },
            textStyle = TextStyle(fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                color = MaterialTheme.colorScheme.onBackground
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        ) {
                innerTextField ->
            if (value.text.isEmpty()) {
                Text(placeHolder, style = MaterialTheme.typography.bodyMedium, color = Gray4)
            }
            innerTextField()
        }
    }
}
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun TextFieldPreview() {
    BebechoTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            SearchTextField("faf","검색어를 입력해주세요.",){

            }
        }

    }
}
private fun signUpBirthFormating(birth: String):String{
    val builder = StringBuilder(birth)
    if(builder.length > 4){
        builder.insert(4,"-")
    }
    if(builder.length > 7){
        builder.insert(7,"-")
    }

    return builder.toString()
}
fun formatTextFieldValue(input: String): String {
    val digits = input.filter { it.isDigit() } // 숫자만 추출
    val formatted = buildString {
        for (i in digits.indices) {
            if (i == 4 || i == 6) { // 4번째와 6번째 문자 뒤에 하이픈 추가
                append("-")
            }
            append(digits[i])

        }
    }.take(10) // 최대 길이 10으로 제한
    return formatted
}
