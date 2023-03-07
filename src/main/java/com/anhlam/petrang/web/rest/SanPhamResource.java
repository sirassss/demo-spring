package com.anhlam.petrang.web.rest;

import com.anhlam.petrang.domain.HangSX;
import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import com.anhlam.petrang.service.SanPhamService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class SanPhamResource {

    private final SanPhamService sanPhamService;
    private final SanPhamRepoCustom sanPhamRepoCustom;
    private final RestTemplateBuilder restTemplateBuilder;

    public SanPhamResource(SanPhamService sanPhamService, SanPhamRepoCustom sanPhamRepoCustom, RestTemplateBuilder restTemplateBuilder) {
        this.sanPhamService = sanPhamService;
        this.sanPhamRepoCustom = sanPhamRepoCustom;
        this.restTemplateBuilder = restTemplateBuilder;
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

    @GetMapping("/hang-sx-by-name")
    public ResponseEntity<List<HangSX>> getAllHangSXByName(@RequestParam String name) {
        List<HangSX> hsx = sanPhamService.getHangSXByName(name);
        return ResponseEntity.ok().body(hsx);
    }

    @GetMapping("/san-pham-dto")
    public ResponseEntity<List<SanPham>> getListSanPhamDTO() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        List<SanPham> nv = sanPhamService.getListSanPhamDTO();
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/san-pham-web-mono/{id}")
    private Mono<SanPham> getSPForMono(@PathVariable Long id) {
        return Mono.just(Objects.requireNonNull(sanPhamService.getSpById(id).orElse(null)));
    }

    @GetMapping("/san-pham-web-flux")
    private Flux<SanPham> getSPForFlux() {
        List<SanPham> nv = sanPhamService.getListSanPhamDTO();
        return Flux.just(new SanPham[0]);
    }

    @PostMapping("/san-pham-http-net")
    private ResponseEntity<String> getSPHTTPNet() {
        return ResponseEntity.ok("oki nhé");
    }
}
