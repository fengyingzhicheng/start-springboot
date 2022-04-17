package com.flyin.example.structure.filter;

/**
 * @author 王军
 * @description
 * @date 2022/3/25 10:24
 */
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(){
        filterChain = new FilterChain();
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        filterChain.execute(request);
    }
}