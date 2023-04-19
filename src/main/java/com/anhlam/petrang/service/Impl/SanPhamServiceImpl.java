package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.annotation.HandlingBusiness;
import com.anhlam.petrang.domain.DTO.ProductDTO;
import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.HangSXRepositoty;
import com.anhlam.petrang.repository.SanPhamRepository;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import com.anhlam.petrang.repository.search.ProductRepositorySearch;
import com.anhlam.petrang.security.SecurityUtils;
import com.anhlam.petrang.service.SanPhamService;
import com.anhlam.petrang.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository sanPhamRepository;
    private final SanPhamRepoCustom sanPhamRepoCustom;
    private final HangSXRepositoty hangSXRepositoty;
    private final ProductRepositorySearch productRepositorySearch;
    private final ProductMapper productMapper;

    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository, SanPhamRepoCustom sanPhamRepoCustom, HangSXRepositoty hangSXRepositoty, ProductRepositorySearch productRepositorySearch, ProductMapper productMapper) {
        this.sanPhamRepository = sanPhamRepository;
        this.sanPhamRepoCustom = sanPhamRepoCustom;
        this.hangSXRepositoty = hangSXRepositoty;
        this.productRepositorySearch = productRepositorySearch;
        this.productMapper = productMapper;
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
    @Transactional
    public SanPham createProduct(SanPham sanPham) {
        SanPham sp = sanPhamRepository.save(sanPham);
        productRepositorySearch.save(sp);
        return sp;
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
//        List<HangSX> hasx = new ArrayList<>(hangSXRepositoty.getCustomHangSx());
        hangSXRepositoty.findAll((root, query, cb) -> root.get("a").in(""));
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public List<HangSX> getHangSXByName(String name) {
        Integer test = hangSXRepositoty.getProcHangSX(name);
        return Collections.emptyList();
    }

    @Override
    public Optional<SanPham> getSpById(Long id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public List<ProductDTO> getByName(String name) {
        return productRepositorySearch
                .search(name)
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
