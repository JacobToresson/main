package duke.command;

// TODO: Write different commands for different contexts

import duke.ui.Context;

/**
 * Maintains the associations between command keywords and commands (e.g. "list" -> ListCommand). For use in parsing
 * user input.
 */
public class Commands {
    /**
     * Constructs and returns the command corresponding to a name provided by the user.
     *
     * @param cmdStr The user-provided name.
     * @return The newly constructed command without any parameters loaded.
     */
    public Command getCommand(String cmdStr, Context context) {
        // check context-independent switches first
        // maybe supply context as argument?
        switch (cmdStr) {
        case "bye":
            return new ByeCommand();
        case "back":
            //return new BackCommand();
        case "up":
            //return new UpCommand();
        default:
            break; //not one of these; continue
        }

        switch (context) {
        case HOME:
            switch (cmdStr) {
            case "find":
                return new PatientFindCommand();
            case "new":
                return new HomeNewCommand();
            case "open":
                return new HomeOpenCommand();
            case "report":
                return new HomeReportCommand();
            case "discharge":
                return new HomeDischargeCommand();
            case "history":
                return new HomeHistoryCommand();
            case "help":
                return new HomeHelpCommand();
            default:
                return null;
            }
        case PATIENT:
            switch (cmdStr) {
            case "report":
                return new PatientReportCommand();
            case "discharge":
                return new PatientDischargeCommand();
            default:
                return null;
            }

        case TREATMENT:
            if ("status".equals(cmdStr)) {
                //return new TreatmentStatusCommand();
                break;
            }
            //fallthrough
        case INVESTIGATION:
            if ("result".equals(cmdStr)) {
                //return new InvxResultCommand();
                break;
            }
            //fallthrough
        case EVIDENCE:

        default:
            break;
        }
        return null;
    }
}
