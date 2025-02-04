package org.entity;

import java.util.Objects;

public class Afectiuni extends IstoricMed {
private Integer codAfectiune; 
private String denAfectiune;
private String tipAfectiune;
public Integer getCodAfectiune() {
	return codAfectiune;
}
public void setCodAfectiune(Integer codAfectiune) {
	this.codAfectiune = codAfectiune;
}
public String getDenAfectiune() {
	return denAfectiune;
}
public void setDenAfectiune(String denAfectiune) {
	this.denAfectiune = denAfectiune;
}
public String getTipAfectiune() {
	return tipAfectiune;
}
public void setTipAfectiune(String tipAfectiune) {
	this.tipAfectiune = tipAfectiune;
}
public Afectiuni(Integer idIstoricMed, Pacienti pacient, Medic medic, Integer codAfectiune, String denAfectiune,
		String tipAfectiune) {
	super(idIstoricMed, pacient, medic);
	this.codAfectiune = codAfectiune;
	this.denAfectiune = denAfectiune;
	this.tipAfectiune = tipAfectiune;
}
public Afectiuni(Integer idIstoricMed, Pacienti pacient, Medic medic) {
	super(idIstoricMed, pacient, medic);
	
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(codAfectiune, denAfectiune, tipAfectiune);
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Afectiuni other = (Afectiuni) obj;
	return Objects.equals(codAfectiune, other.codAfectiune) && Objects.equals(denAfectiune, other.denAfectiune)
			&& Objects.equals(tipAfectiune, other.tipAfectiune);
}
@Override
public String toString() {
	return "Afectiuni [codAfectiune=" + codAfectiune + ", denAfectiune=" + denAfectiune + ", tipAfectiune="
			+ tipAfectiune + "]";
}
public Afectiuni() {
	super();
}
public Afectiuni(Integer codAfectiune, String denAfectiune, String tipAfectiune) {
	super();
	this.codAfectiune = codAfectiune;
	this.denAfectiune = denAfectiune;
	this.tipAfectiune = tipAfectiune;
}




}
