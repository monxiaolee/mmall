package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by limengxiao on 2018/9/29.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);

}
