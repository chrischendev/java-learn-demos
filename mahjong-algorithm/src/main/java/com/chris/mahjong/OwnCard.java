package com.chris.mahjong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chrischan
 * create on 2019\7\15 0015 17:38
 * use for: 手牌
 */
public class OwnCard {
    private List<Integer> chi;//已经吃过的牌
    private List<Integer> pen;//已经碰过的
    private List<Integer> gang;//已经杠过的牌
    private List<Integer> hand;//手里还有的牌

    public OwnCard() {
        chi=new ArrayList<Integer>();
        pen=new ArrayList<Integer>();
        gang=new ArrayList<Integer>();
        hand =new ArrayList<Integer>();
    }

    public OwnCard(List<Integer> chi, List<Integer> pen, List<Integer> gang, List<Integer> hand) {
        this.chi = chi;
        this.pen = pen;
        this.gang = gang;
        this.hand = hand;
    }

    public List<Integer> getChi() {
        return chi;
    }

    public void setChi(List<Integer> chi) {
        this.chi = chi;
    }

    public List<Integer> getPen() {
        return pen;
    }

    public void setPen(List<Integer> pen) {
        this.pen = pen;
    }

    public List<Integer> getGang() {
        return gang;
    }

    public void setGang(List<Integer> gang) {
        this.gang = gang;
    }

    public List<Integer> getHand() {
        return hand;
    }

    public void setHand(List<Integer> hand) {
        this.hand = hand;
    }
}
