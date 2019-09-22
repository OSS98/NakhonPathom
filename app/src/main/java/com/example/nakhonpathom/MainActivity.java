package com.example.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  String[] mPlaceList =  new String[]{
      "พระปฐมเจดีย์","บ้านปายนา","พิพิธภัณฑ์รถเก่า","ตลาดท่านา" ,"วัดกลางบางแก้ว"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView placeListView = findViewById(R.id.place_list_view);
//เป็นตัวกลางระหว่างข้อมูล "อะแดปเตอร์"
//        generic "<String>" พวกคลาสที่เป็นตัวเก็บข้อมูล เหมือนระบุว่าภายในเก็บอะไร
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,// ความจริงคือไฟล์ XML ที่ google ทำเอาไว้ให้แล้วนำหน้าด้วย android.
                // simple... คือรูปแบบการแสดงผลของ listview
                mPlaceList //  แหล่งข้อมูล
        );

 /// อันนี้คือการผูก/เชื่อม listview กับ adapter โดยเรียกใช้ method setadapter ของ listview
        placeListView.setAdapter(adapter);

        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String placeName = mPlaceList[position]; // อ่านชื่อชื่อของสถานที่ ของไอเทมที่ถูกคลิก มาเก็บลงตัวแปร placeName

                // แสดงชื่อสถานที่ออกมาใน toast
                Toast.makeText(MainActivity.this,placeName,Toast.LENGTH_SHORT).show();


            }
        });
    }
}
