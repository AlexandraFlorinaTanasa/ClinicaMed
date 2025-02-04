package org.entity;

import java.util.Objects;

public class Pacienti {
	private Integer id;
	private String nume;
	private Integer varsta;
	private String gen;
	private String localitate;
	
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
	public Integer getVarsta() {
		return varsta;
	}
	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getLocalitate() {
		return localitate;
	}
	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}
	public Pacienti(Integer id, String nume, Integer varsta, String gen, String localitate) {
		super();
		this.id = id;
		this.nume = nume;
		this.varsta = varsta;
		this.gen = gen;
		this.localitate = localitate;
	}
	public Pacienti() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(gen, id, localitate, nume, varsta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacienti other = (Pacienti) obj;
		return Objects.equals(gen, other.gen) && Objects.equals(id, other.id)
				&& Objects.equals(localitate, other.localitate) && Objects.equals(nume, other.nume)
				&& Objects.equals(varsta, other.varsta);
	}
	@Override
	public String toString() {
		return "Pacienti [id=" + id + ", nume=" + nume + ", varsta=" + varsta + ", gen=" + gen + ", localitate="
				+ localitate + "]";
	}
	
	
	
}


