package com.fledzz.employeedetailsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeAPI {
    @GET("/users")
    Call<List<Employee>> getEmployees();

    @GET("/users/{id}")
    Call<Employee> getEmployee(@Path("id") int id);
}
