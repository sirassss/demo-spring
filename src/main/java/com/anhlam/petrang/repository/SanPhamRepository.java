package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {

    @Query(value = "select new SanPham(sp.id, sp.tenSP) from SanPham sp where sp.hangSX.id = ?1")
//    @EntityGraph(attributePaths = "producthsx")
    List<SanPham> getSanPhamsByHangSXID(Long maHangSX);

//    @EntityGraph(value = "SanPham.hangSX")
    @Query("from SanPham")
    List<SanPham> getAllForGraph(String name);
}
