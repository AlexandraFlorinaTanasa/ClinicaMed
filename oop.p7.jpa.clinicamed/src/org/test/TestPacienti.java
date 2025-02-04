package org.test;

import java.util.ArrayList;
import java.util.List;

import org.entity.Pacienti;

public class TestPacienti {
	public static void main(String[] args) {
	List<Pacienti> pacienti = new ArrayList<Pacienti>();

	pacienti.add(new Pacienti(10, "Paun Andrei", 24, "M", "Vaslui"));
	pacienti.add(new Pacienti(11, "Buche Despina", 22, "F", "Botosani"));
	pacienti.add(new Pacienti(12, "Matcu Mara", 15, "F", "Iasi"));
	pacienti.add(new Pacienti(13, "Sava Valentina", 34, "Roman", "Iasi"));
	pacienti.add(new Pacienti(14, "Moisei Marius", 71, "M", "Galati"));
	pacienti.add(new Pacienti(15, "Condrea Bogdana", 90, "F", "Iasi"));
	pacienti.add(new Pacienti(16, "Andrei Andrei", 38, "M", "Botosani"));
	pacienti.add(new Pacienti(17, "Paverin Raisa", 29, "F", "Suceava"));
	pacienti.add(new Pacienti(18, "Armandin Manuel", 30, "M", "Dorohoi"));
	pacienti.add(new Pacienti(19, "Apostol Lucia", 20, "F", "Iasi"));
	pacienti.add(new Pacienti(20, "Budai Lucian", 69, "M", "Hirlau"));
	pacienti.add(new Pacienti(21, "Tofin Mirabela", 55, "F", "Bacau"));
	pacienti.add(new Pacienti(22, "Birsan Ionela", 61, "F", "Chisinau"));
	pacienti.add(new Pacienti(23, "Hrehoret Ivan", 28, "M", "Flamanzi"));
	pacienti.add(new Pacienti(24, "Maftei Carmen", 47, "F", "Iasi"));
	pacienti.add(new Pacienti(25, "Istrate Cameliu", 14, "M", "Iasi"));

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaMed");
	EntityManager em = emf.createEntityManager();

	// Clean-up
	em.getTransaction().begin();
	em.createQuery("Delete From Pacienti p").executeUpdate();
	em.getTransaction().commit();

	// Create
	em.persist(pacienti.get(0));
	em.persist(pacienti.get(1));
	em.persist(pacienti.get(2));
	em.persist(pacienti.get(3));
	em.persist(pacienti.get(4));
	em.persist(pacienti.get(5));
	em.persist(pacienti.get(6));
	em.persist(pacienti.get(7));
	em.persist(pacienti.get(8));
	em.persist(pacienti.get(9));
	em.persist(pacienti.get(10));
	em.persist(pacienti.get(11));
	em.persist(pacienti.get(12));
	em.persist(pacienti.get(13));
	em.persist(pacienti.get(14));
	em.persist(pacienti.get(15));
	em.getTransaction().begin();
	em.getTransaction().commit();
	em.clear();

	// Read after create
	List<Pacienti> PacientiPersitenti = em.createQuery("Select p From Pacienti p", Pacienti.class).getResultList();

	System.out.println("Lista pacienti persitenti/salvati in baza de date");
	for (Pacienti p : PacientiPersitenti)
		System.out.println("IdPacient: " + p.getId() + ", nume: " + p.getNume() + ", varsta: " + p.getVarsta()
				+ ", gen: " + p.getGen() + ", localitate: " + p.getLocalitate());

	// Update/Remove
	em.getTransaction().begin();
	Pacienti c10 = em.find(Pacienti.class, 10);
	if (c10 != null) {
		c10.setNume("Ungureanu Marian");
		c10.setVarsta(26);
		c10.setGen("M");
		c10.setLocalitate("Iasi");
	}
	// Read/Remove

	Pacienti c21 = em.find(Pacienti.class, 21);
	if (c21 != null)
		em.remove(c21);

	// Realizare tranzactie
	em.getTransaction().commit();
	em.clear();

	PacientiPersitenti = em.createQuery("Select p From Pacienti p", Pacienti.class).getResultList();
	System.out.println("Lista finala pacienti persistenti (salvati in baza de date):");
	for (Pacienti p : PacientiPersitenti)
		System.out.println("IdPacient: " + p.getId() + ", nume: " + p.getNume() + ", varsta: "
				+ p.getVarsta() + ", gen: " + p.getGen() + ", localitate: " + p.getLocalitate());
}

}




