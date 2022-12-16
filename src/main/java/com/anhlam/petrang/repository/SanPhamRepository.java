package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.SanPham;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {

    @Query(value = "select new SanPham(sp.id, sp.tenSP, hsx) from SanPham sp join fetch HangSX hsx")
//    @EntityGraph(attributePaths = "producthsx")
    List<SanPham> getSanPhamsByHangSXID(Long maHangSX);
}
