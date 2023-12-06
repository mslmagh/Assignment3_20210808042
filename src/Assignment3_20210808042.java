import java.util.Scanner;

/**
 * @author Müslüm Agah
 * @since 29.11.2023
 */
public class Assignment3_20210808042 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to our university grade system.");
        String[] categories = new String[4];
        int[] quantities = new int[4]; // initialized with 0, update based on user input
        int[] weights = new int[4]; // example weights, update based on user input
        calculateGrade(categories, quantities, weights);
    }

    public static int menu(Scanner inp, String[] menu) {
        System.out.println("Please enter a choice below: ");
        menu = new String[]{"0 - Enter All Grades", "1 - Display grade information",
                "2 - Change a single grade", "Q - to Quit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
        char a = inp.next().charAt(0);
        if (a == 'Q') {
            return -1;
        } else {
            return (int) a;
        }
    }

    public static void calculateGrade(String[] categories, int[] quantities, int[] weights) {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        double[] average = new double[4];
        double[] category0 = new double[4];
        double[] category1 = new double[4];
        double[] category2 = new double[4];
        double[] category3 = new double[4];
        int choice;
        do {
            choice = menu(scan, categories);
            if (choice == 48) {
                for (int i = 0; i < 4; i++) {
                    System.out.print("Please enter the name of category " + (i + 1) + ": ");
                    String name = scan.next();
                    categories[i] = name;
                    System.out.print("Please enter how many items of type " + name + " were given: ");
                    int itemNumber = scan.nextInt();
                    quantities[i] = itemNumber;
                    System.out.print("Please enter the percentage of " + name + ": ");
                    int weightItem = scan.nextInt();
                    weights[i] = weightItem;
                }
                category0 = new double[quantities[0]];
                category1 = new double[quantities[1]];
                category2 = new double[quantities[2]];
                category3 = new double[quantities[3]];
                for (int i = 0; i < quantities[0]; i++) {
                    System.out.print("Please enter grade for " + categories[0] + " " + (i + 1) + " >> ");
                    int a = scan.nextInt();
                    category0[i] = a;
                }
                for (int i = 0; i < quantities[1]; i++) {
                    System.out.print("Please enter grade for " + categories[1] + " " + (i + 1) + " >> ");
                    int a = scan.nextInt();
                    category1[i] = a;
                }
                for (int i = 0; i < quantities[2]; i++) {
                    System.out.print("Please enter grade for " + categories[2] + " " + (i + 1) + " >> ");
                    int a = scan.nextInt();
                    category2[i] = a;
                }
                for (int i = 0; i < quantities[3]; i++) {
                    System.out.print("Please enter grade for " + categories[3] + " " + (i + 1) + " >> ");
                    int a = scan.nextInt();
                    category3[i] = a;
                }

            } else if (choice == 49) {
                System.out.println("Category information: ");
                for (int j = 0; j < quantities[0]; j++) {
                    average[0] += category0[j] / quantities[0];
                }
                for (int j = 0; j < quantities[1]; j++) {
                    average[1] += category1[j] / quantities[1];
                }
                for (int j = 0; j < quantities[2]; j++) {
                    average[2] += category2[j] / quantities[2];
                }
                for (int j = 0; j < quantities[3]; j++) {
                    average[3] += category3[j] / quantities[3];
                }
                for (int i = 0; i < categories.length; i++) {
                    System.out.println(categories[i] + " - " + average[i]);
                }
                for (int i = 0; i <average.length ; i++) {
                    average[i]=0;
                }

            } else if (choice == 50) {
                System.out.println("Please enter the category");
                for (int i = 0; i < categories.length; i++) {
                    System.out.println(i + " - " + categories[i]);
                }
                System.out.println("Q - to Quit");
                char choose = scan.next().charAt(0);
                if (choose == 48) {
                    System.out.print("Please enter which " + categories[1] + " would like to change (1-" + quantities[1] + ")");
                    int a = scan.nextInt();
                    System.out.println("The current grade for " + categories[1] + " is " + category1[(a - 1)]);
                    System.out.print("Please enter the new grade value >> ");
                    double b = scan.nextDouble();
                    category1[(a - 1)] = b;
                } else if (choose == 49) {
                    System.out.print("Please enter which " + categories[2] + " would like to change (1-" + quantities[2] + ")");
                    int a = scan.nextInt();
                    System.out.println("The current grade for " + categories[2] + " is " + category2[(a - 1)]);
                    System.out.print("Please enter the new grade value >> ");
                    double b = scan.nextDouble();
                    category2[(a - 1)] = b;
                } else if (choose == 50) {
                    System.out.print("Please enter which " + categories[3] + " would like to change (1-" + quantities[3] + ")");
                    int a = scan.nextInt();
                    System.out.println("The current grade for " + categories[3] + " is " + category3[(a - 1)]);
                    System.out.print("Please enter the new grade value >> ");
                    double b = scan.nextDouble();
                    category3[(a - 1)] = b;
                } else if (choose == 81 ||choose == 113){

                }

            } else if (choice == -1) {
                System.out.println("Thank you using our system. Have a nice day");
            } else {
                System.out.println("Invalid choice");
            }

        } while (choice != -1);


    }


    public static void formatCategoryName(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase();
        }
    }

    public static boolean isQuantityValid(int quantity) {
        return quantity >= 0;
    }

    public static boolean isWeightValid(int weight, int totalWeight) {
        return weight >= 0 && totalWeight <= 100;
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