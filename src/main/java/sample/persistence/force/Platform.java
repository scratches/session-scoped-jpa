
package sample.persistence.force;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;

import sample.Global;

/**
 * The persistent class for the Platform database table.
 */
@Entity
@Qualifier(Global.USER_SPECIFIC_DATA_QUALIFIER)
@Table(name = "tblplatform")
@SecondaryTables({ @SecondaryTable(name = "tblwls", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "platform_id")) })
public class Platform implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "platform_id", unique = true, nullable = false)
	private int platformId;
	
	@Column(name = "org_code", nullable = false)
	private int orgCode;
	
	@Column(name = "superior_platform_id")
	private int superiorPlatformId;
	
	@Column(table = "tblwls", length = 200)
	private String battalion;
	
	@Column(table = "tblwls", name = "bft_ii", length = 45)
	private String bftIi;
	
	@Column(table = "tblwls", length = 200)
	private String company;
	
	@Column(table = "tblwls", length = 200)
	private String eplrs;
	
	@Column(table = "tblwls", length = 45)
	private String jbcp;
	
	@Column(table = "tblwls", length = 200)
	private String kit;
	
	@Column(table = "tblwls", name = "`lin_/_grade`", length = 200)
	private String lin_Grade;
	
	@Column(table = "tblwls", name = "num_prc_154a_nw", length = 45)
	private String numPrc154aNw;
	
	@Column(table = "tblwls", name = "object_heading", length = 200)
	private String objectHeading;
	
	@Column(table = "tblwls", name = "object_identifier", length = 200)
	private String objectId;
	
	@Column(table = "tblwls", length = 200)
	private String para;
	
	@Column(table = "tblwls", name = "para_desc", length = 200)
	private String paraDesc;
	
	@Column(table = "tblwls", length = 200)
	private String platform;
	
	@Column(table = "tblwls", name = "`platform_-__base_`", length = 200)
	private String platform_Base;
	
	@Column(table = "tblwls", name = "platform_type", length = 200)
	private String platformType;
	
	@Column(table = "tblwls", length = 200)
	private String platoon;
	
	@Column(table = "tblwls", name = "sensor_type", length = 200)
	private String sensorType;
	
	@Column(table = "tblwls", length = 200)
	private String squad;
	
	@Column(table = "tblwls", length = 200)
	private String title;
	
	@Column(table = "tblwls", name = "toe_src", length = 200)
	private String toeSrc;
	
	@Column(table = "tblwls", name = "toe_title", length = 200)
	private String toeTitle;
	
	@Column(table = "tblwls", length = 200)
	private String type;
	
	@Column(table = "tblwls", length = 200)
	private String unit;
	
	@Column(table = "tblwls", name = "unit_name", length = 200)
	private String unitName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "superior_platform_id", nullable = false, insertable = false, updatable = false)
	private Platform superiorPlatform;
	
	/**
	 * \TODO Document {@link Platform} constructor.
	 */
	public Platform()
	{
	}
	
	/**
	 * \TODO Document {@link Platform#getPlatformId} method.
	 * 
	 * @return
	 */
	public int getPlatformId()
	{
		return this.platformId;
	}
	
	/**
	 * \TODO Document {@link Platform#setPlatformId} method.
	 * 
	 * @param platformId
	 */
	public void setPlatformId(int platformId)
	{
		this.platformId = platformId;
	}
	
	/**
	 * \TODO Document {@link Platform#getOrgCode} method.
	 * 
	 * @return
	 */
	public int getOrgCode()
	{
		return this.orgCode;
	}
	
	/**
	 * \TODO Document {@link Platform#setOrgCode} method.
	 * 
	 * @param orgCode
	 */
	public void setOrgCode(int orgCode)
	{
		this.orgCode = orgCode;
	}
	
	/**
	 * \TODO Document {@link Platform#getSuperiorPlatformId} method.
	 * 
	 * @return
	 */
	public int getSuperiorPlatformId()
	{
		return this.superiorPlatformId;
	}
	
	/**
	 * \TODO Document {@link Platform#setSuperiorPlatformId} method.
	 * 
	 * @param superiorPlatformId
	 */
	public void setSuperiorPlatformId(int superiorPlatformId)
	{
		this.superiorPlatformId = superiorPlatformId;
	}
	
	/**
	 * \TODO Document {@link Platform#getBattalion} method.
	 * 
	 * @return
	 */
	public String getBattalion()
	{
		return this.battalion;
	}
	
	/**
	 * \TODO Document {@link Platform#setBattalion} method.
	 * 
	 * @param battalion
	 */
	public void setBattalion(String battalion)
	{
		this.battalion = battalion;
	}
	
	/**
	 * \TODO Document {@link Platform#getBftIi} method.
	 * 
	 * @return
	 */
	public String getBftIi()
	{
		return this.bftIi;
	}
	
	/**
	 * \TODO Document {@link Platform#setBftIi} method.
	 * 
	 * @param bftIi
	 */
	public void setBftIi(String bftIi)
	{
		this.bftIi = bftIi;
	}
	
	/**
	 * \TODO Document {@link Platform#getCompany} method.
	 * 
	 * @return
	 */
	public String getCompany()
	{
		return this.company;
	}
	
	/**
	 * \TODO Document {@link Platform#setCompany} method.
	 * 
	 * @param company
	 */
	public void setCompany(String company)
	{
		this.company = company;
	}
	
	/**
	 * \TODO Document {@link Platform#getEplrs} method.
	 * 
	 * @return
	 */
	public String getEplrs()
	{
		return this.eplrs;
	}
	
	/**
	 * \TODO Document {@link Platform#setEplrs} method.
	 * 
	 * @param eplrs
	 */
	public void setEplrs(String eplrs)
	{
		this.eplrs = eplrs;
	}
	
	/**
	 * \TODO Document {@link Platform#getJbcp} method.
	 * 
	 * @return
	 */
	public String getJbcp()
	{
		return this.jbcp;
	}
	
	/**
	 * \TODO Document {@link Platform#setJbcp} method.
	 * 
	 * @param jbcp
	 */
	public void setJbcp(String jbcp)
	{
		this.jbcp = jbcp;
	}
	
	/**
	 * \TODO Document {@link Platform#getKit} method.
	 * 
	 * @return
	 */
	public String getKit()
	{
		return this.kit;
	}
	
	/**
	 * \TODO Document {@link Platform#setKit} method.
	 * 
	 * @param kit
	 */
	public void setKit(String kit)
	{
		this.kit = kit;
	}
	
	/**
	 * \TODO Document {@link Platform#getLin_Grade} method.
	 * 
	 * @return
	 */
	public String getLin_Grade()
	{
		return this.lin_Grade;
	}
	
	/**
	 * \TODO Document {@link Platform#setLin_Grade} method.
	 * 
	 * @param lin_Grade
	 */
	public void setLin_Grade(String lin_Grade)
	{
		this.lin_Grade = lin_Grade;
	}
	
	/**
	 * \TODO Document {@link Platform#getNumPrc154aNw} method.
	 * 
	 * @return
	 */
	public String getNumPrc154aNw()
	{
		return this.numPrc154aNw;
	}
	
	/**
	 * \TODO Document {@link Platform#setNumPrc154aNw} method.
	 * 
	 * @param numPrc154aNw
	 */
	public void setNumPrc154aNw(String numPrc154aNw)
	{
		this.numPrc154aNw = numPrc154aNw;
	}
	
	/**
	 * \TODO Document {@link Platform#getObjectHeading} method.
	 * 
	 * @return
	 */
	public String getObjectHeading()
	{
		return this.objectHeading;
	}
	
	/**
	 * \TODO Document {@link Platform#setObjectHeading} method.
	 * 
	 * @param objectHeading
	 */
	public void setObjectHeading(String objectHeading)
	{
		this.objectHeading = objectHeading;
	}
	
	/**
	 * \TODO Document {@link Platform#getObjectIdentifier} method.
	 * 
	 * @return
	 */
	public String getObjectIdentifier()
	{
		return this.objectId;
	}
	
	/**
	 * \TODO Document {@link Platform#setObjectIdentifier} method.
	 * 
	 * @param objectIdentifier
	 */
	public void setObjectIdentifier(String objectIdentifier)
	{
		this.objectId = objectIdentifier;
	}
	
	/**
	 * \TODO Document {@link Platform#getPara} method.
	 * 
	 * @return
	 */
	public String getPara()
	{
		return this.para;
	}
	
	/**
	 * \TODO Document {@link Platform#setPara} method.
	 * 
	 * @param para
	 */
	public void setPara(String para)
	{
		this.para = para;
	}
	
	/**
	 * \TODO Document {@link Platform#getParaDesc} method.
	 * 
	 * @return
	 */
	public String getParaDesc()
	{
		return this.paraDesc;
	}
	
	/**
	 * \TODO Document {@link Platform#setParaDesc} method.
	 * 
	 * @param paraDesc
	 */
	public void setParaDesc(String paraDesc)
	{
		this.paraDesc = paraDesc;
	}
	
	/**
	 * \TODO Document {@link Platform#getPlatform} method.
	 * 
	 * @return
	 */
	public String getPlatform()
	{
		return this.platform;
	}
	
	/**
	 * \TODO Document {@link Platform#setPlatform} method.
	 * 
	 * @param platform
	 */
	public void setPlatform(String platform)
	{
		this.platform = platform;
	}
	
	/**
	 * \TODO Document {@link Platform#getPlatform_Base} method.
	 * 
	 * @return
	 */
	public String getPlatform_Base()
	{
		return this.platform_Base;
	}
	
	/**
	 * \TODO Document {@link Platform#setPlatform_Base} method.
	 * 
	 * @param platform_Base
	 */
	public void setPlatform_Base(String platform_Base)
	{
		this.platform_Base = platform_Base;
	}
	
	/**
	 * \TODO Document {@link Platform#getPlatformType} method.
	 * 
	 * @return
	 */
	public String getPlatformType()
	{
		return this.platformType;
	}
	
	/**
	 * \TODO Document {@link Platform#setPlatformType} method.
	 * 
	 * @param platformType
	 */
	public void setPlatformType(String platformType)
	{
		this.platformType = platformType;
	}
	
	/**
	 * \TODO Document {@link Platform#getPlatoon} method.
	 * 
	 * @return
	 */
	public String getPlatoon()
	{
		return this.platoon;
	}
	
	/**
	 * \TODO Document {@link Platform#setPlatoon} method.
	 * 
	 * @param platoon
	 */
	public void setPlatoon(String platoon)
	{
		this.platoon = platoon;
	}
	
	/**
	 * \TODO Document {@link Platform#getSensorType} method.
	 * 
	 * @return
	 */
	public String getSensorType()
	{
		return this.sensorType;
	}
	
	/**
	 * \TODO Document {@link Platform#setSensorType} method.
	 * 
	 * @param sensorType
	 */
	public void setSensorType(String sensorType)
	{
		this.sensorType = sensorType;
	}
	
	/**
	 * \TODO Document {@link Platform#getSquad} method.
	 * 
	 * @return
	 */
	public String getSquad()
	{
		return this.squad;
	}
	
	/**
	 * \TODO Document {@link Platform#setSquad} method.
	 * 
	 * @param squad
	 */
	public void setSquad(String squad)
	{
		this.squad = squad;
	}
	
	/**
	 * \TODO Document {@link Platform#getTitle} method.
	 * 
	 * @return
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * \TODO Document {@link Platform#setTitle} method.
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * \TODO Document {@link Platform#getToeSrc} method.
	 * 
	 * @return
	 */
	public String getToeSrc()
	{
		return this.toeSrc;
	}
	
	/**
	 * \TODO Document {@link Platform#setToeSrc} method.
	 * 
	 * @param toeSrc
	 */
	public void setToeSrc(String toeSrc)
	{
		this.toeSrc = toeSrc;
	}
	
	/**
	 * \TODO Document {@link Platform#getToeTitle} method.
	 * 
	 * @return
	 */
	public String getToeTitle()
	{
		return this.toeTitle;
	}
	
	/**
	 * \TODO Document {@link Platform#setToeTitle} method.
	 * 
	 * @param toeTitle
	 */
	public void setToeTitle(String toeTitle)
	{
		this.toeTitle = toeTitle;
	}
	
	/**
	 * \TODO Document {@link Platform#getType} method.
	 * 
	 * @return
	 */
	public String getType()
	{
		return this.type;
	}
	
	/**
	 * \TODO Document {@link Platform#setType} method.
	 * 
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	
	/**
	 * \TODO Document {@link Platform#getUnit} method.
	 * 
	 * @return
	 */
	public String getUnit()
	{
		return this.unit;
	}
	
	/**
	 * \TODO Document {@link Platform#setUnit} method.
	 * 
	 * @param unit
	 */
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	
	/**
	 * \TODO Document {@link Platform#getUnitName} method.
	 * 
	 * @return
	 */
	public String getUnitName()
	{
		return this.unitName;
	}
	
	/**
	 * \TODO Document {@link Platform#setUnitName} method.
	 * 
	 * @param unitName
	 */
	public void setUnitName(String unitName)
	{
		this.unitName = unitName;
	}
	
	/**
	 * \TODO Document {@link Platform#getSuperiorPlatform} method.
	 * 
	 * @return
	 */
	public Platform getSuperiorPlatform()
	{
		return this.superiorPlatform;
	}
	
	/**
	 * \TODO Document {@link Platform#setSuperiorPlatform} method.
	 * 
	 * @param superiorPlatform
	 */
	public void setSuperiorPlatform(Platform superiorPlatform)
	{
		this.superiorPlatform = superiorPlatform;
	}
}