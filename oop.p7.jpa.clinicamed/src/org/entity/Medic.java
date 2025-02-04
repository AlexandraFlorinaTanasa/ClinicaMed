package org.entity;

import java.util.Objects;

public class Medic {
	private Integer id;
	private String nume;
	private Pacienti pacienti;
	private String specializare;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public Pacienti getPacienti() {
		return pacienti;
	}
	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}
	public String getSpecializare() {
		return specializare;
	}
	public void setSpecializare(String specializare) {
		this.specializare = specializare;
	}
	public Medic(Integer id, String nume, Pacienti pacienti, String specializare) {
		super();
		this.id = id;
		this.nume = nume;
		this.pacienti = pacienti;
		this.specializare = specializare;
	}
	public Medic() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nume, pacienti, specializare);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medic other = (Medic) obj;
		return Objects.equals(id, other.id) && Objects.equals(nume, other.nume)
				&& Objects.equals(pacienti, other.pacienti) && Objects.equals(specializare, other.specializare);
	}
	@Override
	public String toString() {
		return "Medici [id=" + id + ", nume=" + nume + ", pacienti=" + pacienti + ", specializare=" + specializare
				+ "]";
	}
	
}