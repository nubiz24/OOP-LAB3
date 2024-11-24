import javax.swing.JOptionPane;

public class congtrunhanchia {
    public static void main(String[] args) {

        String nhapA = JOptionPane.showInputDialog(null, "Please Input a", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(nhapA);

        String nhapB = JOptionPane.showInputDialog(null, "Please Input b", "Input", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(nhapB);
        JOptionPane.showMessageDialog(null, "Tong la " + (a+b) , "Ket qua", JOptionPane.INFORMATION_MESSAGE );
        JOptionPane.showMessageDialog(null, "Hieu la " + (a-b) , "Ket qua", JOptionPane.INFORMATION_MESSAGE );
        JOptionPane.showMessageDialog(null, "Tich la " + (a*b) , "Ket qua", JOptionPane.INFORMATION_MESSAGE );
        if ( b == 0){
            JOptionPane.showMessageDialog(null, "Khong co thuong" , "Ket qua", JOptionPane.INFORMATION_MESSAGE );
        }
        else{
        JOptionPane.showMessageDialog(null, "Thuong la " + (a+b) , "Ket qua", JOptionPane.INFORMATION_MESSAGE );}
    }
}