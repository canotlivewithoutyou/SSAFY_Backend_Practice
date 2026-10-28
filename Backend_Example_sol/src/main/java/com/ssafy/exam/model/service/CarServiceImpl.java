package com.ssafy.exam.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.model.dao.CarDaoImpl;
import com.ssafy.exam.model.dao.CarDao;
import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.model.dto.Car;


public class CarServiceImpl implements CarService {
    private CarDao dao = CarDaoImpl.getInstance();

    private static CarServiceImpl service = new CarServiceImpl();

    private CarServiceImpl() {
    }

    public static CarServiceImpl getService() {
        return service;
    }



	@Override
	public Member login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public List<Car> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}



	@Override
	public int insert(Car car) {
		// TODO Auto-generated method stub
		return dao.insert(car);
	}





}
