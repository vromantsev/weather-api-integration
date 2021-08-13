package com.reed.integration.controller;

import com.reed.integration.dto.search.Search;
import com.reed.integration.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(final SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<Search>> searchFor(@PathVariable("city") final String city) {
        final List<Search> search = this.searchService.search(city);
        return ResponseEntity.ok().body(search);
    }
}
