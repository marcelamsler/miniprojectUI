package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddLoanAction extends AbstractAction {

    WindowController windowCtrl;


    public AddLoanAction(String label, WindowController windowCtrl) {
        super(label);
          this.windowCtrl = windowCtrl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        windowCtrl.openAddLoanWindow();
    }
}
