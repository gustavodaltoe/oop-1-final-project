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
public class ProdutoMercadoInterno {
    private boolean incentivo;

    public ProdutoMercadoInterno(boolean incentivo) {
        this.incentivo = incentivo;
    }

    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }
   
}
