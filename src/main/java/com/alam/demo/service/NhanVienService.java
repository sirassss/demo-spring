package com.alam.demo.service;


import com.alam.demo.domain.dto.NhanVienDTO;

import java.util.List;

public interface NhanVienService {

    List<NhanVienDTO> getNhanVien();

    NhanVienDTO createNhanVien(NhanVienDTO nv);

    List<NhanVienDTO> updateNhanVien(NhanVienDTO nv);
}
