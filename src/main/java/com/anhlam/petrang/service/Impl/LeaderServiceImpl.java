package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.service.NhanVienService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("leader")
public class LeaderServiceImpl implements NhanVienService {

    @Override
    public List<NhanVien> getNhanVien() {
        return null;
    }

    @Override
    public NhanVien createNhanVien(NhanVien nv) {
        return null;
    }

    @Override
    public List<NhanVien> updateNhanVien(NhanVien nv) {
        return null;
    }

    @Override
    public List<NhanVien> getProcNhanVien() {
        return null;
    }
}
