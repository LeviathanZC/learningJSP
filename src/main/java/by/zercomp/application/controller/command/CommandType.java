package by.zercomp.application.controller.command;

import by.zercomp.application.controller.JspPath;
import by.zercomp.application.controller.command.impl.EmptyCommand;
import by.zercomp.application.controller.command.impl.IncludeCategories;
import by.zercomp.application.controller.command.impl.LogInCommand;
import by.zercomp.application.controller.command.impl.SignUpCommand;
import by.zercomp.application.controller.router.Router;

public enum CommandType {

    WELCOME_GET(((request, response) -> new Router(JspPath.WELCOME))),
    LOGIN_COMMAND(new LogInCommand()),
    SIGN_UP_COMMAND(new SignUpCommand()),
    INCLUDE_CATEGORIES(new IncludeCategories()),
    EMPTY(new EmptyCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrent() {
        return command;
    }

}
