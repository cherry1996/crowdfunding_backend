package com.xhp.crowdfunding_backend.dao;
import com.xhp.crowdfunding_backend.common.Pagination;
import com.xhp.crowdfunding_backend.common.PageRequest;
import com.xhp.crowdfunding_backend.entity.Projectclassification;
import java.util.List;
/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-28 16:06:55
 */

public interface ProjectclassificationDao{

    Projectclassification findOne(String pcid);

    List<Projectclassification> findAll();

    Pagination<Projectclassification> getPage(PageRequest pageRequest);

    Projectclassification create(Projectclassification projectclassification);

    void update(Projectclassification projectclassification);

    boolean delete(String pcid);
}
