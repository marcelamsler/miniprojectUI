package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controller.WindowController;
import domain.Library;

public abstract class ListenerJFrame extends JFrame implements Observer, WindowListener{

	private Library library;
	protected WindowController windowCtrl;

	public ListenerJFrame(Library library, WindowController windowCtrl) {
		this.library = library;
		this.windowCtrl = windowCtrl;
		library.addObserver(this);
		addWindowListener(this);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel");
        getRootPane().getActionMap().put("Cancel", new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                dispatchEvent(new WindowEvent(ListenerJFrame.this, WindowEvent.WINDOW_CLOSING));
                dispose();
            }
        });
	}

	@Override
	public void windowClosing(WindowEvent e) {
		library.deleteObserver(this);
		windowCtrl.remove(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}
