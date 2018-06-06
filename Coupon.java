

public class Coupon 
/*Define the coupon class with its parameters*/
{
    protected String ProviderName;
    protected String ProductName;
    protected  float Price;
    protected  int DiscountRate;
    protected  int ExpirationPeriod;
    protected  String Status;
	public Coupon(String ProviderName,String ProductName,float Price,int DiscountRate,int ExpirationPeriod,String Status) 
	{
		this.ProviderName=ProviderName;
		this.ProductName=ProductName;
		this.Price=Price;
		this.DiscountRate=DiscountRate;
		this.ExpirationPeriod=ExpirationPeriod;
		this.Status=Status;
	}
	@SuppressWarnings("unused")
	private float FinalPrice() 
	{
		return Price*DiscountRate/100;
	}
	public String toString() 
	{
		return String.format("%s,%s,%s,%s,%s,%s,%.2f",ProviderName,ProductName,Price,DiscountRate,ExpirationPeriod,Status,this.FinalPrice());
		
	}
	
	
}
