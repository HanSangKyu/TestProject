package com.example.main

import com.example.data.api.ProductApi
import com.example.data.repository.ProductRepositoryImpl
import com.example.model.ProductList
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class GetProductListTest {
    @get:Rule
    private val server = MockWebServer()
    private lateinit var repository: ProductRepositoryImpl
    private lateinit var mockedResponse: String

    @Before
    fun init() {
        server.start(8000)
        var BASE_URL = server.url("/").toString()
        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) // Only add this once
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(ProductApi::class.java)
        repository = ProductRepositoryImpl(service)
        mockedResponse="{\n" +
                "  \"data\": [\n" +
                "\t{\n" +
                "\t  \"contents\": {\n" +
                "\t\t\"type\": \"BANNER\",\n" +
                "\t\t\"banners\": [\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/campaign/index/junebeautyfull\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022061009432800000059650.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/22278\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062311154900000044053.jpg\",\n" +
                "\t\t\t\"title\": \"하이드아웃 S/S 시즌오프\",\n" +
                "\t\t\t\"description\": \"최대 30% 할인\",\n" +
                "\t\t\t\"keyword\": \"세일\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/22189\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062311154700000070083.jpg\",\n" +
                "\t\t\t\"title\": \"오끌레르 22 서머 컬렉션 발매\",\n" +
                "\t\t\t\"description\": \"최대 20% 할인\",\n" +
                "\t\t\t\"keyword\": \"발매\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/21902\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062211345700000040311.jpg\",\n" +
                "\t\t\t\"title\": \"COOL한 여름을 위한 냉감 아이템\",\n" +
                "\t\t\t\"description\": \"최대 54% 할인\",\n" +
                "\t\t\t\"keyword\": \"무신사 추천\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/campaign/index/mensformal_summer\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022061510152900000035673.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/22272\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062211292700000012174.jpg\",\n" +
                "\t\t\t\"title\": \"아모프레 22 핫 서머 인기상품\",\n" +
                "\t\t\t\"description\": \"단독 최대 10% 할인\",\n" +
                "\t\t\t\"keyword\": \"단독 세일\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/campaign/index/golf_summer_festival\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022061009431800000062033.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/22032\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062211271700000088225.jpg\",\n" +
                "\t\t\t\"title\": \"클로브 22 S/S 컬렉션\",\n" +
                "\t\t\t\"description\": \"5% 할인 + 10% 쿠폰\",\n" +
                "\t\t\t\"keyword\": \"세일\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/22274\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062211340400000015373.jpg\",\n" +
                "\t\t\t\"title\": \"에센셜 세트 아이템\",\n" +
                "\t\t\t\"description\": \"스컬프터, 노이아고 외 최대 60% 할인\",\n" +
                "\t\t\t\"keyword\": \"무신사 추천\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/22118\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062211292400000067119.jpg\",\n" +
                "\t\t\t\"title\": \"일꼬르소 22 바캉스 컬렉션\",\n" +
                "\t\t\t\"description\": \"한정 발매 및 단독 최대 27% 할인\",\n" +
                "\t\t\t\"keyword\": \"단독 세일\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2618624/0\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062311174100000002315.jpg\",\n" +
                "\t\t\t\"title\": \"예스아이씨 쿨맥스 티셔츠 한정 발매 \",\n" +
                "\t\t\t\"description\": \"블랙 & 화이트 2팩 구성 \",\n" +
                "\t\t\t\"keyword\": \"한정 발매\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/21507\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022061310200700000034341.jpg\",\n" +
                "\t\t\t\"title\": \"3만 원으로 일주일 살기\",\n" +
                "\t\t\t\"description\": \"스파 데이 최대 84% 할인\",\n" +
                "\t\t\t\"keyword\": \"단독 세일\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/content/s/event/muahin\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022061009272400000003644.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/campaign/index/outlet_clearance\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062210491700000041663.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/21923\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062211340100000039165.jpg\",\n" +
                "\t\t\t\"title\": \"네파 22 S/S 인기상품 할인\",\n" +
                "\t\t\t\"description\": \"자유시간 협업 상품 외 단독 최대 60% 할인\",\n" +
                "\t\t\t\"keyword\": \"단독 세일\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/21650\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062314140400000016694.jpg\",\n" +
                "\t\t\t\"title\": \"슬로우 레코드 하우스 22 S/S\",\n" +
                "\t\t\t\"description\": \"인플루언서 PICK 최대 20% 할인\",\n" +
                "\t\t\t\"keyword\": \"세일\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/campaign/index/2022_summer_shoes\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022061413563900000034077.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/campaign/index/boutiqueTVC\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022061009433100000021642.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/campaign/index/2022_package_setup\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062115154600000010868.jpg\",\n" +
                "\t\t\t\"title\": \"\",\n" +
                "\t\t\t\"description\": \"\",\n" +
                "\t\t\t\"keyword\": \"\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/plan/views/22293\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/event_banner/2022062215240900000026699.jpg\",\n" +
                "\t\t\t\"title\": \"NEW IN FASHION FOR WOMEN\",\n" +
                "\t\t\t\"description\": \"노이아고, 리올그, 엔오르 외 최대 40% 할인\",\n" +
                "\t\t\t\"keyword\": \"무신사 추천\"\n" +
                "\t\t  }\n" +
                "\t\t]\n" +
                "\t  }\n" +
                "\t},\n" +
                "\t{\n" +
                "\t  \"header\": {\n" +
                "\t\t\"title\": \"클리어런스\"\n" +
                "\t  },\n" +
                "\t  \"contents\": {\n" +
                "\t\t\"type\": \"GRID\",\n" +
                "\t\t\"goods\": [\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2281818\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"아스트랄 프로젝션\",\n" +
                "\t\t\t\"price\": 39900,\n" +
                "\t\t\t\"saleRate\": 50,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2281817\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211224/2281817/2281817_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"아스트랄 프로젝션\",\n" +
                "\t\t\t\"price\": 39900,\n" +
                "\t\t\t\"saleRate\": 45,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2281819\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211224/2281819/2281819_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"아스트랄 프로젝션\",\n" +
                "\t\t\t\"price\": 39900,\n" +
                "\t\t\t\"saleRate\": 65,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2281822\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211224/2281822/2281822_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"아스트랄 프로젝션\",\n" +
                "\t\t\t\"price\": 39900,\n" +
                "\t\t\t\"saleRate\": 75,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2281823\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211224/2281823/2281823_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"아스트랄 프로젝션\",\n" +
                "\t\t\t\"price\": 39900,\n" +
                "\t\t\t\"saleRate\": 35,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2281826\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211224/2281826/2281826_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"아스트랄 프로젝션\",\n" +
                "\t\t\t\"price\": 39900,\n" +
                "\t\t\t\"saleRate\": 73,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2280726\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211223/2280726/2280726_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"텐블레이드\",\n" +
                "\t\t\t\"price\": 14900,\n" +
                "\t\t\t\"saleRate\": 71,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2239335\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211118/2239335/2239335_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"텐블레이드\",\n" +
                "\t\t\t\"price\": 14900,\n" +
                "\t\t\t\"saleRate\": 81,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  }\n" +
                "\t\t]\n" +
                "\t  },\n" +
                "\t  \"footer\": {\n" +
                "\t\t\"type\": \"MORE\",\n" +
                "\t\t\"title\": \"더보기\"\n" +
                "\t  }\n" +
                "\t},\n" +
                "\t{\n" +
                "\t  \"header\": {\n" +
                "\t\t\"title\": \"디스커버리 익스페디션 인기 스니커즈: 최대 50% 할인\",\n" +
                "\t\t\"iconURL\": \"https://image.msscdn.net/icons/mobile/clock.png\",\n" +
                "\t\t\"linkURL\": \"https://www.musinsa.com/brands/discoveryexpedition?category3DepthCodes=&category2DepthCodes=&category1DepthCode=018&colorCodes=&startPrice=&endPrice=&exclusiveYn=&includeSoldOut=&saleGoods=&timeSale=&includeKeywords=&sortCode=discount_rate&tags=&page=1&size=90&listViewType=small&campaignCode=&groupSale=&outletGoods=false&boutiqueGoods=\"\n" +
                "\t  },\n" +
                "\t  \"contents\": {\n" +
                "\t\t\"type\": \"SCROLL\",\n" +
                "\t\t\"goods\": [\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1727824\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20201221/1727824/1727824_4_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 59500,\n" +
                "\t\t\t\"saleRate\": 50,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2309841\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20220117/2309841/2309841_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 68000,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2175693\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211013/2175693/2175693_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 132300,\n" +
                "\t\t\t\"saleRate\": 30,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1795481\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20210216/1795481/1795481_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 87200,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1363093\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20200323/1363093/1363093_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 111200,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1775655\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20210203/1775655/1775655_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 132300,\n" +
                "\t\t\t\"saleRate\": 30,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1938003\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20210506/1938003/1938003_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 68000,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1866270\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20210326/1866270/1866270_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 95200,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1938002\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20210506/1938002/1938002_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 68000,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1847062\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20210316/1847062/1847062_1_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 77400,\n" +
                "\t\t\t\"saleRate\": 40,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/1795479\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20210216/1795479/1795479_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 111200,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": false\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/goods/2269901\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.msscdn.net/images/goods_img/20211215/2269901/2269901_2_320.jpg\",\n" +
                "\t\t\t\"brandName\": \"디스커버리 익스페디션\",\n" +
                "\t\t\t\"price\": 95200,\n" +
                "\t\t\t\"saleRate\": 20,\n" +
                "\t\t\t\"hasCoupon\": true\n" +
                "\t\t  }\n" +
                "\t\t]\n" +
                "\t  },\n" +
                "\t  \"footer\": {\n" +
                "\t\t\"type\": \"REFRESH\",\n" +
                "\t\t\"title\": \"새로운 추천\",\n" +
                "\t\t\"iconURL\": \"https://image.msscdn.net/icons/mobile/clock.png\"\n" +
                "\t  }\n" +
                "\t},\n" +
                "\t{\n" +
                "\t  \"header\": {\n" +
                "\t\t\"title\": \"무신사 추천 코디\"\n" +
                "\t  },\n" +
                "\t  \"contents\": {\n" +
                "\t\t\"type\": \"STYLE\",\n" +
                "\t\t\"styles\": [\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27417\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214302100000008217.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27416\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214285200000072520.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27415\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214272200000056964.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27414\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214255500000030807.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27413\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214232800000082313.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27412\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214214600000026102.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27411\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214184600000046790.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27410\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214165600000031022.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27409\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214143800000054754.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/styles/views/27408\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/style/list/2022062214124200000032093.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17245\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062313485400000043032.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17244\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062313480100000030596.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17243\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062313464900000074853.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17242\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062313454400000075325.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17239\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062312234100000082540.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17238\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062312221300000016053.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17214\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062309475500000037425.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17237\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062312203900000001222.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17236\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062312194000000072470.jpg\"\n" +
                "\t\t  },\n" +
                "\t\t  {\n" +
                "\t\t\t\"linkURL\": \"https://www.musinsa.com/app/codimap/views/17235\",\n" +
                "\t\t\t\"thumbnailURL\": \"https://image.musinsa.com/images/codimap/list/2022062312184300000050220.jpg\"\n" +
                "\t\t  }\n" +
                "\t\t]\n" +
                "\t  },\n" +
                "\t  \"footer\": {\n" +
                "\t\t\"type\": \"MORE\",\n" +
                "\t\t\"title\": \"더보기\"\n" +
                "\t  }\n" +
                "\t}\n" +
                "  ]\n" +
                "}"
    }
    @Test
    fun testApiSuccess() {

        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )

        val response = runBlocking { repository.getList() }
        assertTrue(response.data.isNotEmpty())
    }

    @Test
    fun testContentCountCheck(){
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )

        val response = runBlocking { repository.getList() }
        assertEquals(4, response.data.size)
    }

    @Test
    fun testDataEqualsCheck(){
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )

        val response = runBlocking { repository.getList() }
        val mockResponse: ProductList = Json.decodeFromString(mockedResponse)

        assertEquals(response, mockResponse)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}