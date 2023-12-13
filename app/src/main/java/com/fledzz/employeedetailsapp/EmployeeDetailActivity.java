package com.fledzz.employeedetailsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeDetailActivity extends AppCompatActivity {
    private TextView idTextView;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView phoneTextView;

    private TextView addressTextView;
    private TextView companyNameTextView;
    private TextView websiteTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        idTextView = findViewById(R.id.idTextView);
        nameTextView = findViewById(R.id.nameTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        addressTextView = findViewById(R.id.addressTextView);
        emailTextView = findViewById(R.id.emailTextView);
        companyNameTextView = findViewById(R.id.companyNameTextView);
        websiteTextView = findViewById(R.id.websiteTextView);

        Employee employee = (Employee) getIntent().getParcelableExtra("employee");

        idTextView.setText("Employee Id : "+Integer.toString(employee.getId()));
        nameTextView.setText( "Name :"+employee.getName());
        emailTextView.setText("Email :"+employee.getEmail().toLowerCase());
        phoneTextView.setText("Employee Phone :"+employee.getPhone());

        Address address = employee.getAddress();
        Company company = employee.getCompany();

        String addressString = (address != null) ? address.toString() : "No Address Available";
        String companyString = (company != null) ? company.getName() : "No Company Available";

        addressTextView.setText("Address : \n"+addressString);
        companyNameTextView.setText("Company Name :"+companyString);
        websiteTextView.setText("Website :"+employee.getWebsite());

        phoneTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + employee.getPhone()));
            startActivity(intent);
        });

        emailTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + employee.getEmail()));
            startActivity(Intent.createChooser(intent, "Send Email"));
        });
    }
}
