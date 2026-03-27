package test2_2_3;

import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String menu = "Choose an equation type to solve:\n" +
                      "1. First-degree equation (ax + b = 0)\n" +
                      "2. System of first-degree equations (2 variables)\n" +
                      "3. Second-degree equation (ax^2 + bx + c = 0)";
        
        String choice = JOptionPane.showInputDialog(menu);

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

    if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions");
            } else {
                JOptionPane.showMessageDialog(null, "No solution");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Solution x = " + x);
        }
    }


    public static void solveSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "x1 = " + (D1/D) + ", x2 = " + (D2/D));
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Infinitely many solutions [cite: 272]");
            } else {
                JOptionPane.showMessageDialog(null, "No solution [cite: 272]");
            }
        }
    }


    public static void solveSecondDegree() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("a (a != 0):"));
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "a must be non-zero! [cite: 278]");
            return;
        }
        double b = Double.parseDouble(JOptionPane.showInputDialog("b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("c:"));

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Two roots: x1=" + x1 + ", x2=" + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Double root: x = " + x + " [cite: 277]");
        } else {
            JOptionPane.showMessageDialog(null, "No real root [cite: 277]");
        }
    }
}