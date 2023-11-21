package com.alam.demo.service.Impl;

import com.alam.demo.domain.dto.NhanVienDTO;
import com.alam.demo.service.NhanVienService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienDTO nv = new NhanVienDTO();
    @Override
    public List<NhanVienDTO> getNhanVien() {
        return List.of(nv);
    }

    @Override
    public NhanVienDTO createNhanVien(NhanVienDTO nv) {
        this.nv = nv;
        log.info("CREATED nhân viên: {}", nv);
        return null;
    }

    @Override
    public List<NhanVienDTO> updateNhanVien(NhanVienDTO nv) {
        this.nv = nv;
        log.info("UPDATED nhân viên: {}", nv);
        return List.of(nv);
    }
}
