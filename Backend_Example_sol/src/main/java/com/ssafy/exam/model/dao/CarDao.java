package com.ssafy.exam.model.dao;

import java.util.List;

import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.model.dto.Car;


public interface CarDao {

    
    Member login(String email, String password);

	List<Car> selectAll();

	int insert(Car car);




}
