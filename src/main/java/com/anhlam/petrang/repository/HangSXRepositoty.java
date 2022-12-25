package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.HangSX;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface HangSXRepositoty extends JpaRepository<HangSX, Long>  {

//    @EntityGraph(attributePaths = "nhanVien")
    @Query("select hsx from HangSX hsx join fetch hsx.nhanVien")
    Set<HangSX> getAllCustom();
}
