package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField password;
	private JLabel lblNewLabel_1;

	private String login= "user";
	private String SenhaText = "senhaforte";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 90, 54, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(41, 139, 54, 14);
		contentPane.add(lblSenha);
		
		usuario = new JTextField();
		usuario.setBounds(105, 89, 86, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(105, 138, 86, 20);
		contentPane.add(password);
		
		JButton botaoOK = new JButton("OK");
		botaoOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(usuario.getText().equals(login) && String.valueOf(password.getPassword()).equals(SenhaText)) {
					PrincipalScreen  principal = new PrincipalScreen();
					principal.setVisible(true);
					dispose();
				}else JOptionPane.showMessageDialog(null,"ERRO LOGIN",null,JOptionPane.CLOSED_OPTION);
				
				
			}
		});
		botaoOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoOK.setBounds(105, 182, 54, 41);
		contentPane.add(botaoOK);
		
		lblNewLabel_1 = new JLabel("Tela Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(69, 11, 122, 30);
		contentPane.add(lblNewLabel_1);
	}
}
