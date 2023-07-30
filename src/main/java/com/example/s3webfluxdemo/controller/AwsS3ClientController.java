package com.example.s3webfluxdemo.controller;

import com.example.s3webfluxdemo.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/s3")
@Validated
public class AwsS3ClientController {

  private final AwsS3Service awsS3Service;

  @GetMapping(path="/{fileKey}",
    // Changes file type
    produces = {MediaType.APPLICATION_PDF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
  public Mono<byte[]> download(@PathVariable("fileKey") String fileKey) {
    return awsS3Service.getByteObject(fileKey);
  }


}
