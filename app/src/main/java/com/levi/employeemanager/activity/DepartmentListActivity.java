package com.levi.employeemanager.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.levi.employeemanager.R;
import com.levi.employeemanager.models.DepartmentModel;

import java.util.ArrayList;
import java.util.List;

public class DepartmentListActivity extends AppCompatActivity {

    private List<DepartmentModel> departmentList; // Replace with your actual data source
    private ArrayAdapter<DepartmentModel> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);

        ListView listViewDepartments = findViewById(R.id.listViewDepartments);

        // Initialize your data source (departmentList) with actual data
        departmentList = new ArrayList<>();

        // Initialize the adapter with custom layout (list_item_department)
        adapter = new ArrayAdapter<DepartmentModel>(this, R.layout.list_item_department, departmentList) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                // Populate the item view with department data
                DepartmentModel department = getItem(position);

                TextView textViewDepartmentId = view.findViewById(R.id.textViewDepartmentId);
                TextView textViewDepartmentName = view.findViewById(R.id.textViewDepartmentName);
                Button buttonDeleteDepartment = view.findViewById(R.id.buttonDeleteDepartment);

                // Set the data for each view
                textViewDepartmentId.setText("ID: " + department.getId());
                textViewDepartmentName.setText("Tên Phòng Ban: " + department.getName());

                // Set click listener for "Xóa" button
                buttonDeleteDepartment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Add logic to delete the department
                        // ...

                        // Remove the department from the list
                        departmentList.remove(department);

                        // Notify the adapter that the data has changed
                        adapter.notifyDataSetChanged();

                        Toast.makeText(DepartmentListActivity.this, "Đã xóa phòng ban", Toast.LENGTH_SHORT).show();
                    }
                });

                return view;
            }
        };

        // Set the adapter to the ListView
        listViewDepartments.setAdapter(adapter);

        // Set click listener for ListView items
        listViewDepartments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click (e.g., show details)
                DepartmentModel selectedDepartment = departmentList.get(position);
                // Add your logic here
            }
        });

        // Load your actual department data into the departmentList
        // ...

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged();
    }
}