package com.example.user_managment.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.user_managment.demo.dto.DocumentDto;
import com.example.user_managment.demo.entity.Document;
import com.example.user_managment.demo.exception.NotFoundException;
import com.example.user_managment.demo.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public Document findById(Long id){
        Document document = documentRepository.findById(id).get();
        if(document == null)
			throw new NotFoundException();
        return document;
    }

    public List<Document> findByUserId(Long userId){
        return documentRepository.findByUserId(userId);
    }

    public Document save(Document document){
        return documentRepository.save(document);
    }

    public Document create(DocumentDto dto){

        Document document = new Document();
        document.setUserId(dto.getUserId());
        document.setDate(dto.getDate());
        document.setText(dto.getText());
        
        return this.save(document);
    }

    public void delete(Long id){
        Document document = this.findById(id);
        documentRepository.delete(document);
    }
}
