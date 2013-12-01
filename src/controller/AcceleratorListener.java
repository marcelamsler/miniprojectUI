package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcceleratorListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
