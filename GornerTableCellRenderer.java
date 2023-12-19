package bsu.rfe.java.group7.lab3.Finova.varB7;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(5);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }



    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        double x=(double) table.getValueAt(row,0);
        double y=(double) table.getValueAt(row,1);
        boolean check= Math.signum(x)==Math.signum(y);
        if (col==0 && needle!=null && needle.equals(formattedDouble) || col==1 && needle!=null && needle.equals(formattedDouble)) {

            panel.setBackground(Color.RED);
        } else {
            panel.setBackground(Color.WHITE);
        }

        if(col == 1 && !check){
            panel.setBackground(Color.PINK);
        }
        return panel;
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }




}


