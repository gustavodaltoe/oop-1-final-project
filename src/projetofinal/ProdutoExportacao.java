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
public class ProdutoExportacao extends Produto {
    private String destino;

    public ProdutoExportacao(int codigo, String nome, Categoria categoria, double preco, String moeda, double imposto, String destino) {
        super(codigo, nome, categoria, preco, moeda, imposto);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
}
