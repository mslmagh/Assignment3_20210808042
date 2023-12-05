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
                for (int i = 0; i < categories.length; i++) {
                    for (int j = 0; j < quantities[i]; j++) {
                        System.out.print("Please enter grade for " + categories[i] + " " + j + " >> ");
                        int a = scan.nextInt();
                        sum += a;
                    }
                    average[i]=  sum / quantities[i];
                    sum=0;
                }
            } else if (choice == 49) {
                System.out.println("Category information: ");
                for (int i = 0; i < categories.length; i++) {
                    System.out.println(categories[i] + " - " + average[i]);
                }

            } else if (choice == 50) {
                System.out.println("Please enter the category");
                for (int i = 0; i < categories.length ; i++) {
                    System.out.println(i+" - "+ categories[i]);
                }
                System.out.println("Q - to Quit");
                char choose = scan.next().charAt(0);
                if(choose==48){
                    System.out.println("Please enter which "+categories[0]+" would like to change (1-"+quantities[0]+")");
                } else if (choose==49) {

                }else if (choose==50) {

                }else if (choose==81) {

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