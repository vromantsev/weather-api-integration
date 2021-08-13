package com.reed.integration.service;

import com.reed.integration.dto.search.Search;

import java.util.List;

public interface SearchService {

    List<Search> search(final String city);

}
