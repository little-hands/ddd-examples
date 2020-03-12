package com.littlehands.task_management.good_example.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
  @GetMapping("")
  public String healthCheck() {
    return "ok";
  }
}
