public class Grade {
    private String name;
    private int minPercentage;
    private String remarks;
    private int obtainedPercentage;

    Grade(int minPercentage, int obtainedPercentage) {
        setMinPercentage(minPercentage);
        setObtainedPercentage(obtainedPercentage);
        calculateGrade();
    }

    private int getObtainedPercentage() {
        return obtainedPercentage;
    }

    private void setObtainedPercentage(int obtainedPercentage) {
        this.obtainedPercentage = obtainedPercentage;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getMinPercentage() {
        return minPercentage;
    }

    private void setMinPercentage(int minPercentage) {
        this.minPercentage = minPercentage;
    }

    private String getRemarks() {
        return remarks;
    }

    private void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void calculateGrade() {
        if (getObtainedPercentage() >= 80) {
            setName("A");
            setRemarks("Excellent");
        } else if (getObtainedPercentage() >= 65) {
            setName("B");
            setRemarks("Good");
        } else if (getObtainedPercentage() >= 50) {
            setName("C");
            setRemarks("Satisfactory");
        } else if (getObtainedPercentage() >= 40) {
            setName("D");
            setRemarks("Pass");
        } else if (getObtainedPercentage() < getMinPercentage()) {
            setName("F");
            setRemarks("Fail");
        }
    }

    public void displayState() {
        System.out.println("Grade:\t\t" + getName());
        System.out.println("Remarks: " + getRemarks());
    }
}
