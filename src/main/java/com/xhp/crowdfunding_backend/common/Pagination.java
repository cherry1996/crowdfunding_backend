package com.xhp.crowdfunding_backend.common;


import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 分页类
 *
 * @author yuchu
 * @email 
 * @date 2018-04-28 16:06:55
 */
@Data
public class Pagination<T> {

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_START_PAGE = 1;
    //一页显示的记录数
    private int pageSize;
    //记录总数
    private int totalRows;
    //总页数
    private int totalPages;
    //当前页码
    private int pageNum;
    //起始行数
    private int startIndex;
    //结束行数
    private int lastIndex;
    //是否有下一页
    private boolean hasNextPage;
    //结果集存放List
    private List<T> resultList;

    public Pagination(String sql,PageRequest pageRequest,JdbcTemplate jTemplate){
        //设置每页显示记录数
        setPageSize(pageRequest.getPageSize()>0?pageRequest.getPageSize():DEFAULT_PAGE_SIZE);
        //设置要显示的页数
        setPageNum(pageRequest.getPageNum()>0?pageRequest.getPageNum():DEFAULT_START_PAGE);
        //计算总记录数
        StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
        totalSQL.append(sql);
        totalSQL.append(" ) totalTable ");
        //给JdbcTemplate赋值
        //总记录数
        setTotalRows(jTemplate.queryForObject(totalSQL.toString(),Integer.class));
        //计算总页数
        setTotalPages();
        //计算起始行数
        setStartIndex();
        //计算结束行数
        setLastIndex();
        //计算是否有下一页
        setHasNextPage(totalPages>pageNum);
        //构造mysql数据库的分页语句
        StringBuffer paginationSQL = new StringBuffer();
        paginationSQL.append(sql);
        paginationSQL.append(" limit "+startIndex+","+lastIndex);
        //装入结果集
        setResultList((List<T>) jTemplate.queryForList(paginationSQL.toString()));
    }

    private void setTotalPages() {
        if(totalRows % pageSize == 0){
            this.totalPages = totalRows / pageSize;
        }else{
            this.totalPages = (totalRows / pageSize) + 1;
        }
    }

    private void setStartIndex() {
        this.startIndex = (pageNum - 1) * pageSize;
    }
    //计算结束时候的索引
    private void setLastIndex() {
        if( totalRows < pageSize){
            this.lastIndex = totalRows;
        }else if((totalRows % pageSize == 0) || (totalRows % pageSize != 0 && pageNum < totalPages)){
            this.lastIndex = pageNum * pageSize;
        }else if(totalRows % pageSize != 0 && pageNum == totalPages){//最后一页
            this.lastIndex = totalRows ;
        }
    }
}

