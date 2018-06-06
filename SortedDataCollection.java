import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortedDataCollection extends DataCollection<Coupon> {

	int BSTindex = 0;
	int Linearindex = 0;
	SortedBST<Integer> list = new SortedBST<Integer>();

	/* Input new data set by text file if required */
	protected void PurchaseCoupon(String filename) throws FileNotFoundException {

		File myFile = new File(filename);
		Scanner input = new Scanner(myFile);
		while (input.hasNextLine()) {
			String b = input.nextLine();
			String[] part = b.split(",");
			String part1 = part[0];
			String part2 = part[1];
			float part3 = Float.parseFloat(part[2]);
			int part4 = Integer.parseInt(part[3]);
			int part5 = Integer.parseInt(part[4]);
			String part6 = part[5];
			Coupon coupon1 = new Coupon(part1, part2, part3, part4, part5, part6);
			this.add(coupon1);
		}
		input.close();

		list.SetSize(index + 1);
	}

	/*
	 * Search coupon's position by returning search times using BST method and
	 * Linear method
	 */
	protected void SearchCoupon(String ProviderName, String ProductName, float Price, int DiscountRate,
			int ExpirationPeriod, String Status) {
		Coupon coupon = new Coupon(ProviderName, ProductName, Price, DiscountRate, ExpirationPeriod, Status);
		for (int i = 0; i <= index - 1; i++)    /*Sort the list in increasing order*/
		{
			for (int j = i + 1; j <= index; j++) {
				if (this.get(i).info.DiscountRate > this.get(j).info.DiscountRate) {
					Coupon temp = this.get(i).info;
					this.get(i).info = this.get(j).info;
					this.get(j).info = temp;

				}
			}
		}

		for (int i = 0; i <= index; i++)     /*Return the Linear search outcome*/
		{
			if (this.get(i).info.DiscountRate == coupon.DiscountRate) {
				Linearindex = i + 1;
			}
		}
		
		if (Linearindex == index + 1)        /*Return the BST search outcome*/
		{
			int count = 0;
			for (int i = Linearindex; i > 0; i = i / 2) {
				count++;
			}
			BSTindex = count;
		} else {
			BSTindex = list.search(Linearindex - 1);/* mark */
		}

	}

	protected void ListCoupons(Which which)       /*Sort coupons based on different limit attributes*/
	{
		if (which == Which.PROVIDER) /*Sort coupons based on Provider Name*/{
			for (int i = 0; i <= index; i++) {
				for (int j = i + 1; j <= index; j++) {
					if (this.get(j).info.ProviderName.compareTo(this.get(i).info.ProviderName) < 0) {
						Coupon temp = this.get(i).info;
						this.get(i).info = this.get(j).info;
						this.get(j).info = temp;

					}
				}
			}
		}
		if (which == Which.NAME) /*Sort coupons based on Product Name*/ {
			for (int i = 0; i <= index; i++) {
				for (int j = i + 1; j <= index; j++) {
					if (this.get(j).info.ProductName.compareTo(this.get(i).info.ProductName) < 0) {
						Coupon temp = this.get(i).info;
						this.get(i).info = this.get(j).info;
						this.get(j).info = temp;

					}
				}
			}
		}
		if (which == Which.PRICE)/*Sort coupons based on Price Value*/ {
			for (int i = 0; i <= index; i++) {
				for (int j = i + 1; j <= index; j++) {
					if (this.get(j).info.Price < (this.get(i).info.Price)) {
						Coupon temp = this.get(i).info;
						this.get(i).info = this.get(j).info;
						this.get(j).info = temp;

					}
				}
			}
		}
		if (which == Which.DISCOUNTRATE)/*Sort coupons based on Discount Value*/ {
			for (int i = 0; i <= index; i++) {
				for (int j = i + 1; j <= index; j++) {
					if (this.get(j).info.DiscountRate < (this.get(i).info.DiscountRate)) {
						Coupon temp = this.get(i).info;
						this.get(i).info = this.get(j).info;
						this.get(j).info = temp;
					}
				}
			}
		}
		if (which == Which.EXPIRATIONPERIOD)/*Sort coupons based on Expiration Period*/ {
			for (int i = 0; i <= index; i++) {
				for (int j = i + 1; j <= index; j++) {
					if (this.get(j).info.ExpirationPeriod < (this.get(i).info.ExpirationPeriod)) {
						Coupon temp = this.get(i).info;
						this.get(i).info = this.get(j).info;
						this.get(j).info = temp;
					}
				}
			}
		}
		if (which == Which.USED) /*Sort coupons based on Status of Use*/{
			for (int i = 0; i <= index; i++) {
				for (int j = i + 1; j <= index; j++) {
					if (this.get(j).info.Status.compareTo(this.get(i).info.Status) < 0) {
						Coupon temp = this.get(i).info;
						this.get(i).info = this.get(j).info;
						this.get(j).info = temp;

					}
				}
			}
		}
		if (which == Which.FINALPRICE) /*Sort coupons based on Final price value */{
			for (int i = 0; i <= index; i++) {
				for (int j = i + 1; j <= index; j++) {
					if ((this.get(j).info.Price * (100 - this.get(j).info.DiscountRate)) < (this.get(i).info.Price
							* (100 - this.get(i).info.DiscountRate))) {
						Coupon temp = this.get(i).info;
						this.get(i).info = this.get(j).info;
						this.get(j).info = temp;

					}
				}
			}
		}

	}
}
