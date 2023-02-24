package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.NhanVien;

import java.util.List;

public interface NhanVienRepoCustom {
    List<NhanVien> getNhanVien();

    void getNhanVien2();

    void getNhanVien3();

    List<NhanVien> getNV();

    List<NhanVien> getNVFromCritie();

    List<NhanVien> getProcNhanVien();
}
