package com.mx.test.spring.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxisRepository extends JpaRepository<Taxis, Integer> {
}

