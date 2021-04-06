package com.ltt.demo.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 标准规范信息表
 * </p>
 *
 * @author liuwei
 * @since 2021-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_bzgf")
public class Bzgf extends Model<Bzgf> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("C_ID")
	private String id;

	/**
	 * 标题
	 */
	@TableField("C_TITLE")
	private String title;

	/**
	 * 内容
	 */
	@TableField("C_CONTENT")
	private String content;

	/**
	 * 创建人
	 */
	@TableField("C_CREATER_ID")
	private String createrId;

	/**
	 * 使用范围，多个用逗号分隔
	 */
	@TableField("C_SCOPE_DEPT_IDS")
	private String scopeDeptIds;

	/**
	 * 创建时间
	 */
	@TableField("N_CREATE_TIMESTAMP")
	private BigDecimal createTimestamp;

	/**
	 * 修改时间
	 */
	@TableField("N_UPDATE_TIMESTAMP")
	private BigDecimal updateTimestamp;

	/**
	 * 归属部门
	 */
	@TableField("C_BELONG_DEPT_ID")
	private String belongDeptId;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
