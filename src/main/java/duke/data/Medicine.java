package duke.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Medicine extends Treatment {

    private static final List<String> statusArr = Arrays.asList("Not ordered", "In progress", "Completed");
    private String dose;
    private String startDate;
    private String duration;

    /**
     * Represents the medicine needed to treat a symptom or impression of a patient.
     * A Medicine object corresponds to the medicine prescribed by a doctor to treat the signs
     * and symptoms of a Patient, the impression that led to that particular medicine being necessary,
     * the status of the treatment, a description of the status, the dosage, start date, duration of the treatment
     * as well as an integer between 1-4 representing the priority or significance of the investigation.
     * Attributes:
     * @param name the medicine needed
     * @param impression the impression object the medicine is tagged to
     * @param priority the priority level of the medicine
     * @param status the current status of the medicine
     * @param dose the dosage of the medicine needed
     * @param startDate the starting date when the patient should be on the medicine
     * @param duration the duration the patient needs to take the medicine
     */
    public Medicine(String name, Impression impression, int priority, int status,
                    String dose, String startDate, String duration) {
        super(name, impression, priority, status);
        this.dose = dose;
        this.startDate = startDate;
        this.duration = duration;
    }

    @Override
    public String toString() {
        String informationString;
        informationString = "Dose: " + this.dose + "\n";
        informationString += "Start Date: " + this.startDate + "\n";
        informationString += "Duration: " + this.duration + "\n";
        return super.toString() + informationString;
    }

    @Override
    public String toReportString() {
        return toString();
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatusStr() {
        return statusArr.get(getStatusIdx());
    }

    public static List<String> getStatusArr() {
        return Collections.unmodifiableList(statusArr);
    }

    @Override
    public String getSummary() {
        return "";
    }

    @Override
    public void setSummary(String summary) {
        // medicine does not have a summary
    }

    /**
     * Checks for equality with another Medicine object - all fields have the same value and all references point to
     * the same objects. Primarily for testing.
     * @param medicine The medicine to compare against.
     * @return True if all fields and references are the same, false otherwise.
     */
    public boolean equals(Medicine medicine) {
        if (super.equals(medicine)) {
            return dose.equals(medicine.dose)
                    && duration.equals(medicine.duration)
                    && startDate.equals(medicine.startDate);
        } else {
            return false;
        }
    }
}
