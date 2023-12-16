import java.util.Scanner;

/**
 * @author Müslüm Agah
 * @since 29.11.2023
 */
public class Assignment3_20210808042 {
    public static void main(String[] args) {
        String[] category = {"qUiz", "Attendance", "HoMEwOrk", "Midterm Exam", "Final exam", "a", "a", "a", "a", "a"};
        int[] quantities = {3, 2, 2, 2, 1, 1, 1, 1, 1, 1};
        int[] weight = {10, 10, 10, 10, 10, 10, 10, 10, 10,10};
        calculateGrade(category, quantities, weight);
    }

    public static int menu(Scanner inp, String[] menu) {
        System.out.println("Please enter a choice below: ");
        menu = new String[]{"0 - Enter All Grades", "1 - Display grade information",
                "2 - Change a single grade", "Q - to Quit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
        String a = inp.next();
        int b = 0;
        if (a.length() == 1 && a.equalsIgnoreCase("Q")) {
            System.out.println("Thank you using our system. Have a nice day.");
            return -1;
        } else {
            return b = Integer.parseInt(a);
        }
    }

    public static void calculateGrade(String[] category, int[] quantity, int[] weight) {
        Scanner scan = new Scanner(System.in);

        if (isSameAllName(category, quantity, weight)) {
            if (isQuantityValid(quantity)) {
                if (isWeightValid(weight)) {
                    String[] list = new String[4];
                    double[][] grade = new double[category.length][];

                    for (int i = 0; i < category.length; i++) {
                        grade[i] = new double[quantity[i]];
                    }
                    double[] average = new double[category.length];
                    formatCategoryName(category);
                    int choice;
                    do {
                        choice = menu(scan, list);
                        if (choice == 0) {//Entered 0
                            for (int i = 0; i < category.length; i++) {
                                for (int j = 0; j < grade[i].length; j++) {
                                    System.out.print("Please enter grade for " + category[i] + " " + (j + 1) + " >> ");
                                    int a = scan.nextInt();
                                    grade[i][j] = a;
                                }
                            }

                        } else if (choice == 1) {//Entered 1
                            double a = 0;
                            System.out.println("Category information: ");
                            for (int i = 0; i < category.length; i++) {
                                for (int j = 0; j < quantity[i]; j++) {
                                    average[i] += grade[i][j] / quantity[i];
                                }
                            }

                            for (int i = 0; i < category.length; i++) {
                                System.out.println(category[i] + " - " + average[i]);
                            }
                            double overallGrade = 0;
                            for (int i = 0; i < category.length; i++) {
                                overallGrade += (average[i] * weight[i] / 100);
                            }
                            System.out.println();
                            System.out.println("Overall Grade - " + overallGrade);
                            System.out.println("Grade Letter - " + gradeLetter(overallGrade));
                            System.out.println("GPA Points - " + gpaPoints(overallGrade));
                            System.out.println("Status - " + status(overallGrade));
                            System.out.println();
                            for (int i = 0; i < average.length; i++) {
                                average[i] = 0;
                            }
                        } else if (choice == 2) {//Entered 2
                            System.out.println("Please enter the category");
                            for (int i = 0; i < category.length; i++) {
                                System.out.println(i + " - " + category[i]);
                            }
                            System.out.println("Q - to Quit");
                            String choose = scan.next();
                            int userInt = -1;
                            char c = 0;
                            if (choose.length() == 1 && choose.equalsIgnoreCase("q")) {
                                c = choose.toUpperCase().charAt(0);
                            } else {
                                userInt = Integer.parseInt(choose);
                            }
                            if (c == 'Q') {
                                System.out.println("Thank you using our system. Have a nice day.");
                                break;
                            } else if (userInt >= category.length || userInt < 0) {
                                System.out.println("Invalid choice.\n");
                            } else if (userInt >= 0) {//Entered 0
                                System.out.print("Please enter which " + category[userInt] + " would like to change (1 - " + quantity[userInt] + ") >> ");
                                int a = scan.nextInt();
                                if (a > quantity[userInt] || a < 1) {
                                    System.out.println("Invalid choice.\n");
                                    continue;
                                }
                                System.out.println("The current grade for " + category[userInt] + " is " + grade[userInt][(a - 1)]);
                                System.out.print("Please enter the new grade value >> ");
                                double b = scan.nextDouble();
                                grade[userInt][a - 1] = b;
                                System.out.println();
                            }
                        } else if (choice == -1) {

                        } else {
                            System.out.println("Invalid choice.\n");
                        }
                    } while (choice != -1);
                }
            }
        }
    }


    public static void formatCategoryName(String[] name) {
        for (int i = 0; i < name.length; i++) {
            name[i] = name[i].substring(0, 1).toUpperCase() + name[i].substring(1).toLowerCase();
        }
    }

    public static boolean isQuantityValid(int[] quantity) {
        boolean isQuantity = true;
        for (int i = 0; i < quantity.length; i++) {
            if (quantity[i] >= 0) {
                isQuantity = true;
            } else {
                System.out.println("ERROR: Invalid quantity entered");
                isQuantity = false;
            }
        }
        return isQuantity;
    }

    public static boolean isSameAllName(String[] a, int[] b, int[] c) {
        boolean isSame = true;
        if (a.length == b.length && b.length == c.length) {
            isSame = true;
        } else {
            System.out.println("ERROR: Array lengths are not all the same.");
            isSame = false;
        }

        return isSame;
    }

    public static boolean isWeightValid(int[] weight) {
        boolean isWeight;
        int a = 0;
        for (int i = 0; i < weight.length; i++) {
            a += weight[i];
        }
        if (a == 100) {
            isWeight = true;
        } else {
            System.out.println("ERROR: Invalid weight entered.");
            isWeight = false;
        }
        return isWeight;
    }

    public static String gradeLetter(double grade) {
        if (grade >= 88) {
            return "AA";
        } else if (grade >= 81) {
            return "BA";
        } else if (grade >= 74) {
            return "BB";
        } else if (grade >= 67) {
            return "CB";
        } else if (grade >= 60) {
            return "CC";
        } else if (grade >= 53) {
            return "DC";
        } else if (grade >= 46) {
            return "DD";
        } else if (grade >= 35) {
            return "FD";
        } else {
            return "FF";
        }
    }

    public static double gpaPoints(double grade) {
        if (grade >= 88) {
            return 4.0;
        } else if (grade >= 81) {
            return 3.5;
        } else if (grade >= 74) {
            return 3.0;
        } else if (grade >= 67) {
            return 2.5;
        } else if (grade >= 60) {
            return 2.0;
        } else if (grade >= 53) {
            return 1.5;
        } else if (grade >= 46) {
            return 1.0;
        } else if (grade >= 35) {
            return 0.5;
        } else {
            return 0.0;
        }
    }

    public static String status(double grade) {
        if (grade >= 60) {
            return "passed";
        } else if (grade >= 46) {
            return "conditionally passed";
        } else {
            return "failed";
        }
    }
}