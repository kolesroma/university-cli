package com.botscrew.university.command;

import com.botscrew.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class DepartmentCommand {
    private final DepartmentService departmentService;

    @ShellMethod
    public String getHeadInfo(String departmentName) {
        var head = departmentService.findByName(departmentName)
                .getHead();
        return String.format("Head of %s department is %s %s",
                departmentName,
                head.getName(),
                head.getSurname()
        );
    }

    @ShellMethod
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
        return statistics.toString();
    }

}
