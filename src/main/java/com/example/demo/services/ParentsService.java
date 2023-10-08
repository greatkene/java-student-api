package com.example.demo.services;

import com.example.demo.models.Parents;
import com.example.demo.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentsService {
    @Autowired
    private ParentsRepository parentsRepository;

    public Parents addNewParents(Parents parents) {
        return parentsRepository.save(parents);
    }
}
