package main;

import org.springframework.context.*;
import org.springframework.context.support.*;

import daosImpl.*;
import modelo.Sombrero;

public class Main {

	public static void main(String[] args) {
//		Vamos a crear un contenedor de spring para meterle y pedirle objetos
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Sombrero s = new Sombrero("sombrero creado con spring jdbc", "d", 10);
		/**
		 * vamos a hacer un registro con spring jdbc: indicamos unicamente la clase al
		 * metodo getBean estamos pidiendo al contenedor de sprinq que no de el unico
		 * objeto que debe tener de dicha clase
		 */
		SombrerosDAOImpl dao = context.getBean(SombrerosDAOImpl.class);
		dao.registrarSombrero(s);
		System.out.println("registro hecho");

	}
}
