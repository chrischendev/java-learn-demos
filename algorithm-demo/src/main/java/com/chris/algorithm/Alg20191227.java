package com.chris.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/12/27 20:17
 * Use for: 房贷计算
 */
public class Alg20191227 {
    public static void main(String[] args) {
        testDebj(120000, 0.5, 12).show();
        //testDebx(120000, 5, 12);
    }

    /**
     * 等额本金
     *
     * @param principal 贷款本金总额
     * @param rate      月利率百分数
     * @param months    期数
     * @return 还款信息
     */
    private static RepaymentInfo testDebj(int principal, double rate, int months) {
        //剩余本金
        int balance = principal;
        //分期归还本金
        double repaymentPrincipal = principal / months;
        //利息累计
        double interestTotal = 0;

        List<InstallmentDetail> detailsList = new ArrayList<InstallmentDetail>(16);
        for (int i = 0; i < months; i++) {
            //构建分期还款详情
            InstallmentDetail installmentDetail = new InstallmentDetail();
            installmentDetail.id = i + 1;
            installmentDetail.principal = balance;//还款之前的本金
            installmentDetail.rate = rate;
            installmentDetail.repaymentPrincipal = repaymentPrincipal;
            //归还利息 先计算
            double interest = balance * rate / 100;
            //归还本金
            balance -= repaymentPrincipal;
            installmentDetail.balance = balance;//还款之后的本金
            //累计利息
            interestTotal += interest;
            installmentDetail.interest = interest;
            installmentDetail.repaymentTotal = repaymentPrincipal + interest;

            detailsList.add(installmentDetail);
        }
        //构建还款信息
        return RepaymentInfo.create(principal, rate, months, detailsList, principal + interestTotal, interestTotal);
    }

    /**
     * 等额本息
     *
     * @param principal 贷款本金总额
     * @param rate      月利率百分数
     * @param months    期数
     */
    private static void testDebx(int principal, double rate, int months) {

    }
}

/**
 * 还款信息
 */
class RepaymentInfo {
    public int principal;//贷款总额
    public double rate;//月利率百分数
    public int months;//贷款期数
    public List<InstallmentDetail> detailList;//分期还款详情
    public double total;//还款总额
    public double interestTotle;//利息总额

    public RepaymentInfo() {
    }

    public static RepaymentInfo create(int principal, double rate, int months, List<InstallmentDetail> detailList, double total, double interestTotal) {
        RepaymentInfo repaymentInfo = new RepaymentInfo();
        repaymentInfo.principal = principal;
        repaymentInfo.rate = rate;
        repaymentInfo.months = months;
        repaymentInfo.detailList = detailList;
        repaymentInfo.total = total;
        repaymentInfo.interestTotle = interestTotal;
        return repaymentInfo;
    }

    public void show() {
        System.out.println("你共贷款 " + principal + " 元");
        System.out.println("贷款 " + months + " 期");
        System.out.println("每期利率 " + rate + "%");
        System.out.println("还款总额 " + total + " 元");
        System.out.println("共支付利息 " + interestTotle + " 元");
        System.out.println("以下是分期还款详情：");
        for (InstallmentDetail detail : detailList) {
            System.out.print("    ");
            detail.show();
            System.out.println();
        }
    }
}

/**
 * 分期还款详情
 */
class InstallmentDetail {
    public int id;//本期
    public double principal;//本期本金
    public double repaymentPrincipal;//本期归还本金
    public double balance;//本期剩余本金
    public double interest;//本期归还的利息
    public double repaymentTotal;//本期归还总额
    public double rate;//本期适用的月利率百分数 应对调息 此处暂无用处

    public InstallmentDetail() {
    }

    public static InstallmentDetail create(int id, double principal, double repaymentPrincipal, double balance, double interest, double repaymentTotal) {
        InstallmentDetail installmentDetail = new InstallmentDetail();
        installmentDetail.id = id;
        installmentDetail.principal = principal;
        installmentDetail.repaymentPrincipal = repaymentPrincipal;
        installmentDetail.balance = balance;
        installmentDetail.interest = interest;
        installmentDetail.repaymentTotal = repaymentTotal;
        return installmentDetail;
    }

    public void show() {
        System.out.print("第 " + id + " 期共还款 " + repaymentTotal + " 元，其中包含本金 " + repaymentPrincipal + " 元，利息 " + interest + "元，剩余本金 "+balance+" 元");
    }
}