package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import produto.Produto;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	ArrayList<Produto> lista_produtos = new ArrayList<Produto>();
	private JTextField precoTextField;
	private JTextField nomeTextField;
	private JTextField codigoTextField;
	private JTextField localTextField;
	private JTextField contatoTextField;
	private JTextField categoriasTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalScreen frame = new PrincipalScreen();
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
	public PrincipalScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 606, 363);
		contentPane.add(tabbedPane);
		
		JPanel cadastroPane = new JPanel();
		tabbedPane.addTab("Cadastro Produto", null, cadastroPane, null);
		cadastroPane.setLayout(null);
		
		JLabel lblPreco = new JLabel("preço");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(10, 103, 57, 18);
		cadastroPane.add(lblPreco);
		
		precoTextField = new JTextField();
		precoTextField.setColumns(10);
		precoTextField.setBounds(58, 104, 86, 20);
		cadastroPane.add(precoTextField);
		
		JLabel lbNome = new JLabel("nome");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome.setBounds(10, 71, 57, 18);
		cadastroPane.add(lbNome);
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(58, 72, 196, 20);
		cadastroPane.add(nomeTextField);
		
		JLabel lbCodigo = new JLabel("codigo");
		lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCodigo.setBounds(10, 39, 57, 18);
		cadastroPane.add(lbCodigo);
		
		codigoTextField = new JTextField();
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(58, 40, 86, 20);
		cadastroPane.add(codigoTextField);
		
		JLabel lbLocalProduzido = new JLabel("Local Produzido");
		lbLocalProduzido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLocalProduzido.setBounds(10, 238, 120, 18);
		cadastroPane.add(lbLocalProduzido);
		
		localTextField = new JTextField();
		localTextField.setColumns(10);
		localTextField.setBounds(154, 239, 187, 20);
		cadastroPane.add(localTextField);
		
		JLabel lblContato = new JLabel("Contato Distribuidora");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContato.setBounds(10, 267, 134, 18);
		cadastroPane.add(lblContato);
		
		contatoTextField = new JTextField();
		contatoTextField.setColumns(10);
		contatoTextField.setBounds(154, 270, 187, 20);
		cadastroPane.add(contatoTextField);
		
		JTextPane descricaoTextPane = new JTextPane();
		descricaoTextPane.setBounds(279, 23, 322, 160);
		cadastroPane.add(descricaoTextPane);
		
		JLabel lblDescricao = new JLabel("Descrição Produto");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(284, 0, 120, 25);
		cadastroPane.add(lblDescricao);
		
		JButton runButton = new JButton("RUN");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		runButton.setBounds(512, 312, 89, 23);
		cadastroPane.add(runButton);
		
		categoriasTextField = new JTextField();
		categoriasTextField.setBounds(154, 212, 447, 20);
		cadastroPane.add(categoriasTextField);
		categoriasTextField.setColumns(10);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategorias.setBounds(10, 211, 120, 18);
		cadastroPane.add(lblCategorias);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
