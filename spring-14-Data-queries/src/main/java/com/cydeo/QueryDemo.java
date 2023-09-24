package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class QueryDemo implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("getCountryContains: " + regionRepository.getByCountryContains("United"));
        System.out.println("findByCountryContainingOrderByRegionDesc: " + regionRepository.findByCountryContainingOrderByRegionDesc("United"));
        System.out.println("findByCountryContainingOrderByRegionAsc: " + regionRepository.findByCountryContainingOrderByRegionAsc("United"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion: " + regionRepository.findTopByCountryContainsOrderByRegion("United"));

        System.out.println("************** departments ************************");

        System.out.println("findByDepartment" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findAllByDivision" + departmentRepository.findAllByDivision("Health"));
        System.out.println("findByDivision" + departmentRepository.findByDivision("Health"));

        System.out.println("findByDivisionEndsWithIgnoreCase" + departmentRepository.findByDivisionEndsWithIgnoreCase("ics"));
        System.out.println("findDistinctTop3ByDivisionContaining" + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("************** employee ************************");

        System.out.println("findByEmail" + employeeRepository.findByEmail("lguppie68@army.mil"));
        System.out.println("findBySalaryGreaterThan" +employeeRepository.findBySalaryGreaterThan(BigDecimal.valueOf(165000)));
        System.out.println("findBySalaryGreaterThanEqualOrderBySalary" +employeeRepository.findBySalaryGreaterThanEqualOrderBySalary(BigDecimal.valueOf(145000)));
        System.out.println("findBySalaryGreaterThanEqualOrderBySalaryDesc" +employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(BigDecimal.valueOf(145000)));


    }

}
