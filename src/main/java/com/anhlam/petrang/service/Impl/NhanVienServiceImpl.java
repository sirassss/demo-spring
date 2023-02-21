package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.NhanVienRepository;
import com.anhlam.petrang.repository.SanPhamRepository;
import com.anhlam.petrang.repository.impl.NhanVienRepoCustom;
import com.anhlam.petrang.service.NhanVienService;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final NhanVienRepoCustom nhanVienRepoCustom;
    private final SanPhamRepository sanPhamRepository;

    public NhanVienServiceImpl(NhanVienRepository nhanVienRepository, NhanVienRepoCustom nhanVienRepoCustom, SanPhamRepository sanPhamRepository) {
        this.nhanVienRepository = nhanVienRepository;
        this.nhanVienRepoCustom = nhanVienRepoCustom;
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public List<NhanVien> getNhanVien() {
        List<NhanVien> nv = nhanVienRepoCustom.getNV();
        return nhanVienRepository.getNhanVien();
    }

    @Override
    public NhanVien createNhanVien(NhanVien nhanVienv) {
        List<NhanVien> lst = new ArrayList<>();
        return nhanVienv;
    }

    @Override
    public NhanVien updateNhanVien(NhanVien nv) {
        return null;
    }
}
