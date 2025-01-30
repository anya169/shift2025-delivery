package com.example.delivery.frontpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.example.delivery.R

@Composable
fun SetText(text: String, size: Int, weight: Int, height: Int, start: Int, top: Int, end: Int, bottom: Int, red: Int, green: Int, black: Int) {
    Text(text = text,
        fontSize = size.sp,
        fontFamily = FontFamily(Font(R.font.inter)),
        fontWeight = FontWeight(weight),
        style = TextStyle(lineHeight = height.sp),
        color = Color(red, green, black),
        modifier = Modifier
            .padding(
                start = start.dp,
                top = top.dp,
                end = end.dp,
                bottom = bottom.dp)
    )
}

@Composable
fun PackageSvg(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.package_open),
        contentDescription = "Голубая открытая коробка",
        modifier = modifier
    )
}
@Composable
fun QR(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.qr),
        contentDescription = "QR code",
        modifier = modifier
    )
}
@Composable
fun City(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.city),
        contentDescription = "Иконка города",
        modifier = modifier
    )
}

@Composable
fun Chevron(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.chevron),
        contentDescription = "Галочка",
        modifier = modifier
    )
}

@Composable
fun Email(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.email),
        contentDescription = "Письмо",
        modifier = modifier
    )
}

@Composable
fun BlueButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(25, 117, 255),
            contentColor = Color(255, 255, 255)
        ),
        modifier = Modifier.padding(24.dp).size(250.dp, 56.dp)
    ) {
        Text(text = text,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(600),
            style = TextStyle(lineHeight = 24.sp),
            color = Color(255, 255, 255),
        )

    }
}


@Composable
fun FrontPageScreen(navController: NavController) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetText(
                "Мы доставим ваш заказ",
                28,
                700,
                36,
                16,
                48,
                46,
                0,
                20, 28, 36
            )
            SetText(
                "Отправляйте посылки в приложении Шифт Delivery",
                16,
                300,
                24,
                16,
                8,
                0,
                0,
                99, 112, 131
            )
            Box(
                //белая рамка
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(328.dp, 88.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(255, 255, 255)),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(10.dp)
                ) {
                    PackageSvg(modifier = Modifier.size(56.dp))

                    QR(modifier = Modifier.size(56.dp))

                    Text(text = "Наведите камеру " +
                            "телефона на QR‑код",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        style = TextStyle(lineHeight = 20.sp),
                        color = Color(99, 112, 131),
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                top = 0.dp)
                    )
                }
            }
            Box(
                //белая рамка
                modifier = Modifier
                    .size(328.dp, 530.dp)
                    .padding(24.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(255, 255, 255)),
            ) {
                Column(

                ) {
                    Text(
                        text = "Рассчитать доставку",
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        style = TextStyle(lineHeight = 32.sp),
                        color = Color(20, 28, 36),
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                top = 24.dp
                            )
                    )
                    Text(
                        text = "Город отправки",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        style = TextStyle(lineHeight = 32.sp),
                        color = Color(20, 28, 36),
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                top = 24.dp,
                                bottom = 6.dp
                            )
                    )
                    Box(
                        //серая рамка города

                        modifier = Modifier
                            .padding(
                                start = 14.dp,
                                top = 6.dp,
                            )
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color(151, 161, 175))
                            .size(250.dp, 40.dp)
                            .clickable {
                                navController.navigate(CitiesRoute)
                            }
                    ) {
                        City(modifier = Modifier.size(20.dp).offset(x = 4.dp, y = 8.dp))
                        Text(
                            text = "Москва",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp),
                            color = Color(52, 64, 81),
                            modifier = Modifier
                                .padding(
                                    start = 25.dp,
                                    top = 8.dp,
                                    bottom = 0.dp
                                )
                        )
                        Chevron(modifier = Modifier.size(20.dp).offset(x = 220.dp, y = 8.dp))

                    }
                    Row{
                        Text(
                            text = "Санкт-Петербург",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp, textDecoration = TextDecoration.Underline),
                            color = Color(99, 112, 131),
                            modifier = Modifier
                                .padding(
                                    start = 14.dp,
                                    top = 4.dp,
                                )
                        )
                        Text(
                            text = "Новосибирск",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp, textDecoration = TextDecoration.Underline),
                            color = Color(99, 112, 131),
                            modifier = Modifier
                                .padding(
                                    start = 14.dp,
                                    top = 4.dp,
                                )
                        )
                        Text(
                            text = "Томск",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp, textDecoration = TextDecoration.Underline),
                            color = Color(99, 112, 131),
                            modifier = Modifier
                                .padding(
                                    start = 14.dp,
                                    top = 4.dp,
                                )
                        )
                    }
                    Text(
                        text = "Город назначения",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        style = TextStyle(lineHeight = 32.sp),
                        color = Color(20, 28, 36),
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                top = 24.dp,
                                bottom = 6.dp
                            )
                    )
                    Box(
                        //серая рамка города

                        modifier = Modifier
                            .padding(
                                start = 14.dp,
                                top = 6.dp,
                            )
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color(151, 161, 175))
                            .size(250.dp, 40.dp)
                            .clickable {
                                navController.navigate(CitiesRoute)
                            }
                    ) {
                        City(modifier = Modifier.size(20.dp).offset(x = 4.dp, y = 8.dp))
                        Text(
                            text = "Санкт-Петербург",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp),
                            color = Color(52, 64, 81),
                            modifier = Modifier
                                .padding(
                                    start = 25.dp,
                                    top = 8.dp,
                                    bottom = 0.dp
                                )
                        )
                        Chevron(modifier = Modifier.size(20.dp).offset(x = 220.dp, y = 8.dp))

                    }
                    Row{
                        Text(
                            text = "Новосибирск",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp, textDecoration = TextDecoration.Underline),
                            color = Color(99, 112, 131),
                            modifier = Modifier
                                .padding(
                                    start = 14.dp,
                                    top = 4.dp,
                                )
                        )
                        Text(
                            text = "Москва",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp, textDecoration = TextDecoration.Underline),
                            color = Color(99, 112, 131),
                            modifier = Modifier
                                .padding(
                                    start = 14.dp,
                                    top = 4.dp,
                                )
                        )
                        Text(
                            text = "Томск",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp, textDecoration = TextDecoration.Underline),
                            color = Color(99, 112, 131),
                            modifier = Modifier
                                .padding(
                                    start = 14.dp,
                                    top = 4.dp,
                                )
                        )
                    }
                    Text(
                        text = "Размер посылки",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        style = TextStyle(lineHeight = 32.sp),
                        color = Color(20, 28, 36),
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                top = 24.dp,
                                bottom = 6.dp
                            )
                    )
                    Box(
                        //серая рамка

                        modifier = Modifier
                            .padding(
                                start = 14.dp,
                                top = 6.dp,
                            )
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color(151, 161, 175))
                            .size(250.dp, 40.dp)
                            .clickable {
                                navController.navigate(PostTypesRoute)
                            }
                    ) {
                        Email(modifier = Modifier.size(20.dp).offset(x = 4.dp, y = 8.dp))
                        Text(
                            text = "Конверт",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            style = TextStyle(lineHeight = 24.sp),
                            color = Color(52, 64, 81),
                            modifier = Modifier
                                .padding(
                                    start = 25.dp,
                                    top = 8.dp,
                                    bottom = 0.dp
                                )
                        )
                        Chevron(modifier = Modifier.size(20.dp).offset(x = 220.dp, y = 8.dp))

                    }
                    BlueButton(text = "Рассчитать", onClick = {

                    })
                }
            }
}
   }

