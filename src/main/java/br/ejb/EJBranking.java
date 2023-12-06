
package br.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author daniel
 *
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "java/Fila"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})
public class EJBranking implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage tm = (TextMessage) msg;
            System.out.println(tm.getText());
        } catch (Exception e) {
        }
    }
}
