import java.util.*;
class TaxCalculator{
	//---menu option input validation
	public static boolean isValidOption(String optionNum){
		char ch = optionNum.charAt(0);
		if(!(ch>48 && ch<=57 && optionNum.length()==1)){
			return false;
		}else{
			return true;
		}		
	}
	
	//--- [01] WITHHOLDING TAX
	public static void withHoldingTax(){
		Scanner input = new Scanner(System.in);
		L1:do{
			clearScreen();
			System.out.println("+---------------------------------------------+");
			System.out.println("|               WITHHOLDING TAX               |");
			System.out.println("+---------------------------------------------+\n");
			
			System.out.println("\t[1] Rent Tax\n");
			System.out.println("\t[2] Bank Interest Tax\n");
			System.out.println("\t[3] Divident Tax\n");
			System.out.println("\t[4] Exit Tax\n");
			
			System.out.print("Enter an option to continue -> ");
			String optionNum= input.next();
			
			if(!isValidOption(optionNum)){
				L2:do{							
					System.out.println("\tInvalid input...\n");
					System.out.print("Do you want to input option again (Y/N) -> ");
					char yesNo = input.next().charAt(0);
					if(yesNo=='Y' || yesNo=='y'){
						continue L1;
					}else if(yesNo=='N' || yesNo=='n'){
						break L1;
					}else{
						continue L2;
					}
				}while(true);
			}else{
				int op = Integer.parseInt(optionNum);
				switch(op){
					case 1 :
						rentTax(); break;
					case 2 :
						bankInterestTax(); break;
					case 3 :
						dividentTax(); break;
					case 4 :
						break L1;
					default : 
						L2:do{							
							System.out.println("\tInvalid input...\n");
							System.out.print("Do you want to input option again (Y/N) -> ");
							char yesNo = input.next().charAt(0);
							if(yesNo=='Y' || yesNo=='y'){
								continue L1;
							}else if(yesNo=='N' || yesNo=='n'){
								break L1;
							}else{
								continue L2;
							}
						}while(true);								
				}
			}
		}while(true);
	}
	
	//--- 1.1 RENT TAX
	public static void rentTax(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+---------------------------------------------+");
		System.out.println("|                  RENT TAX                   |");
		System.out.println("+---------------------------------------------+\n");
		
		System.out.print("Enter your rent : ");		
		double rentAmount = input.nextDouble();
		System.out.println();
		if(rentAmount<0){							
			System.out.println("\tInvalid input... enter correct value...");
		}else if(rentAmount<100000){
			System.out.println("\tYou dont have to pay Rent Tax...");
		}else{
			double rentTax = rentAmount*0.1;
			System.out.printf("You have to pay Rent Tax : %10.2f%n",rentTax);			
		}
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another Rent Tax (Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				rentTax();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}	
	
	//--- 1.2 BANK INTEREST TAX
	public static void bankInterestTax(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+---------------------------------------------+");
		System.out.println("|             BANK INTEREST TAX               |");
		System.out.println("+---------------------------------------------+\n");
		
		System.out.print("Enter your bank interest per year : ");		
		double interestAmount = input.nextDouble();
		System.out.println();
		if(interestAmount<0){
			System.out.println("\tInvalid input... enter correct value...");
		}else if(interestAmount==0){
			System.out.println("\tYou dont have to pay Bank Interest Tax...");
		}else{
			double interestTax = interestAmount*0.05;
			System.out.printf("You have to pay Bank Interest Tax per year : %10.2f%n",interestTax);
		}
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another Bank Interest Tax (Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				bankInterestTax();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}
	
	//--- 1.3 DIVIDENT TAX
	public static void dividentTax(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+---------------------------------------------+");
		System.out.println("|                 DIVIDENT TAX                |");
		System.out.println("+---------------------------------------------+\n");
		
		System.out.print("Enter your total divident per year : ");		
		double dividentAmount = input.nextDouble();
		System.out.println();
		if(dividentAmount<0){
			System.out.println("\tInvalid input... enter correct value...");
		}else if(dividentAmount<100000){
			System.out.println("\tYou dont have to pay Divident Tax...");
		}else{
			double dividentTax = dividentAmount*0.14;
			System.out.printf("You have to pay Divident Tax per year : %10.2f%n",dividentTax);			
		}
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another Divident Tax (Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				dividentTax();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}	
		
	//--- [02] PAYABLE TAX
	public static void payableTax(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+---------------------------------------------+");
		System.out.println("|                 PAYABLE TAX                 |");
		System.out.println("+---------------------------------------------+\n");
		
		System.out.print("Enter your employee payment per month : ");		
		double employeePayment = input.nextDouble();
		System.out.println();
		if(employeePayment<0){
			System.out.println("\tInvalid input... enter correct value...");
		}else if(employeePayment<=100000){
			System.out.println("\tYou dont have to pay Payable Tax...");
		}else{
			double payableTax = 0;
			if(employeePayment<=141667){
				payableTax = (employeePayment-100000)*0.06;				
			}else if(employeePayment<=183333){
				payableTax = (employeePayment-141667)*0.12+(141667-100000)*0.06;				
			}else if(employeePayment<=225000){
				payableTax = (employeePayment-183333)*0.18+(183333-141667)*0.12+(141667-100000)*0.06;				
			}else if(employeePayment<=266667){
				payableTax = (employeePayment-225000)*0.24+(225000-183333)*0.18+(183333-141667)*0.12+(141667-100000)*0.06;				
			}else if(employeePayment<=308333){
				payableTax = (employeePayment-266667)*0.30+(266667-225000)*0.24+(225000-183333)*0.18+(183333-141667)*0.12+(141667-100000)*0.06;				
			}else{
				payableTax = (employeePayment-308333)*0.36+(308333-266667)*0.30+(266667-225000)*0.24+(225000-183333)*0.18+(183333-141667)*0.12+(141667-100000)*0.06;								
			}			
			System.out.printf("You have to pay Payable Tax per month : %10.2f%n",(double)Math.round(payableTax));			
		}
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another Payable Tax (Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				payableTax();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}
	
	//--- [03] INCOME TAX
	public static void incomeTax(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+---------------------------------------------+");
		System.out.println("|                 INCOME TAX                  |");
		System.out.println("+---------------------------------------------+\n");
		
		System.out.print("Enter your total income per year : ");		
		double annualIncome = input.nextDouble();
		System.out.println();
		if(annualIncome<0){
			System.out.println("\tInvalid input... enter correct value...");
		}else if(annualIncome<=1200000){
			System.out.println("\tYou dont have to pay Income Tax...");
		}else{
			double incomeTax = 0;
			if(annualIncome<=1700000){
				incomeTax = (annualIncome-1200000)*0.06;				
			}else if(annualIncome<=2200000){
				incomeTax = (annualIncome-1700000)*0.12+(1700000-1200000)*0.06;				
			}else if(annualIncome<=2700000){
				incomeTax = (annualIncome-2200000)*0.18+(2200000-1700000)*0.12+(1700000-1200000)*0.06;					
			}else if(annualIncome<=3200000){
				incomeTax = (annualIncome-2700000)*0.24+(2700000-2200000)*0.18+(2200000-1700000)*0.12+(1700000-1200000)*0.06;					
			}else if(annualIncome<=3700000){
				incomeTax = (annualIncome-3200000)*0.30+(3200000-2700000)*0.24+(2700000-2200000)*0.18+(2200000-1700000)*0.12+(1700000-1200000)*0.06;					
			}else{
				incomeTax = (annualIncome-3700000)*0.36+(3700000-3200000)*0.30+(3200000-2700000)*0.24+(2700000-2200000)*0.18+(2200000-1700000)*0.12+(1700000-1200000)*0.06;					
			}			
			System.out.printf("You have to pay Income Tax per year : %10.2f%n",(double)Math.round(incomeTax));			
		}
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another Income Tax (Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				incomeTax();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}
	
	//--- [04] SSCL TAX
	public static void ssclTax(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+------------------------------------------------+");
		System.out.println("|  SOCIAL SECURITY CONTRIBUTION LEVY (SSCL) TAX  |");
		System.out.println("+------------------------------------------------+\n");
		
		System.out.print("Enter value of Good or Service : ");		
		double value = input.nextDouble();
		System.out.println();
		
		if(value<0){
			System.out.println("\tInvalid input... enter correct value...");
		}else{
			double saleTax = value*0.025;
			double vat = (value+saleTax)*0.15;
			double ssclTax = saleTax+vat;
			
			System.out.printf("You have to pay SSCL Tax : %10.2f%n",(double)Math.round(ssclTax));			
		}
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another SSCL Tax (Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				ssclTax();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}
	
	//--- [05] LEASING PAYMENT
	public static void leasingPayment(){
		Scanner input = new Scanner(System.in);
		L1:do{
			clearScreen();
			System.out.println("+---------------------------------------------+");
			System.out.println("|              LEASING PAYMENT                |");
			System.out.println("+---------------------------------------------+\n");
			
			System.out.println("\t[1] Calculate Monthly Installment\n");
			System.out.println("\t[2] Search Leasing Category\n");
			System.out.println("\t[3] Find Leasing Amount\n");
			System.out.println("\t[4] Exit Tax\n");
			
			System.out.print("Enter an option to continue -> ");
			String optionNum= input.next();
			
			if(!isValidOption(optionNum)){
				L2:do{							
					System.out.println("\tInvalid input...\n");
					System.out.print("Do you want to input option again (Y/N) -> ");
					char yesNo = input.next().charAt(0);
					if(yesNo=='Y' || yesNo=='y'){
						continue L1;
					}else if(yesNo=='N' || yesNo=='n'){
						break L1;
					}else{
						continue L2;
					}
				}while(true);
			}else{
				int op = Integer.parseInt(optionNum);
				switch(op){
					case 1 :
						calculateMonthlyInstallment(); break;
					case 2 :
						searchLeasingCategory(); break;
					case 3 :
						findLeasingAmount(); break;
					case 4 :
						break L1;
					default : 
						L2:do{							
							System.out.println("\tInvalid input...\n");
							System.out.print("Do you want to input option again (Y/N) -> ");
							char yesNo = input.next().charAt(0);
							if(yesNo=='Y' || yesNo=='y'){
								continue L1;
							}else if(yesNo=='N' || yesNo=='n'){
								break L1;
							}else{
								continue L2;
							}
						}while(true);								
				}
			}
		}while(true);
	}

	//--- 5.1 Calculate Monthly Installment
	public static void calculateMonthlyInstallment(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|                Calculate Leasing Payment                |");
		System.out.println("+---------------------------------------------------------+");
		
		L1:do{
			System.out.println();
			System.out.print("Enter lease amount           : ");		
			double leaseAmount = input.nextDouble();	
			
			if(leaseAmount<0){
				System.out.println();
				System.out.println("\tInvalid lease amount input...Enter the correct value again");
				continue L1;
			}else{
				L2:do{
					System.out.println();
					System.out.print("Enter annual interest rate  : ");	
					double interestRate = input.nextDouble();
					
					if(interestRate<=0 || interestRate>100){	
						System.out.println();				
						System.out.println("\tInvalid interest rate input...Enter the correct value again");
						continue L2;
					}else{
						L3:do{
							System.out.println();
							System.out.print("Enter number of years  (1-5)  : ");	
							int years = input.nextInt();
							System.out.println();
							if(years<=0||years>5){	
								System.out.println("\tInvalid number of years...Enter the correct value again");
								continue L3;
							}else{
								int n = years*12;
								double i = interestRate/100.0/12.0;
								double monthlyInstallment = leaseAmount*i/(1-(1/Math.pow((1+i),n)));
								System.out.printf("Your monthly installment : %10.2f%n",monthlyInstallment);			
							}
							break;
						}while(true);
					}
					break;					
				}while(true);				
			}
			break;
		}while(true);		
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another monthly installment(Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				calculateMonthlyInstallment();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}

	//--- 5.2 Search Leasing Category
	public static void searchLeasingCategory(){
	Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+----------------------------------------------------------+");
		System.out.println("|                 Search Leasing Payment                   |");
		System.out.println("+----------------------------------------------------------+");
		
		L1:do{
			System.out.println();
			System.out.print("Enter lease amount       : ");		
			double leaseAmount = input.nextDouble();	
			
			if(leaseAmount<0){
				System.out.println();
				System.out.println("\tInvalid lease amount input...Enter the correct value again");
				continue L1;
			}else{
				L2:do{
					System.out.println();
					System.out.print("Enter annual interest rate : ");	
					double interestRate = input.nextDouble();
					
					if(interestRate<=0 || interestRate>100){	
						System.out.println();				
						System.out.println("\tInvalid interest rate input...Enter the correct value again");
						continue L2;
					}else{		
						int years=3;				
						int n = years*12;
						double i = interestRate/100.0/12.0;
						double monthlyInstallmentfor3y = leaseAmount*i/(1-(1/Math.pow((1+i),n)));
						years=4;
						n = years*12;
						double monthlyInstallmentfor4y = leaseAmount*i/(1-(1/Math.pow((1+i),n)));
						years=5;
						n = years*12;
						double monthlyInstallmentfor5y = leaseAmount*i/(1-(1/Math.pow((1+i),n)));
						System.out.println();
						System.out.printf("Your monthly installment : %10.2f%n",monthlyInstallmentfor3y);	
						System.out.printf("Your monthly installment : %10.2f%n",monthlyInstallmentfor4y);	
						System.out.printf("Your monthly installment : %10.2f%n",monthlyInstallmentfor5y);						
					}
					break;					
				}while(true);				
			}
			break;
		}while(true);		
		do{	
			System.out.println();						
			System.out.print("Do you want to Search another Leasing Category (Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				searchLeasingCategory();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}
	//--- 5.3 Find Leasing Amount()
	public static void findLeasingAmount(){
		Scanner input = new Scanner(System.in);
		clearScreen();
		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("|                          Find Leasing Amount                         |");
		System.out.println("+----------------------------------------------------------------------+");
		
		L1:do{
			System.out.println();
			System.out.print("Enter the monthly lease payment amount you can afford : ");		
			double monthlyInstallment = input.nextDouble();	
			
			if(monthlyInstallment<=0){
				System.out.println();
				System.out.println("\tInvalid monthly lease payment amount input...Enter the correct value again");
				continue L1;
			}else{
				L2:do{
					System.out.println();
					System.out.print("Enter number of years  (1-5)                          : ");	
					int years = input.nextInt();
					if(years<=0||years>5){						
						System.out.println();
						System.out.println("\tInvalid number of years...Enter the correct value again");
						continue L2;										
					}else{
						L3:do{
							System.out.println();
							System.out.print("Enter annual interest rate                            : ");	
							double interestRate = input.nextDouble();							
							if(interestRate<=0 || interestRate>100){	
								System.out.println();				
								System.out.println("\tInvalid interest rate input...Enter the correct value again");
								continue L3;
							}else{
								int n = years*12;
								double i = interestRate/100.0/12.0;								
								double leaseAmount = monthlyInstallment*(1-(1/Math.pow((1+i),n)))/i;
								System.out.println();
								System.out.printf("You can get lease amount                              : %10.2f%n",(double)Math.round(leaseAmount));			
							}
							break;
						}while(true);
					}
					break;					
				}while(true);				
			}
			break;
		}while(true);		
		do{	
			System.out.println();						
			System.out.print("Do you want to calculate another monthly installment(Y/N) -> ");
			  char yesNo = input.next().charAt(0);
			if(yesNo=='Y' || yesNo=='y'){
				findLeasingAmount();
				break;
			}else if(yesNo=='N' || yesNo=='n'){
				break;
			}else{
				System.out.println();
				System.out.println("\tInvalid input...");
				continue;
			}
		}while(true);
	}
	
	//=== *** MAIN METHOD *** ===
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		L1:do{
			clearScreen();
			String icetStr = " __   ______   _____" + "___  ________ \r\n" + "|  \\ /      \\ |   " + "     \\|        \\\r" + "\n" +  " \\$$|  $$$$$$\\| $$" + "$$$$$$ \\$$$$$$$$\r" + "\n" + "|  \\| $$   \\$$| $$" + "__       | $$   \r\n" + "| $$| $$      | $$  " + "\\      | $$   \r\n" + "| $$| $$   __ | $$$$" + "$      | $$   \r\n" + "| $$| $$__/  \\| $$_" + "____    | $$   \r\n" + "| $$ \\$$    $$| $$ " + "    \\   | $$   \r\n" + " \\$$  \\$$$$$$  \\$" + "$$$$$$$    \\$$   \r" + "\n";		
			String taxCalculatorStr =" _____ ___  __   __ " +  " _____   ___   _    " + " _____ _   _ _      " + " ___ _____ _________" + "__ \r\n" + "|_   _/ _ \\ \\ \\ /" + " / /  __ \\ / _ \\ |" + " |   /  __ \\ | | | " + "|     / _ \\_   _|  " + "_  | ___ \\\r\n" + "  | |/ /_\\ \\ \\ V " + "/  | /  \\// /_\\ \\" + "| |   | /  \\/ | | |" + " |    / /_\\ \\| | |" + " | | | |_/ /\r\n" + "  | ||  _  | /   \\ " + " | |    |  _  || |  " + " | |   | | | | |    " + "|  _  || | | | | |  " + "  / \r\n" + "  | || | | |/ /^\\ " + "\\ | \\__/\\| | | ||" + " |___| \\__/\\ |_| |" + " |____| | | || | \\ " + "\\_/ / |\\ \\ \r\n" + "  \\_/\\_| |_/\\/   " + "\\/  \\____/\\_| |_/" + "\\_____/\\____/\\___" + "/\\_____/\\_| |_/\\_" + "/  \\___/\\_| \\_| ";
			System.out.println(icetStr);
			System.out.println(taxCalculatorStr);
			System.out.println();
			System.out.println("====================================================================================\n");
			System.out.println("\t[1] Withholding Tax\n");
			System.out.println("\t[2] Payable Tax\n");
			System.out.println("\t[3] Income Tax\n");
			System.out.println("\t[4] Social Security Contribution Levy(SSCL) Tax\n");
			System.out.println("\t[5] Leasing Payment\n");
			System.out.println("\t[6] Exit");
			System.out.println();
			System.out.print("Enter an option to continue -> ");
			String optionNum = input.next();
			
			if(!isValidOption(optionNum)){
				L2:do{							
					System.out.println("\tInvalid input...\n");
					System.out.print("Do you want to input option again (Y/N) -> ");
					char yesNo = input.next().charAt(0);
					if(yesNo=='Y' || yesNo=='y'){
						continue L1;
					}else if(yesNo=='N' || yesNo=='n'){
						clearScreen();
						System.out.println("----Program end----");
						break L1;
					}else{
						continue L2;
					}
				}while(true);
			}else{
				int op = Integer.parseInt(optionNum);
				switch(op){
					case 1 :
						withHoldingTax(); break;
					case 2 :
						payableTax(); break;
					case 3 :
						incomeTax(); break;
					case 4 :
						ssclTax(); break;
					case 5 :
						leasingPayment(); break;
					case 6 :
						clearScreen();
						System.out.println("----Program end----");
						break L1;
					default : 
						L2:do{							
							System.out.println("\tInvalid input...\n");
							System.out.print("Do you want to input option again (Y/N) -> ");
							char yesNo = input.next().charAt(0);
							if(yesNo=='Y' || yesNo=='y'){
								continue L1;
							}else if(yesNo=='N' || yesNo=='n'){
								clearScreen();
								System.out.println("----Program end----");
								break L1;
							}else{
								continue L2;
							}
						}while(true);								
				}
			}
		}while(true);		
	}
	
	//--- clearScreen
	public static void clearScreen(){
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[2J\033[H");
				System.out.flush();
			}
		}catch (final Exception e){
			e.printStackTrace();
			// Handle any exceptions.
		}
    }
}

