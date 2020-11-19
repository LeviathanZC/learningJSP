package by.zercomp.application.controller.command;

public enum CommandType {

    ;

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrent() {
        return command;
    }

}
