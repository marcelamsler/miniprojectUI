package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import domain.Library;

public abstract class ListenerJFrame extends JFrame implements Observer, WindowListener{

	private Library library;

	public ListenerJFrame(Library library) {
		this.library = library;
		library.addObserver(this);
		addWindowListener(this);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		library.deleteObserver(this);
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
	
	@Override
	public void setVisible(final boolean visible) {
	 
	  // let's handle visibility...
	  if (!visible || !isVisible()) { // have to check this condition simply because super.setVisible(true) invokes toFront if frame was already visible
	      super.setVisible(visible);
	  }
	  // ...and bring frame to the front.. in a strange and weird way
	  if (visible) {
	      int state = super.getExtendedState();
	      state &= ~JFrame.ICONIFIED;
	      super.setExtendedState(state);
	      super.setAlwaysOnTop(true);
	      super.toFront();
	      super.requestFocus();
	      super.setAlwaysOnTop(false);
	  }
	}


	@Override
	public void toFront() {
	  super.setVisible(true);
	  int state = super.getExtendedState();
	  state &= ~JFrame.ICONIFIED;
	  super.setExtendedState(state);
	  super.setAlwaysOnTop(true);
	  super.toFront();
	  super.requestFocus();
	  super.setAlwaysOnTop(false);
	}

}
