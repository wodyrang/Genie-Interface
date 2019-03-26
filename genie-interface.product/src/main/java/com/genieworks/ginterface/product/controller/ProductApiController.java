package com.genieworks.ginterface.product.controller;

import com.genieworks.ginterface.product.service.ProductApiService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 테스트용으로 작성된 API
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductApiController {

    @NonNull
    private final ProductApiService productApiService;

    @GetMapping("/hello/{name}")
    public String helloProduct(@PathVariable("name") final String name) {
        if (log.isDebugEnabled()) {
            log.debug("name is {}", name);
        }
        return this.productApiService.getProductName(name);
    }

}

