package com.cmc.triangulos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class form extends JFrame {

	private JPanel contentPane;
	private JTextField txtLadoA;
	private JTextField txtLadoB;
	private JTextField txtLadoC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLadoA = new JTextField();
		txtLadoA.setText("Lado A");
		txtLadoA.setBounds(43, 97, 147, 20);
		contentPane.add(txtLadoA);
		txtLadoA.setColumns(10);
		
		txtLadoB = new JTextField();
		txtLadoB.setText("Lado B");
		txtLadoB.setColumns(10);
		txtLadoB.setBounds(43, 146, 147, 20);
		contentPane.add(txtLadoB);
		
		txtLadoC = new JTextField();
		txtLadoC.setText("Lado C");
		txtLadoC.setColumns(10);
		txtLadoC.setBounds(43, 191, 147, 20);
		contentPane.add(txtLadoC);
		
		JLabel TipoDeTriangulo = new JLabel("");
		TipoDeTriangulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		TipoDeTriangulo.setBounds(298, 97, 323, 20);
		contentPane.add(TipoDeTriangulo);
		
		JLabel lblNewLabel = new JLabel("Indica los lados del triangulo como enteros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 22, 306, 28);
		contentPane.add(lblNewLabel);
		
		JLabel TipoDeTriangulo_1 = new JLabel("");
		TipoDeTriangulo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		TipoDeTriangulo_1.setBounds(298, 146, 323, 20);
		contentPane.add(TipoDeTriangulo_1);
		
		JLabel Angulo_1 = new JLabel("Angulo 1");
		Angulo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		Angulo_1.setBounds(200, 210, 132, 14);
		contentPane.add(Angulo_1);
		
		JLabel Angulo_2 = new JLabel("Angulo 2");
		Angulo_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		Angulo_2.setBounds(342, 210, 141, 14);
		contentPane.add(Angulo_2);
		
		JLabel Angulo_3 = new JLabel("Angulo 3");
		Angulo_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		Angulo_3.setBounds(493, 210, 141, 14);
		contentPane.add(Angulo_3);
		
		JLabel Area = new JLabel("");
		Area.setFont(new Font("Tahoma", Font.BOLD, 13));
		Area.setBounds(200, 242, 357, 14);
		contentPane.add(Area);
		
		JLabel lblTipoDeTriangulo = new JLabel("Tipo de triangulo");
		lblTipoDeTriangulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeTriangulo.setBounds(298, 61, 323, 20);
		contentPane.add(lblTipoDeTriangulo);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ladoA = txtLadoA.getText().trim();
				String ladoB = txtLadoB.getText().trim();
				String ladoC = txtLadoC.getText().trim();

				String triangulo; 
				double AnguloA;
				double AnguloB;
				double AnguloC;
				double A;
				double h;
				
				double a = Integer.parseInt(ladoA);
				double b = Integer.parseInt(ladoB);
				double c = Integer.parseInt(ladoC);
				
				
				if(c<a+b && b<a+c && a<b+c) {
					TipoDeTriangulo.setText("Si es un triangulo de tipo: ");
					if(a==b && a==c) {
						triangulo="equilatero";
						TipoDeTriangulo_1.setText("Es un triangulo equilatero");
					}else if(a==b || a==c || b==c) {
						triangulo="isoceles";
						TipoDeTriangulo_1.setText("Es un triangulo isóceles");
					}else {
						triangulo = "escaleno";
						TipoDeTriangulo_1.setText("Es un triangulo escaleno");

					}
					
					switch(triangulo) {
						case "equilatero":
							Angulo_1.setText("60");
							Angulo_2.setText("60");
							Angulo_3.setText("60");
							String gam = Angulo_3.getText().trim();
							double gamma = Integer.parseInt(gam);;
							h= Math.toDegrees(b*(Math.sin(gamma)));
							A=a*h/2;
							lblTipoDeTriangulo.setText((A)+"");

						case "isoceles":
							AnguloA= Math.toDegrees(Math.acos(((Math.pow(a, 2))-(Math.pow(b, 2))-(Math.pow(c, 2)))/(-2*b*c)));
							AnguloB= Math.toDegrees(Math.acos(((Math.pow(a, 2))-(Math.pow(b, 2))-(Math.pow(c, 2)))/(-2*b*c)));
							AnguloC= 180-(AnguloA+AnguloB);

							Angulo_1.setText((AnguloA)+"");
							Angulo_2.setText((AnguloB)+"");
							Angulo_3.setText((AnguloC)+"");
							
							String gam1 = Angulo_3.getText().trim();
							double gamma1 = Integer.parseInt(gam1);;
							h= Math.toDegrees((b*(Math.sin(gamma1))));
							A=(a*h)/2;
							lblTipoDeTriangulo.setText((h)+"");
							
						case "escaleno":
							AnguloA= Math.toDegrees(Math.acos(((Math.pow(a, 2))-(Math.pow(b, 2))-(Math.pow(c, 2)))/(-2*b*c)));

							AnguloB= Math.toDegrees(Math.acos(((0.5*(Math.pow(a, 2)))-(0.5*(Math.pow(b, 2)))+(0.5*(Math.pow(c, 2))))/(a*c)));
							AnguloC= 180-(AnguloA+AnguloB);

							Angulo_1.setText("Alpha: "+(AnguloA)+"");
							Angulo_2.setText("Beta: "+(AnguloB)+"");
							Angulo_3.setText("Gamma: "+(AnguloC)+"");
							
							String gam2 = Angulo_3.getText().trim();
							double gamma2 = Integer.parseInt(gam2);;
							h= Math.toDegrees(b*(Math.sin(gamma2)));
							A=a*h/2;
							lblTipoDeTriangulo.setText((A)+"");
							
					}
					
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "No es un triangulo");
				}
				
				
							
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(262, 283, 106, 28);
		contentPane.add(btnNewButton);
		

		
		
		
		
	}
}
