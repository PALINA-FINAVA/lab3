package bsu.rfe.java.group7.lab3.Finova.varB7;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }
    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return (int)(Math.ceil((to-from)/step))+1;
    }
    public Object getValueAt(int row, int col) {
        // Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step*row;
        double gornerResult = coefficients[coefficients.length - 1];
        for (int i = coefficients.length - 2; i >= 0; i--) {
            gornerResult = coefficients[i] + gornerResult * x;}
        String strNumber = Double.toString(gornerResult).replace(".", "");
        boolean found = false;
        for (int i = 0; i < strNumber.length() - 2; i++) {
            int firstDigit = Character.getNumericValue(strNumber.charAt(i));
            int secondDigit = Character.getNumericValue(strNumber.charAt(i+1));
            int thirdDigit = Character.getNumericValue(strNumber.charAt(i+2));
            if (firstDigit == secondDigit - 1 && secondDigit == thirdDigit - 1) {
                found = true;
                break;
            }
        }
        switch (col) {
            case 0:
                return x;
            case 1:
                return gornerResult;
            case 2:
                return found;
            default:
                return 1;
        }


        }


    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "Последовательный ряд?";
        }
    }
    public Class<?> getColumnClass(int col) {

        switch (col) {
            case 0:
                return Double.class;
            case 1:
                return Double.class;
            case 2:
                return Boolean.class;
            default:
                return Double.class;
        }
    }
}

