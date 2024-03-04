package com.lkbackend.lkbackend.s3handler;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.Duration;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class S3Handler {
    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    public URL getPresignedUrl(String keyName) {
        // Set the expiration time for the pre-signed URL (1 minute in this case)
        Duration expirationTime = Duration.ofMinutes(5);

        Date expiration = new Date(System.currentTimeMillis() + expirationTime.toMillis());

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, keyName, com.amazonaws.HttpMethod.GET);
        generatePresignedUrlRequest.setExpiration(expiration);

        return s3Client.generatePresignedUrl(generatePresignedUrlRequest);
    }
}
