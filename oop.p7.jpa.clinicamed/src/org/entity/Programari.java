package org.entity;

import java.util.Date;
import java.util.Objects;

public class Programari {
 private Integer idProgramare;
 private Date data;
 private String tipProgramare; //urgent, de rutina
public Integer getIdProgramare() {
	return idProgramare;
}
public void setIdProgramare(Integer idProgramare) {
	this.idProgramare = idProgramare;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public String getTipProgramare() {
	return tipProgramare;
}
public void setTipProgramare(String tipProgramare) {
	this.tipProgramare = tipProgramare;
}
public Programari(Integer idProgramare, Date data, String tipProgramare) {
	super();
	this.idProgramare = idProgramare;
	this.data = data;
	this.tipProgramare = tipProgramare;
}
public Programari() {
	super();
}
@Override
public int hashCode() {
	return Objects.hash(data, idProgramare, tipProgramare);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Programari other = (Programari) obj;
	return Objects.equals(data, other.data) && Objects.equals(idProgramare, other.idProgramare)
			&& Objects.equals(tipProgramare, other.tipProgramare);
}
@Override
public String toString() {
	return "Programari [idProgramare=" + idProgramare + ", data=" + data + ", tipProgramare=" + tipProgramare + "]";
}


}



