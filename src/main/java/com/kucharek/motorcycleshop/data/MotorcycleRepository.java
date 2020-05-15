package com.kucharek.motorcycleshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository
        extends JpaRepository<Motorcycle, Long> {
}
