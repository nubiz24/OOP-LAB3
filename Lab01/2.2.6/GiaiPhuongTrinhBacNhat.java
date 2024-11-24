import javax.swing.JOptionPane;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {

        String nhapA = JOptionPane.showInputDialog(null, "Please Input a", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(nhapA);

        String nhapB = JOptionPane.showInputDialog(null, "Please Input b", "Input", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(nhapB);
        
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "CO VO SO NGHIEM", "Ket qua", JOptionPane.INFORMATION_MESSAGE );
            } else {
                JOptionPane.showMessageDialog(null, "VO NGHIEM", "Ket qua", JOptionPane.INFORMATION_MESSAGE );}
        } else {
        double x = -b / a;
        JOptionPane.showMessageDialog(null, "NGHIEM LA " + x , "Ket qua", JOptionPane.INFORMATION_MESSAGE );}
        } 
    }
