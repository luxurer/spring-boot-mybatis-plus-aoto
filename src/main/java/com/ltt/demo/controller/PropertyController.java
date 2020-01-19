package com.ltt.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ltt.demo.common.common.bean.Result;
import com.ltt.demo.entity.Property;
import com.ltt.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器1
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/admin/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	/***
	 * @MethodName add
	 * @Description 新增指标
	 * @Author 刘伟
	 * @Date 2019/12/3 15:59
	 * @Return com.xdja.eidm.common.bean.Result
	 * @Exception
	 *
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(@RequestBody @Validated Property property) {
		try {
			propertyService.add(property);
			return Result.successResult();
		} catch (Exception e) {
			return Result.failResult(e.getMessage());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Result add(String id) {
		try {
			propertyService.delete(id);
			return Result.successResult();
		} catch (Exception e) {
			return Result.failResult(e.getMessage());
		}
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public List<Property> detail(String name) {
		try {
			return propertyService.detail(name);
		} catch (Exception e) {
			List<Property> list = new ArrayList<Property>();
			return list;
		}
	}

	@RequestMapping(value = "/searchAll", method = RequestMethod.GET)
	public List<Property> searchAll(int pageNo, int pageSize) {
		return propertyService.searchAll(pageNo,pageSize);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Result edit(@RequestBody Property property) {
		try {
			propertyService.edit(property);
			return Result.successResult();
		} catch (Exception e) {
			return Result.failResult(e.getMessage());
		}
	}

}
