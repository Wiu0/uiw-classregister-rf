package com.uiw.repository.tenant;

import com.uiw.entity.TenantEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TenantRepository implements PanacheRepository<TenantEntity> {

    public TenantEntity findByName(String name) {
        return find("name", name).firstResult();
    }

    public TenantEntity findByIdentifier(String identifier) {
        return find("identifier", identifier).firstResult();
    }
}
