import java.util.Arrays;
import java.util.Scanner;
public class NumberofDay{
    public static void main(String[] args ){
        Scanner input = new Scanner(System.in);
        
            System.out.print("Nhap nam (year)");
            int year = input.nextInt();
        String[] validMonths = {
            "1", "Jan", "January", 
            "2", "Feb", "February", 
            "3", "Mar", "March", 
            "4", "Apr", "April", 
            "5", "May", 
            "6", "Jun", "June", 
            "7", "Jul", "July", 
            "8", "Aug", "August", 
            "9", "Sep", "September", 
            "10", "Oct", "October", 
            "11", "Nov", "November", 
            "12", "Dec", "December"};
        String month;
        while (true) {
            System.out.print("Nhap thang (viet tat, ten day du hoac so tu 1 den 12)");
            month = input.next();
            boolean isValid = false;
            for (String validMonth : validMonths) {
                if (Arrays.asList(validMonths).contains(month)) { 
                    isValid = true;
                    break;
                }
            }
            if (isValid) {
                int monthin;
                switch (month) {
                    case "1":
                    case "Jan":
                    case "January":
                    monthin = 1;
                    break;

                    case "2":
                    case "Feb":
                    case "Febuary":
                    monthin = 2;
                    break;

                    case "3":
                    case "Mar":
                    case "March":
                    monthin = 3;
                    break;


                    case "4":
                    case "Apr":
                    case "April":
                    monthin = 4;
                    break;


                    case "5":
                    case "May":
                    monthin = 5;
                    break;


                    case "6":
                    case "Jun":
                    case "June":
                    monthin = 6;
                    break;


                    case "7":
                    case "Jul":
                    case "July":
                    monthin = 7;
                    break;


                    case "8":
                    case "Aug":
                    case "August":
                    monthin = 8;
                    break;


                    case "9":
                    case "Sep":
                    case "September":
                    monthin = 9;
                    break;


                    case "10":
                    case "Oct":
                    case "October":
                    monthin = 10;
                    break;


                    case "11":
                    case "Nov":
                    case "November":
                    monthin = 11;
                    break;


                    case "12":
                    case "Dev":
                    case "December":
                    monthin = 12;
                    break;
                    default:
                    System.out.println("Thang khong hop le.");
                    continue;
                    
                }
                    int daysInMonth = getDaysInMonth(year,monthin);
                    System.out.println("Thang " + monthin + " nam " + year + " co " + daysInMonth + " ngay.");
                break; 
            } else {
                System.out.println("Input khong hop le, vui long thu lai.");
            }
        }
    
    }
    public static int getDaysInMonth(int year, int monthin) {
        int days = 0;
            switch (monthin) {
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        days = 29; 
                    } else {
                        days = 28; 
                    }
                    break;
                default:
                    days = 31;
                    break;
            }
        
        return days;    
    }
}