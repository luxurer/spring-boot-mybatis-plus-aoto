package com.ltt.demo.entity;

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
 * <p>
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_property")
public class Property extends Model<Property> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private String id;

	/**
	 * 属性名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 属性唯一标识
	 */
	@TableField("code")
	private String code;

	/**
	 * 1 文本2数字3日期
	 */
	@TableField("type")
	private Integer type;

	/**
	 * 是否可编辑：0-否；1-是
	 */
	@TableField("can_edit")
	private Integer canEdit;

	/**
	 * 排序
	 */
	@TableField("order_num")
	private Integer orderNum;

	/**
	 * 最后更新时间戳
	 */
	@TableField("last_update_timestamp")
	private Long lastUpdateTimestamp;

	/**
	 * 所属集团
	 */
	@TableField("company_id")
	private String companyId;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Integer canEdit) {
		this.canEdit = canEdit;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Long getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Long lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
