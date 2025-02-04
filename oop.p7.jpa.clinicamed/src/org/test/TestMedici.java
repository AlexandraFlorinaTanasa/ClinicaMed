package org.test;

import org.entity.Medic;
import org.entity.Pacienti;

public class TestMedici {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			
			Pacienti p1 = new Pacienti(10,  "Paun Andrei", 24, "M", "Vaslui");
			Pacienti p2 = new Pacienti(11, "Buche Despina", 22, "F", "Botosani");
			Pacienti p3 = new Pacienti(12, "Matcu Mara", 15, "F", "Iasi");
			
	        
			Medic m1 = new Medic(81,"Istrateanu Camelia",p1,"Dermatologie");
			Medic m2 = new Medic(82,"Nastasiu Anastasia",p2,"Oftalmologie");
			Medic m3 = new Medic(83,"Baltatescu Monica",p3,"Ortopedie");

			
			System.out.println("Medicul  cu numele " + m1.getNume() + " are pacientul " + p1.getNume());
			System.out.println("Medicul  cu numele " + m2.getNume() + " are pacientul " + p2.getNume());
			System.out.println("Medicul  cu numele " + m3.getNume() + " are pacientul " + p3.getNume());
			
		}
	

}
