package com.fabiolux.gbot.api.apiModels.braziliex;

public class Currency
{
    private String minDeposit;
    private String is_withdrawal_active;
    private String MinWithdrawal;
    private String is_deposit_active;
    private String under_maintenance;
    private String txDepositFee;
    private String decimal_withdrawal;
    private String decimal;
    private String order;
    private String txWithdrawalMinFee;
    private String name;
    private String dev_active;
    private String active;
    private String minAmountTrade;
    private String minConf;
    private String txDepositPercentageFee;
    private String txWithdrawalFee;

    public String getMinDeposit ()
    {
        return minDeposit;
    }

    public void setMinDeposit (String minDeposit)
    {
        this.minDeposit = minDeposit;
    }

    public String getIs_withdrawal_active ()
    {
        return is_withdrawal_active;
    }

    public void setIs_withdrawal_active (String is_withdrawal_active)
    {
        this.is_withdrawal_active = is_withdrawal_active;
    }

    public String getMinWithdrawal ()
    {
        return MinWithdrawal;
    }

    public void setMinWithdrawal (String MinWithdrawal)
    {
        this.MinWithdrawal = MinWithdrawal;
    }

    public String getIs_deposit_active ()
    {
        return is_deposit_active;
    }

    public void setIs_deposit_active (String is_deposit_active)
    {
        this.is_deposit_active = is_deposit_active;
    }

    public String getUnder_maintenance ()
    {
        return under_maintenance;
    }

    public void setUnder_maintenance (String under_maintenance)
    {
        this.under_maintenance = under_maintenance;
    }

    public String getTxDepositFee ()
    {
        return txDepositFee;
    }

    public void setTxDepositFee (String txDepositFee)
    {
        this.txDepositFee = txDepositFee;
    }

    public String getDecimal_withdrawal ()
    {
        return decimal_withdrawal;
    }

    public void setDecimal_withdrawal (String decimal_withdrawal)
    {
        this.decimal_withdrawal = decimal_withdrawal;
    }

    public String getDecimal ()
    {
        return decimal;
    }

    public void setDecimal (String decimal)
    {
        this.decimal = decimal;
    }

    public String getOrder ()
    {
        return order;
    }

    public void setOrder (String order)
    {
        this.order = order;
    }

    public String getTxWithdrawalMinFee ()
    {
        return txWithdrawalMinFee;
    }

    public void setTxWithdrawalMinFee (String txWithdrawalMinFee)
    {
        this.txWithdrawalMinFee = txWithdrawalMinFee;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDev_active ()
    {
        return dev_active;
    }

    public void setDev_active (String dev_active)
    {
        this.dev_active = dev_active;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public String getMinAmountTrade ()
    {
        return minAmountTrade;
    }

    public void setMinAmountTrade (String minAmountTrade)
    {
        this.minAmountTrade = minAmountTrade;
    }

    public String getMinConf ()
    {
        return minConf;
    }

    public void setMinConf (String minConf)
    {
        this.minConf = minConf;
    }

    public String getTxDepositPercentageFee ()
    {
        return txDepositPercentageFee;
    }

    public void setTxDepositPercentageFee (String txDepositPercentageFee)
    {
        this.txDepositPercentageFee = txDepositPercentageFee;
    }

    public String getTxWithdrawalFee ()
    {
        return txWithdrawalFee;
    }

    public void setTxWithdrawalFee (String txWithdrawalFee)
    {
        this.txWithdrawalFee = txWithdrawalFee;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [minDeposit = "+minDeposit+", is_withdrawal_active = "+is_withdrawal_active+", MinWithdrawal = "+MinWithdrawal+", is_deposit_active = "+is_deposit_active+", under_maintenance = "+under_maintenance+", txDepositFee = "+txDepositFee+", decimal_withdrawal = "+decimal_withdrawal+", decimal = "+decimal+", order = "+order+", txWithdrawalMinFee = "+txWithdrawalMinFee+", name = "+name+", dev_active = "+dev_active+", active = "+active+", minAmountTrade = "+minAmountTrade+", minConf = "+minConf+", txDepositPercentageFee = "+txDepositPercentageFee+", txWithdrawalFee = "+txWithdrawalFee+"]";
    }
}
