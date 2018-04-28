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
public class Approval{

	/**
	 * 审批编号
	 */

	private String aid;
	/**
	 * 审批状态
	 */

	private String astate;
	/**
	 * 项目编号
	 */

	private String pid;
	/**
	 * 审批日期
	 */

	private Date adate;

}
