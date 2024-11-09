package com.ej1.eje1;
import com.ej1.eje1.Services.SpamFilterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eje1Application {
	private JTextField urlField;
	private JTextArea resultArea;
	private SpamFilterService spamFilterService;

	public Eje1Application(SpamFilterService spamFilterService) {
		this.spamFilterService = spamFilterService;
		JFrame frame = new JFrame("Control de Acceso - Páginas de Spam");
		frame.setLayout(new FlowLayout());

		JLabel label = new JLabel("Ingresa una URL:");
		urlField = new JTextField(30);
		JButton checkButton = new JButton("Verificar");
		resultArea = new JTextArea(10, 30);
		resultArea.setEditable(false);

		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = urlField.getText();
				if (spamFilterService.isSpam(url)) {
					resultArea.setText("¡Advertencia! El sitio es un sitio de SPAM.");
				} else {
					resultArea.setText("El sitio es seguro.");
				}
			}
		});

		frame.add(label);
		frame.add(urlField);
		frame.add(checkButton);
		frame.add(new JScrollPane(resultArea));

		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Eje1Application app = new Eje1Application(new SpamFilterService());
		});
	}
}



