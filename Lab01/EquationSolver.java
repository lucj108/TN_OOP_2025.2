package test2_2_3;

import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String menu = "Choose an equation type to solve:\n" +
                      "1. First-degree equation (ax + b = 0)\n" +
                      "2. System of first-degree equations (2 variables)\n" +
                      "3. Second-degree equation (ax^2 + bx + c = 0)";
        
        String choice = JOptionPane.showInputDialog(menu);

        if (choice == null) {
            System.exit(0);
        }

        switch (choice) {
            case "1":
                solveFirstDegree();
                break;
            case "2":
                solveSystem();
                break;
            case "3":
                solveSecondDegree();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice!");
        }
        System.exit(0);
    }

    public static void solveFirstDegree() {
        String strA = JOptionPane.showInputDialog("Nhập hệ số a:");
        String strB = JOptionPane.showInputDialog("Nhập hệ số b:");
        
        if (strA == null || strB == null) return;

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm (Infinite solutions)");
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm (No solution)");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Nghiệm của phương trình là x = " + x);
        }
    }

    public static void solveSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "Hệ có nghiệm duy nhất:\nx1 = " + (D1/D) + "\nx2 = " + (D2/D));
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Hệ vô số nghiệm (Infinitely many solutions)");
            } else {
                JOptionPane.showMessageDialog(null, "Hệ vô nghiệm (No solution)");
            }
        }
    }

    public static void solveSecondDegree() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số a (a != 0):"));
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Hệ số a phải khác 0!");
            return;
        }
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số c:"));

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Hai nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Nghiệm kép: x = " + x);
        } else {
            JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm thực (No real root)");
        }
    }
}