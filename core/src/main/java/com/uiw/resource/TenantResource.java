package com.uiw.resource;

import com.uiw.entity.TenantEntity;
import com.uiw.mapper.TenantMapper;
import com.uiw.repository.tenant.TenantRepository;
import com.uiw.vo.TenantVO;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/tenant")
public class TenantResource {

    @Inject
    private TenantRepository tenantRepository;

    @Inject
    private TenantMapper tenantMapper;

    @POST
    @Transactional
    public TenantVO createTenant(TenantVO tenantVO) {
        TenantEntity tenantEntity = tenantMapper.toMap(tenantVO);
        tenantRepository.persist(tenantEntity);
        tenantVO.setId(tenantEntity.getId());
        return tenantVO;
    }
}
