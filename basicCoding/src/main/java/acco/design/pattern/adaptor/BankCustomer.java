package acco.design.pattern.adaptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements Client{ 

	@Override
	public void giveBankDetails() throws IOException{
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Enter the Name \\ n");
			setName(reader.readLine());
			System.out.println("Enter the Account No \\n");
			setAccountNo(Long.parseLong(reader.readLine()));
			System.out.println("Set Account Balance \\n");
			setAccountNo(Long.parseLong(reader.readLine()));
		}catch(Exception e) {}
	}
	
	@Override
	public String getBankDetails() {
		// TODO Auto-generated method stub
		return "Customer Name"+getName()+" Account no "+getAccountNo()+" Accont Balance " + getAcountBalance();
	}

}
