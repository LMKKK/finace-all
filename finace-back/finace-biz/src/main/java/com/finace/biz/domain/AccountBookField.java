package com.finace.biz.domain;

import com.bage.mybatis.help.DbField;
import com.bage.mybatis.help.FieldResult;

import java.util.Collections;

public class AccountBookField {
    public static DbField Id = new DbField("id", "id", "BIGINT", "java.lang.Long");

    public static DbField CompanyName = new DbField("company_name", "companyName", "VARCHAR", "java.lang.String");

    public static DbField UnifiedSocialCreditCode = new DbField("unified_social_credit_code", "unifiedSocialCreditCode", "VARCHAR", "java.lang.String");

    public static DbField IndustryId = new DbField("industry_id", "industryId", "INTEGER", "java.lang.Integer");

    public static DbField ValueAddedTaxCate = new DbField("value_added_tax_cate", "valueAddedTaxCate", "TINYINT", "java.lang.Byte");

    public static DbField EnableVoucherVerify = new DbField("enable_voucher_verify", "enableVoucherVerify", "BIT", "java.lang.Boolean");

    public static DbField StartTime = new DbField("start_time", "startTime", "TIMESTAMP", "java.util.Date");

    public static DbField AccountingStandard = new DbField("accounting_standard", "accountingStandard", "TINYINT", "java.lang.Byte");

    public static DbField EnableFixedAssets = new DbField("enable_fixed_assets", "enableFixedAssets", "BIT", "java.lang.Boolean");

    public static DbField EnableCapital = new DbField("enable_capital", "enableCapital", "BIT", "java.lang.Boolean");

    public static DbField EnablePsi = new DbField("enable_psi", "enablePsi", "BIT", "java.lang.Boolean");

    public static DbField Disable = new DbField("disable", "disable", "BIT", "java.lang.Boolean");

    public static DbField CreateTime = new DbField("create_time", "createTime", "TIMESTAMP", "java.util.Date");

    public static DbField UpdateTime = new DbField("update_time", "updateTime", "TIMESTAMP", "java.util.Date");

    public static DbField MemberId = new DbField("member_id", "memberId", "BIGINT", "java.lang.Long");

    public static DbField UpdateMemberId = new DbField("update_member_id", "updateMemberId", "BIGINT", "java.lang.Long");

    public static DbField DelFlag = new DbField("del_flag", "delFlag", "BIT", "java.lang.Boolean");

    public static DbField TenantId = new DbField("tenant_id", "tenantId", "BIGINT", "java.lang.Long");

    public static FieldResult setId(Long id) {
        return new FieldResult(Id, Collections.singletonList(id));
    }

    public static FieldResult setCompanyName(String companyName) {
        return new FieldResult(CompanyName, Collections.singletonList(companyName));
    }

    public static FieldResult setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        return new FieldResult(UnifiedSocialCreditCode, Collections.singletonList(unifiedSocialCreditCode));
    }

    public static FieldResult setIndustryId(Integer industryId) {
        return new FieldResult(IndustryId, Collections.singletonList(industryId));
    }

    public static FieldResult setValueAddedTaxCate(Byte valueAddedTaxCate) {
        return new FieldResult(ValueAddedTaxCate, Collections.singletonList(valueAddedTaxCate));
    }

    public static FieldResult setEnableVoucherVerify(Boolean enableVoucherVerify) {
        return new FieldResult(EnableVoucherVerify, Collections.singletonList(enableVoucherVerify));
    }

    public static FieldResult setStartTime(java.util.Date startTime) {
        return new FieldResult(StartTime, Collections.singletonList(startTime));
    }

    public static FieldResult setAccountingStandard(Byte accountingStandard) {
        return new FieldResult(AccountingStandard, Collections.singletonList(accountingStandard));
    }

    public static FieldResult setEnableFixedAssets(Boolean enableFixedAssets) {
        return new FieldResult(EnableFixedAssets, Collections.singletonList(enableFixedAssets));
    }

    public static FieldResult setEnableCapital(Boolean enableCapital) {
        return new FieldResult(EnableCapital, Collections.singletonList(enableCapital));
    }

    public static FieldResult setEnablePsi(Boolean enablePsi) {
        return new FieldResult(EnablePsi, Collections.singletonList(enablePsi));
    }

    public static FieldResult setDisable(Boolean disable) {
        return new FieldResult(Disable, Collections.singletonList(disable));
    }

    public static FieldResult setCreateTime(java.util.Date createTime) {
        return new FieldResult(CreateTime, Collections.singletonList(createTime));
    }

    public static FieldResult setUpdateTime(java.util.Date updateTime) {
        return new FieldResult(UpdateTime, Collections.singletonList(updateTime));
    }

    public static FieldResult setMemberId(Long memberId) {
        return new FieldResult(MemberId, Collections.singletonList(memberId));
    }

    public static FieldResult setUpdateMemberId(Long updateMemberId) {
        return new FieldResult(UpdateMemberId, Collections.singletonList(updateMemberId));
    }

    public static FieldResult setDelFlag(Boolean delFlag) {
        return new FieldResult(DelFlag, Collections.singletonList(delFlag));
    }

    public static FieldResult setTenantId(Long tenantId) {
        return new FieldResult(TenantId, Collections.singletonList(tenantId));
    }
}