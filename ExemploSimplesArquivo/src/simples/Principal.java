package simples;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		final String NOME_ARQ = "D:/teste.txt";
		
		try {
			criarArquivo(JOptionPane.showInputDialog("Digite o conteudo do arquivo"), NOME_ARQ);
			
			String texto = lerArquivo(NOME_ARQ);
			System.out.println("Conteúdo do arquivo: " + texto);

		} catch (Exception e) {
			System.out.println("Erro ao criar ou ler o arquivo! Erro: " + e.getMessage());
		}
	}

	
	public static String lerArquivo(String caminhoENomeArq) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(caminhoENomeArq));
        String conteudo = "";
        String linha = "";
        while (linha != null) {
        	linha = buffRead.readLine();
        	if (linha != null) {
        		conteudo = conteudo + "\n" + linha;
        	}
        }
        buffRead.close();
        return conteudo;
    }
 
    public static void criarArquivo(String conteudo, String caminhoENomeArq) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminhoENomeArq));
        buffWrite.append(conteudo);
        buffWrite.close();
    }
}	
