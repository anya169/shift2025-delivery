package com.example.delivery.frontpage

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.R

@Composable
fun BlueButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        ),
        modifier = Modifier.padding(24.dp).size(250.dp, 56.dp)
    ) {
        Text(text = text,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(600),
            style = TextStyle(lineHeight = 24.sp),
            color = Color.White,
        )

    }
}