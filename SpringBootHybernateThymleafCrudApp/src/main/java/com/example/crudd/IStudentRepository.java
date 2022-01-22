package com.example.crudd;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStudentRepository extends CrudRepository<students,Integer> {
    public Long countById(Integer id);
}
