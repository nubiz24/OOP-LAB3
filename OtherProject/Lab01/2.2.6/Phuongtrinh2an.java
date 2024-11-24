import javax.swing.JOptionPane;

public class Phuongtrinh2an {
    public static void main(String[] args) {
        String nhapA11 = JOptionPane.showInputDialog(null, "Please Input a11", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(nhapA11);

        String nhapA12 = JOptionPane.showInputDialog(null, "Please Input a12", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a12 = Double.parseDouble(nhapA12);

        String nhapA21 = JOptionPane.showInputDialog(null, "Please Input a21", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a21 = Double.parseDouble(nhapA21);

        String nhapA22 = JOptionPane.showInputDialog(null, "Please Input a22", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a22 = Double.parseDouble(nhapA22);

        String nhapB1 = JOptionPane.showInputDialog(null, "Please Input b1", "Input", JOptionPane.INFORMATION_MESSAGE);
        double b1 = Double.parseDouble(nhapB1);

        String nhapB2 = JOptionPane.showInputDialog(null, "Please Input b2", "Input", JOptionPane.INFORMATION_MESSAGE);
        double b2 = Double.parseDouble(nhapB2);
    Double D = a11 * a22 - a21 * a12;
    Double D1 = b1 * a22 - b2 * a12;
    Double D2 = a12 * b2 - a21 * b1;
    if (D == 0){
        if (D1 == D2){
            JOptionPane.showMessageDialog(null, "CO VO SO NGHIEM", "KET QUA", JOptionPane.INFORMATION_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null, "VO NGHIEM", "KET QUA", JOptionPane.INFORMATION_MESSAGE);
    }
    else {
        double x = D1/D, y = D2/D;
        JOptionPane.showMessageDialog(null, "Hai nghiem la x = " +x +" va y = " +y , "KET QUA", JOptionPane.INFORMATION_MESSAGE);
    }
    }
}