package Assignment_1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ePortfolio {
	private static ArrayList<Stock> stockList;
	private static ArrayList<MutualFund> mutualFundList;

	Stock stock = new Stock();
	MutualFund mutualFund = new MutualFund();

	//Getters and setters
	public ePortfolio(){
		stockList = new ArrayList<>();
		mutualFundList = new ArrayList<>();
	}
	public static ArrayList<Stock> getStockList(){
		return stockList;
	}
	public ArrayList<MutualFund> getMutualFundList(){
		return mutualFundList;
	}

	//Adding elemnets to the lists
	public void addElement(Stock elementStock){
		stockList.add(elementStock);
	}
	public void addElement(MutualFund elementMutualFund){
		mutualFundList.add(elementMutualFund);
	}

	// To String methods for both lists
	public static void toStringStock(Stock elementStock, String transaction){
		System.out.println("Name: " + elementStock.getName());
		System.out.println("Symbol: " + elementStock.getSymbol().toUpperCase());
		System.out.println("Quantity: " + elementStock.getQuantity());
		System.out.println("Price: " + elementStock.getPrice());
		if (transaction.toLowerCase().equals("buy")){
			System.out.println("Book Value: " + elementStock.getBookValue() + "\n");
		}else if (transaction.toLowerCase().equals("sell")) {
			System.out.println("Payment Recieved: " + elementStock.paymentRecieved() + "\n");
			System.out.println("Book Value: " + elementStock.getBookValue() + "\n");
		}
	}
	public void toStringMutualFunds(MutualFund elementMutualFuns, String transaction){
		System.out.println("Name: " + elementMutualFuns.getName());
		System.out.println("Symbol: " + elementMutualFuns.getSymbol().toUpperCase());
		System.out.println("Quantity: " + elementMutualFuns.getQuantity());
		System.out.println("Price: " + elementMutualFuns.getPrice());
		if (transaction.toLowerCase().equals("buy")){
			System.out.println("Book Value: " + elementMutualFuns.getBookValue() + "\n");
		}else if (transaction.toLowerCase().equals("sell")) {
			System.out.println("Payment Recieved: " + elementMutualFuns.paymentRecieved() + "\n");
			System.out.println("Book Value: " + elementMutualFuns.getBookValue() + "\n");
		}
	}

	//Diplay the whole list
	public void displayList(String list, String transaction) {
		if (list.toLowerCase().equals("stock")) {
			for (int i = 0; i < getStockList().size(); i++) {
				toStringStock(stockList.get(i), transaction);
			}
		}
		if (list.toLowerCase().equals("mutualfund") || list.toLowerCase().equals("mutual Fund")) {
			for (int i = 0; i < getMutualFundList().size(); i++) {
				toStringMutualFunds(mutualFundList.get(i), transaction);
			}
		}
	}
	
	public void searchDigitsInStock(String input, Stock i) {
		double lowerBound = 0;
		double upperBound = 0;
		if (input.matches("\\d+")) { // 15.00
			lowerBound = Double.parseDouble(input);
		} else if (input.matches("\\d+-")) { //15.00-
			System.out.println(input + " matches 'number-'");
		} else if (input.matches("-\\d+")) { //-15.00
			System.out.println(input + " matches '-number'");
		} else if (input.matches("\\d+-\\d+")) { //15.00-20.00
			System.out.println(input + " matches 'number-number'");
		} else {
			System.out.println(input + " does not match any pattern");
		}
    }

		// if (searchStrings.contains("-")) {
		// 	String[] tokens = searchStrings.split("-");
		// 	if (tokens.length > 2) {
		// 		System.err.println("Price range search can only take lower and upper bound");
		// 	}else {
		// 		try {
		// 			if (tokens[0].trim().isEmpty()){
		// 				upperBound = 0;
		// 			}else {
		// 				upperBound = Double.parseDouble(tokens[0]);
		// 			}
		// 			if (tokens[1].trim().isEmpty()){
		// 				lowerBound = 0;
		// 			}else {
		// 				lowerBound = Double.parseDouble(tokens[1]);
		// 			}
		// 		} catch (NumberFormatException e) {
		// 			System.err.println("Price given is not a valid number");
		// 		}
		// 	}
		// 	if ((stock.getPrice() > lowerBound) && (stock.getPrice() < upperBound)) {
		// 		toStringStock(i, "buy");
		// 	}
		// }else {
		// 	double digit = Double.parseDouble(searchStrings);
		// 	if (stock.getPrice() == digit) {
		// 		toStringStock(i, "buy");
		// 	}
		// }

	public void searchDigitsInMutualFunds(String searchStrings, MutualFund i) {
		double upperBound = 0;
		double lowerBound = 0;
		
		if (searchStrings.contains("-")) {
			String[] tokens = searchStrings.split("-");
			if (tokens.length > 2) {
				System.err.println("Price range search can only take lower and upper bound");
			}else {
				try {
					if (tokens[0].trim().isEmpty()){
						upperBound = 0;
					}else {
						upperBound = Double.parseDouble(tokens[0]);
					}
					if (tokens[1].trim().isEmpty()){
						lowerBound = 0;
					}else {
						lowerBound = Double.parseDouble(tokens[1]);
					}
				} catch (NumberFormatException e) {
					System.err.println("Price given is not a valid number");
				}
			}
			if ((mutualFund.getPrice() > lowerBound) && (mutualFund.getPrice() < upperBound)) {
				toStringMutualFunds(i, "buy");
			}
		}else {
			double digit = Double.parseDouble(searchStrings);
			if (mutualFund.getPrice() == digit) {
				toStringMutualFunds(i, "buy");
			}
		}
	}

	public void search(ArrayList<String> searchStrings) {
		
		if (searchStrings.size() > 4) {
			System.err.println("A search request can take only three fields, Please try again!");		
		}else {
			for (String elements : searchStrings) {
				boolean hasDigits = elements.matches(".*\\d.*");
				for (int i = 0; i < stockList.size(); i++) {
					if (elements.toUpperCase().equals(stockList.get(i).getSymbol())) {
						toStringStock(stockList.get(i), "buy");
					}else if (stockList.get(i).getName().contains(elements)) {
						toStringStock(stockList.get(i), "buy");
					}
					else if(hasDigits) {
						searchDigitsInStock(elements, stockList.get(i));
					}
				}
				for (int i = 0; i < mutualFundList.size(); i++) {
					if (elements.toUpperCase().equals(mutualFundList.get(i).getSymbol())) {
						toStringMutualFunds(mutualFundList.get(i), "buy");
					}else if (mutualFundList.get(i).getName().contains(elements)) {
						toStringMutualFunds(mutualFundList.get(i), "buy");
					}
					else if(hasDigits) {
						searchDigitsInMutualFunds(elements, mutualFundList.get(i));
					}
				}

			}
		}
	}

	// methods(stock)
	public void buyStock(String name, String symbol, double price, double quantity)
    {
		boolean inStock = false;
		for (int i = 0; i <= getStockList().size(); i++)
		{
            inStock = symbol.toLowerCase().equals(stock.getSymbol());
		}
		if (inStock) {
			double beforePurchase = stock.getBookValue();
			stock.setPrice(price);
			stock.setQuantity(quantity);
			stock.gain(beforePurchase, stock.findBookValue(price));
		}else {
			double beforePurchase = stock.getBookValue();
			stock.setName(name);
			stock.setSymbol(symbol);
			stock.setPrice(price);
			stock.setQuantity(quantity);
			stock.gain(beforePurchase, stock.findBookValue(price));
			addElement(stock);
		}
		
		toStringStock(stock, "buy");
		System.out.println(stock.getSymbol().toUpperCase() + " successfully  bought.");

	}
	public void sellStock(String symbol, double price, double quantity)
    {
		boolean stockAvailable = false;
		for (int i = 0; i <= getStockList().size(); i++)
		{
			if (symbol.toLowerCase().equals(stock.getSymbol()))
			{
				if (stock.getQuantity() == 0) {
					System.out.println(stock.getSymbol().toUpperCase() + " is not enough");
				}
				else {
					stockAvailable = true;
				}
			}
			else
			{
				System.out.println(symbol + " is not available");
			}
		}
		if (stockAvailable){
			double beforePurchase = stock.getBookValue();
			stock.setPrice(price);
			double newQty = stock.getQuantity() - quantity;
			stock.setQuantity(newQty);
			stock.paymentRecieved();
			stock.findBookValue(price);
			stock.gain(beforePurchase, stock.findBookValue(price));
		}
		System.out.println("\n");
		toStringStock(stock, "sell");
		System.out.println(quantity + " shares of " + stock.getSymbol().toUpperCase() + " is sold, " + stock.getQuantity() + " shares are left");
	}
	// Methods Mutual Fund
	public void buyMutualFund(String name, String symbol, double price, double quantity)
    {
		boolean inMutualFund = false;
		for (int i = 0; i <= getMutualFundList().size(); i++)
		{
			inMutualFund = symbol.toLowerCase().equals(mutualFund.getSymbol());
		}
		if (inMutualFund)
		{
			double beforePurchase = mutualFund.getBookValue();
			mutualFund.setPrice(price);
			mutualFund.setQuantity(quantity);
			mutualFund.gain(beforePurchase, mutualFund.findBookValue(price));
		}
		else
		{
			double beforePurchase = mutualFund.getBookValue();
			mutualFund.setName(name);
			mutualFund.setSymbol(symbol);
			mutualFund.setPrice(price);
			mutualFund.setQuantity(quantity);
			mutualFund.gain(beforePurchase, mutualFund.findBookValue(price));
			addElement(mutualFund);
		}
		toStringMutualFunds(mutualFund, "buy");
		System.out.println(mutualFund.getSymbol().toUpperCase() + " successfully  bought.");
	}
	public void sellMutualFund(String symbol, double price, double quantity)
    {
		boolean mutualFundAvailable = false;
		for (int i = 0; i <= getMutualFundList().size(); i++)
		{
			if (symbol.toLowerCase().equals(stock.getSymbol()))
			{
				if (mutualFund.getQuantity() == 0) {
					System.out.println(mutualFund.getSymbol().toUpperCase() + " is not enough");
				}
				else {
					mutualFundAvailable = true;
				}
			}
			else
			{
				System.out.println(symbol + " is not available");
			}
		}
		if(mutualFundAvailable) {
			double beforePurchase = mutualFund.getBookValue();
			mutualFund.setPrice(price);
			double newQty = mutualFund.getQuantity() - quantity;
			mutualFund.setQuantity(newQty);
			mutualFund.paymentRecieved();
			mutualFund.findBookValue(price);
			mutualFund.gain(beforePurchase, mutualFund.findBookValue(price));
		}
		toStringMutualFunds(mutualFund, "sell");
		System.out.println("\n");
		System.out.println(quantity + " shares of " + mutualFund.getSymbol().toUpperCase() + " is sold, " + mutualFund.getQuantity() + " shares are left");
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		ePortfolio portfolio = new ePortfolio();
		String name;
		String symbol;
		double price, quantity;
		int menuOption;
		int investmentToBuy;
		int investmentToSell;

		while (true) { 
			System.out.println("Please select an option from the menu below:");
		    System.out.println("(1) Buy a new investment");
		    System.out.println("(2) Sell an exsiting investment");
		    System.out.println("(3) Get the investment gains");
		    System.out.println("(4) Search for an investment");

		    try {
				menuOption = scanner.nextInt();
			} 
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter an integer.");
				continue;
			}
		    switch (menuOption) {
			    case 1 -> {
					System.out.println("Please select the investment you wish to buy:");
					System.out.println("(1) Stock");
					System.out.println("(2) Mutual Funds");
					try {
						investmentToBuy = scanner.nextInt();
					} 
					catch (InputMismatchException e) {
						System.out.println("Invalid input. Please enter an integer.");
						continue;
					}
					switch (investmentToBuy) {				
						case 1 -> {
							System.out.println("Please provide the following information for the stock you wish to buy");
							System.out.println("Symbol of Stock: ");
							symbol = scanner.next();
							System.out.println("Name of Stock: ");
							name = scanner.next();
							System.out.println("Price of Stock: ");
							price = scanner.nextDouble();
							System.out.println("Quantity of Stock: ");
							quantity = scanner.nextDouble();
							portfolio.buyStock(name, symbol, price, quantity);
						}
						case 2 -> {
							System.out.println("Please provide the following information for the Mutual Fund you wish to buy");
							System.out.println("Symbol of Mutual Fund: ");
							symbol = scanner.next();
							System.out.println("Name of Stock: ");
							name = scanner.next();
							System.out.println("Price of Mutual Fund: ");
							price = scanner.nextDouble();
							System.out.println("Quantity of Mutual Fund: ");
							quantity = scanner.nextDouble();
							portfolio.buyMutualFund(name, symbol, price, quantity);
						}
						default -> throw new AssertionError();
					}
                }
				case 2 -> {
					System.out.println("Please select the investment you wish to sell:");
					System.out.println("(1) Stock");
					System.out.println("(2) Mutual Funds");
					try {
						investmentToSell = scanner.nextInt();
					} 
					catch (InputMismatchException e) {
						System.out.println("Invalid input. Please enter an integer.");
						continue;
					}
					switch (investmentToSell) {				
						case 1 -> {
							System.out.println("Please provide the following information for the stock you wish to sell");
							System.out.println("Symbol of Stock: ");
							symbol = scanner.next();
							System.out.println("Price of Stock: ");
							price = scanner.nextDouble();
							System.out.println("Quantity of Stock: ");
							quantity = scanner.nextDouble();
							portfolio.sellStock(symbol, price, quantity);
						}
						case 2 -> {
							System.out.println("Please provide the following information for the Mutual Fund you wish to sell");
							System.out.println("Symbol of Mutual Fund: ");
							symbol = scanner.next();
							System.out.println("Price of Mutual Fund: ");
							price = scanner.nextDouble();
							System.out.println("Quantity of Mutual Fund: ");
							quantity = scanner.nextDouble();
							portfolio.sellMutualFund(symbol, price, quantity);
						}
						default -> throw new AssertionError();
					}
				}
				case 3 -> {
					String formattedGainsValue = String.format("%.2f", (portfolio.stock.getGains() + portfolio.mutualFund.getGains()));
					System.out.println("Total gains from your investments is $" + formattedGainsValue);
				}
				case 4 -> {
					ArrayList<String> inputs = new ArrayList<>();
					String input;
					System.out.println("Please enter in the keywords to search for your investments and  type \"OK\" to pass the search. ");
					System.out.println("The search menu takes a maximum of 3 fields (The symbol, name, price range)");
					while (inputs.size() < 3) {
						input = scanner.next();
						if (input.toUpperCase().equalsIgnoreCase("OK")) {
							break;
						}
						inputs.add(input);
					}
					System.out.println("Inputs collected: " + inputs); // Debugging print statement
					try {
						portfolio.search(inputs);
						System.out.println("Search completed successfully."); // Debugging print statement
					} catch (Exception e) {
					}
				}

				default -> throw new AssertionError();
			}
		}
	}
}