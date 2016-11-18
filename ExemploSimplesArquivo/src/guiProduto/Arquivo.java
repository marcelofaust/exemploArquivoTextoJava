package guiProduto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Arquivo {

	static final String NOME_ARQ = "D:/PRODUTOS.TXT";
	static final String SEPARADOR = ";";
	
	public static ArrayList<Produto> retornaProdutos() {

		ArrayList<Produto> lista = new ArrayList<Produto>();
        
		try {
    		BufferedReader buffRead = new BufferedReader(new FileReader(NOME_ARQ));

            String linha = "";
            while (linha != null) {
            	linha = buffRead.readLine();
            	if (linha != null) {
            		String array[] = linha.split(SEPARADOR);
            		Produto p = new Produto(Integer.parseInt(array[0]), 
            								array[1], 
            								Float.parseFloat(array[2]));
            		lista.add(p);
            	}
            }
            buffRead.close();
            return lista;
		} catch (Exception e) {
			return lista;
		}
    }
 
    public static String salvarProduto(Produto prod) {
    	try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(NOME_ARQ, true));
            String conteudo = prod.getCodigo() + SEPARADOR + prod.getNome() + SEPARADOR + prod.getPreco() + "\n";  
            buffWrite.append(conteudo);
            buffWrite.close();
            return "Produto Inserido com sucesso.";
		} catch (Exception e) {
			return "Erro ao inserir o produto.";
		}
    }

}
