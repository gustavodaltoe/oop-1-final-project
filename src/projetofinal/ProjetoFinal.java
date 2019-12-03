/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

import java.io.Console;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author sothis
 */
public class ProjetoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op, subOp;
        
        HashMap<Integer, Cliente> clientes = new HashMap(100);
        HashMap<Integer, Pedido> pedidos = new HashMap(100);
        HashMap<Integer, Produto> produtos = new HashMap(100);
        HashMap<Integer, Categoria> categorias = new HashMap(50);
        
        clientes.put(1, new Cliente(1, "teste", "av teste", "111111", 200));
        categorias.put(1, new Categoria(1, "categoria teste"));
        produtos.put(1, new Produto(1, "prod teste", categorias.get(1), 50, "R$", 5));
        
        do
        {
            printMenu();
            op = Integer.parseInt(sc.next());
            switch(op) {
                case 1:
                    printManutencao();
                    subOp = Integer.parseInt(sc.next());
                    switch(subOp) {
                        case 1:
                            printCrud("clientes");
                            subOp = Integer.parseInt(sc.next());
                            manutClientes(clientes, subOp);
                            break;
                        case 2:
                            printCrud("produtos");
                            subOp = Integer.parseInt(sc.next());
                            manutProdutos(produtos, categorias, subOp);
                            break;
                        case 3:
                            printCrud("categoria");
                            subOp = Integer.parseInt(sc.next());
                            manutCategorias(categorias, subOp);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:

                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    System.exit(0);
            }
        } while (op != 5);
    }
    
    public static void printMenu() {
        System.out.println("\n[1] Manutenção");
        System.out.println("[2] Criar pedidos para um cliente");
        System.out.println("[3] Listar pedidos de um cliente");
        System.out.println("[4] Dar baixa em um pedido");
        System.out.println("[5] Sair");
        System.out.print("Opção: ");
    }
    
    public static void printManutencao() {
        System.out.println("\n---- Manutenção ---- \n");
        System.out.println("[1] Cliente");
        System.out.println("[2] Produto");
        System.out.println("[3] Categoria");
        System.out.println("[4] Voltar");
        System.out.print("Opção: ");
    }
    
    public static void printCrud(String op) {
        System.out.println("\n---- Manutenção de " + op + " ---- \n");
        System.out.println("[1] Criar");
        System.out.println("[2] Remover");
        System.out.println("[3] Alterar");
        System.out.println("[4] Pesquisar");
        System.out.println("[5] Listar");
        System.out.println("[6] Cancelar");
        System.out.print("Opção: ");
    }
    
    public static void manutClientes(HashMap<Integer, Cliente> clientes, int op) {
        int cod;
        String nome, endereco, telefone, lim;
        double limite;
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        switch(op) {
            case 1:
                System.out.println("\n ---- Cadastro de Cliente ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (clientes.containsKey(cod)) {
                    System.out.println("Erro: Já existe um cliente com este código.");
                    break;
                }
                System.out.print("Nome: ");
                nome = sc.next();
                System.out.print("Endereço: ");
                endereco = sc.next();
                System.out.print("Telefone: ");
                telefone = sc.next();
                System.out.print("Limite: ");
                lim = sc.next();
                limite = 0;
                if (!lim.isEmpty())
                    limite = Double.parseDouble(lim);
                Cliente cliente = new Cliente(cod, nome, endereco, telefone, limite);
                clientes.put(cod, cliente);
                
                System.out.println("Cliente cadastrado com sucesso.");
                break;
            case 2:
                System.out.println("\n ---- Remoção de Cliente ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!clientes.containsKey(cod)) {
                    System.out.println("Erro: Cliente não encontrado.");
                    break;
                }
                
                cliente = clientes.get(cod);
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Tem certeza que deseja remover o cliente? <S/N>");
                char sn = sc.next().charAt(0);
                
                if (sn == 's' || sn == 'S') {
                    clientes.remove(cod);
                    System.out.println("Cliente removido com sucesso.");
                    break;
                }
                
                System.out.println("Operação cancelada.");
                break;
            case 3:
                System.out.println("\n ---- Alteração de Cliente ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!clientes.containsKey(cod)) {
                    System.out.println("Erro: Cliente não encontrado.");
                    break;
                }
                cliente = clientes.get(cod);
                System.out.println(cliente.toString());
                System.out.println("Mantenha em branco para manter os valores atuais.\n");
                System.out.print("Nome: ");
                nome = sc.next();
                System.out.print("Endereço: ");
                endereco = sc.next();
                System.out.print("Telefone: ");
                telefone = sc.next();
                System.out.print("Limite: ");
                limite = Double.parseDouble(sc.next());
                
                if(!nome.isEmpty())
                    cliente.setNome(nome);
                if(!endereco.isEmpty())
                    cliente.setEndereco(endereco);
                if(!telefone.isEmpty())
                    cliente.setTelefone(telefone);
                if(limite > 0)
                    cliente.setLimite(limite);
                
                System.out.println("Cliente alterado com sucesso.\n");
                System.out.println(cliente.toString());
                break;
            case 4:
                System.out.println("\n ---- Pesquisar cliente ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!clientes.containsKey(cod)) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }
                cliente = clientes.get(cod);
                System.out.println(cliente.toString());
                break;
            case 5:
                System.out.println("\n ---- Listar clientes ---- \n");
                if(clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado.");
                    break;
                }
                clientes.forEach((k, v) -> 
                    System.out.println("Código: " + k + "\tNome: " + v.getNome())
                );
                break;
            default:
                break;
                
        }
    }
    
    public static void manutProdutos(HashMap<Integer, Produto> produtos, HashMap<Integer, Categoria> categorias, int op) {
        int cod, codCategoria;
        Categoria cat;
        String nome, moeda;
        double imposto, preco;
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        switch(op) {
            case 1:
                System.out.println("\n ---- Cadastro de Produto ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (produtos.containsKey(cod)) {
                    System.out.println("Erro: Já existe um produto com este código.");
                    break;
                }
                System.out.print("Categoria: ");
                codCategoria = Integer.parseInt(sc.next());
                if (!categorias.containsKey(codCategoria)) {
                    System.out.println("Erro: Categoria não encontrada");
                    break;
                }
                cat = categorias.get(codCategoria);
                System.out.print("Nome: ");
                nome = sc.next();
                System.out.print("Preço: ");
                preco = Double.parseDouble(sc.next());
                System.out.print("Moeda: ");
                moeda = sc.next();
                System.out.print("Imposto: ");
                imposto = Double.parseDouble(sc.next());
                
                Produto prod = new Produto(cod, nome, cat, preco, moeda, imposto);
                produtos.put(cod, prod);
                
                System.out.println("Produto cadastrado com sucesso.");
                break;
            case 2:
                System.out.println("\n ---- Remoção de Produto ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!produtos.containsKey(cod)) {
                    System.out.println("Erro: Produto não encontrado.");
                    break;
                }
                
                prod = produtos.get(cod);
                System.out.println("Nome: " + prod.getNome());
                System.out.println("Tem certeza que deseja remover o Produto? <S/N>");
                char sn = sc.next().charAt(0);
                
                if (sn == 's' || sn == 'S') {
                    produtos.remove(cod);
                    System.out.println("Produto removido com sucesso.");
                    break;
                }
                
                System.out.println("Operação cancelada.");
                break;
            case 3:
                System.out.println("\n ---- Alteração de Produto ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!produtos.containsKey(cod)) {
                    System.out.println("Erro: Produto não encontrado.");
                    break;
                }
                prod = produtos.get(cod);
                System.out.println(prod.toString());
                System.out.println("Mantenha em branco para manter os valores atuais.\n");
                System.out.print("Nome: ");
                nome = sc.next();
                System.out.print("Categoria: ");
                codCategoria = Integer.parseInt(sc.next());
                if (!categorias.containsKey(codCategoria)) {
                    System.out.println("Erro: Categoria não encontrada");
                    break;
                }
                cat = categorias.get(codCategoria);
                System.out.print("Preço: ");
                preco = Double.parseDouble(sc.next());
                System.out.print("Moeda: ");
                moeda = sc.next();
                System.out.print("Imposto: ");
                imposto = Double.parseDouble(sc.next());
                
                if(!nome.isEmpty())
                    prod.setNome(nome);
                prod.setCategoria(cat);
                if(preco != 0)
                    prod.setPreco(preco);
                if(!moeda.isEmpty())
                    prod.setMoeda(moeda);
                if(imposto != 0)
                    prod.setPreco(imposto);
                
                System.out.println("Produto alterado com sucesso.\n");
                System.out.println(prod.toString());
                break;
            case 4:
                System.out.println("\n ---- Pesquisar produto ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!produtos.containsKey(cod)) {
                    System.out.println("Produto não encontrado.");
                    break;
                }
                prod = produtos.get(cod);
                System.out.println(prod.toString());
                break;
            case 5:
                System.out.println("\n ---- Listar Produtos ---- \n");
                if(produtos.isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                    break;
                }
                produtos.forEach((k, v) ->
                    System.out.println("Código: " + k + "\tNome: " + v.getNome()
                        + "\tPreço: " + v.getMoeda() + " " + v.getPreco())
                );
                break;
            default:
                break;
        }
    }
    
    public static void manutCategorias(HashMap<Integer, Categoria> categorias, int op) {
        int cod;
        String nome;
        Categoria cat;
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        switch(op) {
            case 1:
                System.out.println("\n ---- Cadastro de Categoria ---- \n");
                System.out.print("Código:");
                cod = Integer.parseInt(sc.next());
                if (categorias.containsKey(cod)) {
                    System.out.println("Erro: Já uma categoria com este codigo.");
                    break;
                }
                System.out.print("Descrição:");
                nome = sc.next();
                
                cat = new Categoria(cod, nome);
                categorias.put(cod, cat);
                
                System.out.println("Categoria cadastrada com sucesso.");
                break;
            case 2:
                System.out.println("\n ---- Remoção de Categoria ---- \n");
                System.out.print("Código:");
                cod = Integer.parseInt(sc.next());
                if (!categorias.containsKey(cod)) {
                    System.out.println("Erro: Categoria não encontrado.");
                    break;
                }
                cat = categorias.get(cod);
                System.out.println("Descrição: " + cat.getDescricao());
                
                System.out.println("Tem certeza que deseja remover a categoria? <S/N>");
                char sn = sc.next().charAt(0);
                
                if (sn == 's' || sn == 'S') {
                    categorias.remove(cod);
                    System.out.println("Categoria removida com sucesso.");
                    break;
                }
                
                System.out.println("Operação cancelada.");
                break;
            case 3:
                System.out.println("\n ---- Alteração de Categoria ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!categorias.containsKey(cod)) {
                    System.out.println("Erro: Categoria não encontrada.");
                    break;
                }
                cat = categorias.get(cod);
                System.out.println(cat.toString());
                System.out.print("Descrição: ");
                nome = sc.next();
                
                if(!nome.isEmpty())
                    cat.setDescricao(nome);
                
                System.out.println("Categoria alterada com sucesso.\n");
                System.out.println(cat.toString());
                break;
            case 4:
                System.out.println("\n ---- Pesquisar categoria ---- \n");
                System.out.print("Código: ");
                cod = Integer.parseInt(sc.next());
                if (!categorias.containsKey(cod)) {
                    System.out.println("Categoria não encontrada.");
                    break;
                }
                cat = categorias.get(cod);
                System.out.println(cat.toString());
                break;
            case 5:
                System.out.println("\n ---- Listar Categorias ---- \n");
                if(categorias.isEmpty()) {
                    System.out.println("Nenhuma categoria cadastrada.");
                    break;
                }
                categorias.forEach((k, v) ->
                    System.out.println(v.toString())
                );
                break;
            default:
                break;
        }
    }
    
}
