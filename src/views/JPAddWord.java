package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPAddWord extends JPanel {
	private JButton jbAddTranslate;

	public JPAddWord(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,15,0);

		jbAddTranslate = new JButton("Agregar Traduccion al Diccionario Actual");
		jbAddTranslate.setActionCommand("AddWordIntermediary");
		jbAddTranslate.addActionListener(listener);

		add(jbAddTranslate,gbc);
	}
}
