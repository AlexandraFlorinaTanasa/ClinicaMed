package org.entity;

import java.util.Objects;

public class InvestigatiiTratamente extends IstoricMed {
private Integer codInvestigatiiTratamente;
private String denInvestigatiiTratamente;
private Double pretInvestigatiiTratamente;

public Integer getCodInvestigatiiTratamente() {
	return codInvestigatiiTratamente;
}
public void setCodInvestigatiiTratamente(Integer codInvestigatiiTratamente) {
	this.codInvestigatiiTratamente = codInvestigatiiTratamente;
}
public String getDenInvestigatiiTratamente() {
	return denInvestigatiiTratamente;
}
public void setDenInvestigatiiTratamente(String denInvestigatiiTratamente) {
	this.denInvestigatiiTratamente = denInvestigatiiTratamente;
}
public Double getPretInvestigatiiTratamente() {
	return pretInvestigatiiTratamente;
}
public void setPretInvestigatiiTratamente(Double pretInvestigatiiTratamente) {
	this.pretInvestigatiiTratamente = pretInvestigatiiTratamente;
}
public InvestigatiiTratamente(Integer idIstoricMed, Pacienti pacient, Medic medic, Integer codInvestigatiiTratamente,
		String denInvestigatiiTratamente, Double pretInvestigatiiTratamente) {
	super(idIstoricMed, pacient, medic);
	this.codInvestigatiiTratamente = codInvestigatiiTratamente;
	this.denInvestigatiiTratamente = denInvestigatiiTratamente;
	this.pretInvestigatiiTratamente = pretInvestigatiiTratamente;
}
public InvestigatiiTratamente(Integer idIstoricMed, Pacienti pacient, Medic medic) {
	super(idIstoricMed, pacient, medic);
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result
			+ Objects.hash(codInvestigatiiTratamente, denInvestigatiiTratamente, pretInvestigatiiTratamente);
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
	InvestigatiiTratamente other = (InvestigatiiTratamente) obj;
	return Objects.equals(codInvestigatiiTratamente, other.codInvestigatiiTratamente)
			&& Objects.equals(denInvestigatiiTratamente, other.denInvestigatiiTratamente)
			&& Objects.equals(pretInvestigatiiTratamente, other.pretInvestigatiiTratamente);
}
@Override
public String toString() {
	return "InvestigatiiTratamente [codInvestigatiiTratamente=" + codInvestigatiiTratamente
			+ ", denInvestigatiiTratamente=" + denInvestigatiiTratamente + ", pretInvestigatiiTratamente="
			+ pretInvestigatiiTratamente + "]";
}



}
