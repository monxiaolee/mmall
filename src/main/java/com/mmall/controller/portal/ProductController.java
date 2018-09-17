package com.mmall.controller.portal;

import com.mmall.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by limengxiao on 2018/9/17.
 */
@Controller
@RequestMapping("/portal/product")
public class ProductController {

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse list() {
        System.out.println("ceshi");
        return null;
    }
}
