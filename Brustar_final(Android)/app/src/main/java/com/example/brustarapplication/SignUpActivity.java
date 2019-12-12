package com.example.brustarapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SignUpActivity extends AppCompatActivity {

    private  EditText sign_id, sign_pw, check_pw, device_code;
    private  Button success_sign;
    private ImageButton check_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sign_id = findViewById(R.id.sign_id);
        sign_pw = findViewById(R.id.sign_password);
        check_pw = findViewById(R.id.check_password);
        device_code = findViewById(R.id.device_code);
        check_button = findViewById(R.id.pw_check_button);
        success_sign = findViewById(R.id.sign_up_button);

        //패스워드 일치 검사
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_pw=sign_pw.getText().toString(); //비밀번호 입력 값
                String pw_check=check_pw.getText().toString(); //비밀번호 일치여부 확인을 위한 입력 값
                //일치 X
                if(!pw_check.equals(input_pw)){
                    check_pw.setError("비밀번호가 다릅니다.");
                    sign_pw.requestFocus();
                    return;
                }
                //일치
                else{
                    Toast.makeText(SignUpActivity.this,"비밀번호가 일치합니다.", Toast.LENGTH_SHORT).show();
                    check_pw.setFocusable(false);
                    check_button.setClickable(false);
                }
            }
        });
        success_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //아이디 구성 조건
                String input_id = sign_id.getText().toString();
                //아이디 길이 체크
                char[] id_array = new char[input_id.length()];
                for (int i = 0; i < id_array.length; i++) {
                    id_array[i] = (input_id.charAt(i));
                }
                if (id_array.length == 0) {
                    sign_id.setError("아이디를 입력하시오");
                    sign_id.requestFocus();
                    return;
                }
                else {
                    if (id_array.length <= 5) {
                        sign_id.setError("6자리 이상의 아이디를 입력하시오");
                        sign_id.requestFocus();
                        return;
                    }
                }

                //패스워드 구성 조건
                String input_pw=sign_pw.getText().toString();
                char[] pw_array = new char[input_pw.length()];
                for(int j=0;j<pw_array.length;j++){
                    pw_array[j]=(input_pw.charAt(j));
                }

                int sp=0;//특수문자 체크
                int eng=0;//영문자 체크
                int num=0;//숫자 체크

                //입력된 비밀번호 길이가 0일 때
                if (pw_array.length == 0){
                    sign_pw.setError("비밀번호를 입력하시오");
                    sign_pw.requestFocus();
                    return;
                }
                //입력된 비밀번호 길이가 0이 아닐 때
                else {
                    if (pw_array.length >= 5 && pw_array.length <= 20) {
                        //ASCII코드를 통한 특수문자, 영문자, 숫자 수 체크
                        for (int i = 0; i < pw_array.length; i++) {
                            if (33 <= (int) pw_array[i] && (int) pw_array[i] <= 47 || 58 <= (int) pw_array[i] && (int) pw_array[i] <= 64 || 91 <= (int) pw_array[i] && (int) pw_array[i] <= 96 || 123 <= (int) pw_array[i] && (int) pw_array[i] <= 126) {
                                sp++;
                            } else if (48 <= (int) pw_array[i] && (int) pw_array[i] <= 57) {
                                num++;
                            } else if ((65 <= (int) pw_array[i] && (int) pw_array[i] <= 90) || (97 <= (int) pw_array[i] && (int) pw_array[i] <= 122)) {
                                eng++;
                            }
                        }

                        if (sp == 0) { //특수문자 수 확인
                            sign_pw.setError("특수문자를 입력하시오");
                            sign_pw.requestFocus();
                            return;
                        }
                        if (num == 0) { //숫자 수 확인
                            sign_pw.setError("숫자를 입력하시오");
                            sign_pw.requestFocus();
                            return;
                        }
                        if (eng == 0) { //영문자 수 확인
                            sign_pw.setError("영문자를 입력하시오");
                            sign_pw.requestFocus();
                            return;
                        }
                    }
                    //입력된 비밀번호 길이 체크
                    else {
                        sign_pw.setError("5~20 size pw please.");
                        sign_pw.requestFocus();
                        return;
                    }
                }


                //디바이스 코드 입력 조건
                String dev_code=device_code.getText().toString();
                if(dev_code.length()==0){
                    device_code.setError("코드를 입력하시오");
                    device_code.requestFocus();
                    return;
                }

                //비밀번호 체크를 안했을 때
                if(check_button.isClickable()){
                    Toast.makeText(SignUpActivity.this,"비밀번호 체크 하시오", Toast.LENGTH_SHORT).show();
                }
                //비밀번호 체크 완료
                else{
                    Toast.makeText(SignUpActivity.this,"회원가입 성공", Toast.LENGTH_SHORT).show();
                    insertoToDatabase(input_id,input_pw);
                    startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                    finish();
                }


            }
        });
    }

    private void insertoToDatabase(String Id, String Pw) {
        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SignUpActivity.this, "Please Wait", null, true, true);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
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
                    String link = "http://dlaeorms.cafe24.com/member.php";
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
                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
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


}
