package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GenericMessage {
	
	@JsonProperty(value = "in1")
	private In1Model in1Model;
	@JsonProperty(value = "msh")
	private MshModel mshModel;
	@JsonProperty(value = "obr")
	private ObrModel obrModel;
	@JsonProperty(value = "obx")
	private ObxModel obxModel;
	@JsonProperty(value = "orc")
	private OrcModel orcModel;
	@JsonProperty(value = "pid")
	private PidModel pidModel;
	@JsonProperty(value = "pv1")
	private Pv1Model pv1Model;
	@JsonProperty(value = "evn")
	private String evn;

	public In1Model getIn1Model() {
		return in1Model;
	}
	public void setIn1Model(In1Model in1Model) {
		this.in1Model = in1Model;
	}
	public MshModel getMshModel() {
		return mshModel;
	}
	public void setMshModel(MshModel mshModel) {
		this.mshModel = mshModel;
	}
	public ObrModel getObrModel() {
		return obrModel;
	}
	public void setObrModel(ObrModel obrModel) {
		this.obrModel = obrModel;
	}
	public ObxModel getObxModel() {
		return obxModel;
	}
	public void setObxModel(ObxModel obxModel) {
		this.obxModel = obxModel;
	}
	public OrcModel getOrcModel() {
		return orcModel;
	}
	public void setOrcModel(OrcModel orcModel) {
		this.orcModel = orcModel;
	}
	public PidModel getPidModel() {
		return pidModel;
	}
	public void setPidModel(PidModel pidModel) {
		this.pidModel = pidModel;
	}
	public Pv1Model getPv1Model() {
		return pv1Model;
	}
	public void setPv1Model(Pv1Model pv1Model) {
		this.pv1Model = pv1Model;
	}
	public String getEvn() {
		return evn;
	}
	public void setEvn(String evn) {
		this.evn = evn;
	}

}
