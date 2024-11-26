package com.cmd.service;

import com.cmd.exception.ResourceNotFound;
import com.cmd.payload.EmployeeDto;
import com.cmd.entity.Employee;
import com.cmd.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public EmployeeDto addEmployee(EmployeeDto dto) {
        Employee employee = modelMapper.map(dto, Employee.class);
        Employee saved = employeeRepository.save(employee);

        EmployeeDto Dto = modelMapper.map(dto, EmployeeDto.class);

        //Dto.setDate(new Date());

        //Dto.getCreatedAt();
        return Dto;
    }

    public void deleteEmployeeByID(Long id) {

            employeeRepository.deleteById(id);//throw an exception

    }

    public EmployeeDto updateEmployeesById(long id, EmployeeDto dto) {
                                /*Optional<Employee> emp = employeeRepository.findById(id);
                                if (emp.isPresent()) {
                                    Employee employee = emp.get();
                                   *//* employee.setId(dto.getId());*//*
                                    employee.setName(dto.getName());
                                    employee.setEmailId(dto.getEmailId());
                                    employee.setMobile(dto.getMobile());
                                    Employee updatedEmployee = employeeRepository.save(employee);
                                    return modelMapper.map(updatedEmployee, EmployeeDto.class);
                                                }*/
        Employee employee = mapToEntity(dto);
        employee.setId(dto.getId());
        Employee saved = employeeRepository.save(employee);
        return mapToDto(saved);
    }


    EmployeeDto mapToDto(Employee employee) {
        EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);
        return dto;

    }

    Employee mapToEntity(EmployeeDto dto) {
        Employee map = modelMapper.map(dto, Employee.class);

        return map;
    }

    public List<EmployeeDto> getAllEmployees(int pageSize, int pageNo, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

         /*Sort sort = Sort.by(sortBy);
        if ("desc".equalsIgnoreCase(sortDir)) {
            sort = sort.descending();  // Set descending order
        } else {
            sort = sort.ascending();   // Default to ascending order
        }*//*
        Pageable page = PageRequest.of(pageSize, pageNo, sort);*/
        /*Page<Employee> all = employeeRepository.findAll();*/
        /* List<Employee> employee =all.getContent();*/
        Pageable page = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> all = employeeRepository.findAll(page);
        List<Employee> employee = all.getContent();
        return employee.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public EmployeeDto getEmployeesById(Long empId) {
        Employee emp = employeeRepository.findById(empId).
                orElseThrow(

                        () -> new ResourceNotFound("Record not found for Id: " + empId)
                );
        EmployeeDto employeeDto = mapToDto(emp);
        return employeeDto;

    }
}


