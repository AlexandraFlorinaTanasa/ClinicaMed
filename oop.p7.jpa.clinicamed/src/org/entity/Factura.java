package org.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Factura {
	private Integer nrFactura;
	
	private List<LinieFact> linieFact = new ArrayList<LinieFact>();
	
	
	private Pacienti pacienti; 
	
	private Double totalFact;
	private Double totalTVA;
	
	

	public Integer getNrFactura() {
		return nrFactura;
	}

	public void setNrFactura(Integer nrFactura) {
		this.nrFactura = nrFactura;
	}

	public List<LinieFact> getLinieFact() {
		return linieFact;
	}

	public void setLinieFact(List<LinieFact> linieFact) {
		this.linieFact = linieFact;
	}

	public Pacienti getPacienti() {
		return pacienti;
	}

	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}

	

	public void setTotalFact(Double totalFact) {
		this.totalFact = totalFact;
	}

	public void setTotalTVA(Double totalTVA) {
		this.totalTVA = totalTVA;
	}

	public Double getTotalFact() {
		if(linieFact.isEmpty()) return null;
		Double totalFact=0.0;
		for(LinieFact lf:linieFact)
			totalFact+=lf.getValoareLinie();
		return totalFact;
	}
	
	Double calculTotal() {
		Double totalFact=.0;
		for(LinieFact lf:linieFact ) totalFact+=lf.getValoareLinie();
		return totalFact;
	}
	public Double getTotalTVA() {
		if(linieFact.isEmpty())
			return null;
		Double totalFact=calculTotal();
		return 0.19/1.09*totalFact; // se aplica tva de 19%
	}
	
	public Factura(Integer nrFactura, List<LinieFact> linieFact, Pacienti pacienti, Double totalFact, Double totalTVA) {
		super();
		this.nrFactura = nrFactura;
		this.linieFact = linieFact;
		this.pacienti = pacienti;
		this.totalFact = totalFact;
		this.totalTVA = totalTVA;
	}

	public Factura() {
		super();
	}
	
	
	
	public void adaugaLinie (LinieFact linieFact) {
		LinieFact.add(linieFact);
	}
	public void adauga(InvestigatiiTratamente investigatiiTratamente) {
		LinieFact lf =new LinieFact();
		lf.setFactura(this);
		lf.setInvestigatiiTratamente(investigatiiTratamente);
		this.linieFact.add(lf);
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(linieFact, nrFactura, pacienti, totalFact, totalTVA);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(linieFact, other.linieFact) && Objects.equals(nrFactura, other.nrFactura)
				&& Objects.equals(pacienti, other.pacienti) && Objects.equals(totalFact, other.totalFact)
				&& Objects.equals(totalTVA, other.totalTVA);
	}

	@Override
	public String toString() {
		return "Factura [nrFactura=" + nrFactura + ", linieFact=" + linieFact + ", pacienti=" + pacienti
				+ ", totalFact=" + totalFact + ", totalTVA=" + totalTVA + "]";
	}


	


}

