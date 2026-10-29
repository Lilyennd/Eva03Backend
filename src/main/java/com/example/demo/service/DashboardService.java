package com.example.demo.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("deprecation")
    public Object obtenerMetricas() {
        Query query = entityManager.createNativeQuery("SELECT * FROM v_dashboard");
        NativeQueryImpl<?> nativeQuery = query.unwrap(NativeQueryImpl.class);
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getSingleResult();
    }
}
