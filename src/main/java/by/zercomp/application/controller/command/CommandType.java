package by.zercomp.application.controller.command;

import by.zercomp.application.controller.command.impl.EmptyCommand;
import by.zercomp.application.controller.command.impl.LogInCommand;
import by.zercomp.application.controller.command.impl.SignUpCommand;

public enum CommandType {

    LOGIN_COMMAND(new LogInCommand()),
    SIGN_UP_COMMAND(new SignUpCommand()),
    EMPTY(new EmptyCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrent() {
        return command;
    }

}
