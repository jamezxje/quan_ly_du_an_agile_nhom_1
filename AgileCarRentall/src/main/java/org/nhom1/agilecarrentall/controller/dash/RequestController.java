package org.nhom1.agilecarrentall.controller.dash;

import org.nhom1.agilecarrentall.entity.dto.filter.CarFilterRequest;
import org.nhom1.agilecarrentall.entity.dto.filter.TransactionFilterRequest;
import org.nhom1.agilecarrentall.entity.type.Status;
import org.nhom1.agilecarrentall.entity.type.TransactionStatus;
import org.nhom1.agilecarrentall.entity.type.TransactionType;
import org.nhom1.agilecarrentall.service.dash.BrandService;
import org.nhom1.agilecarrentall.service.dash.CarService;
import org.nhom1.agilecarrentall.service.dash.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard/request")
@PreAuthorize("hasRole('ADMIN')")
public class RequestController {
    private final CarService carService;
    private final BrandService brandService;
    private final TransactionService transactionService;

    @GetMapping("/cars")
    public String listCarRequest(Model model, CarFilterRequest filter) {
        model.addAttribute("cars", carService.findByFilter(filter));
        model.addAttribute("brands", brandService.findAllBrandItemResponseDTO());
        model.addAttribute("status", Status.values());
        model.addAttribute("filter", filter);
        return "dashboard/request/car-list";
    }

    @GetMapping("/cars/{id}/details")
    public String carDetails(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("car", carService.findById(id));
        return "dashboard/request/car-details";
    }

    @PostMapping("/cars/{id}/status")
    public String changeCarStatus(@PathVariable("id") Integer id, @RequestParam("status") Status status) {
        carService.changeStatus(id, status);
        return "redirect:/dashboard/request/cars";
    }

    @GetMapping("/deposits")
    public String transactionRequest(Model model, TransactionFilterRequest request) {
        if (request.getType() == null) {
            request.setType(TransactionType.REQUEST_IN);
        }
        model.addAttribute("deposits", transactionService.findByFilter(request));
        model.addAttribute("filter", request);
        model.addAttribute("status", TransactionStatus.values());
        return "/dashboard/request/transaction-list";
    }

    @GetMapping("/deposits/status")
    public String changeTransactionStatus(@RequestParam("id") Integer id, TransactionStatus status, RedirectAttributes attributes) {
        String error = transactionService.changeDepositStatus(id, status);
        if (error != null) {
            attributes.addFlashAttribute("error", error);
        }else {
            attributes.addFlashAttribute("success", "Transaction status changed successfully");
        }
        return "redirect:/dashboard/request/deposits";
    }


}
