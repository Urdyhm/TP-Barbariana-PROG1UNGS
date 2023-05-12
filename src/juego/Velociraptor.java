package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Velociraptor {
	
	
	private int x, y;
	private int ancho;
	private int alto;
	private int angulo;
	private int direccion;
	private double velocidad;
	Image img1;
	Image img2;

	public Velociraptor(int x, int y, int d) 
	{
		this.x = x;
		this.y = y;
		this.ancho=50;
		this.alto=70;
		this.angulo=0;
		this.velocidad=1;
		this.setDireccion(d);
		img1 = Herramientas.cargarImagen("veloc.png");
		img2 = Herramientas.cargarImagen("velocd.png");
	}
	
	
	public void caida() {
		this.y += 2;
	}
	
	
	public void moverLados(Entorno entorno) 
	{
		this.x += velocidad * direccion;
		
	    if (this.x + this.ancho / 2 > entorno.ancho()-15) { 
	            this.direccion=-1;
	        }
	    if (this.x - this.ancho / 2 < 15) { 
	           this.direccion=1;
	        }
	}

	
	public int getX() 
	{
		return this.x;
	}


	public int getY() 
	{
		return this.y;	
	}

	public int getAncho() 
	{
		return this.ancho;
	}


	public int getAlto() 
	{
		return this.alto;	
	}
	
	public void derecha(Entorno entorno) {
		
		entorno.dibujarImagen(img2,this.x, this.y, this.angulo);
		
	}
	
	public void izquierda(Entorno entorno) 
	{
	entorno.dibujarImagen(img1, this.x, this.y, this.angulo );
	
	}

	public boolean colisionaCon( Barbarianna b) 
	{
		if ( b.getY() >= this.y - this.alto/2 - 50  && b.getY()  <= this.y + this.alto/2 + 50  &&
			b.getX() >= this.x - this.ancho/2  && b.getX()  <= this.x + this.ancho/2 )
		{
			return true;
		}
		
		return false;		
	}

	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	
}
