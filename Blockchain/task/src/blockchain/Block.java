package blockchain;

import javax.xml.crypto.Data;
import java.util.Date;

public class Block {
    private long timestamp;
    private String previousHash;
    private String myHash;
    private int id;


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

    private String getBlockHash() {
        String timestampString = Long.toString(timestamp);
        String idString = Integer.toString(id);
        String concatStr = timestampString + idString + previousHash + myHash;
        return StringUtil.applySha256(concatStr);
    }

    @Override
    public String toString() {
        String returnStr = "Block: \nId: " + id + "\nTimestamp: " + timestamp +
                "\nHash of the previous block: \n" + previousHash + "\nHash of the block: \n" + myHash + "\n";
        return returnStr;
    }
}