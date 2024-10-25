package com.example.designsystem.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.designsystem.ui.theme.White


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HeaderComponent(
    title: String,
    iconUrl: String?,
    linkURL: String?,
    onNavigateToDetailScreen: (String) -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .align(Alignment.CenterStart),  // 수평적으로 시작점에 정렬
            verticalArrangement = Arrangement.Center,  // 수직적으로 가운데 정렬
            horizontalAlignment = Alignment.Start      // 아이템을 수평적으로 시작점에 맞춤
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // 텍스트 설정
                        Text(
                            text = title,
                            maxLines = 1, // 한 줄로 제한
                            overflow = TextOverflow.Ellipsis, // 말줄임표로 표시
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier.weight(1f, fill = false) // 텍스트가 공간을 필요할 때까지만 차지하게 함
                        )
                        if (iconUrl?.isNotEmpty() == true) {
                            Spacer(modifier = Modifier.width(8.dp)) // 텍스트와 아이콘 사이에
                            // 아이콘 설정
                            GlideImage(
                                model = iconUrl,  // 이미지 URL 또는 로컬 리소스
                                contentDescription = "",
                                modifier = Modifier
                                    .size(20.dp),
                                contentScale = ContentScale.Crop  // 이미지를 잘라서 보여줌
                            )
                        }
                    }
                }
                if (linkURL?.isNotEmpty() == true) {
                    Spacer(modifier = Modifier.width(10.dp)) // 텍스트와 아이콘 사이에
                    Column(
                        modifier = Modifier
                            .wrapContentWidth()
                            .clickable {
                                onNavigateToDetailScreen(linkURL)
                            }
                    ) {
                        Text(
                            text = "전체",
                            maxLines = 1, // 한 줄로 제한
                            overflow = TextOverflow.Ellipsis, // 말줄임표로 표시
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier.wrapContentWidth() // 텍스트가 공간을 필요할 때까지만 차지하게 함
                        )
                    }
                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun HeaderComponentPreview() {
    HeaderComponent("414324141234433144424241", "https://example.com/image.jpg", "요약") // 5회 방문 예시
}
