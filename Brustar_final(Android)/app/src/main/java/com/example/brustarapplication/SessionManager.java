package com.example.brustarapplication;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MOD = 0 ;
    private static final String PREF_NAME="LOGIN";
    private static final String LOGIN ="IS_LOGIN";
    public static final String ID = "ID";
    public static final String SM_Mode = "SM_Mode_check";
    public static final String ST_Mode = "ST_Mode_check";

    public SessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MOD);
        editor = sharedPreferences.edit();
    }

    //로그인 세션
    public void createSession(String id){
        editor.putBoolean(LOGIN, true);
        editor.putString(ID,id);
        editor.apply();
    }

    //Security Mode 체크 여부 저장
    public void SecurityMode(Boolean check){
        if(check==true){
            editor.putBoolean(SM_Mode,true);
        }
        else if (check == false){
            editor.putBoolean(SM_Mode,false);
        }
        editor.apply();
    }
    //Security Mode 체크 여부 return
    public boolean sm_checked(){
        return sharedPreferences.getBoolean(SM_Mode,false);
    }

    //Stop Mode 체크 여부 저장
    public void StopMode(Boolean check){
        if(check==true){
            editor.putBoolean(ST_Mode,true);
        }
        else if (check == false){
            editor.putBoolean(ST_Mode,false);
        }
        editor.apply();
    }
    //Stop Mode 체크 여부 return
    public boolean st_checked(){
        return sharedPreferences.getBoolean(ST_Mode,false);
    }

    //로그아웃시 모든 세션 지우기
    public void logout(){
        editor.clear();
        editor.commit();
    }
}
