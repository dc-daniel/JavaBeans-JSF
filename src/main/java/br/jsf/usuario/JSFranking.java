/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf.usuario;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author danie
 */
@Named(value = "jSFranking")
@RequestScoped
public class JSFranking {

    
    public JSFranking() {
    }

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java/Fila")
    private Queue fila;

   
    public void send(String ranking) {
        try {
            JMSContext context = connectionFactory.createContext();
            Destination destination = (Destination) fila;
            context.createProducer().send(destination, ranking);

        } catch (Exception e) {
            System.out.println("ERRO NO ENVIO DE DADOS" + e.getMessage());
        }
    }
    
    
    
}
