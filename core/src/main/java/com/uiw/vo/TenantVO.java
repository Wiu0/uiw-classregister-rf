package com.uiw.vo;

import com.uiw.types.IdentifierType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TenantVO {

    private BigInteger id;
    private String name;
    private String identifier;
    private IdentifierType type;

}
