package blockchain;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Miner miner = new Miner(5);

        List<Block> chain = new ArrayList<>();
        Block myBlock = new Block("0", 1);
        myBlock = miner.mine(myBlock);
        chain.add(myBlock);
        for (int i = 1; i < 5; i++) {
            Block previousBlock = chain.get(i - 1);
            Block newBlock = new Block(previousBlock.getMyHash(), previousBlock.getId() + 1);
            newBlock = miner.mine(newBlock);
            chain.add(newBlock);
        }
        chain.forEach(System.out::println);

    }


}
