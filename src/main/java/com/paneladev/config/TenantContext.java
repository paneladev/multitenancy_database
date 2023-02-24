package com.paneladev.config;

public class TenantContext {

    public static final String DEFAULT_TENANT = "tenant1";

    private static final TenantContext INSTANCE = new TenantContext();

    private final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    private TenantContext() {}

    public static TenantContext getInstance() {
        return INSTANCE;
    }

    public void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public String getCurrentTenant() {
        return currentTenant.get();
    }

    public void clear() {
        currentTenant.remove();
    }
}
