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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PrincipalScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	private ArrayList<Produto> lista_produtos = new ArrayList<Produto>();
	
	//Componentes Interface
	private JTextField precoTextField;
	private JTextField nomeTextField;
	private JTextField codigoTextField;
	private JTextField localTextField;
	private JTextField contatoTextField;
	private JTextField categoriasTextField;
	private JTextField codigoTextField_1;
	private JTable table;
	
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
		
		JPanel buscaPanel = new JPanel();
		tabbedPane.addTab("Buscar Produto", null, buscaPanel, null);
		buscaPanel.setLayout(null);
		
		JLabel codigoPanel = new JLabel("Escolha Codigo");
		codigoPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codigoPanel.setBounds(10, 11, 96, 19);
		buscaPanel.add(codigoPanel);
		
		codigoTextField_1 = new JTextField();
		codigoTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codigoTextField_1.setBounds(116, 12, 86, 20);
		buscaPanel.add(codigoTextField_1);
		codigoTextField_1.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(285, 118, 251, 178);
		buscaPanel.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(0, 145, 601, 190);
		buscaPanel.add(table);
		
		
		
		JPanel cadastroPanel = new JPanel();
		tabbedPane.addTab("Cadastro Produto", null, cadastroPanel, null);
		cadastroPanel.setLayout(null);
		
		JLabel lblPreco = new JLabel("preço");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(0, 226, 57, 18);
		cadastroPanel.add(lblPreco);
		
		precoTextField = new JTextField();
		precoTextField.setColumns(10);
		precoTextField.setBounds(47, 226, 86, 20);
		cadastroPanel.add(precoTextField);
		
		JLabel lbNome = new JLabel("nome");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome.setBounds(0, 194, 57, 18);
		cadastroPanel.add(lbNome);
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(47, 194, 196, 20);
		cadastroPanel.add(nomeTextField);
		
		JLabel lbCodigo = new JLabel("codigo");
		lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCodigo.setBounds(0, 162, 57, 18);
		cadastroPanel.add(lbCodigo);
		
		codigoTextField = new JTextField();
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(47, 162, 86, 20);
		cadastroPanel.add(codigoTextField);
		
		JLabel lbLocalProduzido = new JLabel("Local Produzido");
		lbLocalProduzido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLocalProduzido.setBounds(0, 288, 120, 18);
		cadastroPanel.add(lbLocalProduzido);
		
		localTextField = new JTextField();
		localTextField.setColumns(10);
		localTextField.setBounds(144, 284, 187, 20);
		cadastroPanel.add(localTextField);
		
		JLabel lblContato = new JLabel("Contato Distribuidora");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContato.setBounds(0, 317, 134, 18);
		cadastroPanel.add(lblContato);
		
		contatoTextField = new JTextField();
		contatoTextField.setColumns(10);
		contatoTextField.setBounds(144, 315, 187, 20);
		cadastroPanel.add(contatoTextField);
		
		JTextPane descricaoTextPane = new JTextPane();
		descricaoTextPane.setBounds(279, 130, 322, 124);
		cadastroPanel.add(descricaoTextPane);
		
		
		JLabel lblDescricao = new JLabel("Descrição Produto");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cadastroPanel.add(lblDescricao);
		
		JLabel lblfoto = new JLabel("");
 		lblfoto.setBounds(0, 11, 133, 108);
 		cadastroPanel.add(lblfoto);
 		
		JButton runButton = new JButton("RUN");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto p = new Produto();
				if(precoTextField.getText().matches("[0-9.]*") && !precoTextField.getText().isBlank()) {
					System.out.println("Sucesso");
					p.setPreco(Float.parseFloat(precoTextField.getText()));
				}
				
				p.setNome(nomeTextField.getText());
				p.setCodigo(codigoTextField.getText());
				
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(getParent());
				
				
				ImageIcon img= new ImageIcon(fileChooser.getSelectedFile().toString());//Carrega imagem
				
												//Escalona o img para tamanho do Jlabel lblfoto
				p.setIcon(new ImageIcon((Image)img.getImage().getScaledInstance(lblfoto.getWidth(),lblfoto.getHeight(),Image.SCALE_SMOOTH)));
				
				lblfoto.setIcon(p.getIconProduto());
				
				lista_produtos.add(p);
				
				DefaultTableModel modelo =(DefaultTableModel) table.getModel();
				modelo.addRow(new Object[] {p.getCodigo(),p.getNome(),p.getPreco()});
				table.setModel(modelo);
			}
		});
		runButton.setBounds(520, 303, 71, 32);
		cadastroPanel.add(runButton);
		
 		categoriasTextField = new JTextField();
 		lblDescricao.setBounds(279, 106, 120, 25);
 		categoriasTextField.setBounds(144, 257, 447, 20);
 		cadastroPanel.add(categoriasTextField);
 		categoriasTextField.setColumns(10);
 		
 		JLabel lblCategorias = new JLabel("Categorias");
 		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
 		lblCategorias.setBounds(0, 261, 120, 18);
 		cadastroPanel.add(lblCategorias);
 		
 		
	}
}
