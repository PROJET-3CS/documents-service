package com.example.user_managment.demo.controller;

import java.util.List;

import com.example.user_managment.demo.dto.DocumentDto;
import com.example.user_managment.demo.entity.Document;
import com.example.user_managment.demo.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin
public class DocumentController {
    
    @Autowired
    DocumentService documentService;

    @GetMapping("/{id}")
    public ResponseEntity<Document> getById(@PathVariable Long id){
        Document document = documentService.findById(id);
        return new ResponseEntity<Document>(document, HttpStatus.OK);
    }

    @GetMapping("/by_user/{userId}")
    public List<Document> getByUserId(@PathVariable("userId") Long userId){
        return documentService.findByUserId(userId);
    }

    @PostMapping("/")
    public ResponseEntity<Document> create(@RequestBody DocumentDto documentDto){
        Document document = documentService.create(documentDto);
        return new ResponseEntity<Document>(document, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> delete(@PathVariable Long id){
        documentService.delete(id);
        return new ResponseEntity<>("Document successfully deleted!", HttpStatus.OK);
    }
}
