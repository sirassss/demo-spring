package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.annotation.HandlingBusiness;
import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.HangSXRepositoty;
import com.anhlam.petrang.repository.SanPhamRepository;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import com.anhlam.petrang.security.SecurityUtils;
import com.anhlam.petrang.service.SanPhamService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository sanPhamRepository;
    private final SanPhamRepoCustom sanPhamRepoCustom;
    private final HangSXRepositoty hangSXRepositoty;

    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository, SanPhamRepoCustom sanPhamRepoCustom, HangSXRepositoty hangSXRepositoty) {
        this.sanPhamRepository = sanPhamRepository;
        this.sanPhamRepoCustom = sanPhamRepoCustom;
        this.hangSXRepositoty = hangSXRepositoty;
    }


    @Override
    @HandlingBusiness
    public List<SanPham> getListSanPham() {
        SecurityUtils.getCurrentUserLogin().ifPresent(System.out::println);
        return sanPhamRepository.findAll();
    }

    @Override
    public List<SanPham> getListSanPhamByMaHangSx(Long mahangSx) {
        return sanPhamRepository.getSanPhamsByHangSXID(mahangSx);
    }

    @Override
    public SanPham createProduct(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public List<SanPham> getListSanPhamDTO() {
        List<SanPham> lstSP = new ArrayList<>();
        sanPhamRepoCustom.getProductbyDTO(lstSP::addAll, 3);
        return lstSP;
    }

    @Override
    public List<SanPham> testNew(Long hsxID) {
        return sanPhamRepository.getSanPhamsByHangSXID(hsxID);
    }

    @Override
    public List<SanPham> testGraph(String name) {
        return sanPhamRepository.getAllForGraph(name);
    }

    @Override
    @Transactional
    public List<HangSX> getAllHangSX() {
        List<HangSX> hasx = new ArrayList<>(hangSXRepositoty.getCustomHangSx());
        hangSXRepositoty.findAll((root, query, cb) -> root.get("a").in(""));
        return hasx;
    }

    @Override
    @Transactional
    public List<HangSX> getHangSXByName(String name) {
        Integer test = hangSXRepositoty.getProcHangSX(name);
        return Collections.emptyList();
    }
}
