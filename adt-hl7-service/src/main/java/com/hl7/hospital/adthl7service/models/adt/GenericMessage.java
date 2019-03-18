package com.hl7.hospital.adthl7service.models.adt;

public class GenericMessage {
	
	private GenericMessage GenericMessage;
	private In1Model In1Model;
	private MshModel MshModel;
	private ObrModel ObrModel;
	private ObxModel ObxModel;
	private OrcModel OrcModel;
	private PidModel PidModel;
	private Pv1Model Pv1Model;
	private String Evn;
	public GenericMessage getGenericMessage() {
		return GenericMessage;
	}
	public void setGenericMessage(GenericMessage genericMessage) {
		GenericMessage = genericMessage;
	}
	public In1Model getIn1Model() {
		return In1Model;
	}
	public void setIn1Model(In1Model in1Model) {
		In1Model = in1Model;
	}
	public MshModel getMshModel() {
		return MshModel;
	}
	public void setMshModel(MshModel mshModel) {
		MshModel = mshModel;
	}
	public ObrModel getObrModel() {
		return ObrModel;
	}
	public void setObrModel(ObrModel obrModel) {
		ObrModel = obrModel;
	}
	public ObxModel getObxModel() {
		return ObxModel;
	}
	public void setObxModel(ObxModel obxModel) {
		ObxModel = obxModel;
	}
	public OrcModel getOrcModel() {
		return OrcModel;
	}
	public void setOrcModel(OrcModel orcModel) {
		OrcModel = orcModel;
	}
	public PidModel getPidModel() {
		return PidModel;
	}
	public void setPidModel(PidModel pidModel) {
		PidModel = pidModel;
	}
	public Pv1Model getPv1Model() {
		return Pv1Model;
	}
	public void setPv1Model(Pv1Model pv1Model) {
		Pv1Model = pv1Model;
	}
	public String getEvn() {
		return Evn;
	}
	public void setEvn(String evn) {
		Evn = evn;
	}

}
