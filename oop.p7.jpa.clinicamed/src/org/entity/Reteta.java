package org.entity;

import java.util.Objects;

public class Reteta {
	private Integer cod;
	private String tipPastile;
	private Integer zileAdministrare;
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getTipPastile() {
		return tipPastile;
	}
	public void setTipPastile(String tipPastile) {
		this.tipPastile = tipPastile;
	}
	public Integer getZileAdministrare() {
		return zileAdministrare;
	}
	public void setZileAdministrare(Integer zileAdministrare) {
		this.zileAdministrare = zileAdministrare;
	}
	public Reteta(Integer cod, String tipPastile, Integer zileAdministrare) {
		super();
		this.cod = cod;
		this.tipPastile = tipPastile;
		this.zileAdministrare = zileAdministrare;
	}
	public Reteta() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(cod, tipPastile, zileAdministrare);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reteta other = (Reteta) obj;
		return Objects.equals(cod, other.cod) && Objects.equals(tipPastile, other.tipPastile)
				&& Objects.equals(zileAdministrare, other.zileAdministrare);
	}
	@Override
	public String toString() {
		return "Reteta [cod=" + cod + ", tipPastile=" + tipPastile + ", zileAdministrare=" + zileAdministrare + "]";
	}
	
	
}