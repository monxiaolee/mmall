package com.mmall.service.impl;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by limengxiao on 2018/9/18.
 */
@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ServerResponse saveOrUpdateProduct(Product product) {

        if(product != null) {
            if(product.getId() != null) {
                // 更新产品逻辑
            } else {
                // 添加产品逻辑
                System.out.println("添加商品。。。");
                int rowCount = productMapper.insert(product);
                if(rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("新增产品成功");
                }
                return ServerResponse.createByErrorMessage("新增产品失败");
            }
        }

        return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");
    }

    @Override
    public ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy) {
        return null;
    }
}
