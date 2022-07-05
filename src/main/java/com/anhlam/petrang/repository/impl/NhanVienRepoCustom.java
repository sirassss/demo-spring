package com.anhlam.petrang.repository.impl;

import com.anhlam.petrang.domain.DTO.NhanVienDTO;
import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.domain.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NhanVienRepoCustom {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @PersistenceContext()
    private EntityManager entityManager;

    public List<NhanVien> getNhanVien() {
        List<NhanVien> nvs = new ArrayList<>();
        jdbcTemplate.query("select * from NhanVien", ps -> {
            NhanVien nv = new NhanVien();
            nv.setId(ps.getLong(1));
            nv.setTenNV(ps.getString(2));
            nv.setGioiTinh(ps.getBoolean(3));
            nv.setDiaChi(ps.getString(4));
            nv.setSoDT(ps.getString(5));
            nv.setEmail(ps.getString(6));
            nv.setTenPhong(ps.getString(7));
            nvs.add(nv);

        });
        return nvs;
    }

    public void getNhanVien2() {
//        NhanVienDTO nv = jdbcTemplate.queryForObject("select * from NhanVien where MaNV = 'NV01' ", NhanVienDTO.class);
//        List<NhanVien> nvs = jdbcTemplate.queryForObject("select * from NhanVien", List.class);
        List<Map<String, Object>> mapnvs = jdbcTemplate.queryForList("select * from NhanVien");
        if(!mapnvs.isEmpty()) {
            mapnvs.forEach(System.out::println);
        }
    }

    public void getNhanVien3() {
        TypedQuery<String> spt = entityManager.createQuery("select sp.tenSP from SanPham sp", String.class);
        List<String> a = spt.getResultList();
    }
}
