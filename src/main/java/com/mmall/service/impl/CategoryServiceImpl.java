package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by limengxiao on 2018/9/14.
 */

@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {
    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        System.out.println("执行了。。。");

//        private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

        if(parentId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("添加品类参数错误");
        }

        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);//这个分类是可用的

        System.out.println(category);

        int rowCount = categoryMapper.insert(category);

        if(rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加品类成功");
        }
        return ServerResponse.createByErrorMessage("添加商品失败");

//        int rowCount = categoryMapper.insert(category);
//
//        if(rowCount > 0) {
//            return ServerResponse.createBySuccessMessage("添加品类成功");
//        }
//        return ServerResponse.createByErrorMessage("添加品类失败");

//        return null;
    }

    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        return null;
    }


    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        // 这里的categoryMapper是从dao层的categoryMapper 引入的
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        System.out.println("输出结果->");
        System.out.println(categoryList);
        if(CollectionUtils.isEmpty(categoryList)) {
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

    /**
     * 递归查询本节点的id及孩子节点的id
     * @param categoryId
     * @return
     */

    @Override
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId) {
        Set<Category> categorySet = Sets.newHashSet();
        findChildCategory(categorySet, categoryId);

        List<Integer> categoryIdList = Lists.newArrayList();
        if(categoryId != null){
            for(Category categoryItem : categorySet){
                categoryIdList.add(categoryItem.getId());
            }
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }

//    递归算法算出子节点
    private Set<Category> findChildCategory(Set<Category> categorySet ,Integer categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);

        if(category != null){
            categorySet.add(category);
        }

//        查询子节点，递归算法一定要有一个退出条件
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for(Category categoryItem : categoryList) {
            findChildCategory(categorySet, categoryItem.getId());
        }

        return categorySet;
    }
}
