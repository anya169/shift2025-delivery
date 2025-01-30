package com.example.delivery.posttypes


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.delivery.data.PostTypeItem


@Composable
fun ContentComponent(
    postTypes: List<PostTypeItem>,
    onItemClicked: (postTypeId: Long) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(postTypes) { postType ->
            PostTypeItem(
                postType,
                onItemClicked = { onItemClicked(postType.id) },
            )
        }
    }
}

@Composable
private fun PostTypeItem(
    item: PostTypeItem,
    onItemClicked: () -> Unit,

) {
    Column (
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClicked)
    ) {
        val dimensions: String = "${item.length}x${item.width}x${item.height}"
        Text(
            text = "${item.name}, $dimensions",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(400),
            style = TextStyle(lineHeight = 24.sp),
            color = Color(52, 64, 81),
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                )
        )
    }
}
