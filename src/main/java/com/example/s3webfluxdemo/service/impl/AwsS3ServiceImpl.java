package com.example.s3webfluxdemo.service.impl;

import com.example.s3webfluxdemo.config.AwsProperties;
import com.example.s3webfluxdemo.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.core.BytesWrapper;
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

@RequiredArgsConstructor
@Slf4j
@Service
public class AwsS3ServiceImpl implements AwsS3Service {

  private final S3AsyncClient s3AsyncClient;
  private final AwsProperties s3ConfigProperties;

  @Override
  public Mono<byte[]> getByteObject(String key) {
    log.debug("Fetching object as byte array from S3 bucket: {}, key: {}", s3ConfigProperties.getS3BucketName(), key);
    return Mono.just(GetObjectRequest.builder().bucket(s3ConfigProperties.getS3BucketName()).key(key).build())
      .map(it -> s3AsyncClient.getObject(it, AsyncResponseTransformer.toBytes()))
      .flatMap(Mono::fromFuture)
      .map(BytesWrapper::asByteArray);
  }
}
