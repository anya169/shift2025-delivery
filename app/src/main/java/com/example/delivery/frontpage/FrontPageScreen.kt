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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
fun FrontPageScreen(navController: NavController) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text ="Мы доставим ваш заказ", fontSize = 28.sp, fontWeight = FontWeight(700),
                style = TextStyle(lineHeight = 36.sp), fontFamily = FontFamily(Font(R.font.inter)),
                color = Color.Black, modifier = Modifier.padding(
                    start = 16.dp,
                    top = 32.dp,
                    end = 42.dp))
            Text(
                text ="Отправляйте посылки в Шифт Delivery", fontSize = 16.sp, fontWeight = FontWeight(300),
                style = TextStyle(lineHeight = 24.sp), fontFamily = FontFamily(Font(R.font.inter)),
                color = Color.Gray, modifier = Modifier.padding(
                    start = 16.dp,
                    top = 8.dp))
            Box(
                //белая рамка
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.package_open),
                        contentDescription = "Голубая открытая коробка",
                        modifier = Modifier.size(56.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.qr),
                        contentDescription = "QR code",
                        modifier = Modifier.size(56.dp)
                    )

                    Text(text = "Наведите камеру " +
                            "телефона на QR‑код",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        style = TextStyle(lineHeight = 20.sp),
                        color = Color.Gray,
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
                    .fillMaxWidth()
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
                    Card("Город отправления", "Москва", "Санкт-Петербург")
                    Card("Город назначения", "Санкт-Петербург", "Москва")
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
                        Image(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Письмо",
                            modifier = Modifier.size(20.dp).offset(x = 4.dp, y = 8.dp)
                        )
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
                        Image(
                            painter = painterResource(id = R.drawable.chevron),
                            contentDescription = "Галочка",
                            modifier = Modifier.size(20.dp).offset(x = 220.dp, y = 8.dp)
                        )

                    }
                    BlueButton(text = "Рассчитать", onClick = {

                    })
                }
            }
}
   }

