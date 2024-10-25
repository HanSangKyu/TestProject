//package com.example.main.model
//
//import com.example.model.CustomerVisitResponse
//import com.example.model.Reservation
//import com.example.model.ReservationDetailResponse
//import javax.inject.Inject
//
//class ReservationMapper @Inject constructor() {
//
//    fun mapReservation(
//        reservation: Reservation,
//        reservationDetail: ReservationDetailResponse,
//        visitInfo: CustomerVisitResponse
//    ): MappedReservation {
//        return MappedReservation(
//            serverId = reservation.serverId,
//            customerId = reservation.customerId,
//            customerName = reservationDetail.customer.name,
//            customerPhone = reservationDetail.customer.phone,
//            vehicleBrand = reservationDetail.vehicle.brand,
//            vehicleModel = reservationDetail.vehicle.model,
//            vehicleNumber = reservationDetail.vehicle.number,
//            fuelType = reservationDetail.vehicle.fuelType,
//            status = reservation.status,
//            reservedAt = reservation.reservedAt,
//            requirements = reservation.requirements,
//            products = reservation.products, // 메인 상품과 추가 상품을 그대로 사용
//            paymentMethod = reservation.paymentMethod,
//            visitCount = visitInfo.visitCount
//        )
//    }
//}