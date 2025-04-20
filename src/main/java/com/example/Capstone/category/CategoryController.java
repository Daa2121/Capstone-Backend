package com.example.Capstone.category;

import com.example.Capstone.category.Model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {


    @GetMapping("/test")
    public ResponseEntity<String> Test() {
        return ResponseEntity.ok().body("Success!");
    }
}
