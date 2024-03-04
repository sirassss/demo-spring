package com.alam.demo.web.rest;

import com.alam.demo.domain.dto.NhanVienDTO;
import com.alam.demo.repository.search.UserSearchRepository;
import com.alam.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class NhanVienResource {

    @Autowired
    private RedisTemplate template;
    private final NhanVienService nhanVienService;
//    private final UserSearchRepository userSearchRepository;

    public NhanVienResource(NhanVienService nhanVienService/*, UserSearchRepository userSearchRepository*/) {
        this.nhanVienService = nhanVienService;
//        this.userSearchRepository = userSearchRepository;
    }

    @PostMapping("/nhan-vien")
    public ResponseEntity<NhanVienDTO> createEmployee(@RequestBody NhanVienDTO nhanVien) {
        return ResponseEntity.ok().body(nhanVienService.createNhanVien(nhanVien));
    }

    @GetMapping("/nhan-vien")
    public ResponseEntity<List<NhanVienDTO>> getNhanVien() {
        return ResponseEntity.ok().body(nhanVienService.getNhanVien());
    }

    @GetMapping("/nhan-vien-update")
    public ResponseEntity<List<NhanVienDTO>> getNhanVien_2() {
        return ResponseEntity.ok().body(nhanVienService.updateNhanVien(new NhanVienDTO()));
    }

//    @GetMapping("/users/_search/{query}")
//    public List<NhanVienDTO> search(@PathVariable String query) {
//        return StreamSupport.stream(userSearchRepository.search(query).spliterator(), false).map(NhanVienDTO::new).toList();
//    }

    @GetMapping("/redis/check")
    public ResponseEntity<String> redisCheck() {
        template.getClientList();
        return ResponseEntity.ok("");
    }

}

abstract class Prt {
    private String a;
}