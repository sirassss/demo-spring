package com.anhlam.petrang.service;


import com.anhlam.petrang.domain.NhanVien;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public interface NhanVienService {

    List<NhanVien> getNhanVien();

    NhanVien createNhanVien(NhanVien nv);

    List<NhanVien> updateNhanVien(NhanVien nv);

    default <V, B> BiFunction<V, B, NhanVien> tesst(BiFunction<? super V,? super B, NhanVien> action) {
        return action::apply;
    }

    List<NhanVien> getProcNhanVien();

    List<NhanVien> searchEmployeeByName(String name);
}
