/*
 * File name: AutoSalesOrder.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Sep 30, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * <insert class description here>
 *
 * @author Emma ROUGER
 *
 */
public class AutoSalesOrder
{
	public final double OIL_CHANGE=299.99;
	public final double TIRE_ROTATION=149.50;
	public final double CAR_WASH=499.99;
	public final double VEHICULE_SALES_TAX=.035;
	public final double SERVICE_SALES_TAX=.08;
	public final double SERVICE_REBATE=.02;
	
	private Date orderDate;
	private double orderPrice;
	private String vehiculeDescription;
	private double vehiculePrice;
	private double vehiculeTax;
	private double vehiculeSubtotal;
	private double servicePrice;
	private double serviceTax;
	private double serviceSubtotal;
	private double serviceCash;
	private double serviceRebate;
	private boolean oilChangeIndi;
	private boolean tireRotationIndi;
	private boolean carWashIndi;
	
	private double oil;
	private double tire;
	private double wash;
	
	
	/**
	 * Constructor
	 * Assign the current date to the date of the order
	 */
	public AutoSalesOrder()
	{
		orderDate = new Date();
		
	}


	/**
	 * Constructor
	 * Assign the current date to the date of the order
	 * @param vehiculeDescription
	 * 			assign the vehicle description
	 * @param vehiculePrice
	 * 			assign the vehicle price
	 */
	public AutoSalesOrder(String vehiculeDescription, double vehiculePrice)
	{
		this();
		this.vehiculeDescription = vehiculeDescription;
		this.vehiculePrice = vehiculePrice;
	}


	/**
	 * @return the vehiculeDescription
	 */
	public String getVehiculeDescription()
	{
		return vehiculeDescription;
	}


	/**
	 * @param vehiculeDescription 
	 * 			the vehiculeDescription to set
	 */
	public void setVehiculeDescription(String vehiculeDescription)
	{
		this.vehiculeDescription = vehiculeDescription;
	}


	/**
	 * @return the orderPrice
	 */
	public double getOrderPrice()
	{
		return orderPrice;
	}


	/**
	 * @return the serviceCash
	 */
	public double getServiceCash()
	{
		return serviceCash;
	}


	/**
	 * @param oilChangeIndi 
	 * 			the oilChangeIndi to set
	 */
	public void setOilChangeIndi(boolean oilChangeIndi)
	{
		this.oilChangeIndi = oilChangeIndi;
		if (this.oilChangeIndi==true)
		{
			oil=OIL_CHANGE;
		}
		else
		{
			oil=0;
		}
	}


	/**
	 * @param tireRotationIndi 
	 * 			the tireRotationIndi to set
	 */
	public void setTireRotationIndi(boolean tireRotationIndi)
	{
		this.tireRotationIndi = tireRotationIndi;
		if (this.tireRotationIndi==true)
		{
			tire=TIRE_ROTATION;
		}
		else
		{
			tire=0;
		}
	}


	/**
	 * @param carWashIndi 
	 * 			the carWashIndi to set
	 */
	public void setCarWashIndi(boolean carWashIndi)
	{
		this.carWashIndi = carWashIndi;
		if (this.carWashIndi==true)
		{
			wash=CAR_WASH;
		}
		else 
		{
			wash=0;
		}
	}


	/**
	 * @param vehiculePrice 
	 * 		the vehiculePrice, the vehiculeTaxm the serviceCash and the vehiculeSubtotal to set
	 */
	public void setVehiculePrice(double vehiculePrice)
	{
		this.vehiculePrice = vehiculePrice;
		vehiculeTax = Math.round(this.vehiculePrice*this.VEHICULE_SALES_TAX*100.0)/100.0;
		serviceCash=Math.round(this.vehiculePrice*SERVICE_REBATE*100.0)/100.0;
		vehiculeSubtotal=this.vehiculePrice+vehiculeTax;
		orderPrice=vehiculeSubtotal+serviceSubtotal;
	}
	
	/**
	 * set the servicePrice, the serviceRebatem the serviceTax and the ServiceSubtotal
	 * @return the serviceSubtotal
	 */
	public double calculateOrderLineItemCost()
	{
		servicePrice=(oil+tire+wash);
		serviceRebate=serviceCash;
		if (serviceRebate>servicePrice)
		{
			serviceRebate=servicePrice;
		}
		serviceTax=(servicePrice*SERVICE_SALES_TAX*100.0)/100.0;
		serviceSubtotal=servicePrice+serviceTax-serviceRebate;
		return serviceSubtotal;
		
	}
	
	/**
	 * print out the order receipt 
	 */
	public String toString()
	{
		DecimalFormat df=new DecimalFormat("$###,##0.00");
		String toString="--------------------------------------------------"
				+"\nAUTO SALES ORDER RECEIPT\n"
				+"Order Date: "+orderDate
				+"\n--------------------------------------------------"
				+"\nItem\t\t\tAmount\n"
				+"--------------------------------------------------\n"
				+"Vehicle\n\t"+vehiculeDescription
				+"\n  Sales Price\t\t\t\t"+df.format(vehiculePrice)
				+"\n  Sales Tax\t\t\t\t   "+df.format(vehiculeTax)
				+"\n  Subtotal\t\t\t\t"+df.format(vehiculeSubtotal)
				+"\n\nService Package";
		System.out.println(toString);
		if (oilChangeIndi==true)
		{
			System.out.println("\t3-year oil change package");
		}
		if (tireRotationIndi==true)
		{
			System.out.println("\t3-year tire rotation package");
		}
		if (carWashIndi==true)
		{
			System.out.println("\t3-year car wash package");
		}
		calculateOrderLineItemCost();
		String packageString="  Sale Price\t\t\t\t   "+df.format(servicePrice)
				+"\n  Sales Tax\t\t\t\t    "+df.format(serviceTax)
				+"\n  Rebate\t\t\t\t ("+df.format(serviceRebate)+")"
				+"\n  Subtotal\t\t\t\t   "+df.format(serviceSubtotal);
		String packageNull="  Sale Price\t\t\t\t     "+df.format(servicePrice)
		+"\n  Sales Tax\t\t\t\t     "+df.format(serviceTax)
		+"\n  Rebate\t\t\t\t     "+df.format(serviceRebate)
		+"\n  Subtotal\t\t\t\t     "+df.format(serviceSubtotal);
		if (Math.abs(servicePrice)==0)
		{
			System.out.println(packageNull);
		}
		else
		{
			System.out.println(packageString);
		}
		
		orderPrice=vehiculeSubtotal+serviceSubtotal;
		String total="\n--------------------------------------------------"
				+"\nGrand Total\t\t\t\t"+df.format(orderPrice)
				+"\n--------------------------------------------------";
		System.out.println(total);
		return total;
	}
	
	
	
	
	
	
}
