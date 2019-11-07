package blockchain;

import java.util.Date;

public class Miner {
    private int zerosAmount = 2;

    public void setZerosAmount(int zerosAmount) {
        this.zerosAmount = zerosAmount;
    }

    public Block mine(Block block) {
        long timeBefore = new Date().getTime();
        while (true) {
            String currentHash = block.getBlockHash();
            if (hasNeededZeros(currentHash)) {
                long timeAfter = new Date().getTime() - timeBefore;
                block.setMiningTime(timeAfter);
                block.setMyHash(currentHash);
                return block;
            }
            block.setNonce(block.getNonce() + 1);
        }
    }

    private boolean hasNeededZeros(String currentHash) {
        String firstNSymbols = currentHash.substring(0, zerosAmount);
        int zerosCounter = 0;
        for (char letter : firstNSymbols.toCharArray()) {
            int a = Character.getNumericValue(letter);
            if (Character.isDigit(letter) && Character.getNumericValue(letter) == 0) {
                zerosCounter++;
            }
        }
        return zerosCounter == zerosAmount;
    }

}
