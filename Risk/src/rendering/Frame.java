package rendering;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import logic.ObjectMap;

public class Frame extends JFrame {
	private ObjectMap oM;

	public Frame(ObjectMap oM) {
		this.oM = oM;
	}
}
