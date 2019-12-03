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
public class ProdutoMercadoInterno extends Produto {
    private boolean incentivo;

    public ProdutoMercadoInterno(int codigo, String nome, Categoria categoria, double preco, String moeda, double imposto, boolean incentivo) {
        super(codigo, nome, categoria, preco, moeda, imposto);
        this.incentivo = incentivo;
    }

    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }
   
}
