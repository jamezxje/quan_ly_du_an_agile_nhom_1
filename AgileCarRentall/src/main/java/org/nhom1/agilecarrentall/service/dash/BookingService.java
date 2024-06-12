package org.nhom1.agilecarrentall.service.dash;

import org.nhom1.agilecarrentall.entity.Booking;
import org.nhom1.agilecarrentall.entity.dto.filter.BookingFilterRequest;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationResponse;
import org.nhom1.agilecarrentall.entity.type.Status;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Booking findBookingById(Integer id);
    PaginationResponse<List<Booking>> findByFilter(BookingFilterRequest request);
    String[] changeStatus(Integer id, Status status);
    double calculateTotalIncome(LocalDate start, LocalDate end, Integer ownerId);
    double calculateTotalRevenue(LocalDate start, LocalDate end, Integer ownerId);
    double calculateExpectedRevenue(LocalDate start, LocalDate end, Integer ownerId);
    int countBookingsByStatus(LocalDate start, LocalDate end,Status status, Integer ownerId);
}
