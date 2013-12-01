package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddBookAction extends AbstractAction {

    WindowController windowCtrl;


    public AddBookAction(String label, WindowController windowCtrl) {
        super(label);
          this.windowCtrl = windowCtrl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        windowCtrl.openAddBookWindow();
    }
}
