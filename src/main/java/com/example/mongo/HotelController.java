package com.example.mongo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
  private HotelRepo repo;

  public HotelController(HotelRepo repo) {
    this.repo = repo;
  }

  @GetMapping("/all")
  public List<Hotel> getAll() {
    return this.repo.findAll();
  }
}
