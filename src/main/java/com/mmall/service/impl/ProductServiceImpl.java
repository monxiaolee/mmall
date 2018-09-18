package com.mmall.service.impl;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * Created by limengxiao on 2018/9/18.
 */
@Service("iProductService")
public class ProductServiceImpl implements IProductService {
    @Override
    public ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy) {
        return null;
    }
}
