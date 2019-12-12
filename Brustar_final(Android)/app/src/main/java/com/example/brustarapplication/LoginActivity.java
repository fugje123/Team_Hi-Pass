package com.example.brustarapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class LoginActivity extends AppCompatActivity {

    private EditText login_id, login_pw;
    private Button success_login;
    private String input_id, input_pw;
    private CheckBox auto_check;
    SessionManager sessionManager;
    SharedPreferences AutoPref;
    SharedPreferences.Editor edit;
    Boolean logoutcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //session 생성을 위함
        sessionManager=new SessionManager(this);

        //sharedpreferences 생성과 저장을 위함
        AutoPref = getSharedPreferences("auto",MODE_PRIVATE);
        edit = AutoPref.edit();

        //Layout item 선언
        login_id = findViewById(R.id.id_edit);
        login_pw = findViewById(R.id.password_edit);
        success_login = findViewById(R.id.login_button);
        auto_check=findViewById(R.id.auto_check);

        //로그아웃 버튼을 눌렀을 때 false 값 저장, defalutValue : True
        logoutcheck=getIntent().getBooleanExtra("boolcheck",true);

        //logoutcheck에 false 저장 (로그아웃 버튼 클릭)
        if(logoutcheck==false){
            auto_check.setChecked(false); //auto_check 체크 false
            edit.clear(); //SharedPreferences 값 초기화
            edit.commit();
        }
        //logoutcheck에 true 저장 (로그아웃 X)
        else{
            //sherdpreferences의 checkbox가 true이면
            if(AutoPref.getBoolean("checkbox",false)==true){
                auto_check.setChecked(true); //checkbox의 체크를 계속 유지
                login_id.setText(AutoPref.getString("id","error")); //아이디칸에 아이디 띄우기
                login_pw.setText(AutoPref.getString("password","error")); //비밀번호칸에 비밀번호 띄우기
                checkLoginDatabase(AutoPref.getString("id",null),AutoPref.getString("password",null)); //로그인 실행
            }
        }

        //로그인 버튼 클릭
        success_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_id = login_id.getText().toString();
                input_pw = login_pw.getText().toString();
                checkLoginDatabase(input_id,input_pw);//로그인 실행
            }
        });

        //Enter Key로 로그인 실행
        login_pw.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent keyEvent) {
                //ENTER KEY를 눌렀을 때
                if (keycode==KeyEvent.KEYCODE_ENTER){
                    success_login.callOnClick(); //로그인 실행
                    return true;
                }
                return false;
            }
        });

    }

    private void checkLoginDatabase(final String Id, final String Pw) {
        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoginActivity.this, "Please Wait", null, true, true);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                sessionManager.createSession(Id); //session에 ID 저장
                //로그인 실행 시 auto_check 체크
                if(auto_check.isChecked()){
                    edit.putString("id",Id);
                    edit.putString("password",Pw);
                    edit.putBoolean("checkbox",true);
                    edit.commit(); //입력된 아이디, 비밀번호, 체크 여부 SharedPreferences에 저장
                }
                //로그인 실행 시 auto_check 체크X
                else{
                    edit.putString("id","");
                    edit.putString("password","");
                    edit.putBoolean("checkbox",false);
                    edit.commit(); //SharedPreferences의 아이디, 비밀번호, 체크 여부 초기화
                }
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(String... params) {
                try {
                    //보낼 값
                    String Id = (String) params[0];
                    String Pw = (String) params[1];
                    //접속 주소
                    String link = "http://dlaeorms.cafe24.com/login.php";
                    //php에 보낼 data
                    String data = URLEncoder.encode("Id", "UTF-8") + "=" + URLEncoder.encode(Id, "UTF-8");
                    data += "&" + URLEncoder.encode("Pw", "UTF-8") + "=" + URLEncoder.encode(Pw, "UTF-8");

                    //접속
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);

                    //데이터 보내기
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();

                    //서버측 response 가져오기
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }

                    //Response의 값이 "success"일 때
                    if (line.equals("success")){
                        //Login 성공, HomeActivity 이동
                        Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
                        LoginActivity.this.startActivity(loginIntent);
                        finish();
                    }
                    return sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }

        }
        InsertData task = new InsertData();
        task.execute(Id, Pw);
    }

    //회원가입 버튼 클릭
    public void SignClick(View view) {
        //SignUpActivity 이동
        startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
    }

}
