package business;

public class Customer {
		public static final int MAX_FIRSTNAME_SIZE = 30;
		public static final int MAX_LASTNAME_SIZE = 30;
		public static final int MAX_PHONE_SIZE = 10; 
		public static final int MAX_EMAIL_SIZE = 30;
		public static final int MAX_ADDRESS_SIZE = 50;
		public static final int MAX_CITY_SIZE = 30;
		public static final int MAX_PROVINCE_SIZE = 20;
		public static final int MAX_POSTALCODE_SIZE = 6; 
	
		private int customerID;
		private String firstName;
		private String lastName;
		private String phone;
		private String email;
		private String address;
		private String city;
		private String province;
		private String postalCode;
		
		private boolean wasAllSetDataOk = true;
		private String[] errInfo;
		
		public int getCustomerID() {
			return customerID;
		}
		
		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public boolean setFirstName(String firstName) {
			if (firstName.length() <= MAX_FIRSTNAME_SIZE) {
				this.firstName = firstName;
				return true;
			}
			errInfo = new String[]{firstName, MAX_FIRSTNAME_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public boolean setLastName(String lastName) {
			if (lastName.length() <= MAX_LASTNAME_SIZE) {
				this.lastName = lastName;
				return true;
			}
			errInfo = new String[]{lastName, MAX_LASTNAME_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public String getPhone() {
			return phone;
		}
		
		public boolean setPhone(String phone) { 
			if (phone.length() <= MAX_PHONE_SIZE) {
				this.phone = phone;
				return true;
			}
			errInfo = new String[]{phone, MAX_PHONE_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public String getEmail() {
			return email;
		}
		
		public boolean setEmail(String email) { 
			if (email.length() <= MAX_EMAIL_SIZE) {
				this.email = email;
				return true;
			}
			errInfo = new String[]{email, MAX_EMAIL_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public String getAddress() {
			return address;
		}
		
		public boolean setAddress(String address) { 
			if (address.length() <= MAX_ADDRESS_SIZE) {
				this.address = address;
				return true;
			}
			errInfo = new String[]{address, MAX_ADDRESS_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public String getCity() {
			return city;
		}
		
		public boolean setCity(String city) { 
			if (city.length() <= MAX_CITY_SIZE) {
				this.city = city;
				return true;
			}
			errInfo = new String[]{city, MAX_CITY_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public String getProvince() {
			return province;
		}
		
		public boolean setProvince(String province) { 
			if (province.length() <= MAX_PROVINCE_SIZE) {
				this.province = province;
				return true;
			}
			errInfo = new String[]{province, MAX_PROVINCE_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public String getPostalCode() {
			return postalCode;
		}
		
		public boolean setPostalCode(String postalCode) { 
			if (postalCode.length() <= MAX_POSTALCODE_SIZE) {
				this.postalCode = postalCode;
				return true;
			}
			errInfo = new String[]{postalCode, MAX_POSTALCODE_SIZE + ""};
			return wasAllSetDataOk = false;
		}
		
		public boolean wasAllSetDataOk() {
			return wasAllSetDataOk;
		}
		
		public void clearWasAllSetDataOk() {
			wasAllSetDataOk = true;
		}
		
		public String[] getSetErrorInfo() {
			return errInfo;
		}
		
		@Override
		public String toString() {
			return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", city=" + city
					+ ", province=" + province + ", postalCode=" + postalCode + "]";
		}
}
