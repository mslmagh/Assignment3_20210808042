import java.util.Scanner;

public class Assignment3_20210808042 {
    public static void main(String[] args) {
<<<<<<< Updated upstream
        Scanner inp = new Scanner(System.in);
        String[] list = {"0 - Enter All Grades", "1 - Display grade information",
                "2 - Change a single grade", "Q - to Quit"};
        menu(inp,list);
<<<<<<< HEAD
        System.out.println();
=======
        System.out.println("Welcome to our university grade system.");
        String[] categories = {"QUiZ", "HomEwOrk", "Midterm exam", "Final exam"};
        formatCategoryName(categories);
        int[] quantities = {4, 2, 2, 1}; // initialized with 0, update based on user input
        int[] weights = new int[]{10, 20, 30, 40}; // example weights, update based on user input
        calculateGrade(categories, quantities, weights);
        System.out.println("a");
        
>>>>>>> Stashed changes
=======
>>>>>>> parent of f4429a2 (Try)
    }

    public static int menu(Scanner inp, String[] list) {
        do{
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        }while(inp.nextInt()>=3);
        return 1;
    }
    public static void calculateGrade(int category, int quantity, int weight){

    }
}