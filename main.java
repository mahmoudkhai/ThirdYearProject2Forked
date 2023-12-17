import java.util.*;

//Student
public class main {
    public static void main(String[] args) {
        Employee drAhmed = new Employee("Ahmed", 323232, GENDER.MALE, "Menouf", 44, 014, JopTitle.PROFFESOR, "2015 / 7/3");
        Employee drOsama = new Employee("Osama", 323232, GENDER.MALE, "Menouf", 44, 014, JopTitle.PROFFESOR, "2015 / 7/3");
        Employee drOla = new Employee("Ola", 323232, GENDER.FEMALE, "Menouf", 44, 014, JopTitle.TEACHING_ASSISTANT, "2015 / 7/3");

        Student yousef = new Student("Bakr", 323232, GENDER.MALE, "Quesna", 95.0, 22, 011);
        Student bakr = new Student("Bakr", 323232, GENDER.MALE, "Quesna", 96.0, 22, 011);

        List<String> familyActivities = new LinkedList<String>();
        familyActivities.add("Awarness");
        familyActivities.add("Finanacial");
        familyActivities.add("Events");
        Family resalaFamily = new ResalaFamily(yousef, familyActivities);


        FamilyEvent conference = new FamilyEvent("Conference", "Conference to support Gaza", "FEE", 11, 1, 12);
        Trip tripToAlexandria = new Trip("Alexandria", "Trip to Alexandria", "Trip to Alexandria library", "30 / 12 / 2023", 170.0);
        resalaFamily.createTrip(tripToAlexandria);
        resalaFamily.createEvent(conference);

        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<Employee>();
        List<Student> students = new LinkedList<>();

        employees.add(drAhmed);
        employees.add(drOla);
        employees.add(drOsama);

        Integer userChoice;
        while (true) {
            System.out.println("press 1 to register as a student , press 2 to register as employee or press 0 to continue...");
            userChoice = scanner.nextInt();
            if (userChoice == 1) {
                Student newStudent = registerAsStudent();
                students.add(newStudent);
            } else if (userChoice == 2) employees.add(registerAsEmployee());
            else break;
        }
        List<Course> csCourseList = new ArrayList<Course>();
        csCourseList.add(new Course("Advanced JAVA", 20, drAhmed, 150.0, 0.0));
        csCourseList.add(new Course("Ai", 20, drOla, 100.0, 0.0));

        Department csDepartment = createDepartment(CollegeDepartments.COMPUTER_SCIENCE, employees, csCourseList, drOsama);

        System.out.println("press 1 to enroll department \n press 2 to join to family " +
                "\n press 3 to show family events and trips \n press 4 to to show faculty services \n ");

        Integer studentChoice = scanner.nextInt();

        switch (studentChoice) {
            case 1: {
                System.out.println("press 1 to enroll CS , press 2 to enroll Control , press 3 to enroll Communication");
                Integer choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        new DepartmentServices(csDepartment).enrollStudents(students.get(0));
                        break;
                    }
                    case 2: {
                    }
                    case 3: {
                    }
                    default: {
                        System.out.println("Invalid choice");
                    }
                }
            }
            case 2: {
                System.out.println("press 1 to enroll " + ResalaFamily.getFamilyName() + " , press 2 to enroll " + FeeLifeMakers.getFamilyName());
                Integer choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        HashMap<Student, FamilyMemberRole> hashMap = new HashMap<Student, FamilyMemberRole>();
                        hashMap.put(students.get(0), FamilyMemberRole.HR);
                        resalaFamily.enrollFamilyMembers(hashMap);
                        break;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice");
                    }
                }
                break;
            }
            case 3: {
                System.out.println(Family.getFamilyTrips() + "" + resalaFamily.getFamilyEvents());
            }
            case 4: {

            }
            case 5: {
            }
            default: {
            }
        }


    }


    static Department createDepartment(CollegeDepartments collegeDepartment,
                                       List<Employee> employeeList,
                                       List<Course> courseList,
                                       Employee departmentManager
    ) {
        switch (collegeDepartment) {

            case COMPUTER_SCIENCE -> {
                return new Department(CollegeDepartments.COMPUTER_SCIENCE, employeeList, courseList, departmentManager, College.Cs_Department_Grade);
            }
            case CONTROL -> {
                return new Department(CollegeDepartments.CONTROL, employeeList, courseList, departmentManager, College.Control_Department_Grade);
            }
            case COMMUNICATION -> {
                return new Department(CollegeDepartments.COMMUNICATION, employeeList, courseList, departmentManager, College.Communication_Department_Grade);
            }
            default -> {
                throw new IllegalArgumentException("Unknowncollege department: ");
            }
        }

    }

    private static Employee registerAsEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Enter your national id");
        Integer nationalId = scanner.nextInt();
        GENDER studentGender;
        while (true) {
            System.out.println("Enter your gender : male or female");
            String gender = scanner.next();
            if (gender == "male") {
                studentGender = GENDER.MALE;
                break;
            } else if (gender == "female") {
                studentGender = GENDER.FEMALE;
                break;
            } else
                System.out.println("Enter a valid gender male or female");
        }
        System.out.println("Enter your location");
        String location = scanner.next();
        System.out.println("Enter your phone age");
        Integer age = scanner.nextInt();
        System.out.println("Enter your phone number");
        Integer phoneNumber = scanner.nextInt();
        JopTitle jopTitle = JopTitle.PROFFESOR;
        System.out.println("Enter your job press 1 for Proff , 2 for Secretary , 3 for Dean , 4 for Teaching Assistant");
        Integer jobtitle = scanner.nextInt();
        Boolean flag = true;
        while (flag) {
            switch (jobtitle) {
                case 1: {
                    jopTitle = JopTitle.PROFFESOR;
                    flag = false;
                    break;
                }
                case 2: {
                    jopTitle = JopTitle.SECRETARY;
                    flag = false;
                    break;
                }
                case 3: {
                    flag = false;
                    jopTitle = JopTitle.DEAN;
                    break;
                }
                case 4: {
                    flag = false;
                    jopTitle = JopTitle.TEACHING_ASSISTANT;
                    break;
                }
                default: {
                    System.out.println("Invalid Input");
                }
            }
        }
        System.out.println("Enter your phone Employment Date");
        String emplomentDate = scanner.next();
        return new Employee(name, nationalId, studentGender, location, age, phoneNumber, jopTitle, emplomentDate);
    }

    private static Student registerAsStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Enter your national id");
        Integer nationalId = scanner.nextInt();

        GENDER studentGender;
        while (true) {
            System.out.println("Enter your gender : male or female");
            String gender = scanner.next();
            if (gender == "male") {
                studentGender = GENDER.MALE;
                break;
            } else if (gender == "female") {
                studentGender = GENDER.FEMALE;
                break;
            } else
                System.out.println("Enter a valid gender male or female");
        }
        System.out.println("Enter your location");
        String location = scanner.next();
        System.out.println("Enter your secondary school grade");
        Double secondarySchoolGrade = scanner.nextDouble();
        System.out.println("Enter your phone age");
        Integer age = scanner.nextInt();
        System.out.println("Enter your phone number");
        Integer phoneNumber = scanner.nextInt();
        return new Student(name, nationalId, studentGender, location, secondarySchoolGrade, age, phoneNumber);

    }

}