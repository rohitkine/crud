package com.kine.springboothibernate.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.kine.springboothibernate.entities.EmployeeEntity;
import com.kine.springboothibernate.model.EmployeeDetails;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	public EmployeeDetails toPojo(EmployeeEntity employeeEntity);

	public EmployeeEntity toEntity(EmployeeDetails employeeDetails);

	public EmployeeEntity updateEntity(@MappingTarget EmployeeEntity employeeEntity, EmployeeDetails employeeDetails);

}
