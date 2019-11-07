package duke.data;

public class Result extends Evidence {

    private Impression impression;

    /**
     * Represents results of an investigation based on the treatment prescribed for a patient.
     * A Result object corresponds to the result of an investigation into the symptoms of a Patient,
     * the particular impression, as well as an integer between 1-4 representing the priority
     * or significance of the result.
     * Attributes:
     * @param name the result
     * @param impression the impression object the result is tagged to
     * @param summary a summary of the result
     * @param priority the priority level of the evidence
    */
    public Result(String name, Impression impression, int priority, String summary) {
        super(name, impression, priority, summary);
    }

    @Override
    public String toString() {
        String informationString;
        informationString = "Name: " + this.getName() + "\n";
        informationString += "Impression: " + this.impression + "\n";
        informationString += "Impression: " + this.summary + "\n";
        informationString += "Impression: " + this.getPriority() + "\n";
        return super.toString() + informationString;
    }

    @Override
    public String toReportString() {
        return null;
    }

}
