package com.ltt.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ltt.demo.common.common.bean.PageBean;
import com.ltt.demo.entity.Property;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
public interface PropertyService extends IService<Property> {

	void add(Property property);
	void delete(String  id);
	Property detail(String  id);
	void edit(Property property);
	List<Property> list(PageBean pageBean,String companyId);
}
