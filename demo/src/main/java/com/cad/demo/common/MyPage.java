package com.cad.demo.common;

import com.cad.demo.entity.vo.UserVO;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class MyPage<T> {
    /**
     * 当前选择页
     */
    private int page;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 每页记录条数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 实体对象list
     */
    private List<T> list;


    /**
     * 功能描述:
     * 由PageInfo构造Page对象
     *
     * @param pageInfo
     * @return
     * @author twalk
     * @date 2019-06-02 11:17
     */
    public MyPage(PageInfo pageInfo) {
        this.list = pageInfo.getList();
        this.page = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pages = pageInfo.getPages();
    }

    public MyPage(List<T> list) {
        this.list = list;
    }

}
