package com.anhlam.petrang.repository.impl;

import com.anhlam.petrang.domain.SanPham;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@Repository
public class SanPhamRepoCustom {

    @PersistenceContext()
    private EntityManager entityManager;

    @PersistenceContext()
    private Session session;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void getProductbyDTO(Consumer<List<SanPham>> lstSP, Integer type) {
        lstSP.accept(entityManager.createQuery("select sp from SanPham sp", SanPham.class).getResultList());
    }
}
