<!-- Heading -->
# Open CV,Open VINO, NIP 기반 스마트 애완견
# **목차**
 * ## Pi 별 실행 방법
 * ##  개요
 * ## 프로젝트 소개
 * ## 시장성 및 경쟁력 
 * ## 세부 내용
    * ### 기능 소개
     1. 하드웨어 및 모터
      2. OpenCV 기반 face_recognition
      3. OpenVINO 기반 object_detection
      4. DC MOTOR 이용 Human-Tracking
      5. NLP 기반 자연어 처리
      6. Raspberry Pi와 통신 App
      7. Raspberry Pi간 통신


# **Pi 별 실행 방법**
 ## 1. 자연어 처리 (python-docs-samples)
 * ## /python-docs-samples/speech_start.sh 실행
 ## 2. 서버 (workingDir)
 * ## speech서버 /workingDir/server.py 실행
 * ## App서버 /workingDir/socketServer.py 실행
 ## 3. Tracking 
 * ## process.sh 실행

# **개요** 
* ### 개발기간  2019.09.03~2019.12.12
* ### 개발목적 : 움직이는 AI 음성 비서 스마트 애완견
* ### 개발 일정 
![개발일정](https://user-images.githubusercontent.com/48273803/70620596-0cc41480-1c5b-11ea-8407-4fb4f3fadb30.PNG)
* ### 개인 역할 
![역할](https://user-images.githubusercontent.com/48273803/70611274-450e2780-1c48-11ea-91f0-d15300c1a71c.PNG)
* ### 주요 기능 및 기술 <br>
  * ### 보안 모드 : 빈 집에서 침입자가 들어왔을 때 App 알림
  * ### CCTV : App에서 항상 LiveStreaming으로 확인 가능.
  * ### 얼굴인증 : 사용자를 확인하여 부정한 사용자인지 올바른 사용자인지 확인
  * ### Object Detection : 프레임 상에서 사람이라는 객체를 찾아 트래킹
  * ### STT : 사용자가 명령한 음성을 text로 라즈베리 파이에 저장해 NLP처리
  * ### NLP : 입력받은 문장에서 단어를 찾아 분리 후 필요한 단어만 분리 한 후 단어의 원형 도출
  * ### TTS : 사용자가 명령한 음성을 STT로 처리한 text를 받아 음성 재생
  * ### AI : STT+TTS 사용해 AI 스피커 설계
  * ### 스위치 제어 : servo motor를 사용해 사용자 집 스위치 ON/OFF 제어


# **프로젝트 소개** 
 스마트 애완견이란?
  빠르게 변화하는 시대에 맞춰 가구의 형태도 급속도로 변화하고 있다. 통계청 발표에 따르면 2018년 10월 기준, 1인 가구의 수는 561만 3000가구로 전체 가구 형태 중 28.7%의 비중을 차지하고 있다. 본 논문에서는 이러한 1인 가구를 겨냥하여 Open CV, Open VINO, 자연어처리 기반으로 사용자를 인식하여 사용자와 대화하고 사용자를 따라다니는 스마트 애완견을 개발하였다. 스마트 애완견을 통해 사용자의 적적함과 외로움을 덜어주는 것에 긍정적인 효과를 볼 수 있다.

* ### 구성도
![구성도](https://user-images.githubusercontent.com/48273803/70619093-a25da500-1c57-11ea-9eba-df70cfe317ac.png)

* ### 개발환경

![개발환경경](https://user-images.githubusercontent.com/48273803/70623901-6f6cde80-1c62-11ea-8cfc-5e6342aa08d4.png)

# **시장성 및 경쟁력** 
* ### 시장성
    현재 AI스피커는 4차 산업 혁명시대에 주목받고 있는 사업이다. 향후 2025년까지 AI스피커는 약 25억대 이상 판매될 예정이다. 
* ### 경쟁력
![가정용 음성인식 하드웨어](https://user-images.githubusercontent.com/48273803/70624041-b5c23d80-1c62-11ea-8443-fb8a8827271c.PNG)
![ai](https://user-images.githubusercontent.com/48273803/70624037-b4911080-1c62-11ea-9c0e-fc8607f19e76.PNG)

* ### 가정용 스마트 스피커에선 경쟁 제품을 보게 되면 스피커안에 Assistant 소프트웨어를 탑재한 형식으로 많이 출시.
* ### 스마트 애완견은 경쟁 제품에 있는 Assistant에다가 집에서 사람을 트래킹하는 이동식 스마트 스피커.
* ### 스마트 애완견은 도어락에 많이 들어 있는 침입자 발생 시 사용자 어플에 알림을 해주는 보안 기능 탑재. 

# **세부내용** 

# **HardWare**
## 1.하드웨어 구성품
   dagu rover5

![dagu](https://user-images.githubusercontent.com/48273803/70624657-18680900-1c64-11ea-8388-576118c73be7.jpg)

   L298N

![L298N](https://user-images.githubusercontent.com/48273803/70624817-68df6680-1c64-11ea-9421-e52dbf516545.png)

   12V 건전지홀더

![12V 건전지홀더](https://user-images.githubusercontent.com/48273803/70624973-cffd1b00-1c64-11ea-9553-a08ed72432d4.jpg)

## 2. Motor 구동
   Motor 구동을 위한 RPi 패키지 설치

![RPi 패키지](https://user-images.githubusercontent.com/48273803/70630173-7c8fca80-1c6e-11ea-8501-10c04b6bf9ad.png)

![rpi update](https://user-images.githubusercontent.com/48273803/70630304-b660d100-1c6e-11ea-8247-3544fe0b02f9.png)

   회로도

![회로도](https://user-images.githubusercontent.com/48273803/70629092-ba8bef00-1c6c-11ea-8871-a05e378e46e3.png)

   Raspberry pi GPIO 핀 설정과 구동 함수

![motor 구동 설명](https://user-images.githubusercontent.com/48273803/70631472-8fa39a00-1c70-11ea-8bc5-afec22f8f182.png)

   구동 함수

![구동함수](https://user-images.githubusercontent.com/48273803/70631928-4869d900-1c71-11ea-9c4e-753c78b0a535.png)
![구동함수2](https://user-images.githubusercontent.com/48273803/70631932-4a339c80-1c71-11ea-8c95-7a2fefa2fa0c.png)

## 3. servo motor로 카메라 제어하기

   Servo Motor를 Raspberry pi와 연결하기

![servo motor raspberry pi](https://user-images.githubusercontent.com/48273803/70642567-c2ef2480-1c82-11ea-8cbd-0fdb5c665f0e.png)

![servo 표](https://user-images.githubusercontent.com/48273803/70642285-48260980-1c82-11ea-9c26-0bde79d8fcfd.png)

   Servo Motor 핀 설정 & 구동

![servo 제어](https://user-images.githubusercontent.com/48273803/70636831-8d920900-1c79-11ea-9ab9-55d71d782ffa.png)

Servo Motor detection mode

![servo 올리기](https://user-images.githubusercontent.com/48273803/70651009-719b6100-1c93-11ea-80a6-08c94553ac3d.png)

Servo Motor tracking mode

![servo 종료](https://user-images.githubusercontent.com/48273803/70660326-3dc93700-1ca5-11ea-89a3-b9e6a9416b5b.JPG)

앱에서 Stop Mode 버튼 누르면 카메라가 원위치 되면서 종료


# **Nueral Compute Stick 2**
## 1. Intel Nueral Compute Stick 1 & Intel Nueral Compute Stick 2
![Nueral stick](https://user-images.githubusercontent.com/48273803/69005852-0a77de80-096b-11ea-8ee4-8f464e00c63c.png)
상호간의 코드가 호환 되지 않음으로 예제 참고시 주의
## **2. 환경구축** 
## 환경 구축 간에 OpenCV와 OpenVINO는 각각의 가상환경에서 따로 설치할 것을 권장
  1) Intel  Nueral Compute Stick 공식 홈 페이지 접속
    * ![image](https://user-images.githubusercontent.com/48273803/69005936-039d9b80-096c-11ea-8556-75944f0905cf.png) <br>
    https://docs.openvinotoolkit.org/latest/_docs_install_guides_installing_openvino_raspbian.html
  2) 가장 최신 버전 선택<br>
    ![image](https://user-images.githubusercontent.com/48273803/69005957-3778c100-096c-11ea-9efb-21aed84f44aa.png)
    https://download.01.org/opencv/2019/openvinotoolkit
  3) 자신의 개발 환경에 맞게 다운로드
    ![image](https://user-images.githubusercontent.com/48273803/69006117-1c0eb580-096e-11ea-9f5c-80e7fd799196.png)
    
  3) 파일질라를 통하여 원하는 디렉터리에 zip 파일 전송
    ![image](https://user-images.githubusercontent.com/48273803/69005959-46f80a00-096c-11ea-8d7a-01b9475bfe73.png)

  4) OpenVINO 압축해제
    ![image](https://user-images.githubusercontent.com/48273803/69005976-70189a80-096c-11ea-8d68-37795a6e715b.png)<br> $sudo tar -xf l_openvino_toolkit_runtime_raspbian_p_2019.3.334.tgz --strip 1 -C ~/OpenVINO
  5) OpenVINO 환경변수 업데이트 및 설정<br>![image](https://user-images.githubusercontent.com/48273803/69005986-aa823780-096c-11ea-8b71-50dd2e1aaa07.png)<br> $source ~/OpenVINO/bin/setupvars.sh <재부팅시 초기화> <br> $echo "source ~/OpenVINO/bin/setupvars.sh">> ~ / .bashrc<br>Default 값으로 설정                          <재부팅시 초기화x>
  6) $~/.bashrc 에서 설정 확인
    ![image](https://user-images.githubusercontent.com/48273803/69006021-0056df80-096d-11ea-9a04-4d1981c5c07c.png)
  7) 설정 후 터미널 실행 시 [setupvars.sh] OpenVINO environment initialized 출력 확인 가능<br>![image](https://user-images.githubusercontent.com/48273803/69006055-4a3fc580-096d-11ea-811f-96cc205f94c0.png)
  8) 현재 Raspberry Pi 사용자를 user 그룹에 추가<br>![image](https://user-images.githubusercontent.com/48273803/69006059-617eb300-096d-11ea-9c03-5617514e545a.png)
  9) USB 포트 설치 <br>![image](https://user-images.githubusercontent.com/48273803/69006069-7e1aeb00-096d-11ea-9b60-e4ee7a96431f.png)

# **Face Authentication**
https://youtu.be/L7W-cCmu4bI
## 1. Face Authentication 순서
1) 얼굴 검출(Detection)
2) 얼굴 특징 추출(Alignment)
3) 표준화(Normalization)
4) 인식(Recognition)
## 2. Face Authentication 필요 패키지 및 원리
 1) 필요 패키지 설치
    * $pip3 install opencv-python <br>![image](https://user-images.githubusercontent.com/48273803/69006387-dfdd5400-0971-11ea-9d1b-9ee591ffb0c2.png)
    * $pip3 install opencv-contrib-python<br>![image](https://user-images.githubusercontent.com/48273803/69006485-aeb15380-0972-11ea-8990-d55beb58a101.png)
    * $pip3 install dlib <br>![image](https://user-images.githubusercontent.com/48273803/69006496-da343e00-0972-11ea-83c9-27c2d51b6970.png)
    * $pip3 install face_recognition<br>![image](https://user-images.githubusercontent.com/48273803/69006510-fe901a80-0972-11ea-9bb5-54ce5b2d594e.png)
    * $pip3 install flask<br>![image](https://user-images.githubusercontent.com/48273803/69006516-2bdcc880-0973-11ea-82fe-84910512d01e.png)
2) Face Authentication 원리
    * 얼굴만 있는 사진으로 얼굴 학습<br>
    ![image](https://user-images.githubusercontent.com/48273803/70610132-5d7d4280-1c46-11ea-84cc-11111c721056.png)
    * 사진 또는 동영상에서 얼굴 검출<br>![image](https://user-images.githubusercontent.com/48273803/69006985-e58b6780-097a-11ea-80ff-e6a7e5418be0.png)
    * Face LadMark<br>![image](https://user-images.githubusercontent.com/48273803/69006996-22575e80-097b-11ea-93b0-8040228f7853.png)<br>검출된 얼굴에서 68개의 LandMark 생성<br>
    ![image](https://user-images.githubusercontent.com/48273803/69007017-84b05f00-097b-11ea-87a0-6d7c33e5f355.png)
       ```
       import face_recognition
        import cv2
        import camera
        import os
        import numpy as np
        import ser as cammotor
       ```
       ```
        if min_value < 0.6:
                        index = np.argmin(distances)
                        name = self.known_face_names[index]
                        self.__del__()
                        cammotor.trackingmode()
                        cammotor.cleanup()
                        os.system("./object_start.sh")
                    self.face_names.append(name)
                    if name == "Unknown":
                        cv2.imwrite('/home/pi/Unknown.jpg',frame)
                        warning=open('/home/pi/workingDir/info.txt','w')
                        warning.write("1")
                        warning.close()
       ```
   
3) Face Recognition 결과
    * KNOWN Directory 안의 이미지 파일로 인증
   ![image](https://user-images.githubusercontent.com/48273803/70610636-4559f300-1c47-11ea-842c-c3d6b42e8a1f.png)
   * Knowns Diretory 내에 .jpg 파일 읽어온 후 비교
   ![image](https://user-images.githubusercontent.com/48273803/70613010-4bea6980-1c4b-11ea-9081-74b2cc3017ed.png)
    * 아는 사람일 경우 해당 파일 이름 출력
   ![image](https://user-images.githubusercontent.com/48273803/70610372-cebcf580-1c46-11ea-97c6-3a4d9b516706.png)
   * 모르는 사람일 경우 UNKNOWN 출력
   ![image](https://user-images.githubusercontent.com/48273803/70610515-0d52b000-1c47-11ea-8713-d23b5ae2f7d8.png)


# **Object Detection**
[DCMotor Human_Trackking](https://youtu.be/El-TT31SUvM)<br>
[DCMotor Human_Trackking2](https://www.youtube.com/watch?v=1wfB_Xf1-L8)
## 1. Object Detection 순서
  1) 인식할 객체Dataset 수집
  2) 알맞은 Framwork 또는 Model 선정
      ### 1. Tensorflow Framework란
     ![image](https://user-images.githubusercontent.com/48273803/70614295-95d44f00-1c4d-11ea-98b7-b1a1ba1f74f3.png)
     * MobileNet, Inception 등 여러 Model을 지원하는 Framework

     * 특징 추출

        ![image](https://user-images.githubusercontent.com/48273803/70616928-e5694980-1c52-11ea-9d1a-670338177618.png)
![image](https://user-images.githubusercontent.com/48273803/70616844-b7840500-1c52-11ea-8ecb-dd48ad1f5d4a.png)

      * SSD(Single Shot multibox Detector)
![image](https://user-images.githubusercontent.com/48273803/70621754-a096e000-1c5d-11ea-9200-a84cd3aee2a7.png)
        * 테두리 조정을 위한 픽셀 및 특징 재추출을 하지 않는다.
  3) 예외처리 및 필요한 동작 처리
        ```
          import sys
          if sys.version_info.major < 3 or sys.version_info.minor < 4:
            print("Please using python3.4 or greater!")
            sys.exit(1)
        import numpy as np
        import cv2, io, time, argparse, re
        from os import system
        from os.path import isfile, join
        from time import sleep
        import multiprocessing as mp
        import motor_test as motor
        import os

        try:
            from armv7l.openvino.inference_engine import IENetwork, IEPlugin
        except:
            from openvino.inference_engine import IENetwork, IEPlugin
        import heapq
        import threading

        lastresults = None
        threads = []
        processes = []
        frameBuffer = None
        results = None
        fps = ""
        detectfps = ""
        framecount = 0
        detectframecount = 0
        time1 = 0
        time2 = 0
        cam = None
        camera_width = 320
        camera_height = 240
        window_name = ""
        ssd_detection_mode = 1
        face_detection_mode = 0
        elapsedtime = 0.0

        LABELS = [['background',
                   'aeroplane', 'bicycle', 'bird', 'boat',
                   'bottle', 'bus', 'car', 'cat', 'chair',
                   'cow', 'diningtable', 'dog', 'horse',
                   'motorbike', 'person', 'pottedplant',
                   'sheep', 'sofa', 'train', 'tvmonitor'],
                  ['background', 'face']]

        ```
        ```
           
               if label_yd == 15:
                   khx = int(((box_right-box_left)/2)+box_left)
                   khy = int(((box_top-box_bottom)/2)+box_bottom)
                   cv2.circle (img_cp, (int(((box_right-box_left)/2)+box_left), int(((box_top-box_bottom)/2)+box_bottom)) ,10, (255,0,0), -1)
                   box_color = (255, 128, 0)
                   box_thickness = 1
                   cv2.rectangle(img_cp,(box_left, box_top), (box_right, box_bottom), box_color, box_thickness)

                   label_background_color = (125, 175, 75)
                   label_text_color = (255, 255, 255)
                   label_size = cv2.getTextSize(label_text, cv2.FONT_HERSHEY_SIMPLEX, 0.5, 1)[0]
                   label_left = box_left
                   label_top = box_top - label_size[1]
                   if (label_top < 1):
                       label_top = 1
                   label_right = label_left + label_size[0]
                   label_bottom = label_top + label_size[1]

                   cv2.rectangle(img_cp, (label_left - 1, label_top - 1), (label_right + 1, label_bottom + 1), label_background_color, -1)
                   cv2.putText(img_cp, label_text, (label_left, label_bottom), cv2.FONT_HERSHEY_SIMPLEX, 0.5, label_text_color, 1)

                   if 135 < khy and khy < 150 :
                       if khx < 135 :
                           motor.turnLeft()
                       elif khx > 185 :
                           motor.turnRight()
                       else:
                           motor.forward_1()
                   elif 150 < khy :
                       if khx < 135 :
                           motor.turnLeft()
                       elif khx > 185 :
                           motor.turnRight()
                       else:
                           motor.forward_2()
                   elif khy < 105 :
                       motor.Reverse()
                   else:
                       motor.brake()
        ```
        <image src= "https://user-images.githubusercontent.com/48273803/70627566-ce822180-1c69-11ea-9515-ce6ddf9918e2.png" width="320" height="200">

  
  4) 결과<br>
    <image src= "https://user-images.githubusercontent.com/48273803/70621870-efdd1080-1c5d-11ea-9000-b8c98378b815.png" width="320" height="200">

# **NLP**
## 1. Deep Learning 기반 NLP 순서
  1) 토큰화 
  2) 불용어제거
  3) 어간추출
  4) 문서표현
## 2. NLTK 환경구축
* 자신의 python 환경에 맞게 pip/pip3 nltk 설치
![image](https://user-images.githubusercontent.com/48273803/70631140-0e4c0780-1c70-11ea-8f6a-968d8681d80b.png)
* 데이터셋 다운로드를 위해 nltk.download('all') 설치 (한 번만 설치하면 되므로 all 권장)<br>
![image](https://user-images.githubusercontent.com/48273803/70633010-2cffcd80-1c73-11ea-8958-712b807a9e63.png)


### 토큰화(tokenize)
   * 문자열에서 공백을 기준으로 단어를 분리시키는 작업<br>
   ![image](https://user-images.githubusercontent.com/48273803/70636009-30e21e80-1c78-11ea-8efd-c9edce78e78f.png)
   
### 불용어제거(sptopwords)
   * 문자열에서 의미가 없는 단어 토큰을 제거하는 작업
       * 불용어 목록중 예시 출력<br>
   ![image](https://user-images.githubusercontent.com/48273803/70631717-f032d700-1c70-11ea-8002-37cd71f0d53e.png)
   ![image](https://user-images.githubusercontent.com/48273803/70631766-09d41e80-1c71-11ea-89ca-604139f77c90.png)
   ![image](https://user-images.githubusercontent.com/48273803/70636073-4bb49300-1c78-11ea-8ef7-2336c57e89ff.png)

### 표제어 추출(Lemmatizer)
* 단어 원형 추출
   
   ![image](https://user-images.githubusercontent.com/48273803/70635137-bcf34680-1c76-11ea-8936-d74a833b22f5.png)


### 문서표현 및 결과 출력
![image](https://user-images.githubusercontent.com/48273803/70635706-baddb780-1c77-11ea-896f-b8de7a8f0ff9.png)



# **Google speech 사용 음성 인식 및 처리**
[음성처리](https://www.youtube.com/watch?v=IVFLcCBhQwY&feature=youtu.be)
## 1. Tracking용으로 사용할 Raspberry pi에 Google speech 설치
1) 라즈베리파이에 pyaudio를 설치  
 $ sudo apt-get install libportaudio0 libportaudio2 libportaudiocpp0 portaudio19-dev  
 $ sudo apt-get install python-dev  
 명령어 실행 후  
 방법 1.  
 $ sudo pip install pyaudio   
방법 2.  
 $ sudo apt-get install git  
 $ sudo git clone http://people.csail.mit.edu/hubert/git/pyaudio.git  
 $ cd pyaudio  
 $ sudo python setup.py install   
방법 1이 안될 시에 방법 2를 사용한다.
  
2) Google Action Console에 접속한다.   
 -로그인 후 project를 새로 만든다.  
 -api library에서 google speech를 검색한 후 API 사용설정을 눌러 활성화 시킨다.  
 -서비스계정 키 생성 페이지(https://console.cloud.google.com/projectselector2/apis/credentials/serviceaccountkey?_ga=2.40899618.-1016148464.1531368544&supportedpurview=project) 접속 후 방금 만든 상단 프로젝트 선택에서 프로젝트를 선택한 후 서비스 계정을 생성한다.   
 ![서비스](https://user-images.githubusercontent.com/48273803/69046236-d91b1380-0a3b-11ea-8e9d-0c00a0c603a7.png)  
 -서비스 계정 선택은 새 서비스 계정을 누르고 키 유형은 JSON을 선택한다. 이때 역할은 프로젝트의 소유자로 설정한다. 완료되면 생성 버튼을 누른다.  
 -생성 버튼을 누르면 .json 파일이 하나가 다운로드 된다.  
 -이 파일을 라즈베리파이로 옮겨 /home/pi 경로에 붙여넣는다.  
  ***이때 절대로 파일 이름을 변경해서는 안된다.***  
  
3) 다시 라즈베리파이로 돌아와 터미널에 아래의 명령어를 본인에 맞게 수정하여 입력한다.  
 $ export GOOGLE_APPLICATION_CREDENTIALS="/home/user/Downloads/[FILE_NAME].json"  
 -입력하면 별다른 변화 없이 넘어가는데 이로써 인증이 완료된 것이다.  
4) 아래 명령을 통해 샘플코드들을 다운받는다.  
 $ git clone https://github.com/GoogleCloudPlatform/python-docs-samples.git  
5) 샘플 코드 다운 후 파이썬 가상환경을 실행시켜 준다.  
  $ sudo apt-get update  
  $ sudo apt-get install python3-dev python3-venv  
  $ python3 -m venv env  
  $ env/bin/python -m pip install --upgrade pip setuptools wheel  
  $ source env/bin/activate  
  ![가상환경접속](https://user-images.githubusercontent.com/48273803/69046962-79be0300-0a3d-11ea-9c8f-f0a6d0132989.JPG)  
6) 이 샘플코드들 중 우리가 원하는 음성인식 코드는 python-docs-samples/speech/microphone/ 경로에 있다.  
 (env) $ cd python-docs-samples/speech/microphone/  
 -앞으로의 모든 과정은 python-docs-samples/speech/microphone/ 경로에서 진행된다.  
 -이제 해당 디렉토리내에 있는 requirements.txt 파일을 설치하기 위해 아래 명령을 입력한다.  
 (env) $ pip install -r requirements.txt  
7) 마이크를 이용해 영어 문장을 인식하는 예제 코드는 transcribe_streaming_mic.py로 저장되어 있다.  
 (env) $ python transcribe_streaming_mic.py   
8) 터미널 창에서 끝나지 않고 커서만 깜박거리는데, 이 상태에서 영어로 문장을 말하면 터미널에 본인이 말한 문장이 출력된다.   
 ![실행2](https://user-images.githubusercontent.com/48273803/69046694-fc928e00-0a3c-11ea-9748-90bd4e79d80a.JPG)  
 ![실행1](https://user-images.githubusercontent.com/48273803/69046693-fb616100-0a3c-11ea-9540-45092b5e3a70.JPG)  
 ![실행결과](https://user-images.githubusercontent.com/48273803/69047218-ffda4980-0a3d-11ea-98be-8bb23b0d3636.JPG)  
***음성인식 프로그램이 작동되는 시간은 대략 65초 정도이며 이상이 되면 자동으로 정지된다.***  
## 2. 서비스 키 환경변수에 저장 & shell script file 작성  
1) Google speech에서 발급받은 서비스 키를 환경변수에 저장해 실행 때마다 서비스 키 등록하는 과정을 없앤다.  
   - bash.bashrc 파일 끝에 서비스키 json 파일을 등록한다.  
![image](https://user-images.githubusercontent.com/48273803/70127810-1c71b500-16bf-11ea-8691-777a33778dc7.png)  
![image](https://user-images.githubusercontent.com/48273803/70127824-1f6ca580-16bf-11ea-8de2-9a6713a6cfe0.png)  

2) shell script 파일 실행으로 가상환경 접속 및 파일 위치 이동 과정을 줄여준다.  
![image](https://user-images.githubusercontent.com/48273803/70127828-21ceff80-16bf-11ea-8172-ee2605f01b32.png)

## 3. NLP에 Google speech 결과 전달 후 문장 토큰화  
 1) Google speech to text 결과를 text파일 형태로 저장하고 os.system으로 nlp처리 python 파일 실행    
 ![결과저장](https://user-images.githubusercontent.com/48273803/69054549-2b196480-0a4f-11ea-82ce-40548bf71403.JPG)
 2) stt결과  
 ![stt 결과](https://user-images.githubusercontent.com/48273803/69054550-2b196480-0a4f-11ea-82ec-8bfaaca37a0d.JPG)
 3) nlp에서 stt결과 text파일 읽어오기  
 ![nlp 읽어오기](https://user-images.githubusercontent.com/48273803/69054552-2b196480-0a4f-11ea-9b5b-df3ce4ad305f.JPG)
 4) nlp처리 결과를 새로운 text 파일에 ' '로 구분하여 저장  
 ![nlp 처리](https://user-images.githubusercontent.com/48273803/69055491-38375300-0a51-11ea-888d-55cdad1774e1.JPG)    
 5) nlp처리를 통한 문장 토큰화 결과  
 ![nlp 결과](https://user-images.githubusercontent.com/48273803/69055213-9fa0d300-0a50-11ea-81d8-9c1ff4e39d02.JPG)  
## 4. 토큰화 된 문장으로 기능 만들기    
 1) nlp처리 python 코드에서 기능 구현 python 코드 실행하기  
 ![nlp넘기기](https://user-images.githubusercontent.com/48273803/69057085-97e32d80-0a54-11ea-8edc-4588e6bc6f59.JPG)  
 2) 기능 구현 코드에서 nlp처리 결과가 저장되어 있는 text파일 읽어오기  
 ![nlp결과읽어오기](https://user-images.githubusercontent.com/48273803/69057086-97e32d80-0a54-11ea-8f8e-1cc251f7f998.JPG)  
 3) 규칙 기반으로 토큰화된 문장 처리하여 기능 구현하기  
 ![규칙기반처리](https://user-images.githubusercontent.com/48273803/69057087-987bc400-0a54-11ea-8238-2b319adbd0b9.JPG)  
![규칙기반처리2](https://user-images.githubusercontent.com/48273803/69057090-987bc400-0a54-11ea-91b3-3fbeb0946283.JPG)  
 
# **Text-To-Speech (TTS)를 사용한 기능 구현**
## 1. 1.(2)방법으로 ACTION ON GOOGLE 에서 서비스키 생성 ##
## 2. 설정한 가상 환경 접속
* ### $ source env/bin/activate    
## 3. TTS 파이썬 모듈 설치
* ### $ sudo apt-get install mpg321
![mpg321](https://user-images.githubusercontent.com/48273803/69005692-0e0a6600-0969-11ea-916b-e9d9de446748.JPG)
* ### $ pip install gTTS
![gTTS](https://user-images.githubusercontent.com/48273803/69005685-f03d0100-0968-11ea-9d13-75b978adc420.JPG)

## 4. TTS 로 모터구동시 알림
### 1) 녹음
![control](https://user-images.githubusercontent.com/48273803/69005699-267a8080-0969-11ea-9905-64c5ad21b466.JPG) 
* #### $ python
  #### >> from gtts import gTTS
  #### >> import os
  #### >> tts = gTTS(text='turnnig on the light ',lang='en')
  #### >> tts.save("controllight.mp3")
  #### >> exit()  
### 2) mp3 파일 실행
* ###  **python 파일에 os.system("mpg321 controllight.mp3") 추가**
## 5. TTS 로 현재 날씨 알려주기(네이버 크롤링)
### 1) 네이버 날씨 접속후 키보드 F12 누르고 개발자도구 창 확인후 화살표 클릭
  ![네이버 화살표](https://user-images.githubusercontent.com/48273803/69006356-6c3b4700-0971-11ea-8286-cd1fdcb598dd.JPG)
### 2) 클릭 후 웹페이지로 넘어가 자신이 원하는 정보에 마우스 커서를 가져간 후 클릭
![네이버 활성화](https://user-images.githubusercontent.com/48273803/69006433-5d08c900-0972-11ea-993b-2e2b7fa8653b.JPG)
### 3) span class="todaytemp" 찾기 
![네이버 화살표 2](https://user-images.githubusercontent.com/48273803/69006526-69d9ec80-0973-11ea-9372-ff7232371dba.JPG) 

### 4) Beautiful Soup 라이브러리 설치
![bs4](https://user-images.githubusercontent.com/48273803/69006720-980cfb80-0976-11ea-8f4b-3603af52281f.JPG)
### 5) Beautiful Soup (html5lib) 설치 
![html5lib](https://user-images.githubusercontent.com/48273803/69006723-99d6bf00-0976-11ea-83e6-cd765760515a.JPG)

### 6) Python 코드 작성후 Weather.mp3 저장
![weathermp3](https://user-images.githubusercontent.com/48273803/69006736-d4d8f280-0976-11ea-9e24-665887c119dc.JPG)
### 7) Weather.mp3 실행
* ###  **python 파일에 os.system("mpg321 weather.mp3") 추가** 

## 6. TTS 로 YOUTUBE 동영상 실행
### 1) 파이썬 에 있는 웹 브라우저 열어주는 기능(webbrowser) 실행
$ python
#### >> import webbrowser
#### >> webbrowser.open("https://www.youtube.com")
![youtube](https://user-images.githubusercontent.com/48273803/69007199-01dcd380-097e-11ea-9b97-3bb0187800bc.JPG)
### 2) Webbrowser 닫기
$ python
#### >> import os
#### >> os.system("pkill chromium")
![pkill](https://user-images.githubusercontent.com/48273803/69007198-01443d00-097e-11ea-8dff-33476f86398d.JPG)
## 7. 파이썬 DateTime 사용 현재 시간 알려주기
![asdasdasdasdasdad](https://user-images.githubusercontent.com/48273803/70637359-70116f00-1c7a-11ea-9f11-c0e5d8674020.JPG)
### 1) from datetime import datetime 사용 Raspberry Pi 년 월 일 시 분 가져오기
### 2) text=str(now.year),str(now.month),str(now.day)사용 하여 TTS mp3 파일 생성
### 3) python(mpg321 time.mp3) 재생

## 8. Wikipedia 검색
### 1) Wikipedia 라이브러리 설치(pip , pip3 둘다 가능)
![asdasdasdasdasdas](https://user-images.githubusercontent.com/48273803/70653202-5b8f9f80-1c97-11ea-842a-a99ffcf6e248.JPG)
![asdfasdfasdfasdfasdfa](https://user-images.githubusercontent.com/48273803/70653205-5cc0cc80-1c97-11ea-8fcc-e23ddcc5f40d.JPG)
### 2) Split 사용하여 단어 자르기
![단어 2222](https://user-images.githubusercontent.com/48273803/70651484-42d1ba80-1c94-11ea-9a19-38e1248aabba.JPG)

### 3) NLP 사용할 때 text(Google speech 사용 음성 인식 및 처리 4-1 참조) 파일 Split으로 잘라서 마지막 단어 만 추출 후 splits 에 저장
#### >> s = line.split(' ')[-1]
### 4) 2)에서 저장한 마지막 단어 (splits)를 새로운 text 파일에 저장
#### >> f = open("/home/pi/Hi-Pass/python-docs-samples/speech/microphone/laststr.txt","w")
#### >> f.write(splits)
#### >> f.close 
### 5) Wikipedia python 라이브러리 사용 
![단어 333333](https://user-images.githubusercontent.com/48273803/70652208-90025c00-1c95-11ea-88f9-e963c482cbee.JPG)
### 6) 3)에서 저장한 text 파일 불러와서 lastword 에 저장
### 7) page_py = wiki.page(lastword) 마지막 단어를  wikipedia라이브러리 에 사용준비
### 8) page_py.exists() = False면 검색 불가능 mp3 재생
#### >> tts=gTTS(text = '검색 결과가 없습니다.',lang = 'ko')
#### >> tts.save("wikif.mp3")
#### >> os.system("mpg321 wikif.mp3")
### 9) page_py.exists() = True 면 검색 가능 page_py.summary[0:80]까지 저장 후 mp3 재생
#### >> text3 = page_py.summary[0:80]
#### >> tts=gTTS(text=text3,lang='ko')
#### >> tts.save("wiki.mp3")
#### >> os.system("mpg321 wiki.mp3")
## 9. 간단한 Beatbox 예제 실행 
### 1) TTS 방법으로 예상되는 AI 대답 작성 후 mp3 저장 후 실행 
![1231231231313123123](https://user-images.githubusercontent.com/48273803/70653481-e8d2f400-1c97-11ea-8833-38797d69fe6e.JPG)
## 10. 간단한 유머 작성 후 랜덤으로 실행 
### 1) funny.mp3 
![funny1](https://user-images.githubusercontent.com/48273803/70653832-91815380-1c98-11ea-9dbf-66f2621e82a5.JPG)
### 2) funny1.mp3
![funny2](https://user-images.githubusercontent.com/48273803/70653837-9219ea00-1c98-11ea-8741-047846de8d37.JPG)
### 3) funny2.mp3
![funny3](https://user-images.githubusercontent.com/48273803/70653840-934b1700-1c98-11ea-9e21-f32fb80acbba.JPG)
### 4) funny3.mp3
![funny4](https://user-images.githubusercontent.com/48273803/70653841-947c4400-1c98-11ea-879e-949a721991f1.JPG)
### 5) STT실행 파일 에서 랜덤으로 출력 
![asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfadfs](https://user-images.githubusercontent.com/48273803/70654244-4156c100-1c99-11ea-9bba-1651c31d74b1.JPG) 랜덤 사용 준비
### 6) List 안에 있는 배열중 한가지 랜덤으로 선택 후 if문이 맞으면 mp3재생
![12312313123123123123](https://user-images.githubusercontent.com/48273803/70654346-7bc05e00-1c99-11ea-8745-5a8fd937ef56.JPG)

# STT + TTS = AI스피커 실행
## 1. 날씨 알려주기
* weather 값 과 today 이 들어오면 os.system 사용

![weather](https://user-images.githubusercontent.com/48273803/70655100-fb026180-1c9a-11ea-95bb-dca386c09234.JPG)

## 2. 시간 알려주기
* time 값 이 들어오면 os.system 사용
 
![time](https://user-images.githubusercontent.com/48273803/70655139-0eadc800-1c9b-11ea-9415-d2c3d0eeed50.JPG)

## 3. Wikipedia 검색
* Wikipedia 값 이 들어오면 os.system 사용

![wikipe](https://user-images.githubusercontent.com/48273803/70655289-53d1fa00-1c9b-11ea-8b9c-da89c49c9a2c.JPG)

## 4. BeatBox 실행
* beat 값 과 box 이 들어오면 os.system 사용

![beatboxx](https://user-images.githubusercontent.com/48273803/70655324-64827000-1c9b-11ea-9cfb-6669b43de28c.JPG)

## 5. Funny 실행
* tell 값 과 funny 이 들어오면 list 배열 랜덤으로 나눈 후 os.system 사용 

![funnny](https://user-images.githubusercontent.com/48273803/70655343-6b10e780-1c9b-11ea-9a9f-d3082c708114.JPG)


# **Android App**
 [App](https://youtube.com/watch?v=J6I7cMclBDQ&feature=youtu.be)
## 1. App Design

* **App Icon**

![App Icon](https://user-images.githubusercontent.com/48273803/70651179-b7582980-1c93-11ea-8658-aa8c96ae0fd6.png)

* **Loading, Login, SignUp Page**

![loading_login_signup](https://user-images.githubusercontent.com/48273803/70651990-339f3c80-1c95-11ea-80fa-944a3d3f4c38.PNG)

* **Home, CCTV, Setting Page**

![main_cctv_setting](https://user-images.githubusercontent.com/48273803/70652200-8d076b80-1c95-11ea-86bc-3b1a4158f544.PNG)

* **Warnging Page**

![Warning](https://user-images.githubusercontent.com/48273803/70652533-1880fc80-1c96-11ea-84fe-c9cb48c10dd5.PNG)

## 2. DataBase 연동 (회원가입)

* **Android Studio Java Code**

![signup_database](https://user-images.githubusercontent.com/48273803/70652814-9f35d980-1c96-11ea-9536-25d4e69851c3.PNG)

Id와 Pw 값을 FTP Server의 member.php에 보내고 성공 여부 값을 받는다.

* **member.php**
```
<?php
$con=mysqli_connect("localhost","(username)","(password)","(dbname)");
mysqli_set_charset($con,"utf8");
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$userid = $_POST['Id'];
$userpw = $_POST['Pw'];
$result = mysqli_query($con,"INSERT INTO Member (M_id,M_pwd) values ('$userid','$userpw')");
if($result){
    echo 'success';
} 
else{
    echo 'failure';
}
mysqli_close($con);
?>
```
Android에서 받은 값을 db에 저장하고 success 값을 Android에 보낸다.

## 3. DataBase 연동 (로그인)

* **Android Studio Java Code**

![login_database](https://user-images.githubusercontent.com/48273803/70654310-65b29d80-1c99-11ea-87e7-26ffee0506b4.PNG)

Id와 Pw 값을 FTP Server의 login.php에 보내고 로그인 성공 여부 값을 받는다.

* **Login.php**
```
<?php
$con=mysqli_connect("localhost","dlaeorms","eorms7427!","dlaeorms");
mysqli_set_charset($con,"utf8");
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$userid = $_POST['Id'];
$userpw = $_POST['Pw'];
$sql = "SELECT * FROM Member WHERE M_id='$userid' AND M_pwd='$userpw' ";
$result = mysqli_query($con, $sql);
if(mysqli_num_rows($result) == 1 ){
    echo 'success';
}
else{
     echo 'failure';
}
mysqli_close($con);
?>
```
Android에서 받은 값을 db의 값과 비교하고 만약 같은 값이 있다면 success 값을 Android에 보낸다.

## 4. 회원가입 유효성 검사 

* **ID 유효성 검사**

![Id_check](https://user-images.githubusercontent.com/48273803/70654849-7adbfc00-1c9a-11ea-98ef-d856f1a96e1e.PNG)

입력된 아이디의 길이를 체크하여 6자리 미만일 경우 에러메시지를 출력한다.

* **PASSWORD 유효성 검사**

![pw_check](https://user-images.githubusercontent.com/48273803/70654945-ad85f480-1c9a-11ea-9b8a-f2128d6bddd6.PNG)

입력된 비밀번호의 ASCII CODE 값을 비교하여 숫자, 영문자, 특수문자 수를 저장하고 각 문자가 하나라도 입력되지 않을 경우 에러메시지를 출력한다.

## 5. Session

* **Session Manager**

Android의 각종 데이터를 지속 저장하기 위해 Session Manager를 생성

![SessionManager](https://user-images.githubusercontent.com/48273803/70655515-c04cf900-1c9b-11ea-93a0-4d4ce79fc963.PNG)

1. 로그인 시 ID 저장
2. Security Mode, Stop Mode의 On/Off 저장
3. 로그아웃 기능

# **Android App Raspberry Pi FTP Server 접속**

## 1. Raspberry Pi FTP Server 구축

**1. vsftpd 설치**
```
sudo apt-get install vsftpd
```
**2. vsftpd 설정 수정 (주석 제거)**
```
sudo nano /etc/vsftpd.conf
```
* local_enable=YES
* write_enable=YES
* local_umask=022
* chroot_local_user=YES
* chroot_list_enable=YES
* chroot_list_file=/etc/vsftpd.chroot_list

**3. 라즈베리파이 아이디 추가**
```
sudo nano /etc/vsftpd.chroot_list
```
* Raspberry pi Id 입력 (pi)

**4. vsftpd 재시작**
```
sudo systemctl restart vsftpd
```

**5. 자동실행 설정**
```
sudo systemctl enable vsftpd
```

## 2. Android App FTP Server 접속

**1. FTP Client 라이브러리**

* 해당 링크에서 commons-net-3.6-bin.zip을 다운 받는다.

http://commons.apache.org/proper/commons-net/download_net.cgi

* 라이브러리 추가

![ftpclient](https://user-images.githubusercontent.com/48273803/70659230-05285e00-1ca3-11ea-9c12-9d405255a7bf.PNG)

Android Studio의 해당 폴더에 다운받은 파일을 붙혀넣기 후 Add Library를 실행한다.

**2. Android FTP Code**

```
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
```
FTP Server에 접속하기 위해 설치해준 FTPClient를 import 한다.

![ftp](https://user-images.githubusercontent.com/48273803/70658853-305e7d80-1ca2-11ea-9774-7f17367faae5.PNG)

**3. 주의사항**

ftp Server에서 다운받은 이미지를 핸드폰 저장소에 저장하기 때문에 권한설정이 필요하다.

![Storage](https://user-images.githubusercontent.com/48273803/70660120-c693a300-1ca4-11ea-86ea-1e27ae95eadb.PNG)

# **Android App과 Raspberry Pi UDP 소켓 연결**
## 1. UDP 통신

![UDP](https://user-images.githubusercontent.com/48273803/70656267-1c644d00-1c9d-11ea-97d0-bb9391a046b7.jpg)

UDP통신은 User Datagram Protocol의 축약어로 TCP 통신과 다르게 비연결형 서비스이며 클라이언트에서 일방적으로 데이터를 전달하고 데이터가 전달 되었는지 확인할 수 없기에 비 신뢰성 연결이다. 간단한 데이터를 전송할 때는 연결형 서비스인 TCP보다 UDP가 효율적이다.

## 2. Android Code Java

UDP Socket통신을 하기 위해서 DatagramSocket과 DatagramPacket 클래스를 사용한다.
InetAddress는 서버의 IP주소를 저장하기 위해 사용한다.
```
import java.net.DatagramPacket;  
import java.net.DatagramSocket;
import java.net.InetAddress;
```
## 3. App Security mode 구현

* 1) SettingActivity.java 
```
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
    }
```

* 2)Deep Learning Pi에 socketServer.py

![stop](https://user-images.githubusercontent.com/48273803/70632947-0f326880-1c73-11ea-89ca-66ef9b232698.PNG)

* 3) Deep Learning Pi에 face_recog.py

![face_recog](https://user-images.githubusercontent.com/48273803/70657828-f9876800-1c9f-11ea-82c4-962bf213495f.PNG)


# **App Stop mode 구현**

* 1) SettingActivity.java 
```
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
```
* 2) Deep Learning Pi에 socketServer.py

![stop](https://user-images.githubusercontent.com/48273803/70632947-0f326880-1c73-11ea-89ca-66ef9b232698.PNG)



# **Raspberry PI USB Camera**

##  1. LiveStream을 가능하게 하는 motion 설치
![그림7](https://user-images.githubusercontent.com/48273803/68989666-4472b300-088d-11ea-938b-5448bcc1b5a8.jpg)
*  1) sudo apt-get install motion -y

##  2. Motion 설정 파일 편집.

* sudo nano /etc/motion/motion.conf<br> 
![그림8](https://user-images.githubusercontent.com/48273803/68989668-450b4980-088d-11ea-8ec1-8b8dd83961b3.jpg)

*  Daemon off -> on으로 변경<br> 
![그림9](https://user-images.githubusercontent.com/48273803/68989671-463c7680-088d-11ea-9340-412210732bc7.jpg)

* target_dir을 motion을 설치한 디렉토리로 절대 경로 지정.<br> 
![그림10](https://user-images.githubusercontent.com/48273803/68989680-5fddbe00-088d-11ea-8b2b-6c9933c77c0b.jpg)

* stream_localhost on -> off 로 변경<br> 
![그림11](https://user-images.githubusercontent.com/48273803/68989682-61a78180-088d-11ea-8143-7f8af0823a3c.jpg) 


## 3. Motion 나중에 실행할 수 있도록 daemon 활성화
* sudo nano /etc/default/motion<br> 
![그림12](https://user-images.githubusercontent.com/48273803/68989684-62401800-088d-11ea-81db-79bc78db395f.jpg)
* Start_motion_daemon=no ->yes으로 변경.<br> 
![그림13](https://user-images.githubusercontent.com/48273803/68989693-8e5b9900-088d-11ea-8c64-ed1b964b55be.jpg)
* sudo service motion start -> 서비스 시작.<br> 
![그림14](https://user-images.githubusercontent.com/48273803/68989694-8ef42f80-088d-11ea-9224-9e201db90839.jpg)

## 4. Livestream Web에서 확인
![그림15](https://user-images.githubusercontent.com/48273803/68989723-e09cba00-088d-11ea-8207-1dd4d297b3a4.jpg)
* Raspberry Pi ip 주소:지정 PORT
* EX) 117.16.174.18:8081


## 5. Livestream App 제작
* 1) CCTVActivity.java 
```
 public class CCTVActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv);

        webView = (WebView)findViewById(R.id.webView);

        //웹 뷰 설정
        webView.setPadding(0,0,0,0);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        //접속 Url
        String url ="http://192.168.115.235:8081/";
        webView.loadUrl(url);
    }
}
```


## 6. Web View에러 
![그림18](https://user-images.githubusercontent.com/48273803/68989732-06c25a00-088e-11ea-89bb-212b6ebf637d.jpg)
* 1) 앞에 방식으로 하면 Android OS 9 이하 버전에서는 바로 실행 가능하지만 이상 버전은 WebView에서 일반적인 텍스토로 http:// URL 접근 막힘.
*  2) 해결법
        1>res/xml/network_security_config.xml 추가 -> network_security_config 파일 생성 위에 경로 폴더 없으면 생성 후 접속할 URL의 domain cleartextTrafficPermitted = “true”

## 7. LiveStream 동시 화면 실행 결과
* 1) WEB<br> 
![Ac](https://user-images.githubusercontent.com/48273803/70660652-13c44480-1ca6-11ea-84eb-1cd08926d834.png)
* 2) APP <br> 
![webcctv](https://user-images.githubusercontent.com/48273803/70660651-13c44480-1ca6-11ea-9fa2-4956bcef84e4.png)


# **Raspberry Pi 2대 이용 Python 이용 TCP 소켓 통신.**
[음성인식로 pi 통신 ServoMotor제어](https://youtube.com/watch?v=fiqbaQ16fCE&feature=youtu.be)<br>
## 1. 두 대의 Raspberry Pi에 모두 Socket 설치
![그림1](https://user-images.githubusercontent.com/48273803/68989538-ac27fe80-088b-11ea-9202-352639d00087.jpg)
 * 1) sudo apt-get install socket

## 2. 두 대의 Raspberry Pi에 각각 ifconfig을 이용하여 IP를 확인 하고 
![그림2](https://user-images.githubusercontent.com/48273803/68989606-7d5e5800-088c-11ea-9d43-a301d1ade454.jpg)
* ifconfig 명령 후 IP 확인
* 같은 대역대의 IP를 사용해야한다. 무선일 경우에도 같은 공유기를 사용하면 가능.

## 3. 자연어처리 Raspberry Pi에 role_activate.py 작성
![nlp socket](https://user-images.githubusercontent.com/48273803/70626739-50714b00-1c68-11ea-9151-4c3a49c59fbc.PNG)
* 1) HOST-> 서버 IP.
* 2) PORT -> Server,Client 파일에서 PORT 일치.

## 4. Server Raspberry Pi에 Server.py 작성
![serverpy](https://user-images.githubusercontent.com/48273803/70626984-bfe73a80-1c68-11ea-9f77-8c51863f1c44.PNG)
* 1) HOST-> 서버 IP.
* 2) PORT -> Server,Client 파일에서 PORT 일치.
* 3) data -> Client Pi에서 받은 값.

## 5. 소켓 통신으로 스위치 제어를 위한 servo motor 제어
1) client pi 자연어 처리 기능 구현 python 파일 중 스위치 제어 부분에서 server pi에 '1' 값을 전달한다.  
![image](https://user-images.githubusercontent.com/48273803/70128519-555e5980-16c0-11ea-9166-9579c74267bf.png)  

2) server pi에서 '1'을 전달 받으면 현재 servo motor 상태에 따라 스위치 on/off를 제어한다.

3) 현재 servo motor상태를 저장하기 위해 text파일로 상태를 저장한다.  

![image](https://user-images.githubusercontent.com/48273803/70128523-57c0b380-16c0-11ea-8436-736beab3b212.png)
