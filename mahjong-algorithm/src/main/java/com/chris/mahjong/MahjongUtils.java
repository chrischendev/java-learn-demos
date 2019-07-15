package com.chris.mahjong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            checkChi(chi);
            checkPen(pen);
            checkGang(gang);
        }

        return false;
    }

    /**
     * 检查吃牌
     *
     * @param chi
     */
    private static void checkChi(List<List<Integer>> chi) {
        if (null == chi || chi.size() == 0) {
            return;
        }
        chi.stream().forEach(chiList -> {
            //一组吃牌必须是三张
            if (null == chiList || chiList.size() == 0 || chiList.size() != 3) {
                return;
            }
            //排序
            List<Integer> collect = chiList.stream().sorted(Integer::compareTo).collect(Collectors.toList());

            Integer card0 = collect.get(0);
            Integer card1 = collect.get(1);
            Integer card2 = collect.get(2);
            //检查是否同种花色 万筒条才可以吃
            if (checkCardType(card0) < 3) {
                throw new RuntimeException("你有眼疾？");
            }
            //三个连续张
            if ((card1 - card0 != 1) || (card2 - card1 != 1)) {
                throw new RuntimeException("你什么都吃呀？");
            }
        });
    }

    /**
     * 检查一组麻将是否为同种
     * 如果是返回种类
     * 如果不是返回-1
     * 1-7 花 11-14 风 21-23 箭 31-39 万 41-49 筒 51-59 条
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
    private static void checkPen(List<List<Integer>> pen) {
        if (null == pen || pen.size() == 0) {
            return;
        }
        pen.stream().forEach(penList -> {

        });
    }

    /**
     * 检查杠牌
     *
     * @param gang
     */
    private static void checkGang(List<List<Integer>> gang) {
        if (null == gang || gang.size() == 0) {
            return;
        }

        gang.stream().forEach(gangList -> {

        });
    }

    public static void main(String[] args) {
        List<List<Integer>> cardsList = new ArrayList<>();
        Integer[] cards = {33, 32, 34};
        cardsList.add(Arrays.asList(cards));
        checkChi(cardsList);
    }
}
