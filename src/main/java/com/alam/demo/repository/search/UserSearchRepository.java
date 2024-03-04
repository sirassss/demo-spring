package com.alam.demo.repository.search;

//import co.elastic.clients.elasticsearch._types.query_dsl.QueryStringQuery;

import com.alam.demo.domain.dto.NhanVienDTO;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.client.elc.NativeQuery;
//import org.springframework.data.elasticsearch.core.SearchHit;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends /*ElasticsearchRepository<NhanVienDTO, String>,*/ UserSearchRepositoryInternal {}

interface UserSearchRepositoryInternal {
    Stream<NhanVienDTO> search(String query);

    @Async
    void index(NhanVienDTO entity);

    @Async
    void deleteFromIndex(NhanVienDTO entity);
}

class UserSearchRepositoryInternalImpl /*implements UserSearchRepositoryInternal*/ {

//    private final ElasticsearchTemplate elasticsearchTemplate;

//    UserSearchRepositoryInternalImpl(ElasticsearchTemplate elasticsearchTemplate) {
//        this.elasticsearchTemplate = elasticsearchTemplate;
//    }

//    @Override
//    public Stream<NhanVienDTO> search(String query) {
//        NativeQuery nativeQuery = new NativeQuery(QueryStringQuery.of(qs -> qs.query(query))._toQuery());
//        return elasticsearchTemplate.search(nativeQuery, NhanVienDTO.class).map(SearchHit::getContent).stream();
//    }
//
//    @Override
//    public void index(NhanVienDTO entity) {
//        elasticsearchTemplate.save(entity);
//    }
//
//    @Override
//    public void deleteFromIndex(NhanVienDTO entity) {
//        elasticsearchTemplate.delete(entity);
//    }
}
