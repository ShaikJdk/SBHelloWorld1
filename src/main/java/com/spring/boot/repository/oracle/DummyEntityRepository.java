package com.spring.boot.repository.oracle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.oracle.DummyEntity;

public interface  DummyEntityRepository extends JpaRepository<DummyEntity, String> {
}
