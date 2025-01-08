        package kr.co.eoasis.bebecho.util.component

        import androidx.compose.animation.animateColorAsState
        import androidx.compose.foundation.BorderStroke
        import androidx.compose.foundation.layout.Column
        import androidx.compose.foundation.layout.PaddingValues
        import androidx.compose.foundation.layout.Row
        import androidx.compose.foundation.layout.defaultMinSize
        import androidx.compose.foundation.layout.fillMaxSize
        import androidx.compose.foundation.layout.fillMaxWidth
        import androidx.compose.foundation.layout.height
        import androidx.compose.foundation.layout.width
        import androidx.compose.foundation.shape.RoundedCornerShape
        import androidx.compose.material3.Button
        import androidx.compose.material3.ButtonColors
        import androidx.compose.material3.Icon
        import androidx.compose.material3.MaterialTheme
        import androidx.compose.material3.Text
        import androidx.compose.runtime.Composable
        import androidx.compose.runtime.getValue
        import androidx.compose.ui.Alignment
        import androidx.compose.ui.Modifier
        import androidx.compose.ui.graphics.Color
        import androidx.compose.ui.graphics.painter.Painter
        import androidx.compose.ui.res.painterResource
        import androidx.compose.ui.tooling.preview.Preview
        import androidx.compose.ui.unit.TextUnit
        import androidx.compose.ui.unit.dp
        import androidx.compose.ui.unit.sp
        import kr.co.eoasis.bebecho.R
        import kr.co.eoasis.bebecho.ui.theme.BebechoTheme
        import kr.co.eoasis.bebecho.ui.theme.PANTONE1785C
        import kr.co.eoasis.bebecho.ui.theme.Transparent


        enum class ButtonFont {
            POPPINS,
            WANTED,

        }

        @Composable
        fun CommonOutLineButton(text: String, font: ButtonFont, enabled: Boolean, onClick: () -> Unit) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 19.dp),
                onClick = { onClick() },
                enabled = enabled,
                border = BorderStroke(1.dp, color =  MaterialTheme.colorScheme.primary,),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.background,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = text,
                    modifier = Modifier,
                    style = if (font == ButtonFont.POPPINS) {
                        MaterialTheme.typography.bodyMedium
                    } else {
                        MaterialTheme.typography.titleSmall
                    },
                    fontSize = 18.sp,
                )
            }
        }

        @Composable
        fun CommonButton(text: String, font: ButtonFont, enabled: Boolean, fontSize: TextUnit, onClick: () -> Unit) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 19.dp),
                onClick = { onClick() },
                enabled = enabled,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = text,
                    modifier = Modifier,
                    style = if (font == ButtonFont.POPPINS) {
                        MaterialTheme.typography.bodyMedium
                    } else {
                        MaterialTheme.typography.titleSmall
                    },
                    fontSize = fontSize,
                )
            }
        }


        @Composable
        fun redCommonButton(text: String, font: ButtonFont, enabled: Boolean, fontSize: TextUnit, onClick: () -> Unit) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 19.dp),
                onClick = { onClick() },
                enabled = enabled,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = text,
                    modifier = Modifier,
                    style = if (font == ButtonFont.POPPINS) {
                        MaterialTheme.typography.bodyMedium
                    } else {
                        MaterialTheme.typography.titleSmall
                    },
                    fontSize = fontSize,
                )
            }
        }


        @Composable
        fun ConnectButton(text: String = "연결", font: ButtonFont = ButtonFont.WANTED, enabled: Boolean = true, onClick: () -> Unit){
            Button(
                modifier = Modifier.defaultMinSize(1.dp, 1.dp).height(26.dp).width(60.dp),
                contentPadding = PaddingValues(1.dp,1.dp),

                onClick = { onClick() },
                enabled = enabled,
                border = BorderStroke(1.dp, color =  MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(13.dp),
                colors = ButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.background,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = text,
                    modifier = Modifier,
                    style = if (font == ButtonFont.POPPINS) {
                        MaterialTheme.typography.bodyMedium
                    } else {
                        MaterialTheme.typography.titleSmall
                    },
                    fontSize = 10.sp,
                )
            }
        }

        @Composable
        fun ColorOutLineButton(
            text: String,
            font: ButtonFont,
            enabled: Boolean,
            contentColor: Color,
            fontSize: TextUnit,
            onClick: () -> Unit
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {onClick()},
                enabled = enabled,
                contentPadding = PaddingValues(vertical = 19.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, contentColor),
                colors = ButtonColors(
                    contentColor = contentColor,
                    containerColor = Transparent,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = Transparent
                )
            ) {
                Text(
                    text = text,
                    modifier = Modifier,
                    style = if (font == ButtonFont.POPPINS) {
                        MaterialTheme.typography.bodyMedium
                    } else {
                        MaterialTheme.typography.titleSmall
                    },
                    fontSize = fontSize,
                )
            }
        }

        @Composable
        fun CommonToggleButton(
            text: String,
            value: Boolean,
            font: ButtonFont,
            enabled: Boolean,
            contentColor: Color,
            onClick: () -> Unit
        ) {
            val backgroundColor by animateColorAsState(
                targetValue = if (value) {
                    contentColor
                } else {
                    MaterialTheme.colorScheme.background
                }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onClick() },
                enabled = enabled,
                contentPadding = PaddingValues(vertical = 19.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    1.dp, if (value) {
                        contentColor
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    }
                ),
                colors = ButtonColors(
                    contentColor = if (value) {
                        MaterialTheme.colorScheme.onBackground
                    } else MaterialTheme.colorScheme.surfaceVariant,
                    containerColor = backgroundColor,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(
                    text = text,
                    modifier = Modifier,
                    style = if (font == ButtonFont.POPPINS) {
                        MaterialTheme.typography.bodyMedium
                    } else {
                        MaterialTheme.typography.titleSmall
                    },
                    fontSize = 14.sp,
                )
            }

        }


        @Preview
        @Composable
        fun ButtonPreview() {
            BebechoTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    ColorOutLineButton("",ButtonFont.WANTED, true, MaterialTheme.colorScheme.primary, 16.sp) {
                    }
                }
            }
        }

        @Composable
        fun PlayButton(isPlay : Boolean ,onClick : () -> Unit ){
            Button(modifier = Modifier.fillMaxWidth().height(60.dp), onClick = {
                onClick()
            },
                colors = ButtonColors(
                    contentColor = MaterialTheme.colorScheme.background,
                    containerColor = PANTONE1785C,
                    disabledContentColor = MaterialTheme.colorScheme.background,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                ),
                shape = RoundedCornerShape(10.dp)

                ) {
                Icon(painter =
                if(!isPlay){
                    painterResource(R.drawable.play)
                }else{
                    painterResource(R.drawable.pause)
                },
                    contentDescription = "play")

            }
        }
        @Composable
        fun CommonIconButton(text: String, painter:Painter, font: ButtonFont, enabled: Boolean, fontSize: TextUnit, onClick: () -> Unit) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 19.dp),
                onClick = { onClick() },
                enabled = enabled,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(painter = painter, contentDescription = text)
                    Text(
                        text = text,
                        modifier = Modifier,
                        style = if (font == ButtonFont.POPPINS) {
                            MaterialTheme.typography.bodyMedium
                        } else {
                            MaterialTheme.typography.titleSmall
                        },
                        fontSize = fontSize,
                    )
                }
            }
        }



        @Preview
        @Composable
        fun ToggleButtonPreview() {
            BebechoTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    PlayButton(false,{})
                }
            }
        }


