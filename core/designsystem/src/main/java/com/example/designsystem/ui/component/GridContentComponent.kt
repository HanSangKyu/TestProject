package com.example.designsystem.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.designsystem.ui.theme.BannerCountBox
import com.example.designsystem.ui.theme.LocalTypography
import com.example.designsystem.ui.theme.White
import com.example.model.Banner
import com.example.model.Goods


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GridContentComponent(goods: List<Goods>,onNavigateToDetailScreen: (String) -> Unit) {

    val numberOfColumns = 3 // 그리드의 열 수
    val rows = goods.chunked(numberOfColumns) // 데이터 리스트를 열 수에 맞게 나눔

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        rows.forEach { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),

            ) {
                rowItems.forEach { item ->
                    Box(
                        modifier = Modifier
                            .weight(1f) // 각 아이템이 동일한 크기로 차지하도록 설정
                            .wrapContentHeight().clickable {
                                onNavigateToDetailScreen(item.linkURL)
                            },
                        contentAlignment = Alignment.Center // 중앙 정렬
                    ) {
                        ProductComponent(item)
                    }
                }

                // 남은 칸을 채우기 위해 빈 박스를 추가
                if (rowItems.size < numberOfColumns) {
                    repeat(numberOfColumns - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f)) // 빈 공간을 동일한 비율로 채움
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp)) // 행 간의 간격 추가
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridContentComponent() {
//    GridContentComponent(Banner(title = "타이틀", thumbnailURL = "https://example.com/image.jpg", description = "요약"),1,5) // 5회 방문 예시
}
