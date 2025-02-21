package duke.data;

import duke.exception.DukeException;

import java.util.HashMap;
import java.util.Map;

public class Patient extends DukeObject {

    private String bedNo;
    private String allergies;
    private Impression priDiagnosis;
    private HashMap<String, Impression> impressions;

    private Integer height;
    private Integer weight;
    private Integer age;
    private Integer number;
    private String address;
    private String history;

    /**
     * Represents the patient.
     * A Patient object corresponds to the biometric information of a patient,
     * patient details, medical history, the impressions the doctor has about a patient.
     * Attributes:
     * - priDiagnosis the chief complaint or most serious impression of a patient
     * - impression the list of all impressions of a patient
     *
     * @param name      the name of the patient
     * @param bedNo     the bed number of the patient
     * @param height    the height of the patient
     * @param weight    the weight of the patient
     * @param age       the age of the patient
     * @param number    the contact details of a patient's NOK
     * @param address   the residential address of a patient
     * @param history   the medical history of a patient
     * @param allergies the Food and Drug allergies a patient has
     */
    public Patient(String name, String bedNo, String allergies, Integer height, Integer weight,
                   Integer age, Integer number, String address, String history) {
        super(name);
        this.bedNo = bedNo;
        this.allergies = allergies;
        this.impressions = new HashMap<String, Impression>();

        this.height = height;
        this.weight = weight;
        this.age = age;
        this.number = number;
        this.address = address;
        this.history = history;
        this.priDiagnosis = new Impression("No Primary Impression", "Add upon admission diagnosis", this);

    }

    /**
     * Represents the patient.
     * A Patient object corresponds to the biometric information of a patient,
     * patient details, medical history, the impressions the doctor has about a patient.
     * Attributes:
     *
     * @param name      the name of the patient
     * @param bedNo     the bed number of the patient
     * @param allergies the Food and Drug allergies a patient has
     */
    public Patient(String name, String bedNo, String allergies) {
        super(name);
        this.bedNo = bedNo;
        this.allergies = allergies;
        this.impressions = new HashMap<String, Impression>();
        this.height = null;
        this.weight = null;
        this.age = null;
        this.number = null;
        this.address = null;
        this.history = null;
        this.priDiagnosis = null;
    }

    /**
     * This discharge function runs the procedure to discharges a patient from the hospital.
     * Todo write the function
     */
    public void discharge() {
        // Todo
    }

    /**
     * This addNewImpression function adds a new impression to the impressions list.
     *
     * @param newImpression the impression to be added
     * @return the Impression newly added
     */

    public Impression addNewImpression(Impression newImpression) {
        this.impressions.put(newImpression.getName(), newImpression);
        return newImpression;
    }

    /**
     * This deleteImpression function deletes an impression at the specified index
     * from the impressions list.
     *
     * @param keyIdentifier name of the impression
     * @return the Impression of the deleted Impression
     */
    public Impression deleteImpression(String keyIdentifier) throws DukeException {
        if (this.impressions.containsKey(keyIdentifier)) {
            Impression imp = this.impressions.get(keyIdentifier);
            this.impressions.remove(keyIdentifier);
            return imp;
        } else {
            throw new DukeException("I don't have that entry in the list!");
        }
    }

    /**
     * This getImpression function returns the impression from the impressions list at the specified index.
     *
     * @param keyIdentifier index of the impression
     * @return Impression the impression specified by the index
     */
    public Impression getImpression(String keyIdentifier) throws DukeException {
        if (this.impressions.containsKey(keyIdentifier)) {
            Impression imp = this.impressions.get(keyIdentifier);
            return imp;
        } else {
            throw new DukeException("I don't have that entry in the list!");
        }
    }

    /**
     * Sets the Primary Diagnosis of the patient specified by the index chosen.
     *
     * @param keyIdentifier index of the impression
     */
    public void setPriDiagnosis(String keyIdentifier) throws DukeException {
        if (this.impressions.containsKey(keyIdentifier)) {
            Impression imp = this.impressions.get(keyIdentifier);
            this.priDiagnosis = imp;
            return;
        } else {
            throw new DukeException("I don't have that entry in the list!");
        }
    }

    /**
     * This function find returns a list of all DukeObjs
     * with names related to the patient containing the search term.
     *
     * @param searchTerm String to be used to filter the DukeObj
     * @return the hashMap of DukeObjs
     */
    public HashMap<String, DukeObject> find(String searchTerm) throws DukeException {
        int i = 1;
        HashMap<String, DukeObject> searchResult = new HashMap<String, DukeObject>();
        for (Map.Entry mapElement : this.impressions.entrySet()) {
            Impression value = (Impression) mapElement.getValue();
            if (value.toString().contains(searchTerm)) {
                searchResult.put(value.getName(), value);
                ++i;
            }
        }
        if (i == 1) {
            throw new DukeException("Can't find any matching tasks!");
        } else {
            return searchResult;
        }
    }

    /**
     * This function appends an addition to the history of a Patient.
     * @param addition the string to be added
     * @return the new history
     */
    public String appendHistory(String addition) {
        String newHistory;
        if (this.history != null && !this.history.equals("")) {
            newHistory = this.history + "\t" + addition;
        } else {
            newHistory = addition;
        }
        this.history = newHistory; // setHistory(newHistory);
        return newHistory;
    }

    /**
     * This function find returns if a patient is allergic to an allergy.
     *
     * @param allergy String the possible allergy striped of spaces
     * @return boolean
     */
    public boolean isAllergic(String allergy) {
        return this.allergies.contains(allergy);
    }

    /**
     * Returns a string representation of a patient displaying all the values of the patient's attributes
     * in a reader-friendly format.      *
     *
     * @return string representation of patient
     */
    public String toString() {
        String informationString;
        informationString = "Personal details\n";
        informationString += "Height: " + Integer.toString(this.height) + "\n";
        informationString += "Weight: " + Integer.toString(this.weight) + "\n";
        informationString += "Age: " + Integer.toString(this.age) + "\n";
        informationString += "Number: " + Integer.toString(this.number) + "\n";
        informationString += "Address: " + this.address + "\n";
        informationString += "History: " + this.history + "\n";
        informationString += "Registration details\n";
        informationString += "Bed Number: " + this.bedNo + "\n";
        informationString += "Allergies: " + this.allergies + "\n";
        informationString += "Primary Diagnosis: " + this.priDiagnosis.toString() + "\n";
        for (Map.Entry mapElement : this.impressions.entrySet()) {
            Impression imp = (Impression) mapElement.getValue();
            informationString += imp.toString();
        }
        return super.toString() + informationString + "\n";
    }

    @Override
    public String toDisplayString() {
        // Todo
        return null;
    }

    @Override
    public String toReportString() {
        String informationString;
        informationString = "\tName of patient: " + getName() + "\n";
        informationString += "\tBed Number: " + this.bedNo + "\n";
        if (this.height != null) {
            informationString += "\tHeight: " + Integer.toString(this.height) + "\n";
        }
        if (this.weight != null) {
            informationString += "\tWeight: " + Integer.toString(this.weight) + "\n";
        }
        if (this.allergies != null) {
            informationString += "\tAllergies: " + this.allergies + "\n";
        }
        if (this.age != null) {
            informationString += "\tAge: " + Integer.toString(this.age) + "\n";
        }
        if (this.number != null) {
            informationString += "\tNumber: " + Integer.toString(this.number) + "\n";
        }
        if (this.address != null) {
            informationString += "\tAddress: " + this.address + "\n";
        }
        if (this.history != null) {
            informationString += "\tHistory: " + this.history + "\n";
        }
        if (this.priDiagnosis != null) {
            informationString += "\tRegistration details:\n";
            informationString += "\tAllergies: " + this.allergies + "\n";
            informationString += "\tPrimary Diagnosis: " + this.priDiagnosis.getDescription() + "\n";
            informationString += "\nData about doctors impression of the patient and associated"
                    + " treatments and evidences;";
            for (Map.Entry mapElement : this.impressions.entrySet()) {
                Impression imp = (Impression) mapElement.getValue();
                informationString += imp.toReportString();
            }
        }
        return informationString + "\n\n";
    }

    public String getBedNo() {
        return bedNo;
    }

    public HashMap<String, Impression> getImpressions() {
        return impressions;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Impression getPriDiagnosis() {
        return priDiagnosis;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
