package com.botscrew.university.command;

import com.botscrew.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class DepartmentCommand {
    private final DepartmentService departmentService;

    @ShellMethod(key = "Who is head of department",
            value = "Shows the head of department. Head either can be an employee in his department or no")
    public String getHeadInfo(String departmentName) {
        var head = departmentService.findByName(departmentName)
                .getHead();
        return String.format("Head of %s department is %s %s",
                departmentName,
                head.getName(),
                head.getSurname()
        );
    }

    @ShellMethod(key = "Show statistics",
            value = "Shows stats for department (includes all employees). Empty department if no employees")
    public String getStatistics(String departmentName) {
        var degreeLectorsMap = departmentService.getDegreeLectorsMap(departmentName);
        if (degreeLectorsMap.isEmpty()) {
            return "empty department";
        }
        StringBuilder statistics = new StringBuilder();
        for (var degreeLectorsEntry : degreeLectorsMap.entrySet()) {
            statistics.append(degreeLectorsEntry.getKey().getName())
                    .append(" - ")
                    .append(degreeLectorsEntry.getValue().size())
                    .append("\n");
        }
        return statistics.toString().strip();
    }

    @ShellMethod(key = "Show the average salary for the department",
            value = "Shows average salary. 0 if no employees")
    public String getAverageSalaryInfo(String departmentName) {
        return String.format("The average salary of %s is %s",
                departmentName,
                departmentService.getAverageSalary(departmentName)
        );
    }

    @ShellMethod(key = "Show count of employee for",
            value = "Shows employee count in department")
    public Integer getCountEmployeeInfo(String departmentName) {
        return departmentService.findByName(departmentName)
                .getLectorList()
                .size();
    }

    @ShellMethod(key = "Global search by",
            value = "Searches lectors with name and surname like template")
    public String getGlobalSearchInfo(String keyword) {
        var lectors = departmentService.findByKeyword(keyword);
        if (lectors.isEmpty()) {
            return "no results";
        }
        return String.join(", ", lectors);
    }
}
