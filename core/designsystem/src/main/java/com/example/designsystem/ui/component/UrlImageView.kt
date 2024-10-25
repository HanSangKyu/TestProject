package com.example.designsystem.ui.component

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UrlImageView(url: String) {
    GlideImage(
        model = url, // 이미지 URL 설정
        contentDescription = null,
        modifier = Modifier
            .wrapContentWidth() // 가로 크기를 꽉 채움
            .wrapContentHeight(), // 세로 크기는 이미지 비율에 맞게
        contentScale = ContentScale.Crop // 이미지를 가로에 맞춰 조정, 세로는 비율에 맞게
    )
}



@Preview(showBackground = true)
@Composable
fun UrlImageViewPreview() {
    UrlImageView("") // 5회 방문 예시
}
