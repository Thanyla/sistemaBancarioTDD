package com.sistemabancario.model;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Manoel Campos da Silva Filho
 */
public class MovimentacaoTest {
    public static void main(String[] args) {
     MovimentacaoTest movimentacaoTest = new MovimentacaoTest();
     
     movimentacaoTest.instanciarMovimentacaoComoNaoConfirmada();
     movimentacaoTest.setTipoCreditoMaisculo();
    }
    
    @Before
    public void setUp(){
        //instancia.setValor(10);
    }
    
    private Movimentacao instancia = new Movimentacao();
    
    @Test
    public void setValorNegativo() {
        final double invalido = -100;
        try{
        instancia.setValor(invalido);
        }catch(IllegalArgumentException i){}
        final double obtido = instancia.getValor();
        assertNotEquals(invalido, obtido, 0.0001);
    }
    
    @Test
    public void setValorPositivo() {
        final double esperado = 100;
        instancia.setValor(esperado);
        final double obtido = instancia.getValor();
        assertEquals(esperado, obtido, 0.0001);
    }
    
    @Test
    public void setTipoCreditoMaisculo() {
        final char esperado = 'C';
        instancia.setTipo(esperado);
        final char obtido = instancia.getTipo();
        assertEquals(esperado, obtido);
        instancia.setConfirmada(true);
    }
    
    @Test
    public void setTipoCreditoMinusculo() {
        final char esperado = 'c';
        //final char esperado = 'C';
        instancia.setTipo(esperado);
        //instancia.setTipo('c');
        final char obtido = instancia.getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void setTipoInvalido() {
        final char invalido = 'X';
        try {
            instancia.setTipo(invalido);
        }catch(IllegalArgumentException e){}
        final char obtido = instancia.getTipo();
        assertNotEquals(invalido, obtido); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setTipoInvalidoExcecao() {
        final char invalido = 'X';
        instancia.setTipo(invalido);
    }
    
    @Test
    public void instanciarMovimentacaoComoNaoConfirmada() {
        assertFalse(instancia.isConfirmada());
    }
}