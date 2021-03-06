package com.xhp.crowdfunding_backend.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author yuchu
 * @email 
 * @date 2018-04-28 16:06:55
 */
@Data
public class Sponsor{

	/**
	 * 赞助商编号
	 */

	private String sid;
	/**
	 * 赞助商名称
	 */

	private String sname;
	/**
	 * 赞助商资金
	 */

	private Integer smoney;

}
