package finassets.core.assets;

public abstract class Asset {
    public boolean equals(Asset other) {
        return this.hashCode() == other.hashCode();
    }
}

