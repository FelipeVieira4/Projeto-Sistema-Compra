package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import produto.*;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.sql.ConnectionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dados.ConexaoMySQL;
import dados.GrubDados;

public class PrincipalScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	private HashMap<String, Produto> lista_produtos = new HashMap<String, Produto>();
	
	private ArrayList<CompraProduto> lista_compra = new ArrayList<CompraProduto>();
	
	//Componentes Interface
	private JTextField precoTF_cadastro;
	private JTextField nomeTX_cadastro;
	private JTextField codigoTF_cadastro;
	private JTextField localTextField;
	private JTextField contatoTextField;
	private JTextField categoriasTX_cadastro;
	private JTable table_Lista;
	private JTextField codigoTF_buscar;
	private JTextField contatoTF_buscar;
	private JTextField localTF_buscar;
	private JTextField categoriasTF_buscar;
	private JTextField precoTF_buscar;
	private JTextField nomeTF_buscar;
	private JTextField codigoTF_deleta;
	private JTextField codigoTF_Compra;
	private JTable tableCompra;
	private JTextField precoTF_compra;
	private JTextField qtdaTF_compra;
	private JTextField removerTF_compra;
	
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
					
					p.setPreco(Float.parseFloat(precoTF_cadastro.getText()));
					p.setNome(nomeTX_cadastro.getText());
					p.setCodigo(codigoTF_cadastro.getText());
					
					String[] s = categoriasTX_cadastro.getText().split(" ");
					p.setCategorias(s);
					
					p.setContatoDistribuidora(contatoTextField.getText());
					p.setLocalProduzido(localTextField.getText());
					
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.showOpenDialog(getParent());
					
					File file = fileChooser.getSelectedFile();
					if(file!=null) {
						ImageIcon img= new ImageIcon(file.toString());//Carrega imagem
						//Escalona o img para tamanho do Jlabel lblfoto
							p.setIcon(new ImageIcon((Image)img.getImage().getScaledInstance(lblfoto.getWidth(),lblfoto.getHeight(),Image.SCALE_SMOOTH)));
							lblfoto.setIcon(p.getIconProduto());
					}
					
				} else validacaoProduto=false;
				
				
					
				if(lista_produtos.get(p.getCodigo())==null && validacaoProduto) {//verificar se não existe nenhum produto com esse código
					
						lista_produtos.put(p.getCodigo(),p);			
						
						
						DefaultTableModel modelo =(DefaultTableModel) table_Lista.getModel();
						modelo.addRow(new Object[] {p.getCodigo(),p.getNome(),p.getPreco()});
						table_Lista.setModel(modelo);
				}
				
				GrubDados.salvarProduto(p);
				
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
 		
 		table_Lista = new JTable();
 		table_Lista.setModel(new DefaultTableModel(
 			new Object[][] {
 				{null, null, null},
 			},
 			new String[] {
 				"CÓDIGO", "NOME", "PREÇO"
 			}
 		));
 		table_Lista.setBounds(0, 0, 601, 336);
 		listaPanel.add(table_Lista);
 		
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
 		
 		JLabel lblContato_buscar = new JLabel("Contato Distribuidora");
 		lblContato_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblContato_buscar.setBounds(0, 274, 149, 18);
 		buscaPanel.add(lblContato_buscar);
 		
 		JLabel lbLocalProduzido_buscar = new JLabel("Local Produzido");
 		lbLocalProduzido_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbLocalProduzido_buscar.setBounds(0, 245, 120, 18);
 		buscaPanel.add(lbLocalProduzido_buscar);
 		
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
 		
 		JLabel lblCategorias_buscar = new JLabel("Categorias");
 		lblCategorias_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblCategorias_buscar.setBounds(0, 218, 120, 18);
 		buscaPanel.add(lblCategorias_buscar);
 		
 		JLabel lblPreco_buscar = new JLabel("preço");
 		lblPreco_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lblPreco_buscar.setBounds(0, 183, 57, 18);
 		buscaPanel.add(lblPreco_buscar);
 		
 		precoTF_buscar = new JTextField();
 		precoTF_buscar.setEditable(false);
 		precoTF_buscar.setColumns(10);
 		precoTF_buscar.setBounds(47, 183, 86, 20);
 		buscaPanel.add(precoTF_buscar);
 		
 		JLabel lbNome_buscar = new JLabel("nome");
 		lbNome_buscar.setFont(new Font("Dialog", Font.PLAIN, 15));
 		lbNome_buscar.setBounds(0, 151, 57, 18);
 		buscaPanel.add(lbNome_buscar);
 		
 		nomeTF_buscar = new JTextField();
 		nomeTF_buscar.setEditable(false);
 		nomeTF_buscar.setColumns(10);
 		nomeTF_buscar.setBounds(47, 151, 196, 20);
 		buscaPanel.add(nomeTF_buscar);
 		
 		JLabel lblfoto_buscar = new JLabel("");
 		lblfoto_buscar.setBounds(441, 12, 150, 120);
 		buscaPanel.add(lblfoto_buscar);
 		
 		JButton btnProcurar_buscar = new JButton("Procurar");
 		btnProcurar_buscar.setBounds(10, 60, 98, 25);
 		buscaPanel.add(btnProcurar_buscar);
 		
 		btnProcurar_buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(lista_produtos.get(codigoTF_buscar.getText())!=null) {
					
					nomeTF_buscar.setText(lista_produtos.get(codigoTF_buscar.getText()).getNome());
					lblfoto_buscar.setIcon(lista_produtos.get(codigoTF_buscar.getText()).getIconProduto());
					precoTF_buscar.setText(String.valueOf(lista_produtos.get(codigoTF_buscar.getText()).getPreco()));
					
					localTF_buscar.setText(lista_produtos.get(codigoTF_buscar.getText()).getLocalProduzido());
					contatoTF_buscar.setText(lista_produtos.get(codigoTF_buscar.getText()).getContatoDistribuidora());
					
					categoriasTF_buscar.setText("[");
					for(String i: lista_produtos.get(codigoTF_buscar.getText()).getCategoriasToArray()) {
						categoriasTF_buscar.setText(categoriasTF_buscar.getText()+i+",");
					}
					categoriasTF_buscar.setText(categoriasTF_buscar.getText()+"]");
					
					
				}
				else JOptionPane.showMessageDialog(null,"CODIGO DE PRODUTO NÃO ECONTRADO");
			}
 			
 		});
 		
 		JPanel deletePanel = new JPanel();
 		tabbedPane.addTab("Deleta", null, deletePanel, null);
 		deletePanel.setLayout(null);
 		
 		JLabel lblCodigo_deleta = new JLabel("Codigo Produto");
 		lblCodigo_deleta.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblCodigo_deleta.setBounds(10, 11, 126, 26);
 		deletePanel.add(lblCodigo_deleta);
 		
 		codigoTF_deleta = new JTextField();
 		codigoTF_deleta.setBounds(146, 16, 86, 20);
 		deletePanel.add(codigoTF_deleta);
 		codigoTF_deleta.setColumns(10);
 		
 		JButton btnDeletaProduto_deleta = new JButton("DELETAR");
 		btnDeletaProduto_deleta.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 				if(lista_produtos.get(codigoTF_deleta.getText())!=null) {
 					
 					
 					lista_produtos.remove(codigoTF_deleta.getText());
 					
 					
 					//table_Lista.removeAll();
 					DefaultTableModel modelo =(DefaultTableModel) table_Lista.getModel();
 					
 					modelo.setRowCount(0);//limpa todas as colunas do modelo
 					
 					//loop adicionar lista_produto ao modelo
	 				for (String chaves : lista_produtos.keySet()) {
	 					modelo.addRow(new Object[] {lista_produtos.get(chaves).getCodigo(),lista_produtos.get(chaves).getNome(),lista_produtos.get(chaves).getPreco()});
						
	 		        }
	 				table_Lista.setModel(modelo);

	 				 				
 				}
 			}
 		});
 		btnDeletaProduto_deleta.setFont(new Font("Tahoma", Font.PLAIN, 12));
 		btnDeletaProduto_deleta.setBounds(20, 48, 89, 34);
 		deletePanel.add(btnDeletaProduto_deleta);
 		
 		JPanel listaCompraPanel = new JPanel();
 		tabbedPane.addTab("Compra", null, listaCompraPanel, null);
 		listaCompraPanel.setLayout(null);
 		
 		JLabel lblNewLabel = new JLabel("Código");
 		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
 		lblNewLabel.setBounds(413, 37, 49, 22);
 		listaCompraPanel.add(lblNewLabel);
 		
 		codigoTF_Compra = new JTextField();
 		codigoTF_Compra.setBounds(465, 40, 86, 20);
 		listaCompraPanel.add(codigoTF_Compra);
 		codigoTF_Compra.setColumns(10);
 		
 		tableCompra = new JTable();
 		tableCompra.setModel(new DefaultTableModel(
 			new Object[][] {
 				{null, null, null, null},
 			},
 			new String[] {
 				"New column", "New column", "New column", "New column"
 			}
 		));
 		tableCompra.setBounds(10, 23, 393, 204);
 		listaCompraPanel.add(tableCompra);
 		
 		
 		JButton bntAdicionar_produto = new JButton("Adicionar");
 		bntAdicionar_produto.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 				if(Validacao.IntTipo(qtdaTF_compra.getText()) && lista_produtos.get(codigoTF_Compra.getText())!=null) {
 					CompraProduto p = new CompraProduto(lista_produtos.get(codigoTF_Compra.getText()),Integer.parseInt(qtdaTF_compra.getText()));
 					p.setCodigo(String.valueOf(lista_compra.size()));
 					p.setPrecoTotal();
 					lista_compra.add(p);
 					
 					DefaultTableModel modelo =(DefaultTableModel) tableCompra.getModel();
 					modelo.addRow(new Object[] {p.getProduto().getNome(),p.getQtda(),p.getPrecoTotal(),lista_compra.size()-1});
 					tableCompra.setModel(modelo);
 				}
 			}
 		});
 		bntAdicionar_produto.setFont(new Font("Tahoma", Font.BOLD, 12));
 		bntAdicionar_produto.setBounds(449, 160, 102, 34);
 		listaCompraPanel.add(bntAdicionar_produto);
 		

 		JLabel lblNewLabel_1 = new JLabel("Preço");
 		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
 		lblNewLabel_1.setBounds(413, 205, 49, 22);
 		listaCompraPanel.add(lblNewLabel_1);
 		
 		precoTF_compra = new JTextField();
 		precoTF_compra.setEditable(false);
 		precoTF_compra.setBounds(465, 207, 86, 20);
 		listaCompraPanel.add(precoTF_compra);
 		precoTF_compra.setColumns(10);
 		
 		JLabel lblQtda_compra = new JLabel("QTDA");
 		lblQtda_compra.setFont(new Font("Tahoma", Font.BOLD, 14));
 		lblQtda_compra.setBounds(413, 87, 49, 22);
 		listaCompraPanel.add(lblQtda_compra);
 		
 		qtdaTF_compra = new JTextField();
 		qtdaTF_compra.setColumns(10);
 		qtdaTF_compra.setBounds(465, 90, 86, 20);
 		listaCompraPanel.add(qtdaTF_compra);
 		
 		removerTF_compra = new JTextField();
 		removerTF_compra.setColumns(10);
 		removerTF_compra.setBounds(82, 309, 86, 20);
 		listaCompraPanel.add(removerTF_compra);
 		
 		JLabel lblQtda_compra_1 = new JLabel("Código");
 		lblQtda_compra_1.setFont(new Font("Tahoma", Font.BOLD, 14));
 		lblQtda_compra_1.setBounds(23, 306, 49, 22);
 		listaCompraPanel.add(lblQtda_compra_1);
 		
 		JButton bntRemover_compra = new JButton("Remover");
 		bntRemover_compra.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 							
 				if(Validacao.IntTipo(removerTF_compra.getText()) && lista_compra.size()>Integer.parseInt(removerTF_compra.getText()) && Integer.parseInt(removerTF_compra.getText())>=0){
 					lista_compra.remove(Integer.parseInt(removerTF_compra.getText()));
 					
 					DefaultTableModel modelo = (DefaultTableModel) tableCompra.getModel();
 					
 					modelo.setRowCount(0); //Limpar tabela
 					
 					for(int i=0;i<lista_compra.size();i++) {
 						modelo.addRow(new Object[] {lista_compra.get(i).getProduto().getNome(),
 													lista_compra.get(i).getQtda(),
					 								lista_compra.get(i).getPrecoTotal(),
					 								i
 												}
 						);

 	 				}
 					tableCompra.setModel(modelo);
 					
 				}
 			}
 		});
 		bntRemover_compra.setFont(new Font("Tahoma", Font.BOLD, 12));
 		bntRemover_compra.setBounds(178, 301, 102, 34);
 		listaCompraPanel.add(bntRemover_compra);
 		
 		JLabel lblNewLabel_2 = new JLabel("Código");
 		lblNewLabel_2.setBounds(324, 2, 49, 17);
 		listaCompraPanel.add(lblNewLabel_2);
 		
 		JLabel lblNewLabel_2_1 = new JLabel("Preço");
 		lblNewLabel_2_1.setBounds(240, 2, 40, 17);
 		listaCompraPanel.add(lblNewLabel_2_1);
 		
 		JLabel lblNewLabel_2_1_1 = new JLabel("Unidades");
 		lblNewLabel_2_1_1.setBounds(127, 2, 58, 17);
 		listaCompraPanel.add(lblNewLabel_2_1_1);
 		
 		JLabel lblNewLabel_2_1_1_1 = new JLabel("Nome");
 		lblNewLabel_2_1_1_1.setBounds(23, 2, 58, 17);
 		listaCompraPanel.add(lblNewLabel_2_1_1_1);
 		
	}
}
