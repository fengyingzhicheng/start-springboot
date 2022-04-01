package com.flyin.example.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王军
 * @description
 * @date 2022/3/25 10:23
 */
public class FilterChain {
    private final List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
    }
}