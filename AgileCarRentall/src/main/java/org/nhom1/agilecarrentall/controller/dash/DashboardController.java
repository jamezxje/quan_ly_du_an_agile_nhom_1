package org.nhom1.agilecarrentall.controller.dash;

import org.nhom1.agilecarrentall.entity.Member;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.ReportRequestDTO;
import org.nhom1.agilecarrentall.entity.type.MemberRole;
import org.nhom1.agilecarrentall.entity.type.Status;
import org.nhom1.agilecarrentall.service.dash.BookingService;
import org.nhom1.agilecarrentall.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/dashboard")
@PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
@RequiredArgsConstructor
public class DashboardController {
    private final BookingService bookingService;

    @GetMapping({"", "/"})
    public String dashboardAdmin(Model model, ReportRequestDTO request) {
        Member member = RequestUtils.getMemberFromModel(model);
        if (member.getRole() == MemberRole.ROLE_OWNER) {
            request.setOwnerId(member.getMemberId());
        }

        if (request.getStartDate() == null || request.getEndDate() == null) {
            request.setStartDate(LocalDate.now().withDayOfMonth(1));
            request.setEndDate(LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()));
        }

        var totalFee = bookingService.calculateTotalIncome(request.getStartDate(), request.getEndDate(), request.getOwnerId());
        var totalRevenue = bookingService.calculateTotalRevenue(request.getStartDate(), request.getEndDate(), request.getOwnerId());
        if (member.getRole() == MemberRole.ROLE_OWNER) {
            model.addAttribute("income", totalRevenue - totalFee);
        } else {
            model.addAttribute("income", totalFee);
        }
        model.addAttribute("revenue", totalRevenue);
        model.addAttribute("expectedRevenue", bookingService.calculateExpectedRevenue(request.getStartDate(), request.getEndDate(), request.getOwnerId()));
        model.addAttribute("totalBookings", bookingService.countBookingsByStatus(request.getStartDate(), request.getEndDate(), null, request.getOwnerId()));
        model.addAttribute("approvedBookings", bookingService.countBookingsByStatus(request.getStartDate(), request.getEndDate(), Status.APPROVED, request.getOwnerId()));
        model.addAttribute("pending", bookingService.countBookingsByStatus(request.getStartDate(), request.getEndDate(), Status.PENDING, request.getOwnerId()));
        model.addAttribute("request", request);
        return "dashboard/index";
    }

}
