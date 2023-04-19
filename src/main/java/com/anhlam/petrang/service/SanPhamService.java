package com.anhlam.petrang.service;

import com.anhlam.petrang.domain.DTO.ProductDTO;
import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.SanPham;

import java.util.List;
import java.util.Optional;

public interface SanPhamService {

    List<SanPham> getListSanPham();

    List<SanPham> getListSanPhamByMaHangSx(Long mahangSx);

    SanPham createProduct(SanPham sanPham);

    List<SanPham> getListSanPhamDTO();

    List<SanPham> testNew(Long hsxID);

    List<SanPham> testGraph(String name);

    List<HangSX> getAllHangSX();

    List<HangSX> getHangSXByName(String name);

    Optional<SanPham> getSpById(Long id);

    List<ProductDTO> getByName(String name);
}
