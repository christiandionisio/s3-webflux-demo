package com.example.s3webfluxdemo.service;

import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

public interface AwsS3Service {

  Mono<byte[]> getByteObject(@NotNull String key);

}
