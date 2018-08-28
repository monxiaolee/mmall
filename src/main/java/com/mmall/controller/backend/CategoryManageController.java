package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by monxiaoLee on 2018/8/26.
 */
@Controller
@RequestMapping("manage/caterogy")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    private ICategoryService iCategoryService;

    public ServerResponse addCategory(HttpSession session, String CategoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);

        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");

            //校验一下是否是管理员
            if(iUserService.checkAdminRole(user).isSuccess()) {
//                是管理员
//                增加处理分类的逻辑
                return iCategoryService.addCategory(categoryName,parentId);
            }
        }
    }

}
