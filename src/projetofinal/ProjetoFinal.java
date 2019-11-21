/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

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
        int op;
        
        HashSet<Cliente> clientes = new HashSet(100);
        HashSet<Pedido> pedidos = new HashSet(100);
        HashSet<Produto> produtos = new HashSet(100);
        HashSet<Categoria> categorias = new HashSet(50);
        
        do
        {
            printMenu();
            op = Integer.parseInt(sc.next());
            switch(op) {
                case 1:
                    printManutencao();
                    op = Integer.parseInt(sc.next());
                    switch(op) {
                        case 1:
                            printCrud("clientes");
                            op = Integer.parseInt(sc.next());
                            manutClientes(clientes, op);
                            break;
                        case 2:
                            printCrud("produtos");
                            break;
                        case 3:
                            printCrud("categoria");
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
        System.out.println("[1] Manutenção");
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
    
    public static void manutClientes(HashSet<Cliente> clientes, int op) {
        switch(op) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            default:
                break;
                
        }
    }
    
    public static void manutProdutos(HashSet<Produto> produtos, int op) {
    
    }
    
    public static void manutCategorias(HashSet<Categoria> categorias, int op) {
        
    }
}
