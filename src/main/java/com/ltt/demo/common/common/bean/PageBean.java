package com.ltt.demo.common.common.bean;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页Bean
 *
 * @author yxb
 * @since 2019/6/26
 */
public class PageBean {

    /**
     * 页码 默认1页
     */
    private Integer pageNo = 1;

    /**
     * 数量 默认10条
     */
    private Integer pageSize = 10;

    /**
     * 总数 默认0
     */
    private Long total = 0L;

    public PageBean() {

    }

    public PageBean(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageBean(Integer pageNo, Integer pageSize, Long total) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public static Page getPage(PageBean pageBean) {
        Page page = new Page();
        page.setCurrent(pageBean.getPageNo());
        page.setSize(pageBean.getPageSize());
        return page;
    }
}
