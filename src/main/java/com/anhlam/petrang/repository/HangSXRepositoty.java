package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.DTO.HangSXDTO;
import com.anhlam.petrang.domain.HangSX;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface HangSXRepositoty extends JpaRepository<HangSX, Long>, JpaSpecificationExecutor<HangSX> {

    @EntityGraph(attributePaths = "nhanVien")
    @Query("select hsx from HangSX hsx ")
    List<HangSX> getAllCustom();

    @Query("select new HangSXDTO(hsx.id, hsx.tenHang, hsx.email) from HangSX hsx")
    List<HangSXDTO> getCustomHangSx();

    @Procedure(name = "getProcHangSx", outputParameterName = "test")
    Integer getProcHangSX(@Param("name") String name);
}
