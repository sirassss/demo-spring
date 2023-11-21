package com.alam.demo.service.Impl;

import com.alam.demo.domain.dto.ProductDTO;
import com.alam.demo.service.SanPhamService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    private final List<ProductDTO> productDTO = Arrays.asList(
            new ProductDTO(1L, "Shirt", 2, "Đẹp"),
            new ProductDTO(1L, "Pan", 2, "Đẹp"),
            new ProductDTO(1L, "Hat", 2, "Đẹp"),
            new ProductDTO(1L, "Glass", 2, "Đẹp")
    );
    @Override
    public List<ProductDTO> getByName(String name) {
        return productDTO.stream().filter(item -> item.getTenSP().contains(name)).collect(Collectors.toList());
    }
}
