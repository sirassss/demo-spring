package com.alam.demo.web.rest;

import com.alam.demo.domain.dto.ProductDTO;
import com.alam.demo.service.SanPhamService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SanPhamResource {

    private final SanPhamService sanPhamService;
    private final RestTemplateBuilder restTemplateBuilder;

    public SanPhamResource(SanPhamService sanPhamService, RestTemplateBuilder restTemplateBuilder) {
        this.sanPhamService = sanPhamService;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @GetMapping("/get-product-by-name")
    private ResponseEntity<List<ProductDTO>> getSPByName(@RequestParam String name) {
        List<ProductDTO> sps = sanPhamService.getByName(name);
        return ResponseEntity.ok().body(sps);
    }

    @GetMapping("/san-pham")
    private ResponseEntity<String> getSPHTTPNet() {
        return ResponseEntity.ok("oki nhé");
    }
}
