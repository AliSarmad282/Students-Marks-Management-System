public class Assessment {
    private int id;
    private String type;
    private int day;
    private int month;
    private int year;
    private int[] totalMarks;
    private int[] marksObtained;
    private double percentage;
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    Assessment(int id) {
        setId(id);
    }

    Assessment(int day, int month, int year, int[] marksObtained) {
        setId(786);
        setType("Full");
        setDay(day);
        setMonth(month);
        setYear(year);
        setTotalMarks(new int[]{400});
        setMarksObtained(marksObtained);
        setPercentage(calculatePercentage());
        setPercentage(Math.round(getPercentage()));
    }

    public void calculateCourseGrade() {
        this.grade = new Grade(40, (int) Math.round(getPercentage()));
    }

    Assessment(int id, String type, int day, int month, int year, int[] totalMarks, int[] marksObtained) {
        setId(id);
        setType(type);
        setDay(day);
        setMonth(month);
        setYear(year);
        setTotalMarks(totalMarks);
        setMarksObtained(marksObtained);
        setPercentage(calculatePercentage());
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    private int getDay() {
        return day;
    }

    private void setDay(int day) {
        this.day = day;
    }

    private int getMonth() {
        return month;
    }

    private void setMonth(int month) {
        this.month = month;
    }

    private int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private int[] getTotalMarks() {
        return totalMarks;
    }

    private void setTotalMarks(int[] totalMarks) {
        this.totalMarks = totalMarks;
    }

    private int[] getMarksObtained() {
        return marksObtained;
    }

    private void setMarksObtained(int[] marksObtained) {
        this.marksObtained = marksObtained;
    }

    public double getPercentage() {
        return percentage;
    }

    private void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    private double calculatePercentage() {
        int obtainedMarksSum = 0;
        int totalMarksSum = 0;
        int[] marksObtained = getMarksObtained();
        int[] marksTotal = getTotalMarks();
        for (int i = 0; i < getMarksObtained().length; i++) {
            obtainedMarksSum += marksObtained[i];
            totalMarksSum += marksTotal[i];
        }
        return (double) obtainedMarksSum / totalMarksSum * 100;
    }

    public void displayState() {
        System.out.println("Assessment ID: " + getId());
        System.out.println("Assessment Type: " + getType());
        System.out.println("Date of Assessment: " + getDay() + "/" + getMonth() + "/" + getYear());
        int obtainedMarksSum = 0;
        int totalMarksSum = 0;
        int[] marksObtained = getMarksObtained();
        int[] marksTotal = getTotalMarks();
        for (int i = 0; i < getMarksObtained().length; i++) {
            obtainedMarksSum += marksObtained[i];
            totalMarksSum += marksTotal[i];
        }
        System.out.println("Total Marks: " + totalMarksSum);
        System.out.println("Obtained Marks: " + obtainedMarksSum);
        System.out.println("Percentage: " + getPercentage());
    }
}
