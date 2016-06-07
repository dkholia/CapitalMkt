/**
 * 
 */
package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;
import java.util.Random;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Deep
 */
public class ChDapTO extends Model {

	private static final long serialVersionUID = -3685887190715645847L;
	
	@NotEmpty
	private String dapName;
	@NotEmpty
	private String dapDescription;
	private BigDecimal dapServiceId;
	@NotNull
	private BigDecimal channelCustId;
	
	private String chnlCustName;
	
	public String getDapName() {
		return dapName;
	}
	public String getDapDescription() {
		return dapDescription;
	}
	public BigDecimal getDapServiceId() {
		return dapServiceId;
	}
	public BigDecimal getChannelCustId() {
		return channelCustId;
	}
	public void setDapName(String dapName) {
		this.dapName = dapName;
	}
	public void setDapDescription(String dapDescription) {
		this.dapDescription = dapDescription;
	}
	public void setDapServiceId(BigDecimal dapServiceId) {
		this.dapServiceId = dapServiceId;
	}
	public void setChannelCustId(BigDecimal channelCustId) {
		this.channelCustId = channelCustId;
	}
	
	public String getChnlCustName() {
		return chnlCustName;
	}
	public void setChnlCustName(String chnlCustName) {
		this.chnlCustName = chnlCustName;
	}
	@Override
	public int hashCode() {
		Random generator = new Random(999999999);
		int hashCode = generator.nextInt();
		
		if(dapName!=null && dapName.trim()!=""){
			hashCode += dapName.length()* dapName.hashCode(); 
		}
		if(dapDescription!=null && dapDescription.trim()!=""){
			hashCode += dapDescription.length()* dapDescription.hashCode(); 
		}
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
