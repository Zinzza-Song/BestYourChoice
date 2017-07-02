package com.example.goople4;

        import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class selfrandom6 extends Activity {
    private DBAdapter mDb;
    protected ArrayList<Info> mInfo;
    protected ArrayAdapter<Info> mAdapter;
    static int math;

    ListView listView;
    EditText editText1;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selfrandom);

        listView=(ListView) findViewById(R.id.listView);
        editText1=(EditText) findViewById(R.id.editText1);
        btnSave=(Button) findViewById(R.id.btnSave);

        mDb = new DBAdapter(this);
        mInfo = mDb.getAllInfo();
        mAdapter = new ArrayAdapter<Info>(this, android.R.layout.simple_list_item_1, mInfo);
        listView.setAdapter(mAdapter);

	        /* 저장 버튼 */
        btnSave.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mDb.insertInfo(editText1.getText().toString(), null);
                editText1.setText("");
                refreshList();
            }
        });

	        /* 리스트뷰 클릭시 삭제 */
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Info i = mInfo.get(position);
                Toast.makeText(selfrandom6.this, "delete " + i.getMeeting(), Toast.LENGTH_SHORT).show();
                mDb.deleteInfo(i.getId());
                refreshList();
                return false;
            }
        });
    }

   /* public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "All delete!");
        // TODO Auto-generated method stub
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        mDb.deleteAll();
        refreshList();
        return super.onOptionsItemSelected(item);
    }*/

    protected void onDestroy() {
        mDb.close();
        super.onDestroy();
    }

    private void refreshList() {
        mInfo.clear();
        mInfo.addAll(mDb.getAllInfo());
        mAdapter.notifyDataSetInvalidated();
    }

    public void wow(View v){
       if(mInfo.size() != 0){
        math =(int)(Math.random() * mInfo.size());

        Intent it = new Intent(getApplicationContext(), selfrandom_result7.class);
        startActivity(it);
       }
    }
    public void rese(View v){
        mDb.deleteAll();
        refreshList();
    }
}
