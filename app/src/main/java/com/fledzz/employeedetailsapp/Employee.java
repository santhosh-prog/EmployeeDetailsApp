package com.fledzz.employeedetailsapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;

    protected Employee(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        phone = in.readString();
        website = in.readString();
        address = in.readParcelable(Address.class.getClassLoader());
        company = in.readParcelable(Company.class.getClassLoader());
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(website);
        parcel.writeParcelable(address, i);
        parcel.writeParcelable(company, i);
    }
}
