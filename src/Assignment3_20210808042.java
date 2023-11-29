import java.util.Scanner;

public class Assignment3_20210808042 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String[] list = {"0 - Enter All Grades", "1 - Display grade information",
                "2 - Change a single grade", "Q - to Quit"};
        menu(inp,list);
        System.out.println();
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