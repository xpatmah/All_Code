package com.org.application.domain;

public class PaymentTransaction {

	private String bankId;
	
	private Double amount;
	
	private Integer policyId;
	
	private Integer accountNo;
	
	private Integer paymentTxnId;
	
	private String status;
	
	private String reason;
	
	private String bankAccDsc;
	
	private String valueDate;
	
	private Integer ilBatchId;
	
	private Integer bankBatchId;
	
	private String entityResponseDate;
	
	private Double entityResponseAmount;
	
	
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public Integer getPaymentTxnId() {
		return paymentTxnId;
	}
	public void setPaymentTxnId(Integer paymentTxnId) {
		this.paymentTxnId = paymentTxnId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getBankAccDsc() {
		return bankAccDsc;
	}
	public void setBankAccDsc(String bankAccDsc) {
		this.bankAccDsc = bankAccDsc;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public Integer getIlBatchId() {
		return ilBatchId;
	}
	public void setIlBatchId(Integer ilBatchId) {
		this.ilBatchId = ilBatchId;
	}
	public Integer getBankBatchId() {
		return bankBatchId;
	}
	public void setBankBatchId(Integer bankBatchId) {
		this.bankBatchId = bankBatchId;
	}
	public String getEntityResponseDate() {
		return entityResponseDate;
	}
	public void setEntityResponseDate(String entityResponseDate) {
		this.entityResponseDate = entityResponseDate;
	}
	public Double getEntityResponseAmount() {
		return entityResponseAmount;
	}
	public void setEntityResponseAmount(Double entityResponseAmount) {
		this.entityResponseAmount = entityResponseAmount;
	}
}