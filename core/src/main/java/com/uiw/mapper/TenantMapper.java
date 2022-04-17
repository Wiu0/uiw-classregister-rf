package com.uiw.mapper;

import com.uiw.entity.TenantEntity;
import com.uiw.vo.TenantVO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TenantMapper {

    TenantEntity toMap(TenantVO tenantVO);

    TenantVO toMap(TenantEntity tenantVO);
}
