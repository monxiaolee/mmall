package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by limengxiao on 2018/9/14.
 */

@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        return null;
    }

    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        return null;
    }

    @Override
    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        return null;
    }

    @Override
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId) {
        return null;
    }
}
