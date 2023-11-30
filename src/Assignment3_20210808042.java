import java.util.Scanner;

/**
 * @author Müslüm Agah
 * @since 29.11.2023
 */
public class Assignment3_20210808042 {
    public static void main(String[] args) {
        String[] categories = {"QUiZ", "HomEwOrk", "Midterm exam", "Final exam"};
        formatCategoryName(categories);
        int[] quantities = {4, 2, 2, 1}; // initialized with 0, update based on user input
        int[] weights = new int[]{10, 20, 30, 40}; // example weights, update based on user input
        calculateGrade(categories, quantities, weights);
    }

    public static int menu(Scanner inp, String[] list) {
        System.out.println("Welcome to our university grade system.");
        System.out.println("Please enter a choice below: ");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        char a = inp.next().charAt(0);
        return (int) a;
    }

    public static void calculateGrade(String[] categories, int[] quantities, int[] weights) {
        Scanner scan = new Scanner(System.in);
        String[] list = {"0 - Enter All Grades", "1 - Display grade information",
                "2 - Change a single grade", "Q - to Quit"};
        int choice = menu(scan, list);
        if (choice == '0') {
            for (int i = 0; i < categories.length; i++) {
                for (int j = 1; j <= quantities[i]; j++) {
                    System.out.print("Please enter grade for " + categories[i] + " " + j + " >> ");
                    int a = scan.nextInt();
                }

            }
        }else if( choice=='1'){

        }else if(choice =='2'){

        } else if (choice== 'Q') {
            System.out.println("Thank you using our system. Have a nice day");
        }else{
            System.out.println("Invalid choice");
        }
    }

    public static String formatCategoryName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static void formatCategoryName(String[] name) {
        for (int i = 0; i < name.length; i++) {

            name[i] = formatCategoryName(name[i]);
            System.out.println("ergege");

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