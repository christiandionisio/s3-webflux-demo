package com.example.s3webfluxdemo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AwsProperties {
  @Value("${aws.access-key}")
  private String accessKey;

  @Value("${aws.secret-key}")
  private String secretKey;

  @Value("${aws.region}")
  private String region;

  @Value("${aws.s3-bucket-name}")
  private String s3BucketName;

  @Value("${aws.multipart-min-part-size}")
  private int multipartMinPartSize;

  @Value("${aws.endpoint}")
  private String endpoint;
}
