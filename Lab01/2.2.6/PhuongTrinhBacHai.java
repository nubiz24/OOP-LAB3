import javax.swing.JOptionPane;

public class PhuongTrinhBacHai {
    public static void main(String[] args) {

        String nhapA = JOptionPane.showInputDialog(null, "Please Input a", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(nhapA);

        String nhapB = JOptionPane.showInputDialog(null, "Please Input b", "Input", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(nhapB);

        String nhapC = JOptionPane.showInputDialog(null, "Please Input c", "Input", JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(nhapC);
        double delta = b*b - 4 * a * c;
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "CO VO SO NGHIEM", "Ket qua", JOptionPane.INFORMATION_MESSAGE );
            } else {
                double x = -c/b;
                JOptionPane.showMessageDialog(null, "Co nghiem duy nhat x = " + x , "Ket qua", JOptionPane.INFORMATION_MESSAGE );}
        } else {
        
        if (delta == 0) { 
            double x1 = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "NGHIEM KEP x = " + x1 , "Ket qua", JOptionPane.INFORMATION_MESSAGE );
        }
        if (delta < 0 ) {
            JOptionPane.showMessageDialog(null, "VO NGHIEM" , "Ket qua", JOptionPane.INFORMATION_MESSAGE );
        }
        if (delta > 0 ) {
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            double x3= (-b - Math.sqrt(delta))/(2*a);
        JOptionPane.showMessageDialog(null, "2 NGHIEM PHAN BIET LA x1 = " + x2 + " va x2 = " +x3 , "Ket qua", JOptionPane.INFORMATION_MESSAGE );}
        } 
    }
}
