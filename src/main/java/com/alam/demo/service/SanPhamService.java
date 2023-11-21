package com.alam.demo.service;

import com.alam.demo.domain.dto.ProductDTO;

import java.util.List;

public interface SanPhamService {


    List<ProductDTO> getByName(String name);
}
