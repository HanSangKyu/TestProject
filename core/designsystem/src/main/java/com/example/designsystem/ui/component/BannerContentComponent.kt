package com.example.designsystem.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.ui.theme.BannerCountBox
import com.example.model.Banner
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@Composable
fun BannerContentComponent(banners: List<Banner>,    onNavigateToDetailScreen: (String) -> Unit = {}
) {
    val size = banners?.size ?: 0
    val pagerState = rememberPagerState(pageCount = { size })

    LaunchedEffect(pagerState) {
        while (true) {
            yield()
            delay(3000L)
            val nextPage =
                (pagerState.currentPage + 1) % (pagerState.pageCount)
            pagerState.animateScrollToPage(nextPage)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),// TopBar 높이 설정
        ) { pageIndex ->
            val banner =banners?.get(pageIndex)
            banner?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clickable { onNavigateToDetailScreen(it.linkURL) }
                ) {
                    BannerBox(
                        banner = it,
                        currentPage = pageIndex,
                        totalPages = size
                    )
                }

            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd) // 하단 정렬
                .padding(bottom = 5.dp), // 하단에서 50dp 위로 패딩
            horizontalAlignment = Alignment.End
        ) {
            // 텍스트 박스
            Text(
                text = "${pagerState.currentPage + 1} / ${pagerState.pageCount}",
                fontSize = 14.sp,
                color = Color.White, // 글자 색은 흰색으로
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 3.dp) // 바깥쪽 여백
                    .background(
                        color =  BannerCountBox, // 배경색 빨간색
                        shape = RoundedCornerShape(8.dp) // 둥근 모서리 적용 (8dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp) // 텍스트 내부 패딩
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BannerContentComponentPreview() {
   BannerContentComponent(arrayListOf(),{}) // 5회 방문 예시
}
