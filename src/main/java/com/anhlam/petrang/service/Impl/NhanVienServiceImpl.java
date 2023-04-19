package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.repository.NhanVienRepository;
import com.anhlam.petrang.repository.SanPhamRepository;
import com.anhlam.petrang.repository.search.EmployeeRepositorySearch;
import com.anhlam.petrang.service.NhanVienService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("nhanvien")
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final SanPhamRepository sanPhamRepository;
    private final EmployeeRepositorySearch employeeRepositorySearch;

    public NhanVienServiceImpl(NhanVienRepository nhanVienRepository, SanPhamRepository sanPhamRepository, EmployeeRepositorySearch employeeRepositorySearch) {
        this.nhanVienRepository = nhanVienRepository;
        this.sanPhamRepository = sanPhamRepository;
        this.employeeRepositorySearch = employeeRepositorySearch;
    }

    @Override
    public List<NhanVien> getNhanVien() {
        return nhanVienRepository.getNhanVien();
//        return nhanVienRepository.getNhanVien();
    }

    @Override
    @Transactional
    public NhanVien createNhanVien(NhanVien nhanVienv) {
        NhanVien nv = nhanVienRepository.save(nhanVienv);
        employeeRepositorySearch.save(nv);
        return nhanVienv;
    }

    @Override
    public List<NhanVien> updateNhanVien(NhanVien nv) {
        return nhanVienRepository.getNhanVienTest2();
    }

    @Override
    public List<NhanVien> getProcNhanVien() {
        return nhanVienRepository.getProcForLstNhanVien();
    }

    @Override
    public List<NhanVien> searchEmployeeByName(String name) {
        return employeeRepositorySearch.search(name).collect(Collectors.toList());
    }
}
