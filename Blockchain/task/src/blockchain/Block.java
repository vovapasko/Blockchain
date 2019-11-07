package blockchain;

import java.util.Date;

public class Block {
    private long timestamp;
    private String previousHash;
    private String myHash;
    private int id;
    private int nonce;
    private long miningTime;

    public long getMiningTime() {
        return miningTime;
    }

    public void setMiningTime(long miningTime) {
        this.miningTime = miningTime;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }


    public void setMyHash(String myHash) {
        this.myHash = myHash;
    }

    Block(String previousHash, int id) {
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.id = id;
        this.myHash = getBlockHash();
    }

    public String getMyHash() {
        return myHash;
    }

    public int getId() {
        return id;
    }

    public String getBlockHash() {
        String concatStr = timestamp + id + previousHash + myHash + nonce;
        return StringUtil.applySha256(concatStr);
    }

    @Override
    public String toString() {
        String returnStr = "Block: \nId: " + id + "\nTimestamp: " + timestamp +
                "\nHash of the previous block: \n" + previousHash + "\nHash of the block: \n" + myHash + "\n";
        return returnStr;
    }
}