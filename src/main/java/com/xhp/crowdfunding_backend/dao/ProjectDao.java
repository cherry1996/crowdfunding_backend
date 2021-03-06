package com.xhp.crowdfunding_backend.dao;
import com.xhp.crowdfunding_backend.common.Pagination;
import com.xhp.crowdfunding_backend.common.PageRequest;
import com.xhp.crowdfunding_backend.entity.Project;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-28 16:06:55
 */

public interface ProjectDao{

    Project findOne(String pid);

    List<Project> findAll();

    Pagination<Project> getPage(PageRequest pageRequest);

    Project create(Project project);

    void update(Project project);

    boolean delete(String pid);
}
