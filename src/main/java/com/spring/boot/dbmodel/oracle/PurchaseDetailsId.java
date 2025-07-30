package com.spring.boot.dbmodel.oracle;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseDetailsId implements Serializable {
    private String tnxId;
    private String tnxType;

    public PurchaseDetailsId() {}
    public PurchaseDetailsId(String tnxId, String tnxType) {
        this.tnxId = tnxId;
        this.tnxType = tnxType;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseDetailsId)) return false;
        PurchaseDetailsId that = (PurchaseDetailsId) o;
        return Objects.equals(tnxId, that.tnxId) &&
               Objects.equals(tnxType, that.tnxType);
    }
    @Override public int hashCode() { return Objects.hash(tnxId, tnxType); }
}