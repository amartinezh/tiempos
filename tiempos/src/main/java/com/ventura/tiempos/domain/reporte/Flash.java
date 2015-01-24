package com.ventura.tiempos.domain.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity @IdClass(FlashPK.class)
@Table(name="flash_pn", schema="public")
public class Flash implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	@NotEmpty
	@Column
	private int ano;
	@Id
	@NotEmpty
	@Column
	private BigDecimal cocust;
	@Id
	@NotEmpty
	@Column
	private String coprod;
	@Id
	@NotEmpty
	@Column
	private int mes;	
	@Column
	private int cocia;
	@Column
	private String cocltp;
	@Column
	private String codecp;
	@Column
	private String conme;
	@Column
	private String cowhse;
	@Column
	private String cocurr;
	@Column
	private BigDecimal coccus;
	@Column
	private String concus;
	@Column
	private String cotype;
	@Column
	private String cotype_Desc;
	@Column
	private String cozon;
	@Column
	private String codzbp;
	@Column
	private BigDecimal cosal;
	@Column
	private String coname;
	@Column
	private BigDecimal coortp;
	@Column
	private String codesb;
	@Column
	private String coref01;
	@Column
	private String codes01;
	@Column
	private String coref02;
	@Column
	private String codes02;
	@Column
	private String coref03;
	@Column
	private String codes03;
	@Column
	private String coref04;
	@Column
	private String codes04;
	@Column
	private String coref05;
	@Column
	private String codes05;
	@Column
	private String codestm;
	@Column
	private BigDecimal clqty;
	@Column
	private BigDecimal clord;
	@Column
	private BigDecimal cldev;
	@Column
	private BigDecimal cpdte;
	@Column
	private BigDecimal cpqty;
	@Column
	private BigDecimal ckqty;
	@Column
	private BigDecimal clnet;
	@Column
	private BigDecimal clcar;
	@Column
	private BigDecimal clqtyb;
	@Column
	private BigDecimal clnetb;
	@Column
	private BigDecimal clnetc;
	@Column
	private String codesz;
		
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public BigDecimal getCocust() {
		return cocust;
	}

	public void setCocust(BigDecimal cocust) {
		this.cocust = cocust;
	}

	public String getCoprod() {
		return coprod;
	}

	public void setCoprod(String coprod) {
		this.coprod = coprod;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getCocia() {
		return cocia;
	}

	public void setCocia(int cocia) {
		this.cocia = cocia;
	}

	public String getCocltp() {
		return cocltp;
	}

	public void setCocltp(String cocltp) {
		this.cocltp = cocltp;
	}

	public String getCodecp() {
		return codecp;
	}

	public void setCodecp(String codecp) {
		this.codecp = codecp;
	}

	public String getConme() {
		return conme;
	}

	public void setConme(String conme) {
		this.conme = conme;
	}

	public String getCowhse() {
		return cowhse;
	}

	public void setCowhse(String cowhse) {
		this.cowhse = cowhse;
	}

	public String getCocurr() {
		return cocurr;
	}

	public void setCocurr(String cocurr) {
		this.cocurr = cocurr;
	}

	public BigDecimal getCoccus() {
		return coccus;
	}

	public void setCoccus(BigDecimal coccus) {
		this.coccus = coccus;
	}

	public String getConcus() {
		return concus;
	}

	public void setConcus(String concus) {
		this.concus = concus;
	}

	public String getCotype() {
		return cotype;
	}

	public void setCotype(String cotype) {
		this.cotype = cotype;
	}

	public String getCotype_Desc() {
		return cotype_Desc;
	}

	public void setCotype_Desc(String cotype_Desc) {
		this.cotype_Desc = cotype_Desc;
	}

	public String getCozon() {
		return cozon;
	}

	public void setCozon(String cozon) {
		this.cozon = cozon;
	}

	public String getCodzbp() {
		return codzbp;
	}

	public void setCodzbp(String codzbp) {
		this.codzbp = codzbp;
	}

	public BigDecimal getCosal() {
		return cosal;
	}

	public void setCosal(BigDecimal cosal) {
		this.cosal = cosal;
	}

	public String getConame() {
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public BigDecimal getCoortp() {
		return coortp;
	}

	public void setCoortp(BigDecimal coortp) {
		this.coortp = coortp;
	}

	public String getCodesb() {
		return codesb;
	}

	public void setCodesb(String codesb) {
		this.codesb = codesb;
	}

	public String getCoref01() {
		return coref01;
	}

	public void setCoref01(String coref01) {
		this.coref01 = coref01;
	}

	public String getCodes01() {
		return codes01;
	}

	public void setCodes01(String codes01) {
		this.codes01 = codes01;
	}

	public String getCoref02() {
		return coref02;
	}

	public void setCoref02(String coref02) {
		this.coref02 = coref02;
	}

	public String getCodes02() {
		return codes02;
	}

	public void setCodes02(String codes02) {
		this.codes02 = codes02;
	}

	public String getCoref03() {
		return coref03;
	}

	public void setCoref03(String coref03) {
		this.coref03 = coref03;
	}

	public String getCodes03() {
		return codes03;
	}

	public void setCodes03(String codes03) {
		this.codes03 = codes03;
	}

	public String getCoref04() {
		return coref04;
	}

	public void setCoref04(String coref04) {
		this.coref04 = coref04;
	}

	public String getCodes04() {
		return codes04;
	}

	public void setCodes04(String codes04) {
		this.codes04 = codes04;
	}

	public String getCoref05() {
		return coref05;
	}

	public void setCoref05(String coref05) {
		this.coref05 = coref05;
	}

	public String getCodes05() {
		return codes05;
	}

	public void setCodes05(String codes05) {
		this.codes05 = codes05;
	}

	public String getCodestm() {
		return codestm;
	}

	public void setCodestm(String codestm) {
		this.codestm = codestm;
	}

	public BigDecimal getClqty() {
		return clqty;
	}

	public void setClqty(BigDecimal clqty) {
		this.clqty = clqty;
	}

	public BigDecimal getClord() {
		return clord;
	}

	public void setClord(BigDecimal clord) {
		this.clord = clord;
	}

	public BigDecimal getCldev() {
		return cldev;
	}

	public void setCldev(BigDecimal cldev) {
		this.cldev = cldev;
	}

	public BigDecimal getCpdte() {
		return cpdte;
	}

	public void setCpdte(BigDecimal cpdte) {
		this.cpdte = cpdte;
	}

	public BigDecimal getCpqty() {
		return cpqty;
	}

	public void setCpqty(BigDecimal cpqty) {
		this.cpqty = cpqty;
	}

	public BigDecimal getCkqty() {
		return ckqty;
	}

	public void setCkqty(BigDecimal ckqty) {
		this.ckqty = ckqty;
	}

	public BigDecimal getClnet() {
		return clnet;
	}

	public void setClnet(BigDecimal clnet) {
		this.clnet = clnet;
	}

	public BigDecimal getClcar() {
		return clcar;
	}

	public void setClcar(BigDecimal clcar) {
		this.clcar = clcar;
	}

	public BigDecimal getClqtyb() {
		return clqtyb;
	}

	public void setClqtyb(BigDecimal clqtyb) {
		this.clqtyb = clqtyb;
	}

	public BigDecimal getClnetb() {
		return clnetb;
	}

	public void setClnetb(BigDecimal clnetb) {
		this.clnetb = clnetb;
	}

	public BigDecimal getClnetc() {
		return clnetc;
	}

	public void setClnetc(BigDecimal clnetc) {
		this.clnetc = clnetc;
	}

	public String getCodesz() {
		return codesz;
	}

	public void setCodesz(String codesz) {
		this.codesz = codesz;
	}
	
	public Flash() {
		// TODO Auto-generated constructor stub
	}
		
	public Flash(String cozon, String codzbp, BigDecimal ckqty, BigDecimal cpqty, BigDecimal clord, BigDecimal cldev, BigDecimal clnet, BigDecimal cpdte, BigDecimal clqty, BigDecimal clqtyb, BigDecimal clnetb, BigDecimal clnetc, String codesz) {
		this.cozon = cozon;
		this.codzbp = codzbp;
		this.ckqty = ckqty;
		this.cpqty = cpqty;
		this.clord = clord;
		this.cldev = cldev;
		this.clnet = clnet;
		this.cpdte = cpdte;
		this.clqty = clqty;
		this.clqtyb = clqtyb;
		this.clnetb = clnetb;
		this.clnetc = clnetc;
		this.codesz = codesz;
	}
	
	public Flash(String cozon, String codzbp, BigDecimal ckqty, BigDecimal cpqty, BigDecimal clord, BigDecimal cldev, BigDecimal clnet, BigDecimal cpdte, BigDecimal clqty) {
		this.cozon = cozon;
		this.codzbp = codzbp;
		this.ckqty = ckqty;
		this.cpqty = cpqty;
		this.clord = clord;
		this.cldev = cldev;
		this.clnet = clnet;
		this.cpdte = cpdte;
		this.clqty = clqty;
	}
	
	public String toString() {
        return "Descripción: " + ano + ";";
    }

}
