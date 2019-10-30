package duke.command.home;

import duke.command.ArgLevel;
import duke.command.ArgSpec;
import duke.command.Switch;

public class HomeNewSpec extends ArgSpec {
    private static final HomeNewSpec spec = new HomeNewSpec();

    public static HomeNewSpec getSpec() {
        return spec;
    }

    private HomeNewSpec() {
        emptyArgMsg = "You did not tell me anything about the patient you wish to add to the system!";
        cmdArgLevel = ArgLevel.REQUIRED;
        initSwitches(
                new Switch("bed", String.class, false, ArgLevel.REQUIRED, "b"),
                new Switch("allergies", String.class, false, ArgLevel.REQUIRED, "a",
                        "allergy"),
                new Switch("height", Integer.class, true, ArgLevel.REQUIRED, "h"),
                new Switch("weight", Integer.class, true, ArgLevel.REQUIRED, "w"),
                new Switch("age", Integer.class, true, ArgLevel.REQUIRED, "ag"),
                new Switch("number", Integer.class, true, ArgLevel.REQUIRED, "num"),
                new Switch("address", String.class, true, ArgLevel.REQUIRED, "ad"),
                new Switch("history", String.class, true, ArgLevel.REQUIRED, "hi"),
                new Switch("go", String.class, true, ArgLevel.NONE, "g")
        );
    }
}
