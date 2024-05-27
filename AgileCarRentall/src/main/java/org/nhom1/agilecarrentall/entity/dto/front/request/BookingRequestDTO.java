package org.nhom1.agilecarrentall.entity.dto.front.request;

import lombok.*;
import org.nhom1.agilecarrentall.entity.Booking;
import org.nhom1.agilecarrentall.entity.BookingDetail;
import org.nhom1.agilecarrentall.entity.type.PaymentMethod;
import org.nhom1.agilecarrentall.entity.type.PickupType;
import org.nhom1.agilecarrentall.entity.type.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingRequestDTO {
    private Integer bookingId;
    private String fullName;
    private String address;
    private String phoneNumber;
    private LocalDateTime pickupTime;
    private LocalDateTime returnTime;
    private PaymentMethod paymentMethod;
    private PickupType pickupType;
    private Double totalPrice;
    private Double feePrice;
    private Double basePrice;

    public Booking toEntity() {

        BookingDetail bookingDetail = new BookingDetail();
        bookingDetail.setFullName(this.fullName);
        bookingDetail.setPickupAddress(this.address);
        bookingDetail.setPhoneNumber(this.phoneNumber);
        bookingDetail.setPaymentMethod(this.paymentMethod);
        bookingDetail.setPickupType(this.pickupType);
        bookingDetail.setPickupFee(this.feePrice);
        bookingDetail.setBasePrice(this.basePrice);

        Booking booking = new Booking();
        if (this.bookingId != null) {
            booking.setBookingId(this.bookingId);
        }
        booking.setTotalPrice(this.totalPrice);
        booking.setBookingRequestTime(LocalDateTime.now());
        booking.setBookingPickupTime(this.pickupTime);
        booking.setBookingReturnTime(this.returnTime);
        booking.setIsDeleted(false);
        booking.setStatus(Status.PENDING);
        booking.setBookingDetail(bookingDetail);

        return booking;
    }
}
