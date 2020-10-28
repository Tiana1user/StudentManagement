/*
@author NB
@date 2019/4/8 - 18:47
*/

package com.student.entity;

import java.util.List;

public class Page {
//    第几页 currcentPage
    private int currcentPage;
//    页面大小 pageSize
    private int pageSize;
//    当前页的数据集合 students
    private List<Student> students;
//    总数居 totalCount
    private int totalCount;
//    总页数 totalPage
    private int totalPage;

    public Page(int currcentPage, int pageSize, List<Student> students, int totalCount, int totalPage) {
        this.currcentPage = currcentPage;
        this.pageSize = pageSize;
        this.students = students;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }
    public Page() {

    }

    public int getCurrcentPage() {
        return currcentPage;
    }

    public void setCurrcentPage(int currcentPage) {
        this.currcentPage = currcentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    /*
    *总页数 = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1;
    *
    * 当我们调用了数据总数的set()和页面大小set以后，自动计算处总页数
    */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        //自动计算出总页数
        //总页数 = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1;
        this.totalPage =totalCount%pageSize==0? totalCount/pageSize:totalCount/pageSize+1;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }
    //给总页数赋值
//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }
}
