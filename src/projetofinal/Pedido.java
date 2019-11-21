/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author sothis
 */
public class Pedido {
    private final long numero;
    private Date data;
    private HashSet<ItemPedido> itens = new HashSet(50);
    private Cliente cliente;

    public Pedido(long numero, Date data, Cliente cliente) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
    }

    public Pedido(long numero, Cliente cliente) {
        this.numero = numero;
        this.data = new Date(System.currentTimeMillis());
        this.cliente = cliente;
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

    public HashSet<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(HashSet<ItemPedido> itens) {
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
}
