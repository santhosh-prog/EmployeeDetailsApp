package com.fledzz.employeedetailsapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Address implements Parcelable {
    private String street;
    private String suite;
    private String city;
    private String zipcode;


    protected Address(Parcel in) {
        street = in.readString();
        suite = in.readString();
        city = in.readString();
        zipcode = in.readString();
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
    @NonNull
    @Override
    public String toString() {
        return street + ", " + suite + ", " + city + ", " + zipcode;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(street);
        parcel.writeString(suite);
        parcel.writeString(city);
        parcel.writeString(zipcode);

    }
}

