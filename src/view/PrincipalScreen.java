package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import produto.Produto;
import produto.Validacao;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrincipalScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	private HashMap<String, Produto> lista_produtos = new HashMap<String, Produto>();
	
	//Componentes Interface
	private JTextField precoTF_cadastro;
	private JTextField nomeTX_cadastro;
	private JTextField codigoTF_cadastro;
	private JTextField localTextField;
	private JTextField contatoTextField;
	private JTextField categoriasTX_cadastro;
	private JTable table;
	private JTextField codigoTF_buscar;
	private JTextField contatoTF_buscar;
	private JTextField localTF_buscar;
	private JTextField categoriasTF_buscar;
	private JTextField precoTF_buscar;
	private JTextField nomeTF_buscar;
	
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
		setTitle("Trabalho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 606, 363);
		contentPane.add(tabbedPane);
		
		
		
		JPanel cadastroPanel = new JPanel();
		tabbedPane.addTab("Cadastro Produto", null, cadastroPanel, null);
		cadastroPanel.setLayout(null);
		
		JLabel lblPreco = new JLabel("preço");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(0, 226, 57, 18);
		cadastroPanel.add(lblPreco);
		
		precoTF_cadastro = new JTextField();
		precoTF_cadastro.setColumns(10);
		precoTF_cadastro.setBounds(47, 226, 86, 20);
		cadastroPanel.add(precoTF_cadastro);
		
		JLabel lbNome = new JLabel("nome");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNome.setBounds(0, 194, 57, 18);
		cadastroPanel.add(lbNome);
		
		nomeTX_cadastro = new JTextField();
		nomeTX_cadastro.setColumns(10);
		nomeTX_cadastro.setBounds(47, 194, 196, 20);
		cadastroPanel.add(nomeTX_cadastro);
		
		JLabel lbCodigo = new JLabel("codigo");
		lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCodigo.setBounds(0, 162, 57, 18);
		cadastroPanel.add(lbCodigo);
		
		codigoTF_cadastro = new JTextField();
		codigoTF_cadastro.setColumns(10);
		codigoTF_cadastro.setBounds(47, 162, 86, 20);
		cadastroPanel.add(codigoTF_cadastro);
		
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
		lblContato.setBounds(0, 317, 149, 18);
		cadastroPanel.add(lblContato);
		
		contatoTextField = new JTextField();
		contatoTextField.setColumns(10);
		contatoTextField.setBounds(144, 318, 187, 20);
		cadastroPanel.add(contatoTextField);
		
		JTextPane descricaoTextPane = new JTextPane();
		descricaoTextPane.setBounds(279, 130, 322, 124);
		cadastroPanel.add(descricaoTextPane);
		
		
		JLabel lblDescricao = new JLabel("Descrição Produto");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cadastroPanel.add(lblDescricao);
		
		JLabel lblfoto = new JLabel("");
 		lblfoto.setBounds(0, 11, 150, 120);
 		cadastroPanel.add(lblfoto);
 		
		JButton runButton = new JButton("RUN");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean validacaoProduto=true;
				Produto p = new Produto();
				
				if((precoTF_cadastro.getText().matches("[0-9.]*") && !precoTF_cadastro.getText().isBlank())
					&& (Validacao.Codigo(codigoTF_cadastro.getText()) && !nomeTX_cadastro.getText().isBlank())) {
					System.out.println("Sucesso");
					p.setPreco(Float.parseFloat(precoTF_cadastro.getText()));
					p.setNome(nomeTX_cadastro.getText());
					p.setCodigo(codigoTF_cadastro.getText());
					
				} else validacaoProduto=false;
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(getParent());
				
				
				ImageIcon img= new ImageIcon(fileChooser.getSelectedFile().toString());//Carrega imagem
				
												//Escalona o img para tamanho do Jlabel lblfoto
				p.setIcon(new ImageIcon((Image)img.getImage().getScaledInstance(lblfoto.getWidth(),lblfoto.getHeight(),Image.SCALE_SMOOTH)));
				
				lblfoto.setIcon(p.getIconProduto());
				
				
				
				if(lista_produtos.get(p.getCodigo())==null && validacaoProduto) {//verificar se não existe nenhum produto com esse código
				
					lista_produtos.put(p.getCodigo(),p);				
										
					DefaultTableModel modelo =(DefaultTableModel) table.getModel();
					modelo.addRow(new Object[] {p.getCodigo(),p.getNome(),p.getPreco()});
					table.setModel(modelo);
					
				}
			
			}
		});
		runButton.setBounds(520, 303, 71, 32);
		cadastroPanel.add(runButton);
		
 		categoriasTX_cadastro = new JTextField();
 		lblDescricao.setBounds(279, 106, 120, 25);
 		categoriasTX_cadastro.setBounds(144, 257, 447, 20);
 		cadastroPanel.add(categoriasTX_cadastro);
 		categoriasTX_cadastro.setColumns(10);
 		
 		JLabel lblCategorias = new JLabel("Categorias");
 		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
 		lblCategorias.setBounds(0, 261, 120, 18);
 		cadastroPanel.add(lblCategorias);
 		
 		JPanel listaPanel = new JPanel();
 		tabbedPane.addTab("Lista Produto", null, listaPanel, null);
 		listaPanel.setLayout(null);
 		
 		table = new JTable();
 		table.setModel(new DefaultTableModel(
 			new Object[][] {
 				{null, null, null},
 			},
 			new String[] {
 				"CÓDIGO", "NOME", "PREÇO"
 			}
 		));
 		table.setBounds(0, 0, 601, 336);
 		listaPanel.add(table);
 		
 		JPanel buscaPanel = new JPanel();
 		tabbedPane.addTab("Buscar Produto", null, buscaPanel, null);
 		buscaPanel.setLayout(null);
 		
 		JLabel lblCodigo = new JLabel("Código");
 		lblCodigo.setFont(new Font("Monospaced", Font.BOLD, 13));
 		lblCodigo.setBounds(0, 33, 55, 15);
 		buscaPanel.add(lblCodigo);
 		
 		codigoTF_buscar = new JTextField();
 		codigoTF_buscar.setBounds(51, 31, 104, 19);
 		buscaPanel.add(codigoTF_buscar);
 		codigoTF_buscar.setColumns(10);
 		
 		contatoTF_buscar = new JTextField();
 		contatoTF_buscar.setEditable(false);
 		contatoTF_buscar.setColumns(10);
 		contatoTF_buscar.setBounds(144, 275, 187, 20);
 		buscaPanel.add(contatoTF_buscar);
 		
 		JLabel lblContato_1 = new JLabel("Contato Distribuidora");
 		lblContato_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblContato_1.setBounds(0, 274, 149, 18);
 		buscaPanel.add(lblContato_1);
 		
 		JLabel lbLocalProduzido_1 = new JLabel("Local Produzido");
 		lbLocalProduzido_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbLocalProduzido_1.setBounds(0, 245, 120, 18);
 		buscaPanel.add(lbLocalProduzido_1);
 		
 		localTF_buscar = new JTextField();
 		localTF_buscar.setEditable(false);
 		localTF_buscar.setColumns(10);
 		localTF_buscar.setBounds(144, 241, 187, 20);
 		buscaPanel.add(localTF_buscar);
 		
 		categoriasTF_buscar = new JTextField();
 		categoriasTF_buscar.setEditable(false);
 		categoriasTF_buscar.setColumns(10);
 		categoriasTF_buscar.setBounds(144, 214, 447, 20);
 		buscaPanel.add(categoriasTF_buscar);
 		
 		JLabel lblCategorias_1 = new JLabel("Categorias");
 		lblCategorias_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblCategorias_1.setBounds(0, 218, 120, 18);
 		buscaPanel.add(lblCategorias_1);
 		
 		JLabel lblPreco_1 = new JLabel("preço");
 		lblPreco_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblPreco_1.setBounds(0, 183, 57, 18);
 		buscaPanel.add(lblPreco_1);
 		
 		precoTF_buscar = new JTextField();
 		precoTF_buscar.setEditable(false);
 		precoTF_buscar.setColumns(10);
 		precoTF_buscar.setBounds(47, 183, 86, 20);
 		buscaPanel.add(precoTF_buscar);
 		
 		JLabel lbNome_1 = new JLabel("nome");
 		lbNome_1.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbNome_1.setBounds(0, 151, 57, 18);
 		buscaPanel.add(lbNome_1);
 		
 		nomeTF_buscar = new JTextField();
 		nomeTF_buscar.setEditable(false);
 		nomeTF_buscar.setColumns(10);
 		nomeTF_buscar.setBounds(47, 151, 196, 20);
 		buscaPanel.add(nomeTF_buscar);
 		
 		JLabel lblfoto_1 = new JLabel("");
 		lblfoto_1.setBounds(441, 12, 150, 120);
 		buscaPanel.add(lblfoto_1);
 		
 		JButton btnProcurar = new JButton("Procurar");
 		btnProcurar.setBounds(10, 60, 98, 25);
 		buscaPanel.add(btnProcurar);
 		
 		btnProcurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(lista_produtos.get(codigoTF_buscar.getText())!=null) {
					
					nomeTF_buscar.setText(lista_produtos.get(codigoTF_buscar.getText()).getNome());
					lblfoto_1.setIcon(lista_produtos.get(codigoTF_buscar.getText()).getIconProduto());
				}
				else JOptionPane.showMessageDialog(null,"CODIGO DE PRODUTO NÃO ECONTRADO");
			}
 			
 		});
 		
 		JPanel panel_1 = new JPanel();
 		tabbedPane.addTab("Atualizar", null, panel_1, null);
 		
 		JPanel panel_2 = new JPanel();
 		tabbedPane.addTab("Deleta", null, panel_2, null);
 		
 		
	}
}
