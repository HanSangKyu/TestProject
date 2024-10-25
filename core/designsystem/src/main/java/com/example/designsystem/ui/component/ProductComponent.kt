package com.example.designsystem.ui.component

import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.designsystem.ui.theme.*
import com.example.model.Goods


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductComponent(goods: Goods) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight()) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                GlideImage(
                    model = goods.thumbnailURL,  // 이미지 URL 또는 로컬 리소스
                    contentDescription = "",
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop, // 이미지를 잘라서 보여줌
                )
                if (goods.hasCoupon) {
                    CouponBadge(Modifier.align(Alignment.BottomStart))
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                style = LocalTypography.current.productName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis, // 말줄임표로 표시
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight(),
                text = goods.brandName,
                color = TextTertiary
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween // 좌우로 요소 배치

            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    text = "${
                        NumberFormat.getNumberInstance(java.util.Locale.KOREA)
                            .format(goods.price)
                    }원",
                    style = LocalTypography.current.price,
                    color = TextTertiary
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(Alignment.CenterVertically),
                    style = LocalTypography.current.rate,
                    textAlign = TextAlign.End,
                    text = "${goods.saleRate}%",
                    color = Rate
                )
            }

        }
    }
}

@Composable
fun CouponBadge(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(start = 2.dp, bottom = 2.dp)
            .background(Coupon, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "쿠폰",
            color = White,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductComponent(
        Goods(
            brandName = "아스트랄 프로젝션",
            hasCoupon = false,
            linkURL = "https://www.musinsa.com/app/goods/2281817",
            price = 100000,
            saleRate = 10,
            thumbnailURL = "https://image.msscdn.net/images/goods_img/20210630/2281817/2281817_1_125.jpg"
        )
    ) // 5회 방문 예시
}
