package com.johnckeyes.kotlin;

public class BoringOldPojo {

    private String blah;

    BoringOldPojo(String blah) {
        this.blah = blah;
    }

    public String getBlah() {
        return this.blah;
    }

    public void setBlah(String blah) {
        this.blah = blah;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoringOldPojo that = (BoringOldPojo) o;

        return blah != null ? blah.equals(that.blah) : that.blah == null;
    }

    @Override
    public int hashCode() {
        return blah != null ? blah.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BoringOldPojo{" +
                "blah='" + blah + '\'' +
                '}';
    }
}
