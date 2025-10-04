package com.vn.baitapsangt7_04_10.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vn.baitapsangt7_04_10.entity.Customer;

@RestController
@EnableMethodSecurity
public class CustomerController {

    final private List<Customer> customers = List.of(
            Customer.builder().id("001").name("cao nguyen anh vu").email("anhvu@gmail.com").build(),
            Customer.builder().id("002").name("Hello i'm user").email("anhvu@gmail.com").build());

    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Customer> getCustomerList() {
        return customers;
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Customer getCustomerList(@PathVariable("id") String id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
