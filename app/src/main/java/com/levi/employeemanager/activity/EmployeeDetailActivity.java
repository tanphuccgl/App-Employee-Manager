package com.levi.employeemanager.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.levi.employeemanager.R;

public class EmployeeDetailActivity extends AppCompatActivity {

    private TextView textViewEmployeeId;
    private TextView textViewEmployeeName;
    private TextView textViewEmployeeDepartment;
    private TextView textViewEmployeeImage;
    private TextView textViewEmployeeSdt;
    private TextView textViewEmployeeEmail;
    private Button buttonAddEmployee;
    private Button buttonEditEmployee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        textViewEmployeeId = findViewById(R.id.textViewEmployeeId);
        textViewEmployeeName = findViewById(R.id.textViewEmployeeName);
        textViewEmployeeDepartment = findViewById(R.id.textViewEmployeeDepartment);
        textViewEmployeeImage = findViewById(R.id.textViewEmployeeImage);
        textViewEmployeeSdt = findViewById(R.id.textViewEmployeeSdt);
        textViewEmployeeEmail = findViewById(R.id.textViewEmployeeEmail);
        buttonAddEmployee = findViewById(R.id.buttonAddEmployee);
        buttonEditEmployee = findViewById(R.id.buttonEditEmployee);

        // Set click listener for "Thêm Nhân Viên" button
        buttonAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add logic to create a new employee
                // ...
            }
        });

        // Set click listener for "Sửa Thông Tin Nhân Viên" button
        buttonEditEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add logic to edit employee information
                // ...
            }
        });

        // Load employee details from intent or other source
        loadEmployeeDetails();
    }

    private void loadEmployeeDetails() {
        // Get employee details from the intent or another source
        // Example: Intent intent = getIntent();
        // EmployeeModel employee = (EmployeeModel) intent.getSerializableExtra("employee");

        // Update the TextViews with employee details
        // Example:
        // textViewEmployeeId.setText("Mã Nhân Viên: " + employee.getId());
        // textViewEmployeeName.setText("Tên Nhân Viên: " + employee.getName());
        // textViewEmployeeDepartment.setText("Phòng Ban: " + employee.getDepartmentId());
        // textViewEmployeeImage.setText("Hình Ảnh: " + employee.getImage());
        // textViewEmployeeSdt.setText("Số Điện Thoại: " + employee.getSdt());
        // textViewEmployeeEmail.setText("Email: " + employee.getEmail());
    }
}