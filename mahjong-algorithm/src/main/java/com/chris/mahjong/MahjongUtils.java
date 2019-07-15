package com.chris.mahjong;

import java.util.List;

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

        List<Integer> chi = ownCard.getChi();
        List<Integer> pen = ownCard.getPen();
        List<Integer> gang = ownCard.getGang();
        List<Integer> hand = ownCard.getHand();
        int handSize = hand.size();

        //1. 检查手牌张数
        if (handSize<14){
            //不够14张 
        }

        return false;
    }
}
