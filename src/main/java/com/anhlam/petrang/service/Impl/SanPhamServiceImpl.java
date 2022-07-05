package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.domain.DTO.ProductDTO;
import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.SanPhamRepository;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import com.anhlam.petrang.service.SanPhamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository sanPhamRepository;
    private final SanPhamRepoCustom sanPhamRepoCustom;

    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository, SanPhamRepoCustom sanPhamRepoCustom) {
        this.sanPhamRepository = sanPhamRepository;
        this.sanPhamRepoCustom = sanPhamRepoCustom;
    }


    @Override
    public List<SanPham> getListSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public List<SanPham> getListSanPhamByMaHangSx(Long mahangSx) {
        return sanPhamRepository.getSanPhamsByHangSXID(mahangSx);
    }

    @Override
    public SanPham createProduct(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public List<SanPham> getListSanPhamDTO() {
        return sanPhamRepoCustom.getProductbyDTO();
    }
}
