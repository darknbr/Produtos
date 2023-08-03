import db.EstoquesDB;
import db.ProdutosDB;
import db.UsuariosDB;
import models.Admin;
import models.Cliente;
import models.Estoque;
import models.Produto;
import models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ProdutosDB produtosDB = new ProdutosDB();
    static UsuariosDB usuariosDB = new UsuariosDB();
    static EstoquesDB estoquesDB = new EstoquesDB();
    public static void main(String[] args) throws Exception {
        System.out.println("---PEDIDO DE VENDAS ---");

        int option;

        do {
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos cadastrados");
            System.out.println("3 - Cadastar usuário ADMINISTRADOR");
            System.out.println("4 - Cadastar usuário CLIENTE");
            System.out.println("5 - Listar todos os usuários cadastrados");
            System.out.println("6 - Cadastrar novo estoque de produtos");
            System.out.println("7 - Listar estoque de produtos");
            System.out.println("0 - Sair");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Qual operação deseja realizar: ");

            option = scanner.nextInt();
          
            process(option);

        } while (option != 0);
    }   

    public static void process(int option) throws Exception {
        switch (option) {
            case 1: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Qual a descrição que você deseja dar ao novo produto: ");
                String descricao = scanner.nextLine();

                System.out.print("Qual o ID que deseja dar ao produto: ");
                int id = scanner.nextInt();

                System.out.print("Qual o preço: ");
                double preco = scanner.nextDouble();

                System.out.print("Qual a data de validade: ");
                String dataString = scanner.next();
                Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

                Produto novoProduto = new Produto(id, descricao, preco, dataValidade);

                produtosDB.addNovoProduto((novoProduto));

                break;
            }

            case 2: {
                List<Produto> listaDeProdutos = produtosDB.getProdutoList();

                for (Produto produto : listaDeProdutos) {
                    System.out.println("--- ID: " + produto.getId());
                    System.out.println("--- Descrição: " + produto.getDescricao());
                    System.out.println("--- Preço: " + produto.getPreco());
                    System.out.println("--- Data de validade: " + produto.getDataValidade());
                    System.out.println("-------------------------------------------------");
                }
                break;

            }

            case 3: {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Qual o nome do usuário ADMINISTRADOR: ");
                String nome = scanner.nextLine();
                Admin novoAdmin = new Admin(nome);
                usuariosDB.addNovoUsuario(novoAdmin);

                break;
            }

            case 4: {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Qual o nome do usuário Cliente: ");
                String nome = scanner.nextLine();
                Cliente novoCliente = new Cliente(nome);
                usuariosDB.addNovoUsuario(novoCliente);
          
                break;
            }

            case 5: {
                System.out.println("------------------------------------");
                System.out.println("-----LISTANDO USUÁRIOS CADASTRADOS -----");
                for(Usuario usuario : usuariosDB.getUsuarioList()){
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("NOME: " + usuario.getNome());
                    System.out.println("TIPO: " + usuario.getTipoUsuario());
                    System.out.println("------------------------------------");
                }
                break;
            }

            case 6: {
                Scanner sc = new Scanner(System.in);
                System.out.println("------------------------------------");
                System.out.println("-----CADASTRANDO ESTOQUE DE PRDUTOS -----");
                System.out.println("Qual o identificador do estoque?");
                String id = sc.next();
                System.out.println("Qual o produto que será adicionado ao estoque (informe o ID): ");
                int produtoId = sc.nextInt();
                Produto  produto = produtosDB.getProdutoPorID(produtoId);
                System.out.println("PRODUTO ID:  "+ produto.getId());
                System.out.println("PRODUTO DESCRIÇÃO: "+ produto.getDescricao());
                System.out.println("PRODUTO VALIDADE: "+ produto.getDataValidade());
                System.out.println("Qual a quantidade de produtos a ser adicionada no estoque: ");
                int quantidade = sc.nextInt();
                Estoque novoEstoque = new Estoque(id, produto, quantidade);
                estoquesDB.addNovoEstoque(novoEstoque);

                break;
            }

            case 7: {
                System.out.println("------------------------------------");
                System.out.println("-----LISTANDO ESTOQUES CADASTRADOS -----");
                for(Estoque estoque : estoquesDB.getEstoques()){
                    System.out.println("ID: " + estoque.getId());
                    System.out.println("PRODUTO: " + estoque.getProduto().getDescricao());
                    System.out.println("PREÇO: " + estoque.getProduto().getPreco());
                    System.out.println("QUANTIDADE: " + estoque.getQuantidade());
                    System.out.println("------------------------------------"); 
                }

                break;
            }
        }      
    }    
}