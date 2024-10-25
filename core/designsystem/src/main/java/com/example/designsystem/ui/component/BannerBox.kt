package com.example.designsystem.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.designsystem.ui.theme.LocalTypography
import com.example.designsystem.ui.theme.White
import com.example.model.Banner


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BannerBox(banner: Banner, currentPage: Int, totalPages: Int) {

    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        GlideImage(
            model = banner.thumbnailURL,  // 이미지 URL 또는 로컬 리소스
            contentDescription = banner.description,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop, // 이미지를 잘라서 보여줌
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // 하단 정렬
                .padding(bottom = 50.dp), // 하단에서 50dp 위로 패딩
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 타이틀과 서브 타이틀
            Text(
                text = banner.title,
                style = LocalTypography.current.titleBold,
                color = White
            )
            Text(
                text = banner.description,
                style = LocalTypography.current.descriptionMedium,
                color = White
            )

            Spacer(modifier = Modifier.height(8.dp))
        }


    }
}

@Preview(showBackground = true)
@Composable
fun BannerCardPreview() {
    BannerBox(Banner(title = "타이틀", thumbnailURL = "https://example.com/image.jpg", description = "요약"),1,5) // 5회 방문 예시
}
