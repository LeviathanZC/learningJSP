package by.zercomp.application.controller.command;

import by.zercomp.application.controller.JspPath;
import by.zercomp.application.controller.router.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionProvider {

    private static Logger log = LogManager.getLogger(ActionProvider.class);

    private ActionProvider() {}

    public static ActionCommand defineAction(String action) {
        ActionCommand command = ((request, response) -> new Router(JspPath.ERROR_404));
        try {
            if (action != null) {
                command = CommandType.valueOf(action.toUpperCase()).getCurrent();
            }
        } catch (IllegalArgumentException e) {
            log.error(e);
        }
        return command;
    }

}
