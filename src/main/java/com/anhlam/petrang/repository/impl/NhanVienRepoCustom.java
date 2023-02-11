package com.anhlam.petrang.repository.impl;

import com.anhlam.petrang.domain.DTO.NhanVienDTO;
import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.domain.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NhanVienRepoCustom {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext()
    private EntityManager entityManager;

    public List<NhanVien> getNhanVien() {
        return jdbcTemplate.query("select ID, TenNV from NhanVien", DataClassRowMapper.newInstance(NhanVien.class));
    }

    public void getNhanVien2() {
        List<NhanVienDTO> mapnvs = jdbcTemplate.query("select * from NhanVien", DataClassRowMapper.newInstance(NhanVienDTO.class));
        if (!mapnvs.isEmpty()) {
            mapnvs.forEach(System.out::println);
        }
        NhanVien map = jdbcTemplate.execute((Connection con) -> {
            return new NhanVien();
        });
    }

    public void getNhanVien3() {
        TypedQuery<String> spt = entityManager.createQuery("select sp.tenSP from SanPham sp", String.class);
        List<String> a = spt.getResultList();
    }
}
