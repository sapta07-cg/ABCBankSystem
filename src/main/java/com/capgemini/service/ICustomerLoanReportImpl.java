package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.CustomerLoanRequest;
import com.capgemini.entities.LoanProgram;
import com.capgemini.entities.LoanStatus;
import com.capgemini.exception.CustomerLoanRequestNotFoundException;
import com.capgemini.repository.CustomerLoanRequestRepository;
import com.capgemini.repository.LoanProgramRepository;
import com.capgemini.repository.LoanStatusRepository;

@Service
public class ICustomerLoanReportImpl implements ICustomerLoanReport {

	@Autowired
	CustomerLoanRequestRepository customerLoanRequestRepository;

	@Autowired
	LoanProgramRepository loanprogramRepository;
	
	@Autowired
	LoanStatusRepository loanstatusRepository;

	@Override
	public String hello(int id) {

		if (!customerLoanRequestRepository.existsById(id)) {
			throw new CustomerLoanRequestNotFoundException("Check the id and Try again");
		}

		CustomerLoanRequest ld = customerLoanRequestRepository.findById(id).get();
		//LoanProgram lp = loanprogramRepository.findById(loanid).get();
		//LoanStatus ls = loanstatusRepository.findById(statusid).get();
		LoanStatus ls=new LoanStatus();
		
		
		
		double loanamount = 0.0;
		double emi = 0.0;
		double tenure = 0;
		
		
		if ((ld.getAge() > 20 || ld.getAge() <= 60) && (ld.getAnnualincome() < 300000)) {
			return "You are not eligible for loan";
		}
		else {
		

		/*-------------------------------- this whole condition is for HOME LOAN---------------------------------------------*/
		
		
         
		if (ld.getLoantype().equals("home") ){
			//if ((ld.getAge() > 20 || ld.getAge() <= 60) && (ld.getAnnualincome() < 300000)) {
				//return "You are not eligible for loan";
			//}

			// age group for 20-30

			 if (ld.getAge() >= 20 && ld.getAge() <= 30) {
				double intrate = 6.0 / 12 / 100;
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 500000) {
					loanamount = 1500000;
					tenure = (60 - (ld.getAge()));
					emi = (loanamount * intrate) * Math.pow(1 + intrate, tenure) / (Math.pow(1 + intrate, tenure - 1));

				} else if (ld.getAnnualincome() > 500000 && ld.getAnnualincome() <= 1000000) {
					loanamount = 3000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 1000000) {
					loanamount = 5000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}

			}

			// age group for 30-50

			else if (ld.getAge() > 30 && ld.getAge() <= 50) {
				double intrate = 8.0 / 12 / 100;
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 500000) {
					loanamount = 1200000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 500000 && ld.getAnnualincome() <= 1000000) {
					loanamount = 2500000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 1000000) {
					loanamount = 4500000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}

			}

			// age group for 50-60

			else if (ld.getAge() > 50 && ld.getAge() < 60) {
				double intrate = 10.0 / 12 / 100;
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 500000) {
					loanamount = 1000000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 500000 && ld.getAnnualincome() <= 1000000) {
					loanamount = 2000000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 1000000) {
					loanamount = 4000000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}

			}
		}

		/*--------------------------------- HOME LOAN condition end------------------------------------------------------------*/
		
		

		/*------------------------------this condition is for PERSONAL LOAN-------------------------------------------------*/

		else if (ld.getLoantype().equals("personal") ){
			//if ((ld.getAge() > 20 || ld.getAge() <= 60) && (ld.getAnnualincome() < 300000)) {
				//return "You are not eligible for loan";
			//}

			// age group for 20-30

			 if (ld.getAge() >= 20 && ld.getAge() <= 30) {
				double intrate = 9.0 / 12 / 100;
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 500000) {
					loanamount = 1500000;
					tenure = (60 - (ld.getAge()));
					emi = (loanamount * intrate) * Math.pow(1 + intrate, tenure) / (Math.pow(1 + intrate, tenure - 1));

				} else if (ld.getAnnualincome() > 500000 && ld.getAnnualincome() <= 1000000) {
					loanamount = 3000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 1000000) {
					loanamount = 5000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}

			}

			// age group for 30-50

			else if (ld.getAge() > 30 && ld.getAge() <= 50) {
				double intrate = 12.0 / 12 / 100;
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 500000) {
					loanamount = 1200000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 500000 && ld.getAnnualincome() <= 1000000) {
					loanamount = 2500000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 1000000) {
					loanamount = 4500000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}

			}

			// age group for 50-60

			else if (ld.getAge() > 50 && ld.getAge() < 60) {
				double intrate = 17.0 / 12 / 100;
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 500000) {
					loanamount = 1000000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 500000 && ld.getAnnualincome() <= 1000000) {
					loanamount = 2000000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} else if (ld.getAnnualincome() > 1000000) {
					loanamount = 4000000;
					tenure = (60 - ld.getAge());
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}

			}

		}
		/*-------------------------------------------- end of PERSONAL LOAN------------------------------------------------*/
		
		
		/*-------------------------------------------start BUSINESS LOGIC---------------------------------------------*/
		else if(ld.getLoantype().equals("business")){
			//if((ld.getAge() > 20 || ld.getAge() <= 60) && (ld.getAnnualincome() < 300000)) {
				//return "You are not eligible for loan";				
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 500000) {
					double intrate = 5.0 / 12 / 100;
					loanamount = 700000;
					tenure = (60 - (ld.getAge()));
					emi = (loanamount * intrate) * Math.pow(1 + intrate, tenure) / (Math.pow(1 + intrate, tenure - 1));

				}
				else if (ld.getAnnualincome() > 500000 && ld.getAnnualincome() <= 1500000) {
					double intrate = 6.0 / 12 / 100;
					loanamount = 2500000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} 
				else if (ld.getAnnualincome() > 1500000 && ld.getAnnualincome() <= 3000000) {
					double intrate = 7.0 / 12 / 100;
					loanamount = 4000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}
				else if (ld.getAnnualincome() > 3000000) {
					double intrate = 10.0 / 12 / 100;
					loanamount = 6000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}
			}
			
		
		/*---------------------------------------------end BUISNESS LOAN logic---------------------------------------*/
		
		
		 /*---------------------------------------this condition is for CAR LOAN--------------------------------------*/
		else if(ld.getLoantype().equals("car")) {
			//if((ld.getAge() > 20 || ld.getAge() <= 60) && (ld.getAnnualincome() < 300000)) {
				//return "You are not eligible for loan";				
			//}
				if (ld.getAnnualincome() > 300000 && ld.getAnnualincome() <= 800000) {
					double intrate = 9.0 / 12 / 100;
					loanamount = 700000;
					tenure = (60 - (ld.getAge()));
					emi = (loanamount * intrate) * Math.pow(1 + intrate, tenure) / (Math.pow(1 + intrate, tenure - 1));

				}
				else if (ld.getAnnualincome() > 800000 && ld.getAnnualincome() <= 1500000) {
					double intrate = 8.0 / 12 / 100;
					loanamount = 2500000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				} 
				else if (ld.getAnnualincome() > 1500000 && ld.getAnnualincome() <= 3000000) {
					double intrate = 7.0 / 12 / 100;
					loanamount = 4000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}
				else if (ld.getAnnualincome() > 3000000) {
					double intrate = 6.0 / 12 / 100;
					loanamount = 6000000;
					tenure = ((60 - ld.getAge()));
					emi = (loanamount * intrate * Math.pow(1 + intrate, tenure)) / (Math.pow(1 + intrate, tenure - 1));
				}
			}
		ls.setCustomerloantype(ld.getLoantype());
		ls.setCustomerrefid(ld.getId());
		ls.setEmi(emi);
		ls.setLoanamount(loanamount);
		loanstatusRepository.save(ls);

		return "your loan amount is" + " " + Double.toString(loanamount) + "              " + "your tenure is" + " "
				+ Double.toString(tenure) + "years" + "     " + " your emi is " + "   " + Double.toString(emi);
		}
		
		
	}
	
	
	
	
	//FIND ALL RECORD FROM LOAN STATUS TABLE
	public List<LoanStatus> findallrecord(){
		return loanstatusRepository.findAll();
		
	}
	
	
	
	
	
}
