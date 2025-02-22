package application;

import java.util.Scanner;

import DAO.DDDDAO;
import DAO.departamentoDAO;
import DAO.depositoDAO;
import DAO.enderecoDAO;
import DAO.fornecedorDAO;
import DAO.fornecedor_projetoDAO;
import DAO.funcionarioDAO;
import DAO.funcionario_projetoDAO;
import DAO.pecaDAO;
import DAO.peca_fornecedorDAO;
import DAO.projetoDAO;
import DAO.telefoneDAO;
import entity.DDD;
import entity.departamento;
import entity.deposito;
import entity.endereco;
import entity.fornecedor;
import entity.fornecedor_projeto;
import entity.funcionario;
import entity.funcionario_projeto;
import entity.peca;
import entity.peca_fornecedor;
import entity.projeto;
import entity.telefone;

public class Programa {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String senha;
		
		while (true) {
			System.out.print("Digite a senha para acessar o sistema: ");
			senha = scanner.nextLine();

			if (senha.equals("123")) {
				System.out.println("Acesso permitido.");
				break;
			} else {
				System.out.println("Senha incorreta. Tente novamente.");
			}
		}

		
		while (true) {
			System.out.println("\nMenu de Cadastro:");
			System.out.println("1. Cadastrar DDD");
			System.out.println("2. Cadastrar Fornecedor");
			System.out.println("3. Cadastrar Departamento");
			System.out.println("4. Cadastrar Funcionário");
			System.out.println("5. Cadastrar Telefone");
			System.out.println("6. Cadastrar Projeto");
			System.out.println("7. Cadastrar Funcionário em Projeto");
			System.out.println("8. Cadastrar Depósito");
			System.out.println("9. Cadastrar Endereço");
			System.out.println("10. Cadastrar Peça");
			System.out.println("11. Cadastrar Peça para Fornecedor");
			System.out.println("12. Cadastrar Fornecedor para Projeto");
			System.out.println("13. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine(); 

			switch (opcao) {
			case 1:
				cadastrarDDD(scanner);
				break;
			case 2:
				cadastrarFornecedor(scanner);
				break;
			case 3:
				cadastrarDepartamento(scanner);
				break;
			case 4:
				cadastrarFuncionario(scanner);
				break;
			case 5:
				cadastrarTelefone(scanner);
				break;
			case 6:
				cadastrarProjeto(scanner);
				break;
			case 7:
				cadastrarFuncionarioProjeto(scanner);
				break;
			case 8:
				cadastrarDeposito(scanner);
				break;
			case 9:
				cadastrarEndereco(scanner);
				break;
			case 10:
				cadastrarPeca(scanner);
				break;
			case 11:
				cadastrarPecaFornecedor(scanner);
				break;
			case 12:
				cadastrarFornecedorProjeto(scanner);
				break;
			case 13:
				System.out.println("Saindo...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private static void cadastrarDDD(Scanner scanner) {
		System.out.print("Número do DDD: ");
        int numDDD = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Região do DDD: ");
        String regiaoDDD = scanner.nextLine();
		DDD ddd = new DDD();
		ddd.setNumDDD(numDDD);
		ddd.setRegiaoDDD(regiaoDDD);

		new DDDDAO().cadastrarDDD(ddd);
		System.out.println("DDD cadastrado com sucesso!");
	}

	private static void cadastrarFornecedor(Scanner scanner) {
		System.out.print("Nome do Fornecedor: ");
		String nomeFornecedor = scanner.nextLine();

		fornecedor fornecedor = new fornecedor();
		fornecedor.setNomeFornecedor(nomeFornecedor);

		new fornecedorDAO().cadastrarFornecedor(fornecedor);
		System.out.println("Fornecedor cadastrado com sucesso!");
	}

	private static void cadastrarDepartamento(Scanner scanner) {
		System.out.print("Setor do Departamento: ");
		String setorDepart = scanner.nextLine();

		departamento departamento = new departamento();
		departamento.setSetorDepart(setorDepart);

		new departamentoDAO().cadastrarDepartamento(departamento);
		System.out.println("Departamento cadastrado com sucesso!");
	}

	private static void cadastrarFuncionario(Scanner scanner) {
		System.out.print("Nome do Funcionário: ");
		String nomeFunc = scanner.nextLine();
		System.out.print("Salário do Funcionário: ");
		double salariFunc = scanner.nextDouble();
		System.out.print("Número do Departamento: ");
		int numDepart = scanner.nextInt();
		scanner.nextLine(); 
		System.out.print("Data de Início do Funcionário (YYYY-MM-DD): ");
		String dataInicioFunc = scanner.nextLine();

		funcionario funcionario = new funcionario();
		funcionario.setNomeFunc(nomeFunc);
		funcionario.setSalariFunc(salariFunc);
		funcionario.setNumDepart(numDepart);
		funcionario.setDataInicioFunc(dataInicioFunc);

		new funcionarioDAO().cadastrarFuncionario(funcionario);
		System.out.println("Funcionário cadastrado com sucesso!");
	}

	private static void cadastrarTelefone(Scanner scanner) {
	    System.out.print("Número do Telefone: ");
	    String numTelefone = scanner.nextLine();
	    System.out.print("Código DDD: ");
	    int codDDD = scanner.nextInt();
	    scanner.nextLine(); 

	    System.out.print("Número do Fornecedor (ou deixe em branco para nulo): ");
	    String numFornecedorInput = scanner.nextLine().trim();
	    Integer numFornecedor = numFornecedorInput.isEmpty() ? null : Integer.parseInt(numFornecedorInput);

	    System.out.print("Número do Funcionário: ");
	    int numFunc = scanner.nextInt();
	    scanner.nextLine(); 

	    telefone telefone = new telefone();
	    telefone.setNumTelefone(numTelefone);
	    telefone.setCodDDD(codDDD);
	    telefone.setNumFornecedor(numFornecedor);
	    telefone.setNumFunc(numFunc);

	    new telefoneDAO().cadastrarTelefone(telefone);
	    System.out.println("Telefone cadastrado com sucesso!");
	}

	private static void cadastrarProjeto(Scanner scanner) {
		System.out.print("Orçamento do Projeto: ");
		double orcaProjeto = scanner.nextDouble();
		scanner.nextLine(); 

		projeto projeto = new projeto();
		projeto.setOrcaProjeto(orcaProjeto);

		new projetoDAO().cadastrarProjeto(projeto);
		System.out.println("Projeto cadastrado com sucesso!");
	}

	private static void cadastrarFuncionarioProjeto(Scanner scanner) {
		System.out.print("Número do Funcionário: ");
		int numFunc = scanner.nextInt();
		System.out.print("Número do Projeto: ");
		int numProjeto = scanner.nextInt();
		scanner.nextLine(); 
		System.out.print("Data de Início do Projeto (YYYY-MM-DD): ");
		String dataInicioProjeto = scanner.nextLine();
		System.out.print("Horas Trabalhadas: ");
		double horasTrabalhadas = scanner.nextDouble();
		scanner.nextLine(); 

		funcionario_projeto funcionarioProjeto = new funcionario_projeto();
		funcionarioProjeto.setNumFunc(numFunc);
		funcionarioProjeto.setNumProjeto(numProjeto);
		funcionarioProjeto.setDataInicioProjeto(dataInicioProjeto);
		funcionarioProjeto.setHorasTrabalhadas(horasTrabalhadas);

		new funcionario_projetoDAO().cadastrarFuncionario_projeto(funcionarioProjeto);
		System.out.println("Funcionário em Projeto cadastrado com sucesso!");
	}

	private static void cadastrarDeposito(Scanner scanner) {
		System.out.print("Nome do Depósito: ");
		String nomeDeposito = scanner.nextLine();

		deposito deposito = new deposito();
		deposito.setNomeDeposito(nomeDeposito);

		new depositoDAO().cadastrarDeposito(deposito);
		System.out.println("Depósito cadastrado com sucesso!");
	}

	private static void cadastrarEndereco(Scanner scanner) {
		System.out.print("Logradouro do Endereço: ");
		String lograEndereco = scanner.nextLine();
		System.out.print("Número do Endereço: ");
		int numEndereco = scanner.nextInt();
		scanner.nextLine(); 
		System.out.print("Cidade do Endereço: ");
		String cidadeEndereco = scanner.nextLine();
		System.out.print("Estado do Endereço: ");
		String estadoEndereco = scanner.nextLine();
		System.out.print("Número do Fornecedor (ou deixe em branco para nulo): ");
		String numFornecedorInput = scanner.nextLine().trim();
		Integer numFornecedor = numFornecedorInput.isEmpty() ? null : Integer.parseInt(numFornecedorInput);
		System.out.print("Número do Depósito (ou deixe em branco para nulo): ");
		String numDepositoInput = scanner.nextLine().trim();
		Integer numDeposito = numDepositoInput.isEmpty() ? null : Integer.parseInt(numDepositoInput);

		endereco endereco = new endereco();
		endereco.setLograEndereco(lograEndereco);
		endereco.setNumEndereco(numEndereco);
		endereco.setCidadeEndereco(cidadeEndereco);
		endereco.setEstadoEndereco(estadoEndereco);
		endereco.setNumFornecedor(numFornecedor);
		endereco.setNumDeposito(numDeposito);

		new enderecoDAO().cadastrarEndereco(endereco);
		System.out.println("Endereço cadastrado com sucesso!");
	}

	private static void cadastrarPeca(Scanner scanner) {
		System.out.print("Peso da Peça: ");
		double pesoPeca = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Número do Depósito: ");
        int numDeposito = scanner.nextInt();
		System.out.print("Cor da Peça: ");
		String corPeca = scanner.nextLine();

		peca peca = new peca();
		peca.setPesoPeca(pesoPeca);
		peca.setCorPeca(corPeca);
		peca.setNumDeposito(numDeposito);

		new pecaDAO().cadastrarPeca(peca);
		System.out.println("Peça cadastrada com sucesso!");
	}

	private static void cadastrarPecaFornecedor(Scanner scanner) {
		System.out.print("Número do Fornecedor: ");
		int numFornecedor = scanner.nextInt();
		System.out.print("Número da Peça: ");
		int numPeca = scanner.nextInt();
		scanner.nextLine(); 

		peca_fornecedor pecaFornecedor = new peca_fornecedor();
		pecaFornecedor.setNumFornecedor(numFornecedor);
		pecaFornecedor.setNumPeca(numPeca);

		new peca_fornecedorDAO().cadastrarPeca_fornecedor(pecaFornecedor);
		System.out.println("Peça para Fornecedor cadastrada com sucesso!");
	}

	private static void cadastrarFornecedorProjeto(Scanner scanner) {
		System.out.print("Número do Fornecedor: ");
		int numFornecedor = scanner.nextInt();
		System.out.print("Número do Projeto: ");
		int numProjeto = scanner.nextInt();
		scanner.nextLine(); 

		fornecedor_projeto fornecedorProjeto = new fornecedor_projeto();
		fornecedorProjeto.setNumFornecedor(numFornecedor);
		fornecedorProjeto.setNumProjeto(numProjeto);

		new fornecedor_projetoDAO().cadastrarFornecedor_projeto(fornecedorProjeto);
		System.out.println("Fornecedor para Projeto cadastrado com sucesso!");
	}

}