package com.ssafy.exam.model.service;


import java.util.List;

import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.model.dto.Car;

public interface CarService {

    Member login(String email, String password);
    
	List<Car> selectAll();


	int insert(Car car);



    
}
