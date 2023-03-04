package com.anhlam.petrang.repository.impl;

import com.anhlam.petrang.domain.DTO.NhanVienDTO;
import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.repository.NhanVienRepositoryCustom;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;


public class NhanVienRepositoryImpl implements NhanVienRepositoryCustom {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Qualifier("parseJson")
    private ObjectMapper objectMapper;

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public void getNhanVienTest() {
        jdbcTemplate.query("select ID, TenNV from NhanVien", DataClassRowMapper.newInstance(NhanVien.class));
    }

    @Override
    public List<NhanVien> getNhanVienTest2() {
        List<NhanVienDTO> mapnvs = jdbcTemplate.query("exec Proc_getNhanVien 1", DataClassRowMapper.newInstance(NhanVienDTO.class));
        if (!mapnvs.isEmpty()) {
            mapnvs.forEach(System.out::println);
        }
        List<NhanVien> map = jdbcTemplate.execute((Connection con) -> {
            con.setAutoCommit(true);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(con.nativeSQL("select * from NhanVien"));
            List<Map<String, Object>> nvs = new ArrayList<>();
            while (resultSet.next()) {
                nvs.add(getObjectFromResultSet(resultSet, NhanVien.class));
            }
            return Arrays.asList(objectMapper.convertValue(nvs, NhanVien[].class));
        });

        System.out.println("Done");
        return map;
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
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<NhanVien> getProcForLstNhanVien() {
        StoredProcedureQuery builder = entityManager.createStoredProcedureQuery("Proc_getNhanVien", NhanVien.class);
        builder.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        builder.setParameter(1, 2L);
        return builder.getResultList();
    }

    private <T> Map<String, Object> getObjectFromResultSet(ResultSet resultSet, Class<T> tClass) throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        int colcount = meta.getColumnCount();
        Map<String, Object> res = new HashMap<>();
        for (Field declaredField : tClass.getDeclaredFields()) {
            for (int i = 1; i <= colcount; i++) {
                String name = meta.getColumnLabel(i);
                if (name.equalsIgnoreCase(declaredField.getName())) {
                    if (declaredField.getType().equals(Boolean.class)) res.put(name, resultSet.getBoolean(i));
                    if (declaredField.getType().equals(String.class)) res.put(name, resultSet.getString(i));
                    if (declaredField.getType().equals(Integer.class)) res.put(name, resultSet.getInt(i));
                    if (declaredField.getType().equals(Long.class)) res.put(name, resultSet.getLong(i));
                    if (declaredField.getType().equals(Float.class)) res.put(name, resultSet.getFloat(i));
                    if (declaredField.getType().equals(Double.class)) res.put(name, resultSet.getDouble(i));
                    if (declaredField.getType().equals(LocalDate.class)) res.put(name, objectMapper.convertValue(resultSet.getObject(i), LocalDate.class));
                }
            }
        }
        return res;
    }
}
