package dto;

import java.math.BigInteger;

/**
 * Created by nik on 16.05.16.
 */
public class CustomBus {
    private BigInteger myCustomId;
    private String myCustomNumber;

    public BigInteger getMyCustomId() {
        return myCustomId;
    }

    public void setMyCustomId(BigInteger myCustomId) {
        this.myCustomId = myCustomId;
    }

    public String getMyCustomNumber() {
        return myCustomNumber;
    }

    public void setMyCustomNumber(String myCustomNumber) {
        this.myCustomNumber = myCustomNumber;
    }
}
