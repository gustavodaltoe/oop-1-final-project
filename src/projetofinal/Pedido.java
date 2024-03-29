/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sothis
 */
public class Pedido {
    private final long numero;
    private Date data;
    private ArrayList<ItemPedido> itens = new ArrayList(50);
    private Cliente cliente; 
   private int status;

    public Pedido(long numero, Date data, Cliente cliente, int status) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.status = status;
    }

    public Pedido(long numero, Cliente cliente) {
        this.numero = numero;
        this.data = new Date(System.currentTimeMillis());
        this.cliente = cliente;
        this.status = 0;
    }

    public long getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void addItem(ItemPedido item) {
        this.itens.add(item);
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    public double totalPedido() {
        double result = 0;
        for(ItemPedido i : itens) {
            result += i.totalItem();
        }
        return result;
    }
    
    // TODO
    public double totalImposto() {
        return 0;
    }

    @Override
    public String toString() {
        String strItens = "";
        for (ItemPedido i : itens) {
            strItens += "\n\t" + i.getProduto().getNome()
                    + "\t" + i.getQuantidade();
        }
        String strStatus;
        switch(status) {
            case 1: 
                strStatus = "Finalizado";
                break;
            default:
                strStatus = "Aberto";
                break;
        }
        return "\n---- Pedido " + numero + " ----\n\n"
                + "Cliente: " + cliente.getNome()
                + "Itens: {" + strItens
                + "}"
                + "Total Impostos: R$ " + totalImposto()
                + "Total Pedido: R$ " + totalPedido()
                + "data: " + data.toString()
                + "status: " + strStatus;
    }
    
}
