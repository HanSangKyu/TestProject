package com.example.designsystem.ui.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.model.Style


@Composable
fun StyleComponent(styleList: List<Style>, onNavigateToDetailScreen: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        for (rowIndex in 0 until (styleList.size + 2) / 3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(if (rowIndex == 0) 300.dp else 150.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                when (rowIndex) {
                    0 -> {
                        Box(
                            modifier = Modifier
                                .weight(2f) // 2열 차지
                                .fillMaxHeight()
                                .clickable {
                                    Log.i("test", "click= ${styleList[0].linkURL}")

                                    onNavigateToDetailScreen(styleList[0].linkURL)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            UrlImageView(styleList[0].thumbnailURL)
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            repeat(2) { index ->
                                val itemIndex = index + 1
                                if (itemIndex < styleList.size) {
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxSize()
                                            .clickable {
                                                Log.i("test", "click= ${styleList[0].linkURL}")
                                                onNavigateToDetailScreen(styleList[itemIndex].linkURL)
                                                       },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        UrlImageView(styleList[itemIndex].thumbnailURL)
                                    }
                                } else {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }

                    else -> {
                        val offset = 3 + (rowIndex - 1) * 3
                        repeat(3) { index ->
                            val itemIndex = offset + index
                            if (itemIndex < styleList.size) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight()
                                        .clickable {
                                            Log.i("test", "click= ${styleList[itemIndex].linkURL}")
                                            onNavigateToDetailScreen(styleList[itemIndex].linkURL)

                                                   },
                                    contentAlignment = Alignment.Center
                                ) {
                                    UrlImageView(styleList[itemIndex].thumbnailURL)
                                }
                            } else {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

            if (rowIndex < 2) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StyleComponent() {
    StyleComponent(arrayListOf(),{})
}
