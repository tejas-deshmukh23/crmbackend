package com.credithaat.crm.entity.hicredit;

//public class Master_City_State {
//
//}

import com.credithaat.crm.entity.anno.BaseEntity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "t_masterpincode")
public class Master_City_State extends BaseEntity{
	
    @Column(name = "pincode",length = 100)
    private String pincode;
    
    @Column(name = "city",length = 100)
    private String city;
    
    @Column(name = "state",length = 100)
    private String state;
    
    @Column(name = "finnable_servicable",length = 10)
    private String Finnable;
    
    @Column(name = "stashfin_servicable",length = 10)
    private String StashFin;
    
    @Column(name = "fullerton_servicable",length = 10)
    private String Fullerton;
    
    @Column(name = "homecredit_servicable",length = 10)
    private String HomeCredit;
    
    @Column(name = "upwards_servicable",length = 10)
    private String Upwards;
    
    @Column(name = "cashe_servicable",length = 10)
    private String CASHe;
    
    @Column(name = "moneyview_servicable",length = 10)
    private String MoneyView;
    
    @Column(name = "payme_servicable",length = 10)
    private String PayMe;
    
    @Column(name = "nira_servicable",length = 10)
    private String NIRA;
    
    @Column(name = "moneytap_servicable",length = 10)
    private String MoneyTap;
    
    @Column(name = "earlysalary_servicable",length = 10)
    private String EarlySalary;
    
    @Column(name = "rupeeredee_servicable",length = 10)
    private String RupeeRedee;
    
    @Column(name = "indifi_servicable",length = 10)
    private String Indifi;
    
    @Column(name = "flexiLoans_servicable",length = 10)
    private String FlexiLoans;
    
    @Column(name = "kinara_servicable",length = 10)
    private String Kinara;
    
    @Column(name = "tata_capital_servicable",length = 10)
    private String TataCapital;    
    
    @Column(name = "BL",length = 10)
    private String BL;
    
    @Column(name = "state_code",length = 10)
    private String statecode;
    
    @Column(name = "finzy_city",length = 10)
    private String finzy_city;
    
    @Column(name = "finzy_servicable",length = 10)
    private String Finzy;
    
    @Column(name = "incred_servicable",length = 10)
    private String Incred; 
    
    @Column(name = "iifl_servicable",length = 10)
    private String IIFL;
    
    @Column(name = "privo_servicable",length = 10)
    private String Privo;
    
    @Column(name = "prefr_servicable",length = 10)
    private String Prefr;
    
    @Column(name = "kreditbee_servicable",length = 10)
    private String KreditBee; 
    
    @Column(name = "navi_servicable",length = 10)
    private String NAVI;
    
    @Column(name = "moneywide_servicable",length = 10)
    private String MoneyWide;
    
    @Column(name = "iiflgold_servicable",length = 10)
    private String iiflgoldloan;
    
    @Column(name = "smartcoin_servicable",length = 10)
    private String SmartCoin;
    
    @Column(name = "idfc_servicable",length = 10)
    private String IDFC;
    
    @Column(name = "branch_code",length = 10)
    private String BranchCode;
    
    @Column(name = "kissht_servicable",length = 10)
    private String Kissht;
    
    @Column(name = "zype_servicable",length = 10)
    private String Zype;
    
    @Column(name = "freed_servicable",length = 10)
    private String Freed;
    
    @Column(name = "abc",length = 10)
    private String abc;
    
    @Column(name = "ltfs_serviceable",length = 10)
    private String LTFS;
    
    @Column(name = "GosreeFinanceLimited_serviceable",length = 10)
    private String GosreeFinanceLimited;
    
    @Column(name = "aditya_birla_capital_bl_serviceable",length = 10)
    private String Aditya_Birla_Capital_BL;
    
    @Column(name = "fatakpay_serviceable",length = 10)
    private String FatakPay;
    
    @Column(name = "mPokket_serviceable",length = 10)
    private String mPokket;
    
    @Column(name = "ltpl_serviceable",length = 10)
    private String LTPL;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }  
    
    public String getFinnable() {
        return Finnable;
    }

    public void setFinnable(String Finnable) {
        this.Finnable = Finnable;
    }
    
    public String getFullerton() {
        return Fullerton;
    }

    public void setFullerton(String Fullerton) {
        this.Fullerton = Fullerton;
    }
    
    public String getHomeCredit() {
        return HomeCredit;
    }

    public void setHomeCredit(String HomeCredit) {
        this.HomeCredit = HomeCredit;
    }
    
    public String getUpwards() {
        return Upwards;
    }

    public void setUpwards(String Upwards) {
        this.Upwards = Upwards;
    }
    
    public String getCASHe() {
        return CASHe;
    }

    public void setCASHe(String CASHe) {
        this.CASHe = CASHe;
    }
    
    public String getMoneyView() {
        return MoneyView;
    }

    public void setMoneyView(String MoneyView) {
        this.MoneyView = MoneyView;
    }
    
    public String getPayMe() {
        return PayMe;
    }

    public void setPayMe(String PayMe) {
        this.PayMe = PayMe;
    }
    
    public String getNIRA() {
        return NIRA;
    }

    public void setNIRA(String NIRA) {
        this.NIRA = NIRA;
    }
    
    public String getMoneyTap() {
        return MoneyTap;
    }

    public void setMoneyTap(String MoneyTap) {
        this.MoneyTap = MoneyTap;
    }
    
    public String getEarlySalary() {
        return EarlySalary;
    }

    public void setEarlySalary(String EarlySalary) {
        this.EarlySalary = EarlySalary;
    }
    
    public String getRupeeRedee() {
        return RupeeRedee;
    }

    public void setRupeeRedee(String RupeeRedee) {
        this.RupeeRedee = RupeeRedee;
    }
    
    public String getBL() {
        return BL;
    }

    public void setBL(String BL) {
        this.BL = BL;
    }
    
    public String getIndifi() {
        return Indifi;
    }

    public void setIndifi(String Indifi) {
        this.Indifi = Indifi;
    }
    
    public String getFlexiLoans() {
        return FlexiLoans;
    }

    public void setFlexiLoans(String FlexiLoans) {
        this.FlexiLoans = FlexiLoans;
    }

    public String getKinara() {
        return Kinara;
    }

    public void setKinara(String Kinara) {
        this.Kinara = Kinara;
    }
    
    public String getTataCapital() {
        return TataCapital;
    }

    public void setTataCapital(String TataCapital) {
        this.TataCapital = TataCapital;
    }
    
    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }
    
    public String getFinzy_city() {
        return finzy_city;
    }

    public void setFinzy_city(String finzy_city) {
        this.finzy_city = finzy_city;
    }
    
    public String getFinzy() {
        return Finzy;
    }

    public void setFinzy(String Finzy) {
        this.Finzy = Finzy;
    }
    
    public String getIncred() {
        return Incred;
    }

    public void setIncred(String Incred) {
        this.Incred = Incred;
    } 
    
    public String getIIFL() {
        return IIFL;
    }

    public void setIIFL(String IIFL) {
        this.IIFL = IIFL;
    }
    
    public String getPrivo() {
        return Privo;
    }

    public void setPrivo(String Privo) {
        this.Privo = Privo;
    }
    
    public String getPrefr() {
        return Prefr;
    }

    public void setPrefr(String Prefr) {
        this.Prefr = Prefr;
    }  
    
    public String getKreditBee() {
        return KreditBee;
    }

    public void setKreditBee(String KreditBee) {
        this.KreditBee = KreditBee;
    }
    
    public String getStashFin() {
        return StashFin;
    }

    public void setStashFin(String StashFin) {
        this.StashFin = StashFin;
    }
    
    public String getNAVI() {
        return NAVI;
    }

    public void setNAVI(String NAVI) {
        this.NAVI = NAVI;
    }
    
    public String getMoneyWide() {
        return MoneyWide;
    }

    public void setMoneyWide(String MoneyWide) {
        this.MoneyWide = MoneyWide;
    }
    
    public String getIiflgoldloan() {
        return iiflgoldloan;
    }

    public void setIiflgoldloan(String iiflgoldloan) {
        this.iiflgoldloan = iiflgoldloan;
    }
    
    public String getSmartCoin() {
        return SmartCoin;
    }

    public void setSmartCoin(String SmartCoin) {
        this.SmartCoin = SmartCoin;
    }
    
    public String getIDFC() {
        return IDFC;
    }

    public void setIDFC(String IDFC) {
        this.IDFC = IDFC;
    }
    
    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String BranchCode) {
        this.BranchCode = BranchCode;
    }
    
    public String getKissht() {
        return Kissht;
    }

    public void setKissht(String Kissht) {
        this.Kissht = Kissht;
    }
    
    public String getZype() {
        return Zype;
    }

    public void setZype(String Zype) {
        this.Zype = Zype;
    }
    
    public String getFreed() {
        return Freed;
    }

    public void setFreed(String Freed) {
        this.Freed = Freed;
    }
    
    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }
    
    public String getLTFS() {
        return LTFS;
    }

    public void setLTFS(String LTFS) {
        this.LTFS = LTFS;
    }
    
    public String getGosreeFinanceLimited() {
		return GosreeFinanceLimited;
	}

	public void setGosreeFinanceLimited(String GosreeFinanceLimited) {
		this.GosreeFinanceLimited = GosreeFinanceLimited;
	}
	
    public String getAditya_Birla_Capital_BL() {
		return Aditya_Birla_Capital_BL;
	}

	public void setAditya_Birla_Capital_BL(String Aditya_Birla_Capital_BL) {
		this.Aditya_Birla_Capital_BL = Aditya_Birla_Capital_BL;
	}
	
    public String getFatakPay() {
		return FatakPay;
	}

	public void setFatakPay(String FatakPay) {
		this.FatakPay = FatakPay;
	}
	
    public String getMPokket() {
		return mPokket;
	}

	public void setMPokket(String mPokket) {
		this.mPokket = mPokket;
	}
	
    public String getLTPL() {
		return LTPL;
	}

	public void setLTPL(String LTPL) {
		this.LTPL = LTPL;
	}
	
}

