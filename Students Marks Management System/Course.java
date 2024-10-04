public class Course {
    private String code;
    private String title;
    private int creditHours;
    private int numberOfQuizzes;
    private int numberOfAssignments;
    private Assessment[] assessment;
    private int currentAssessment;
    private int totalAssessments;
    private Assessment fullAssessment;
    private double totalPercentage;
    private int[] quizTotalMarks;
    private int[] quizObtainedMarks;
    private int[] assignmentTotalMarks;
    private int[] assignmentObtainedMarks;
    private int[] midTotalMarks;
    private int[] midObtainedMarks;
    private int[] finalTotalMarks;
    private int[] finalObtainedMarks;

    private double getTotalPercentage() {
        return totalPercentage;
    }

    private int calculateTotalPercentage() {
        totalPercentage = 0;
        for (int i = 0; i < getTotalAssessments(); i++) {
            totalPercentage += this.assessment[i].getPercentage();
        }
        return (int) getTotalPercentage();
    }

    public Assessment getFullAssessment() {
        return fullAssessment;
    }

    public void doFullAssessment(int day, int month, int year) {
        this.fullAssessment = new Assessment(day, month, year, new int[]{calculateTotalPercentage()});
    }

    Course(String code) {
        setCode(code);
    }

    Course(String code, String title, int creditHours, int numberOfQuizzes, int numberOfAssignments) {
        setCode(code);
        setTitle(title);
        setCreditHours(creditHours);
        setNumberOfQuizzes(numberOfQuizzes);
        setNumberOfAssignments(numberOfAssignments);
        setCurrentAssessment(0);
        setTotalAssessments();
        this.assessment = new Assessment[getTotalAssessments()];
    }

    private int getCurrentAssessment() {
        return currentAssessment;
    }

    private void setCurrentAssessment(int currentAssessment) {
        this.currentAssessment = currentAssessment;
    }

    private int getTotalAssessments() {
        return totalAssessments;
    }

    private void setTotalAssessments() {
        this.totalAssessments = 4;
    }

    public void doAssessment(int id, String type, int day, int month, int year) {
        Assessment newAssessment = switch (type) {
            case "Quiz", "quiz" -> new Assessment(id, type, day, month, year, this.quizTotalMarks, this.quizObtainedMarks);
            case "Assignment", "assignment" -> new Assessment(id, type, day, month, year, this.assignmentTotalMarks, this.assignmentObtainedMarks);
            case "Mid-Term", "mid-term" -> new Assessment(id, type, day, month, year, this.midTotalMarks, this.midObtainedMarks);
            case "Final-Term", "final-term" -> new Assessment(id, type, day, month, year, this.finalTotalMarks, this.finalObtainedMarks);
            default -> null;
        };
        setAssessment(newAssessment);
    }

    private void setAssessment(Assessment assessment) {
        this.assessment[getCurrentAssessment()] = assessment;
        setCurrentAssessment(getCurrentAssessment() + 1);
    }

    public Assessment getAssessment(int id) {
        for (int i = 0; i < getTotalAssessments(); i++) {
            if (this.assessment[i] != null) {
                if (this.assessment[i].getId() == id) {
                    return this.assessment[i];
                }
            }
        }
        System.out.println("Assessment ID not Found");
        return new Assessment(0);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private int getCreditHours() {
        return creditHours;
    }

    private void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    private int getNumberOfQuizzes() {
        return numberOfQuizzes;
    }

    private void setNumberOfQuizzes(int numberOfQuizzes) {
        this.numberOfQuizzes = numberOfQuizzes;
    }

    private int getNumberOfAssignments() {
        return numberOfAssignments;
    }

    private void setNumberOfAssignments(int numberOfAssignments) {
        this.numberOfAssignments = numberOfAssignments;
    }

    public void displayState() {
        System.out.println("The Course Code " + getCode());
        System.out.println("Title of Course: " + getTitle());
        System.out.println("Course Credit Hours: " + getCreditHours());
        System.out.println("No. of Quizzes: " + getNumberOfQuizzes());
        System.out.println("No. of Assignments: " + getNumberOfAssignments());
    }

    public void setQuizTotalMarks(int... marks) {
        int quizCount = 0;
        this.quizTotalMarks = new int[getNumberOfQuizzes()];
        if (marks.length == getNumberOfQuizzes()) {
            for (int i : marks) {
                this.quizTotalMarks[quizCount++] = i;
            }
        } else System.out.println("Total Quizzes Cant Exceed the limit " + getNumberOfQuizzes());
    }

    public void setQuizObtainedMarks(int... marks) {
        int quizCount = 0;
        this.quizObtainedMarks = new int[getNumberOfQuizzes()];
        if (marks.length == getNumberOfQuizzes()) {
            for (int i : marks) {
                this.quizObtainedMarks[quizCount++] = i;
            }
        } else System.out.println("Total Quizzes Cant Exceed the limit  " + getNumberOfQuizzes());
    }

    public void setAssignmentTotalMarks(int... marks) {
        int assignmentCount = 0;
        this.assignmentTotalMarks = new int[getNumberOfAssignments()];
        if (marks.length == getNumberOfAssignments()) {
            for (int i : marks) {
                this.assignmentTotalMarks[assignmentCount++] = i;
            }
        } else System.out.println("Total Assignment Cant Exceed the limit   " + getNumberOfAssignments());
    }

    public void setAssignmentObtainedMarks(int... marks) {
        int assignmentCount = 0;
        this.assignmentObtainedMarks = new int[getNumberOfAssignments()];
        if (marks.length == getNumberOfAssignments()) {
            for (int i : marks) {
                this.assignmentObtainedMarks[assignmentCount++] = i;
            }
        } else System.out.println("Total Assignment Cant Exceed the limit  " + getNumberOfAssignments());
    }

    public void setMidTermMarks(int totalMarks, int obtainedMarks) {
        this.midTotalMarks = new int[]{totalMarks};
        this.midObtainedMarks = new int[]{obtainedMarks};
    }

    public void setFinalTermMarks(int totalMarks, int obtainedMarks) {
        this.finalTotalMarks = new int[]{totalMarks};
        this.finalObtainedMarks = new int[]{obtainedMarks};
    }

}