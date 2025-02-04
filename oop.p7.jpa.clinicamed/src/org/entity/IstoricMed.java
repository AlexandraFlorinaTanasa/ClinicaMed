package org.entity;

import java.util.Objects;

public class IstoricMed {
  private Integer idIstoricMed;
	Pacienti pacient;
    Medic medic;
    
	public Integer getIdIstoricMed() {
		return idIstoricMed;
	}
	public void setIdIstoricMed(Integer idIstoricMed) {
		this.idIstoricMed = idIstoricMed;
	}
	public Pacienti getPacient() {
		return pacient;
	}
	public void setPacient(Pacienti pacient) {
		this.pacient = pacient;
	}
	public Medic getMedic() {
		return medic;
	}
	public void setMedic(Medic medic) {
		this.medic = medic;
	}
	public IstoricMed(Integer idIstoricMed, Pacienti pacient, Medic medic) {
		super();
		this.idIstoricMed = idIstoricMed;
		this.pacient = pacient;
		this.medic = medic;
	}
	public IstoricMed() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(idIstoricMed, medic, pacient);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IstoricMed other = (IstoricMed) obj;
		return Objects.equals(idIstoricMed, other.idIstoricMed) && Objects.equals(medic, other.medic)
				&& Objects.equals(pacient, other.pacient);
	}
	@Override
	public String toString() {
		return "IstoricMed [idIstoricMed=" + idIstoricMed + ", pacient=" + pacient + ", medic=" + medic + "]";
	}
}
