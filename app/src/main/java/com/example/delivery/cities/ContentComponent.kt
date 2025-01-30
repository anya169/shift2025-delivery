package com.example.delivery.cities

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.R
import com.example.delivery.data.CityItem


@Composable
fun Arrow(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.arrow),
        contentDescription = "Галочка",
        modifier = modifier
    )
}

@Composable
fun ContentComponent(
    cities: List<CityItem>,
    onItemClicked: (cityId: Long) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(cities) { city ->
            CityItem(
                city,
                onItemClicked = { onItemClicked(city.id) },
            )
        }
    }
}

@Composable
private fun CityItem(
    item: CityItem,
    onItemClicked: () -> Unit,

    ) {
    Column (
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClicked)
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "${item.name}",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(400),
                style = TextStyle(lineHeight = 24.sp),
                color = Color(20, 28, 36),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                    )
            )
            Arrow(modifier = Modifier.size(20.dp))
        }

    }
}