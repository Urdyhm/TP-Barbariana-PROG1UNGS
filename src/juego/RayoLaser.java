package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class RayoLaser {
	
	private int x, y;
	private int ancho;
	private int alto;
	private int angulo;
	private int direccion;
	Image img1;


	public RayoLaser(int x, int y, int d) 
	{
		this.x = x;
		this.y = y;
		this.ancho=50;
		this.alto=50;
		this.angulo=0;
		this.direccion=1;
		img1 = Herramientas.cargarImagen("rayoL.png");
	}
	

	
	public void mover() 
	{
		this.x += 2 * direccion;
	}

	public void disparar(Entorno entorno) 
	{
		entorno.dibujarImagen(img1, this.x, this.y, this.angulo );
		
	}

	public int getX() 
	{
		return this.x;
	}


	public int getY() 
	{
		return this.y;	
	}
	
	public double getAncho() {
		return ancho;
	}

	public double getAlto() {
		return alto;
	}
	
	public boolean colisionaCon(Barbarianna v) 
	{
		if ( v.getY() + v.getAlto()/2  >= this.y - this.alto/2   && v.getY() - v.getAlto()/2 <= this.y + this.alto/2  &&
				v.getX()   >= this.x - this.ancho/2  && v.getX()<= this.x + this.ancho/2  )
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
