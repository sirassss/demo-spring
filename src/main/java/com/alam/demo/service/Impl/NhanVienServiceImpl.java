package com.alam.demo.service.Impl;

import com.alam.demo.domain.dto.NhanVienDTO;
import com.alam.demo.repository.search.UserSearchRepository;
import com.alam.demo.service.NhanVienService;
import lombok.extern.log4j.Log4j2;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class NhanVienServiceImpl implements NhanVienService {

//    private final UserSearchRepository userSearchRepository;
//    private ElasticsearchOperations elasticsearchOperations;

//    public NhanVienServiceImpl(UserSearchRepository userSearchRepository) {
//        this.userSearchRepository = userSearchRepository;
//    }

    @Override
    public List<NhanVienDTO> getNhanVien() {
        return Collections.emptyList();
    }

    @Override
    public NhanVienDTO createNhanVien(NhanVienDTO nv) {
//        userSearchRepository.index(nv);
        return nv;
    }

    @Override
    public List<NhanVienDTO> updateNhanVien(NhanVienDTO nv) {
        return List.of(nv);
    }
}
