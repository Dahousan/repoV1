package com.allomed.app.repository.search;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryStringQuery;
import com.allomed.app.domain.Specialization;
import com.allomed.app.repository.SpecializationRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;

/**
 * Spring Data Elasticsearch repository for the {@link Specialization} entity.
 */
public interface SpecializationSearchRepository
    extends ElasticsearchRepository<Specialization, Long>, SpecializationSearchRepositoryInternal {}

interface SpecializationSearchRepositoryInternal {
    Page<Specialization> search(String query, Pageable pageable);

    Page<Specialization> search(Query query);

    @Async
    void index(Specialization entity);

    @Async
    void deleteFromIndexById(Long id);
}

class SpecializationSearchRepositoryInternalImpl implements SpecializationSearchRepositoryInternal {

    private final ElasticsearchTemplate elasticsearchTemplate;
    private final SpecializationRepository repository;

    SpecializationSearchRepositoryInternalImpl(ElasticsearchTemplate elasticsearchTemplate, SpecializationRepository repository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.repository = repository;
    }

    @Override
    public Page<Specialization> search(String query, Pageable pageable) {
        NativeQuery nativeQuery = new NativeQuery(QueryStringQuery.of(qs -> qs.query(query))._toQuery());
        return search(nativeQuery.setPageable(pageable));
    }

    @Override
    public Page<Specialization> search(Query query) {
        SearchHits<Specialization> searchHits = elasticsearchTemplate.search(query, Specialization.class);
        List<Specialization> hits = searchHits.map(SearchHit::getContent).stream().toList();
        return new PageImpl<>(hits, query.getPageable(), searchHits.getTotalHits());
    }

    @Override
    public void index(Specialization entity) {
        repository.findById(entity.getId()).ifPresent(elasticsearchTemplate::save);
    }

    @Override
    public void deleteFromIndexById(Long id) {
        elasticsearchTemplate.delete(String.valueOf(id), Specialization.class);
    }
}
