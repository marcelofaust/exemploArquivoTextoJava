package guiProduto;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class frmProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JButton btnIncluir;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProduto frame = new frmProduto();
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
	public frmProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlDados = new JPanel();
		contentPane.add(pnlDados);
		GridBagLayout gbl_pnlDados = new GridBagLayout();
		gbl_pnlDados.columnWidths = new int[]{179, 230, 0};
		gbl_pnlDados.rowHeights = new int[]{20, 20, 20, 0};
		gbl_pnlDados.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDados.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDados.setLayout(gbl_pnlDados);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.fill = GridBagConstraints.BOTH;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		pnlDados.add(lblCdigo, gbc_lblCdigo);
		
		txtCodigo = new JTextField();
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.fill = GridBagConstraints.BOTH;
		gbc_txtCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 0;
		pnlDados.add(txtCodigo, gbc_txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.fill = GridBagConstraints.BOTH;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		pnlDados.add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.BOTH;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		pnlDados.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		GridBagConstraints gbc_lblPreo = new GridBagConstraints();
		gbc_lblPreo.fill = GridBagConstraints.BOTH;
		gbc_lblPreo.insets = new Insets(0, 0, 0, 5);
		gbc_lblPreo.gridx = 0;
		gbc_lblPreo.gridy = 2;
		pnlDados.add(lblPreo, gbc_lblPreo);
		
		txtPreco = new JTextField();
		GridBagConstraints gbc_txtPreco = new GridBagConstraints();
		gbc_txtPreco.fill = GridBagConstraints.BOTH;
		gbc_txtPreco.gridx = 1;
		gbc_txtPreco.gridy = 2;
		pnlDados.add(txtPreco, gbc_txtPreco);
		txtPreco.setColumns(10);
		
		JPanel pnlTitulo = new JPanel();
		contentPane.add(pnlTitulo, BorderLayout.NORTH);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		pnlTitulo.add(lblCadastroDeProdutos);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Produto p = new Produto();
				p.setCodigo(Integer.parseInt(txtCodigo.getText()));
				p.setNome(txtNome.getText());
				p.setPreco(Float.parseFloat(txtPreco.getText()));
				
				String resp = Arquivo.salvarProduto(p);
				JOptionPane.showMessageDialog(null, resp);
				
				txtCodigo.setText("0");
				txtNome.setText("");
				txtPreco.setText("0");
			}
		});
		pnlBotoes.add(btnIncluir);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Produto> lista = Arquivo.retornaProdutos();
				String dados = "";

				for (int i = 0; i < lista.size(); i++) {
					Produto p = lista.get(i);
					
					dados = dados + "Código: " + p.getCodigo() + "    Nome: " + p.getNome() + "    Preço: " + p.getPreco() + "\n";
				}
				JOptionPane.showMessageDialog(null, dados);
			}
		});
		pnlBotoes.add(btnImprimir);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		pnlBotoes.add(btnFechar);
	}

	
	
	public JTextField getTxtCodigo() {
		return txtCodigo;
	}
	public JButton getBtnIncluir() {
		return btnIncluir;
	}
	public JButton getBtnImprimir() {
		return btnImprimir;
	}
}
