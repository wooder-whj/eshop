package com.macro.mall.dto;

import com.macro.mall.model.OmsCompanyAddress;
import com.macro.mall.model.OmsOrderReturnApply;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 申请信息封装
 * Created by macro on 2018/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply implements Serializable {
    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}
