package com.cmd.controller;

import com.cmd.payload.EmployeeDto;
import com.cmd.entity.Employee;
import com.cmd.repository.EmployeeRepository;
import com.cmd.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employee/")
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService,
                              EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmloyee(@Valid @RequestBody EmployeeDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        EmployeeDto employeeDto = employeeService.addEmployee(dto);

        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    //http://Localhost:8080/api/v1/employee/emp/1
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteEmployeeByID(@PathVariable Long id) {
        employeeService.deleteEmployeeByID(id);
        return new ResponseEntity<>("Deleted Record Successfully", HttpStatus.OK);
    }

    //http://localhost:api/v1/employee/empiId/10
    //{{url}}/api/v1/employee/empId/10
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeesById(@PathVariable long id, @RequestBody EmployeeDto dto) {
        EmployeeDto employeeDto = employeeService.updateEmployeesById(id, dto);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }

    //The Url looks Like>> http://localhost:8080/api/v1/employee/?pageSize=4&pageNo=1&sortBy=emailId&sortDir=asc
  //  http://localhost:8080/api/v1/employee/?pageSize=1&pageNo=3&sortBy=mobile&sortDir=desc
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees
    (

            @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize,
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDir", required = false, defaultValue = "asc") String sortDir
    ) {
        List<EmployeeDto> dtoPageNSort = employeeService.getAllEmployees(pageSize, pageNo, sortBy, sortDir);
        return new ResponseEntity<>(dtoPageNSort, HttpStatus.OK);

    }

    // http://localhost:8080/api/v1/employee/employeeId/1
    @GetMapping("/employeeId/{empId}")
    public ResponseEntity<EmployeeDto> getAllEmployeesById(@PathVariable Long empId) {
        EmployeeDto dtoId = employeeService.getEmployeesById(empId);
        return new ResponseEntity<>(dtoId, HttpStatus.OK);


    }


}



