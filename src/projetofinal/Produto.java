/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

/**
 *
 * @author sothis
 */
public class Produto {
    private final int codigo;
    private String nome;
    private Categoria categoria;
    private double preco;
    private String moeda;
    private double imposto;

    public Produto(int codigo, String nome, Categoria categoria, double preco, String moeda, double imposto) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.moeda = moeda;
        this.imposto = imposto;
    }

    public Produto(int codigo, String nome, double preco, double imposto) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.moeda = "R$";
        this.imposto = imposto;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    @Override
    public String toString() {
        return "\n --- Produto ---"
                + "\nCódigo: " + codigo
                + "\nNome: " + nome
                + "\nCategoria: " + categoria.getDescricao()
                + "\nPreço: " + moeda + " " + preco
                + "\nImposto: " + imposto + "\n---------------\n";
    }
    
    
    
}
