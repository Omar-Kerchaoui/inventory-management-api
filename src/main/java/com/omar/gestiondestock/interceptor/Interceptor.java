package com.omar.gestiondestock.interceptor;


import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class Interceptor implements StatementInspector {

    @Override
    public String inspect(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            // select utilisateu0.
            final String entityName = sql.substring(7, sql.indexOf("."));
            final String idEntreprise = MDC.get("idEntreprise");
            if (StringUtils.hasLength(entityName)
                    && !entityName.toLowerCase().contains("entreprise")
                    && !entityName.toLowerCase().contains("roles")
                    && StringUtils.hasLength(idEntreprise)) {

                if (sql.contains("where")) {
                    sql = sql + " and " + entityName + ".idEntreprise = " + idEntreprise;
                } else {
                    sql = sql + " where " + entityName + ".idEntreprise = " + idEntreprise;
                }
            }
        }

        return sql;
    }


}
