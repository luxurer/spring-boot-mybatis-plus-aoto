package com.ltt.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ltt.demo.common.common.bean.PageBean;
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

import static com.ltt.demo.common.common.bean.Result.successResult;

/**
 * <p>
 * 前端控制器1
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
        propertyService.add(property);
        return successResult();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result add(String id) {
        propertyService.delete(id);
        return successResult();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(String id) {
        return successResult(propertyService.detail(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(PageBean pageBean,String companyId) {
        List<Property> properties = propertyService.list(pageBean,companyId);
        return successResult(properties,pageBean);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result edit(@RequestBody Property property) {
        propertyService.edit(property);
        return successResult();
    }

}
