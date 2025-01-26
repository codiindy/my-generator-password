package com.example.mygeneratepassword.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mygeneratepassword.PasswordGenerator;

@RestController
@RequestMapping("/api/password")
@CrossOrigin(origins = "http://localhost:8081")

public class PasswordController {

  @PostMapping("/generate")
  public String generatePassword(@RequestBody PasswordRequest request) {
    if (request.getLength() < 12) {
      return "Erreur : La longueur minimale est de 12 caractères.";
    }

    String enhancedWord1 = PasswordGenerator.addNumberAndSpecialChar(request.getWord1());
    String enhancedWord2 = PasswordGenerator.addNumberAndSpecialChar(request.getWord2());
    return PasswordGenerator.combineWords(enhancedWord1, enhancedWord2, request.getLength());
  }
}

class PasswordRequest {
  private String word1;
  private String word2;
  private int length;

  // Getters and setters
  public String getWord1() {
    return word1;
  }

  public void setWord1(String word1) {
    this.word1 = word1;
  }

  public String getWord2() {
    return word2;
  }

  public void setWord2(String word2) {
    this.word2 = word2;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
