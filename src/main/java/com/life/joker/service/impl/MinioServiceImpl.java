package com.life.joker.service.impl;

import com.life.joker.service.MinioService;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhengdeqi
 * @description Minio Service 实现类
 * @date 2021/6/26
 */
@Slf4j
@Service
public class MinioServiceImpl implements MinioService {

    @Autowired
    MinioClient minioClient;

    @Override
    public Boolean bucketExists(String bucket) {
        BucketExistsArgs existsArgs = BucketExistsArgs.builder().bucket(bucket).build();
        try {
            return minioClient.bucketExists(existsArgs);
        } catch (Exception e) {
            log.error("判断bucket是否存在异常：{}", e.getLocalizedMessage());
        }
        return Boolean.FALSE;
    }

    @Override
    public void createBucket(String bucketName) {
        MakeBucketArgs makeBucketArgs = MakeBucketArgs.builder()
                .bucket(bucketName)
                .objectLock(true)
                .build();
        try {
            minioClient.makeBucket(makeBucketArgs);
            SetBucketPolicyArgs setBucketPolicyArgs = SetBucketPolicyArgs.builder()
                    .bucket(bucketName)
                    .config("*.*")
                    .build();
            minioClient.setBucketPolicy(setBucketPolicyArgs);
        } catch (Exception e) {
            log.error("创建bucket异常，{}", e.getLocalizedMessage());
        }
    }

    @Override
    public void saveObject(String bucketName, String fileName, MultipartFile file) {
        try {
            if (StringUtils.isBlank(fileName)) {
                fileName = file.getName();
            }
            PutObjectArgs objectArgs = PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();
            minioClient.putObject(objectArgs);
        } catch (Exception e) {
            log.error("存储对象异常，{}", e.getLocalizedMessage());
        }
    }
}
