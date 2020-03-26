package com.troweprice.interview;

public class Word {

    private String value;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLength() {
        return value == null ? 0 : value.length();
    }

    @Override
    public int hashCode() {
        return 31 * 7  + (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return value.equals(((Word)obj).value);
    }

    @Override
    public String toString() {
        return "value=" + value + ", length=" + getLength();
    }
}
