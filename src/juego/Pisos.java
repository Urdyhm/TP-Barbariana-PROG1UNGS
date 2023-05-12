package juego;

import java.awt.Color;

import entorno.Entorno;

public class Pisos {
	
		// Variables de instancia
		private int x, y;
		private int ancho;
		private int alto;

		public Pisos (int x, int y) 
		{
			this.x = x;
			this.y = y;
			this.ancho = 600;
			this.alto = 10;
		}


		public void dibujarse(Entorno entorno) 
		{
			entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.white);
			
		}

		public int getX() 
		{
			return this.x;
		}
		
		public int getY() 
		{
			return this.y;
		}


		public boolean colisionaBordesCon( Barbarianna b) 
		{
			if ( b.getY() == this.y - this.alto/2 - 30  && b.getY() == this.y + this.alto/2 + 30  
					&&
				b.getX() == this.x - this.ancho/2  && b.getX() == this.x + this.ancho/2 )
			{
				return true;
			}
			
			return false;			
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
		

		public boolean colisionaCon( Velociraptor b) 
		{
			if ( b.getY() >= this.y - this.alto/2 - 25  && b.getY()  <= this.y + this.alto/2 + 25  &&
				b.getX() >= this.x - this.ancho/2  && b.getX()  <= this.x + this.ancho/2 )
			{
				return true;
			}
			
			return false;		
		}
		
		public boolean colisionaArribaCon( Barbarianna b) 
		{
			if ( b.getY() >= this.y - this.alto/2 - 50  && b.getY()  <= this.y + this.alto/2  &&
				b.getX() >= this.x - this.ancho/2  && b.getX() <= this.x + this.ancho/2 )
			{
				return true;
			}
			
			return false;			
		}
		
		public boolean colisionaAbajoCon( Barbarianna b) 
		{
			if ( b.getY()  >= this.y - this.alto/2  && b.getY()  <= this.y + this.alto/2 + 50 &&
				b.getX() >= this.x - this.ancho/2  && b.getX()  <= this.x + this.ancho/2 )
			{
				return true;
			}
			
			return false;			
		}
		
}
