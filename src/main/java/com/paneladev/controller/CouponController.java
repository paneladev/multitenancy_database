package com.paneladev.controller;

import com.paneladev.config.TenantContext;
import com.paneladev.entity.Coupon;
import com.paneladev.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/{brand}/coupon")
public class CouponController {

    private final CouponRepository repository;

    @GetMapping("/{id}")
    public Coupon getCoupons(@PathVariable String brand, @PathVariable Long id) {
        TenantContext.getInstance().setCurrentTenant(brand);

        return repository.findById(id).get();
    }
}
