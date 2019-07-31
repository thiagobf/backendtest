package com.backendtest_final;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  

@Path("/AccountService") 
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)

public class AccountService 
{
	Account acct = new Account();
	
	@Path("/createAccount")
    public AccountResponse createAccount(@PathParam("account") String account, @PathParam("amount") float amount) 
	{
		AccountResponse response = new AccountResponse();
		acct.CreateAccount(account, amount);
		
		response.setStatus(true);
		response.setMessage("Account created!");
		
		return response;
	}

	@Path("/tranferFunds")
	public AccountResponse transferFunds(@PathParam("sourceaccount") String sourceaccount, @PathParam("destinationaccount") String destinationaccount, @PathParam("amount") float amount))
	{
		AccountResponse response = new AccountResponse();
		acct.transferFunds(sourceaccount, destinationaccount, amount);
		response.setStatus(true);
		response.setMessage("Transfer succesfully executed!");
	}
	@GET
	@PATH("{account}/getAccountMovement")
	public AccountResponse getAccountMovement(@PathParam("account") String account)
	{
		AccountResponse response = new AccountResponse();
		response.setStatus(true);
		response.setMessage(acct.getAccountMovement(account));
	}
}
