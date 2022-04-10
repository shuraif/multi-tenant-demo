package com.ms.multitenant.configs;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TenantRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        ServletRequestAttributes attr =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        
		if (attr != null && null != attr.getRequest().getHeader("X-Tenant-Id")) {
			
			if(attr.getRequest().getHeader("X-Tenant-Id").equalsIgnoreCase("tenant_1")) {
				return "tenant_1";
			}else {
				return null;
			}

			
		} else {
			
			return "default";
			
		}
    }
}