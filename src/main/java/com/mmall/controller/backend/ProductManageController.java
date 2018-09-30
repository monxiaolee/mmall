package com.mmall.controller.backend;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.service.IFileService;
import com.mmall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by limengxiao on 2018/9/26.
 */

@Controller
@RequestMapping("/manage/product")
public class ProductManageController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IFileService iFileService;

    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product) {
        System.out.println("输出前台传过来的商品信息");
        System.out.println(product);

        iProductService.saveOrUpdateProduct(product);

//        填充增加商品的业务逻辑
        return null;
    }

    @RequestMapping("upload.do")
    @ResponseBody
    public ServerResponse upload(HttpSession session, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = iFileService.upload(file,path);
        return null;
    }
}
