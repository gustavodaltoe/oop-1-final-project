/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

import java.util.ArrayList;

/**
 *
 * @author sothis
 */
public class Cliente {
    private final int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private double limite;
    private ArrayList<Pedido> pedidos = new ArrayList(100);

    public Cliente(int codigo, String nome, String endereco, String telefone, double limite) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.limite = limite;
    }

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Cliente: " + 
                "\n\tCódigo: " + codigo + 
                "\n\tNome: " + nome + 
                "\n\tEndereço: " + endereco + 
                "\n\tTelefone: " + telefone + 
                "\n\tLimite: " + limite;
    }
    
    
    
}
