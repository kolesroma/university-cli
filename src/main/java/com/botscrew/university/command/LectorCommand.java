package com.botscrew.university.command;

import com.botscrew.university.entity.LectorEntity;
import com.botscrew.university.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class LectorCommand {
    private final LectorService lectorService;

    @ShellMethod
    public LectorEntity foo(Integer id) {
        return lectorService.findById(id);
    }

}
