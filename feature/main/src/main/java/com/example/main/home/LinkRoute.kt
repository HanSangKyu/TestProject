package com.example.main.home

import android.graphics.Bitmap
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.airbnb.mvrx.hellohilt.ProductMavericksViewModel
import com.example.designsystem.ui.theme.MusinsaTheme
import com.example.designsystem.ui.theme.myColorScheme
import com.example.main.model.MusinsaUiState

@Composable
internal fun LinkRoute(
    viewModel2: ProductMavericksViewModel = mavericksViewModel(),
    onBack: () -> Unit
) {
    val status by viewModel2.collectAsState()
    when (status.link) {
        null -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MusinsaTheme.myColorScheme.backgroundLight)
            ) {
                Text(
                    text = "Loading...",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        else -> {

            WebViewScreen(
                status.link,
                onBack = onBack
            )
        }
    }


}

@Composable
fun WebViewScreen(
    link: String,
    onBack: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true

                    webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                            return false
                        }

                        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                            super.onPageStarted(view, url, favicon)
                        }

                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                        }
                    }

                    loadUrl(link) // 초기 URL 로드
                }
            },
            update = { webView ->
                webView.loadUrl(link) // URL 업데이트 시 처리
            },
            modifier = Modifier.fillMaxSize()
        )

    }
}



@Preview
@Composable
fun WebViewScreenPreview(
    @PreviewParameter(MusinsaUiStatePreviewParameterProvider::class)
    reservationsUiState: MusinsaUiState
) {
//    WebViewScreen(
//        response = null,
//    )
}
