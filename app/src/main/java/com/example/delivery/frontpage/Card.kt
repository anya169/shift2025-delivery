package com.example.delivery.frontpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.R

@Composable
fun Card(title: String, city: String, city2: String){
    Text(
        text = title,
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter)),
        fontWeight = FontWeight(700),
        style = TextStyle(lineHeight = 32.sp),
        color = Color.Black,
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
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable {
                navController.navigate(CitiesRoute)
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.city),
            contentDescription = "Иконка города",
            modifier = Modifier.size(20.dp).offset(x = 4.dp, y = 8.dp)
        )
        Text(
            text = city,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(400),
            style = TextStyle(lineHeight = 24.sp),
            color = Color.DarkGray,
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
    Row{
        Text(
            text = city2,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(400),
            style = TextStyle(lineHeight = 24.sp, textDecoration = TextDecoration.Underline),
            color = Color.Gray,
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
            color = Color.Gray,
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
            color = Color.Gray,
            modifier = Modifier
                .padding(
                    start = 14.dp,
                    top = 4.dp,
                )
        )
    }
}