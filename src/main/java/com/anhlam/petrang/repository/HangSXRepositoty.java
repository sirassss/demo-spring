package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.HangSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HangSXRepositoty extends JpaRepository<HangSX, Long>  {

    @Query("from HangSX")
    List<HangSX> getAllCustom();
}
