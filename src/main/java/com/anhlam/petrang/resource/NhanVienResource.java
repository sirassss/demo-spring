package com.anhlam.petrang.resource;

import com.anhlam.petrang.Annotation.HandlingBusiness;
import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import com.anhlam.petrang.service.NhanVienService;
//import com.google.gson.Gson;
import com.anhlam.petrang.service.SanPhamService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class NhanVienResource {

    private final NhanVienService nhanVienService;
    private final SanPhamService sanPhamService;
    private final SanPhamRepoCustom sanPhamRepoCustom;
    private final RestTemplateBuilder restTemplateBuilder;

    public NhanVienResource(NhanVienService nhanVienService, SanPhamService sanPhamService, SanPhamRepoCustom sanPhamRepoCustom, RestTemplateBuilder restTemplateBuilder) {
        this.nhanVienService = nhanVienService;
        this.sanPhamService = sanPhamService;
        this.sanPhamRepoCustom = sanPhamRepoCustom;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @GetMapping("/nhan-vien")
    public ResponseEntity<List<NhanVien>> getNhanVien() {
        return ResponseEntity.ok().body(nhanVienService.getNhanVien());
    }

    @PostMapping("/hang-san-xuat")
    public ResponseEntity<SanPham> getHanSX(@RequestBody SanPham sanPham) {
        SanPham nv = sanPhamService.createProduct(sanPham);
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/san-pham")
    public ResponseEntity<List<SanPham>> getListSanPham() {
        List<SanPham> nv = sanPhamService.getListSanPham();
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/san-pham-by-mahsx/{mahsx}")
    public ResponseEntity<List<SanPham>> getListSanPham(@PathVariable Long mahsx) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<SanPham> nv = sanPhamService.getListSanPhamByMaHangSx(mahsx);
//        List<SanPham> nv = sanPhamService.testGraph(mahsx);
//        Class<?> clazz = sanPhamService.getClass();
//        for (Method method : clazz.getDeclaredMethods()) {
//            if (method.isAnnotationPresent(HandlingBusiness.class)) {
//                if (method.getReturnType().equals(List.class)) {
//
//                }
//            }
//        }

        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/san-pham-by-name")
    public ResponseEntity<List<SanPham>> getListSanPham(@RequestParam String name) {
        List<SanPham> nv = sanPhamService.testGraph(name);
        return ResponseEntity.ok().body(nv);
    }

    @PostMapping("/san-pham")
    public ResponseEntity<SanPham> createProduct(@RequestBody SanPham sanPham) {
        SanPham nv = sanPhamService.createProduct(sanPham);
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/hang-sx")
    public ResponseEntity<List<HangSX>> getAllHangSX() {
        List<HangSX> hsx = sanPhamService.getAllHangSX();
        return ResponseEntity.ok().body(hsx);
    }

    @GetMapping("/san-pham-dto")
    public ResponseEntity<List<SanPham>> getListSanPhamDTO() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        try {
            restTemplate.getClass().getField("anhlam");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        List<SanPham> nv = sanPhamService.getListSanPhamDTO();
        return ResponseEntity.ok().body(nv);
    }

//    @GetMapping("/test-jdbc")
//    public ResponseEntity<List<SanPham>> testJDBCExecutor() {
//        List<SanPham> nv = sanPhamRepoCustom.testJDBC();
//        return ResponseEntity.ok().body(nv);
//    }
}
