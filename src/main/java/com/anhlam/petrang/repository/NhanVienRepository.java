package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    @Query(value = "select nv.diaChi from NhanVien nv")
    List<NhanVien> getNhanVien();

    @Query(value = "from NhanVien nv join fetch nv.sanPham")
    List<NhanVien> getNhanVienWithSP();
}
