package com.springboot.jdbc.spring_demo;

import com.springboot.jdbc.spring_demo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarRepo {


    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }



    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    public void save(Car car) {

        String sql = "insert into car (id, year, make, model) values (?,?,?,?)";

        int rows = template.update(sql, car.getId(), car.getYear(), car.getMake(), car.getColor());
        System.out.println(rows + " rows inserted");

    }




    public List<Car> findAll() {

        String sql = "select * from car";

        RowMapper<Car> mapper = new RowMapper<Car>() {
            @Override
            public Car mapRow(ResultSet rs, int rowNum) throws SQLException {

                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setYear(rs.getInt("year"));
                car.setMake(rs.getString("make"));
                car.setColor(rs.getString("color"));

                return car;
            }
        };


        return template.query(sql, mapper);
        }
}

















