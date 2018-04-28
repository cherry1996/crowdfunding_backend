package com.xhp.crowdfunding_backend.dao;
import com.xhp.crowdfunding_backend.common.Pagination;
import com.xhp.crowdfunding_backend.common.PageRequest;
import com.xhp.crowdfunding_backend.entity.Order;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-28 16:06:55
 */

public interface OrderDao{

    Order findOne(String oid);

    List<Order> findAll();

    Pagination<Order> getPage(PageRequest pageRequest);

    Order create(Order order);

    void update(Order order);

    boolean delete(String oid);
}
