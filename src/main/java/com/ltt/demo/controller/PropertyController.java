package com.ltt.demo.controller;


import com.ltt.demo.common.common.bean.Result;
import com.ltt.demo.entity.Property;
import com.ltt.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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



}
