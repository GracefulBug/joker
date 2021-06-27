package com.life.joker.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author zhengdeqi
 * @description Minio Service
 * @date 2021/6/26
 */
public interface MinioService {

    /**
     * 判断bucket是否存在
     *
     * @param bucketName
     * @return
     */
    Boolean bucketExists(String bucketName);

    /**
     * 创建Bucket
     *
     * @param bucketName
     */
    void createBucket(String bucketName);

    /**
     * 存储对象
     *
     * @param bucketName
     * @param objectName
     * @param file
     */
    void saveObject(String bucketName, String objectName, MultipartFile file);

}
