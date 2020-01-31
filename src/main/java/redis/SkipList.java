package redis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SkipList {

    private class LevelNode {

        int value;
        LevelNode next;
        LevelNode pre;
        LevelNode nextLevel;
        int level;

        public LevelNode(int value, int level) {

            this.value = value;
            this.level = level;
        }
    }

    private List<LevelNode> allLevel = new ArrayList<>(12);


    public void add(int value) {

        int level = getRandomLevel();
        LevelNode nextLevelNode = null;
        for (int i = 0; i <= level; i++) {
            LevelNode node = new LevelNode(value, i);
            if (allLevel.get(i) == null) {
                allLevel.add(i, node);
            } else {
                LevelNode start = allLevel.get(i);
                insertList(start, node);
            }
            node.nextLevel = nextLevelNode;
            nextLevelNode = node;
        }

    }

    private int getRandomLevel() {

        //get random from [0,1)
        // return (int) Math.random() * 10 + 1;
        return new Random().nextInt(12);
    }

    //双向链表的插入
    private void insertList(LevelNode start, LevelNode node) {

        LevelNode cur = start;
        LevelNode pre = null;
        while (cur.value <= node.value && cur != null) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            LevelNode next = cur.next;
            cur.next = node;
            node.pre = cur;
            node.next = next;
            if (next != null) {
                next.pre = node;
            }
        } else {
            pre.next = node;
            node.pre = pre;
        }
    }
}
