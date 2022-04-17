package com.uiw.entity;

import com.uiw.types.IdentifierType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity(name = "tenant")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TenantEntity {

    @Id
    @SequenceGenerator(name = "tenantIdSeq", sequenceName = "tenant_id_seq")
    @GeneratedValue(generator = "tenantIdSeq")
    private BigInteger id;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String identifier;
    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private IdentifierType type;

}
