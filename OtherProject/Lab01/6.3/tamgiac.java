import java.util.Scanner;

public class tamgiac {
    public static void main(String[] args){
        System.out.println("Nhap chieu cao tam giac");
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
            for (int i = 1; i<=h;i++){
                for (int j = 1; j <= (h-i);j++ ){
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2*i-1;j++){
                    System.out.print("*");
                }
                System.out.print("\n");
        }
       
    }
}