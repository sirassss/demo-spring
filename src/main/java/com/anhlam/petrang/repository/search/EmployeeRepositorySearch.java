package com.anhlam.petrang.repository.search;

import com.anhlam.petrang.domain.NhanVien;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

public interface EmployeeRepositorySearch extends ElasticsearchRepository<NhanVien, Long>, EmployeeSearchRepositoryInternal{
}

interface EmployeeSearchRepositoryInternal {
    Stream<NhanVien> search(String query);
}


@Repository
class EmployeeSearchRepositoryInternalImpl implements EmployeeSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    EmployeeSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @Override
    public Stream<NhanVien> search(String query) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        return elasticsearchTemplate.search(nativeSearchQuery, NhanVien.class).map(SearchHit::getContent).stream();
    }
}