package com.example.brustarapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class SettingActivity extends AppCompatActivity {

    private RadioGroup radioGroup1,radioGroup2;
    private RadioButton sm1_radioButton,sm2_radioButton,st1_radioButton,st2_radioButton;
    final FTPClient ftpClient = new FTPClient();
    private NotificationManager notificationManager;
    private String CHANNEL_ID;
    private TextView logout;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //radio Button의 체크를 저장하기 위한 sessionManager
        sessionManager = new SessionManager(this);


        radioGroup1 = (RadioGroup) findViewById(R.id.radioGruop1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGruop2);
        sm1_radioButton = (RadioButton) findViewById(R.id.sm_check1);
        sm2_radioButton = (RadioButton) findViewById(R.id.sm_check2);
        st1_radioButton = (RadioButton) findViewById(R.id.st_check1);
        st2_radioButton = (RadioButton) findViewById(R.id.st_check2);
        logout = (TextView) findViewById(R.id.logout);

        //security Mode 체크 값 가져오기
        if (sessionManager.sm_checked() == true) {
            sm1_radioButton.setChecked(true);
            sm2_radioButton.setChecked(false);
        } else {
            sm1_radioButton.setChecked(false);
            sm2_radioButton.setChecked(true);
        }

        //stop Mode 체크 값 가져오기
        if (sessionManager.st_checked() == true) {
            st1_radioButton.setChecked(true);
            st2_radioButton.setChecked(false);
        } else {
            st1_radioButton.setChecked(false);
            st2_radioButton.setChecked(true);
        }

        //로그아웃 버튼 클릭
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout(); // 로그아웃 실행
                //LoginActivity로 이동, false라는 값을 보냄
                Intent logout_send = new Intent(SettingActivity.this, LoginActivity.class);
                logout_send.putExtra("boolcheck", false);
                startActivity(logout_send);
                finish();
            }
        });

        //security mode 이벤트
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.sm_check1: //security Mode On
                        sessionManager.SecurityMode(true);
                        createNotificationChannel();
                        new Thread() {
                            public void run() {
                                try {
                                    while (sm1_radioButton.isChecked()) {
                                        //서버 도메인 객체 생성
                                        InetAddress serverAddr = InetAddress.getByName(getString(R.string.server_ip));
                                        //UDP 통신을 위한 소켓
                                        DatagramSocket socket = new DatagramSocket();
                                        //UDP 통신을 위한 DatagramPacket 생성, 보내기
                                        byte[] buf = ("Security Mode").getBytes();
                                        DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 5514);
                                        socket.send(packet);
                                        Log.d("Security Mode", "Data Send!!"); // 데이터 전송 확인을 위한 LOG
                                        //서버로 부터 값을 받음
                                        socket.receive(packet);
                                        System.out.println(new String(packet.getData()));
                                        //값이 "Security Mode" 이면
                                        if (new String(packet.getData()).equals("Security Mode")) {
                                            FTP_Connect(); //Raspberry Pi의 FTP Server에 접속
                                            socket.close(); //소켓 통신 종료
                                            Thread.sleep(3000); //Thread 3초간 멈춤
                                        } else {
                                            socket.close(); //소켓 통신 종료
                                            Thread.sleep(3000); //Thread 3초간 멈춤
                                        }
                                    }
                                } catch (Exception e) {
                                    Log.e("UDP", "C: Error", e);
                                }

                            }
                        }.start();
                        break;

                    case R.id.sm_check2:  //security Mode Off
                        sessionManager.SecurityMode(false);
                        break;
                }
            }
        });

        //Stop mode 이벤트
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.st_check1) {
                sessionManager.StopMode(true);
                new Thread() {
                    public void run() {
                        try {
                            {
                                //서버 도메인 객체 생성
                                InetAddress serverAddr = InetAddress.getByName(getString(R.string.server_ip));
                                //UDP 통신을 위한 소켓
                                DatagramSocket socket = new DatagramSocket();
                                //UDP 통신을 위한 DatagramPacket 생성, 보내기
                                byte[] buf = ("Audio On").getBytes();
                                DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 5514);
                                Log.d("Stop Mode On", "Data Send!!"); // 데이터 전송 확인을 위한 LOG
                                socket.send(packet);
                                //소켓 통신, Thread 종료
                                socket.close();
                                Thread.interrupted();
                            }
                        }
                        catch (Exception e) {
                            Log.e("UDP", "C: Error", e);
                        }
                    }
                }.start();
            }
            else if (i == R.id.st_check2) {
                sessionManager.StopMode(false);
                new Thread() {
                    public void run() {
                        try {
                            //서버 도메인 객체 생성
                            InetAddress serverAddr = InetAddress.getByName(getString(R.string.server_ip));
                            //UDP 통신을 위한 소켓
                            DatagramSocket socket = new DatagramSocket();
                            //UDP 통신을 위한 DatagramPacket 생성, 보내기
                            byte[] buf = ("Audio Off").getBytes();
                            DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 5514);
                            Log.d("Stop Mode Off", "Data Send!!"); // 데이터 전송 확인을 위한 LOG
                            socket.send(packet);
                            //소켓 통신, Thread 종료
                            socket.close();
                            Thread.interrupted();
                        }
                        catch (Exception e) {
                            Log.e("UDP", "C: Error", e);
                        }
                    }
                }.start();

            }
        }
    });
}

    public void FTP_Connect() {
                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //Raspberry Pi FTP Server Connect
                            ftpClient.connect(InetAddress.getByName(getString(R.string.server_ip)), 21);
                            ftpClient.login("pi", "pi1234");
                            System.out.println("connect success");

                            //접근 파일 타입 설정
                            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                            ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
                            //파일 다운 모드
                            ftpClient.enterLocalPassiveMode();
                            //FTP WorkingDirectory 변경
                            ftpClient.changeWorkingDirectory("/home/pi");

                            //스마트폰 저장 경로 설정
                            File getFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/Unknown.jpg");

                            //스마트폰에 FTP 서버 파일 저장
                            FileOutputStream outputStream = new FileOutputStream(getFile);
                            ftpClient.retrieveFile("/home/pi/Unknown.jpg", outputStream);

                            runOnUiThread(new Runnable() {    // 쓰레드 안에서 레이아웃 요소를 변경
                                @Override
                                public void run() {
                                    File imgFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/Unknown.jpg");

                                    if (imgFile.exists()) {
                                        //저장된 이미지 bitmap으로 변경
                                        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                        float scale = (float) (1024 / (float) myBitmap.getWidth());
                                        int image_w = (int) (myBitmap.getWidth() * scale);
                                        int image_h = (int) (myBitmap.getHeight() * scale);
                                        Bitmap resize = Bitmap.createScaledBitmap(myBitmap, image_w, image_h, true);
                                        resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                                        byte[] byteArray = stream.toByteArray();
                                        //Notification 생성
                                        createNotification(byteArray);
                                    }
                                }
                            });
                            //FTP 연결 종료
                            ftpClient.logout();
                            ftpClient.disconnect();
                        } catch (Exception e) {
                            Log.d("FTP Error", e.getMessage());

                        }

                    }
                });
                thread2.start();
    }

    //Notification Channel 생성
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CHANNEL_ID = "notiID";
            CharSequence name = "Reminder Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void createNotification(byte[] byte1) {
        //Notification 설정
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.warning)
                .setContentTitle("Brustar")
                .setContentText("침입 감지가 발생했습니다")
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL);

        //Intent로 이미지 전송
        Intent resultIntent = new Intent(getApplicationContext(), WarningActivity.class);
        resultIntent.putExtra("image", byte1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
        stackBuilder.addParentStack(WarningActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);
        notificationManager.notify(234, builder.build());
    }
}
