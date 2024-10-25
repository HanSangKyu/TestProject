package com.example.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.airbnb.mvrx.hellohilt.ProductMavericksViewModel
import com.example.designsystem.ui.component.AppBar
import com.example.designsystem.ui.component.BannerContentComponent
import com.example.designsystem.ui.component.FooterComponent
import com.example.designsystem.ui.component.GridContentComponent
import com.example.designsystem.ui.component.HeaderComponent
import com.example.designsystem.ui.component.ScrollContentComponent
import com.example.designsystem.ui.component.StyleComponent
import com.example.designsystem.ui.theme.Black01
import com.example.designsystem.ui.theme.ColorMainBlue500
import com.example.designsystem.ui.theme.Divider
import com.example.designsystem.ui.theme.LocalTypography
import com.example.designsystem.ui.theme.MusinsaTheme
import com.example.designsystem.ui.theme.White
import com.example.designsystem.ui.theme.myColorScheme
import com.example.feature.main.R
import com.example.main.model.MusinsaUiState
import com.example.model.ProductList
import com.example.model.type.ContentType
import com.example.model.type.FooterType

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    productMavericksViewModel: ProductMavericksViewModel = mavericksViewModel(),
    onNavigateToDetailScreen: (String) -> Unit
) {


    val musinsaData by viewModel.musinsaData.collectAsStateWithLifecycle()
    val status by productMavericksViewModel.collectAsState()

    LaunchedEffect(musinsaData) {
        when (musinsaData) {
            is MusinsaUiState.Loading -> {
                productMavericksViewModel.setData(null)
            }

            is MusinsaUiState.Success -> {
                (musinsaData as MusinsaUiState.Success).data.let { data ->
                    productMavericksViewModel.setData(data)
                }
            }

            is MusinsaUiState.Error -> {
                productMavericksViewModel.setData(ProductList(arrayListOf()))
            }
        }
    }


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
                viewModel = viewModel,
                status.posts!!,
                onNavigateToDetailScreen = onNavigateToDetailScreen
            )
        }
    }


}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    productList: ProductList?,
    onNavigateToDetailScreen: (String) -> Unit
) {

    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(id = R.string.app_name)
            )
        },
        content = { padding ->


            productList?.let { response ->

                if (response.data.isNullOrEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(White),
                        contentAlignment = Alignment.Center // Box의 contentAlignment 설정
                    ) {
                        Column(
                            modifier = Modifier.wrapContentSize() // Column의 크기는 wrapContentSize로 유지
                        ) {
                            Text(
                                text = "데이터를 불러오지 못했습니다.",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.size(10.dp))
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                                    .border(1.dp, Divider, shape = RoundedCornerShape(20.dp)),
                                onClick = { viewModel.getReservationStatus() },
                                colors = ButtonDefaults.buttonColors(White, ColorMainBlue500),
                                contentPadding = PaddingValues(0.dp),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Text("재시도", color = Black01, style = LocalTypography.current.button)
                            }
                        }
                    }
                    return@let
                }
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
                              FooterType.MORE -> {
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

                                FooterType.REFRESH -> {
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
        viewModel = hiltViewModel(),
        productList = null,
        onNavigateToDetailScreen = {}
    )
}
