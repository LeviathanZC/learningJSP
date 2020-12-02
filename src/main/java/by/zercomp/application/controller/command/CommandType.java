package by.zercomp.application.controller.command;

import by.zercomp.application.controller.command.impl.EmptyCommand;
import by.zercomp.application.controller.command.impl.LogInCommand;

public enum CommandType {

    LOGIN_COMMAND(new LogInCommand()),
    EMPTY(new EmptyCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrent() {
        return command;
    }

}
