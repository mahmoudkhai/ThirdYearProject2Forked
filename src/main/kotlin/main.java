import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();
        int result = connectOneDigitNumber(firstNumber, secondNumber, thirdNumber);
        System.out.println(result);
    }
    public static int connectOneDigitNumber(int firstNumber, int secondNumber, int thirdNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] numbers = {firstNumber, secondNumber, thirdNumber};
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter " + (i + 1) + " number: ");
            int number = numbers[i];
            stringBuilder.append(number);
        }
        return Integer.parseInt(stringBuilder.reverse().toString());
    }
    // 2
    public static int power(int firstNumber, int secondNumber) {
        int result = firstNumber;
        for (int i = secondNumber; i > 1; i--) {
            result *= firstNumber;
        }
        return result;
    }
    // 3
    public static double calculateArrivalAndDeparture(double arrival, double departureTime) {
        if (arrival < departureTime) {
            return 24 + arrival - departureTime;
        } else {
            return arrival - departureTime;
        }
    }

    // 4 - a
    public static int calculateInvalidGrades(List<Double> grades) {
        var numberOfInvalidGrades = 0;
        for (Double grade : grades) {
            if (grade > 100 || grade < 0) numberOfInvalidGrades++;
        }
        return numberOfInvalidGrades;
    }

    // 4 - b
    public static List<Integer> convertGradesToBinary(List<Double> grades) {
        LinkedList<Integer> binaryGrades = new LinkedList<Integer>();
        for (double grade : grades) {
            if (grade > 100 || grade < 0) binaryGrades.add(0);
            else binaryGrades.add(1);
        }
        return binaryGrades;
    }

    // 4- c
    public static Double calculateAverageGrade(List<Double> grades) {
        int sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return (double) (sum / grades.size());
    }

    // 4-d
    public static HashMap<Double, Integer> findMaxGradeAndLocation(List<Double> grades) {
        HashMap<Double, Integer> maxAndLocation = new HashMap<>();
        maxAndLocation.put(Collections.max(grades), grades.indexOf(Collections.max(grades)));
        return maxAndLocation;
    }

    public static HashMap<Double, Integer> findMinGradeAndLocation(List<Double> grades) {
        HashMap<Double, Integer> maxAndLocation = new HashMap<>();
        maxAndLocation.put(Collections.min(grades), grades.indexOf(Collections.min(grades)));
        return maxAndLocation;
    }

    //4-e
    public static List<HashMap<Double, Integer>> findStudentsWithHigherThan85(List<Double> grades) {
        List<HashMap<Double, Integer>> students = new LinkedList<>();
        for (Double grade : grades) {
            if (grade > 85) {
                HashMap<Double, Integer> gradeAndLocation = new HashMap<>();
                int index = grades.indexOf(grade);
                gradeAndLocation.put(grade, index);
                students.add(gradeAndLocation);
            }
        }
        return students;
    }

    // 4-f
    public static List<HashMap<Double, Integer>> findStudentsGreaterThanAverage(List<Double> grades) {
        List<HashMap<Double, Integer>> students = new LinkedList<>();
        Double averageGrade = calculateAverageGrade(grades);
        for (Double grade : grades) {
            if (grade > averageGrade) {
                HashMap<Double, Integer> gradeAndLocation = new HashMap<>();
                int index = grades.indexOf(grade);
                gradeAndLocation.put(grade, index);
                students.add(gradeAndLocation);
            }
        }
        return students;
    }

    // 5
    public static String findEquationRoot(int a, int b, double c) {
        if (a == b && b == c && a == c && a == 0) return "Any x is a solution";
        else if (a == 0 && b == a && (c >= 0 && c <= 1)) return "No solution";
        else if (a == 0) return (double) (-c / b) + "";
        else return "2 \n 3";
    }

    // 6
    public static ArrayList<Integer> computeElementsOccurance(ArrayList<Integer> firstArray,
                                                              ArrayList<Integer> secondArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer firstArrayNumber : firstArray) {
            var count = 0;
            for (Integer secondArrayNumber : secondArray) {
                if (firstArrayNumber.equals(secondArrayNumber)) count++;
            }
            result.add(count);
        }
        return result;
    }

}
