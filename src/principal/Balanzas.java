package principal;

public enum Balanzas {
	MT_1229520536("MT_1229520536");

    private String numSerial;

    // Constructor
    Balanzas(String numSerial) {
        this.numSerial = numSerial;
    }

    // Getter
    public String getNumSerial() {
        return numSerial;
    }
}
