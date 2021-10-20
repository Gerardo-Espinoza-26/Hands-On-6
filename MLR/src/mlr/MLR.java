package mlr;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import javax.swing.JOptionPane;

public class MLR extends Agent {

    HelperArithmetic HA = new HelperArithmetic();
    
    boolean I = HA.DoMLR();
    
    double[][] producto = HA.getProducto();
    
    public void displayRegressioEquation(){
        
        System.out.println("Regression Equation B0 + B1x1 + B2x2");
        
    }//Fin public void displayRegressioEquation
    
    public double predict(){
        
        double x1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa El Valor De X1: "));
        double x2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa El Valor De X2: "));
        
        double predict = (producto[0][0] + (producto[1][0] * x1) + (producto[2][0] * x2));
        
        System.out.println("Predict: " + predict);
        
        return predict;
        
    }//Fin public float predict
    
    @Override
    protected void setup() {
      
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyOneShotBehaviour());
    
    }//Fin protected void setup 

    private class MyOneShotBehaviour extends OneShotBehaviour {

        @Override
        public void action() {
            
            MLR mlr = new MLR();
            
            mlr.displayRegressioEquation();
            mlr.predict();
            
        }//Fin public void action 

        @Override
        public int onEnd() {
            
            myAgent.doDelete();
            return super.onEnd();
    
        }//Fin public int onEnd 
    
    }//Fin private class MyCyclicBehaviour
  
}//Fin public class MLR