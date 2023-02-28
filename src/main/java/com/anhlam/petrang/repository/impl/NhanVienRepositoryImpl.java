package com.anhlam.petrang.repository.impl;

import com.anhlam.petrang.domain.DTO.NhanVienDTO;
import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.repository.NhanVienRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class NhanVienRepositoryImpl implements NhanVienRepositoryCustom {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public void getNhanVienTest() {
        jdbcTemplate.query("select ID, TenNV from NhanVien", DataClassRowMapper.newInstance(NhanVien.class));
    }

    @Override
    public void getNhanVienTest2() {
        List<NhanVienDTO> mapnvs = jdbcTemplate.query("select * from NhanVien", DataClassRowMapper.newInstance(NhanVienDTO.class));
        if (!mapnvs.isEmpty()) {
            mapnvs.forEach(System.out::println);
        }
        NhanVien map = jdbcTemplate.execute((Connection con) -> new NhanVien());
    }

    @Override
    public void getNhanVienTest3() {
        TypedQuery<String> spt = entityManager.createQuery("select sp.tenSP from SanPham sp", String.class);
        List<String> a = spt.getResultList();
    }

    @Override
    public List<NhanVien> getNV() {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValues(Map.of("id", 1));
        List<NhanVienDTO> nv =  namedParameterJdbcTemplate.query("select * from NhanVien where ID <> :id", map, DataClassRowMapper.newInstance(NhanVienDTO.class));
        return namedParameterJdbcTemplate.query("select * from NhanVien where ID <> :id", map, DataClassRowMapper.newInstance(NhanVien.class));
    }

    @Override
    public List<NhanVien> getNVForCritie() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();


        CriteriaQuery<NhanVien> query =  builder.createQuery(NhanVien.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        query.select(root).where(builder.equal(root.get("ID"), "lam"));
        return null;
    }

    @Override
    public List<NhanVien> getProcForLstNhanVien() {
//        StoredProcedureQuery builder = entityManager.createNamedStoredProcedureQuery("Proc_getNhanVien");
        return Collections.emptyList();
    }
}
