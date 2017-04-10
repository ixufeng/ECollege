package com.xf.college.model.apiwrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly10080 on 2015/3/18.
 */
public class Pagination {

    private Boolean isFirst = true; // 是否为首页
    private Boolean isLast = true; // 是否为尾页

    private Integer previous = 1; // 后一页
    private Integer next = 1; // 前一页

    private Integer pageIndex = 1; //当前页索引
    private Integer pageSize = 0; // 每页记录数

    private Integer rowCount = 1; // 总共记录数
    private Integer pageCount = 1; // 总共页数

    private List data;

    private List<Integer> indexList = new ArrayList<>();// 页面索引集合

    public Pagination() {
    }

    public Pagination(Integer pageSize, Integer pageIndex, Integer rowCount, Integer indexCount) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.rowCount = rowCount;

        // 计算总共页数
        if (rowCount % pageSize == 0) {
            this.pageCount = rowCount / pageSize;
        } else {
            this.pageCount = rowCount / pageSize + 1;
        }
        // 判断索引是否正常
        if (pageIndex < 1 || pageIndex > pageCount) {
            return;
        }

        // 前一页
        if (this.pageIndex > 1) {
            this.previous = this.pageIndex - 1;
        }
        // 后一页
        if (this.pageIndex == this.pageCount) {
            this.next = this.pageCount;
        } else {
            this.next = this.pageIndex + 1;
        }
        // 首页判断
        if (this.pageIndex == 1) {
            this.isFirst = true;
        } else {
            this.isFirst = false;
        }
        // 尾页判断
        if (this.pageIndex == this.pageCount) {
            this.isLast = true;
        } else {
            this.isLast = false;
        }

        //结束生成索引
        if(indexCount == null){
            return;
        }
            /* 索引列生成 */
        int per = indexCount / 2;
        // 计算当前页前的索引分布
        if (pageIndex - per > 2) {
            // 绑上首页
            indexList.add(1);
            // 计算 前一个索引列中间页索引  小于0为占位符
            int _pl = pageIndex - per * 2 - 1;
            if (_pl <= 0) {
                _pl = 1;
            }
            indexList.add(_pl * -1);

            for (int i = pageIndex - per; i < pageIndex; i++) {
                indexList.add(i);
            }
        } else {
            for (int i = 1; i < pageIndex; i++) {
                indexList.add(i);
            }
        }
        // 计算当前页后的索引分布
        if (pageIndex + per < pageCount - 1) {
            for (int i = pageIndex; i <= pageIndex + per; i++) {
                indexList.add(i);
            }
            // 计算 前一个索引列中间页索引  小于0为占位符
            int _pl = pageIndex + per * 2 + 1;
            if (_pl >= pageCount) {
                _pl = pageCount;
            }
            indexList.add(_pl * -1);

            // 绑上尾页
            indexList.add(pageCount);
        } else {
            for (int i = pageIndex; i <= pageCount; i++) {
                indexList.add(i);
            }
        }


    }

    public Boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    public Boolean getIsLast() {
        return isLast;
    }

    public void setIsLast(Boolean isLast) {
        this.isLast = isLast;
    }

    public Integer getPrevious() {
        return previous;
    }

    public void setPrevious(Integer previous) {
        this.previous = previous;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<Integer> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<Integer> indexList) {
        this.indexList = indexList;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
