package com.anhlam.petrang.service;

import com.anhlam.petrang.domain.DTO.ProductDTO;
import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getListSanPham();

    List<SanPham> getListSanPhamByMaHangSx(Long mahangSx);

    SanPham createProduct(SanPham sanPham);

    List<SanPham> getListSanPhamDTO();

    List<SanPham> testNew(Long hsxID);
}
