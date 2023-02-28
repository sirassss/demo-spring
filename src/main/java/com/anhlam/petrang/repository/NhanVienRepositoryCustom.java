package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.NhanVien;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NhanVienRepositoryCustom {
    void getNhanVienTest();

    void getNhanVienTest2();

    void getNhanVienTest3();

    List<NhanVien> getNV();

    List<NhanVien> getNVForCritie();

    List<NhanVien> getProcForLstNhanVien();
}
