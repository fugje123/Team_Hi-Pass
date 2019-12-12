# **Nueral Compute Stick 2**
## 1. Intel Nueral Compute Stick 1 & Intel Nueral Compute Stick 2
![Nueral stick](https://user-images.githubusercontent.com/48273803/69005852-0a77de80-096b-11ea-8ee4-8f464e00c63c.png)
상호간의 코드가 호환 되지 않음으로 예제 참고시 주의
## **2. 환경구축** 
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
## 1. Face Authentication 순서
1) Face Detection
2) Face Posing & Projection
3) Face Encoding
4) Face Recognition
## 2. Face Authentication 필요 패키지 및 원리
 1) 필요 패키지 설치
    * $pip3 install opencv-python <br>![image](https://user-images.githubusercontent.com/48273803/69006387-dfdd5400-0971-11ea-9d1b-9ee591ffb0c2.png)
    * $pip3 install opencv-contrib-python<br>![image](https://user-images.githubusercontent.com/48273803/69006485-aeb15380-0972-11ea-8990-d55beb58a101.png)
    * $pip3 install dlib <br>![image](https://user-images.githubusercontent.com/48273803/69006496-da343e00-0972-11ea-83c9-27c2d51b6970.png)
    * $pip3 install face_recognition<br>![image](https://user-images.githubusercontent.com/48273803/69006510-fe901a80-0972-11ea-9bb5-54ce5b2d594e.png)
    * $pip3 install flask<br>![image](https://user-images.githubusercontent.com/48273803/69006516-2bdcc880-0973-11ea-82fe-84910512d01e.png)
2) Face Authentication 원리
    * 얼굴만 있는 사진으로 얼굴 학습<br>
    ![image](https://user-images.githubusercontent.com/48273803/69006968-b4ab3280-097a-11ea-9b51-7d91384d243a.png)
    * 사진 또는 동영상에서 얼굴 검출<br>![image](https://user-images.githubusercontent.com/48273803/69006985-e58b6780-097a-11ea-80ff-e6a7e5418be0.png)
    * Face LadMark<br>![image](https://user-images.githubusercontent.com/48273803/69006996-22575e80-097b-11ea-93b0-8040228f7853.png)<br>검출된 얼굴에서 68개의 LandMark 생성<br>
    ![image](https://user-images.githubusercontent.com/48273803/69007017-84b05f00-097b-11ea-87a0-6d7c33e5f355.png)


# **Object Detection**
## 1. Object Detection 순서
  1) 인식할 객체Dataset 수집
  2) 알맞은 Framwork 또는 Model 선정
  3) PB 또는 tffile 과 Label 추출
  4) Real Time Object Detection 참고
  5) 예외처리 및 필요한 동작 처리
## 2. Caffe FrameWork란
## 3. Caffe FrameWork to NCS2(Neural Compute Stick2) Conversion

# **Google speech 사용 음성 인식 및 처리**
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
6) 이 샘플코드들 중 우리가 원하는 음성인식 코드는 python-docs-samples/speech/cloud-client/ 경로에 있다.  
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

## 3. NLP 사용을 위한 NLTK 설치  
## 4. NLP에 Google speech 결과 전달 후 문장 토큰화  
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
## 5. 토큰화 된 문장으로 기능 만들기    
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
* ### $ python
  ### >> from gtts import gTTS
  ### >> import os
  ### >> tts = gTTS(text='turnnig on the light ',lang='en')
  ### >> tts.save("controllight.mp3")
  ### >> exit()  
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
### >> import webbrowser
### >> webbrowser.open("https://www.youtube.com")
![youtube](https://user-images.githubusercontent.com/48273803/69007199-01dcd380-097e-11ea-9b97-3bb0187800bc.JPG)
### 2) Webbrowser 닫기
$ python
### >> import os
### >> os.system("pkill chromium")
![pkill](https://user-images.githubusercontent.com/48273803/69007198-01443d00-097e-11ea-8dff-33476f86398d.JPG)




 
Socket cd /home/pi/Hi-Pass/home/pi server.py and /home/pi/Hi-pass/home/pi Client.py 

LiveStream cd /home/pi/Hi-Pass/home/pi sudo service motion start

# **Raspberry Pi 2대 이용 Python 이용 TCP 소켓 통신.**
## 1. 두 대의 Raspberry Pi에 모두 Socket 설치
![그림1](https://user-images.githubusercontent.com/48273803/68989538-ac27fe80-088b-11ea-9202-352639d00087.jpg)
 * 1) sudo apt-get install socket



## 2. 두 대의 Raspberry Pi에 각각 ifconfig을 이용하여 IP를 확인 하고 
같은 대역대의 IP를 사용해야한다. 무선일 경우에도 같은 공유기를 사용하면 가능.
![그림2](https://user-images.githubusercontent.com/48273803/68989606-7d5e5800-088c-11ea-9d43-a301d1ade454.jpg)
* 1) ifconfig 명령 후 IP 확인

## 3. Client Raspberry Pi에 Client.py 작성
![그림3](https://user-images.githubusercontent.com/48273803/68989612-a0890780-088c-11ea-82ba-446ba04736ac.jpg)
* 1) HOST-> 서버 IP.
* 2) PORT -> Server,Client 파일에서 PORT 일치.
* 3) raw_input -> TEST를 위해 input 열고 값을 Server Pi 전송.

## 4. Server Raspberry Pi에 Server.py 작성
![그림4](https://user-images.githubusercontent.com/48273803/68989602-733c5980-088c-11ea-9b96-5d1b372d5dd2.jpg)
![그림5](https://user-images.githubusercontent.com/48273803/68989603-746d8680-088c-11ea-9c44-53628bb00866.jpg)
* 1) HOST-> 서버 IP.
* 2) PORT -> Server,Client 파일에서 PORT 일치.
* 3) data -> TEST를 위해 받은 값을 처리.-> 자연어 처리 값을 가지고 server센서 제어 예정  

## 5. TEST 결과 값 확인 
![그림6](https://user-images.githubusercontent.com/48273803/68989604-75061d00-088c-11ea-986a-e6b2360fc9d1.png)   

## 6. 소켓 통신으로 스위치 제어를 위한 servo motor 제어
1) client pi 자연어 처리 기능 구현 python 파일 중 스위치 제어 부분에서 server pi에 '1' 값을 전달한다.  
![image](https://user-images.githubusercontent.com/48273803/70128519-555e5980-16c0-11ea-9166-9579c74267bf.png)  

2) server pi에서 '1'을 전달 받으면 현재 servo motor 상태에 따라 스위치 on/off를 제어한다.  
![image](https://user-images.githubusercontent.com/48273803/70128523-57c0b380-16c0-11ea-8436-736beab3b212.png)

3) 현재 servo motor상태를 저장하기 위해 text파일로 상태를 저장한다.  


# **Raspberry PI USB Camera**

##  1. LiveStream을 가능하게 하는 motion 설치
![그림7](https://user-images.githubusercontent.com/48273803/68989666-4472b300-088d-11ea-938b-5448bcc1b5a8.jpg)
*  1) sudo apt-get install motion -y

##  2. Motion 설정 파일 편집.

* sudo nano /etc/motion/motion.conf 
![그림8](https://user-images.githubusercontent.com/48273803/68989668-450b4980-088d-11ea-8ec1-8b8dd83961b3.jpg)

*  Daemon off -> on으로 변경
![그림9](https://user-images.githubusercontent.com/48273803/68989671-463c7680-088d-11ea-9340-412210732bc7.jpg)

* target_dir을 motion을 설치한 디렉토리로 절대 경로 지정.
![그림10](https://user-images.githubusercontent.com/48273803/68989680-5fddbe00-088d-11ea-8b2b-6c9933c77c0b.jpg)

* stream_localhost on -> off 로 변경
![그림11](https://user-images.githubusercontent.com/48273803/68989682-61a78180-088d-11ea-8143-7f8af0823a3c.jpg) 


## 3. Motion 나중에 실행할 수 있도록 daemon 활성화
* sudo nano /etc/default/motion
![그림12](https://user-images.githubusercontent.com/48273803/68989684-62401800-088d-11ea-81db-79bc78db395f.jpg)
* Start_motion_daemon=no ->yes으로 변경.
![그림13](https://user-images.githubusercontent.com/48273803/68989693-8e5b9900-088d-11ea-8c64-ed1b964b55be.jpg)
* sudo service motion start -> 서비스 시작.
![그림14](https://user-images.githubusercontent.com/48273803/68989694-8ef42f80-088d-11ea-9224-9e201db90839.jpg)

## 4. Livestream Web에서 확인
![그림15](https://user-images.githubusercontent.com/48273803/68989723-e09cba00-088d-11ea-8207-1dd4d297b3a4.jpg)
* 1) Raspberry Pi ip 주소:지정 PORT
* EX) 117.16.174.18:8081


## 5. Livestream App 제작
* 1) App.xml
![그림16](https://user-images.githubusercontent.com/48273803/68989724-e1cde700-088d-11ea-8450-2f43cc15048f.jpg)
* 2) App.java 
![그림17](https://user-images.githubusercontent.com/48273803/68989725-e2ff1400-088d-11ea-84a1-1e36544702e8.jpg)

## 6. Web View에러 
![그림18](https://user-images.githubusercontent.com/48273803/68989732-06c25a00-088e-11ea-89bb-212b6ebf637d.jpg)
* 1) 앞에 방식으로 하면 Android OS 9 이하 버전에서는 바로 실행 가능하지만 이상 버전은 WebView에서 일반적인 텍스토로 http:// URL 접근 막힘.
*  2) 해결법
        1>res/xml/network_security_config.xml 추가 -> network_security_config 파일 생성 위에 경로 폴더 없으면 생성 후 접속할 URL의 domain cleartextTrafficPermitted = “true”

## 7. LiveStream 동시 화면 실행 결과
* 1) App
![그림19](https://user-images.githubusercontent.com/48273803/68989733-07f38700-088e-11ea-8713-da0c2b7c2ef9.jpg)
* 2) Web 
![그림20](https://user-images.githubusercontent.com/48273803/68989734-0924b400-088e-11ea-8163-4e7f9abe7841.jpg)

# UDP소켓 통신을 통한Android와 Raspberry Pi연결

## 1) UDP 통신

UDP통신은 User Datagram Protocol의 축약어로 TCP 통신과 다르게 비연결형 서비스이며 클라이언트에서 일방적으로 데이터를 전달하고 데이터가 전달 되었는지 확인할 수 없기에 비 신뢰성 연결이다. 간단한 데이터를 전송할 때는 연결형 서비스인 TCP보다 UDP가 효율적이다.
<!--TCP vs UDP Image-->

## 2) Android UDP 통신 코드
UDP Socket통신을 하기 위해서 DatagramSocket과 DatagramPacket 클래스를 사용한다.
InetAddress는 서버의 IP주소를 저장하기 위해 사용한다.

    import java.net.DatagramPacket;  
	import java.net.DatagramSocket;
	import java.net.InetAddress;

다음은 UDP 통신으로 Android(Client)에서 Raspberry Pi(Server)에 DatagramPacket을 보내는 코드이다.  

**1. SecurityMode code**

    new Thread() {  
    public void run() {  
        try {  
            while (sm1_radioButton.isChecked()) {  
				InetAddress serverAddr = InetAddress.getByName(getString(R.string.server_ip)); //서버 도메인 객체 생성  
				DatagramSocket socket = new DatagramSocket();  
                byte[] buf = ("signal").getBytes();    
                DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 5514); 
                socket.send(packet); 
                
접속을 계속 유지시켜야 하기 때문에 thread를 사용하고 서버와 계속적인 연결을 위해 while문을 사용한다. DatagramPacket에 "signal"이라는 값을 담아 serverAddr에 저장된 서버의 IP주소에 보낸다. 

**2. AudioMode code**

    new Thread() {  
    public void run() {  
        try {  
	            {  
				  InetAddress serverAddr = InetAddress.getByName(getString(R.string.server_ip)); 
				  DatagramSocket socket = new DatagramSocket();  
	              byte[] buf = ("Audio On").getBytes();  
			      DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 5514);      
				  socket.send(packet);  
                  socket.close();  
                  Thread.interrupted();  
	            }  
	        } catch (Exception e) {  
            Log.e("UDP", "C: Error", e);  
	        }  
	    }  
	}.start();

SecurityMode와 같이 DatagramPacket에 Server의 IP와 "Audio On"이라는 값을 담아 Server에 보낸다.

다음은 RaspberryPi (Server)측 코드이다.

**3. RaspberryPi(Server) Code**
 
    import socket
    import struct
    import time
	
	port = 5514

	sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
	sock.bind(('',port))
	
	print("server start")

	while True:
		data,info = sock.recvfrom(55555)
		checkWarning=open('/home/pi/workingDir/info.txt','r')
		warningData=f.read()
		if data.decode() == 'Audio On':
			print("Audio")
			continue
		if data.decode() == 'Audio Off':
			print("Audio Off")
			continue
		
		if warningData == '1':
			sock.sendto(data,info)
			print("WARNING")
			checkWarning.close()
			time.sleep(5)
			continue
		if warningData == '0':
			safe = 'safe'.encode()
			sock.sendto(safe, info)
			print("SAFE")
			checkWarning.close()
			time.sleep(5)
			continue

UDP 통신은 비연결형 통신이기 때문에 socket.SOCK_DGRAM의 소켓 타입을 사용한다. 
while True: 를 통해 서버를 지속시키고 data와 info에 각각 클라이언트에서 받은 데이터와 클라이언트의 IP를 저장한다. 클라이언트에서 보낸 데이터가 "Audio On"이면 Audio모드를 실행하고 "Audio Off"이면 Audio모드를 종료한다. 또한 침입자 발생시 "1"의 값을 저장하고 평상시에 "0"의 값을 저장하는 info.txt의 값을 읽어 만약 "1"의 값이 저장되어 있다면 클라이언트에서 받은 data 그대로 클라이언트에 보내고 만약 평상시라면 'safe'의 값을 클라이언트에 보낸다.

 
 다음은 Android (Client)의 SecurityMode 추가 코드이다.   

**4. SecurityMode Code (서버에서 패킷 받는 부분)**

                socket.receive(packet);  
                System.out.println(new String(packet.getData()));  
                if (new String(packet.getData()).equals("signal")) {  
                    Log.d("데이터", "if");  
                    FTP_Connect();  
                    socket.close();  
                    Thread.sleep(3000);  
                } else {  
                    Log.d("데이터", "else");  
                    socket.close();  
                    Thread.sleep(3000);  
                }  
            }  
        } catch (Exception e) {  
            Log.e("UDP", "C: Error", e);  
        }  
    }  
	}.start();
만약 서버에서 받은 패킷의 데이터가 "signal"이라면 FTP_Connect() 를 실행시킨다.(FTP_Connect()는 바로 다음 부분에서 설명하겠다.) 실행시킨후 socket을 닫아주고 Thread traffic을 관리하기 위해 Thread를  3초간 멈춰준다. 

**5. FTP_Connect()**

FTP_Connect는 침입자가 발생했을 때 RaspberryPi의 FTP 서버에 접속하여 사진을 가져오는 코드이다. 

    public void FTP_Connect() {  
    Thread thread2 = new Thread(new Runnable() {  
        @Override  
	  public void run() {  
            try {  
                ftpClient.connect(InetAddress.getByName(getString(R.string.server_ip)), 21);  
                ftpClient.login("pi", "pi1234");  
                System.out.println("connect success"); 
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);  
                ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);  
                ftpClient.enterLocalPassiveMode();  
                ftpClient.changeWorkingDirectory("/home/pi");
                File getFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/photo.png");                
				FileOutputStream outputStream = new FileOutputStream(getFile);    
                ftpClient.retrieveFile("/home/pi/brustar/photo.png", outputStream);  
			    
			    runOnUiThread(new Runnable() {    
				  @Override  
				  public void run() {  
                        File imgFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/photo.png");  
                        if (imgFile.exists()) {  
                            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());  
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();  
                            float scale = (float) (1024 / (float) myBitmap.getWidth());  
                            int image_w = (int) (myBitmap.getWidth() * scale);  
                            int image_h = (int) (myBitmap.getHeight() * scale);  
                            Bitmap resize = Bitmap.createScaledBitmap(myBitmap, image_w, image_h, true);  
                            resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);  
                            byte[] byteArray = stream.toByteArray();  
                            Log.d("radio", "bitmap ready!!");  
                            createNotification(byteArray);  
                        }  
                    }  
                });  
				ftpClient.logout();  
                ftpClient.disconnect();  
	            } catch (Exception e) {  
                Log.d("FTP Error", e.getMessage());  
	            }  
	        }  
	    });  
    thread2.start();  
	}
ftpClient를 통해 RaspberryPi FTP 서버에 connect, login 한다. FTP의 WorkingDirectory를 /home/pi로 변경 하고 스마트폰의 내부저장소에 접근한다.

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />  
	  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
이때 Androidmanifests.xml에 위의 코드를 추가해야 스마트폰 내부저장소에 접근할 수 있다. 그 후 retrieveFile을 사용하여 FileOutputStream에 "/home/pi/brustar/photo.png"의 경로에 있는 사진파일을 저장한다.  저장후 사진파일을 byte 형식으로 변경하여 createNotification()의 인자로 사용한다.

**6. Notification 생성**

API 26 이상에서는 Notification을 사용하기 위해 NotificationChannel을 만들어야한다.

**#Create NotificationChannel**
   
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
**#Create Notification**

    private void createNotification(byte[] byte1) {  
    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)  
            .setSmallIcon(R.drawable.warning)  
            .setContentTitle("Brustar")  
            .setContentText("침입 감지가 발생했습니다")  
            .setAutoCancel(true)  
            .setDefaults(Notification.DEFAULT_ALL);  
  
		    Intent resultIntent = new Intent(getApplicationContext(), WarningActivity.class);  
		    resultIntent.putExtra("image", byte1);  
		    Log.d("radio", "bitmap send!!");  
		    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());  
		    stackBuilder.addParentStack(WarningActivity.class);  
		    stackBuilder.addNextIntent(resultIntent);  
		    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);  
		    builder.setContentIntent(resultPendingIntent);  
		    notificationManager.notify(234, builder.build());  
		    Log.d("notification", "success");  
	}
NotificationCompat.Builder를 통해 기본적인 Notification의 UI를 수정한다.
인자로 받은 byte1을 Intent를 사용하여 WarningActivity로 보낸다.

# Android App Session 구성

## Session Manager
Session을 이용하기 위해 SessionManager.java 을 만든다.

    public SessionManager(Context context){   
	    this.context = context;  
	    sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MOD);  
	    editor = sharedPreferences.edit();  
	}

Session을 구성하기 위해 SharedPreferences를 사용한다. 
SharedPreferences를 수정하기 위해 editor도 선언한다.

**Login Session**

    public void createSession(String id){  
	    editor.putBoolean(LOGIN, true);  
	    editor.putString(ID,id);  
	    editor.apply();   
	}
로그인 시 ID와 로그인 여부를 Session에 저장한다.

**Security Mode Session**

    public void SecurityMode(Boolean check){  
	    if(check==true){  
	        editor.putBoolean(SM_Mode,true);  
	    }  
	    else if (check == false){  
	        editor.putBoolean(SM_Mode,false);  
	    }  
	    editor.apply();  
	}
	  
	public boolean sm_checked(){  
	    return sharedPreferences.getBoolean(SM_Mode,false);  
	}
	
Security Mode의 On/Off 체크 여부를 저장하고 return한다.	

**Audio Mode Session**

    public void AudioMode(Boolean check){  
	    if(check==true){  
	        editor.putBoolean(AM_Mode,true);  
	    }  
	    else if (check == false){  
	        editor.putBoolean(AM_Mode,false);  
	    }  
	    editor.apply();  
	}  
	public boolean am_checked(){  
	    return sharedPreferences.getBoolean(AM_Mode,false);  
	}
Audio Mode의 On/Off 체크 여부를 저장하고 return한다.

**Logout Session**

    public void logout(){  
        editor.clear();  
        editor.commit();  
    }
 로그아웃 버튼 클릭시 모든 세션을 지운다.
 
 # Android App 세부코딩
## 유효성 검사
회원가입시 아이디와 비밀번호에 조건을 추가 하였다.

**ID 조건**

    String input_id = sign_id.getText().toString();  
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
입력된 아이디를 배열에 저장하여 일정 크기(6)가 넘지 않으면 Error Message를 출력하도록 하였다.

**Password 조건**

    String input_pw=sign_pw.getText().toString();  
	char[] pw_array = new char[input_pw.length()];  
	for(int j=0;j<pw_array.length;j++){  
	    pw_array[j]=(input_pw.charAt(j));  
	}  
	int sp=0;  
	int eng=0;  
	int num=0;  
	if (pw_array.length == 0){  
	    sign_pw.setError("비밀번호를 입력하시오");  
	    sign_pw.requestFocus();  
	    return;  
	}  
	else {  
	    if (pw_array.length >= 5 && pw_array.length <= 20) {  
        for (int i = 0; i < pw_array.length; i++) {  
	        if (33 <= (int) pw_array[i] && (int) pw_array[i] <= 47 || 58 <= (int) pw_array[i] && (int) pw_array[i] <= 64 || 91 <= (int) pw_array[i] && (int) pw_array[i] <= 96 || 123 <= (int) pw_array[i] && (int) pw_array[i] <= 126) {  
                sp++;  
            } 
            else if (48 <= (int) pw_array[i] && (int) pw_array[i] <= 57) {  
                num++;  
            } 
            else if ((65 <= (int) pw_array[i] && (int) pw_array[i] <= 90) || (97 <= (int) pw_array[i] && (int) pw_array[i] <= 122)) {  
                eng++;  
            }  
        }  
        if (sp == 0) {  
            sign_pw.setError("특수문자를 입력하시오");  
            sign_pw.requestFocus();  
            return;  
        }  
        if (num == 0) {  
            sign_pw.setError("숫자를 입력하시오");  
            sign_pw.requestFocus();  
            return;  
        }  
        if (eng == 0) {  
            sign_pw.setError("영문자를 입력하시오");  
            sign_pw.requestFocus();  
            return;  
        }  
    }  
	    else {  
	        sign_pw.setError("5~20 size pw please.");  
	        sign_pw.requestFocus();  
	        return;  
	    }  
	}
ASCII 코드를 이용하여 입력된 비밀번호의 영문, 숫자, 특수 문자 수를 각각 eng, num, sp 변수에 저장하고 각각의 기준 수를 충족 시키지 않는다면 Error Message를 출력한다.

**자동로그인**
Auto Login 체크가 활성화 되면 SharedPreferences를 이용하여 자동로그인을 실행한다.

    
	if(auto_check.isChecked()){  
	    edit.putString("id",Id);  
	    edit.putString("password",Pw);  
	    edit.putBoolean("checkbox",true);  
	    edit.commit(); //입력된 아이디와 비밀번호 그리고 체크 여부를 SharedPreferences에 저장  
	}  
	else{ //아니면  
		edit.putString("id","");  
	    edit.putString("password","");  
	    edit.putBoolean("checkbox",false);  
	    edit.commit(); //아이디와 비밀번호값을 ""로 아무것도 안주고 체크박스 여부도 false로  
	}
Auto Login 체크가 활성화 되었을 때 입력된 아이디와 비밀번호 그리고 체크박스의 여부를 SharedPreferences에 저장한다. 

    if(AutoPref.getBoolean("checkbox",false)==true){ //그리고 sharedPreferences의 checkBox 체크가 됬는지 알아보는 boolean 값이 true 즉 체크 되었다면  
	  auto_check.setChecked(true); //checkbox의 체크를 계속 유지  
	  login_id.setText(AutoPref.getString("id","error")); //아이디칸에 아이디 띄우기  
	  login_pw.setText(AutoPref.getString("password","error")); //비밀번호칸에 비밀번호 띄우기  
	  checkLoginDatabase(AutoPref.getString("id",null),AutoPref.getString("password",null)); //로그인 실행  
	}
onCreate()에서 만약 SharedPreferences에 체크박스 여부가 true일 경우 로그인을 실행한다.
