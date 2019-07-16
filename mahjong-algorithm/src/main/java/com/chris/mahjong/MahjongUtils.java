package com.chris.mahjong;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chrischan
 * create on 2019\7\15 0015 17:37
 * use for: 麻将工具
 */
public class MahjongUtils {
    /**
     * 胡牌算法 14张
     *
     * @param ownCard 已经加上测试可用胡牌的牌
     * @return
     */
    public static boolean hu(OwnCard ownCard) {

        List<List<Integer>> chi = ownCard.getChi();
        List<List<Integer>> pen = ownCard.getPen();
        List<List<Integer>> gang = ownCard.getGang();
        List<Integer> hand = ownCard.getHand();
        int handSize = hand.size();

        //是不是相公
        if (handSize > 14 || handSize % 3 != 2) {
            throw new RuntimeException("相公~~~~~");
        }

        //1. 检查手牌张数
        if (handSize < 14) {
            //不够14张 肯定有吃碰杠
            int chiCount = checkChi(chi);
            int penCount = checkPen(pen);
            int gangCount = checkGang(gang);
            int groupCount = handSize / 3 + chiCount + penCount + gangCount;
            if (groupCount != 4) {
                throw new RuntimeException("你的牌张不对数啊！！");
            }
        }

        //解析手牌
        parseHandCards(hand);

        return false;
    }

    //解析手牌 如果全部能够抽成搭子，则返回除将牌之外的搭子数
    private static int parseHandCards(List<Integer> hand) {
        //1. 检查其中可能会成为将牌的牌张，即数量大于2
        MultiValueMap<Integer, Integer> map = new LinkedMultiValueMap<>();
        hand.stream().forEach(hanCard -> map.add(hanCard, hanCard));
        Set<Integer> jiangSet = new HashSet<>();
        map.forEach((card, cardList) -> {
            //大于一张有做将的机会
            if (cardList.size() > 1) {
                jiangSet.add(card);
            }
        });
        //2. 遍历可能的将
        for (Integer jiang : jiangSet) {
            //剔除两张将牌
            int jiangCount = 0;
            List<Integer> groupList = new ArrayList<>();
            for (Integer card : hand) {
                if (card == jiang && jiangCount < 2) {
                    jiangCount++;
                    continue;
                }
                groupList.add(card);
            }
            int group = parseGroup(groupList);
            if (group > 0) {
                System.out.println("恭喜胡牌");
            } else {
                System.out.println("诈和~~~来人，剁手！！");
            }
            return group;
        }
        return 0;
    }

    /**
     * 解析手牌中去掉将牌之后的搭子
     *
     * @param groupList
     */
    private static int parseGroup(List<Integer> groupList) {
        int groupCount = 0;
        //1. 首先检索刻子
        MultiValueMap<Integer, Integer> map = new LinkedMultiValueMap<>();
        groupList.stream().forEach(card -> map.add(card, card));
        Set<Integer> keziSet = new HashSet<>();
        Set<Integer> keySet = map.keySet();
        for (Integer card : keySet) {
            List<Integer> cardList = map.get(card);
            //有三张的为一个刻子
            if (cardList.size() == 3) {
                keziSet.add(card);
                groupCount++;
            } else if (cardList.size() != 1) {
                throw new RuntimeException("你的牌有问题！");
            }

        }
        //2. 剔除刻子之后检索搭子
        List<Integer> list1=new ArrayList<>()
/*
暂停，这里思路有问题，先检出刻子是不对的
 */

        return groupCount;
    }

    /**
     * 检查吃牌
     *
     * @param chi
     */
    private static int checkChi(List<List<Integer>> chi) {
        if (null == chi || chi.size() == 0) {
            return 0;
        }
        int count = 0;
        for (List<Integer> chiList : chi) {
            if (null == chiList || chiList.size() == 0) {
                continue;
            }
            //一组吃牌必须是三张
            if (chiList.size() != 3) {
                throw new RuntimeException("你是怎么吃的？不够三张。");
            }
            //排序
            List<Integer> collect = chiList.stream().sorted(Integer::compareTo).collect(Collectors.toList());

            Integer card0 = collect.get(0);
            Integer card1 = collect.get(1);
            Integer card2 = collect.get(2);
            //检查是否同种花色 万筒条才可以吃
            if (checkCardType(card0, card1, card2) < 3) {
                throw new RuntimeException("你有眼疾？");
            }
            //三个连续张
            if ((card1 - card0 != 1) || (card2 - card1 != 1)) {
                throw new RuntimeException("你什么都吃呀？");
            }
            count++;
        }
        return count;
    }

    /**
     * 检查一组麻将是否为同种
     * 如果是返回种类
     * 如果不是返回-1
     * 1- 8 花
     * 11-14 风
     * 21-23 箭
     * 31-39 万
     * 41-49 筒
     * 51-59 条
     *
     * @param cards
     * @return
     */
    private static int checkCardType(Integer... cards) {
        if (null == cards || cards.length == 0) {
            return -1;
        }
        int type = -1;
        for (int i = 0, len = cards.length; i < len; i++) {
            int tp = cards[i] / 10;
            if (type == -1) {
                type = tp;
                continue;
            }
            if (tp != type) {
                return -1;
            }
        }
        return type;
    }

    /**
     * 检查碰牌
     *
     * @param pen
     */
    private static int checkPen(List<List<Integer>> pen) {
        if (null == pen || pen.size() == 0) {
            return 0;
        }
        int count = 0;
        for (List<Integer> penList : pen) {
            if (null == penList || penList.size() == 0) {
                continue;
            }
            if (penList.size() != 3) {
                throw new RuntimeException("碰牌落地要三张");
            }
            long cnt = penList.stream().distinct().count();
            if (cnt > 1) {
                throw new RuntimeException("相同的牌才可以碰");
            }
            count++;
        }
        return count;
    }

    /**
     * 检查杠牌
     *
     * @param gang
     */
    private static int checkGang(List<List<Integer>> gang) {
        if (null == gang || gang.size() == 0) {
            return 0;
        }

        int count = 0;
        for (List<Integer> gangList : gang) {
            if (null == gangList || gangList.size() == 0) {
                return 0;
            }
            if (gangList.size() != 4) {
                throw new RuntimeException("杠牌落地要四张");
            }
            long cnt = gangList.stream().distinct().count();
            if (cnt > 1) {
                throw new RuntimeException("相同的牌才可以杠");
            }

            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Integer[] handCards = {31, 32, 33, 34, 35, 36, 37, 37};
        parseHandCards(Arrays.asList(handCards));
    }

    private static void test2() {
        OwnCard ownCard = new OwnCard();
        Integer[] chiCards = {41, 42, 43};
        Integer[] penCards = {11, 11, 11};
        Integer[] handCards = {31, 32, 33, 34, 35, 36, 37, 38};
        ownCard.addChiList(Arrays.asList(chiCards));
        ownCard.addPenList(Arrays.asList(penCards));
        ownCard.setHand(Arrays.asList(handCards));
        hu(ownCard);
    }

}
