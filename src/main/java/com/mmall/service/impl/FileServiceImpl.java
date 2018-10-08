package com.mmall.service.impl;

import com.mmall.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by limengxiao on 2018/9/29.
 */

@Service("iFileService")
public class FileServiceImpl implements IFileService {
    @Override
    public String upload(MultipartFile file, String path) {
        return null;
    }
}
