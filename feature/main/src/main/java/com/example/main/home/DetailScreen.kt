package com.example.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.ui.theme.MusinsaTheme
import com.example.designsystem.ui.theme.myColorScheme
import com.example.feature.main.R
import com.example.main.common.FuelType
import com.example.main.common.PaymentMethod
import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
fun DetailScreen(
    onBack: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    DetailScreenContent(

    )
}

@Composable
fun DetailScreenContent(

) {
//    var showUnavailableDialog by remember { mutableStateOf(false) }
//    var showConfirmDialog by remember { mutableStateOf(false) }
//
//    if (showConfirmDialog) {
//        ReservationDialog(
//            onDismiss = { showConfirmDialog = false},
//            title = "예약을 확정할까요?",
//            message = "고객에게 예약 확정 알림을 보낼게요.",
//            buttons = listOf(
//                DialogButton.Cancel(
//                    title = "취소",
//                    action = {
//                        showConfirmDialog = false
//                    }
//                ),
//                DialogButton.Confirm(
//                    title = "확정하기",
//                    action = {
//                        onConfirmClick(reservation.serverId, "CONFIRMED")
//                        showConfirmDialog = false
//                        onBack()
//                    }
//                ),
//            )
//        )
//    }
//
//    if (showUnavailableDialog) {
//        ReservationDialog(
//            onDismiss = { showUnavailableDialog = false},
//            title = "작업이 어려우신가요?",
//            message = "고객의 신뢰 유지를 위해 예약이 불가능한 시간은 미리 표시해주세요.",
//            buttons = listOf(
//                DialogButton.Cancel(
//                    title = "취소",
//                    action = {
//                        showUnavailableDialog = false
//                    }
//                ),
//                DialogButton.Confirm(
//                    title = "예약 불가능",
//                    action = {
//                        onUnavailableClick(reservation.serverId, "DEFERRED")
//                        showUnavailableDialog = false
//                        onBack()
//                    }
//                ),
//            )
//        )
//    }
//
//    Scaffold(
//        topBar = {
//            TopBar(
//                reservation = reservation,
//                onBack = onBack
//            )
//        },
//        bottomBar = {
//            ReservationButtons(
//                onUnavailableClick = {
//                    showUnavailableDialog = true
//                },
//                onConfirmClick = {
//                    showConfirmDialog = true
//                }
//            )
//        },
//        content = { padding ->
//            LazyColumn(
//                modifier = Modifier
//                    .padding(padding)
//                    .fillMaxSize()
//                    .background(color = MusinsaTheme.myColorScheme.backgroundLight)
//            ) {
//                item {
//                    ProductInfoSection(reservation = reservation)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    CustomerInfoSection(reservation = reservation)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    PaymentInfoSection(reservation = reservation)
//                }
//                // bottom 영역
//                item {
//                    HorizontalDivider(
//                        thickness = 1.dp,
//                        color = MusinsaTheme.myColorScheme.divider
//                    )
//                }
//            }
//        }
//    )
}

//@Composable
//fun TopBar(
//    reservation: MappedReservation,
//    onBack: () -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .statusBarsPadding()
//            .background(Color.White)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 15.dp, bottom = 15.dp, start = 4.dp, end = 4.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.ic_arrow_left),
//                contentDescription = "Previous Day",
//                tint = Color.Black,
//                modifier = Modifier
//                    .padding(12.dp)
//                    .clickable { onBack() }
//            )
//
//            Text(
//                text = "예약 요청 확인",
//                style = MusinsaTheme.typography.title1Medium,
//                color = MusinsaTheme.myColorScheme.textPrimary,
//                modifier = Modifier.padding(start = 4.dp)
//            )
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(color = MusinsaTheme.myColorScheme.backgroundAccentLight)
//                .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.ic_clock_fill),
//                contentDescription = "Previous Day",
//                tint = MusinsaTheme.myColorScheme.textAccent,
//                modifier = Modifier.clickable { onBack() }
//            )
//
//            Text(
//                text = formatReservationDateSimplified(reservation.reservedAt),
//                style = MusinsaTheme.typography.title1SemiBold,
//                color = MusinsaTheme.myColorScheme.textAccent,
//                modifier = Modifier.padding(start = 4.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun ProductInfoSection(
//    reservation: MappedReservation,
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.White)
//            .padding(start = 20.dp, end = 20.dp, top = 32.dp, bottom = 32.dp)
//    ) {
//        Text(
//            text = reservation.products[0].group,
//            style = MusinsaTheme.typography.heading3Bold,
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            color = MusinsaTheme.myColorScheme.textPrimary,
//        )
//
//        // {메인 상품의 상품명}
//        Text(
//            text = reservation.products[0].name,
//            style = MusinsaTheme.typography.title1Medium,
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            color = MusinsaTheme.myColorScheme.textSecondary,
//            modifier = Modifier.padding(top = 4.dp)
//        )
//
//        Spacer(modifier = Modifier.height(12.dp)) // 추가 상품이 없으면 노출 여부 확인 필요
//
//        reservation.products.drop(1).forEachIndexed { index, product ->
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_plus_circle),
//                    contentDescription = "",
//                    tint = MusinsaTheme.myColorScheme.textSecondary,
//                )
//
//                Spacer(modifier = Modifier.width(6.dp))
//
//                Text(
//                    text = product.name,
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textSecondary,
//                )
//            }
//
//            // 마지막 항목이 아닌 경우에만 Spacer 추가
//            if (index < reservation.products.drop(1).size - 1) {
//                Spacer(modifier = Modifier.height(4.dp))
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        CustomerInfoCard("요청사항", reservation.requirements)
//    }
//}
//
//@Composable
//fun CustomerInfoSection(
//    reservation: MappedReservation,
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.White)
//            .padding(start = 20.dp, end = 20.dp, top = 32.dp, bottom = 32.dp)
//    ) {
//        Text(
//            text = "고객 정보",
//            style = MusinsaTheme.typography.heading4SemiBold,
//            color = MusinsaTheme.myColorScheme.textPrimary,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column {
//                Text(
//                    text = "고객 이름",
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textTertiary
//                )
//            }
//            Text(
//                text = reservation.customerName, // 고객 이름 표시
//                style = MusinsaTheme.typography.title1SemiBold,
//                color = MusinsaTheme.myColorScheme.textSecondary
//            )
//        }
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column {
//                Text(
//                    text = "전화번호",
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textTertiary
//                )
//            }
//            Text(
//                text = reservation.customerPhone, // 전화번호 표시
//                style = MusinsaTheme.typography.title1SemiBold,
//                color = MusinsaTheme.myColorScheme.textSecondary
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//        HorizontalDivider(
//            thickness = 1.dp,
//            color = MusinsaTheme.myColorScheme.divider
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "차량 정보",
//            style = MusinsaTheme.typography.heading4SemiBold,
//            color = MusinsaTheme.myColorScheme.textPrimary,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column {
//                Text(
//                    text = "차량 정보",
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textTertiary
//                )
//            }
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.End
//            ) {
//                // 차량 브랜드
//                Text(
//                    text = reservation.vehicleBrand,
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textSecondary
//                )
//                Spacer(modifier = Modifier.width(6.dp))
//
//                // 점 이미지
//                Icon(
//                    painter = painterResource(id = R.drawable.dot), // 여기에 점 이미지를 추가하세요
//                    contentDescription = "Dot",
//                    modifier = Modifier
//                        .size(4.dp)
//                )
//
//                Spacer(modifier = Modifier.width(6.dp))
//
//                // 차량 모델
//                Text(
//                    text = reservation.vehicleModel,
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textSecondary
//                )
//                Spacer(modifier = Modifier.width(6.dp))
//
//                // 점 이미지
//                Icon(
//                    painter = painterResource(id = R.drawable.dot), // 여기에 점 이미지를 추가하세요
//                    contentDescription = "Dot",
//                    modifier = Modifier
//                        .size(4.dp)
//                    // padding.size(horizontal)
//                )
//
//                Spacer(modifier = Modifier.width(6.dp))
//
//                // 연료 타입 (한글 변환 필요)
//                Text(
//                    text = FuelType.getDisplayName(reservation.fuelType),
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textSecondary
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column {
//                Text(
//                    text = "차량 번호",
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textTertiary
//                )
//            }
//            Text(
//                text = reservation.vehicleNumber, // 차량 번호 표시
//                style = MusinsaTheme.typography.title1Medium,
//                color = MusinsaTheme.myColorScheme.textSecondary
//            )
//        }
//    }
//}
//
//@Composable
//fun PaymentInfoSection(
//    reservation: MappedReservation,
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.White)
//            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 64.dp)
//    ) {
//        Text(
//            text = "결제 상세",
//            style = MusinsaTheme.typography.heading4SemiBold,
//            color = MusinsaTheme.myColorScheme.textPrimary,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column {
//                Text(
//                    text = "결제방법",
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.textTertiary
//                )
//            }
//            Text(
//                text = PaymentMethod.getDisplayName(reservation.paymentMethod), // 결제방법 표시
//                style = MusinsaTheme.typography.title1Medium,
//                color = MusinsaTheme.myColorScheme.textSecondary
//            )
//        }
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column {
//                Text(
//                    text = "총 결제금액",
//                    style = MusinsaTheme.typography.title1Medium,
//                    color = MusinsaTheme.myColorScheme.colorMainBlue500
//                )
//            }
//            Text(
//                text = formatPrice(reservation.products.sumOf { it.price }),
//                style = MusinsaTheme.typography.heading4Bold,
//                color = MusinsaTheme.myColorScheme.colorMainBlue500
//            )
//        }
//    }
//}
//
//@Composable
//fun ReservationButtons(
//    onUnavailableClick: () -> Unit,
//    onConfirmClick: () -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.White)
//            .padding(top = 12.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
//            .navigationBarsPadding(),  // 네비게이션 바 위에 표시되도록 패딩 추가,
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // 예약 불가 버튼
//        Text(
//            text = "예약 불가",
//            style = MusinsaTheme.typography.title1Medium,
//            color = MusinsaTheme.myColorScheme.buttonTextTertiary,
//            modifier = Modifier
//                .weight(1f)
//                .background(
//                    MusinsaTheme.myColorScheme.buttonBackgroundTertiary,
//                    shape = RoundedCornerShape(10.dp)
//                )
//                .padding(vertical = 12.dp, horizontal = 16.dp)
//                .clickable { onUnavailableClick() },
//            textAlign = TextAlign.Center,
//        )
//
//        // 예약 확정 버튼
//        Text(
//            text = "예약 확정",
//            style = MusinsaTheme.typography.title1Medium,
//            color = MusinsaTheme.myColorScheme.textOnColor,
//            modifier = Modifier
//                .weight(1f)
//                .background(
//                    MusinsaTheme.myColorScheme.buttonBackgroundPrimary,
//                    shape = RoundedCornerShape(10.dp)
//                )
//                .padding(vertical = 12.dp, horizontal = 16.dp)
//                .clickable { onConfirmClick() },
//            textAlign = TextAlign.Center,
//        )
//    }
//}
//
//fun formatReservationDateSimplified(dateString: String): String {
//    val formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h:mm", Locale.KOREAN)
//    val dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME)
//
//    return dateTime.format(formatter)
//}
//
//fun formatPrice(price: Int): String {
//    val formatter = NumberFormat.getInstance(Locale.KOREA) // 한국 스타일의 숫자 포맷 (천 단위마다 콤마)
//    return formatter.format(price) + "원"
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DetailScreenPreview() {
//    val testReservation = MappedReservation(
//        serverId = 1,
//        customerId = 123,
//        customerName = "김민지",
//        customerPhone = "010-1234-5678",
//        vehicleBrand = "기아",
//        vehicleModel = "올 뉴 쏘렌토",
//        vehicleNumber = "93가1243",
//        status = "예약 완료",
//        reservedAt = "2024-09-08",
//        requirements = "정기 점검 요청",
//        products = listOf(
//            Product(group = "엔진", name = "엔진오일 교체", price = 105000, quantity = 1),
//            Product(group = "배터리", name = "배터리 교체", price = 190000, quantity = 1)
//        ),
//        paymentMethod = "카드 결제",
//        visitCount = 2,
//        fuelType = "휘발유"
//    )
//
//    DetailScreenContent(
//        reservation = testReservation,
//        onBack = {},
//        onConfirmClick = { _, _ -> }, // 빈 함수로 전달
//        onUnavailableClick = {_, _ ->}
//    )
//}