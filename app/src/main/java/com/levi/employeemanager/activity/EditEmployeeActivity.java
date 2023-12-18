package com.levi.employeemanager.activity;// EditEmployeeActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.levi.employeemanager.R;
import com.levi.employeemanager.database.DataManager;
import com.levi.employeemanager.models.EmployeeModel;

public class EditEmployeeActivity extends AppCompatActivity {

    private EditText editTextEmployeeName;
    private EditText editTextDepartmentId;
    private EditText editTextImage;
    private EditText editTextSdt;
    private EditText editTextEmail;
    private Button buttonSaveChanges;

    private EmployeeModel employee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        // Khởi tạo các thành phần giao diện
        editTextEmployeeName = findViewById(R.id.editTextEmployeeName);
        editTextDepartmentId = findViewById(R.id.editTextDepartmentId);
        editTextImage = findViewById(R.id.editTextImage);
        editTextSdt = findViewById(R.id.editTextPhoneNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSaveChanges = findViewById(R.id.buttonSaveChanges);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Nhận dữ liệu nhân viên từ Intent
        Intent intent = getIntent();
        if (intent.hasExtra("employee")) {
            employee = (EmployeeModel) intent.getSerializableExtra("employee");

            // Hiển thị thông tin hiện tại của nhân viên trên giao diện
            editTextEmployeeName.setText(employee.getName());
            editTextDepartmentId.setText(employee.getDepartmentId());
            editTextImage.setText(employee.getImage());
            editTextSdt.setText(employee.getSdt());
            editTextEmail.setText(employee.getEmail());
        }

        // Thiết lập sự kiện khi nhấn nút "Lưu thay đổi"
        buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();
            }
        });
    }

    private void saveChanges() {
        // Lấy dữ liệu từ các trường EditText
        String name = editTextEmployeeName.getText().toString();
        String departmentId = editTextDepartmentId.getText().toString();
        String image = editTextImage.getText().toString();
        String sdt = editTextSdt.getText().toString();
        String email = editTextEmail.getText().toString();

        // Cập nhật thông tin nhân viên
        employee.setName(name);
        employee.setDepartmentId(departmentId);
        employee.setImage(image);
        employee.setSdt(sdt);
        employee.setEmail(email);

        // Cập nhật vào cơ sở dữ liệu
        DataManager dataManager = new DataManager(EditEmployeeActivity.this);
        dataManager.open();
        dataManager.updateEmployee(employee);
        dataManager.close();

        // Trở về màn hình trước đó
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            // Xử lý sự kiện khi nút quay lại được nhấn
            finish();
            return true;
        }
        else if (itemId == R.id.menu_about) {
            // Add logic to handle "About" option
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        } else if (itemId == R.id.menu_exit) {
            // Add logic to handle "Exit" option
            finishAffinity(); // Đóng
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}