package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Motorcycle;
import com.kucharek.motorcycleshop.data.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleServiceImpl
        implements MotorcycleService {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Override
    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

}
