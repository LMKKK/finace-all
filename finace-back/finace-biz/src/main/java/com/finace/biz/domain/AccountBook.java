package com.finace.biz.domain;

import java.util.Date;

/**
 * 账套（表：account_book）
 *
 * @author finace
 * @date 2024-03-07 22:45:28
 */
public class AccountBook {
    /**
     *
     */
    private Long id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 统一社会信用代码
     */
    private String unifiedSocialCreditCode;

    /**
     * 行业代码id（取数据字典）
     */
    private Integer industryId;

    /**
     * 增值税种类[0：小规模纳税人；1：一般纳税人]
     */
    private Byte valueAddedTaxCate;

    /**
     * 凭证是否审核[0：不审核；1：审核]
     */
    private Boolean enableVoucherVerify;

    /**
     * 账套启用年月
     */
    private Date startTime;

    /**
     * 会计准则[0：小企业会计准则；1：企业会计准则；2：民间非盈利组织会计制度；3：农民专业合作社财务会计制度]
     */
    private Byte accountingStandard;

    /**
     * 是否启用固定资产模块[0：不启用；1：启用]
     */
    private Boolean enableFixedAssets;

    /**
     * 是否启用资金模块[0：不启用；1：启用]
     */
    private Boolean enableCapital;

    /**
     * 是否启用进销存[0：不启用；1：启用]
     */
    private Boolean enablePsi;

    /**
     * 是否禁用
     */
    private Boolean disable;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 用户id
     */
    private Long memberId;

    /**
     * 修改用户id
     */
    private Long updateMemberId;

    /**
     * 是否删除，0：删除，1：未删除
     */
    private Boolean delFlag;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.id
     *
     * @return the value of account_book.id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.id
     *
     * @param id the value for account_book.id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.company_name
     *
     * @return the value of account_book.company_name
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.company_name
     *
     * @param companyName the value for account_book.company_name
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.unified_social_credit_code
     *
     * @return the value of account_book.unified_social_credit_code
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.unified_social_credit_code
     *
     * @param unifiedSocialCreditCode the value for account_book.unified_social_credit_code
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.industry_id
     *
     * @return the value of account_book.industry_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Integer getIndustryId() {
        return industryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.industry_id
     *
     * @param industryId the value for account_book.industry_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.value_added_tax_cate
     *
     * @return the value of account_book.value_added_tax_cate
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Byte getValueAddedTaxCate() {
        return valueAddedTaxCate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.value_added_tax_cate
     *
     * @param valueAddedTaxCate the value for account_book.value_added_tax_cate
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setValueAddedTaxCate(Byte valueAddedTaxCate) {
        this.valueAddedTaxCate = valueAddedTaxCate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.enable_voucher_verify
     *
     * @return the value of account_book.enable_voucher_verify
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Boolean getEnableVoucherVerify() {
        return enableVoucherVerify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.enable_voucher_verify
     *
     * @param enableVoucherVerify the value for account_book.enable_voucher_verify
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setEnableVoucherVerify(Boolean enableVoucherVerify) {
        this.enableVoucherVerify = enableVoucherVerify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.start_time
     *
     * @return the value of account_book.start_time
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.start_time
     *
     * @param startTime the value for account_book.start_time
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.accounting_standard
     *
     * @return the value of account_book.accounting_standard
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Byte getAccountingStandard() {
        return accountingStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.accounting_standard
     *
     * @param accountingStandard the value for account_book.accounting_standard
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setAccountingStandard(Byte accountingStandard) {
        this.accountingStandard = accountingStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.enable_fixed_assets
     *
     * @return the value of account_book.enable_fixed_assets
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Boolean getEnableFixedAssets() {
        return enableFixedAssets;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.enable_fixed_assets
     *
     * @param enableFixedAssets the value for account_book.enable_fixed_assets
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setEnableFixedAssets(Boolean enableFixedAssets) {
        this.enableFixedAssets = enableFixedAssets;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.enable_capital
     *
     * @return the value of account_book.enable_capital
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Boolean getEnableCapital() {
        return enableCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.enable_capital
     *
     * @param enableCapital the value for account_book.enable_capital
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setEnableCapital(Boolean enableCapital) {
        this.enableCapital = enableCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.enable_psi
     *
     * @return the value of account_book.enable_psi
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Boolean getEnablePsi() {
        return enablePsi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.enable_psi
     *
     * @param enablePsi the value for account_book.enable_psi
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setEnablePsi(Boolean enablePsi) {
        this.enablePsi = enablePsi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.disable
     *
     * @return the value of account_book.disable
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Boolean getDisable() {
        return disable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.disable
     *
     * @param disable the value for account_book.disable
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.create_time
     *
     * @return the value of account_book.create_time
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.create_time
     *
     * @param createTime the value for account_book.create_time
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.update_time
     *
     * @return the value of account_book.update_time
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.update_time
     *
     * @param updateTime the value for account_book.update_time
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.member_id
     *
     * @return the value of account_book.member_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.member_id
     *
     * @param memberId the value for account_book.member_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.update_member_id
     *
     * @return the value of account_book.update_member_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Long getUpdateMemberId() {
        return updateMemberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.update_member_id
     *
     * @param updateMemberId the value for account_book.update_member_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setUpdateMemberId(Long updateMemberId) {
        this.updateMemberId = updateMemberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.del_flag
     *
     * @return the value of account_book.del_flag
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.del_flag
     *
     * @param delFlag the value for account_book.del_flag
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_book.tenant_id
     *
     * @return the value of account_book.tenant_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_book.tenant_id
     *
     * @param tenantId the value for account_book.tenant_id
     * @mbg.generated Thu Mar 07 22:45:28 HKT 2024
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public void initDefault() {
        if (this.getCompanyName() == null) {
            this.setCompanyName("");
        }
        if (this.getUnifiedSocialCreditCode() == null) {
            this.setUnifiedSocialCreditCode("");
        }
        if (this.getIndustryId() == null) {
            this.setIndustryId(0);
        }
        if (this.getValueAddedTaxCate() == null) {
            this.setValueAddedTaxCate((byte) 0);
        }
        if (this.getEnableVoucherVerify() == null) {
            this.setEnableVoucherVerify(false);
        }
        if (this.getStartTime() == null) {
            this.setStartTime(new Date());
        }
        if (this.getAccountingStandard() == null) {
            this.setAccountingStandard((byte) 0);
        }
        if (this.getEnableFixedAssets() == null) {
            this.setEnableFixedAssets(false);
        }
        if (this.getEnableCapital() == null) {
            this.setEnableCapital(false);
        }
        if (this.getEnablePsi() == null) {
            this.setEnablePsi(false);
        }
        if (this.getDisable() == null) {
            this.setDisable(false);
        }
        if (this.getCreateTime() == null) {
            this.setCreateTime(new Date());
        }
        if (this.getUpdateTime() == null) {
            this.setUpdateTime(new Date());
        }
        if (this.getMemberId() == null) {
            this.setMemberId(0L);
        }
        if (this.getUpdateMemberId() == null) {
            this.setUpdateMemberId(0L);
        }
        if (this.getDelFlag() == null) {
            this.setDelFlag(false);
        }
        if (this.getTenantId() == null) {
            this.setTenantId(0L);
        }
    }

    public void initUpdate() {
    }
}