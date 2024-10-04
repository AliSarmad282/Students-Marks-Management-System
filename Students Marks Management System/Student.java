public class Student {


            private int id;
            private String name;
            private String program;
            private final Course[] courses;
            private int totalNumberOfCourses;
            private int maxCourses;

         Student(int id, String name, String program, int maxCourses) {
            setId(id);
            setName(name);
            setProgram(program);
            setTotalNumberOfCourses(0);
            setMaxCourses(maxCourses);
            this.courses = new Course[maxCourses];
        }

        private int getTotalNumberOfCourses() {
            return totalNumberOfCourses;
        }

        private void setMaxCourses(int maxCourses) {
            this.maxCourses = maxCourses;
        }

        private void setTotalNumberOfCourses(int totalNumberOfCourses) {
            this.totalNumberOfCourses = totalNumberOfCourses;
        }

        private int getId() {
            return id;
        }

        private int getMaxCourses() {
            return maxCourses;
        }

        private void setId(int id) {
            this.id = id;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private String getProgram() {
            return program;
        }

        private void setProgram(String program) {
            this.program = program;
        }

        private void setCourses(Course C) {
            this.courses[getTotalNumberOfCourses()] = C;
        }

        public Course getCourses(String courseCode) {
             for (int i = 0; i < getTotalNumberOfCourses(); i++) {
                if (this.courses[i] != null) {
                    if (this.courses[i].getCode().equals(courseCode)) {
                        return this.courses[i];
                    }
                }
            }
                System.out.println("The Code Of Course Is Wrong");
                return new Course(null);
        }

        public void displayState() {
            System.out.println("Name Of Student" + getName());
            System.out.println("Students Id" + getId());
            System.out.println("Students Program " + getProgram());
            System.out.print("Students Registered Courses ");
            for (int i = 0; i < getTotalNumberOfCourses(); i++) {
                if (i < getTotalNumberOfCourses() - 1) {
                    System.out.print(this.courses[i].getTitle() + " , ");
                } else System.out.print(this.courses[i].getTitle());
            }
            System.out.println();
        }

        public void registerCourse(Course C) {
            if (getTotalNumberOfCourses() < getMaxCourses()) {
                setCourses(C);
                setTotalNumberOfCourses(getTotalNumberOfCourses() + 1);
            } else System.out.println("Courses Reached Out Of Limit " + getMaxCourses());
        }

        public void printGradeBook() {
            double gpa;
            int TotalGPA = 0;
            System.out.println("\nSubject\t\t\tMarks\t\tGrade\t\tGrade Point");
            for (Course course : this.courses) {
                if (course != null) {
                    String subject = course.getCode();
                    double marks = course.getFullAssessment().getPercentage();
                    String grade = course.getFullAssessment().getGrade().getName();
                    System.out.print(subject + "\t\t\t" + marks + "\t\t" + grade + "\t\t\t");
                    switch (grade) {
                        case "A" -> {
                            System.out.println("4");
                            TotalGPA += 4;
                        }
                        case "B" -> {
                            System.out.println("3");
                            TotalGPA += 3;
                        }
                        case "C" -> {
                            System.out.println("2");
                            TotalGPA += 2;
                        }
                        case "D" -> {
                            System.out.println("1");
                            TotalGPA += 1;
                        }
                        default -> {
                            System.out.println("0");
                            TotalGPA += 0;
                        }
                    }
                }
            }
            gpa = (double) TotalGPA / getTotalNumberOfCourses();
            System.out.print("GPA= " + gpa + " , ");
            if (gpa > 3.5) {
                System.out.println("Excellent");
            } 
            else if (gpa > 2.5) {
                System.out.println("Good");
            } 
            else if (gpa > 2) {
                System.out.println("Satisfactory");
            } 
            else if (gpa > 1) {
                System.out.println("Pass");
            } 
            else System.out.println("Fail");
        }
    }
