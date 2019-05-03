package com.chy.oa.base.pluging;

import java.util.ArrayList;
import java.util.List;

public class Page {
//    当前页   每页显示条数  总数data  总数page
    private Integer page;
    private Integer pageSize;
    private Integer pageCount;
    private Integer pageSum;
//    分页请求的URL 方便前台的分页导航的封装
    private String url;
//    当前应该显示的页码
    private List<Integer> indexs;

    public Page() {

    }

    public Page(Integer page, Integer pageSize, Integer pageCount, Integer pageSum, String url, List<Integer> indexs) {
        this.page = page;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.pageSum = pageSum;
        this.url = url;
        this.indexs = indexs;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        compulation();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSum() {
        return pageSum;
    }

    public void setPageSum(Integer pageSum) {
        this.pageSum = pageSum;
        compulation();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getIndexs() {
        return indexs;
    }

    public void setIndexs(List<Integer> indexs) {
        this.indexs = indexs;
    }

    //计算显示的页码 当前页 共多少页 如果第五页  显示
    public void compulation(){
        Integer page = getPage();
        Integer pageSum = getPageSum();
        if (page != null && pageSum != null){
            int beginIndex = Math.max(page-2,1);
            int endIndex = Math.min(page+2,pageSum);

            indexs = new ArrayList<Integer>();
            for (int i = beginIndex;i <= endIndex;i++){
                indexs.add(i);
            }
        }

    }
}
