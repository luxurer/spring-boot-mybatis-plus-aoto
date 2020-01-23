package com.ltt.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("t_student")
public class Student extends Model<Student> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;

	/**
	 * 学生名称
	 */
	@TableField("name")
	private String name;

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
	 * 所属公司
	 */
	@TableField("company_id")
	private String companyId;

	/**
	 * 性别
	 */
	@TableField("sex")
	private int sex;

	/**
	 * 出生日期
	 */
	@TableField("birthday")
	private Long birthday;

	/**
	 * 出生日期
	 */
	@TableField("sno")
	private String sno;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
