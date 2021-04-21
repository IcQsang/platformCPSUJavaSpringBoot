package com.training.platform.services;


import com.training.platform.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Integer id);

    Page<User> findAllByLimit(Integer start, Integer limit, String field);

    List<User> findByCityAndActiveAndAge(String city, Integer active, Integer age);

    List<User> findByAgeIn(List<Integer> ages);

    List<User> findAllByQuery();

    List<User> findAllByParamsQuery(Integer active, String city);

    List<User> findAllByJpqlQuery();

    List<User> findAllByJpqlParamsQuery(Integer active, String city);

    List<User> findByCityIn(List<String> city);

    List<User> findByEmailIn(List<String> email);
}
