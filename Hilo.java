package javaapplication15;

import javax.swing.JOptionPane;

public class Hilo extends Thread //Nuestra clase es un hilo o proceso
{	//MIEBRO DE CLASE O ATRIBUTOS
	private int tiempoInactividad;

    public Hilo( String nombre ) //CONSTRUCTOR
    {	super(nombre); 	//se asigna nombre al proceso
    	tiempoInactividad = (int)(Math.random()*5001);
        //tiempoInactividad =(int)6200; //ejemplo
    }   
    //Sobre-escritura método run()
    public void run()
    {	// COMO LA EJECUCIÓN ES CONTROLADA Y DESPACHADA POR 
    	// SISTEMA OPERATIVO, ES POSIBLE QUE HALLA ERROR
    	// POR LO TANTO SE MANEJA EL CAPTURADOR DE EXCEPCIONES 
    	// Y CONTROL DE ERRORES
    	try
    	{	System.err.println(getName() + " Estara inactivo "+ tiempoInactividad);
    		Thread.sleep( tiempoInactividad );
    		System.err.println(getName() + " Despertando y finalizando");
    	}
    	//EN CASO DE INTERRUPCION DEL PROCESO, SE CAPTURA EL ERROR
    	catch(InterruptedException excepcion)
    	{	excepcion.printStackTrace(); //Se imprime el error
    		JOptionPane.showMessageDialog(null,"Se interrumpió el proceso");
    	}
    }//FIN DEL RUN 
    //el metodo star lanza al estado listo el procesos es decir 
    //lo manda a la pila de ejecucion 
    public static void main (String[] args) 
    {	Hilo a,b,c,d;
    	a= new Hilo("proceso A");
    	b= new Hilo("proceso B");
    	c= new Hilo("proceso C");
    	d= new Hilo("proceso D");
    	
    	d.setPriority(10);
    	a.setPriority(Thread.MIN_PRIORITY);
    	
    	a.start();
    	b.start();
    	c.start();
    	d.start();
	} 
}//Fin de la clase Hilo