package com.lkbackend.lkbackend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class S3DownloadController {
    @Value("${aws.s3.bucketName}")
    private static String BUCKET_NAME;

    @GetMapping("/downlaodPDF/{url}")
    public static void downloadDocumentFromS3(@PathVariable String url, String downloadPath) {
        Region region = Region.US_EAST_1; // Change this to your desired region
        S3Client s3Client = S3Client.builder().region(region).build();

        try {
            String objectKey = url.substring(1);
            // Construct the URL of the S3 object
            // Download the S3 object to the specified path
            ResponseBytes responseBytes = s3Client.getObjectAsBytes(GetObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(objectKey)
                    .build()); {

                byte[] content = responseBytes.asByteArray();

                try (OutputStream outputStream = new FileOutputStream(downloadPath)) {
                    outputStream.write(content);
                    System.out.println("Document downloaded successfully to: " + downloadPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (S3Exception e) {
            e.printStackTrace();
        } finally {
            s3Client.close();
        }
    }

    public static void main(String[] args) {
        String objectKey = "your-object-key"; // Change this to the key of the object you want to download
        String downloadPath = "path/to/save/downloaded/file"; // Change this to the desired path to save the downloaded file

        downloadDocumentFromS3(objectKey, downloadPath);
    }
}
