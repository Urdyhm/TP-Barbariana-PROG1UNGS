package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Commodore128kb {
	
	private int x, y;
	private int ancho;
	private int alto;
	private int angulo;
	Image img1;

	public Commodore128kb(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.ancho=100;
		this.alto=100;
		this.angulo=0;
		img1 = Herramientas.cargarImagen("com128.png");
	}
	

	
	public void dibujarse(Entorno entorno) 
	{
		entorno.dibujarImagen(img1, this.x, this.y, this.angulo );
		
	}

	public int getAncho() 
	{
		return this.ancho;
	}


	public int getAlto() 
	{
		return this.alto;	
	}
	
	
	public int getX() 
	{
		return this.x;
	}


	public int getY() 
	{
		return this.y;	
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

}
