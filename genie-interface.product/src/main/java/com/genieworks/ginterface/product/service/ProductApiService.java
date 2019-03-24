package com.genieworks.ginterface.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductApiService {

    public String getProductName(final String name) {
        return String.format("name is '%s'", name);
    }

}
