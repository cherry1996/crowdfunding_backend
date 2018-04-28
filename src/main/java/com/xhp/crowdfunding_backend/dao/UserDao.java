package com.xhp.crowdfunding_backend.dao;
import com.xhp.crowdfunding_backend.common.Pagination;
import com.xhp.crowdfunding_backend.common.PageRequest;
import com.xhp.crowdfunding_backend.entity.User;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-28 16:06:55
 */

public interface UserDao{

    User findOne(Integer uid);

    List<User> findAll();

    Pagination<User> getPage(PageRequest pageRequest);

    User create(User user);

    void update(User user);

    boolean delete(Integer uid);
}
