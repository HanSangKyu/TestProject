package com.example.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.airbnb.mvrx.hellohilt.ProductMavericksViewModel
import com.example.designsystem.ui.component.BannerContentComponent
import com.example.designsystem.ui.component.FooterComponent
import com.example.designsystem.ui.component.GridContentComponent
import com.example.designsystem.ui.component.HeaderComponent
import com.example.designsystem.ui.component.ScrollContentComponent
import com.example.designsystem.ui.component.StyleComponent
import com.example.designsystem.ui.theme.MusinsaTheme
import com.example.designsystem.ui.theme.White
import com.example.designsystem.ui.theme.myColorScheme
import com.example.feature.main.R
import com.example.main.model.MusinsaUiState
import com.example.model.ContentType
import com.example.model.Response

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    viewModel2: ProductMavericksViewModel = mavericksViewModel(),
    onNavigateToDetailScreen: (String) -> Unit
) {


    val selectedDate by viewModel.musinsaData.collectAsStateWithLifecycle()
    val status by viewModel2.collectAsState()
    selectedDate?.let { viewModel2.setData(it) }

    when (status.posts) {
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
            HomeScreen(
                status.posts!!,
                onNavigateToDetailScreen = onNavigateToDetailScreen
            )
        }
    }


}

@Composable
fun HomeScreen(
    response: Response?,
    onNavigateToDetailScreen: (String) -> Unit
) {

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }

        },
        content = { padding ->


            response?.let { response ->

                LazyColumn(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .background(White)

                ) {
                    items(response.data) { dataItem ->

                        dataItem.header?.let { header ->
                            HeaderComponent(
                                title = header.title,
                                iconUrl = header.iconURL,
                                linkURL = header.linkURL,
                                onNavigateToDetailScreen = onNavigateToDetailScreen
                            )
                        }
                        var goods by remember {
                            mutableStateOf(
                                dataItem.contents.goods ?: emptyList()
                            )
                        }
                        var pagerCount by remember { mutableStateOf(2) }

                        when (dataItem.contents.type) {
                            ContentType.BANNER -> {
//                             dataItem.contents.banners
                                BannerContentComponent(
                                    dataItem.contents.banners ?: emptyList(),
                                    onNavigateToDetailScreen
                                )

                            }

                            ContentType.GRID -> {
                                goods?.let {
                                    GridContentComponent(
                                        it.take(3 * pagerCount),
                                        onNavigateToDetailScreen
                                    )
                                }
                            }

                            ContentType.SCROLL -> {

                                ScrollContentComponent(
                                    goods?.take(3 * pagerCount) ?: emptyList(),
                                    onNavigateToDetailScreen
                                )

                            }

                            ContentType.STYLE -> {
                                StyleComponent(
                                    dataItem.contents.styles?.take((3 * pagerCount)) ?: emptyList(),
                                    onNavigateToDetailScreen
                                )
                            }
                        }

                        dataItem.footer?.let { foot ->
                            when (foot.type) {
                                com.example.model.FooterType.MORE -> {
                                    val goodsCount = dataItem.contents.goods?.size ?: 0
                                    val stylesCount = dataItem.contents.styles?.size ?: 0

                                    if (goodsCount > 3 * (pagerCount) || stylesCount > 3 * (pagerCount)
                                    ) {
                                        FooterComponent(
                                            foot, onClick = {
                                                pagerCount++
                                            }
                                        )
                                    }

                                }

                                com.example.model.FooterType.REFRESH -> {
                                    FooterComponent(
                                        foot, onClick = {
                                            goods = goods.shuffled()
                                        }
                                    )
                                }
                            }
                        }

                    }
                }

            }
        }
    )
}


@Preview
@Composable
fun HomeScreenPreview(
    @PreviewParameter(MusinsaUiStatePreviewParameterProvider::class)
    reservationsUiState: MusinsaUiState
) {
    HomeScreen(
        response = null,
        onNavigateToDetailScreen = {}
    )
}
