package com.anhlam.petrang.repository.impl;

import com.anhlam.petrang.domain.SanPham;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SanPhamRepoCustom {

    @PersistenceContext()
//    @Autowired()
    private EntityManager entityManager;

    @PersistenceContext()
    private Session session;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<SanPham> getProductbyDTO() {
//        Query query = session.createQuery("select sp from SanPham sp", SanPham.class);
//        List<SanPham> sps = query.getResultList();
        return Collections.checkedList(entityManager.createQuery("select sp from SanPham sp").getResultList(), SanPham.class);
    }

}
