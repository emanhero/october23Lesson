package com.lesson.october23lesson;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    String[] names;
    String[] saints;
    ListView list;
    int[] cLogo = {R.drawable.accountancy, R.drawable.archi, R.drawable.finearts, R.drawable.civillaw, R.drawable.commerce, R.drawable.edu, R.drawable.engg, R.drawable.iics};
    String[] collegeInfo = {"Accountancy Message", "Fine Architecture Message", "CFAD Message", "Civil Law Message", "Commerce Message", "Education Messsage", "Engineering Message", "IICS Message"};

    ArrayList<College> collegeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.colleges);
        saints = getResources().getStringArray(R.array.patron);
        for(int i=0; i<names.length; i++)
        {
            collegeList.add(new College(cLogo[i], names[i], saints[i]));
        }
        list = findViewById(R.id.lbColleges);
        //ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        CollegeAdapter adapter = new CollegeAdapter(this,R.layout.item,collegeList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id)
    {
        //Toast.makeText(this, names[i], Toast.LENGTH_LONG).show();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(collegeList.get(i).getName());
        dialog.setIcon(collegeList.get(i).getLogo());
        dialog.setMessage(collegeInfo[i]);
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.dismiss();
            }
        });
        dialog.create().show();
        Toast.makeText(this, collegeInfo[i], Toast.LENGTH_LONG).show();


    }
}
